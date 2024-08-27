package de.fom.kdp.project.lib.logger;

import java.io.IOException;

import org.junit.Test;

/**
 * The LoggerHelperTest demonstrates the usage of the LoggerHelper class. It
 * sets up the logger, logs some example messages, and catches any IOException
 * that may occur.
 * 
 * @author engels
 */

public class LoggerHelperTest {
	@Test
	public void testLogger() {

		try {
			LoggerHelper.setupLogger();

			LoggerHelper.logInfo("Logging an informational message");
			LoggerHelper.logWarning("Logging a warning message");
			LoggerHelper.logError("Loggin Error"); // without throwing Exception
			/* error log and throwoing exception 
			try {
				LoggerHelper.logError("Logging an error message", new RuntimeException("Test Sample exception"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
