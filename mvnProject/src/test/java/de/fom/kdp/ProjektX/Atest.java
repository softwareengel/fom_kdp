package de.fom.kdp.ProjektX;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class Atest {

	@Test
	public void test1() {
		A a = new A();
		a.setI(1);
		a.setNextA(new A());
		assertEquals(1, a.getI());
		assertNotNull(a.getNextA());
	}
	
	@Test
	public void test2() {
//		A a = new A();
		A.main(null);
	}

}
