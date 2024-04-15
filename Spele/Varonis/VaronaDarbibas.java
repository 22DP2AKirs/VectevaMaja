package Spele.Varonis;
import java.util.Arrays;

import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.VirtuvesSpoks;
import Spele.Enums;
import Spele.PaligMetodes;
import Spele.Enums.KustibasVirziens;
import Spele.Enums.Istabas;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.SpelesProcesi.Laiks;

public class VaronaDarbibas {
  public static int infoLapasSecibasSkaitlis = 1; // Nosaka vai varoņa ievade būs ar kustību saistīta vai ar darbu darbību saistīta.

  public static boolean aizdedzinatsSerkocins = false; 
  public static int serkocinaDeksanasLaikaSkaititajs;
  public static int laiksCikIlgiElektribaBusIzslegta;

  public static void parastasDarbibas(String panemtaIevade) {
    if (panemtaIevade.equals("F") && IestatijumuDati.atlikusoSerkocinuDaudzums != 0 && !aizdedzinatsSerkocins) {
      meginatAizdedzinatSerkocinu();
    } 
    else if (panemtaIevade.equals("A")) { // Pagriezties pa kreisi.
      pagrieztGalvu(KustibasVirziens.NEGATIVS);
    } 
    else if (panemtaIevade.equals("D")) { // Pagriezties pa labi.
      pagrieztGalvu(KustibasVirziens.POZITIVS);
    } 
    else if (panemtaIevade.equals("1")) { // Pārslēdz režīmu.
      infoLapasSecibasSkaitlis = 1;
    } 
    else if (panemtaIevade.equals("2")){
      infoLapasSecibasSkaitlis = 2;
    } 
    else if (panemtaIevade.equals("3")) {
      infoLapasSecibasSkaitlis = 3;
    } 
    else if (panemtaIevade.equals("4")) {
      infoLapasSecibasSkaitlis = 4;
    } 
  }

