package de.fom.kdp.project.lib.example.arraylist;

import org.junit.Test;

/**
 * Test class for {@link ArrayListExample}.
 * <p>
 * This class contains a test method to verify that the main method of the
 * {@link ArrayListExample} class executes without any exceptions.
 * </p>
 */
public class ArrayListExampleTest {
	/**
	 * Tests the {@link ArrayListExample#main(String[])} method.
	 * <p>
	 * This method invokes the main method of {@link ArrayListExample} with a null
	 * argument and verifies that no exceptions are thrown.
	 * </p>
	 */
	@Test
	public void testMain() {
		ArrayListExample.main(null);
	}

}
