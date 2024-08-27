package de.fom.kdp.project.lib.example.files;

import java.io.IOException;

import org.junit.Test;

/**
 * Test class for {@link FileWrite}.
 * <p>
 * This class contains a test method to verify that the main method of the
 * {@link FileWrite} class executes without any exceptions.
 * </p>
 */
public class FileWriteTest {
	/**
	 * Tests the {@link FileWrite#main(String[])} method.
	 * <p>
	 * This method invokes the main method of {@link FileWrite} with a null argument
	 * and verifies that no exceptions are thrown during its execution.
	 * </p>
	 */
	@Test
	public void test() {
		FileWrite.main(null);
	}

	/**
	 * Tests the {@link FileWrite#writeFile(String, String)} method for failure when
	 * an invalid file path is provided.
	 * <p>
	 * This test verifies that an {@link IOException} is thrown when attempting to
	 * write to an invalid file path. In this case, the file path `"::"` is not
	 * valid, and the test expects an {@link IOException} to be thrown. The test
	 * passes if the {@link IOException} is correctly thrown, and fails if no
	 * exception is thrown.
	 * </p>
	 * 
	 * @throws IOException if an I/O error occurs during the execution of the
	 *                     {@link FileWrite#writeFile(String, String)} method.
	 */
	@Test(expected = IOException.class)
	public void testFailure() throws IOException {
		FileWrite.writeFile("::", "::"); // filepath "::" not okay
	}
}
