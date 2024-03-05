package Spele.SpelesProcesi;

import java.util.Random;

import Spele.Enums;
import Spele.IzvadeUzTerminalu;
import Spele.K;
import Spele.Testi;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Izskati.EkranuIzskati;
import Spele.Enums.EkranuVeidi;
import Spele.MazasSpeles.Karatavas.SavienotaisKaratavuKods;
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
  public static boolean sakumaEkrans = false; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
  public static volatile boolean spelePalaista = true; // Mainīgais bool, kas pašu spēli.

  // Priekš minigames.
  public static volatile boolean varonisIrMazajaSpele; // true, ja varonis ir iegājis mazajā spēlē, false, ja nav.
  public static volatile boolean izveletaMazaSpele; // true, ja spēle izvēlējās, kādu no iespējamajām spēlēm, katru stundu. 

  // Priekš karātaām.
  public static String[] rAtstarpes = new String[17];
  public static String karatavasVards;

  public static boolean karatavas;
  public static boolean mazasSpelesRezultataParskats = false;

  // Varoņa īpašības.
  public static boolean varonaNemirstiba = false; // Vai varonis var zaudēt spēli vai nē.
  
  // Objekti.
  public static Random rand = new Random(); // Priekš random darbībām.
  
  // Iestata tikšķa jeb 1 "refreša" periodu.
  static int framesPerSecond = 1000 / 25; // Pēc cik ilga laika ekrāns "refrešojas". (Milisekundēs)
  public static int spelesIlgums = 100;// 6 min 360;
  
  // Cits.
  public static volatile boolean thrediGul; // Apstādina Laiks thredu uz noteiktu laiku.
  static boolean programmasKluduLasisana = false;

  public static void main(String[] args) throws InterruptedException { // throws InterruptedException nozīmē, ka var neizmantot try_catch.
    // * Galvenais programmas process.

    Testi.testaProgramma();

    // ? /////// T H R E D I //////////
    // Jaunie rīki jeb thredi, jeb objekti.
    Ievade ievadesLasitajs = new Ievade(); // Arī threads, bet šis lasa ievadi.
    SkanasSpeletajs skanasSpeletajs = new SkanasSpeletajs();

    // Sākas atsevišķās darbības jeb patstāvīgie procesi.
    skanasSpeletajs.start(); // Strādā, kamēr spelePalaista bools ir true.
    ievadesLasitajs.start(); // Strādā, kamēr programmaPalaista bools ir true.
    
    // Izveido un izslēdz spokus (inicializē, lai pēc tam tos izmantotu spēlē).
    Spoks.izslegtSpokus(); 

    // * P R O G R A M M A S   C I K L S //
    while (programmaPalaista) {
      nodzestTerminali();

      // * ///// S A K U M A   E K R A N A   C I K L S //////
      while (sakumaEkrans) {
        // ------------------ Apstrādā lietotāja ievadi.
        DarbibuIzpilde.izpilditSakumaEkranaDarbibas(Ievade.lietotajaIevade);
        // ------------------ Izvada bildi terminālī.
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[0], EkranuVeidi.GALVENAIS_EKRANS));
        // ------------------ Notīra ievadi.
        Ievade.notiritIevadi();
        // ------------------ 1 'freims' jeb cikls spēlē.
        Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 25 FPS.
      }

      nodzestTerminali();
      Laiks laiks = new Laiks(); // Katru reizi, kad ir palaista spēle, veido jaunu Laika thredu.
      laiks.start(); // Strādā, kamēr spelePalaista bools ir true.

      // * ///// S P Ē L E S   C I K L S ///////
      while (spelePalaista) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.
        // ------------------ Apstrādā lietotāja ievadi.
        // Enums.mainitIstabasUnVirzienaEnumus(); // * Jāmaina pozīcija!!!
        DarbibuIzpilde.izpilditSpelesDarbibas(Enums.V_Istaba, Enums.V_Virziens, Ievade.lietotajaIevade); // Pilnībā aizvieto 'VaronaDarbibas.apstradatKomandu(Ievade.lietotajaIevade);'.
        // ------------------ Papildus informācijas izvade --Debuging--
        informacijasIzvade();
        // ------------------ Izvade uz ekrānu jeb termināli.
        izvaditBildiUzEkranu();
        // ------------------ Varoņa zaudēšanas nosacījumu pārbaude.
        VaronaStatusaEfekti.varonaStress();
        VaronaStatusaEfekti.parbauditEffektus(); // Varoņa bojāiešanas nosacījumi.
        // ------------------ Notīra ievadi.
        Ievade.notiritIevadi();
        // ------------------ 1 'freims' spēlē.
        Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 25 FPS.
        if (programmasKluduLasisana) { // Apstādina spēli, lai varētu izlasīt kļūdas aprakstu.
          Thread.sleep(100000);
        }
      }

      nodzestTerminali();
      laiks.join(); // wait for the thread to stop // Apstādina Laika thredu un izveido jaunu, kad palaiž spēli no jauna.
    }
    // * /// L I E K   T H R E D I E M   B E I G T I E S ///////
    skanasSpeletajs.join();
    ievadesLasitajs.join();
  }

  private static void izvaditBildiUzEkranu() {
    // Visām fāzēm, bildēm un visam vizuālajam ir jābūt gatavam pirms šīs metodes izsaukšanas!!!
    // Spoku vizuālais atjaunojums notiek Laiks.java Klasē.
    if (!varonisIrMazajaSpele) {
      IzvadeUzTerminalu.salipinataUIIzvade(); // Izvade uz ekrāna.
    }
    else {
      SavienotaisKaratavuKods.karatavuKods();
    }
  }

  private static void informacijasIzvade() {
    // * Metode ievāc info. kategoriju, kuru izvadīt virs ekrana.
    // * Testeru metode.

    // Izvada informāciju par spokiem.
    if (Main.spokuInfo) { 
      Spoks.spokuInfo();
      System.out.println("Laiks ms: " + Laiks.spelesLaiks + " / " + Laiks.vienaStunda * 6 + K.RESET + ", Stressa limenis: " + VaronaStatusaEfekti.varonaStresaLimenis + "\033[0K");
    }
    // Izvada informāciju par m-spēlēm.
    else if (Main.mSpeluInfo) {
      izvaditMSpelesInfo();
    }
  }

  private static void izvaditMSpelesInfo() {
    System.out.println();
    System.out.println("Ieksa m-spele: " + Main.varonisIrMazajaSpele + ", Izveleta m-spele: " + Main.izveletaMazaSpele + "\033[0K");
    System.out.println("Izveleta spele: Karatavas: " + Main.karatavas + ", Atrodi pari: " + "\033[0K");
    System.out.println("Laiks ms: " + Laiks.spelesLaiks + " / " + Laiks.vienaStunda * 6 + K.RESET + ", Stressa limenis: " + VaronaStatusaEfekti.varonaStresaLimenis + "\033[0K");
  }

  public static void nodzestTerminali() {
    System.out.print("\033[H\033[2J"); // Notīra terminālu.
    System.out.flush(); // Kaut kas ar kursora pozīciju.
  }
}