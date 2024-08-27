package de.fom.kdp.project.lib.nominatimapi;

import org.junit.Test;

/**
 * Test class for {@link RailwayStationSearchInCity}.
 * <p>
 * This class contains a test method to verify that the main method of the
 * {@link RailwayStationSearchInCity} class executes without any exceptions.
 * </p>
 * 
 * @author engels
 *
 */
public class RailwayStationSearchInCityTest {
	/**
	 * Tests the {@link RailwayStationSearchInCity#main(String[])} method.
	 * <p>
	 * This method invokes the main method of {@link RailwayStationSearchInCity}
	 * with a null argument and verifies that no exceptions are thrown during its
	 * execution. This is a basic test to ensure that the main method can be
	 * executed without any issues.
	 * </p>
	 */
	@Test
	public void testMain() {
		RailwayStationSearchInCity.main(null);
	}

}
