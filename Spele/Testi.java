package Spele;

import Spele.Majasdarbi.SamaisitieVardi.SMSavienojums;
import Spele.Majasdarbi.SamaisitieVardi.SamaisitieVardi;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;

public class Testi {
  public static boolean testesana = false;

  public static void testaProgramma() throws InterruptedException { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    TastaturasKlausitajs.palaistKlaviaturasLasitaju();
    Main.nodzestTerminali();

    SamaisitieVardi.izveidotJaunuSVObjektu();

    while (true) {
      TastaturasKlausitajs.definetCiklaKomandu();

      SMSavienojums.palaistSamaisitosVardus();
      System.out.println( SamaisitieVardi.samaisitieVardi.samaisitoBurtuVirkne);
      System.out.println( SamaisitieVardi.samaisitieVardi.lietotajaVards);
      System.out.println( Main.ciklaKomanda);

      Thread.sleep(100);
      Main.nodzestTerminali();
    }
  }
}