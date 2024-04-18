package Spele;

import Spele.SpelesProcesi.Main;

public class Testi {
  public static boolean testesana = false;

  public static void testaProgramma() { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.

    while (true) {
      Main.nodzestTerminali();
      System.out.println("::::1234567890");
      System.out.println(PaligMetodes.atgriestProgresaLiniju(100, 1000, 10, true)); 
      System.out.println(PaligMetodes.atgriestProgresaLiniju(9, 100, 10, true));
      System.out.println(PaligMetodes.atgriestProgresaLiniju(100, 100, 10, true));

      System.out.println(PaligMetodes.atgriestProgresaLiniju(50, 100, 5, true));
      System.out.println(PaligMetodes.atgriestProgresaLiniju(0, 100, 5, true));
      System.out.println(PaligMetodes.atgriestProgresaLiniju(10, 100, 5, true));

      PaligMetodes.gulet(10);
    }
  }

      
  
}
