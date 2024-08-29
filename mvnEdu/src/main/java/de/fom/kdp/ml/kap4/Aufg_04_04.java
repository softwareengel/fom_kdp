package de.fom.kdp.ml.kap4;

public class Aufg_04_04 {

	public static void main(String[] args) {

		int sekunden = 0, minuten = 0, stunden = 0, tage = 0;
		sekunden = Tools.intEingabe();

		// Berechnungen mit arithmetischen Operatoren
		tage = sekunden / (24 * 3600); // Umrechnung von Sekunden in Tage
		sekunden %= (24 * 3600); // Restsekunden nach Abzug der vollen Tage

		stunden = sekunden / 3600; // Umrechnung von verbleibenden Sekunden in Stunden
		sekunden %= 3600; // Restsekunden nach Abzug der vollen Stunden

		minuten = sekunden / 60; // Umrechnung von verbleibenden Sekunden in Minuten
		sekunden %= 60; // Restsekunden nach Abzug der vollen Minuten

		// Ausgabe des Ergebnisses
		System.out.println("Das sind");
		System.out.println(tage + " Tage und");
		System.out.println(stunden + " Stunden und");
		System.out.println(minuten + " Minuten und");
		System.out.println(sekunden + " Sekunden");
	}
}
