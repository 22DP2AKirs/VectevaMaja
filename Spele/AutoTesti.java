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

}
