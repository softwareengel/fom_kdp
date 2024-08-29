package de.fom.kdp.skript.kap4;
public class Aufg_04_05 {

    public static void main(String[] args) {

        int sekunden = 0, minuten = 0, stunden = 0, tage = 0;
        tage = Tools.intEingabe(); // Annahme: Tage werden eingegeben

        // Berechnungen mit arithmetischen Operatoren
        stunden = tage * 24; // 1 Tag hat 24 Stunden
        minuten = stunden * 60; // 1 Stunde hat 60 Minuten
        sekunden = minuten * 60; // 1 Minute hat 60 Sekunden

        // Ausgabe des Ergebnisses
        System.out.println("Das sind");
        System.out.println(stunden + " Stunden oder");
        System.out.println(minuten + " Minuten oder");
        System.out.println(sekunden + " Sekunden");
    }
}
