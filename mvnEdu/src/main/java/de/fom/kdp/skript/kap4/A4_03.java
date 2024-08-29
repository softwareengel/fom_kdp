package de.fom.kdp.skript.kap4;

import java.util.Scanner;

public class A4_03 {
    public static void main(String[] args) {

        // Scanner-Objekt erstellen, um Eingaben vom Benutzer zu lesen
        Scanner scanner = new Scanner(System.in);

        // Den Benutzer nach dem Radius des Kreises fragen
        System.out.print("Geben Sie den Radius des Kreises ein: ");
        double radius = scanner.nextDouble();

        // Berechnung des Flächeninhalts des Kreises
        double flaeche = Math.PI * radius * radius;

        // Ausgabe des Ergebnisses
        System.out.printf("Der Flächeninhalt des Kreises beträgt: %.2f%n", flaeche);

        // Scanner schließen
        scanner.close();

    }
}
