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
import Spele.MazasSpeles.SamaisitieVardi.SMSavienojums;
import Spele.Parklajumi.BildesParklajumi;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.Varonis.DarbibuIzpilde;
import Spele.Varonis.VaronaStatusaEfekti;
import Spele.Veikals.Piederumi;

public class Main {
  // ? Mainīgie.
  
  // Informācijas booli.
  public static boolean spokuInfo, mSpeluInfo;

  // Lai noteiktu darbības, kādā no programmas fāzēm.
  public static volatile boolean programmaPalaista = true, spelePalaista = false; // booleans, kas palaiž visu programmu.
  public static boolean sakumaEkrans = true; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
 

  // Varoņa īpašības.
  public static boolean varonaNemirstiba = true; // Vai varonis var zaudēt spēli vai nē.
  
  // Objekti.
  public static Random rand = new Random(); // Priekš random darbībām.

  // Cits.
  static boolean programmasKluduLasisana = false; // Apstādina 
  public static String ciklaKomanda = K.TUKSA_IEVADE; // Cikla komanda ir tā, kas tiks definēta cikla sākumā un nodzēsta cikla beigās, lai komanda visās pārbaudēs būtu vienāda.

  // ? /////// T H R E D I //////////
  private static SkanasSpeletajs skanasSpeletajs;
  private static Izvade izvade;
  private static Laiks laiks;
  private static BlakusProcesi blakusProcesi;
 
  public static void main(String[] args) throws InterruptedException { // throws InterruptedException nozīmē, ka var neizmantot try_catch.
    // * Galvenais programmas process.

    // Dažādu metožu un ideju testēšana.
    if (Testi.testesana) {
      Testi.testaProgramma();
    }

    // Pieslēdz lietotāja kontu, un nolasa galvenos datus.
    if (Konts.atceretiesMani) {
      SakumaDati.nolasitDatusNoKonta();
      Piederumi.atjaunotPiederumus(); // Atjauno, lai, kad sāk spēli, būtu atjaunināti uz maxLīmeni.
    }
    else {
      // Ja nav konta, tad uzstāda parastās vērtības jeb datus.
      SakumaDati.uzstaditSpeliUzNoklusejumaDatiem();
    }
    
    palaistProgrammasThredus();

    //#region
    // *P R O G R A M M A S   C I K L S* // 
    while (programmaPalaista) {
      nodzestTerminali();
      Izvade.ieslegtMasivaIzvadi();

      // *S Ā K U M A   E K R Ā N A   C I K L S* //
      while (sakumaEkrans) {
        // 1. Atļauj rakstīt tekstu.
        TastaturasKlausitajs.komandasTekstaFunkcija();
        // 2. Apstrādā lietotāja ievadi.
        DarbibuIzpilde.izpilditSakumaEkranaDarbibas(TastaturasKlausitajs.komanda);
        // 3. Izvada bildi terminālī.
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.SAKUMA);
      }
      
      // Sagatavo datus līmenim.
      Izvade.ieslegtSpelesIzvadi();
      SakumaDati.sagatavotSpelesDatus();
      TastaturasKlausitajs.ieslegtKomandasTekstaFunkciju();
      palaistSpelesThredus();

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
      else if (SMSavienojums.MDSamaisitieVardi) {
        SMSavienojums.palaistSamaisitosVardus();
      }
    }
  }

  private static void palaistSpelesThredus() {
    // Thredi, kurus izmantos spēles laikā. Tie beidzas, kad (spelePalaista == false).
    // 1. Izveido thredus.
    laiks = new Laiks();
    blakusProcesi = new BlakusProcesi();
    // 2. Palaiž thredus.
    laiks.start(); 
    blakusProcesi.start();
  }

  private static void palaistProgrammasThredus() {
    // 1. Izveido jaunos programmas procesus (Thredus).
    skanasSpeletajs = new SkanasSpeletajs();
    izvade = new Izvade();  

    // 2. Palaiž izveidotos processus.
    skanasSpeletajs.start(); // Strādā, kamēr spelePalaista bools ir true.
    izvade.start();

    // 3. Pieslēdz klaviatūras lasītāju (lai iegūtu momentālu taustiņu ievadi).
    TastaturasKlausitajs.palaistKlaviaturasLasitaju();
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