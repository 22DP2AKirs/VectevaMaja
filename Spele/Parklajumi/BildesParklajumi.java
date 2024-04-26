package Spele.Parklajumi;
import java.util.Arrays;

import Spele.Enums;
import Spele.K;
import Spele.PaligMetodes;
import Spele.Izskati.IstabuIzskati;
import Spele.Izskati.SpokuIzskati;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.VirtuvesSpoks;
import Spele.Veikals.Piederumi;
import Spele.Veikals.Serkocini;

// * Pārklāj bildes.
public class BildesParklajumi {


  public static String[] parklataIstaba = IstabuIzskati.istabuMasivs[Enums.V_Istaba.CIPARS][Enums.V_Virziens.CIPARS];

  public static void atjaunotParklatoIstabu(String[] parklataisMasivs) {
    parklataIstaba = parklataisMasivs;
  }

  public static String[] izveidotMainamoMasivu(String[] originalaisMasivs) {
    // Parametra masīva vērtību pārkopēšana un jauna masīva, lai nebojātu masīvu, kas ir sniegts kā parametrs.
    // kopija - drīkst mainīt, oriģinālā - NEDRĪKST MAINĪT.
    String[] varonaIstabasKopija = Arrays.copyOf(originalaisMasivs, originalaisMasivs.length); // Masīva elementu pārkopēšana. copyOf(kopējamaisMasīvs, cik elementus no masīva nokopēts)
    return varonaIstabasKopija;
  }

  /// Gultas pārklājumi:
  public static void uzliktGultasPrieksasParklajumus(String[] mainamaisMasivs) {
    uzliktGultasPrieksasApgaismojumaParklajumus(mainamaisMasivs);
  }

  public static void uzliktGultasLabasPusesParklajumus(String[] mainamaisMasivs) {
    uzliktGultasLabasPusesApgaismojumaParklajumus(mainamaisMasivs);
    uzliktElektriskoPaneli(mainamaisMasivs);
  }

  public static void uzliktGultasLejasParklajumus(String[] mainamaisMasivs) {
    uzliktGultasLejasApgaismojumaParklajumus(mainamaisMasivs);
  }

  public static void uzliktGultasKreisasPusesParklajumus(String[] mainamaisMasivs) {
    uzliktGultasKreisasPusesApgaismojumaParklajumus(mainamaisMasivs);
    uzliktGultasLogaSpParklajumu(mainamaisMasivs);
  }

  /// Dīvāna pārklājumi:
  public static void uzliktDivanaPrieksasParklajumus(String[] mainamaisMasivs) {
    uzliktDivanaPrieksasApgaismojumaParklajumus(mainamaisMasivs);
    uzliktDivanaLogaSpParklajumu(mainamaisMasivs);
  }

  public static void uzliktDivanaLabasPusesParklajumus(String[] mainamaisMasivs) {
    uzliktDivanaLabasPusesApgaismojumaParklajumus(mainamaisMasivs);
  }

  public static void uzliktDivanaLejasParklajumus(String[] mainamaisMasivs) {
    uzliktDivanaLejasApgaismojumaParklajumus(mainamaisMasivs);
    uzliktAtrodiPariKasti(mainamaisMasivs);
  }

  public static void uzliktDivanaKreisasPusesParklajumus(String[] mainamaisMasivs) {
    uzliktDivanaKreisasPusesApgaismojumaParklajumus(mainamaisMasivs);
  }

  /// Durvju pārklājumi:
  public static void uzliktDurvjuPrieksasParklajumus(String[] mainamaisMasivs) {
    uzliktDurvjuPrieksasApgaismojumaParklajumus(mainamaisMasivs);
    uzliktDurvjuLogaSpParklajumu(mainamaisMasivs);
  }

  public static void uzliktDurvjuLabasPusesParklajumus(String[] mainamaisMasivs) {
    uzliktDurvjuLabasPusesApgaismojumaParklajumus(mainamaisMasivs);
    uzliktDurvjuSpParklajumu(mainamaisMasivs);
    uzliktKaratavuGramatu(mainamaisMasivs);
  }

  public static void uzliktDurvjuLejasParklajumus(String[] mainamaisMasivs) {
    uzliktDurvjuLejasApgaismojumaParklajumus(mainamaisMasivs);
  }

