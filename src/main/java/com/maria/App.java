package com.maria;

import java.io.IOException;

import static com.maria.DatabaseInitService.initDb;
import static com.maria.DatabasePopulateService.populateDb;
import static com.maria.DatabaseQueryService.*;


public class App {
    public static void main(String[] args) throws IOException {
        Database db = Database.getInstance();

        initDb(db);
        populateDb(db);

        findMaxSalaryWorker(db);
        findMaxProjectsClient(db);
        findLongestProject(db);
        findYoungestEldestWorkers(db);
        printProjectPrices(db);

        db.connectionClose();
    }
}