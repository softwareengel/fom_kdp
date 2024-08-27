package de.fom.kdp.project.lib.example.regex;

import org.junit.Test;
/**
 * Test class for {@link RegexExample}.
 * <p>
 * This class contains a test method to verify that the main method of the 
 * {@link RegexExample} class executes without any exceptions.
 * </p>
 * @author engels
 *
 */
public class RegexExampleTest {
    /**
     * Tests the {@link RegexExample#main(String[])} method.
     * <p>
     * This method invokes the main method of {@link RegexExample} with a 
     * null argument and verifies that no exceptions are thrown during its execution.
     * </p>
     */
	@Test
	public void testMain() {
		RegexExample.main(null);
	}

}