  public static void uzliktDurvjuKreisasPusesParklajumus(String[] mainamaisMasivs) {
    uzliktDurvjuKreisasPusesApgaismojumaParklajumus(mainamaisMasivs);
  }

  /// Virtuves pārklājumi:
  public static void uzliktVirtuvesPrieksasParklajumus(String[] mainamaisMasivs) {
    uzliktVirtuvesPrieksasApgaismojumaParklajumus(mainamaisMasivs);
  }

  public static void uzliktVirtuvesLabasPusesParklajumus(String[] mainamaisMasivs) {
    uzliktVirtuvesLabasPusesApgaismojumaParklajumus(mainamaisMasivs);
    uzliktVirtuvesLogaSpParklajumu(mainamaisMasivs);
  }

  public static void uzliktVirtuvesLejasParklajumus(String[] mainamaisMasivs) {
    // uzliktVirtuvesLejasApgaismojumaParklajumus(mainamaisMasivs);
    uzliktVirtuvesSpParklajumu(mainamaisMasivs);
  }

  public static void uzliktVirtuvesKreisasPusesParklajumus(String[] mainamaisMasivs) {
    uzliktVirtuvesKreisasPusesApgaismojumaParklajumus(mainamaisMasivs);
  }


  // * Spoku pārklājumu metodes.
  /// Virtuves spoks:
  private static void uzliktVirtuvesSpParklajumu(String[] mainamaisMasivs) {
    // Pie masīva kopijas pievieno spoka fāzes bildi.
    mainamaisMasivs[1] += "\033[10G" + VirtuvesSpoks.virtuvesSpoks.izveletiesBildiPecFazes()[0] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    for (int i = 2; i - 1 < SpokuIzskati.virtPrieksasPagrabaBildesArSpoku.length; i++) { // i - 1, lai sāktu skaitīšanu no 0. rindas.
      mainamaisMasivs[i] += "\033[8G" + VirtuvesSpoks.virtuvesSpoks.izveletiesBildiPecFazes()[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
    }
  }
  
  /// Loga spoks:
  private static void uzliktGultasLogaSpParklajumu(String[] mainamaisMasivs) {
    for (int i = 1; i - 1 < SpokuIzskati.gultasLogaSpokaFazesBilde.length; i++) {
      if (!LogaSpoks.logaSpoks.getLSIstabu().equals("GULTA")) {
        mainamaisMasivs[i] += "\033[40G" + SpokuIzskati.logaSpokaBildesGultasIstaba[0][i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
      else {
        mainamaisMasivs[i] += "\033[40G" + LogaSpoks.logaSpoks.izveletiesBildiPecFazes()[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
  }

  private static void uzliktDivanaLogaSpParklajumu(String[] mainamaisMasivs) {
    for (int i = 1; i - 1 < SpokuIzskati.divanaLogaSpokaFazesBilde.length; i++) {
      if (!LogaSpoks.logaSpoks.getLSIstabu().equals("DIVANS")) {
        mainamaisMasivs[i] += "\033[26G" + SpokuIzskati.logaSpokaBildesDivanaIstaba[0][i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
      else {
        mainamaisMasivs[i] += "\033[26G" + LogaSpoks.logaSpoks.izveletiesBildiPecFazes()[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
  }

  private static void uzliktDurvjuLogaSpParklajumu(String[] mainamaisMasivs) {
    for (int i = 1; i - 1 < SpokuIzskati.durvjuLogaSpokaFazesBilde.length; i++) {
      if (!LogaSpoks.logaSpoks.getLSIstabu().equals("DURVIS")) {
        mainamaisMasivs[i] += "\033[18G" + SpokuIzskati.logaSpokaBildesDurvjuIstaba[0][i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
      else {
        mainamaisMasivs[i] += "\033[18G" + LogaSpoks.logaSpoks.izveletiesBildiPecFazes()[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
  }

  private static void uzliktVirtuvesLogaSpParklajumu(String[] mainamaisMasivs) {
    // Pie masīva kopijas pievieno spoka fāzes bildi.
    for (int i = 3; i - 3 < SpokuIzskati.virtuvesLogaSpokaFazesBilde.length; i++) { // i - 1, lai sāktu skaitīšanu no 0. rindas.
      if (!LogaSpoks.logaSpoks.getLSIstabu().equals("VIRTUVE")) {
        mainamaisMasivs[i] += "\033[35G" + SpokuIzskati.logaSpokaBildesVirtuve[0][i - 3] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
      else {
        mainamaisMasivs[i] += "\033[35G" + LogaSpoks.logaSpoks.izveletiesBildiPecFazes()[i - 3] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
  }

  /// Durvju spoks:
  private static void uzliktDurvjuSpParklajumu(String[] mainamaisMasivs) {
    for (int i = 2; i - 2 < SpokuIzskati.durvjuSpokaFazesBilde.length; i++) {
      mainamaisMasivs[i] += "\033[40G" + DurvjuSpoks.durvjuSpoks.izveletiesBildiPecFazes()[i - 2] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -2, jo i = mainamāMasīva kārtas rinda. i - 2 = sākt rediģēšanu no otrās rindas.
    }
  }


  // * Istabu pārklājumu metodes.
  /// Gultas pārklājumi:
  private static void uzliktGultasPrieksasApgaismojumaParklajumus(String[] mainamaisMasivs) {
    if (!SakumaDati.istabuGaismasIeslegtas[1]) {
      for (int i = 1; i < 13; i++) {
        mainamaisMasivs[i] += "\033[45G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      }
    }
  }

  private static void uzliktGultasLabasPusesApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna kreisajā pusē.
    String[] gultasLabasPusesKreisaPuse = new String[4];
    if (!SakumaDati.istabuGaismasIeslegtas[1]) {
      gultasLabasPusesKreisaPuse[0] = "\033[5G" + K.TPELEKS + "░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      gultasLabasPusesKreisaPuse[1] = "\033[4G" + K.TPELEKS + "░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      gultasLabasPusesKreisaPuse[2] = "\033[3G" + K.TPELEKS + "░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      gultasLabasPusesKreisaPuse[3] = "\033[2G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    
      mainamaisMasivs[2] += gultasLabasPusesKreisaPuse[0];
      mainamaisMasivs[3] += gultasLabasPusesKreisaPuse[1];
      mainamaisMasivs[4] += gultasLabasPusesKreisaPuse[2];
      for (int i = 5; i < K.BILDES_MASIVA_IZMERS; i++) {
        mainamaisMasivs[i] += gultasLabasPusesKreisaPuse[3];
      }
    }

    // Saliek durvju arkas gaismu ekrāna priekšā.
    if (!SakumaDati.istabuGaismasIeslegtas[3]) {
      for (int i = 1; i < 13; i++) {
        mainamaisMasivs[i] += "\033[39G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      }
    }
  }

  private static void uzliktGultasLejasApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna kreisajā pusē.
    String[] gultasLejasKreisaPuse = new String[2];
    if (!SakumaDati.istabuGaismasIeslegtas[3]) {
      gultasLejasKreisaPuse[0] = "\033[2G" + K.TPELEKS + "░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      gultasLejasKreisaPuse[1] = "\033[2G" + K.TPELEKS + "░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    
      mainamaisMasivs[2] += gultasLejasKreisaPuse[0];
      for (int i = 3; i < K.BILDES_MASIVA_IZMERS; i++) {
        mainamaisMasivs[i] += gultasLejasKreisaPuse[1];
      }
    }
  }

  private static void uzliktGultasKreisasPusesApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Kods:
  }

  /// Dīvāna pārklājumi:
  private static void uzliktDivanaPrieksasApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Kods:
  }

  public static void uzliktDivanaLabasPusesApgaismojumaParklajumus(String[] mainamaisMasivs) {
    if (!SakumaDati.istabuGaismasIeslegtas[2]) {
      mainamaisMasivs[2] += "\033[57G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[1] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      for (int i = 3; i < 13; i++) {
        mainamaisMasivs[i] += "\033[55G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      }
    }
  }

  private static void uzliktDivanaLejasApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna priekšā.
    if (!SakumaDati.istabuGaismasIeslegtas[0]){
      for (int i = 1; i < 13; i++) {
          mainamaisMasivs[i] += "\033[23G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      }
    }

    // Saliek durvju arkas gaismu ekrāna kreisajā pusē.
    String[] divanaLejasKreisaPuse = new String[5];
    if (!SakumaDati.istabuGaismasIeslegtas[2]) {
      divanaLejasKreisaPuse[0] = "\033[6G" + K.TPELEKS + "░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      divanaLejasKreisaPuse[1] = K.TPELEKS + "░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      divanaLejasKreisaPuse[2] = "\033[4G" + K.TPELEKS + "░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // Dīvaini 4 atstarpju bīdējumi?????? Tie bija saistīti ar TAB un SPACES.
      divanaLejasKreisaPuse[3] = "\033[3G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      divanaLejasKreisaPuse[4] = "\033[2G" + K.TPELEKS + "░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    
      mainamaisMasivs[3] += divanaLejasKreisaPuse[0];
      mainamaisMasivs[4] += "\033[5G" + divanaLejasKreisaPuse[1];
      mainamaisMasivs[5] += divanaLejasKreisaPuse[2];
      mainamaisMasivs[6] += divanaLejasKreisaPuse[3];
      for (int i = 7; i < K.BILDES_MASIVA_IZMERS - 1; i++) {
        mainamaisMasivs[i] += divanaLejasKreisaPuse[4];
      }
      mainamaisMasivs[15] += "\033[2G" +  divanaLejasKreisaPuse[1];
    }
  }

  private static void uzliktDivanaKreisasPusesApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Kods:
  }

  /// Durvju pārklājumi:
  private static void uzliktDurvjuPrieksasApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Kods:
  }

  private static void uzliktDurvjuLabasPusesApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna labajā pusē.
    if (!SakumaDati.istabuGaismasIeslegtas[3]) {
      String[] durvjuLabasPusesLabaPuse = new String[2];
      if (!SakumaDati.istabuGaismasIeslegtas[3]) {
        durvjuLabasPusesLabaPuse[0] = "\033[80G" + K.TPELEKS + "░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
        durvjuLabasPusesLabaPuse[1] = "\033[79G" + K.TPELEKS + "░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      
        mainamaisMasivs[4] += durvjuLabasPusesLabaPuse[0];
        for (int i = 5; i < K.BILDES_MASIVA_IZMERS; i++) {
          mainamaisMasivs[i] += durvjuLabasPusesLabaPuse[1];
        }
      }
    }
  }

  private static void uzliktDurvjuLejasApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna priekšā.
    if (!SakumaDati.istabuGaismasIeslegtas[3]) {
      for (int i = 2; i < 13; i++) {
        mainamaisMasivs[i] += "\033[20G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      }
    }
  }

  private static void uzliktDurvjuKreisasPusesApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna priekšā.
    if (!SakumaDati.istabuGaismasIeslegtas[1]) {
      mainamaisMasivs[1] += "\033[24G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[1] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      for (int i = 2; i < 13; i++) {
        mainamaisMasivs[i] += "\033[22G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      }
    }
  }

  /// Virtuves pārklājumi:
  private static void uzliktVirtuvesPrieksasApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna priekšā.
    if (!SakumaDati.istabuGaismasIeslegtas[2]) {
      for (int i = 2; i < 13; i++) {
        mainamaisMasivs[i] += "\033[48G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      }
    }
  }

  private static void uzliktVirtuvesLabasPusesApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna kreisajā pusē.
    String[] virtuvesLabasPusesKreisaPuse = new String[4];
    if (!SakumaDati.istabuGaismasIeslegtas[2]) {
      virtuvesLabasPusesKreisaPuse[0] = "\033[5G" + K.TPELEKS + "░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      virtuvesLabasPusesKreisaPuse[1] = "\033[4G" + K.TPELEKS + "░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      virtuvesLabasPusesKreisaPuse[2] = "\033[3G" + K.TPELEKS + "░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      virtuvesLabasPusesKreisaPuse[3] = "\033[2G" + K.TPELEKS + "░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    
      mainamaisMasivs[4] += virtuvesLabasPusesKreisaPuse[0];
      mainamaisMasivs[5] += virtuvesLabasPusesKreisaPuse[1];
      mainamaisMasivs[6] += virtuvesLabasPusesKreisaPuse[2];
      for (int i = 7; i < K.BILDES_MASIVA_IZMERS; i++) {
        mainamaisMasivs[i] += virtuvesLabasPusesKreisaPuse[3];
      }
    }

    // > Pagraba gaisma.
    String[] virtuvesLabasPusesPagrabaSkats = new String[5];
    if (!SakumaDati.pagrabaGaisma) {
      virtuvesLabasPusesPagrabaSkats[0] = "\033[71G" + K.TPELEKS + "░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      virtuvesLabasPusesPagrabaSkats[1] = "\033[70G" + K.TPELEKS + "░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      virtuvesLabasPusesPagrabaSkats[2] = "\033[70G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      virtuvesLabasPusesPagrabaSkats[3] = "\033[72G" + K.TPELEKS + "░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      virtuvesLabasPusesPagrabaSkats[4] = "\033[74G" + K.TPELEKS + "░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;

      mainamaisMasivs[3] += virtuvesLabasPusesPagrabaSkats[0];
      mainamaisMasivs[4] += virtuvesLabasPusesPagrabaSkats[1];
      for (int i = 5; i < K.BILDES_MASIVA_IZMERS - 2; i++) {
        mainamaisMasivs[i] += virtuvesLabasPusesPagrabaSkats[2];
      }
      mainamaisMasivs[14] += virtuvesLabasPusesPagrabaSkats[3];
      mainamaisMasivs[15] += virtuvesLabasPusesPagrabaSkats[4];
    }
  }

  private static void uzliktVirtuvesKreisasPusesApgaismojumaParklajumus(String[] mainamaisMasivs) {
    // Saliek durvju arkas gaismu ekrāna priekšā.
    if (!SakumaDati.istabuGaismasIeslegtas[0]) {
      for (int i = 1; i < 13; i++) {
        mainamaisMasivs[i] += "\033[26G" + ParklajumuIzskati.arkuGaismasAizpilditajs[0];
      }
    }
  }


  // * Objektu pārklāja metodes.

  private static void uzliktAtrodiPariKasti(String[] mainamaisMasivs) {
    if (AtrodiPariSavienojums.mSpeleAtrodiPari) {
      mainamaisMasivs[10] += "\033[42G" + K.OBJEKTS + "_______________" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[11] += "\033[41G" + K.OBJEKTS + "/___/_____/___/ |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[12] += "\033[41G" + K.OBJEKTS + "|   $     $   | |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[13] += "\033[41G" + K.OBJEKTS + "|   |     |   | |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[14] += "\033[41G" + K.OBJEKTS + "|_____________|/" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    }
    else {
      mainamaisMasivs[10] += "\033[42G_______________" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[11] += "\033[41G/___/_____/___/ |" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[12] += "\033[41G|   $     $   | |" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[13] += "\033[41G|   |     |   | |" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[14] += "\033[41G|_____________|/" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    }
  }
  
  private static void uzliktElektriskoPaneli(String[] mainamaisMasivs) {
    String[] elektriskaKaste = new String[9]; // Masīvs priekš elektriskās kastes bildes.
    if (SakumaDati.elektribaIeslegta) { // Ieslēgts.
      elektriskaKaste[0] = "\033[22G" + K.OBJEKTS + "   _______" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      elektriskaKaste[1] = "\033[22G" + K.OBJEKTS + "  /       |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      elektriskaKaste[2] = "\033[22G" + K.OBJEKTS + " /|  =  ON|" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      elektriskaKaste[3] = "\033[22G" + K.OBJEKTS + "| | _|_   |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      elektriskaKaste[4] = "\033[22G" + K.OBJEKTS + "| |       |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      elektriskaKaste[5] = "\033[22G" + K.OBJEKTS + "| |    OFF|" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      elektriskaKaste[6] = "\033[22G" + K.OBJEKTS + "| |_______|" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      elektriskaKaste[7] = "\033[22G" + K.OBJEKTS + "| /" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      elektriskaKaste[8] = "\033[22G" + K.OBJEKTS + "|/" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    } 
    // += pieliek pie masīva elementa.
    for (int i = 0; i < elektriskaKaste.length; i++) {
      mainamaisMasivs[i + 1] += elektriskaKaste[i];
    }	
  }

  private static void uzliktKaratavuGramatu(String[] mainamaisMasivs) {
    if (KaratavasSavienojums.mSpeleKaratavas) {
      mainamaisMasivs[9] += "\033[21G" + K.OBJEKTS + "/  ~~ /" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[10] += "\033[20G" + K.OBJEKTS + "/_____/" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    }
    else {
      mainamaisMasivs[9] += "\033[21G/  ~~ /" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      mainamaisMasivs[10] += "\033[20G/_____/" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    }
  }


  // * Citas pārklājumu metodes:

  public static void istabasGaismasUnSerkocinaParklajumi(String[] mainamaisMasivs, String[] originalaisMasivs) {
    // * Pārbauda istabu, kurā ir varonis, un nosaka vai gaisma tanī būs ieslēgta vai izslēgta, tas pats ar sērkociņu.
    if (!SakumaDati.istabuGaismasIeslegtas[Enums.V_Istaba.CIPARS] && !Serkocini.serkocini.getAizdedzinatsSerkocins()) { // Ja gaismas nav, un sērkocins nav aizdedzināts. 0 0
      istabaArIzslegtuGaismu(mainamaisMasivs);
    }
    else if (!SakumaDati.istabuGaismasIeslegtas[Enums.V_Istaba.CIPARS] && Serkocini.serkocini.getAizdedzinatsSerkocins()) { // Ja gaismas nav, un aizdedzināts sērkocins. 0 1
      tumsaIstabaArAizdedzinatuSerkocinu(mainamaisMasivs, originalaisMasivs);
    }
    else if (SakumaDati.istabuGaismasIeslegtas[Enums.V_Istaba.CIPARS] && Serkocini.serkocini.getAizdedzinatsSerkocins()) { // Ja ir gaisma, un aizdedzināts sērkocins. 1 1
      serkocinaPieliksanaPieBildes(mainamaisMasivs);
    }
  }

  public static String[] tumsaIstabaArAizdedzinatuSerkocinu(String[] apstradajamaisMasivs, String[] originalaisMasivs) {
    // * Pie apstrādjamā masīva pieliek ar sērkociņu apgaismoto laukumu.
    istabaArIzslegtuGaismu(apstradajamaisMasivs);
    apstradajamaisMasivs[8] = K.TPELEKS + originalaisMasivs[8] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[70G░░░░░░░░░░░░" + K.RESET;
    apstradajamaisMasivs[9] = K.TPELEKS + originalaisMasivs[9] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[73G░░░░░░░░░" + K.RESET;
    apstradajamaisMasivs[10] = K.TPELEKS + originalaisMasivs[10] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[76G░░░░░░" + K.RESET;
    apstradajamaisMasivs[11] = K.TPELEKS + originalaisMasivs[11] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[79G░░░" + K.RESET;
    apstradajamaisMasivs[12] = K.TPELEKS + originalaisMasivs[12] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
    apstradajamaisMasivs[13] = K.TPELEKS + originalaisMasivs[13] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
    apstradajamaisMasivs[14] = K.TPELEKS + originalaisMasivs[14] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
    apstradajamaisMasivs[15] = K.TPELEKS + originalaisMasivs[15] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
    serkocinaPieliksanaPieBildes(apstradajamaisMasivs);

    return apstradajamaisMasivs;
  }

  public static String[] serkocinaPieliksanaPieBildes(String[] apstradajamaisMasivs) {
    apstradajamaisMasivs[11] += ParklajumuIzskati.serkocinaIzskats[0];
    apstradajamaisMasivs[12] += ParklajumuIzskati.serkocinaIzskats[1];
    apstradajamaisMasivs[13] += ParklajumuIzskati.serkocinaIzskats[2];
    apstradajamaisMasivs[14] += ParklajumuIzskati.serkocinaIzskats[3];
    apstradajamaisMasivs[15] += ParklajumuIzskati.serkocinaIzskats[4];

    return apstradajamaisMasivs;
  }

  public static String[] istabaArIzslegtuGaismu(String[] aizpildamaisMasivs) {
    Arrays.fill(aizpildamaisMasivs, K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET); // Aizpilda visus masīva indeksus ar vienu un to pašu elementu.

    return aizpildamaisMasivs;
  }

  public static String[] pievienotVideokameru(String[] apstradajamaisMasivs) {
    /** Doto 16 elementu masīvu pārklāj ar kameras masīvu.*/
    for (int i = 0 ; i < K.BILDES_MASIVA_IZMERS ; i++) {
      apstradajamaisMasivs[i] += "\033[2G" + Piederumi.kamerasIzskats[i];
    }

    // 2. Pievieno kameras baterijas daudzumu.
    apstradajamaisMasivs[13] += "\033[64G" + PaligMetodes.atgriestProgresaLiniju(Piederumi.baterija, 100, 10, true) + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
    return apstradajamaisMasivs;
  }
}
