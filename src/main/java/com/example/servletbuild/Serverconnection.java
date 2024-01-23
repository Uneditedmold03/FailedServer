
package com.example.servletbuild;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Serverconnection {
    private String url = "jdbc:mariadb://localhost:3306/company";

    //private String url = "http://localhost/phpmyadmin/index.php?route=/sql&db=company&table=payments&pos=0";

    private String user = "root";
    private String password = "";

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
        } catch (ClassNotFoundException e) {
            System.out.println("Oops! Couldn't find the JDBC driver." + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong.");
            e.printStackTrace(); // Detta kommer att skriva ut mer detaljerad information om undantaget
        }
        return conn;
    }

}


