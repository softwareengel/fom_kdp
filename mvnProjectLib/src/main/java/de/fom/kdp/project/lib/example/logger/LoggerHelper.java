package de.fom.kdp.project.lib.example.logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;


/**
 * The LoggerHelper class provides utility methods to set up a logger with custom configuration and log messages.
 * It supports logging to the console and a file with a one-line log format.
 */
public class LoggerHelper {

    private static final Logger logger = Logger.getLogger(LoggerHelper.class.getName());

    /**
     * Sets up the logger with the desired configuration.
     * It sets the logger level to INFO, removes existing handlers, creates a console handler,
     * and adds a file handler with a custom formatter for one-line log output.
     *
     * @throws IOException if there is an error setting up the file handler.
     */
    public static void setupLogger() throws IOException {
        // Set the logger level
        logger.setLevel(Level.INFO);

        // Remove existing handlers from the logger
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers) {
            logger.removeHandler(handler);
        }

        // Create a console handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);

        // Create a file handler with a custom formatter for one-line output
        String logFileName = "application.log";
        FileHandler fileHandler = new FileHandler(logFileName, true);
        fileHandler.setLevel(Level.INFO);
        fileHandler.setFormatter(new OneLineFormatter());

        // Add the handlers to the logger
        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
    }

    /**
     * Logs an informational message.
     *
     * @param message the message to be logged
     */
    public static void logInfo(String message) {
        logger.info(message);
    }

    /**
     * Logs a warning message.
     *
     * @param message the message to be logged
     */
    public static void logWarning(String message) {
        logger.warning(message);
    }

    /**
     * Logs an error message with an associated throwable.
     *
     * @param message   the message to be logged
     * @param throwable the throwable associated with the error
     */
    public static void logError(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }

    /**
     * Custom formatter class for one-line log output.
     * Formats log records with an ISO timestamp, log level, and log message.
     */
    static class OneLineFormatter extends Formatter {
        private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        private SimpleDateFormat dateFormat;

        public OneLineFormatter() {
            dateFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
        }

        @Override
        public String format(LogRecord record) {
            StringBuilder sb = new StringBuilder();
            sb.append(getTimestamp());
            sb.append(" ");
            sb.append(record.getLevel().getName());
            sb.append(": ");
            // Uncomment the following lines to include class and method names
            // sb.append(record.getSourceClassName());
            // sb.append(".");
            // sb.append(record.getSourceMethodName());
            // sb.append(": ");
            sb.append(formatMessage(record));
            sb.append(System.lineSeparator());
            return sb.toString();
        }

        private String getTimestamp() {
            Date now = new Date();
            return dateFormat.format(now);
        }
    }

    /**
     * The main method demonstrates the usage of the LoggerHelper class.
     * It sets up the logger, logs some example messages, and catches any IOException that may occur.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            setupLogger();

            logInfo("Logging an informational message");
            logWarning("Logging a warning message");
            logError("Logging an error message", new RuntimeException("Sample exception"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

