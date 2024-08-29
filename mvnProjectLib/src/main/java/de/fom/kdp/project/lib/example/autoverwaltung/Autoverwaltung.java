package de.fom.kdp.project.lib.example.autoverwaltung;
import java.util.ArrayList;
import java.util.List;

public class Autoverwaltung {
    private List<Auto> autos;

    // Konstruktor
    public Autoverwaltung() {
        this.autos = new ArrayList<>();
    }

    // Methode zum Hinzufügen eines Autos
    public void autoHinzufuegen(String hersteller, String typenbezeichnung, int baujahr) {
        Auto neuesAuto = new Auto(hersteller, typenbezeichnung, baujahr);
        autos.add(neuesAuto);
    }

    // Methode zum Abrufen der Liste der Autos
    public List<Auto> getAutos() {
        return autos;
    }

    // Methode zum Anzeigen aller Autos
    public void zeigeAlleAutos() {
        for (Auto auto : autos) {
            System.out.println(auto);
        }
    }

    public static void main(String[] args) {
        // Beispiel zur Nutzung
        Autoverwaltung verwaltung = new Autoverwaltung();
        verwaltung.autoHinzufuegen("BMW", "X5", 2020);
        verwaltung.autoHinzufuegen("Audi", "A4", 2018);
        verwaltung.zeigeAlleAutos();
    }
}
