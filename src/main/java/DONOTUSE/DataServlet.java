package DONOTUSE;

import java.io.IOException;

import com.example.servletbuild.Serverconnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(name = "dataservlet", value = "/data-servlet")
public class DataServlet extends HttpServlet {

    Serverconnection serverconnection = new Serverconnection();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Server Database</h1>");
        out.println("</body></html>");




    }
}