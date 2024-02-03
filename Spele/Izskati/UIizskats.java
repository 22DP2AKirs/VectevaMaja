package Spele.Izskati;

import Spele.K;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Laiks;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaDarbibas;

public class UIizskats {
    static String[] ievadesMasivs = Ievade.ieprieksejaIevade("");

    public static String[] apaksasUISagatavosana(String panemtaIevade) {
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
            "                                                                                ",
            "                                                                                ",
            "________________________________________________________________________________"
        };
        if (VaronaDarbibas.infoLapasSecibasSkaitlis == 1) {
            gatavsApaksasUI[2] = "                   |_____________________|___________________________|__________";
            gatavsApaksasUI[4] = "      [ W ] - K U S T E T I E S   U Z   P R I E K S U                           ";
            gatavsApaksasUI[6] = "      [ A ] - P A G R I E Z T I E S   P A   L A B I                             ";
            gatavsApaksasUI[8] = "      [ D ] - P A G R I E Z T I E S   P A   K R E I S I                         ";
            gatavsApaksasUI[10] = "      [ X ] - D A R B I B U   I N F O R M A C I J A                             ";
        } else if (VaronaDarbibas.infoLapasSecibasSkaitlis == 2){
            gatavsApaksasUI[2] = "___________________|                     |___________________________|__________";
        } else if (VaronaDarbibas.infoLapasSecibasSkaitlis == 3) {
            gatavsApaksasUI[2] = "___________________|_____________________|                           |__________";
            gatavsApaksasUI[4] = "      [ LOGS ] - A I Z B I E D E T   L O G A   S P O K U                        ";
        } else if (VaronaDarbibas.infoLapasSecibasSkaitlis == 4) {
            gatavsApaksasUI[2] = "___________________|_____________________|___________________________|          ";
            gatavsApaksasUI[4] = "      [ E ] - I Z M A N T O T   O B J E K T U                                   ";
            gatavsApaksasUI[6] = "      [ F ] - C E N S T I E S   A I Z D E D Z I N A T   S E R K O C I N U       ";
            gatavsApaksasUI[8] = "      [ G ] - I E S L E G T   V A I   I Z S L E G T   G A I S M U               ";
        }
        
        if (!panemtaIevade.equals("}")) { // Izveido jauno.
            ievadesMasivs = Ievade.ieprieksejaIevade(panemtaIevade);
        } 

        // Sagatavo 10 rindiņu.
        gatavsApaksasUI[12] = "     I E P R I E K S E J A   K O M A N D A :   " 
            + ievadesMasivs[0] + " "
            + ievadesMasivs[1] +  " "
            + ievadesMasivs[2] +  " "
            + ievadesMasivs[3] +  " "
            + ievadesMasivs[4] +  " "
            + ievadesMasivs[5] +  " "
            + ievadesMasivs[6] +  " "
            + ievadesMasivs[7] +  " "
            + ievadesMasivs[8] +  " "
            + ievadesMasivs[9] +  "              ";
            return gatavsApaksasUI;
    }

    public static String[] labasPusesUISagatavosana() {
        String[] gatavsLabasPusesUI = {
            "                     ",
            " L A I K S : " + Laiks.laikaTeksts,
            "_____________________",
            "Div       |Dur       ",
            "                     ",
            "____   ___|____   ___",
            "Gul       |Vir       ",
            "                     ",
            "__________|__________",
            "                     ",
            " Serkocini :         ",
            "                     ",
            "                     ", // 13
            "                     ",
            "                     ", // 15
            "                     ",
            "                     ",
            "                     ",
            "                     ", // 13
            "                     ",
            "                     ", // 15
            "                     ",
            "                     ",
            "                     ",
            "                     ", // 13
            "                     ",
            "                     ", // 15
            "                     ",
            "                     ",
            "_____________________"
        };

        if (Main.atlikusoSerkocinuDaudzums > 9) { // Nomaina atlikušo sērkociņu daudzuma rindu.
            gatavsLabasPusesUI[10] = " Serkocini : " + Main.atlikusoSerkocinuDaudzums + "      ";
        } else {
            gatavsLabasPusesUI[10] = " Serkocini : " + Main.atlikusoSerkocinuDaudzums + "       ";
        }

        // Mapes varoņa bultiņas pozīcijas noteicējs.
        if (Main.elektribaIeslegta) {
            if (Main.varonaIstabasSkaitlis == 0) {
                gatavsLabasPusesUI[7] = "     " + varonaMapesBultinasVirzienaDevejs() + "               ";
            } else if (Main.varonaIstabasSkaitlis == 1) {
                gatavsLabasPusesUI[4] = "     " + varonaMapesBultinasVirzienaDevejs() + "               ";
            } else if (Main.varonaIstabasSkaitlis == 2) {
                gatavsLabasPusesUI[4] = "                " + varonaMapesBultinasVirzienaDevejs() + "    ";
            } else if (Main.varonaIstabasSkaitlis == 3) {
                gatavsLabasPusesUI[7] = "                " + varonaMapesBultinasVirzienaDevejs() + "    ";
            }
        } else {
            gatavsLabasPusesUI[3] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
            gatavsLabasPusesUI[4] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
            gatavsLabasPusesUI[5] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
            gatavsLabasPusesUI[6] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
            gatavsLabasPusesUI[7] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
            gatavsLabasPusesUI[8] = K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░" + K.RESET;
        }
        return gatavsLabasPusesUI;
    }

    static String varonaMapesBultinasVirzienaDevejs() {
        String noteiktaMapesBultina = "";
        if(Main.varonaVirzienaSkaitlis == 0) {
            noteiktaMapesBultina = K.DEBESU_ZILS + "^" + K.RESET;
        } else if (Main.varonaVirzienaSkaitlis == 1) {
            noteiktaMapesBultina = K.DEBESU_ZILS + ">" + K.RESET;
        } else if (Main.varonaVirzienaSkaitlis == 2) {
            noteiktaMapesBultina = K.DEBESU_ZILS + "v" + K.RESET;
        } else if (Main.varonaVirzienaSkaitlis == 3) {
            noteiktaMapesBultina = K.DEBESU_ZILS + "<" + K.RESET;
        }
        
        return noteiktaMapesBultina;
    }

    
    
}
