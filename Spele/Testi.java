package Spele;

import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.SpelesProcesi.Main;

public class Testi {
  public static void testaProgramma() throws InterruptedException { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    // Sagatave pirms spēles cikla.
    // Scanner iLasitajs = new Scanner(System.in);
    Main.nodzestTerminali();

    Karatavas vards = new Karatavas(Main.rand.nextInt(4), Main.rand.nextInt(4));

    // Cikls.
    while (true) {
      // Lietotāja ievade.
      System.out.print("\rJusu ievade: ");
    //   String ievade = iLasitajs.nextLine();

      // Apstrādā karātavas procesus.
      // vards.parbauditBurtu(ievade);

      // Izvada vārdu gan "_ _ _ _", gan "B _ _ I".
      System.out.println(vards.toString());

      System.out.print("\033[F"); // Noliek mirgojošo kursoru vienu līniju uz augšu.
      System.out.print("\033[F"); // Noliek mirgojošo kursoru vienu līniju uz augšu.

      // Thread.sleep(0);
    }
  }
}
