package Spele.Varonis;

import java.util.Arrays;

import Spele.Enums;
import Spele.Enums.Istabas;
import Spele.Enums.Virzieni;
import Spele.Izskati.IstabuIzskati;
import Spele.Parklajumi.BildesParklajumi;
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

  // Šie masīvi tiek pārbaudīti, lai labāk spētu noteikt, kāda darbība ir, kādai metodei.
  private static final String[] testesanasKomandas = { "I", "O", "P" , "SI", "MI", "EXIT", "POWER OFF", "KILL", "WIN"};
  private static final String[] parastasKomandas = {"F", "A", "D", "1", "2", "3", "4"};

  // Veiksmīgai un pareizai spēles darbībai, katrā virziena izvēlē pirmajam ir jābūt komandas apstrādei,
  // un tikai tad vizuālajai izvadei.

  public static void noteiktVisasAktualasDarbibas(Istabas istaba, Virzieni virziens) {
    // Mainīgie, kurus apstrādās šī metode.
    String ievade = Ievade.lietotajaIevade; // Lietotāja ievade, komandu apstrādei.
    
    String[] mainamaisMasivs = // Šo masīvu pārklās ar pārklājumiem, kuri ir aktuāli varoņa konkrētajā vietā.
    BildesParklajumi.izveidotMainamoMasivu(IstabuIzskati.istabuMasivs[Enums.V_Istaba.CIPARS][Enums.V_Virziens.CIPARS]);
    
    
    // Darbības jeb komandas pareizai situācijai.
    // if (!ievade.equals("}")) { // Ja ievades nebija, tad nepārbauda pārējās komandas.
      VaronaDarbibas.izietAraNoMspeles(ievade);

      // Main menu komandas.
      if (Main.mainMenu) {
        VaronaDarbibas.sakumaEkranaDarbibas(ievade);
      } 
      // Spēles komandas.
      else if (Main.spelePalaista) {
        if (!ievade.equals("}")) {
          if (Arrays.asList(testesanasKomandas).contains(ievade)) { // Testēšanas komands.
            VaronaDarbibas.testesanasDarbibas(ievade);
          }
          else if (Arrays.asList(parastasKomandas).contains(ievade)) { // Parastās komandas.
            VaronaDarbibas.parastasDarbibas(ievade);
          }
        }

        // Pārējās komandas, kuras ir saistītas ar istabas poz. un vir..
        /* Pārbaudes process:
           Pārbaude atrod, kurā istabā atrodas varonis un uz, kuru pusi viņš skatās.
           Tālāk tiek izpildītas visas tās 'lokācijas' vajadzīgās darbības.
        */
        if (istaba.equals(Istabas.GULTA)) { // ----------------------------- Gulta.
          if (virziens.equals(Virzieni.PRIEKSA)) {
            VaronaDarbibas.gultasPrieksasKomandas(ievade);
            BildesParklajumi.uzliktGultasPrieksasParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.LABA_PUSE)) {
            VaronaDarbibas.gultasLabasPusesKomandas(ievade);
            BildesParklajumi.uzliktGultasLabasPusesParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.LEJA)) {
            VaronaDarbibas.gultasLejasKomandas(ievade);
            BildesParklajumi.uzliktGultasLejasParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.KREISA_PUSE)) {
            VaronaDarbibas.gultasKreisasPusesKomandas(ievade);
            BildesParklajumi.uzliktGultasKreisasPusesParklajumus(mainamaisMasivs);
          }
        }
        else if (istaba.equals(Istabas.DIVANS)) { // ----------------------- Dīvāns.
          if (virziens.equals(Virzieni.PRIEKSA)) {
            VaronaDarbibas.divanaPrieksasKomandas(ievade);
            BildesParklajumi.uzliktDivanaPrieksasParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.LABA_PUSE)) {
            VaronaDarbibas.divanaLabasPusesKomandas(ievade);
            BildesParklajumi.uzliktDivanaLabasPusesParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.LEJA)) {
            VaronaDarbibas.divanaLejasKomandas(ievade);
            BildesParklajumi.uzliktDivanaLejasParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.KREISA_PUSE)) {
            VaronaDarbibas.divanaKreisasPusesKomandas(ievade);
            BildesParklajumi.uzliktDivanaKreisasPusesParklajumus(mainamaisMasivs);
          }
        }
        else if (istaba.equals(Istabas.DURVIS)) { // ----------------------- Durvis.
          if (virziens.equals(Virzieni.PRIEKSA)) {
            VaronaDarbibas.durvjuPrieksasKomandas(ievade);
            BildesParklajumi.uzliktDurvjuPrieksasParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.LABA_PUSE)) {
            VaronaDarbibas.durvjuLabasPusesKomandas(ievade);
            BildesParklajumi.uzliktDurvjuLabasPusesParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.LEJA)) {
            VaronaDarbibas.durvjuLejasKomandas(ievade);
            BildesParklajumi.uzliktDurvjuLejasParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.KREISA_PUSE)) {
            VaronaDarbibas.durvjuKreisasPusesKomandas(ievade);
            BildesParklajumi.uzliktDurvjuKreisasPusesParklajumus(mainamaisMasivs);
          }
        }
        else if (istaba.equals(Istabas.VIRTUVE)) { // ---------------------- Virtuve.
          if (virziens.equals(Virzieni.PRIEKSA)) {
            VaronaDarbibas.virtuvesPrieksasKomandas(ievade);
            BildesParklajumi.uzliktVirtuvesPrieksasParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.LABA_PUSE)) {
            VaronaDarbibas.virtuvesLabasPusesKomandas(ievade);
            BildesParklajumi.uzliktVirtuvesLabasPusesParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.LEJA)) {
            VaronaDarbibas.virtuvesLejasKomandas(ievade);
            BildesParklajumi.uzliktVirtuvesLejasParklajumus(mainamaisMasivs);
          }
          else if (virziens.equals(Virzieni.KREISA_PUSE)) {
            VaronaDarbibas.virtuvesKreisaPuseKomandas(ievade);
            BildesParklajumi.uzliktVirtuvesKreisasPusesParklajumus(mainamaisMasivs);
          }
        }
      }
    // }
    // Metodes beigas.
    BildesParklajumi.istabasGaismasUnSerkocinaParklajumi(mainamaisMasivs, IstabuIzskati.istabuMasivs[Enums.V_Istaba.CIPARS][Enums.V_Virziens.CIPARS]);
    BildesParklajumi.atjaunotParklatoIstabu(mainamaisMasivs);
    Ievade.parbauditVaiKomandaTikaIzpildita();
  }

  
}
