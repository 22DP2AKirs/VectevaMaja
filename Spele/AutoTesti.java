package Spele;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Spele.SpelesProcesi.TastaturasKlausitajs;

public class AutoTesti {

  @Test
  public void testetBooleanVertibasAtgriesanu() {
    assertTrue(PaligMetodes.booleanVertiba(true).equals("T"));
    assertTrue(PaligMetodes.booleanVertiba(false).equals("F"));
  }

  @Test
  public void testetSaliktAtstarpesSimboluVirkne() {
    assertTrue(PaligMetodes.saliktAtstarpesSimboluVirkne("Abols", 1).equals("A b o l s"));
    assertTrue(PaligMetodes.saliktAtstarpesSimboluVirkne("Abols", 2).equals("A  b  o  l  s"));
    assertTrue(PaligMetodes.saliktAtstarpesSimboluVirkne("Abols", 3).equals("A   b   o   l   s"));
  }

  @Test
  public void testetProgresLinijasAtgriesanu() {
    assertTrue(PaligMetodes.atgriestProgresaLiniju(50, 100, 2, false).equals("▒" + K.TPELEKS + "▒" + K.RESET));
    assertTrue(PaligMetodes.atgriestProgresaLiniju(25, 100, 4, false).equals("▒" + K.TPELEKS + "▒▒▒" + K.RESET));
    assertTrue(PaligMetodes.atgriestProgresaLiniju(10, 100, 5, false).equals(K.TPELEKS + "▒▒▒▒▒" + K.RESET));

    assertTrue(PaligMetodes.atgriestProgresaLiniju(50, 100, 2, true).equals("50% ▒" + K.TPELEKS + "▒" + K.RESET));
    assertTrue(PaligMetodes.atgriestProgresaLiniju(25, 100, 4, true).equals("25% ▒" + K.TPELEKS + "▒▒▒" + K.RESET));
    assertTrue(PaligMetodes.atgriestProgresaLiniju(10, 100, 5, true).equals("10% " + K.TPELEKS + "▒▒▒▒▒" + K.RESET));
  }

  @Test
  public void testetVardaLimesanu() {
    String vards = "";
    String ievade = "a";

    int i = 0;
    int b = 0;
    while (i++ != 100) { // Cikls atkārtosies 100 reizes.
      vards = TastaturasKlausitajs.limetVardu(vards, ievade, 5);
      b++;
    }

    assertTrue(vards.equals("aaaaa"));
    assertTrue(b == 100);

    vards = "";
    ievade = "b";
    i = 0;

    while (i++ != 100) { // Cikls atkārtosies 100 reizes.
      vards = TastaturasKlausitajs.limetVardu(vards, ievade, 7);
      b++;
    }

    assertTrue(vards.equals("bbbbbbb"));

  }

}
