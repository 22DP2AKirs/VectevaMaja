package Spele;

import Spele.SpelesProcesi.TastaturasKlausitajs;

public class Testi {
  public static boolean testesana = false;
  static int i = 1;

  // static Thread kamerasThreds = Thread.ofVirtual().start(() -> {
  //   // Darbības, kas notiks threda dzīves laikā.
  //   while (Main.spelePalaista) {
  //     while (!VaronaDarbibas.ieslegtaKamera) {
  //       i++;
  //       System.out.println(i);
  //       try { Thread.sleep(100); } catch (Exception e) {} // 0.1 sec.
  //     }
  //   }
  // });



  public static void testaProgramma() { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    TastaturasKlausitajs.palaistKlaviaturasLasitaju();
    while (true) {
      // if (TastaturasKlausitajs.komanda.equals("W")) {
      //   System.out.println("Komanda: W");
      //   VaronaDarbibas.ieslegtaKamera = false;
      //   TastaturasKlausitajs.uzreizNodzestKomandu();
      // }


      // if (TastaturasKlausitajs.komanda.equals("S")) {
      //   System.out.println("Komanda: S");
      //   VaronaDarbibas.ieslegtaKamera = true;
      //   TastaturasKlausitajs.uzreizNodzestKomandu();
      // }

      // if (TastaturasKlausitajs.komanda.equals("E")) {
      //   System.out.println("Komanda: E");
      //   System.out.println(kamerasThreds.isInterrupted());
      //   TastaturasKlausitajs.uzreizNodzestKomandu();
      // }


    }
  }

      
  
}
