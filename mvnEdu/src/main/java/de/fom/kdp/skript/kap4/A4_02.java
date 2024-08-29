package de.fom.kdp.skript.kap4;

import java.util.Scanner;

public class A4_02 {
    public static void main(String[] args) {
        // Scanner-Objekt erstellen, um Eingaben vom Benutzer zu lesen
        Scanner scanner = new Scanner(System.in);

        // Den Benutzer nach dem gesamten Benzinverbrauch in Litern fragen
        System.out.print("Geben Sie den gesamten Benzinverbrauch in Litern ein: ");
        double liter = scanner.nextDouble();

        // Den Benutzer nach der zurückgelegten Strecke in Kilometern fragen
        System.out.print("Geben Sie die zurückgelegte Strecke in Kilometern ein: ");
        double kilometer = scanner.nextDouble();

        // Berechnung des Benzinverbrauchs pro 100 Kilometer
        double verbrauchPro100km = (liter / kilometer) * 100;

        // Ausgabe des Ergebnisses
        System.out.printf("Der Benzinverbrauch beträgt %.2f Liter pro 100 Kilometer.%n", verbrauchPro100km);

        // Scanner schließen
        scanner.close();
    }
}
