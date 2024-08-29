package de.fom.kdp.skript.kap5;
import java.util.Scanner;

public class A05_02 {
    public static void main(String[] args) {
        // Scanner-Objekt erstellen, um Eingaben vom Benutzer zu lesen
        Scanner scanner = new Scanner(System.in);
        
        // Den Benutzer nach dem Alter fragen
        System.out.print("Geben Sie das Alter ein: ");
        int alter = scanner.nextInt();
        
        // Alterskategorie basierend auf dem Alter bestimmen
        if (alter < 0) {
            System.out.println("Ungültiges Alter.");
        } else if (alter < 18) {
            System.out.println("Kind/Jugendlicher");
        } else if (alter < 67) {
            System.out.println("Erwachsener");
        } else {
            System.out.println("Rentner");
        }
        
        // Scanner schließen
        scanner.close();
    }
}
