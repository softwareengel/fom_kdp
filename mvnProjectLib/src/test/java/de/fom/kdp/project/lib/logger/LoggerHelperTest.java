package de.fom.kdp.project.lib.logger;

import java.io.IOException;

import org.junit.Test;

/**
/**
 * Test class for {@link LoggerHelper}.
 * <p>
 * This class demonstrates the usage of the {@link LoggerHelper} class by setting up the logger and logging 
 * various types of messages, such as informational, warning, and error messages. It also handles any 
 * {@link IOException} that might occur during the logger setup.
 * </p>
 * 
 * <p>
 * The test verifies that the logging methods in {@link LoggerHelper} execute without throwing exceptions.
 * </p>
 * 
 * @see LoggerHelper
 * 
 * @author engels
 */

public class LoggerHelperTest {
    /**
     * Tests the logging functionality of the {@link LoggerHelper} class.
     * <p>
     * This method sets up the logger using {@link LoggerHelper#setupLogger()}, 
     * and then logs example informational, warning, and error messages.
     * It catches and prints any {@link IOException} that might be thrown during the setup process.
     * </p>
     */
	@Test
	public void testLogger() {

		try {
			LoggerHelper.setupLogger();

			LoggerHelper.logInfo("Logging an informational message");
			LoggerHelper.logWarning("Logging a warning message");
			LoggerHelper.logError("Loggin Error"); // without throwing Exception

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
