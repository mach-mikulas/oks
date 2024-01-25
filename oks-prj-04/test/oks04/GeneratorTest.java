package oks04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class GeneratorTest {

  private ICteniDat cteniDatMock;
  private Generator generator;
  private List<List<OsobniCislo>> seznamyTypuStudia;
  private List<OsobniCislo> testovaciData;
  
  @BeforeEach
  public void setUp() {
    // příprava dat pro mock objekt
    testovaciData = TestovaciData.getTestovaciData();


    // příprava mock objektu
    cteniDatMock = mock(ICteniDat.class);

    generator = new Generator(cteniDatMock);

    when(cteniDatMock.nactiVsechnaOsobniCisla(anyString())).thenReturn(testovaciData);

    seznamyTypuStudia = generator.zpracovani("ahoj", "fav");

  }
  @Test
  public void getSeznamTypuStudia_bakalari(){

    int pocet = generator.getSeznamTypuStudia(seznamyTypuStudia, TypStudia.BAKALARSKY).size();
    assertEquals(3, pocet);

  }

  @Test
  public void getSeznamTypuStudia_navazujici(){

    int pocet = generator.getSeznamTypuStudia(seznamyTypuStudia, TypStudia.NAVAZUJICI).size();
    assertEquals(2, pocet);

  }

  @Test
  public void getSeznamTypuStudia_doktorandi(){

    int pocet = generator.getSeznamTypuStudia(seznamyTypuStudia, TypStudia.DOKTORSKY).size();
    assertEquals(2, pocet);

  }

  @Test
  public void vytvorSeznamChybnychFormatu(){

    int pocet = generator.vytvorSeznamChybnychFormatu(testovaciData, "A").size();
    assertEquals(4, pocet);

  }
 
  @AfterEach
  public void tearDown() {

    verify(cteniDatMock).nactiVsechnaOsobniCisla(anyString());

  }
}
