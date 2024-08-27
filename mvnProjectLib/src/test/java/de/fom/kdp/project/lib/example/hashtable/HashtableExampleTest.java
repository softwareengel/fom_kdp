package de.fom.kdp.project.lib.example.hashtable;

import org.junit.Test;

/**
 * Test class for {@link HashTableExample}.
 * <p>
 * This class contains a test method to verify that the main method of the
 * {@link HashTableExample} class executes without any exceptions.
 * </p>
 */
public class HashtableExampleTest {
	/**
	 * Tests the {@link HashTableExample#main(String[])} method.
	 * <p>
	 * This method invokes the main method of {@link HashTableExample} with a null
	 * argument and verifies that no exceptions are thrown during its execution.
	 * </p>
	 */
	@Test
	public void test() {
		HashTableExample.main(null);
	}

}
