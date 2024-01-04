class UI_Izskats {
    static String[] ievadesMasivs = Ievade.ieprieksejaIevade("");

    static String[] apaksasUISagatavosana(String panemtaIevade) {
        String[] gatavsApaksasUI = {
            "----------------------------------------------------------------------------------",
            " [1] K U S T I B A | [2] U Z D E V U M I | [3] A I Z S A R D Z I B A | [4] . . .  ",
            "___________________|_____________________|___________________________|            ",
            "                                                                                  ",
            "                                                                                  ",
            "                                                                                  ",
            "                                                                                  ",
            "                                                                                  ",
            "                                                                                  ",
            "                                                                                  ",
            "                                                                                  ",
            "                                                                                  ",
            "                                                                                  ",
            "__________________________________________________________________________________"
        };
        if (Varona_Darbibas.infoLapasSecibasSkaitlis == 1) {
            gatavsApaksasUI[2] = "                   |_____________________|___________________________|____________";
            gatavsApaksasUI[4] = "      [ W ] - K U S T E T I E S   U Z   P R I E K S U                             ";
            gatavsApaksasUI[6] = "      [ A ] - P A G R I E Z T I E S   P A   L A B I                               ";
            gatavsApaksasUI[8] = "      [ D ] - P A G R I E Z T I E S   P A   K R E I S I                           ";
            gatavsApaksasUI[10] = "      [ X ] - D A R B I B U   I N F O R M A C I J A                               ";
        } else if (Varona_Darbibas.infoLapasSecibasSkaitlis == 2){
            gatavsApaksasUI[2] = "___________________|                     |___________________________|____________";
        } else if (Varona_Darbibas.infoLapasSecibasSkaitlis == 3) {
            gatavsApaksasUI[2] = "___________________|_____________________|                           |____________";
        } else if (Varona_Darbibas.infoLapasSecibasSkaitlis == 4) {
            gatavsApaksasUI[2] = "___________________|_____________________|___________________________|            ";
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
            + ievadesMasivs[9] +  "                ";
            return gatavsApaksasUI;
    }

    static String[] labasPusesUISagatavosana() {
        return null;
    }

    public static void salipinataUIIzvade() {
        // Cikls strādā izmantojot indexu. Var izmantot ar vairākiem masīviem.
        // Izvada un nomaina augšējo daļu.
        for (int i = 0; i < 17; i++) {
            System.out.println("\r|" + Istabu_Izskati.aktualaIstabasIzskats[i] + "|");
        }

        // Pielipina apaksējo daļu.
        for (int i = 0; i < apaksasUISagatavosana(Ievade.ievade).length; i++) {
            System.out.println("\r|" + apaksasUISagatavosana(Ievade.ievade)[i] + "|");
        }

        System.out.print("\033[H"); // Noliek kursoru pašā augšā.
    }
}
