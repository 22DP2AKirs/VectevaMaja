package Spele.Varonis;

import java.util.Arrays;

import Spele.Enums;
import Spele.K;
import Spele.Enums.Istabas;
import Spele.Enums.Virzieni;
import Spele.Izskati.IstabuIzskati;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.Parklajumi.BildesParklajumi;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;


public class DarbibuIzpilde {
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

  public static void izpilditSpelesDarbibas(Istabas istaba, Virzieni virziens, String komanda) {
    // * Metode ietekmē tikai un vienīgi komandu apstrādi un bildes izvadi.
    // Mainīgie, kurus apstrādās šī metode.
    String[] mainamaisMasivs = // Šo masīvu pārklās ar pārklājumiem, kuri ir atkarīgi no varoņa konkrētajā vietā.
    BildesParklajumi.izveidotMainamoMasivu(IstabuIzskati.istabuMasivs[Enums.V_Istaba.CIPARS][Enums.V_Virziens.CIPARS]);
    
    
    // Darbības jeb komandas pareizai situācijai.
    // if (!ievade.equals("}")) { // Ja ievades nebija, tad nepārbauda pārējās komandas.
    VaronaDarbibas.izietAraNoMspeles(komanda);

      
    // Spēles komandas.
    if (!MazoSpeluIzvelesKods.varonisIrMazajaSpele) {
      if (!komanda.equals(K.TUKSA_IEVADE)) {
        if (Arrays.asList(testesanasKomandas).contains(komanda)) { // Testēšanas komands.
          VaronaDarbibas.testesanasDarbibas(komanda);
        }
        else if (Arrays.asList(parastasKomandas).contains(komanda)) { // Parastās komandas.
          VaronaDarbibas.parastasDarbibas(komanda);
        }
      }

      // Pārējās komandas, kuras ir saistītas ar istabas poz. un vir..
      /* Pārbaudes process:
          Pārbaude atrod, kurā istabā atrodas varonis un uz, kuru pusi viņš skatās.
          Tālāk tiek izpildītas visas tās 'lokācijas' vajadzīgās darbības.
      */
      if (istaba.equals(Istabas.GULTA)) { // ----------------------------- Gulta.
        if (virziens.equals(Virzieni.PRIEKSA)) {
          VaronaDarbibas.gultasPrieksasKomandas(komanda);
          BildesParklajumi.uzliktGultasPrieksasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LABA_PUSE)) {
          VaronaDarbibas.gultasLabasPusesKomandas(komanda);
          BildesParklajumi.uzliktGultasLabasPusesParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LEJA)) {
          VaronaDarbibas.gultasLejasKomandas(komanda);
          BildesParklajumi.uzliktGultasLejasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.KREISA_PUSE)) {
          VaronaDarbibas.gultasKreisasPusesKomandas(komanda);
          BildesParklajumi.uzliktGultasKreisasPusesParklajumus(mainamaisMasivs);
        }
      }
      else if (istaba.equals(Istabas.DIVANS)) { // ----------------------- Dīvāns.
        if (virziens.equals(Virzieni.PRIEKSA)) {
          VaronaDarbibas.divanaPrieksasKomandas(komanda);
          BildesParklajumi.uzliktDivanaPrieksasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LABA_PUSE)) {
          VaronaDarbibas.divanaLabasPusesKomandas(komanda);
          BildesParklajumi.uzliktDivanaLabasPusesParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LEJA)) {
          VaronaDarbibas.divanaLejasKomandas(komanda);
          BildesParklajumi.uzliktDivanaLejasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.KREISA_PUSE)) {
          VaronaDarbibas.divanaKreisasPusesKomandas(komanda);
          BildesParklajumi.uzliktDivanaKreisasPusesParklajumus(mainamaisMasivs);
        }
      }
      else if (istaba.equals(Istabas.DURVIS)) { // ----------------------- Durvis.
        if (virziens.equals(Virzieni.PRIEKSA)) {
          VaronaDarbibas.durvjuPrieksasKomandas(komanda);
          BildesParklajumi.uzliktDurvjuPrieksasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LABA_PUSE)) {
          VaronaDarbibas.durvjuLabasPusesKomandas(komanda);
          BildesParklajumi.uzliktDurvjuLabasPusesParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LEJA)) {
          VaronaDarbibas.durvjuLejasKomandas(komanda);
          BildesParklajumi.uzliktDurvjuLejasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.KREISA_PUSE)) {
          VaronaDarbibas.durvjuKreisasPusesKomandas(komanda);
          BildesParklajumi.uzliktDurvjuKreisasPusesParklajumus(mainamaisMasivs);
        }
      }
      else if (istaba.equals(Istabas.VIRTUVE)) { // ---------------------- Virtuve.
        if (virziens.equals(Virzieni.PRIEKSA)) {
          VaronaDarbibas.virtuvesPrieksasKomandas(komanda);
          BildesParklajumi.uzliktVirtuvesPrieksasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LABA_PUSE)) {
          VaronaDarbibas.virtuvesLabasPusesKomandas(komanda);
          BildesParklajumi.uzliktVirtuvesLabasPusesParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LEJA)) {
          VaronaDarbibas.virtuvesLejasKomandas(komanda);
          BildesParklajumi.uzliktVirtuvesLejasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.KREISA_PUSE)) {
          VaronaDarbibas.virtuvesKreisaPuseKomandas(komanda);
          BildesParklajumi.uzliktVirtuvesKreisasPusesParklajumus(mainamaisMasivs);
        }
      }
    }
    // Metodes beigas.
    BildesParklajumi.istabasGaismasUnSerkocinaParklajumi(mainamaisMasivs, IstabuIzskati.istabuMasivs[Enums.V_Istaba.CIPARS][Enums.V_Virziens.CIPARS]);
    BildesParklajumi.atjaunotParklatoIstabu(mainamaisMasivs);
    Ievade.sagatavotKomanduDzesanai();
  }

  public static void izpilditSakumaEkranaDarbibas(String komanda) {
    // * Šī metode nosaka, kādas darbības būs pieejamas sākuma ekrānā (Main screen), un to darbību izpilde.
    // Skatoties, kāda ir ievade, tāda būs darbība.

    if (komanda.equals(K.TUKSA_IEVADE)) {
      // Metode neko nemaina.
    }
    else {
      /* Sākuma ekrāna izvēles iespējas:
        (izvelnes cipars ir kārtas skaitlis)
        0. Turpināt.
        1. Spēlēt.
        2. Iestatījumi.
        3. Pamācība.
        4. Konts.
        5. Iziet.
      */

      if (komanda.equals("W") && EkranuParklajumi.izvelnesCipars > 0) {
        EkranuParklajumi.izvelnesCipars--;
      } 
      else if (komanda.equals("S") && EkranuParklajumi.izvelnesCipars < 5) {
        EkranuParklajumi.izvelnesCipars++;
      } 
      else if (komanda.equals("")) { // "" = 'ENTER'.
        if (EkranuParklajumi.izvelnesCipars == 0) {
          // Turpinājuma kods:
        }
        else if (EkranuParklajumi.izvelnesCipars == 1) {
          // Spēlēšanas kods:
          Main.sakumaEkrans = false;
          Main.spelePalaista = true;
        } 
        else if (EkranuParklajumi.izvelnesCipars == 2) {
          // Iestatījumu kods:
        } 
        else if (EkranuParklajumi.izvelnesCipars == 3) {
          // Pamācības kods:
        } 
        else if (EkranuParklajumi.izvelnesCipars == 4) {
          // Konta rģistrācijas kods:
        } 
        else if (EkranuParklajumi.izvelnesCipars == 5) {
          // Aizvērt programmu:
          Main.programmaPalaista = false;
          System.exit(0); // Pārtrauc spēles darbību.
        }
      }
      Ievade.sagatavotKomanduDzesanai();
    }
  }

  
}
