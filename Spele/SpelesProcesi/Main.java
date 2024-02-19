package Spele.SpelesProcesi;

import java.util.Random;

import Spele.IzvadeUzTerminalu;
import Spele.K;
import Spele.Spoki;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Izskati.EkranuIzskati;
import Spele.Izskati.EkranuIzskati.EkranuVeidi;
import Spele.MazasSpeles.Karatavas.SavienotaisKaratavuKods;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;

public class Main {
  // ? Mainīgie.

  // Informācijas booli.
  public static boolean spokuInfo;
  public static boolean mSpeluInfo;

  // Lai noteiktu darbības, kādā no programmas fāzēm.
  public static volatile boolean programmaPalaista = true; // booleans, kas palaiž visu programmu.
  public static boolean mainMenu = false; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
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
  public static boolean varonaNemirstiba = true; // Vai varonis var zaudēt spēli vai nē.
  static boolean kluduLasisana = false;
  

  // Spelētāja pozīcija.
  public static int varonaIstabasSkaitlis = 2; // 0, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas.
  public static int varonaVirzienaSkaitlis = 1;
  
  // Objekti.
  public static Random rand = new Random(); // Priekš random darbībām.

  // Iestata tikšķa jeb 1 "refreša" periodu.
  static int framesPerSecond = 1000 / 25; // Pēc cik ilga laika ekrāns "refrešojas". (Milisekundēs)
  public static int spelesIlgums = 100;// 6 min 360;
  
  // Cits.
  static String[] visiVaronaUzdevumi = {"Pildit majasdarbus", "Est", "Mazgat", "Kartot", "Lasit", "Tirit"}; // TODO: Izmantot vai pārveidot.
  public static volatile boolean thrediGul; // Apstādina Laiks thredu uz noteiktu laiku.

  public static void main(String[] args) throws InterruptedException { // throws InterruptedException nozīmē, ka var neizmantot try_catch.
    // * Galvenais programmas process.

    // Testi.testaProgramma();

    // ? /////// T H R E D I //////////
    // Jaunie rīki jeb thredi jeb objekti.
    Ievade ievadesLasitajs = new Ievade(); // Arī threads, bet šis lasa ievadi.
    SkanasSpeletajs skanasSpeletajs = new SkanasSpeletajs();

    // Sākas atsevišķās darbības jeb patstāvīgie procesi.
    skanasSpeletajs.start(); // Strādā, kamēr spelePalaista bools ir true.
    ievadesLasitajs.start(); // Strādā, kamēr programmaPalaista bools ir true.

    // * P R O G R A M M A S   C I K L S //
    while (programmaPalaista) {
      tiritEkranu();

      // * ///// S A K U M A   E K R A N A   C I K L S //////
      while (mainMenu) {
        VaronaDarbibas.varonaDarbibas(Ievade.ievade);
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[0], EkranuVeidi.GALVENAIS_EKRANS));

        Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 25 FPS.
      }

      tiritEkranu();
      Laiks laiks = new Laiks(); // Katru reizi, kad ir palaista spēle, veido jaunu Laika thredu.
      laiks.start(); // Strādā, kamēr spelePalaista bools ir true.

      // * ///// S P Ē L E S   C I K L S ///////
      while (spelePalaista) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.

        VaronaDarbibas.varonaDarbibas(Ievade.ievade); // Lietotāja jeb varoņa ievade un tās darbības (komandas un to darbības).
        VaronaStatusaEfekti.varonaStress();

        
        informacijasIzvade(); // Spoku informācijas izvade. --Debuging--

        // Visām fāzēm, bildēm un visam vizuālajam ir jābūt gatavam pirms šīs metodes izsaukšanas!!!
        // Spoku vizuālais atjaunojums notiek Laiks.java Klasē.
        if (!varonisIrMazajaSpele) {
          IzvadeUzTerminalu.salipinataUIIzvade(); // Izvade uz ekrāna.
        }
        else {
          SavienotaisKaratavuKods.karatavuKods();
        }

        Ievade.notiritIevadi(); // Cikla beigās notīra Ievadi, jo visas matodes, kurām tā bija vajadzīga jau to ir paņēmušas.
        VaronaStatusaEfekti.parbauditEffektus(); // Varoņa bojāiešanas nosacījumi.

        Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 25 FPS.
        if (kluduLasisana) { // Apstādina spēli, lai varētu izlasīt kļūdas aprakstu.
          Thread.sleep(100000);
        }
      }

      tiritEkranu();
      laiks.join(); // wait for the thread to stop // Apstādina Laika thredu un izveido jaunu, kad palaiž spēli no jauna.
    }
    // * /// L I E K   T H R E D I E M   B E I G T I E S ///////
    skanasSpeletajs.join();
    ievadesLasitajs.join();
  }

  private static void informacijasIzvade() {
    // * Metode ievāc info. kategoriju, kuru izvadīt virs ekrana.
    // * Testeru metode.

    // Izvada informāciju par spokiem.
    if (Main.spokuInfo) { 
      Spoki.spokuInformacijasIzvade();
    }
    // Izvada informāciju par m-spēlēm.
    else if (Main.mSpeluInfo) {
      izvaditMSpelesInfo();
    }
  }

  private static void izvaditMSpelesInfo() {
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("Ieksa m-spele: " + Main.varonisIrMazajaSpele + ", Izveleta m-spele: " + Main.izveletaMazaSpele + "\033[0K");
    System.out.println("Izveleta spele: Karatavas: " + Main.karatavas + ", Atrodi pari: " + "\033[0K");
    
    System.out.println("Laiks ms: " + Laiks.spelesLaiks + " / " + Laiks.vienaStunda * 6 + K.RESET + ", Stressa limenis: " + VaronaStatusaEfekti.varonaStresaLimenis + "\033[0K");
  }

  public static void tiritEkranu() {
    System.out.print("\033[H\033[2J"); // Notīra terminālu.
    System.out.flush(); // Kaut kas ar kursora pozīciju.
  }
}