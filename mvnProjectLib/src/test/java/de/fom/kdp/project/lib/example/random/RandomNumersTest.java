package de.fom.kdp.project.lib.example.random;

import org.junit.Test;

/**
 * Test class for {@link RandomNumers}.
 * <p>
 * This class contains a test method to verify that the main method of the
 * {@link RandomNumers} class executes without any exceptions.
 * </p>
 * 
 * @author engels
 *
 */
public class RandomNumersTest {
	/**
	 * Tests the {@link RandomNumers#main(String[])} method.
	 * <p>
	 * This method invokes the main method of {@link RandomNumers} with a null
	 * argument and verifies that no exceptions are thrown during its execution.
	 * </p>
	 */
	@Test
	public void testMain() {
		RandomNumers.main(null);
	}

}
