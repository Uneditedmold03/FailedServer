package com.example.servletbuild;

import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;




@WebServlet(name = "homepageservlet", value = "/.homepage-servlet")
public class HomepageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Sätt eventuellt attribut som ska användas i JSP
        request.setAttribute("message", "Hej från Servlet!");


        RequestDispatcher dispatcher = request.getRequestDispatcher("/Homepage.jsp");
        dispatcher.forward(request, response);

    }

}