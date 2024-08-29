package de.fom.kdp.project.lib.example.autoverwaltung;
public class Auto {
    private String hersteller;
    private String typenbezeichnung;
    private int baujahr;

    // Konstruktor
    public Auto(String hersteller, String typenbezeichnung, int baujahr) {
        this.hersteller = hersteller;
        this.typenbezeichnung = typenbezeichnung;
        this.baujahr = baujahr;
    }

    // Getter und Setter
    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getTypenbezeichnung() {
        return typenbezeichnung;
    }

    public void setTypenbezeichnung(String typenbezeichnung) {
        this.typenbezeichnung = typenbezeichnung;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "Hersteller='" + hersteller + '\'' +
                ", Typenbezeichnung='" + typenbezeichnung + '\'' +
                ", Baujahr=" + baujahr +
                '}';
    }
}
