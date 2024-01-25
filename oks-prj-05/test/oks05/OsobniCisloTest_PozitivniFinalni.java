package oks05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OsobniCisloTest_PozitivniFinalni {

    OsobniCislo oc;

    @BeforeEach
    void setUp() {

        oc = new OsobniCislo("Novák, Josef, fav, 2014, b, p");
        oc.generujOsobniCislo("0123");

    }

    @Test
    void isPlatneOsobniCislo_1() {

        oc.generujOsobniCislo("0123");
        assertTrue(oc.isPlatneOsobniCislo(), "Osobni číslo není platné");

    }

    @Test
    void isPlatneOsobniCislo_2() {

        oc.generujOsobniCislo("0123");
        oc.vysledek = "xxxx";
        assertFalse(oc.isPlatneOsobniCislo(), "Osobni číslo není platné");

    }
}
