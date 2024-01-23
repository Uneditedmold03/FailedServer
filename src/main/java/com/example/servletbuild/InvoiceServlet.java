package com.example.servletbuild;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.*;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
//import com.mysql.cj.xdevapi.Statement;


@WebServlet(name = "invoiceservlet", value = "/invoice-servlet")
public class InvoiceServlet extends HttpServlet {
    Connection connection = DataConnection.getConnection();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM payments");

            while (rs.next()) {
                String title = rs.getString("title");
                String datestr = rs.getString("date");
                String description = rs.getString("description");
                String category = rs.getString("category");
                String price = rs.getString("price");

                out.println("Title: " + title);
                out.println("Date: " + datestr);
                out.println("Description: " + description);
                out.println("Category: " + category);
                out.println("Price: " + price);
                out.println("-------------------");
            }

            //RequestDispatcher dispatcher = request.getRequestDispatcher("/Invoice.jsp");
            //dispatcher.forward(request, response);
            //kan ej få detta att fungera vill kunna visa det som finns i servern när man väljer att gå till "Invoicepage.jsp"
            //får: java: exception jakarta.servlet.ServletException is never thrown in body of corresponding try statement

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




}