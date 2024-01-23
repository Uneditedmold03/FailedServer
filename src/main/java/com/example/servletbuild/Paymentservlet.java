package com.example.servletbuild;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


@WebServlet(name = "paymentservlet", value = "/payment-servlet")

public class Paymentservlet extends HttpServlet {
    String sql = "INSERT INTO payments (title, date, description, category, price) VALUES (?, ?, ?, ?, ?)";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = DataConnection.getConnection();

            String title = request.getParameter("title");
            String dateStr = request.getParameter("date");
            String description = request.getParameter("description");
            String category = request.getParameter("category");
            //String price = request.getParameter("price");
            String priceStr = request.getParameter("price");
            BigDecimal price = new BigDecimal(priceStr);
            java.sql.Date date = java.sql.Date.valueOf(dateStr);

            String sql = "INSERT INTO payments (title, date, description, category, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setDate(2, date);
            statement.setString(3, description);
            statement.setString(4, category);
            statement.setBigDecimal(5, price);
            //statement.setString(5, price);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
