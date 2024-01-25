package oks02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OsobniCisloTest {

    OsobniCislo test;

    @BeforeEach
    void setUp() {
        this.test = new OsobniCislo("Novák, Josef, fav, 2014, b, 0123, p, i");
    }

    @Test
    void getOsobniCislo() {
        assertEquals("A14B0123P", test.getOsobniCislo());
    }

    @Test
    void isPlatneOsobniCislo_1() {
        assertEquals(true, test.isPlatneOsobniCislo());
    }

    @Test
    void isPlatneOsobniCislo_2() {
        test.vysledek = Konstanty.PRAZDNY;
        assertEquals(false, test.isPlatneOsobniCislo());
    }

    @Test
    void isPlatnyFormat_1() {
        assertEquals(true, test.isPlatnyFormat());
    }

    @Test
    void isPlatnyFormat_2() {
        assertEquals(test.platnyFormat, test.isPlatnyFormat());
    }

    @Test
    void getTypStudia() {
        OsobniCislo ing = new OsobniCislo("Novák, Josef, fav, 2014, n, 0123, p, i");
        assertEquals(TypStudia.NAVAZUJICI, ing.getTypStudia());
    }

    @Test
    void getFakulta() {
        assertEquals(test.fakulta, test.getFakulta());
    }

    @Test
    void zpracujPrijmeni_1() {

        test.zpracujPrijmeni("Novák");
        assertEquals("NOVÁK", test.prijmeni);
    }

    @Test
    void zpracujPrijmeni_2() {

        test.zpracujPrijmeni(null);
        assertEquals(Konstanty.ZNAK_CHYBY, test.prijmeni);
    }

    @Test
    void zpracujJmeno_1() {

        test.zpracujJmeno("Josef");
        assertEquals("Josef", test.jmeno);
    }

    @Test
    void zpracujJmeno_2() {

        test.zpracujJmeno(null);
        assertEquals(false, test.platnyFormat);
    }

    @Test
    void zpracujRokNastupu_1() {

        String rokNastupu = "2012";
        test.zpracujRokNastupu(rokNastupu);
        assertEquals(rokNastupu.substring(2), test.rokNastupu);
    }

    @Test
    void zpracujRokNastupu_2() {
        assertThrows(NumberFormatException.class, () -> test.zpracujRokNastupu("abcd"));
    }


    @Test
    void zpracujRokNastupu_3() {
        assertThrows(NumberFormatException.class, () -> test.zpracujRokNastupu("abcd"));
    }

    @Test
    void chybnyRokNastupu() {

        test.chybnyRokNastupu();
        assertEquals(Konstanty.ZNAK_CHYBY, test.rokNastupu);
    }

    @Test
    void zpracujFakulta_1() {

        test.zpracujFakulta("fav");
        assertEquals("A", test.fakulta);
    }

    @Test
    void zpracujFakulta_2() {

        test.zpracujFakulta(null);
        assertEquals(Konstanty.ZNAK_CHYBY, test.fakulta);
    }

    @Test
    void zpracujTypStudia_1() {

        test.zpracujTypStudia("b");
        assertEquals(TypStudia.BAKALARSKY, test.typStudia);
    }
    @Test
    void zpracujTypStudia_2() {

        test.zpracujTypStudia(null);
        assertEquals(TypStudia.NEPLATNY, test.typStudia);
    }

    @Test
    void zpracujFormaStudia_1() {

        test.zpracujFormaStudia("AHOJ");
        assertEquals(Konstanty.ZNAK_CHYBY, test.formaStudia);
    }

    @Test
    void zpracujFormaStudia_2() {

        test.zpracujFormaStudia("AHOJ");
        assertEquals(false, test.platnyFormat);
    }

    @Test
    void zpracujFormaStudia_3() {

        test.zpracujFormaStudia(null);
        assertEquals(Konstanty.ZNAK_CHYBY, test.formaStudia);
    }


    @Test
    void zpracujNepovinne() {

        test.zpracujNepovinne(null);
        assertEquals(Konstanty.PRAZDNY, test.nepovinne);
    }

    @Test
    void osobniCislo() {
        assertEquals(new OsobniCislo("Novák, Josef, fav, 2014, b, 0123, p, i"), test);
    }

}
