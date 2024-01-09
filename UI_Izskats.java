import java.util.ArrayList;

class UI_Izskats {
    static String[] ievadesMasivs = Ievade.ieprieksejaIevade("");

    static String[] apaksasUISagatavosana(String panemtaIevade) {
        String[] gatavsApaksasUI = {
            "--------------------------------------------------------------------------------",
            " [1] K U S T I B A | [2] U Z D E V U M I | [3] A I Z S A R D Z I B A | [4] . . .",
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
        } else if (VaronaDarbibas.infoLapasSecibasSkaitlis == 4) {
            gatavsApaksasUI[2] = "___________________|_____________________|___________________________|          ";
            gatavsApaksasUI[4] = "      [ E ] - I Z M A N T O T   O B J E K T U                                   ";
            gatavsApaksasUI[6] = "      [ F ] - C E N S T I E S   A I Z D E D Z I N A T   S E R K O C I N U       ";
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

    static String[] labasPusesUISagatavosana() {
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
        if (VaronaDarbibas.elektribaIeslegta) {
            if (VaronaDarbibas.varonaIstabasSkaitlis == 0) {
                gatavsLabasPusesUI[7] = "     " + varonaMapesBultinasVirzienaDevejs() + "               ";
            } else if (VaronaDarbibas.varonaIstabasSkaitlis == 1) {
                gatavsLabasPusesUI[4] = "     " + varonaMapesBultinasVirzienaDevejs() + "               ";
            } else if (VaronaDarbibas.varonaIstabasSkaitlis == 2) {
                gatavsLabasPusesUI[4] = "                " + varonaMapesBultinasVirzienaDevejs() + "    ";
            } else if (VaronaDarbibas.varonaIstabasSkaitlis == 3) {
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
        if(VaronaDarbibas.varonaVirzienaSkaitlis == 0) {
            noteiktaMapesBultina = "^";
        } else if (VaronaDarbibas.varonaVirzienaSkaitlis == 1) {
            noteiktaMapesBultina = ">";
        } else if (VaronaDarbibas.varonaVirzienaSkaitlis == 2) {
            noteiktaMapesBultina = "v";
        } else if (VaronaDarbibas.varonaVirzienaSkaitlis == 3) {
            noteiktaMapesBultina = "<";
        }
        return noteiktaMapesBultina;
    }

    static ArrayList<String> programmasGalejaIzvadeUzEkrana = new ArrayList<>(); // Masīvs saturēs visu spēles grafisko informāciju.
    static void salipinataUIIzvade() { // Metode mainīs un izvadīs "Galveno izvades masīvu". Visu laiku atjaunojot to ar aktuālajām (dinamiskajām bildēm (Katrs freims (FPS))).

        System.out.println("\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"); // Ekrāna augšējā daļa.

        // Pievieno apstrādātas mājas bildes ar "Overlayiem (Pārklājumiem)".
        for (String parklataLinija : Istabu_Izskati.istabasArParklajumiem(Istabu_Izskati.istabuMasivaAtjaunosana()[VaronaDarbibas.varonaIstabasSkaitlis][VaronaDarbibas.varonaVirzienaSkaitlis])) {
            programmasGalejaIzvadeUzEkrana.add("\r|" + parklataLinija + "|");
        }
        
        // Pievieno apakšējo UI pie gala izvades, pēc mājas bildēm.
        for (String linija : UI_Izskats.apaksasUISagatavosana(Ievade.ievade)) {
            programmasGalejaIzvadeUzEkrana.add("\r|" + linija + "|");
        }

        // Pie mājas bildēm un apakšējā UI pievieno Labās puses UI.
        for (int i = 0; i < (labasPusesUISagatavosana().length); i++) {
            programmasGalejaIzvadeUzEkrana.set(i, programmasGalejaIzvadeUzEkrana.get(i) + labasPusesUISagatavosana()[i] + "|\033[0K");
        }

        // Izvada visus ArrayList elementus jeb fināla, gala bildi.
        for (int i = 0; i < programmasGalejaIzvadeUzEkrana.size(); i++) {
            System.out.println(programmasGalejaIzvadeUzEkrana.get(i));
        }

        System.out.println("\033[0J"); // Izdzēš visu tekstu līdz ekrāna beigām.

        programmasGalejaIzvadeUzEkrana.removeAll(programmasGalejaIzvadeUzEkrana); // Attīra ArrayLists no visiem viņa elementiem, padarot to pilnībā tukšu.
        System.out.print("\033[H"); // Noliek kursoru sākuma pozīcijā 0,0 jeb pirmās rindas pirmajā kolonnā.
    }

    static void masivuIzvade(String[] masivs) {
        int masivaGarums = masivs.length;
        for (int i = 0; i < masivaGarums; i++) {
            System.out.println(masivs[i] + "\033[0K");
        }
        System.out.println("\033[0J"); // Izdzēš visu tekstu līdz ekrāna beigām.
        System.out.print("\033[H"); // Noliek kursoru sākuma pozīcijā 0,0 jeb pirmās rindas pirmajā kolonnā.
    }
}
