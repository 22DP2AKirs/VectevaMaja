package Spele.SpelesProcesi;

import java.util.Random;

import Spele.Enums;
import Spele.K;
import Spele.PaligMetodes;
import Spele.Testi;
import Spele.FailuLietotaji.FailuRedigetajs;
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
import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;

public class Main {
  // ? Mainīgie.

  // Informācijas booli.
  public static boolean spokuInfo;
  public static boolean mSpeluInfo;

  // Lai noteiktu darbības, kādā no programmas fāzēm.
  public static volatile boolean programmaPalaista = true; // booleans, kas palaiž visu programmu.
  
  public static boolean sakumaEkrans = true; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
  public static volatile boolean spelePalaista = false; // Mainīgais bool, kas pašu spēli.
 
  // Varoņa īpašības.
  public static boolean varonaNemirstiba = true; // Vai varonis var zaudēt spēli vai nē.
  
  // Objekti.
  public static Random rand = new Random(); // Priekš random darbībām.

  public static int spelesIlgums = 360;// 6 min 360;
  
  // Cits.
  public static volatile boolean thrediGul; // Apstādina Laiks thredu uz noteiktu laiku.
  static boolean programmasKluduLasisana = false;
  public static String ciklaKomanda; // Cikla komanda ir tā, kas tiks definēta cikla sākumā un nodzēsta cikla beigās, lai komanda visās pārbaudēs būtu vienāda.


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

    // * P R O G R A M M A S   C I K L S //
    while (programmaPalaista) {
      nodzestTerminali();

      // * ///// S A K U M A   E K R A N A   C I K L S //////
      Izvade.jaizvadaMasivs = true;
      while (sakumaEkrans) {
        TastaturasKlausitajs.komandasTekstaFunkcija();
        // 1. Apstrādā lietotāja ievadi.
        DarbibuIzpilde.izpilditSakumaEkranaDarbibas(TastaturasKlausitajs.komanda);
        // 2. Izvada bildi terminālī.
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.GALVENAIS_EKRANS);
        // 3. Notīra ievadi.
        TastaturasKlausitajs.nodzestKomandu();
      }
      Izvade.jaizvadaMasivs = false;
      
      // ? Nolasa iestatījumu datus.
      SakumaDati.naktsDati = FailuRedigetajs.atgriestDaluNoFaila("#Nakts" + SakumaDati.spelesNakts, K.NAKTS_DATU_FAILS);
      SakumaDati.sagatavotDatusNaktij();
      SakumaDati.sagatavotDatus();
      Spoks.izveidotSpokus(); 
      TastaturasKlausitajs.ieslegtKomandasTekstaFunkciju();


      nodzestTerminali();
      Laiks laiks = new Laiks(); // Katru reizi, kad ir palaista spēle, veido jaunu Laika thredu.
      laiks.start(); // Strādā, kamēr spelePalaista bools ir true.

      // * ///// S P Ē L E S   C I K L S ///////
      while (spelePalaista) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.
        // 0. Atļauj izmantot 'x' taustiņa funkc.
        TastaturasKlausitajs.komandasTekstaFunkcija();

        TastaturasKlausitajs.definetCiklaKomandu();

        // 1. Apstrādā lietotāja ievadi.
        DarbibuIzpilde.izpilditSpelesDarbibas(Enums.V_Istaba, Enums.V_Virziens, ciklaKomanda , TastaturasKlausitajs.komandasTeksts); // Pilnībā aizvieto 'VaronaDarbibas.apstradatKomandu(Ievade.lietotajaIevade);'.
        // 2. Papildus informācijas izvade --Debuging--
        informacijasIzvade();
        // 3. Izvade uz ekrānu jeb termināli.
        izvaditBildiUzEkranu();
        // 4. Varoņa zaudēšanas nosacījumu pārbaude.
        VaronaStatusaEfekti.varonaStress();
        VaronaDarbibas.kamerasBaterijasAprekins();
        
        VaronaStatusaEfekti.parbauditEffektus(); // Varoņa bojāiešanas nosacījumi.
        // 5. Notīra ievadi.
        // ------------------ Papildus.
        if (programmasKluduLasisana) { // Apstādina spēli, lai varētu izlasīt kļūdas aprakstu (parasti vienmēr izslēgts).
          PaligMetodes.gulet(100);
        }
      }

      nodzestTerminali();
      // * /// L I E K   T H R E D I E M   B E I G T I E S ///////
      laiks.join(); // wait for the thread to stop // Apstādina Laika thredu un izveido jaunu, kad palaiž spēli no jauna.
      
    }
    skanasSpeletajs.join();
    izvade.join();
    // ievadesLasitajs.join();
  }

  private static void izvaditBildiUzEkranu() {
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

  private static void informacijasIzvade() {
    // * Metode ievāc info. kategoriju, kuru izvadīt virs ekrana.
    // * Testeru metode.

    // Izvada informāciju par spokiem.
    if (Main.spokuInfo) { 
      Spoks.spokuInfo();
      izvaditSpelesPapildinformaciju();
    }
    // Izvada informāciju par m-spēlēm.
    else if (Main.mSpeluInfo) {
      izvaditMSpelesInfo();
    }
  }

  private static void izvaditMSpelesInfo() {
    System.out.println();
    System.out.println("Ieksa m-spele: " + MazoSpeluIzvelesKods.varonisIrMazajaSpele + ", Izveleta m-spele: " + MazoSpeluIzvelesKods.izveletaMazaSpele + "\033[0K");
    System.out.println("Izveleta spele: (Karatavas : " + KaratavasSavienojums.mSpeleKaratavas + "), (Atrodi pari : " + AtrodiPariSavienojums.mSpeleAtrodiPari + ")\033[0K");
    izvaditSpelesPapildinformaciju();
  }

  private static void izvaditSpelesPapildinformaciju() {
    System.out.println("Laiks ms: " + Laiks.spelesLaiks + " / " + Laiks.vienaStunda * 6 + K.RESET + ", Stressa limenis: " + VaronaStatusaEfekti.varonaStresaLimenis + "\033[0K");
  }

  public static void nodzestTerminali() {
    System.out.print("\033[H\033[2J"); // Notīra terminālu.
    System.out.flush(); // Kaut kas ar kursora pozīciju.
  }
}