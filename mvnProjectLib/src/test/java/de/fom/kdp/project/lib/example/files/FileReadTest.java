package de.fom.kdp.project.lib.example.files;

import org.junit.Test;
/**
 * Test class for {@link FileRead}.
 * <p>
 * This class contains a test method to verify that the main method of the 
 * {@link FileRead} class executes without any exceptions.
 * </p>
 */
public class FileReadTest {
    /**
     * Tests the {@link FileRead#main(String[])} method.
     * <p>
     * This method invokes the main method of {@link FileRead} with a 
     * null argument and verifies that no exceptions are thrown during its execution.
     * </p>
     */
	@Test
	public void test() {
		FileRead.main(null);
	}

}
