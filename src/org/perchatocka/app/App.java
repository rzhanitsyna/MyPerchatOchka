package org.perchatocka.app;

import org.perchatocka.app.ui.MaterialTableForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        new MaterialTableForm();
    }

    public static Connection getConnecrion() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demotest6", "root", "1234");
    }
}
