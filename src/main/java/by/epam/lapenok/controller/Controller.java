package by.epam.lapenok.controller;

import by.epam.lapenok.model.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

//        String numStr = req.getParameter("number");
//        int num = Integer.parseInt(numStr);
//        num*=2;
//        //logger.debug("hello");
//        req.setAttribute("numResult", num);
//
//        List<User> list = List.of(new User(45, "Alex", "Smirnov", 29),
//                new User(78, "Oleg", "Sukhorukov", 36));
//        req.setAttribute("lst", list);
//
//        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}