  public static void testesanasDarbibas(String komanda , String komandasTeksts) {
    // * Metodē ir darbības, kuras ir domātas spēles testēšanai.

    // Spoku info. izvade.
    if (komandasTeksts.equals("SI") && komanda.equals("ENTER")) {
      ieslegtIzslegtSpokuInformaciju();
    }
    // M-Spēļu info. izvade.
    else if (komandasTeksts.equals("MI") && komanda.equals("ENTER")) {
      ieslegtIzslegtMspelesInformaciju();
    }
    else if (komandasTeksts.equals("I") && komanda.equals("ENTER")) {
      DurvjuSpoks.durvjuSpoks.setSpokaAtputasLaikaMainamaKopija(0);
    }
    else if (komandasTeksts.equals("O") && komanda.equals("ENTER")) {

    }
    else if (komandasTeksts.equals("P") && komanda.equals("ENTER")) {

    }
    // Iziet no spēles.
    else if (komandasTeksts.equals("EXIT") && komanda.equals("ENTER")) {
      Main.programmaPalaista = false;
      System.exit(0);
    }
    // Izslēdz mājas elektrību.
    else if (komandasTeksts.equals("POWER OFF") && komanda.equals("ENTER")) {
      if(IestatijumuDati.elektribaIeslegta) {
        IestatijumuDati.elektribaIeslegta = false;
        laiksCikIlgiElektribaBusIzslegta = 10;
      } 
      else {
        IestatijumuDati.elektribaIeslegta = true;
      }
    }
    // Novāc varoni.
    else if (komandasTeksts.equals("KILL") && komanda.equals("ENTER")) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("PASNAVIBA");
    }
    // Uzvar spēli.
    else if (komandasTeksts.equals("WIN") && komanda.equals("ENTER")) {
      Laiks.spelesLaiks = 1000;
    }
    else if (komandasTeksts.equals("H1") && komanda.equals("ENTER")) {
      Laiks.spelesLaiks = Laiks.vienaStunda - 1;
    } 
    else if (komandasTeksts.equals("H2") && komanda.equals("ENTER")) {
      Laiks.spelesLaiks = (Laiks.vienaStunda * 2) - 1;
    } 
    else if (komandasTeksts.equals("H3") && komanda.equals("ENTER")) {
      Laiks.spelesLaiks = (Laiks.vienaStunda * 3) - 1;
    } 
    else if (komandasTeksts.equals("H4") && komanda.equals("ENTER")) {
      Laiks.spelesLaiks = (Laiks.vienaStunda * 4) - 1;
    } 
    else if (komandasTeksts.equals("H5") && komanda.equals("ENTER")) {
      Laiks.spelesLaiks = (Laiks.vienaStunda * 5) - 1;
    } 
    else if (komandasTeksts.equals("MS") && komanda.equals("ENTER")) {
      MazoSpeluIzvelesKods.izslegtVisasMazasSpeles();
      MazoSpeluIzvelesKods.izveletaMazaSpele = false;
    } 
  }


  // * Darbības izsauktas pēc komandas:
  /// * Gultas darbības:
  public static void gultasPrieksasKomandas(String komanda) {
    if (komanda.equals("W")) {
      kustetiesPaMaju(KustibasVirziens.POZITIVS); ////////////////////////////////////////
    }
    else if (komanda.equals("G")) {
      ieslegtIzslegtIstabasGaismu(Istabas.GULTA);
    }
  }

  public static void gultasLabasPusesKomandas(String komanda) {
    if (komanda.equals("W")) {
      kustetiesPaMaju(KustibasVirziens.NEGATIVS); ////////////////////////////////////////
    }
    else if (komanda.equals("E")) {
      izslegtElektribu();
    }
  }

  public static void gultasLejasKomandas(String komanda) {
    // Kods:
  }

  public static void gultasKreisasPusesKomandas(String komanda , String komandasTeksts) {
    if (komandasTeksts.equals("LOGS") && komanda.equals("ENTER")) {
      aizbiedetLogaSpoku(Istabas.GULTA);
    }
  }

  /// * Dīvāna darbības:
  public static void divanaPrieksasKomandas(String komanda , String komandasTeksts) {
    if (komandasTeksts.equals("LOGS") && komanda.equals("ENTER")) {
      aizbiedetLogaSpoku(Istabas.DIVANS);
    }
  }

  public static void divanaLabasPusesKomandas(String komanda) {
    if (komanda.equals("W")) {
      kustetiesPaMaju(KustibasVirziens.POZITIVS); ////////////////////////////////////////
    }
    else if (komanda.equals("G")) {
      ieslegtIzslegtIstabasGaismu(Istabas.DIVANS);
    }
  }

  public static void divanaLejasKomandas(String komanda) {
    if (komanda.equals("W")) {
      kustetiesPaMaju(KustibasVirziens.NEGATIVS); ////////////////////////////////////////
    }
    else if (komanda.equals("E") && AtrodiPariSavienojums.mSpeleAtrodiPari) {
      MazoSpeluIzvelesKods.varonisIrMazajaSpele = true;
      Main.nodzestTerminali();
      TastaturasKlausitajs.nodzestKomandasTekstu();
      TastaturasKlausitajs.uzreizNodzestKomandu();
    }
  }

  public static void divanaKreisasPusesKomandas(String komanda) {
    // Kods:
  }

  /// * Durvju darbības:
  public static void durvjuPrieksasKomandas(String komanda , String komandasTeksts) {
    if (komandasTeksts.equals("LOGS") && komanda.equals("ENTER")) {
      aizbiedetLogaSpoku(Istabas.DURVIS);
    }
  }

  public static void durvjuLabasPusesKomandas(String komanda , String komandasTeksts) {
    if (komandasTeksts.equals("DURVIS") && komanda.equals("ENTER")) {
      aizbiedetDurvjuSpoku();
    }
    else if (komandasTeksts.equals("SLEGT") && komanda.equals("ENTER")) {
      aizslegtDurvis();
    }
    else if (komanda.equals("E") && KaratavasSavienojums.mSpeleKaratavas) {
      Karatavas.palaistKaratavas();
      TastaturasKlausitajs.nodzestKomandasTekstu();
    }
  }

  public static void durvjuLejasKomandas(String komanda) {
    if (komanda.equals("W")) {
      kustetiesPaMaju(KustibasVirziens.POZITIVS); ////////////////////////////////////////
    }
    else if (komanda.equals("G")) {
      ieslegtIzslegtIstabasGaismu(Istabas.DURVIS);
    }
  }

  public static void durvjuKreisasPusesKomandas(String komanda) {
    if (komanda.equals("W")) {
      kustetiesPaMaju(KustibasVirziens.NEGATIVS); ////////////////////////////////////////
    }
  }

  /// * Virtuves darbības.
  public static void virtuvesPrieksasKomandas(String komanda) {
    if (komanda.equals("W")) {
      kustetiesPaMaju(KustibasVirziens.NEGATIVS); ////////////////////////////////////////
    }
  }

  public static void virtuvesLabasPusesKomandas(String komanda , String komandasTeksts) {
    if (komandasTeksts.equals("LOGS") && komanda.equals("ENTER")) {
      aizbiedetLogaSpoku(Istabas.VIRTUVE);
    }
  }

  public static void virtuvesLejasKomandas(String komanda) {
    // Ieslēgt izslēgt pagraba gaismu uz kom. 'G'.
    if (komanda.equals("G")) {
      ieslegtIzslegtPagrabaGaismu();
    }
  }

  public static void virtuvesKreisaPuseKomandas(String komanda) {
    if (komanda.equals("W")) {
      kustetiesPaMaju(KustibasVirziens.POZITIVS); ////////////////////////////////////////
    }
    else if (komanda.equals("G")) {
      ieslegtIzslegtIstabasGaismu(Istabas.VIRTUVE);
    }
  }
  



  // * Darbības kā metodes:
  /// Public:
  public static void izietAraNoMspeles(String komanda) {
    if (MazoSpeluIzvelesKods.varonisIrMazajaSpele) {
      if (komanda.equals("Q")) {
        MazoSpeluIzvelesKods.varonisIrMazajaSpele = false;
      }
      else if (komanda.equals("WIN")) {
        // Kas vēl, lai beigtu m-spēli.
        MazoSpeluIzvelesKods.varonisIrMazajaSpele = false;
        MazoSpeluIzvelesKods.izveletaMazaSpele = false;
        AtrodiPariSavienojums.mSpeleAtrodiPari = false;
      }
    }
  }

  /// Private:
  private static void meginatAizdedzinatSerkocinu() {
    if (Main.rand.nextInt(2) == 0) { // 50 % iespēja aizdedzināt sērkociņu.
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\lighting-matches.wav", 0);
      aizdedzinatsSerkocins = true;
      IestatijumuDati.atlikusoSerkocinuDaudzums--;
    } 
    else {
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\failing-to-lit-matches.wav", 0);
    }
  }

  private static void ieslegtIzslegtIstabasGaismu(Istabas istaba) {
    // Ja ir ieslēgta elektrība, tad var aiztikt lampas/istabu gaismas.
    if (IestatijumuDati.elektribaIeslegta) {
      if (IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS]) {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
        IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS] = false;
      } 
      else {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
        IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS] = true;
      }
    }
  }

  private static void izslegtElektribu() { // Kad izslēdz elektrību nosaka, kādi iestatījumi vai mainīgie mainās.
    SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
    aizbiedetVirtuvesSpoku();

    Arrays.fill(IestatijumuDati.istabuGaismasIeslegtas, false); // Visās istabās izslēdz gaismu.

    IestatijumuDati.elektribaIeslegta = false;
    laiksCikIlgiElektribaBusIzslegta = 3;
  }

  private static void ieslegtIzslegtMspelesInformaciju() {
    if (Main.mSpeluInfo) {
      Main.mSpeluInfo = false;
    } 
    else {
      Main.mSpeluInfo = true;
    }
    Main.nodzestTerminali();
  }

  private static void ieslegtIzslegtSpokuInformaciju() {
    if (Main.spokuInfo) {
      Main.spokuInfo = false;
    } 
    else {
      Main.spokuInfo = true;
    }
    Main.nodzestTerminali();
  }

  private static void aizbiedetLogaSpoku(Istabas istaba) {
    // Metode var būt izsaukta tikai tad, kad varonis skatās uz iespējamo loga spoka vietu (Visi logi).
    // 1. Pārbauda vai loga spoks ir varoņa aktuālajā istabā. 2. Pārbauda vai spoks ir ieslēgts jeb aktīvs.
    if (LogaSpoks.logaSpoks.getLSIstabu().equals(istaba.ISTABA) && LogaSpoks.logaSpoks.getSpoksIrAktivs()) {
      // Skaņa -->
      LogaSpoks.logaSpoks.deaktivizetSpoku();
    }
  }

  private static void aizbiedetVirtuvesSpoku() {
    if (VirtuvesSpoks.virtuvesSpoks.getSpoksIrAktivs()) {
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\spoks_krit_leja_pa_kapnem.wav", VirtuvesSpoks.virtuvesSpoks.getSpokaFazesIndekss() - 17);
      VirtuvesSpoks.virtuvesSpoks.deaktivizetSpoku();
    }
  }

  private static void aizbiedetDurvjuSpoku() {
    if (DurvjuSpoks.durvjuSpoks.getSpoksIrAktivs()) {
      // Skaņa -->
      DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    }
  }

  private static void ieslegtIzslegtPagrabaGaismu() {
    if(!IestatijumuDati.spuldziteSaplesta) {
      if (IestatijumuDati.pagrabaGaisma) {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
        IestatijumuDati.pagrabaGaisma = false;
      }
      else {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
        IestatijumuDati.pagrabaGaisma = true;
      }
    }
  }

  private static void aizslegtDurvis() {
    if (!IestatijumuDati.durvisSlegtas && DurvjuSpoks.durvjuSpoks.getSpokaFazesIndekss() == 0) {
      IestatijumuDati.durvisSlegtas = true;
      DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    }
  }

  // * Laika threda metodes:
  public static void skaititCikIlgiLidzElektribasPieslegsanas() {
    // Skaita, cik ilgi līdz elektrības pieslēgšanas.
    if (!IestatijumuDati.elektribaIeslegta) { // Ja false, tad ...
      if (laiksCikIlgiElektribaBusIzslegta < 1) {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
        IestatijumuDati.elektribaIeslegta = true;
      }
      laiksCikIlgiElektribaBusIzslegta--;
    }
  }

  public static void skaititCikIlgiDegsSerkocins() {
    // * Metode skaita, cik ilgi līdz sērkociņš izdegs, un pēc tam izdzēš to.
    // Ja sērkociņš ir aizdedzināts un tagadējais degšanas laiks nav vienāds ar iestatījumos uzstādīto laiku, tad ...
    if (aizdedzinatsSerkocins && serkocinaDeksanasLaikaSkaititajs != IestatijumuDati.maxSerkocinaDegsanasLaiks) {
      serkocinaDeksanasLaikaSkaititajs++;
    } 
    // Citādi ...
    else {
      aizdedzinatsSerkocins = false;
      serkocinaDeksanasLaikaSkaititajs = 0;
    }
  }


  // * Varoņa kustību metodes:
  private static void pagrieztGalvu(KustibasVirziens vertiba) { // vērtības -1  vai  1.
    // * Metode ir atbildīga par varoņa galvas pagriežšanu pa labi (poz. vērtība), un pa kreisi (neg. vērtība).
    int varonaVirziens = Enums.V_Virziens.CIPARS;

    varonaVirziens += vertiba.CIPARS;

    // Pārbauda, lai vērtība neaiziet aiz robežas.
    if (varonaVirziens == 4) {
      varonaVirziens = 0;
    }
    else if (varonaVirziens == -1) {
      varonaVirziens = 3;
    }

    Enums.V_Virziens = PaligMetodes.atrastVirzienaEnumuPecTaCiparaVertibas(varonaVirziens);
  }

  private static void kustetiesPaMaju(KustibasVirziens vertiba) { // vērtības -1  vai  1.
    // * Metode ir atbildīga par kustību pa māju.
    // Kopā mājā ir 4 istabas, kurās var iet iekšā gan pulksteņrādītāja virzienā, gan pret to (vērtība neg. vai poz.).
    // Istabu indeksi: 0. Gulta, 1. Dīvāna istaba, 2. Durvju istaba, 3. Virtuve.
    int istabasCipars = Enums.V_Istaba.CIPARS;
    
    istabasCipars += vertiba.CIPARS;

    // Pārbauda, lai vērtība neaiziet aiz robežas.
    if (istabasCipars == 4) {
      istabasCipars = 0;
    }
    else if (istabasCipars == -1) {
      istabasCipars = 3;
    }

    Enums.V_Istaba = PaligMetodes.atrastIstabasEnumuPecTaCiparaVertibas(istabasCipars);
  }
}