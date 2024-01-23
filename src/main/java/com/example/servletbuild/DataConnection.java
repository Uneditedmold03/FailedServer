package com.example.servletbuild;

import java.sql.Connection;

public class DataConnection {
    private static Connection connection;

    private DataConnection() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DataConnection.class) { // Och här
                if (connection == null) {
                    // create your connection here
                    Serverconnection serverConnection = new Serverconnection();
                    connection = serverConnection.connect();
                }
            }
        }
        return connection;
    }
}