package Spele;

import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;

public class Testi {
  public static boolean testesana = false;
  static int i = 1;

  public static void testaProgramma() throws InterruptedException { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    TastaturasKlausitajs.palaistKlaviaturasLasitaju();
    Main.nodzestTerminali();

    Statistika.aizpilditLietotajuTabulu();
    Statistika.kartotAugosaSeciba(4);
    int kolonnasIndekss;
    String txt = "1ABC";

    while (true) {
      kolonnasIndekss = txt.charAt(0);
      System.out.println(kolonnasIndekss);

      PaligMetodes.gulet(1000);
    }
  }
}