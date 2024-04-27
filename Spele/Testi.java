package Spele;

import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;

public class Testi {
  public static boolean testesana = false;
  static int i = 1;

  public static void testaProgramma() throws InterruptedException { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    TastaturasKlausitajs.palaistKlaviaturasLasitaju();
    Main.nodzestTerminali();
    int i = 0;
    while (true) {
      
      int b = i++;
      System.out.println(b);
      System.out.println(i);
      i = 0;

      b = ++i;
      System.out.println(b);
      System.out.println(i);

      Thread.sleep(99999);
    }
  }
}