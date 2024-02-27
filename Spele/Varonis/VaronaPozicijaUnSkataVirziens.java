package Spele.Varonis;

import java.util.Arrays;

import Spele.Enums.Istabas;
import Spele.Enums.Virzieni;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;


public class VaronaPozicijaUnSkataVirziens {
  /* Clases doma jeb jēga: 
     Lai katrā klasē nevajadzētu veidot vairākus if-else_if nosacījumus, specifiskām
     pārbaudēm. Šī klases saturēs vienu lielu if-else_if nosacījumu, kurš izsauks visas
     nepieciešamās metodes atkarīgi no tā, kur atrodas un uz kurieni skatās varonis.

     Cerības:
     Programma patērēs mazāk resursus un strādās ātrāk. Programmu varēs vieglāk saprast
     un salasīt koda domu.
  */

  // Spelētāja pozīcija.
  public static int varonaIstabasCipars = 2; // 0, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas.
  public static int varonaVirzienaCipars = 1;

  private static final String[] testesanasKomandas = { "I", "O", "P" , "SI", "MI", "EXIT", "POWER OFF", "KILL", "WIN"};
  private static final String[] parastasKomandas = {"F", "A", "W", "D", "1", "2", "3", "4"};

  // Veiksmīgai un pareizai spēles darbībai, katrā virziena izvēlē pirmajam ir jābūt komandas apstrādei,
  // un tikai tad vizuālajai izvadei.

  public static void noteiktVisasAktualasDarbibas(Istabas istaba, Virzieni virziens) {
    String ievade = Ievade.lietotajaIevade;

    // Iziet ārā no m-spēles.
    
    
    // Darbības jeb komandas pareizai situācijai.
    if (!ievade.equals("}")) { // Ja ievades nebija, tad nepārbauda pārējās komandas.
      VaronaDarbibas.izietAraNoMspeles(ievade);

      // Main menu komandas.
      if (Main.mainMenu) {
        VaronaDarbibas.sakumaEkranaDarbibas(ievade);
      } 
      // Spēles komandas.
      else if (Main.spelePalaista) {
        if (Arrays.asList(testesanasKomandas).contains(ievade)) {
          VaronaDarbibas.testesanasDarbibas(ievade);
        }
        else if (Arrays.asList(parastasKomandas).contains(ievade)) {
          VaronaDarbibas.parastasDarbibas(ievade);
        }
        // Pārējās komandas, kuras ir saistītas ar istabas poz. un vir..
        else if (istaba.equals(Istabas.GULTA)) { // ----------------------------- Gulta.
          if (virziens.equals(Virzieni.PRIEKSA)) {
            VaronaDarbibas.gultasPrieksasKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.LABA_PUSE)) {
            VaronaDarbibas.gultasLabasPusesKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.LEJA)) {
            VaronaDarbibas.gultasLejasKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.KREISA_PUSE)) {
            VaronaDarbibas.gultasKreisasPusesKomandas(ievade);
          }
        }
        else if (istaba.equals(Istabas.DIVANS)) { // ----------------------- Dīvāns.
          if (virziens.equals(Virzieni.PRIEKSA)) {
            VaronaDarbibas.divanaPrieksasKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.LABA_PUSE)) {
            VaronaDarbibas.divanaLabasPusesKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.LEJA)) {
            VaronaDarbibas.divanaLejasKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.KREISA_PUSE)) {
            VaronaDarbibas.divanaKreisasPusesKomandas(ievade);
          }
        }
        else if (istaba.equals(Istabas.DURVIS)) { // ----------------------- Durvis.
          if (virziens.equals(Virzieni.PRIEKSA)) {
            VaronaDarbibas.durvjuPrieksasKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.LABA_PUSE)) {
            VaronaDarbibas.durvjuLabasPusesKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.LEJA)) {
            VaronaDarbibas.durvjuLejasKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.KREISA_PUSE)) {
            VaronaDarbibas.durvjuKreisasPusesKomandas(ievade);
          }
        }
        else if (istaba.equals(Istabas.VIRTUVE)) { // ---------------------- Virtuve.
          if (virziens.equals(Virzieni.PRIEKSA)) {
            VaronaDarbibas.virtuvesPrieksasKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.LABA_PUSE)) {
            VaronaDarbibas.virtuvesLabasPusesKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.LEJA)) {
            VaronaDarbibas.virtuvesLejasKomandas(ievade);
          }
          else if (virziens.equals(Virzieni.KREISA_PUSE)) {
            VaronaDarbibas.virtuvesKreisaPuseKomandas(ievade);
          }
        }
      }
    }
    // Metodes beigas.
    Ievade.parbauditVaiKomandaTikaIzpildita();
  }

  
}
