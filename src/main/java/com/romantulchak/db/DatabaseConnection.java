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

    private DatabaseConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            initializeProperties();
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static DatabaseConnection getInstance(){
        if(databaseConnection == null){
            databaseConnection = new DatabaseConnection();
        }else {
            try {
                if(databaseConnection.getConnection().isClosed()){
                    databaseConnection = new DatabaseConnection();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return databaseConnection;
    }

    private void initializeProperties(){
        String filename = "E:\\Applications\\LinqForJava\\src\\main\\resources\\config.properties";
        try(InputStream inputStream = new FileInputStream(filename)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("database.url");
            username = properties.getProperty("database.username");
            password = properties.getProperty("database.password");
        }catch (IOException e){
            throw new CannotReadFileException(filename);
        }
    }

}
