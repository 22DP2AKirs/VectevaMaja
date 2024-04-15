package Spele.Izskati;

import Spele.Enums;
import Spele.K;
import Spele.PaligMetodes;
import Spele.Enums.Istabas;
import Spele.Enums.Virzieni;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.SpelesProcesi.Laiks;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.VaronaDarbibas;

public class UIizskats {
    // static String[] ievadesMasivs = Ievade.ieprieksejaIevade("");

    public static String[] apaksasUISagatavosana() { // TODO String panemtaIevade
        String[] gatavsApaksasUI = {
            "--------------------------------------------------------------------------------",
            " [1] K U S T I B A | [2] U Z D E V U M I | [3] A I Z S A R D Z I B A | [4] ...  ",
            "___________________|_____________________|___________________________|          ",
            "                                                                                ",
            "                                                                                ",
            "                                                                                ",
            "                                                                                ",
            "                                                                                ",
            "                                                                                ",
            "                                                                                ",
            "                                                                                ",
            "                v _   _                                                         ",
            "  I E P R I E K S E J A   K O M A N D A :                                       ",
            "________________________________________________________________________________"
        };
        if (VaronaDarbibas.infoLapasSecibasSkaitlis == 1) {
            gatavsApaksasUI[2] = "                   |_____________________|___________________________|__________";
            gatavsApaksasUI[4] = "      [ W ] - K U S T E T I E S   U Z   P R I E K S U                           ";
            gatavsApaksasUI[6] = "      [ A ] - P A G R I E Z T I E S   P A   L A B I                             ";
            gatavsApaksasUI[8] = "      [ D ] - P A G R I E Z T I E S   P A   K R E I S I                         ";
            gatavsApaksasUI[9] = "                _       _                 _ v               v _                 ";
            gatavsApaksasUI[10] = "      [ X ] - P A R S L E G T   R A K S T I S A N A S   R E Z I M U             ";
        } else if (VaronaDarbibas.infoLapasSecibasSkaitlis == 2){
            gatavsApaksasUI[2] = "___________________|                     |___________________________|__________";
            gatavsApaksasUI[4] = "      [ Q ] - I Z I E T   N O   M A J A S D A R B A                             ";
        } else if (VaronaDarbibas.infoLapasSecibasSkaitlis == 3) {
            gatavsApaksasUI[2] = "___________________|_____________________|                           |__________";
            gatavsApaksasUI[4] = "      [ LOGS ] - A I Z B I E D E T   L O G A   S P O K U                        ";
            gatavsApaksasUI[6] = "      [ DURVIS ] - A I Z B I E D E T   D U R V J U   S P O K U                  ";
            gatavsApaksasUI[8] = "      [ SLEGT ] - A I Z S L E G T   D U R V I S                                 ";
        } else if (VaronaDarbibas.infoLapasSecibasSkaitlis == 4) {
            gatavsApaksasUI[2] = "___________________|_____________________|___________________________|          ";
            gatavsApaksasUI[4] = "      [ E ] - I Z M A N T O T   O B J E K T U                                   ";
            gatavsApaksasUI[6] = "      [ F ] - C E N S T I E S   A I Z D E D Z I N A T   S E R K O C I N U       ";
            gatavsApaksasUI[8] = "      [ G ] - I E S L E G T   V A I   I Z S L E G T   G A I S M U               ";
        }
        
        // Iepriekšējās komandas 'Displejs'.
        gatavsApaksasUI[12] += "\033[45G" + PaligMetodes.saliktAtstarpesSimboluVirkne(TastaturasKlausitajs.ieprieksejaKomanda, 1) + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;

      return gatavsApaksasUI;
    }

