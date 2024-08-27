package de.fom.kdp.project.lib.alphavantage;

import org.junit.Test;

/**
 * Unit test class for the {@link AlphaVantageClient} class.
 * <p>
 * This class contains a test method to ensure that the main method of the
 * {@link AlphaVantageClient} class runs without throwing any exceptions.
 * </p>
 */
public class AlphaVantageClientTest {
	/**
	 * Tests the {@link AlphaVantageClient#main(String[])} method.
	 * <p>
	 * This test executes the main method of {@link AlphaVantageClient} with a null
	 * argument, simulating the typical usage scenario where no command-line
	 * arguments are provided. The test passes if no exceptions are thrown during
	 * execution.
	 * </p>
	 */
	@Test
	public void testMain() {
		AlphaVantageClient.main(null);
	}

}
