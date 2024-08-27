package de.fom.kdp.project.lib.example.random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for {@link RandomNumers}.
 * <p>
 * This class contains test methods to verify the functionality of the
 * {@link RandomNumers} class. The tests ensure that the methods in the class
 * generate random numbers within the expected ranges and that the random number
 * generation is consistent when using a specified seed.
 * </p>
 * 
 * @author engels
 */
public class RandomNumersTest {

	/**
	 * Tests the {@link RandomNumers#main(String[])} method.
	 * <p>
	 * This method invokes the main method of {@link RandomNumers} with a null
	 * argument and verifies that no exceptions are thrown during its execution.
	 * This test is primarily to ensure that the method runs successfully and
	 * handles the random number generation without issues.
	 * </p>
	 */
	@Test
	public void testMain() {
		RandomNumers.main(null);
	}

	/**
	 * Tests the {@link RandomNumers#randInt()} method.
	 * <p>
	 * This method verifies that the generated random integer is within the expected
	 * range (0 to 99). It checks that the integer is greater than or equal to 0 and
	 * less than 100.
	 * </p>
	 */
	@Test
	public void testRandInt() {
		int randomInt = RandomNumers.randInt();
		assertTrue("Random integer should be between 0 and 99", randomInt >= 0 && randomInt < 100);
	}

	/**
	 * Tests the {@link RandomNumers#randFloat()} method.
	 * <p>
	 * This method verifies that the generated random float is within the expected
	 * range (0.0 to 1.0). It checks that the float is greater than or equal to 0.0f
	 * and less than 1.0f.
	 * </p>
	 */
	@Test
	public void testRandFloat() {
		float randomFloat = RandomNumers.randFloat();
		assertTrue("Random float should be between 0.0 and 1.0", randomFloat >= 0.0f && randomFloat < 1.0f);
	}

	/**
	 * Tests the {@link RandomNumers#randDouble()} method.
	 * <p>
	 * This method verifies that the generated random double is within the expected
	 * range (0.0 to 1.0). It checks that the double is greater than or equal to 0.0
	 * and less than 1.0.
	 * </p>
	 */
	@Test
	public void testRandDouble() {
		double randomDouble = RandomNumers.randDouble();
		assertTrue("Random double should be between 0.0 and 1.0", randomDouble >= 0.0 && randomDouble < 1.0);

	}

	/**
	 * Tests the {@link RandomNumers#randSeed(long)} method.
	 * <p>
	 * This method verifies that using a specific seed produces a consistent
	 * sequence of random numbers. It sets the seed to a known value (222) and
	 * checks that the subsequent random numbers match the expected values.
	 * </p>
	 */
	@Test
	public void testRandSeedLong() {

		RandomNumers.randSeed(222);

		int randomInt = RandomNumers.randInt();
		// System.out.println("Random Integer: " + randomInt); // 71
		assertEquals(71, randomInt);

		float randomNumber = RandomNumers.randFloat();
		// System.out.println("Random Number: " + randomNumber); // 0.99918574
		assertEquals(0.99918574, randomNumber, 0.0001);
		double randomDouble = RandomNumers.randDouble();
		// System.out.println("Random Double: " + randomDouble); // 0.37242867841906147
		assertEquals(0.37242867841906147, randomDouble, 0.0001);
	}

}
