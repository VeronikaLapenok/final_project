package by.epam.lapenok.model.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {

    private static Logger logger = LogManager.getLogger();

    private static final int DEFAULT_POOL_SIZE = 8;
    private static ConnectionPool instance;
    private static Lock lock = new ReentrantLock();
    private static AtomicBoolean isConnectionPoolCreated = new AtomicBoolean(false);
    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenAwayConnections;

    private ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                Connection connection = ConnectionCreator.createConnection();
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                freeConnections.add(proxyConnection);
            } catch (SQLException e) {
                logger.error("Cannot create connection", e);
            }
        }
        if (freeConnections.isEmpty()) {
            logger.fatal("The pool is empty");
            throw new RuntimeException("The pool is empty");
        }
    }

    public static ConnectionPool getInstance() {
        if (!isConnectionPoolCreated.get()) {
            lock.lock();
            if (instance == null) {
                instance = new ConnectionPool();
                isConnectionPoolCreated.set(true);
            }
            lock.unlock();
        }
        return instance;
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread is interrupted", e);
        }
        return connection;
    }



    public void releaseConnection(Connection connection) {
        if (connection instanceof ProxyConnection && givenAwayConnections.remove(connection)) {
            freeConnections.offer((ProxyConnection) connection);
        } else {
            logger.error("Invalid connection" + connection);
        }

    }

    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (SQLException e) {
                logger.error("Connection was not deleted", e);
            } catch (InterruptedException e) {
                logger.error("Thread is interrupted", e);
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Driver was not deregistered", e);
            }
        });
    }
}
