package de.fom.kdp.project.lib.example.hashset;

import org.junit.Test;
/**
 * Test class for {@link HashSetExample}.
 * <p>
 * This class contains a test method to verify that the main method of the 
 * {@link HashSetExample} class executes without any exceptions.
 * </p>
 */
public class HashSetExampleTest {
    /**
     * Tests the {@link HashSetExample#main(String[])} method.
     * <p>
     * This method invokes the main method of {@link HashSetExample} with a 
     * null argument and verifies that no exceptions are thrown during its execution.
     * </p>
     */
	@Test
	public void test() {
		HashSetExample.main(null);
	}

}
