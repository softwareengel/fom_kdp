package de.fom.kdp.project.lib.peoplegeneratorDemoProjekt;

/**
 * The {@code Report} class is responsible for generating and printing a report
 * based on the statistics of a {@code DataSet}. Upon instantiation, it
 * immediately prints the statistics contained within the provided
 * {@code DataSet}.
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
public class Report {
	/**
	 * Constructs a {@code Report} object and prints the statistics from the
	 * provided {@code DataSet}.
	 * 
	 * @param ds the {@code DataSet} object containing the statistics to be printed.
	 */
	public Report(DataSet ds) {
		ds.peopleStats.printStat();
	}

}
