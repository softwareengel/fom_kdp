package de.fom.kdp.project.lib.peoplegeneratorDemoProjekt;

import de.fom.kdp.project.lib.stdin.ConsoleReader;

/**
 * The {@code DataAnalytics} class provides a simple demonstration of data
 * analysis using generated people data. The class reads a specified number of
 * data records, processes the data, generates statistics, and produces a
 * report.
 *
 * <p>
 * This class interacts with the user to determine how many records to process,
 * fetches the data, and then performs basic data analysis and reporting.
 * </p>
 *
 * <p>
 * <strong>Note:</strong> This class is marked as {@link Deprecated} and may be
 * removed or replaced in future versions.
 * </p>
 * 
 * @author engels
 * @deprecated This class is deprecated and may be removed or replaced in future
 *             versions.
 */
@Deprecated
public class DataAnalytics {
	/**
	 * The entry point of the application. This method prompts the user to input the
	 * number of data records to process, reads the data, prepares it for analysis,
	 * generates statistics, and produces a report based on the data.
	 *
	 * <p>
	 * Steps performed by this method:
	 * </p>
	 * <ul>
	 * <li>Prompts the user to enter the number of data records to generate.</li>
	 * <li>Creates a {@code DataSet} object to fetch and store the data.</li>
	 * <li>Reads the data from the {@code DataSet}.</li>
	 * <li>Prepares the data for analysis (though the actual preparation method is
	 * not implemented).</li>
	 * <li>Generates statistics from the data using the {@code PeopleStats}
	 * class.</li>
	 * <li>Creates a {@code Report} object to print the statistics.</li>
	 * </ul>
	 *
	 * @param args command-line arguments (not used in this example).
	 */
	public static void main(String[] args) {

		// Eingabe Anzahl Datensätze
		System.out.println("Anzahl Datansätze? ");
		int anz = ConsoleReader.readInt();
		DataSet ds = new DataSet(anz);

		String json = ds.readData();
		ds.prepareData();
		PeopleStats ps = ds.makeStats();
		Report r = new Report(ds);

	}

}
