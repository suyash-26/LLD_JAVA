package org.example.commentSectionWithSql.db;

import org.example.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        String url = AppConfig.get("commentSectionWithSql.db.url");
        String user = AppConfig.get("commentSectionWithSql.db.user");
        String password = AppConfig.get("commentSectionWithSql.db.password");

        return DriverManager.getConnection(url, user, password);
    }
}