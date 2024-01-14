import java.util.Arrays;

class VaronaDarbibas {
    

    static int infoLapasSecibasSkaitlis = 1; // Nosaka vai varoņa ievade būs ar kustību saistīta vai ar darbu darbību saistīta. // TODO: Pārvietot uz Main.clasi

    // Spelētāja pozīcija. // TODO: Pārvietot uz Main.clasi
    static int varonaVirzienaSkaitlis = 0;
    static int varonaIstabasSkaitlis = 0; // 0, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas. 

    static boolean elektribaIeslegta = true;  // TODO: Pārvietot uz Main.clasi

    static volatile boolean aizdedzinatsSerkocins = false; 
    static int serkocinaDegsanasLaiks;

    static void varonaDarbibas(String ievade) { // TODO: sadalīt dažādās metodēs (Testēšanas darbības, spēlēšanas darbības, Izvēlnes darbības u.t.t.)
        if (!Ievade.vaiIevadiIzpildija) { // Garantē, lai lietotāja ievade tiktu izpildīta, pirms tā ir nodzēsta ar notiritIevadi().
            Ievade.vaiIevadiIzpildija = true;
        }

        if (Main.sakumaEkrans) {
            sakumaEkranaDarbibas(ievade);
        } 
        else if (Main.spelePalaista) {
            if (!ievade.equals("}")) { // Ja ievades nebija, tad nepārbauda pārējās komandas.
                if (ievade.equals("F") && Main.atlikusoSerkocinuDaudzums != 0 && !aizdedzinatsSerkocins) {
                    if (Spoki.rand.nextInt(4) == 0) { // 25 % iespēja aizdedzināt sērkociņu.
                        SkanasSpeletajs.SpeletSkanu("Skanas faili\\lighting-matches.wav", 0);
                        aizdedzinatsSerkocins = true;
                        Main.atlikusoSerkocinuDaudzums--;
                    } 
                    else {
                        SkanasSpeletajs.SpeletSkanu("Skanas faili\\failing-to-lit-matches.wav", 0);
                    }
                } 
                else if (ievade.equals("A")) { // Pagriezties pa kreisi.
                    pagrieztiesPaKreisi();
                } 
                else if (ievade.equals("W")) { // Iet uz priekšu.
                    ietUzPrieksu();
                } 
                else if (ievade.equals("D")) { // Pagriezties pa labi.
                    pagrieztiesPaLabi();
                } 
                else if (ievade.equals("1")) { // Pārslēdz režīmu.
                    infoLapasSecibasSkaitlis = 1;
                } 
                else if (ievade.equals("2")){
                    infoLapasSecibasSkaitlis = 2;
                } 
                else if (ievade.equals("3")) {
                    infoLapasSecibasSkaitlis = 3;
                } 
                else if (ievade.equals("4")) {
                    infoLapasSecibasSkaitlis = 4;
                } 
                else if (ievade.equals("INFO")) {
                    if (Spoki.spokuInfoIzvadeBoolean) {
                        Spoki.spokuInfoIzvadeBoolean = false;
                    } 
                    else {
                        Spoki.spokuInfoIzvadeBoolean = true;
                    }
                    Main.tiritEkranu();
                } 
                else if (ievade.equals("EXIT")) {
                    Main.programmaPalaista = false;
                    System.exit(0);
                }
                else if (ievade.equals("POWER OFF")) {
                    if(elektribaIeslegta) {
                        elektribaIeslegta = false;
                        Laiks.gaidisanasLaiks = 10;
                    } 
                    else {
                        elektribaIeslegta = true;
                    }
                } 
                else if (varonaIstabasSkaitlis == 0) { // Gultas darbības.
                    gultasDarbibas(ievade);
                }
                else if (varonaIstabasSkaitlis == 1) { // Divana darbības.
                    divanaDarbibas(ievade);
                }
                else if (varonaIstabasSkaitlis == 2) { // Durvju darbības.
                    durvjuDarbibas(ievade);
                }
                else if (varonaIstabasSkaitlis == 3) { // Virtuves darbības.
                    virtuvesDarbibas(ievade);
                }
            }
            Istabu_Izskati.istabuMasivaAtjaunosana(); // Atjauno visas istabas un, pēc pirms metodes izsauktajām darbībām, nosaka varoņa tagadējo istabu, un uz kuru pusi viņš skatās.
        }
    }

    static void virtuvesDarbibas(String panemtaIevade) {
        if (varonaVirzienaSkaitlis == 3) { // Priekšas darbības.
            if (panemtaIevade.equals("G")) {
                if (Main.istabuGaismasIeslegtas[3]) {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-off.wav", 0);
                    Main.istabuGaismasIeslegtas[3] = false;
                } 
                else {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-on.wav", 0);
                    Main.istabuGaismasIeslegtas[3] = true;
                }
            }
        }
    }

