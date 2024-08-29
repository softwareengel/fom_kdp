package de.fom.kdp.ml.kap5;
import java.util.Scanner;

public class A05_01 {
    public static void main(String[] args) {
        // Scanner-Objekt erstellen, um Eingaben vom Benutzer zu lesen
        Scanner scanner = new Scanner(System.in);
        
        // Den Benutzer nach der ersten Zahl fragen
        System.out.print("Geben Sie die erste Zahl ein: ");
        int zahl1 = scanner.nextInt();
        
        // Den Benutzer nach der zweiten Zahl fragen
        System.out.print("Geben Sie die zweite Zahl ein: ");
        int zahl2 = scanner.nextInt();
        
        // Vergleich der beiden Zahlen
        if (zahl1 < zahl2) {
            System.out.println("Die erste Zahl ist kleiner als die zweite Zahl.");
        } else if (zahl1 > zahl2) {
            System.out.println("Die erste Zahl ist größer als die zweite Zahl.");
        } else {
            System.out.println("Die erste Zahl ist gleich der zweiten Zahl.");
        }
        
        // Scanner schließen
        scanner.close();
    }
}
