package com.example.housKeeping.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupConfig implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            try (Connection connection = DriverManager.getConnection(getHostName())) {
                try (Statement statement = connection.createStatement()) {
                    int result = statement.executeUpdate("CREATE DATABASE house");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getHostName() {
        String jdbc_database_url = System.getenv("JDBC_DATABASE_URL");
        String jdbc_database_username = System.getenv("JDBC_DATABASE_USERNAME");
        String jdbc_database_password = System.getenv("JDBC_DATABASE_PASSWORD");
        return jdbc_database_url + "?user=" + jdbc_database_username + "&password=" + jdbc_database_password;
    }
}
