package Spele;

import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;

public class Testi {
  public static boolean testesana = false;
  static int i = 1;

  public static void testaProgramma() throws InterruptedException { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    TastaturasKlausitajs.palaistKlaviaturasLasitaju();
    float i = 0;
    while (true) {
      System.out.println("123456789012345");
      System.out.println(PaligMetodes.atgriestProgresaLiniju(i, 100, 15, false));

      if (i > 100) {
        Thread.sleep(50000);
      }

      i += 0.4;
      Thread.sleep(30);
      
      Main.nodzestTerminali();
    }
  }
}