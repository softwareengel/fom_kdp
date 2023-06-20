package de.fom.kdp.project.lib.peoplegeneratorDemoProjekt;

import java.io.IOException;

import de.fom.kdp.project.lib.peoplegeneratorapi.Peoplegeneratorapi;

/**
 * Class for holding Data of People
 * 
 * @author engels
 *
 */
public class DataSet {
	int anz = 0;
	String jsondata = null;
	PeopleStats peopleStats;

	public DataSet(int anz) {
		this.anz = anz;
	}

	/**
	 * 
	 * @return
	 */
	public String readData() {
		jsondata = null;
		try {
			jsondata = Peoplegeneratorapi.getPeople(anz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsondata;
	}

	/**
	 * clean up and prepare Data
	 * 
	 */
	public void prepareData() {

	}

	/**
	 * generate PeopleStats
	 * @return
	 */
	public PeopleStats makeStats() {
		
		peopleStats = new PeopleStats(jsondata);
		
		return peopleStats;

	}

}
