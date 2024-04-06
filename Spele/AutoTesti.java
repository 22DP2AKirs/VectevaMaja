package Spele;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Spele.SpelesProcesi.Main;

// import org.junit.Assert;

public class AutoTesti {

  @Test
  public void testetMajasdarbaPapildusLaikaAprekinu() {
    int stundasLaiks = 8;
    int papildusMajasdarbuIzpildesLaiks = 0;
    int randCipars = Main.rand.nextInt(101); // Skaitlis no 0 - 100 ieskaitot.
    // Maza iespēja, ka mājasdarbs būs jāizpilda stundas laikā
    if (randCipars > 20) { // 70% iespēja.
      if (randCipars > 50) { // 50% iespēja.
        if (randCipars > 80) { // 20% iespēja.
          papildusMajasdarbuIzpildesLaiks = 3;
        }
        papildusMajasdarbuIzpildesLaiks = 2;
      }
      papildusMajasdarbuIzpildesLaiks = 1;
    }

    // 3. Pamazina mājasdarba izpildes termiņu, lai tas nepārsniegtu 6 AM laiku.
    while (stundasLaiks + papildusMajasdarbuIzpildesLaiks > 6) {
      papildusMajasdarbuIzpildesLaiks--;
    }

    assertTrue(stundasLaiks + papildusMajasdarbuIzpildesLaiks <= 6);
  }

}
