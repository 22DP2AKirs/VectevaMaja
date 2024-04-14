package Spele.Varonis;

import java.util.Arrays;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import Spele.Enums;
import Spele.K;
import Spele.Enums.Istabas;
import Spele.Enums.Virzieni;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.IstabuIzskati;
import Spele.KontaKods.Konts;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.Parklajumi.BildesParklajumi;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;


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
  private static final String[] testesanasKomandas = { "I", "O", "P" , "SI", "MI", "EXIT", "POWER OFF", "KILL", "WIN", "H1", "H2", "H3", "H4", "H5", "MS"};
  private static final String[] parastasKomandas = {"F", "A", "D", "1", "2", "3", "4"};

  // Izvelnes skaitlis (Izmantots, lai kustinātu dažāda veida 'main menus').
  public static int izvelnesSkaitlis = 0;

  // Veiksmīgai un pareizai spēles darbībai, katrā virziena izvēlē pirmajam ir jābūt komandas apstrādei,
  // un tikai tad vizuālajai izvadei.

  public static void izpilditSpelesDarbibas(Istabas istaba, Virzieni virziens, String komanda , String komandasTeksts) {
    // * Metode ietekmē tikai un vienīgi komandu apstrādi un bildes izvadi.
    // Mainīgie, kurus apstrādās šī metode.
    String[] mainamaisMasivs = // Šo masīvu pārklās ar pārklājumiem, kuri ir atkarīgi no varoņa konkrētajā vietā.
    BildesParklajumi.izveidotMainamoMasivu(IstabuIzskati.istabuMasivs[Enums.V_Istaba.CIPARS][Enums.V_Virziens.CIPARS]);
    
    
    // Darbības jeb komandas pareizai situācijai.
    VaronaDarbibas.izietAraNoMspeles(komanda);

      
    // Spēles komandas.
    if (!MazoSpeluIzvelesKods.varonisIrMazajaSpele) {
      TastaturasKlausitajs.sagatavotKomanduDzesanai();

      if (!komanda.equals(K.TUKSA_IEVADE)) {
        // 1. Atrod darbību noteiktai komandai.
        if (Arrays.asList(testesanasKomandas).contains(komanda) || Arrays.asList(testesanasKomandas).contains(komandasTeksts) ) { // Testēšanas komands.
          VaronaDarbibas.testesanasDarbibas(komanda, komandasTeksts);
        }
        else if (Arrays.asList(parastasKomandas).contains(komanda) || Arrays.asList(parastasKomandas).contains(komandasTeksts)) { // Parastās komandas.
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
          VaronaDarbibas.gultasKreisasPusesKomandas(komanda, komandasTeksts);
          BildesParklajumi.uzliktGultasKreisasPusesParklajumus(mainamaisMasivs);
        }
      }
      else if (istaba.equals(Istabas.DIVANS)) { // ----------------------- Dīvāns.
        if (virziens.equals(Virzieni.PRIEKSA)) {
          VaronaDarbibas.divanaPrieksasKomandas(komanda , komandasTeksts);
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
          VaronaDarbibas.durvjuPrieksasKomandas(komanda , komandasTeksts);
          BildesParklajumi.uzliktDurvjuPrieksasParklajumus(mainamaisMasivs);
        }
        else if (virziens.equals(Virzieni.LABA_PUSE)) {
          VaronaDarbibas.durvjuLabasPusesKomandas(komanda , komandasTeksts);
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
          VaronaDarbibas.virtuvesLabasPusesKomandas(komanda , komandasTeksts);
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
  }

  public static void izvelnesKustiba(String ievade, int izvelesIespejas) {
    // * Ļauj kontrolēt spēles izvēlnes ar dažādiem lielumiem.
    if (ievade.equals("W") && izvelnesSkaitlis > 0) {
      // Pārvieto izvēli uz augšu (^).
      izvelnesSkaitlis--;
      TastaturasKlausitajs.uzreizNodzestKomandu();
    } 
    else if (ievade.equals("S") && izvelnesSkaitlis < izvelesIespejas - 1) {
      // Pārvieto izvēli uz leju (v).
      izvelnesSkaitlis++;
      TastaturasKlausitajs.uzreizNodzestKomandu();
    }
  }

  public static void izpilditSakumaEkranaDarbibas(String komanda) {
    // * Šī metode nosaka, kādas darbības būs pieejamas sākuma ekrānā (Main screen), un to darbību izpilde.
    // Skatoties, kāda ir ievade, tāda būs darbība.
    
    if (!komanda.equals(K.TUKSA_IEVADE)) {
      /* Sākuma ekrāna izvēles iespējas:
        (izvelnes cipars ir kārtas skaitlis)
        0. Turpināt.
        1. Spēlēt.
        2. Iestatījumi.
        3. Pamācība.
        4. Konts.
        5. Iziet.
      */
      TastaturasKlausitajs.sagatavotKomanduDzesanai();
      izvelnesKustiba(komanda, 6);
      if (komanda.equals("ENTER")) { // "" = 'ENTER'.
        // Turpinājuma kods:
        if (izvelnesSkaitlis == 0) {
          Main.sakumaEkrans = false;
          Main.spelePalaista = true;
        }
        // Jaunas spēles kods:
        else if (izvelnesSkaitlis == 1) {
          // Nodzēš visu nedēļas progresu.
          IestatijumuDati.spelesNakts = 1;
          if (Konts.lietotajsPiesledzies) {
            FailuRedigetajs.mainitFailaMainigaVertibu("spelesNakts", "1", Konts.lietotajaKontaCels);
          }

          Main.sakumaEkrans = false;
          Main.spelePalaista = true;
        } 
        // Iestatījumu kods:
        else if (izvelnesSkaitlis == 2) {
        } 
        // Pamācības kods:
        else if (izvelnesSkaitlis == 3) {
        } 
        // Konta rģistrācijas kods:
        else if (izvelnesSkaitlis == 4) {
          // Ievade.lietotajaIevade = K.TUKSA_IEVADE;
          Konts.kontaIzvelesDarbibas();
        } 
        // Aizvērt programmu:
        else if (izvelnesSkaitlis == 5) {
          Main.programmaPalaista = false;
          try {
            GlobalScreen.unregisterNativeHook(); // Atāķē klaviatūras klausītāju.
            System.exit(0); // Iziet no programmas.
          } catch (NativeHookException nativeHookException) {
            nativeHookException.printStackTrace();
          }
        }
      }
    }
  }

  
}
