package oks05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OsobniCisloTest_Negativni {

    @Test
    void testToString() {
        OsobniCislo oc = new OsobniCislo("");
        assertEquals("???xxxx? <= ? ? (" + Konstanty.TEXT_CHYBNY_FORMAT + ")", oc.toString());
    }

    @Test
    void isPlatneOsobniCislo() {
        OsobniCislo oc = new OsobniCislo("");
        assertFalse(oc.isPlatneOsobniCislo(), "Osobni číslo není platné");

    }

    @Test
    void zpracujRokNastupu_1() {

        OsobniCislo oc = new OsobniCislo("");
        oc.zpracujRokNastupu("20141213131");
        assertEquals(Konstanty.ZNAK_CHYBY ,oc.rokNastupu, "Rok byl prijate i kdyz ma spatnou delku");
    }

    @Test
    void zpracujRokNastupu_2() {

        OsobniCislo oc = new OsobniCislo("");
        oc.zpracujRokNastupu("AHOJ");
        assertEquals(Konstanty.ZNAK_CHYBY ,oc.rokNastupu, "Rok byl prijate jako cislo i kdyz je string");
    }

    @Test
    void naplAtributy_1() {

        OsobniCislo oc = new OsobniCislo("");
        oc.naplnAtributy("t,t,t,t,t,t,t,,t,t,t,tt,t,tt,t,,t,tt,t,t,t,t,tt,t");
    }

    @Test
    void naplAtributy_2() {

        OsobniCislo oc = new OsobniCislo("");
        oc.naplnAtributy(null);
    }
}
