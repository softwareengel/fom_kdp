package de.fom.kdp.project.lib.osmapi;

import org.junit.Test;

/**
 * Test class for {@link OpenStreetMapExample}.
 * 
 * This class contains a simple test case for the `main` method of the
 * `OpenStreetMapExample` class. The test verifies that the method can be
 * executed without throwing any exceptions.
 * 
 * @author engels
 *
 */
public class OpenStreetMapExampleTest {
	/**
	 * Tests the `main` method of the `OpenStreetMapExample` class.
	 * 
	 * This test invokes the `main` method with a `null` argument to simulate the
	 * execution of the application. The test ensures that the method executes
	 * correctly and does not throw any exceptions.
	 */
	@Test
	public void testMain() {
		OpenStreetMapExample.main(null);
	}

}
