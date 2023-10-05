package com.maria;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Database db = Database.getInstance();
        new DatabaseInitService().initDb(db);
        DatabasePopulateService.populateDb(db);
        db.connectionClose();
    }
}