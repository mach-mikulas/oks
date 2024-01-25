package oks05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OsobniCisloTest_PozitivniPolotovar {

    OsobniCislo oc;

    @BeforeEach
    void setUp() {

        oc = new OsobniCislo("Novák, Josef, fav, 2014, b, p");

    }

    @Test
    void compareTo_1() {

        OsobniCislo test = new OsobniCislo("Mach, Josef, fav, 2014, b, p");
        assertEquals(1,oc.compareTo(test));
    }

    @Test
    void isPlatneOsobniCislo() {

        oc.vysledek = "xxxx";
        assertFalse(oc.isPlatneOsobniCislo(), "Osobni číslo není platné");

    }

    @Test
    void compareTo_2() {

        OsobniCislo test = new OsobniCislo("Zeman, Josef, fav, 2014, b, p");
        assertEquals(-1,oc.compareTo(test));
    }

    @Test
    void compareTo_3() {

        OsobniCislo test = new OsobniCislo("Novák, Josef, fav, 2014, b, p");
        assertEquals(0,oc.compareTo(test));
    }

    @Test
    void testToString() {
        assertEquals("A14BxxxxP <= NOVÁK Josef", oc.toString());
    }

    @Test
    void getOsobniCislo() {

        assertEquals("A14BxxxxP", oc.getOsobniCislo());

    }

    @Test
    void isPlatnyFormat() {

        assertTrue(oc.isPlatnyFormat(), "Formát není platný");

    }


    @Test
    void getTypStudia() {

        assertEquals(TypStudia.BAKALARSKY, oc.getTypStudia(), "Jiny typ studia");

    }

    @Test
    void getFakulta() {

        assertEquals("A", oc.getFakulta(), "Fakulta se neshoduje");

    }

    @Test
    void naplnAtributy() {
    }

    @Test
    void zpracujPrijmeni() {
        oc.zpracujPrijmeni("Mach");
        assertEquals("Mach", oc.prijmeni);
    }

    @Test
    void zpracujJmeno() {
        oc.zpracujJmeno("mikuláš");
        assertEquals("Mikuláš", oc.jmeno);
    }

    @Test
    void zpracujRokNastupu() {

        oc.zpracujRokNastupu("2014");
        assertEquals("14" ,oc.rokNastupu, "Rok nastupu ma spatny format");
    }

    @Test
    void zpracujFakulta() {
        oc.zpracujFakulta("FAV");
        assertEquals("A",oc.fakulta);
    }

    @Test
    void zpracujTypStudia() {
        oc.zpracujTypStudia("B");
        assertEquals(TypStudia.BAKALARSKY, oc.getTypStudia());

    }

    @Test
    void zpracujFormaStudia() {

        oc.zpracujFormaStudia("P");
        assertEquals("P",oc.formaStudia);
    }

    @Test
    void zpracujNepovinne() {
        oc.zpracujNepovinne("ahoj");
        assertEquals("ahoj",oc.nepovinne);

    }
}