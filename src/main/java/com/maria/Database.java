package com.maria;

import java.io.IOException;
import java.sql.*;

public class Database {
    private static Connection con;
    private static final Database INSTANCE = new Database();

    public static Database getInstance(){
        return INSTANCE;
    }

    private  Database() {
        try {
            String conUrl = new Prefs().getString(Prefs.DB_URL);
            con = DriverManager.getConnection(conUrl);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeUpdate(String sql) {
        try (Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void connectionClose() {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
