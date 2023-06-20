package de.fom.kdp.project.lib.peoplegeneratorDemoProjekt;

import de.fom.kdp.project.lib.stdin.ConsoleReader;

public class DataAnalytics {

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
