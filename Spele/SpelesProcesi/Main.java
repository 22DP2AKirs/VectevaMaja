package Spele.SpelesProcesi;

import java.util.Random;

import Spele.Enums;
import Spele.IzvadeUzTerminalu;
import Spele.K;
import Spele.Testi;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.KontaKods.Konts;
import Spele.Enums.EkranuVeidi;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.Spoki.Spoks;
import Spele.Varonis.DarbibuIzpilde;
import Spele.Varonis.VaronaStatusaEfekti;

public class Main {
  // ? Mainīgie.

  // Informācijas booli.
  public static boolean spokuInfo;
  public static boolean mSpeluInfo;

  // Lai noteiktu darbības, kādā no programmas fāzēm.
  public static volatile boolean programmaPalaista = true; // booleans, kas palaiž visu programmu.
  public static boolean sakumaEkrans = true; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
  public static volatile boolean spelePalaista = true; // Mainīgais bool, kas pašu spēli.
 
  // Varoņa īpašības.
  public static boolean varonaNemirstiba = true; // Vai varonis var zaudēt spēli vai nē.
  
  // Objekti.
  public static Random rand = new Random(); // Priekš random darbībām.
  
  // Iestata tikšķa jeb 1 "refreša" periodu.
  public static int framesPerSecond = 1000 / 25; // Pēc cik ilga laika ekrāns "refrešojas". (Milisekundēs)
  public static int spelesIlgums = 60;// 6 min 360;
  
  // Cits.
  public static volatile boolean thrediGul; // Apstādina Laiks thredu uz noteiktu laiku.
  static boolean programmasKluduLasisana = false;

  public static void main(String[] args) throws InterruptedException { // throws InterruptedException nozīmē, ka var neizmantot try_catch.
    // * Galvenais programmas process.

    // Dažādu metožu un ideju testēšana.
    if (Testi.testesana) {
      Testi.testaProgramma();
    }
    
    // ? /////// T H R E D I //////////
    // Jaunie rīki jeb thredi, jeb objekti.
    Ievade ievadesLasitajs = new Ievade(); // Arī threads, bet šis lasa ievadi.
    SkanasSpeletajs skanasSpeletajs = new SkanasSpeletajs();
    // Sākas atsevišķās darbības jeb patstāvīgie procesi.
    skanasSpeletajs.start(); // Strādā, kamēr spelePalaista bools ir true.
    ievadesLasitajs.start(); // Strādā, kamēr programmaPalaista bools ir true.
    
    // Pieslēdz lietotāja kontu.
    if (Konts.atceretiesMani) {
      Konts.lietotajaKontaCels = FailuRedigetajs.stringDatuAtgriezejs("lietotajaKontaCels", K.SAKUMA_DATU_MAPE);
      Konts.lietotajsPiesledzies = true;
    }

    // * P R O G R A M M A S   C I K L S //
    while (programmaPalaista) {
      nodzestTerminali();
      // ? Nolasīt konta datus.
      IestatijumuDati.spelesNakts = FailuRedigetajs.intDatuAtgriezejs("spelesNakts", Konts.lietotajaKontaCels);
      

      // * ///// S A K U M A   E K R A N A   C I K L S //////
      while (sakumaEkrans) {
        // 1. Apstrādā lietotāja ievadi.
        DarbibuIzpilde.izpilditSakumaEkranaDarbibas(Ievade.lietotajaIevade);
        // 2. Izvada bildi terminālī.
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.GALVENAIS_EKRANS));
        // 3. Notīra ievadi.
        Ievade.notiritKomandu();
        // 4. 1 'freims' jeb cikls spēlē.
        Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 25 FPS.
      }

      // ? Nolasīt iestatījuma datus.
      IestatijumuDati.naktsDati = FailuRedigetajs.atgriestDaluNoFaila("#Nakts" + FailuRedigetajs.intDatuAtgriezejs("spelesNakts", Konts.lietotajaKontaCels), K.NAKTS_DATU_FAILS);
      IestatijumuDati.sagatavotDatusNaktij();


      // Izveido un izslēdz spokus (inicializē, lai pēc tam tos izmantotu spēlē).
      Spoks.izslegtSpokus(); 

      nodzestTerminali();
      Laiks laiks = new Laiks(); // Katru reizi, kad ir palaista spēle, veido jaunu Laika thredu.
      laiks.start(); // Strādā, kamēr spelePalaista bools ir true.

      // * ///// S P Ē L E S   C I K L S ///////
      while (spelePalaista) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.
        // 1. Apstrādā lietotāja ievadi.
        DarbibuIzpilde.izpilditSpelesDarbibas(Enums.V_Istaba, Enums.V_Virziens, Ievade.lietotajaIevade); // Pilnībā aizvieto 'VaronaDarbibas.apstradatKomandu(Ievade.lietotajaIevade);'.
        // 2. Papildus informācijas izvade --Debuging--
        informacijasIzvade();
        // 3. Izvade uz ekrānu jeb termināli.
        izvaditBildiUzEkranu();
        // 4. Varoņa zaudēšanas nosacījumu pārbaude.
        VaronaStatusaEfekti.varonaStress();
        VaronaStatusaEfekti.parbauditEffektus(); // Varoņa bojāiešanas nosacījumi.
        // 5. Notīra ievadi.
        Ievade.notiritKomandu();
        // 6. 1 'freims' spēlē.
        Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 25 FPS.
        // ------------------ Papildus.
        if (programmasKluduLasisana) { // Apstādina spēli, lai varētu izlasīt kļūdas aprakstu (parasti vienmēr izslēgts).
          Thread.sleep(100000);
        }
      }

      nodzestTerminali();
      // * /// L I E K   T H R E D I E M   B E I G T I E S ///////
      laiks.join(); // wait for the thread to stop // Apstādina Laika thredu un izveido jaunu, kad palaiž spēli no jauna.
      
    }
    skanasSpeletajs.join();
    ievadesLasitajs.join();
  }

  private static void izvaditBildiUzEkranu() {
    // Visām fāzēm, bildēm un visam vizuālajam ir jābūt gatavam pirms šīs metodes izsaukšanas!!!
    // Spoku vizuālais atjaunojums notiek Laiks.java Klasē.
    if (!MazoSpeluIzvelesKods.varonisIrMazajaSpele) {
      IzvadeUzTerminalu.salipinataUIIzvade(); // Izvade uz ekrāna.
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