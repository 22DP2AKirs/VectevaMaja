package Spele.SpelesProcesi;

import java.util.Random;

import Spele.IzvadeUzTerminalu;
import Spele.Spoki;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Izskati.EkranuIzskati;
import Spele.Izskati.EkranuIzskati.EkranuVeidi;
import Spele.MazasSpeles.Karatavas;
import Spele.MazasSpeles.MazoSpeluPalaisanasKods;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;

public class Main {
  // ? Mainīgie.

  // Lai noteiktu darbības, kādā no programmas fāzēm.
  public static volatile boolean programmaPalaista = true; // booleans, kas palaiž visu programmu.
  public static boolean mainMenu = false; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
  public static volatile boolean spelePalaista = true; // Mainīgais bool, kas pašu spēli.

  // Priekš minigames.
  public static boolean varonisIrMazajaSpele; // true, ja varonis ir iegājis mazajā spēlē, false, ja nav.

  // Priekš karātaām.
  public static String[] rAtstarpes = new String[17];
  public static String karatavasVards;

  public static boolean karatavas;
  public static boolean mazasSpelesRezultataParskats = false;

  // Varoņa īpašības.
  public static boolean varonaNemirstiba = true; // Vai varonis var zaudēt spēli vai nē.
  static boolean kluduLasisana = false;
  public static boolean varonisDzivs = true;

  // Spelētāja pozīcija.
  public static int varonaIstabasSkaitlis = 2; // 0, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas.
  public static int varonaVirzienaSkaitlis = 1;
  
  // Objekti.
  public static Random rand = new Random(); // Priekš random darbībām.

  // Iestata tikšķa jeb 1 "refreša" periodu.
  static int framesPerSecond = 1000 / 25; // Pēc cik ilga laika ekrāns "refrešojas". (Milisekundēs)
  public static int spelesIlgums = 360;// 6 min 360;
  
  // Cits.
  static String[] visiVaronaUzdevumi = {"Pildit majasdarbus", "Est", "Mazgat", "Kartot", "Lasit", "Tirit"}; // TODO: Izmantot vai pārveidot.

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

    // * Palaiž programmu.
    while (programmaPalaista) {
      tiritEkranu();

      // * ////////////////////////////////////////////////////// S P Ē L E S   I Z V Ē L N E (M A I N   M E N U)//////////////////////////////////////////////////////
      while (mainMenu) {
        VaronaDarbibas.varonaDarbibas(Ievade.ievade);
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[0], EkranuVeidi.GALVENAIS_EKRANS));

        // Vienas bildes izvade jeb beigas.
        Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 30 FPS.
      }

      tiritEkranu();
      Laiks laiks = new Laiks(); // Katru reizi, kad ir palaista spēle, veido jaunu Laika thredu.
      laiks.start(); // Strādā, kamēr spelePalaista bools ir true.

      MazoSpeluPalaisanasKods.izveidotJaunuKaratavasSpeli();

      // * /////////////////////////////////////////// S Ā K A S   S P Ē L E S   K O D S (G A M E   C O D E) //////////////////////////////////////////////////////////////////////////////
      while (spelePalaista) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.

        VaronaDarbibas.varonaDarbibas(Ievade.ievade); // Lietotāja jeb varoņa ievade un tās darbības (komandas un to darbības).
        VaronaStatusaEfekti.varonaStress();

        // Spoku informācijas izvade. --Debuging--
        if (Spoki.spokuInfoIzvadeBoolean) {
          Spoki.spokuInformacijasIzvade();
        }

        // Visām fāzēm, bildēm un visam vizuālajam ir jābūt gatavam pirms šīs metodes izsaukšanas!!!
        // Spoku vizuālais atjaunojums notiek Laiks.java Klasē.
        if (!varonisIrMazajaSpele) {
          IzvadeUzTerminalu.salipinataUIIzvade(); // Izvade uz ekrāna.
        }
        else {
          MazoSpeluPalaisanasKods.karatavuKods();
        }

        Ievade.notiritIevadi(); // Cikla beigās notīra Ievadi, jo visas matodes, kurām tā bija vajadzīga jau to ir paņēmušas.

        // ? Varoņa bojāiešanas nosacījumi.
        // Ja varona stresa līmenis pārsniedz 100.
        if (VaronaStatusaEfekti.varonaStresaLimenis > 100.0) {
          VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("STRESS");
        }
        // Ja zaudē karātavas.
        else if (Karatavas.karatavuKluduSkaits > 7) {
          VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("KARATAVAS");
        }

        Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 30 FPS.
        
        if (kluduLasisana) { // Apstādina spēli, lai varētu izlasīt kļūdas aprakstu.
          Thread.sleep(100000);
        }
      }

      tiritEkranu();

      if (varonisDzivs) {
        // * Uzvaras ekrāns.
        
      }
      else {
        // * Zaudēšanas ekrāns.
        IzvadeUzTerminalu.masivuIzvade(EkranuIzskati.visiEkrani[2]);
        Thread.sleep(5000); // 5 sek.
      }

      // Apstādina Laika thredu un izveido jaunu, kad palaiž spēli no jauna.
      laiks.join(); // wait for the thread to stop
      Laiks.spelesLaiks = 0; // Lai laika threads momentāli neapstātos pēc tā pališanas, atjauno spēles laiku.
      mainMenu = true;
      varonisDzivs = true;
    }
    //* ///////////////////// L I E K   T H R E D I E M   B E I G T I E S /////////////////////////
    skanasSpeletajs.join();
    ievadesLasitajs.join();
  }

  public static void tiritEkranu() {
    System.out.print("\033[H\033[2J"); // Notīra terminālu.
    System.out.flush(); // Kaut kas ar kursora pozīciju.
  }
}