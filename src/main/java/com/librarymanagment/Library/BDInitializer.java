package com.librarymanagment.Library;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class BDInitializer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root"; // your username
        String password = "Mulubrihan2126_"; // your password
        String databaseName = "new_database2";

        // Creating the database
        createDatabase(url, username, password, databaseName);

        // Additional logic can be added here, such as working with the new database
    }

    private static void createDatabase(String url, String username, String password, String databaseName) {
        // Try-with-resources to ensure the connection and statement are closed automatically
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            
            // Execute the SQL query to create the new database
            String createDatabaseSQL = "CREATE DATABASE " + databaseName;
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database '" + databaseName + "' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