    public static String[] labasPusesUISagatavosana() {
      String[] gatavsLabasPusesUI = {
          "                     ",
          " L A I K S : " + Laiks.laikaTeksts,
          "                     ",
          " N A K T S :   " + IestatijumuDati.spelesNakts + "     ",
          "_____________________",
          "Div       |Dur       ",
          "                     ",
          "____   ___|____   ___",
          "Gul       |Vir       ",
          "                     ",
          "__________|__________",
          "     MAJASDARBS:     ",
          "                     ",
          "                     ",
          "      _________      ",
          "    IZPILDIT LIDZ:   ", 
          "        " + MazoSpeluIzvelesKods.majasdarbaIzpildesTermins + "  A M       ", 
          "_____________________",
          "      INVENTARS:     ",
          "                     ", 
          " Serkocini :         ",
          "                     ",
          "                     ",
          "                     ",
          "                     ", 
          "                     ",
          "                     ",
          "                     ",
          "                     ",
          "_____________________"
      };
      
      // Izvēlas mājasdarba nosaukumu.
      if (KaratavasSavienojums.mSpeleKaratavas) {
        gatavsLabasPusesUI[12] = "  K A R A T A V A S  ";
      }
      else if (AtrodiPariSavienojums.mSpeleAtrodiPari) {
        gatavsLabasPusesUI[12] = "     A T R O D I     ";
        gatavsLabasPusesUI[13] = "       P A R I       ";
      } else {
        gatavsLabasPusesUI[12] = "                     ";
        gatavsLabasPusesUI[13] = "                     ";
      }

      if (IestatijumuDati.atlikusoSerkocinuDaudzums > 9) { // Nomaina atlikušo sērkociņu daudzuma rindu.
        gatavsLabasPusesUI[20] = " Serkocini : " + IestatijumuDati.atlikusoSerkocinuDaudzums + "      ";
      } else {
        gatavsLabasPusesUI[20] = " Serkocini : " + IestatijumuDati.atlikusoSerkocinuDaudzums + "       ";
      }

      // Mapes varoņa bultiņas pozīcijas noteicējs.
      if (IestatijumuDati.elektribaIeslegta) {
          if (Enums.V_Istaba.equals(Istabas.GULTA)) {
              gatavsLabasPusesUI[9] = "     " + varonaMapesBultinasVirzienaDevejs() + "               ";
          } else if (Enums.V_Istaba.equals(Istabas.DIVANS)) {
              gatavsLabasPusesUI[6] = "     " + varonaMapesBultinasVirzienaDevejs() + "               ";
          } else if (Enums.V_Istaba.equals(Istabas.DURVIS)) {
              gatavsLabasPusesUI[6] = "                " + varonaMapesBultinasVirzienaDevejs() + "    ";
          } else if (Enums.V_Istaba.equals(Istabas.VIRTUVE)) {
              gatavsLabasPusesUI[9] = "                " + varonaMapesBultinasVirzienaDevejs() + "    ";
          }
      } else {
          gatavsLabasPusesUI[5] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
          gatavsLabasPusesUI[6] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
          gatavsLabasPusesUI[7] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
          gatavsLabasPusesUI[8] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
          gatavsLabasPusesUI[9] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
          gatavsLabasPusesUI[10] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
      }
      return gatavsLabasPusesUI;
  }

  private static String varonaMapesBultinasVirzienaDevejs() {
    String noteiktaMapesBultina = "";
    if(Enums.V_Virziens.equals(Virzieni.PRIEKSA)) {
      noteiktaMapesBultina = K.DEBESU_ZILS + "^" + K.RESET;
    } 
    else if (Enums.V_Virziens.equals(Virzieni.LABA_PUSE)) {
      noteiktaMapesBultina = K.DEBESU_ZILS + ">" + K.RESET;
    } 
    else if (Enums.V_Virziens.equals(Virzieni.LEJA)) {
      noteiktaMapesBultina = K.DEBESU_ZILS + "v" + K.RESET;
    } 
    else if (Enums.V_Virziens.equals(Virzieni.KREISA_PUSE)) {
      noteiktaMapesBultina = K.DEBESU_ZILS + "<" + K.RESET;
    }
    return noteiktaMapesBultina;
  }
}
