class Varona_Darbibas {
    static int infoLapasSecibasSkaitlis = 1; // Nosaka vai varoņa ievade būs ar kustību saistīta vai ar darbu darbību saistīta.

    static void varonaDarbibas(String ievade) {
        if (ievade.equals("A")) { // Pagriezties pa kreisi.
            pagrieztiesPaKreisi();
        } else if (ievade.equals("W")) { // Iet uz priekšu.
            Main.ietUzPrieksu(Main.atrasanasVieta[Main.atrasanasSkaitlis], Main.virziens[Main.virzienaSkaitlis]);
        } else if (ievade.equals("D")) { // Pagriezties pa labi.
            pagrieztiesPaLabi();
        } else if (ievade.equals("1")) { // Pārslēdz režīmu.
            infoLapasSecibasSkaitlis = 1;
        } else if (ievade.equals("2")){
            infoLapasSecibasSkaitlis = 2;
        } else if (ievade.equals("3")) {
            infoLapasSecibasSkaitlis = 3;
        } else if (ievade.equals("4")) {
            infoLapasSecibasSkaitlis = 4;
        } else if (ievade.equals("INFO")) {
            if (Spoki.spokuInfoIzvadeBoolean) {
                Spoki.spokuInfoIzvadeBoolean = false;
            } else {
                Spoki.spokuInfoIzvadeBoolean = true;
            }
            Main.tiritEkranu();
        }
        Main.istabasVirziens(); // Varoņa galvas kustināšana (Skatās pa labi, kreisi).
    }

    static void pagrieztiesPaKreisi() {
        Main.virzienaSkaitlis--;
        if (Main.virzienaSkaitlis < 0) { // Lai masīvs neizietu no diapazonas.
            Main.virzienaSkaitlis = 3;
        }
    }

    static void pagrieztiesPaLabi() {
        Main.virzienaSkaitlis++;
        if (Main.virzienaSkaitlis > 3) { // Lai masīvs neizietu no diapazonas.
            Main.virzienaSkaitlis = 0;
        }
    }
}
