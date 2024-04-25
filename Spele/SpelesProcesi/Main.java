package Spele.SpelesProcesi;

import java.util.Random;

import Spele.K;
import Spele.Testi;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.KontaKods.Konts;
import Spele.Enums.EkranuVeidi;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.Parklajumi.BildesParklajumi;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.Spoki.Spoks;
import Spele.Varonis.DarbibuIzpilde;
import Spele.Varonis.VaronaStatusaEfekti;
import Spele.Veikals.Piederumi;

public class Main {
  // ? Mainīgie.
  
  // Informācijas booli.
  public static boolean spokuInfo;
  public static boolean mSpeluInfo;

  // Lai noteiktu darbības, kādā no programmas fāzēm.
  public static volatile boolean programmaPalaista = true; // booleans, kas palaiž visu programmu.
  
  public static boolean sakumaEkrans = true; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
  public static volatile boolean spelePalaista = false; // Mainīgais bool, kas pašu spēli.
 
  public static int spelesIlgums = 360;// 6 min 360;

  // Varoņa īpašības.
  public static boolean varonaNemirstiba = true; // Vai varonis var zaudēt spēli vai nē.
  
  // Objekti.
  public static Random rand = new Random(); // Priekš random darbībām.

  // Cits.
  public static volatile boolean laikaTredsGul; // Apstādina Laiks thredu uz noteiktu laiku.
  static boolean programmasKluduLasisana = false; // Apstādina 
  public static String ciklaKomanda = K.TUKSA_IEVADE; // Cikla komanda ir tā, kas tiks definēta cikla sākumā un nodzēsta cikla beigās, lai komanda visās pārbaudēs būtu vienāda.

  public static void main(String[] args) throws InterruptedException { // throws InterruptedException nozīmē, ka var neizmantot try_catch.
    // * Galvenais programmas process.

    // Dažādu metožu un ideju testēšana.
    if (Testi.testesana) {
      Testi.testaProgramma();
    }
    
    // Pieslēdz lietotāja kontu, un nolasa galvenos datus.
    if (Konts.atceretiesMani) {
      SakumaDati.nolasitDatusNoKonta();
    }
    else {
      // Ja nav konta, tad uzstāda parastās vērtības jeb datus.
      SakumaDati.spelesNakts = 1;
    }
    
    // ? /////// T H R E D I //////////
    // Jaunie rīki jeb thredi, jeb objekti.
    SkanasSpeletajs skanasSpeletajs = new SkanasSpeletajs();
    Izvade izvade = new Izvade();  

    // Sākas atsevišķās darbības jeb patstāvīgie procesi.
    skanasSpeletajs.start(); // Strādā, kamēr spelePalaista bools ir true.
    izvade.start();
    TastaturasKlausitajs.palaistKlaviaturasLasitaju();

    //#region
    // *P R O G R A M M A S   C I K L S* // 
    while (programmaPalaista) {
      nodzestTerminali();

      // *S Ā K U M A   E K R Ā N A   C I K L S* //
      Izvade.ieslegtMasivaIzvadi();
      while (sakumaEkrans) {
        TastaturasKlausitajs.komandasTekstaFunkcija();
        // 1. Apstrādā lietotāja ievadi.
        DarbibuIzpilde.izpilditSakumaEkranaDarbibas(TastaturasKlausitajs.komanda);
        // 2. Izvada bildi terminālī.
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.GALVENAIS_EKRANS);
        // 3. Notīra ievadi.
        TastaturasKlausitajs.nodzestKomandu();
      }
      Izvade.ieslegtSpelesIzvadi();
      
      // Nolasa iestatījumu datus.
      SakumaDati.sagatavotDatus();
      Spoks.izveidotSpokus();
      TastaturasKlausitajs.ieslegtKomandasTekstaFunkciju();
      Piederumi.definetKameru();

      // Thredi, kurus izmantos spēles laikā. Tie beidzas, kad (spelePalaista == false).
      Laiks laiks = new Laiks(); // Parastais threds.
      laiks.start(); 
      Thread blakusProcesi = new BlakusProcesi();
      blakusProcesi.start();
      //  = izveidotBlakusProcesuThredu(); // Virtuālais threds.  

      // *S P Ē L E S   C I K L S* //
      while (spelePalaista) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.
        // 1. Atļauj izmantot 'x' taustiņa funkc.
        TastaturasKlausitajs.komandasTekstaFunkcija();
        // 2. Definē mainīgo, kas tiks izmantots ciklā kā lietotāja nospiestais taustiņš.
        TastaturasKlausitajs.definetCiklaKomandu();
        // 3. Apstrādā lietotāja ievadi.
        DarbibuIzpilde.izpilditSpelesDarbibas(ciklaKomanda , TastaturasKlausitajs.komandasTeksts , TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu); // Pilnībā aizvieto 'VaronaDarbibas.apstradatKomandu(Ievade.lietotajaIevade);'.
        // 4. Izvade uz ekrānu jeb termināli.
        izvadesMasivuAtjaunosana();
        // 5. Pārbauda vai uzvarēja, vai zaudēja u.t.t.
        VaronaStatusaEfekti.parbauditEffektus(); // Varoņa bojāiešanas nosacījumi.
      }
      // Beidz jeb apstādina thredus.
      laiks.join();
      blakusProcesi.join();
      // blakusProcesuVThreds.join();
    }
    //#endregion
    skanasSpeletajs.join();
    izvade.join();
  }

  private static void izvadesMasivuAtjaunosana() {
    // Visām fāzēm, bildēm un visam vizuālajam ir jābūt gatavam pirms šīs metodes izsaukšanas!!!
    // Spoku vizuālais atjaunojums notiek Laiks.java Klasē.
    if (!MazoSpeluIzvelesKods.varonisIrMazajaSpele) {
      Izvade.istabasBilde = BildesParklajumi.parklataIstaba;
    }
    else {      
      if (KaratavasSavienojums.mSpeleKaratavas) {
        KaratavasSavienojums.palaistKaratavasMazoSpeli();
      }
      else if (AtrodiPariSavienojums.mSpeleAtrodiPari) {
        AtrodiPariSavienojums.palaistAtrodiPariMazoSpeli();
      }
    }
  }

  public static void nodzestTerminali() {
    System.out.print("\033[H\033[2J"); // Notīra terminālu.
    System.out.flush(); // Kaut kas ar kursora pozīciju.
  }

  // ! Priekš virtuālajiem thrediem ir vajadzīgs JDK 21.
  // private static Thread izveidotBlakusProcesuThredu() {
  //   // Izveido virtuālo tredu, kurš apstrādā visādus blakus procesus uz 0.1 sek. intervāla.
  //   return Thread.ofVirtual().start(() -> { // Virtuālais threds.  
  //     // Darbības, kas notiks threda dzīves laikā.
  //     while (Main.spelePalaista) {
  //       // 1. Novēro un maina kameras baterijas vērtības.
  //       VaronaDarbibas.kamerasBaterijasAprekins();
  //       // 2. Palielina varoņa stresu, ja viņš ir tumsā.
  //       VaronaStatusaEfekti.varonaStress();
  //       try { Thread.sleep(100); } catch (Exception e) {} // 0.1 sec.
  //     }
  //   });
  // }
}