import java.util.Arrays;

class VaronaDarbibas {
    static int infoLapasSecibasSkaitlis = 1; // Nosaka vai varoņa ievade būs ar kustību saistīta vai ar darbu darbību saistīta.

    static volatile boolean aizdedzinatsSerkocins = false; 
    static int serkocinaDeksanasLaikaSkaititajs;

    
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
                    if (Spoki.rand.nextInt(3) == 0) { // 33.33 % iespēja aizdedzināt sērkociņu.
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
                    if(Main.elektribaIeslegta) {
                        Main.elektribaIeslegta = false;
                        Laiks.gaidisanasLaiks = 10;
                    } 
                    else {
                        Main.elektribaIeslegta = true;
                    }
                } 
                else if (Main.varonaIstabasSkaitlis == 0) { // Gultas darbības.
                    gultasDarbibas(ievade);
                }
                else if (Main.varonaIstabasSkaitlis == 1) { // Divana darbības.
                    divanaDarbibas(ievade);
                }
                else if (Main.varonaIstabasSkaitlis == 2) { // Durvju darbības.
                    durvjuDarbibas(ievade);
                }
                else if (Main.varonaIstabasSkaitlis == 3) { // Virtuves darbības.
                    virtuvesDarbibas(ievade);
                }
            }
            IstabuIzskati.istabuMasivaAtjaunosana(); // Atjauno visas istabas un, pēc pirms metodes izsauktajām darbībām, nosaka varoņa tagadējo istabu, un uz kuru pusi viņš skatās.
        }
    }


    static void virtuvesDarbibas(String panemtaIevade) {
        if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
            if (panemtaIevade.equals("LOGS") && Spoki.spokuStati[0].spokaIstaba.equals("Virtuve") && Spoki.spokuStati[0].spoksAktivs) {
                Spoki.logaSpoksAktivs = false;
            }
        }
        else if (Main.varonaVirzienaSkaitlis == 3) { // Kreisās puses darbības.
            if (panemtaIevade.equals("G") && Main.elektribaIeslegta) {
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
        if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
            if (panemtaIevade.equals("LOGS") && Spoki.spokuStati[0].spokaIstaba.equals("Durvis") && Spoki.spokuStati[0].spoksAktivs) {
                Spoki.logaSpoksAktivs = false;
            }
        }
        else if (Main.varonaVirzienaSkaitlis == 1) {
            if (panemtaIevade.equals("DURVIS") && Spoki.spokuStati[1].spoksAktivs) {
                Spoki.durvjuSpoksAktivs = false;
            }
        }
        else if (Main.varonaVirzienaSkaitlis == 2) { // Lejas darbības.
            if (panemtaIevade.equals("G") && Main.elektribaIeslegta) {
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
        if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
            if (panemtaIevade.equals("LOGS") && Spoki.spokuStati[0].spokaIstaba.equals("Divans") && Spoki.spokuStati[0].spoksAktivs) {
                Spoki.logaSpoksAktivs = false;
            }
        }
        else if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
            if (panemtaIevade.equals("G") && Main.elektribaIeslegta) {
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
        if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
            if (panemtaIevade.equals("G") && Main.elektribaIeslegta) {
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
        else if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
            if (panemtaIevade.equals("E") && Main.elektribaIeslegta) { //* Elektrības izslēgšana.
                SkanasSpeletajs.SpeletSkanu("Skanas faili\\fuse-box-turning-on-off.wav", 0);
                Main.elektribaIeslegta = false;
                Spoki.virtuvesSpoksAktivs = false;
                Arrays.fill(Main.istabuGaismasIeslegtas, false);
                Laiks.gaidisanasLaiks = 3;
            }
        }
        else if (Main.varonaVirzienaSkaitlis == 2) { // Lejas darbības.

        }
        else if (Main.varonaVirzienaSkaitlis == 3) { // Kreisās puses darbības.
            if (panemtaIevade.equals("LOGS") && Spoki.spokuStati[0].spokaIstaba.equals("Gulta") && Spoki.spokuStati[0].spoksAktivs) {
                Spoki.logaSpoksAktivs = false;
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
        Main.varonaVirzienaSkaitlis--;
        if (Main.varonaVirzienaSkaitlis < 0) { // Lai masīvs neizietu no diapazonas.
            Main.varonaVirzienaSkaitlis = 3;
        }
    }


    static void pagrieztiesPaLabi() {
        Main.varonaVirzienaSkaitlis++;
        if (Main.varonaVirzienaSkaitlis > 3) { // Lai masīvs neizietu no diapazonas.
            Main.varonaVirzienaSkaitlis = 0;
        }
    }


    static void ietUzPrieksu() {  // Kustība pa māju.
        // Kopā mājā ir 4 istabas, kurās var iet iekšā gan pulksteņrādītāja virzienā, gan pret to.
        // 0. Gulta, 1. Dīvāna istaba, 2. Durvju istaba, 3. Virtuve.
        // Istabas virzieni:
        // 0. Priekša, 1. Labā puse, 2. Leja, 3. Kreisā puse.

        if (Main.varonaIstabasSkaitlis == 0) {
            if (Main.varonaVirzienaSkaitlis == 0) {
                Main.varonaIstabasSkaitlis++;
            } else if (Main.varonaVirzienaSkaitlis == 1) {
                Main.varonaIstabasSkaitlis = 3; // Pret "pulksteņrādītāja secības" cikla: 0 -3- 2 1 0 -3- 2 1 0.
            }
        } else if (Main.varonaIstabasSkaitlis == 1) {
            if (Main.varonaVirzienaSkaitlis == 1) { // Labās durvis.
                Main.varonaIstabasSkaitlis++;
            } else if (Main.varonaVirzienaSkaitlis == 2) { // Lejas durvis.
                Main.varonaIstabasSkaitlis--;
            }
        } else if (Main.varonaIstabasSkaitlis == 2) {
            if (Main.varonaVirzienaSkaitlis == 2) { // Lejas durvis.
                Main.varonaIstabasSkaitlis++;
            } else if (Main.varonaVirzienaSkaitlis == 3) { // Kreisās durvis.
                Main.varonaIstabasSkaitlis--;
            }
        } else if (Main.varonaIstabasSkaitlis == 3) {
            if (Main.varonaVirzienaSkaitlis == 3) {
                Main.varonaIstabasSkaitlis = 0; //  Pēdējā no 4 istabām. Ciparam ir jāmainās pēc "pulksteņrādītāja secības" cikla: 0 1 2 3 -0- 1 2 3 -0-.
            } else if (Main.varonaVirzienaSkaitlis == 0) {
                Main.varonaIstabasSkaitlis--;
            }
        }
    }
}