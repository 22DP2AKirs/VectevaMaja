package Spele.Varonis;
import java.util.Arrays;

import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.VirtuvesSpoks;
import Spele.Veikals.Fotokamera;
import Spele.Veikals.Piederumi;
import Spele.Veikals.Serkocini;
import Spele.Veikals.VeikalaKods;
import Spele.Veikals.Videokamera;
import Spele.Enums;
import Spele.PaligMetodes;
import Spele.Enums.KustibasVirziens;
import Spele.Enums.Virzieni;
import Spele.Enums.Istabas;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Iestatijumi.Iestatijumi;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Laiks;

public class VaronaDarbibas {
  public static int infoLapasSecibasSkaitlis = 1; // Nosaka vai varoņa ievade būs ar kustību saistīta vai ar darbu darbību saistīta.

  public static int serkocinaDeksanasLaikaSkaititajs;
  public static int laiksCikIlgiElektribaBusIzslegta;
  
  public static void parastasDarbibas(String komanda, String komandasTeksts , boolean pabeigtsKomTeksts) {
    if (komanda.equals(Iestatijumi.aizdedzinatSerkocinu) && Serkocini.serkocini.getSerkocinuDaudzums() != 0 && !Serkocini.serkocini.getAizdedzinatsSerkocins()) {
      meginatAizdedzinatSerkocinu();
    } 
    else if (komanda.equals(Iestatijumi.griestiesPaKreisi)) { // Pagriezties pa kreisi.
      pagrieztGalvu(KustibasVirziens.NEGATIVS);
    } 
    else if (komanda.equals(Iestatijumi.griestiesPaLabi)) { // Pagriezties pa labi.
      pagrieztGalvu(KustibasVirziens.POZITIVS);
    } 
    else if (komanda.equals("1")) { // Pārslēdz režīmu.
      infoLapasSecibasSkaitlis = 1;
    } 
    else if (komanda.equals("2")){
      infoLapasSecibasSkaitlis = 2;
    } 
    else if (komanda.equals("3")) {
      infoLapasSecibasSkaitlis = 3;
    } 
    else if (komanda.equals("4")) {
      infoLapasSecibasSkaitlis = 4;
    }
    else if (komanda.equals(Iestatijumi.izmantotKameru) && (VeikalaKods.izveletaFotokamera || VeikalaKods.izveletaVideokamera)) {
      // Toggle.
      if (!Piederumi.ieslegtaKamera && Piederumi.baterija > 40) {
        Piederumi.ieslegtaKamera = true;
      }
      else {
        Piederumi.ieslegtaKamera = false;
      }
    }
    else if (komandasTeksts.equals("FOTO") && pabeigtsKomTeksts && (VeikalaKods.izveletaFotokamera && Piederumi.ieslegtaKamera && Fotokamera.fotokamera.getMaxLimenis()) && Enums.V_Istaba == Istabas.VIRTUVE && Enums.V_Virziens == Virzieni.LEJA) {
      Piederumi.ieslegtaKamera = false;
      Piederumi.baterija = 0;
      VirtuvesSpoks.virtuvesSpoks.deaktivizetSpoku();
    }
  }

