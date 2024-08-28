package de.fom.kdp.ProjektX;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit tests for the {@link A} class.
 * 
 * <p>
 * This class contains test methods to verify the functionality of the {@code A}
 * class, including its constructor, getter, and setter methods.
 * </p>
 * 
 * <p>
 * The tests are implemented using JUnit 4.
 * </p>
 * 
 * <p>
 * Example usage:
 * 
 * <pre>
 * Atest test = new Atest();
 * test.testA_1();
 * test.testA_main();
 * </pre>
 * </p>
 * 
 * @author engels
 * @version 1.0
 */
public class Atest {

	/**
	 * Tests the constructor, getter, and setter methods of the {@link A} class.
	 * 
	 * <p>
	 * This test verifies that the integer value is correctly set and retrieved, and
	 * that the reference to the next {@code A} instance is properly assigned and
	 * not null.
	 * </p>
	 */
	@Test
	public void testA_1() {

		A a = new A();
		a.setI(1);
		a.setNextA(new A());
		assertEquals(1, a.getI());
		assertNotNull(a.getNextA());
	}

	/**
	 * Tests the {@code main} method of the {@link A} class.
	 * 
	 * <p>
	 * This test ensures that the {@code main} method runs without any exceptions.
	 * </p>
	 */
	@Test
	public void testA_main() {
		A.main(null);
	}

}
