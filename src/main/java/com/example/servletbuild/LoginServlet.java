package com.example.servletbuild;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    //String username = request.getParameter("username");
    //String password = request.getParameter("password");

    private Map<String, String> users = new HashMap<>();

    // När man väljer att logga in på sidan så ska man komma hit
    // Den ska kolla om användarnamet och lösenordet stämmer överens med någon av de 4 anställdas konton som redan finns till servern

    public void init() {
        Serverconnection serverConnection = new Serverconnection(); //
        Connection connection = serverConnection.connect();

        users.put("Admin", "1234");
        users.put("Användare 2", "12345");
        users.put("Användare 3", "123456");
        users.put("Användare 4", "1234567");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String storedPassword = users.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("</body></html>");

           // RequestDispatcher dispatcher = request.getRequestDispatcher("Invoicepage.jsp");
           // dispatcher.forward(request, response); // Används för testning

            RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
            dispatcher.forward(request, response);

        }

        else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Denied Access!</h1>");
            out.println("</body></html>");
        }

    }

}