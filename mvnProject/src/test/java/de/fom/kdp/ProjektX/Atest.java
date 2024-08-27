package de.fom.kdp.ProjektX;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Test of A
 * 
 *
 */
public class Atest {

	/**
	 * Test C'tor, getter, setter
	 */
	@Test
	public void testA_1() {

		A a = new A();
		a.setI(1);
		a.setNextA(new A());
		assertEquals(1, a.getI());
		assertNotNull(a.getNextA());
	}

	@Test
	public void testA_main() {
		A.main(null);
	}

}
