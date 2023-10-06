package com.maria;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Database db = Database.getInstance();

        new DatabaseInitService().initDb(db);
        DatabasePopulateService.populateDb(db);

        new DatabaseQueryService().findMaxSalaryWorker(db);
        new DatabaseQueryService().findMaxProjectsClient(db);
        new DatabaseQueryService().findLongestProject(db);
        new DatabaseQueryService().findYoungestEldestWorkers(db);
        new DatabaseQueryService().printProjectPrices(db);

        db.connectionClose();
    }
}