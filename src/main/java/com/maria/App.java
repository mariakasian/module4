package com.maria;

import java.io.IOException;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        Database db = Database.getInstance();
        new DatabaseInitService().initDb(db);
    }
}