  public static void testesanasDarbibas(String komandasTeksts , boolean pabeigtsKomTeksts) {
    // * Metodē ir darbības, kuras ir domātas spēles testēšanai.

    // Spoku info. izvade.
    if (komandasTeksts.equals("SI") && pabeigtsKomTeksts) {
      ieslegtIzslegtSpokuInformaciju();
    }
    // M-Spēļu info. izvade.
    else if (komandasTeksts.equals("MI") && pabeigtsKomTeksts) {
      ieslegtIzslegtMspelesInformaciju();
    }
    else if (komandasTeksts.equals("I") && pabeigtsKomTeksts) {
      DurvjuSpoks.durvjuSpoks.setSpokaAtputasLaikaMainamaKopija(0);
    }
    else if (komandasTeksts.equals("O") && pabeigtsKomTeksts) {

    }
    else if (komandasTeksts.equals("P") && pabeigtsKomTeksts) {

    }
    // Iziet no spēles.
    else if (komandasTeksts.equals("EXIT") && pabeigtsKomTeksts) {
      Main.programmaPalaista = false;
      System.exit(0);
    }
    // Izslēdz mājas elektrību.
    else if (komandasTeksts.equals("POWER OFF") && pabeigtsKomTeksts) {
      if(SakumaDati.elektribaIeslegta) {
        SakumaDati.elektribaIeslegta = false;
        laiksCikIlgiElektribaBusIzslegta = 10;
      } 
      else {
        SakumaDati.elektribaIeslegta = true;
      }
    }
    // Novāc varoni.
    else if (komandasTeksts.equals("KILL") && pabeigtsKomTeksts) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("PASNAVIBA");
    }
    // Uzvar spēli.
    else if (komandasTeksts.equals("WIN") && pabeigtsKomTeksts) {
      Laiks.spelesLaiks = 1000;
    }
    else if (komandasTeksts.equals("H1") && pabeigtsKomTeksts) {
      Laiks.spelesLaiks = Laiks.vienaStunda - 1;
    } 
    else if (komandasTeksts.equals("H2") && pabeigtsKomTeksts) {
      Laiks.spelesLaiks = (Laiks.vienaStunda * 2) - 1;
    } 
    else if (komandasTeksts.equals("H3") && pabeigtsKomTeksts) {
      Laiks.spelesLaiks = (Laiks.vienaStunda * 3) - 1;
    } 
    else if (komandasTeksts.equals("H4") && pabeigtsKomTeksts) {
      Laiks.spelesLaiks = (Laiks.vienaStunda * 4) - 1;
    } 
    else if (komandasTeksts.equals("H5") && pabeigtsKomTeksts) {
      Laiks.spelesLaiks = (Laiks.vienaStunda * 5) - 1;
    } 
    else if (komandasTeksts.equals("MS") && pabeigtsKomTeksts) {
      MazoSpeluIzvelesKods.izslegtVisasMazasSpeles();
      MazoSpeluIzvelesKods.izveletaMazaSpele = false;
    } 
  }


  // * Darbības izsauktas pēc komandas:
  /// * Gultas darbības:
  public static void gultasPrieksasKomandas(String komanda) {
    if (komanda.equals(Iestatijumi.ietUzPrieksu)) {
      kustetiesPaMaju(KustibasVirziens.POZITIVS); ////////////////////////////////////////
    }
    else if (komanda.equals(Iestatijumi.izmantotGaismu)) {
      ieslegtIzslegtIstabasGaismu(Istabas.GULTA);
    }
  }

  public static void gultasLabasPusesKomandas(String komanda) {
    if (komanda.equals(Iestatijumi.ietUzPrieksu)) {
      kustetiesPaMaju(KustibasVirziens.NEGATIVS); ////////////////////////////////////////
    }
    else if (komanda.equals(Iestatijumi.izmantotObj)) {
      izslegtElektribu();
    }
  }

  public static void gultasLejasKomandas(String komanda) {
    // Kods:
  }

  public static void gultasKreisasPusesKomandas(String komanda , String komandasTeksts , boolean pabeigtsKomTeksts) {
    if (komandasTeksts.equals("LOGS") && pabeigtsKomTeksts) {
      aizbiedetLogaSpoku(Istabas.GULTA);
    }
  }

  /// * Dīvāna darbības:
  public static void divanaPrieksasKomandas(String komanda , String komandasTeksts , boolean pabeigtsKomTeksts) {
    if (komandasTeksts.equals("LOGS") && pabeigtsKomTeksts) {
      aizbiedetLogaSpoku(Istabas.DIVANS);
    }
  }

  public static void divanaLabasPusesKomandas(String komanda) {
    if (komanda.equals(Iestatijumi.ietUzPrieksu)) {
      kustetiesPaMaju(KustibasVirziens.POZITIVS); ////////////////////////////////////////
    }
    else if (komanda.equals(Iestatijumi.izmantotGaismu)) {
      ieslegtIzslegtIstabasGaismu(Istabas.DIVANS);
    }
  }

  public static void divanaLejasKomandas(String komanda) {
    if (komanda.equals(Iestatijumi.ietUzPrieksu)) {
      kustetiesPaMaju(KustibasVirziens.NEGATIVS); ////////////////////////////////////////
    }
    else if (komanda.equals(Iestatijumi.izmantotObj) && AtrodiPariSavienojums.mSpeleAtrodiPari) {
      Izvade.ieslegtMasivaIzvadi();
      MazoSpeluIzvelesKods.varonisIrMazajaSpele = true;
      TastaturasKlausitajs.nodzestCiklaKomandu();
      TastaturasKlausitajs.nodzestKomandasTekstu();
    }
  }

  public static void divanaKreisasPusesKomandas(String komanda) {
    // Kods:
  }

  /// * Durvju darbības:
  public static void durvjuPrieksasKomandas(String komanda , String komandasTeksts , boolean pabeigtsKomTeksts) {
    if (komandasTeksts.equals("LOGS") && pabeigtsKomTeksts) {
      aizbiedetLogaSpoku(Istabas.DURVIS);
    }
  }

  public static void durvjuLabasPusesKomandas(String komanda , String komandasTeksts , boolean pabeigtsKomTeksts) {
    if (komandasTeksts.equals("DURVIS") && pabeigtsKomTeksts) {
      aizbiedetDurvjuSpoku();
    }
    else if (komandasTeksts.equals("SLEGT") && pabeigtsKomTeksts && VeikalaKods.durvjuSledzis) {
      aizslegtDurvis();
    }
    else if (komanda.equals(Iestatijumi.izmantotObj) && KaratavasSavienojums.mSpeleKaratavas) {
      TastaturasKlausitajs.nodzestCiklaKomandu();
      Karatavas.palaistKaratavas();
    }
  }

  public static void durvjuLejasKomandas(String komanda) {
    if (komanda.equals(Iestatijumi.ietUzPrieksu)) {
      kustetiesPaMaju(KustibasVirziens.POZITIVS); ////////////////////////////////////////
    }
    else if (komanda.equals(Iestatijumi.izmantotGaismu)) {
      ieslegtIzslegtIstabasGaismu(Istabas.DURVIS);
    }
  }

  public static void durvjuKreisasPusesKomandas(String komanda) {
    if (komanda.equals(Iestatijumi.ietUzPrieksu)) {
      kustetiesPaMaju(KustibasVirziens.NEGATIVS); ////////////////////////////////////////
    }
  }

  /// * Virtuves darbības.
  public static void virtuvesPrieksasKomandas(String komanda) {
    if (komanda.equals(Iestatijumi.ietUzPrieksu)) {
      kustetiesPaMaju(KustibasVirziens.NEGATIVS); ////////////////////////////////////////
    }
  }

  public static void virtuvesLabasPusesKomandas(String komanda , String komandasTeksts , boolean pabeigtsKomTeksts) {
    if (komandasTeksts.equals("LOGS") && pabeigtsKomTeksts) {
      aizbiedetLogaSpoku(Istabas.VIRTUVE);
    }
  }

  public static void virtuvesLejasKomandas(String komanda) {
    // Ieslēgt izslēgt pagraba gaismu uz kom. 'G'.
    if (komanda.equals(Iestatijumi.izmantotGaismu)) {
      ieslegtIzslegtPagrabaGaismu();
    }
  }

  public static void virtuvesKreisaPuseKomandas(String komanda) {
    if (komanda.equals(Iestatijumi.ietUzPrieksu)) {
      kustetiesPaMaju(KustibasVirziens.POZITIVS); ////////////////////////////////////////
    }
    else if (komanda.equals(Iestatijumi.izmantotGaismu)) {
      ieslegtIzslegtIstabasGaismu(Istabas.VIRTUVE);
    }
  }
  



  // * Darbības kā metodes:
  /// Public:
  public static void izietAraNoMspeles(String komanda) {
    if (MazoSpeluIzvelesKods.varonisIrMazajaSpele) {
      if (komanda.equals(Iestatijumi.izietNoMD)) {
        MazoSpeluIzvelesKods.varonisIrMazajaSpele = false;
        Izvade.ieslegtSpelesIzvadi();
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
      Serkocini.serkocini.aizdedzinat();
    } 
    else {
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\failing-to-lit-matches.wav", 0);
    }
  }

  private static void ieslegtIzslegtIstabasGaismu(Istabas istaba) {
    // Ja ir ieslēgta elektrība, tad var aiztikt lampas/istabu gaismas.
    if (SakumaDati.elektribaIeslegta) {
      if (SakumaDati.istabuGaismasIeslegtas[istaba.CIPARS]) {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
        SakumaDati.istabuGaismasIeslegtas[istaba.CIPARS] = false;
      } 
      else {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
        SakumaDati.istabuGaismasIeslegtas[istaba.CIPARS] = true;
      }
    }
  }

  private static void izslegtElektribu() { // Kad izslēdz elektrību nosaka, kādi iestatījumi vai mainīgie mainās.
    SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
    aizbiedetVirtuvesSpoku();

    Arrays.fill(SakumaDati.istabuGaismasIeslegtas, false); // Visās istabās izslēdz gaismu.

    SakumaDati.elektribaIeslegta = false;
    laiksCikIlgiElektribaBusIzslegta = 3;
  }

  private static void ieslegtIzslegtMspelesInformaciju() {
    if (Main.mSpeluInfo) {
      Main.mSpeluInfo = false;
    } 
    else {
      Main.mSpeluInfo = true;
    }
  }

  private static void ieslegtIzslegtSpokuInformaciju() {
    if (Main.spokuInfo) {
      Main.spokuInfo = false;
    } 
    else {
      Main.spokuInfo = true;
    }
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
    if(!SakumaDati.spuldziteSaplesta) {
      if (SakumaDati.pagrabaGaisma) {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
        SakumaDati.pagrabaGaisma = false;
      }
      else {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
        SakumaDati.pagrabaGaisma = true;
      }
    }
  }

  private static void aizslegtDurvis() {
    if (!SakumaDati.durvisSlegtas && DurvjuSpoks.durvjuSpoks.getSpokaFazesIndekss() == 0) {
      SakumaDati.durvisSlegtas = true;
      DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    }
  }

  // * Laika threda metodes:
  public static void skaititCikIlgiLidzElektribasPieslegsanas() {
    // Skaita, cik ilgi līdz elektrības pieslēgšanas.
    if (!SakumaDati.elektribaIeslegta) { // Ja false, tad ...
      if (laiksCikIlgiElektribaBusIzslegta < 1) {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
        SakumaDati.elektribaIeslegta = true;
      }
      laiksCikIlgiElektribaBusIzslegta--;
    }
  }

  public static void skaititCikIlgiDegsSerkocins() {
    // * Metode skaita, cik ilgi līdz sērkociņš izdegs, un pēc tam izdzēš to.
    // Ja sērkociņš ir aizdedzināts un tagadējais degšanas laiks nav vienāds ar iestatījumos uzstādīto laiku, tad ...
    if (Serkocini.serkocini.getAizdedzinatsSerkocins() && serkocinaDeksanasLaikaSkaititajs != Serkocini.serkocini.getDegsanasLaiku()) {
      serkocinaDeksanasLaikaSkaititajs++;
    } 
    // Citādi ...
    else {
      Serkocini.serkocini.setAizdedzinatsSerkocins(false);
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

  public static void kamerasBaterijasAprekins() {
    if (VeikalaKods.izveletaFotokamera) {
      Fotokamera.fotokamera.baterijasAprekins();
    }
    else if (VeikalaKods.izveletaVideokamera) {
      Videokamera.videokamera.baterijasAprekins();
    }
  }
}