package de.fom.kdp.project.lib.example.autoverwaltung;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AutoTest2 {

    private Auto auto;

    @Before
    public void setUp() throws Exception {
        // Initialisiere ein Auto-Objekt für die Tests
        auto = new Auto("BMW", "X5", 2020);
    }

    @Test
    public void testAuto() {
        // Testet den Konstruktor
        assertNotNull("Das Auto-Objekt sollte nicht null sein", auto);
    }

    @Test
    public void testGetHersteller() {
        // Testet die getHersteller-Methode
        assertEquals("BMW", auto.getHersteller());
    }

    @Test
    public void testSetHersteller() {
        // Testet die setHersteller-Methode
        auto.setHersteller("Audi");
        assertEquals("Audi", auto.getHersteller());
    }

    @Test
    public void testGetTypenbezeichnung() {
        // Testet die getTypenbezeichnung-Methode
        assertEquals("X5", auto.getTypenbezeichnung());
    }

    @Test
    public void testSetTypenbezeichnung() {
        // Testet die setTypenbezeichnung-Methode
        auto.setTypenbezeichnung("A6");
        assertEquals("A6", auto.getTypenbezeichnung());
    }

    @Test
    public void testGetBaujahr() {
        // Testet die getBaujahr-Methode
        assertEquals(2020, auto.getBaujahr());
    }

    @Test
    public void testSetBaujahr() {
        // Testet die setBaujahr-Methode
        auto.setBaujahr(2018);
        assertEquals(2018, auto.getBaujahr());
    }

    @Test
    public void testToString() {
        // Testet die toString-Methode
        String expected = "Auto{Hersteller='BMW', Typenbezeichnung='X5', Baujahr=2020}";
        assertEquals(expected, auto.toString());
    }
}
