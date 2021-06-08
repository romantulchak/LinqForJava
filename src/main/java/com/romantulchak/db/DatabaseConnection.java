package com.romantulchak.db;

import com.romantulchak.exception.CannotReadFileException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private Connection connection;
    private String url;
    private String username;
    private String password;

    private DatabaseConnection(String pathToPropertiesFile){
        try {
            Class.forName("org.postgresql.Driver");
            initializeProperties(pathToPropertiesFile);
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static DatabaseConnection getInstance(String pathToPropertiesFile){
        if(databaseConnection == null){
            databaseConnection = new DatabaseConnection(pathToPropertiesFile);
        }else {
            try {
                if(databaseConnection.getConnection().isClosed()){
                    databaseConnection = new DatabaseConnection(pathToPropertiesFile);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return databaseConnection;
    }

    private void initializeProperties(String pathToPropertiesFile){
        try(InputStream inputStream = new FileInputStream(pathToPropertiesFile)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("database.url");
            username = properties.getProperty("database.username");
            password = properties.getProperty("database.password");
        }catch (IOException e){
            throw new CannotReadFileException(pathToPropertiesFile);
        }
    }

}
