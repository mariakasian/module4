package com.maria;

import java.io.IOException;
import java.sql.*;

public class Database {
    private static final Database INSTANCE;
    private static Connection con;

    static {
        try {
            INSTANCE = new Database();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance(){
        return INSTANCE;
    }

    private  Database() throws SQLException, IOException {
        String conUrl = new Prefs().getString(Prefs.DB_URL);
        con = DriverManager.getConnection(conUrl);
    }

    public Connection getConnection() {
        return con;
    }

    public static int executeUpdate(String sql) throws SQLException {
        Statement st = con.createStatement();
        return st.executeUpdate(sql);
    }

    public void close() throws SQLException {
        con.close();
    }
}