    static void durvjuDarbibas(String panemtaIevade) {
        if (varonaVirzienaSkaitlis == 2) { // Priekšas darbības.
            if (panemtaIevade.equals("G")) {
                if (Main.istabuGaismasIeslegtas[2]) {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-off.wav", 0);
                    Main.istabuGaismasIeslegtas[2] = false;
                } 
                else {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-on.wav", 0);
                    Main.istabuGaismasIeslegtas[2] = true;
                }
            }
        }
    }

    static void divanaDarbibas(String panemtaIevade) {
        if (varonaVirzienaSkaitlis == 1) { // Priekšas darbības.
            if (panemtaIevade.equals("G")) {
                if (Main.istabuGaismasIeslegtas[1]) {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-off.wav", 0);
                    Main.istabuGaismasIeslegtas[1] = false;
                } 
                else {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-on.wav", 0);
                    Main.istabuGaismasIeslegtas[1] = true;
                }
            }
        }
    }

    static void gultasDarbibas(String panemtaIevade) {
        if (varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
            if (panemtaIevade.equals("G")) {
                if (Main.istabuGaismasIeslegtas[0]) {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-off.wav", 0);
                    Main.istabuGaismasIeslegtas[0] = false;
                } 
                else {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-on.wav", 0);
                    Main.istabuGaismasIeslegtas[0] = true;
                }
            }
        }
        else if (varonaVirzienaSkaitlis == 1 && elektribaIeslegta) { // Elektrības kastes puse.
            if (panemtaIevade.equals("E")) {
                SkanasSpeletajs.SpeletSkanu("Skanas faili\\fuse-box-turning-on-off.wav", 0);
                elektribaIeslegta = false;
                Arrays.fill(Main.istabuGaismasIeslegtas, false);
                Laiks.gaidisanasLaiks = 10;
            }
        }
            
    }

    static void sakumaEkranaDarbibas(String panemtaIevade) {
        if (panemtaIevade.equals("W")) {
            if (SakumaEkrans.izvelnesSkaits > 1) {
                SakumaEkrans.izvelnesSkaits--;
            }
        } 
        else if (panemtaIevade.equals("S")) {
            if (SakumaEkrans.izvelnesSkaits < 6) {
                SakumaEkrans.izvelnesSkaits++;
            }
        } 
        else if (panemtaIevade.equals("")) {
            if (SakumaEkrans.izvelnesSkaits == 1) {

            }
            else if (SakumaEkrans.izvelnesSkaits == 2) { // Spēlēt.
                Main.sakumaEkrans = false;
                Main.spelePalaista = true;
            } 
            else if (SakumaEkrans.izvelnesSkaits == 3) {
            
            } 
            else if (SakumaEkrans.izvelnesSkaits == 4) {
            
            } 
            else if (SakumaEkrans.izvelnesSkaits == 5) {

            } 
            else if (SakumaEkrans.izvelnesSkaits == 6) {
                Main.programmaPalaista = false;
                System.exit(0); // Pārtrauc spēles darbību.
            } 
        }
        Ievade.notiritIevadi();
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
   
    static void ietUzPrieksu() {  // Kustība pa māju.
        // Kopā mājā ir 4 istabas, kurās var iet iekšā gan pulksteņrādītāja virzienā, gan pret to.
        // 0. Gulta, 1. Dīvāna istaba, 2. Durvju istaba, 3. Virtuve.
        // Istabas virzieni:
        // 0. Priekša, 1. Labā puse, 2. Leja, 3. Kreisā puse.

        if (varonaIstabasSkaitlis == 0) {
            if (varonaVirzienaSkaitlis == 0) {
                varonaIstabasSkaitlis++;
            } else if (varonaVirzienaSkaitlis == 1) {
                varonaIstabasSkaitlis = 3; // Pret "pulksteņrādītāja secības" cikla: 0 -3- 2 1 0 -3- 2 1 0.
            }
        } else if (varonaIstabasSkaitlis == 1) {
            if (varonaVirzienaSkaitlis == 1) { // Labās durvis.
                varonaIstabasSkaitlis++;
            } else if (varonaVirzienaSkaitlis == 2) { // Lejas durvis.
                varonaIstabasSkaitlis--;
            }
        } else if (varonaIstabasSkaitlis == 2) {
            if (varonaVirzienaSkaitlis == 2) { // Lejas durvis.
                varonaIstabasSkaitlis++;
            } else if (varonaVirzienaSkaitlis == 3) { // Kreisās durvis.
                varonaIstabasSkaitlis--;
            }
        } else if (varonaIstabasSkaitlis == 3) {
            if (varonaVirzienaSkaitlis == 3) {
                varonaIstabasSkaitlis = 0; //  Pēdējā no 4 istabām. Ciparam ir jāmainās pēc "pulksteņrādītāja secības" cikla: 0 1 2 3 -0- 1 2 3 -0-.
            } else if (varonaVirzienaSkaitlis == 0) {
                varonaIstabasSkaitlis--;
            }
        }
    }
}