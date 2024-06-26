package Spele.Varonis;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import Spele.Enums;
import Spele.Iestatijumi;
import Spele.K;
import Spele.Statistika;
import Spele.Enums.Istaba;
import Spele.Enums.Virziens;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Izskati.IstabuIzskati;
import Spele.KontaKods.Konts;
import Spele.Majasdarbi.MajasdarbuIzvelesKods;
import Spele.Parklajumi.BildesParklajumi;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Veikals.Piederumi;
import Spele.Veikals.VeikalaKods;


public class DarbibuIzvlele {
  /* Klases doma jeb jēga: 
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

  // Izvelnes skaitlis (Izmantots, lai kustinātu dažāda veida 'main menus').
  public static int izvelnesSkaitlis = 0;

  // Veiksmīgai un pareizai spēles darbībai, katrā virziena izvēlē pirmajam ir jābūt komandas apstrādei,
  // un tikai tad vizuālajai izvadei.

  public static void izpilditSpelesDarbibas(String komanda , String komandasTeksts , boolean pabeigtsKomTeksts) {
    // * Metode ietekmē tikai un vienīgi komandu apstrādi un bildes izvadi.
    String[] mainamaisMasivs = // Šis masīvs ir aizmugures fons, kuru 'apkrāsos' ar vajadzīgajiem pārklājumiem.
    BildesParklajumi.izveidotMainamoMasivu(IstabuIzskati.istabuMasivs[Enums.V_Istaba.CIPARS][Enums.V_Virziens.CIPARS]);    
    
    // Darbības jeb komandas pareizai situācijai.
    VaronaDarbibas.izietAraNoMspeles(komanda);

      
    // Spēles komandas.
    if (!MajasdarbuIzvelesKods.varonisIrMajasdarba) {
      
      if (!komanda.equals(K.TUKSA_IEVADE) || pabeigtsKomTeksts) {
        // 1. Atrod darbību noteiktai komandai.
        VaronaDarbibas.testesanasDarbibas(komandasTeksts, pabeigtsKomTeksts);
       
        VaronaDarbibas.parastasDarbibas(komanda, komandasTeksts, pabeigtsKomTeksts);
      }

      // Pārējās komandas, kuras ir saistītas ar istabas poz. un vir..
      /* Pārbaudes process:
          Pārbaude atrod, kurā istabā atrodas varonis un uz, kuru pusi viņš skatās.
          Tālāk tiek izpildītas visas tās 'lokācijas' vajadzīgās darbības.
      */
      if (Enums.V_Istaba.equals(Istaba.GULTA)) { // ----------------------------- Gulta.
        if (Enums.V_Virziens.equals(Virziens.PRIEKSA)) {
          VaronaDarbibas.gultasPrieksasKomandas(komanda);
          BildesParklajumi.uzliktGultasPrieksasParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.LABA_PUSE)) {
          VaronaDarbibas.gultasLabasPusesKomandas(komanda);
          BildesParklajumi.uzliktGultasLabasPusesParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.LEJA)) {
          BildesParklajumi.uzliktGultasLejasParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.KREISA_PUSE)) {
          VaronaDarbibas.gultasKreisasPusesKomandas(komanda, komandasTeksts, pabeigtsKomTeksts);
          BildesParklajumi.uzliktGultasKreisasPusesParklajumus(mainamaisMasivs);
        }
      }
      else if (Enums.V_Istaba.equals(Istaba.DIVANS)) { // ----------------------- Dīvāns.
        if (Enums.V_Virziens.equals(Virziens.PRIEKSA)) {
          VaronaDarbibas.divanaPrieksasKomandas(komanda , komandasTeksts, pabeigtsKomTeksts);
          BildesParklajumi.uzliktDivanaPrieksasParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.LABA_PUSE)) {
          VaronaDarbibas.divanaLabasPusesKomandas(komanda);
          BildesParklajumi.uzliktDivanaLabasPusesParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.LEJA)) {
          VaronaDarbibas.divanaLejasKomandas(komanda);
          BildesParklajumi.uzliktDivanaLejasParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.KREISA_PUSE)) {
        }
      }
      else if (Enums.V_Istaba.equals(Istaba.DURVIS)) { // ----------------------- Durvis.
        if (Enums.V_Virziens.equals(Virziens.PRIEKSA)) {
          VaronaDarbibas.durvjuPrieksasKomandas(komanda , komandasTeksts, pabeigtsKomTeksts);
          BildesParklajumi.uzliktDurvjuPrieksasParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.LABA_PUSE)) {
          VaronaDarbibas.durvjuLabasPusesKomandas(komanda , komandasTeksts, pabeigtsKomTeksts);
          BildesParklajumi.uzliktDurvjuLabasPusesParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.LEJA)) {
          VaronaDarbibas.durvjuLejasKomandas(komanda);
          BildesParklajumi.uzliktDurvjuLejasParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.KREISA_PUSE)) {
          VaronaDarbibas.durvjuKreisasPusesKomandas(komanda);
          BildesParklajumi.uzliktDurvjuKreisasPusesParklajumus(mainamaisMasivs);
        }
      }
      else if (Enums.V_Istaba.equals(Istaba.VIRTUVE)) { // ---------------------- Virtuve.
        if (Enums.V_Virziens.equals(Virziens.PRIEKSA)) {
          VaronaDarbibas.virtuvesPrieksasKomandas(komanda);
          BildesParklajumi.uzliktVirtuvesPrieksasParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.LABA_PUSE)) {
          VaronaDarbibas.virtuvesLabasPusesKomandas(komanda , komandasTeksts, pabeigtsKomTeksts);
          BildesParklajumi.uzliktVirtuvesLabasPusesParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.LEJA)) {
          VaronaDarbibas.virtuvesLejasKomandas(komanda);
          BildesParklajumi.uzliktVirtuvesLejasParklajumus(mainamaisMasivs);
        }
        else if (Enums.V_Virziens.equals(Virziens.KREISA_PUSE)) {
          VaronaDarbibas.virtuvesKreisaPuseKomandas(komanda);
          BildesParklajumi.uzliktVirtuvesKreisasPusesParklajumus(mainamaisMasivs);
        }
      }
    }
    // Metodes beigas.
    BildesParklajumi.istabasGaismasUnSerkocinaParklajumi(mainamaisMasivs, IstabuIzskati.istabuMasivs[Enums.V_Istaba.CIPARS][Enums.V_Virziens.CIPARS]);

    if (Piederumi.ieslegtaKamera) {
      BildesParklajumi.pievienotVideokameru(mainamaisMasivs);
    }

    BildesParklajumi.atjaunotParklatoIstabu(mainamaisMasivs);
  }

  public static void izvelnesKustiba(String ievade, int izvelesIespejas) {
    // * Ļauj kontrolēt spēles izvēlnes ar dažādiem lielumiem.
    if (!TastaturasKlausitajs.rakstaKomandasTekstu && !TastaturasKlausitajs.bijaEnter) {
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
  }

  // 
  // ? Sākuma ekrāna darbības.
  // 

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
      izvelnesKustiba(komanda, 8);

      if (komanda.equals("ENTER")) {
        // Turpinājuma kods:
        if (izvelnesSkaitlis == 0) {
          Main.sakumaEkrans = false;
          Main.spelePalaista = true;
        }
        // Jaunas spēles kods:
        else if (izvelnesSkaitlis == 1) {
          // Nodzēš visu nedēļas progresu.
          SakumaDati.spelesNakts = 1;
          SakumaDati.nauda = 0;
          if (Konts.lietotajsPiesledzies) {
            FailuRedigetajs.mainitFailaMainigaVertibu("spelesNakts", "1", Konts.lietotajaKontaCels);
            FailuRedigetajs.mainitFailaMainigaVertibu("nauda", "0", Konts.lietotajaKontaCels);
          }

          Main.sakumaEkrans = false;
          Main.spelePalaista = true;
        } 
        else if (izvelnesSkaitlis == 2) {
          // Veikala kods.
          VeikalaKods.veikalaPalaisana();
        }
        else if (izvelnesSkaitlis == 3) {
          // Iestatījumu kods:
          Iestatijumi.IestatijumuKods();
        } 
        else if (izvelnesSkaitlis == 4) {
          // Pamācības kods:
        } 
        else if (izvelnesSkaitlis == 5) {
          // Statistikas kods:
          Statistika.statistikasKods();
        } 
        else if (izvelnesSkaitlis == 6) {
          // Konta rģistrācijas kods:
          Konts.kontaIzvelesDarbibas();
        } 
        else if (izvelnesSkaitlis == 7) {
          // Aizvērt programmu:
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
