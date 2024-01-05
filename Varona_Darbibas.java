class Varona_Darbibas {
    static int infoLapasSecibasSkaitlis = 1; // Nosaka vai varoņa ievade būs ar kustību saistīta vai ar darbu darbību saistīta.

    // Spelētāja pozīcija.
    static int varonaVirzienaSkaitlis = 3;
    static int varonaIstabasSkaitlis = 0; // 0, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas. 

    static void varonaDarbibas(String ievade) {
        if (ievade.equals("A")) { // Pagriezties pa kreisi.
            pagrieztiesPaKreisi();
        } else if (ievade.equals("W")) { // Iet uz priekšu.
            ietUzPrieksu();
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
        istabasVirzienaNoteiksana(); // Nosaka uz kuru pusi skatīsies varonis ieejot citā istabā.
    }

    static void pagrieztiesPaKreisi() {
        varonaVirzienaSkaitlis--;
        if (varonaVirzienaSkaitlis < 0) { // Lai masīvs neizietu no diapazonas.
            varonaVirzienaSkaitlis = 3;
        }
    }

    static void pagrieztiesPaLabi() {
        varonaVirzienaSkaitlis++;
        if (varonaVirzienaSkaitlis > 3) { // Lai masīvs neizietu no diapazonas.
            varonaVirzienaSkaitlis = 0;
        }
    }
    
    static void istabasVirzienaNoteiksana() { // Nosaka uz kuru pusi skatīsies varonis ieejot citā istabā.
        // Atjauno visas istabas un, pēc pirms metodes izsauktajām darbībām, nosaka varoņa tagadējo istabu, un uz kuru pusi viņš skatās.
        Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.istabuMasivaAtjaunosana()[varonaIstabasSkaitlis][varonaVirzienaSkaitlis]);
    }
   
    static void ietUzPrieksu() {  // Kustība pa māju.
        // Kopā mājā ir 4 istabas, kurās var iet iekšā gan pulksteņrādītāja virzienā, gan pret to.
        // 0. Gulta, 1. Dīvāna istaba, 2. Durvju istaba, 3. Virtuve.
        // Istabas virzieni:
        // 0. Priekša, 1. Labā puse, 2. Leja, 3. Kreisā puse.

        if (varonaVirzienaSkaitlis == 1) { // Ja varonies ieiet "Labajās durvīs", tad ...
            if (varonaIstabasSkaitlis == 3) { // Pēdējā no 4 istabām. Ciparam ir jāmainās pēc "pulksteņrādītāja secības" cikla: 0 1 2 3 -0- 1 2 3 -0-.
                varonaIstabasSkaitlis = 0;
            } else {
                varonaIstabasSkaitlis++;
            }
            varonaVirzienaSkaitlis = 0; // Varonis ieies nākošajā istabā ar skatu uz istabas priekšu.
        } else if (varonaVirzienaSkaitlis == 2) { // Istabas "lejas" durvis.
            if (varonaIstabasSkaitlis == 0) { // Pret "pulksteņrādītāja secības" cikla: 0 -3- 2 1 0 -3- 2 1 0.
                varonaIstabasSkaitlis = 3;
            } else {
                varonaIstabasSkaitlis--;
            }
            varonaVirzienaSkaitlis = 3; // Varonis ieies nākošajā istabā ar skatu uz istabas kreiso pusi.
        }
    }
}