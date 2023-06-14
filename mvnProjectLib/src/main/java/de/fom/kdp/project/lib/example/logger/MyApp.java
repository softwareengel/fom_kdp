package de.fom.kdp.project.lib.example.logger;

import java.io.IOException;

public class MyApp {
    public static void main(String[] args) throws IOException {
        LoggerHelper.setupLogger();

        LoggerHelper.logInfo("This is an informational message.");
        LoggerHelper.logWarning("This is a warning message.");
        LoggerHelper.logError("This is an error message.", new RuntimeException("Something went wrong."));
    }
}