package Spele;

import java.util.Scanner;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.SpelesProcesi.Main;

public class Testi {
  public static boolean testesana = false;

  public static void testaProgramma() throws InterruptedException { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    try ( Scanner iLasitajs = new Scanner(System.in) ) { // Izslēdz erroru 'lasītājs nav aizvērts'.
      Main.nodzestTerminali();
      
      String ievade;

      // Cikls.
      while (true) {
        PaligMetodes.izvaditArrayListElementus(IestatijumuDati.naktsDati);

        ievade = iLasitajs.nextLine();

        if (ievade.equals("EXIT")) {
          break;
        }
        Main.nodzestTerminali();
      }
    }
  }
}
