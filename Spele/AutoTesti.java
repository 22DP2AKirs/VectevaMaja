package Spele;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AutoTesti {

  @Test
  public void testetSaliktAtstarpesSimboluVirkne() {
    assertTrue(PaligMetodes.saliktAtstarpesSimboluVirkne("Abols", 1).equals("A b o l s"));
    assertTrue(PaligMetodes.saliktAtstarpesSimboluVirkne("Abols", 2).equals("A  b  o  l  s"));
    assertTrue(PaligMetodes.saliktAtstarpesSimboluVirkne("Abols", 3).equals("A   b   o   l   s"));
  }

  @Test
  public void testetProgresLinijasAtgriesanu() {
    assertTrue(PaligMetodes.atgriestProgresaLiniju(50, 100, 2, false).equals("▒"));
    assertTrue(PaligMetodes.atgriestProgresaLiniju(25, 100, 4, false).equals("▒"));
    assertTrue(PaligMetodes.atgriestProgresaLiniju(10, 100, 5, false).equals(""));

    assertTrue(PaligMetodes.atgriestProgresaLiniju(50, 100, 2, true).equals("50% ▒"));
    assertTrue(PaligMetodes.atgriestProgresaLiniju(25, 100, 4, true).equals("25% ▒"));
    assertTrue(PaligMetodes.atgriestProgresaLiniju(10, 100, 5, true).equals("10% "));
  }

}
