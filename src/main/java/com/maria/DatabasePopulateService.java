package com.maria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static void populateDb(Database db) throws IOException {
        String populateDbFilename = new Prefs().getString(Prefs.POPULATE_DB_SQL_PATH);
        String sql = String.join("\n", Files.readAllLines(Paths.get(populateDbFilename)));
        Database.executeUpdate(sql);
    }
}
