package by.epam.lapenok.model.pool;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionCreator {
    private static Logger logger = LogManager.getLogger();

    private static final Properties properties = new Properties();
    private static final String FILE = "database/database.properties";
    private static final String DATABASE_URL = "database.url";
    private static final String DATABASE_DRIVER = "database.driver";
    private static final String DATABASE_USER = "database.user";
    private static final String DATABASE_PASSWORD = "database.password";
    private static final String URL;
    private static final String DRIVER;
    private static final String USER;
    private static final String PASSWORD;

    static {
        try (InputStream inputStream = ConnectionCreator.class.getClassLoader()
                .getResourceAsStream(FILE)) {
            properties.load(inputStream);
            URL = properties.getProperty(DATABASE_URL);
            PASSWORD = properties.getProperty(DATABASE_PASSWORD);
            USER = properties.getProperty(DATABASE_USER);
            DRIVER = properties.getProperty(DATABASE_DRIVER);
            Class.forName(DRIVER);

        } catch (FileNotFoundException e) {
            logger.fatal("File not found");
            throw new RuntimeException();
        } catch (IOException ex) {
            logger.fatal("IOException ");
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            logger.fatal("driver: " + properties.getProperty(DATABASE_DRIVER) + " not found");
            throw new RuntimeException();
        }
    }

    private ConnectionCreator() {
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
