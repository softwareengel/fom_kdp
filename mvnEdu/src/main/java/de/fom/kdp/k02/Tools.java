package de.fom.kdp.k02;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tools {

  public static int intEingabe() {
    String eingebs = "";
    InputStreamReader daten = new InputStreamReader(System.in);
    BufferedReader eingeb = new BufferedReader(daten);
    try {
      System.out.println("Ihre Eingabe (int): ");
      eingebs = eingeb.readLine();

    } catch (Exception e) {
      System.out.println(" Falsche Eingabe ");
    }

    int eingebi;
    try {
      eingebi = Integer.valueOf(eingebs).intValue();
      
      // Actually, valueOf uses parseInt internally. The difference is
      // parseInt returns an int primitive while valueOf returns an
      // Integer object. 
      // http://stackoverflow.com/questions/7355024/integer-valueof-vs-integer-parseint 
  
      // eingebi = Integer.parseInt(eingebs);
      
      
    } catch (Exception e) {
      System.out.println("!! Leider keine Zahl eingeben, Wert = 0 !!");
      eingebi = 0;
    }

    return eingebi;
  }

  public static String stringEingabe() {
    String eingebs = "";
    InputStreamReader daten = new InputStreamReader(System.in);
    BufferedReader eingeb = new BufferedReader(daten);
    try {
      System.out.println("Ihre Eingabe (String): ");
      eingebs = eingeb.readLine();

    } catch (Exception e) {
      System.out.println(" Falsche Eingabe ");
    }

    return eingebs;
  }

  public static double doubleEingabe() {
    String eingebs = "";
    InputStreamReader daten = new InputStreamReader(System.in);
    BufferedReader eingeb = new BufferedReader(daten);
    try {
      System.out.println("Ihre Eingabe (double): ");
      eingebs = eingeb.readLine();

    } catch (Exception e) {
      System.out.println(" Falsche Eingabe ");
    }

    double eingebi = 0;
    try {
      eingebi = Double.parseDouble(eingebs);
    } catch (Exception e) {
      System.out.println("Bitte eine Fließkommazahl eingeben (mit Punkt - kein Komma)");
    }
    return eingebi;
  }

  public static boolean booleanEingabe() {

    System.out.print("Bitte 1=true oder 0=false eingeben: ");
    int eingabe = intEingabe();
    if (eingabe == 0) {
      return false;
    } else {
      return true;
    }
  }

}