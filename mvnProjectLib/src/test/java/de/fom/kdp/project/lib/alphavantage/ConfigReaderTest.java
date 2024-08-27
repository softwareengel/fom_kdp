package de.fom.kdp.project.lib.alphavantage;

import org.junit.Test;

/**
 * Unit test class for the {@link ConfigReader} class.
 * <p>
 * This class contains a test method to ensure that the main method of the
 * {@link ConfigReader} class runs without throwing any exceptions.
 * </p>
 * 
 * @author engels
 *
 */
public class ConfigReaderTest {
	/**
	 * Tests the {@link ConfigReader#main(String[])} method.
	 * <p>
	 * This test executes the main method of {@link ConfigReader} with a null
	 * argument, simulating the typical usage scenario where no command-line
	 * arguments are provided. The test passes if no exceptions are thrown during
	 * execution.
	 * </p>
	 */
	@Test
	public void testMain() {
		ConfigReader.main(null);
	}

}
