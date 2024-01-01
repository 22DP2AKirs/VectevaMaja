public class Main {
    // Visur izmantojamie mainīgie jeb objekti.
    public static volatile boolean speleSakas = true; // Mainīgais bool, kas palaiž visu spēli.

    // String array-i, kas nosaka varoņa pozīciju un virzienu.
    static volatile String[] virziens = {"Prieksa", "LabaP", "Zeme", "KreisaP"}; // [P]riekša, [L]aba puse, [Z]eme V, [K]reisā puse.
    static volatile String[] atrasanasVieta = {"Gulta", "Divans", "Durvis", "Virtuve"}; // Specifiska istaba.

    // Spelētāja pozīcija.
    static volatile int virzienaSkaitlis = 3;
    static volatile int atrasanasSkaitlis = 3; // 1, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas. 

    // Ieslēdz spēles testēšanas režīmu.
    public static boolean testesana = false;

    // *Beta* spēlētāja darbības.
    public volatile static boolean pagrabaGaismaON = false;

    // Spēlētāja darbības.
    public static boolean virtDarbibas;
    public static boolean pagrDarbibas;

    // Iestata tikšķa jeb 1 "refreša" periodu.
    public static int spelesAtrums = 1000 / 25; // Pēc cik ilga laika ekrāns "refrešojas". (Milisekundēs)
    public static int spelesIlgums = 20000;

    public static void main(String[] args) throws InterruptedException {
        // Jaunie rīki.
        Laiks laiks = new Laiks(); // Izveido jaunu Thredu, kas vienlaicīgi pildās
        Ievade ievadesLasitajs = new Ievade(); // Arī threads, bet šis lasa ievadi.

        // Sākas atsevišķās darbības jeb patstāvīgie procesi.
        laiks.start();
        ievadesLasitajs.start();
        

        tiritEkranu();
        // ================================================================== Sākas spēles kods ============================================================= //
        while (speleSakas) {

            // Atjaunos istabas ar spoka bildēm tikai tad, kad loga spoks būs izvēlējies savu istabu.
            Spoki.logaSpoks();
            Spoki.durSpoks();
            Spoki.virSpoks();

            Istabu_Izskati.virtSagatavosana();

            varonaKustiba();

            // Rooms.testIstabasIzvade(); // Istabas testa skats.
            if (testesana) { // Testēšanas režīma funkcijas.
                for (int i = 4; i > 0; i--){
                    System.out.print("\033[F");
                }
                System.out.println("\rDurvju spoks aktivs?: " + Spoki.durSpoksAktivs +", Random cipars: " + Spoki.durRandomKustibasCipars + ", Vai kustas?: " + Spoki.vaiDurSpoksVarKusteties + ", Fazes skaitlis: " + Spoki.durSpokaFazesIndeks + ", Spoka drosibas skaitlis: " + Spoki.durSpokaDrosibasRobezas + "             "); // + ", Spoka istaba: " + Spoki.logaSpokaIstaba);
                System.out.println("\rLoga spoks aktivs?: " + Spoki.logaSpoksAktivs +", Random cipars: " + Spoki.logaRandomKustibasCipars + ", Vai kustas?: " + Spoki.vaiLogaSpoksVarKusteties + ", Fazes skaitlis: " + Spoki.logaSpokaFazesIndeks + ", Spoka drosibas skaitlis: " + Spoki.logaSpokaDrosibasRobezas + ", Spoka istaba: " + Spoki.logaSpokaIstaba + "             ");
                System.out.println("\rPagraba gaisma ON?: " + pagrabaGaismaON +", Virtuves spoks aktivs?: " + Spoki.virSpoksAktivs +", Random cipars: " + Spoki.virRandomKustibasCipars + ", Vai kustas?: " + Spoki.vaiVirSpoksVarKusteties + ", Fazes skaitlis: " + Spoki.virSpokaFazesIndeks + ", Spoka drosibas skaitlis: " + Spoki.virSpokaDrosibasRobezas + "             ");
                System.out.println("\rLaiks ms: " + Laiks.spelesLaiks + " / " + spelesIlgums +"                                                                                                                    ");
                // if (pagrabaGaismaON) {
                //     Spoki.logaSpoks(Spoki.virtuvesLogaSpokaFazes);
                // } else {
                //     Spoki.logaSpoks(Spoki.virtuvesTumsaLogaSpokaFazes);
                // }
            }

            
            Istabu_Izskati.istabasIzvade(); // Bildes izvade.

            
            
            // Spēle apstājas uz brīdi.
            try {
                Thread.sleep(spelesAtrums);
            } catch (Exception e) {
                // handle exception
                System.out.println("Ak nē! Kaut kas notika ar laiku!");
            }
            
        }
        laiks.join();
        ievadesLasitajs.join();
        // ======================================================================== Beidzas spēles kods ============================================================================== //
    }

    public static void tiritEkranu() {
        System.out.print("\033[H\033[2J"); // Notīra terminālu.
        System.out.flush(); // Kaut kas ar kursora pozīciju.
    }
    
    // Kustoties pa māju, uz kuru pusi skatīsies varonis.
    public static void istabasVirziens() {
        // Nosākuma pārbauda, kurā istabā atrodas varonis un pēc tam viņa virzienu.
        // Skatoties kurā istabā atrodas varons ir pieejami citi skati.

        // Gultas istaba.
        if (atrasanasVieta[atrasanasSkaitlis].equals("Gulta")) {
            if (virziens[virzienaSkaitlis].equals("Prieksa")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.modificetasGultPrieksasIzvade());

            } else if (virziens[virzienaSkaitlis].equals("LabaP")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.gultasLaba);

            } else if (virziens[virzienaSkaitlis].equals("Zeme")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.gultasZeme);

            } else if (virziens[virzienaSkaitlis].equals("KreisaP")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.gultasKreisa);
            }
        // Dīvāna istaba.
        } else if (atrasanasVieta[atrasanasSkaitlis].equals("Divans")) {
            if (virziens[virzienaSkaitlis].equals("Prieksa")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.modificetaDivanaPrieksasBildesIzvade());

            } else if (virziens[virzienaSkaitlis].equals("LabaP")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.divanaLaba);

            } else if (virziens[virzienaSkaitlis].equals("Zeme")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.divanaZeme);

            } else if (virziens[virzienaSkaitlis].equals("KreisaP")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.divanaKreisa);
            }
        // Durvju istaba.    
        } else if (atrasanasVieta[atrasanasSkaitlis].equals("Durvis")) {
            // Skatoties uz masīva elementu var noteikt, uz kuru pusi skatās varonis.
            if (virziens[virzienaSkaitlis].equals("Prieksa")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.modificetasDurPrieksasBildesIzvade());

            } else if (virziens[virzienaSkaitlis].equals("LabaP")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.durvisLaba);

            } else if (virziens[virzienaSkaitlis].equals("Zeme")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.durvisZeme);

            } else if (virziens[virzienaSkaitlis].equals("KreisaP")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.modificetaDurKreisasPusesBildesIzvade());
            }
        // Virtuves istaba.
        } else if (atrasanasVieta[atrasanasSkaitlis].equals("Virtuve")) {
            virtDarbibas = true;
            if (virziens[virzienaSkaitlis].equals("Prieksa")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.modificetasVirtPrieksasBildesIzvade());

            } else if (virziens[virzienaSkaitlis].equals("LabaP")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.virtuveLaba);

            } else if (virziens[virzienaSkaitlis].equals("Zeme")) {
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.virtuveZeme);

            } else if (virziens[virzienaSkaitlis].equals("KreisaP")) {
                pagrDarbibas = true;
                Istabu_Izskati.aktualasIstabasParrakstisana(Istabu_Izskati.modificetasVirtKreisasPusesIzvade()); // Izvada modificētu jeb pavisam jaunu istabu.
            }
        }
        Ievade.notiritIevadi();
    }

    // Varoņa iespējamās darbības.
    public static void varonaKustiba() {
        // Varoņa kustēšanās kontroles.
        try {
            if (Ievade.ievade.equals("a")) { // Pagriesties pa Kreisi.
                pagrieztiesPaKreisi();
            } else if (Ievade.ievade.equals("d")) { // Pagriesties pa Labi.
                pagrieztiesPaLabi();
            } else if (Ievade.ievade.equals("w")) {
                ietUzPrieksu(atrasanasVieta[atrasanasSkaitlis], virziens[virzienaSkaitlis]);
            } else if (Ievade.ievade.equals("info")) {
                if (testesana) {
                        testesana = false;
                    } else {
                        testesana = true;
                    }
            } else if (Ievade.ievade.equals("g")) {
                // "Toggle gaismu ON vai OFF"
                if (Spoki.virSpokaFazesIndeks != 9) {
                    if (pagrabaGaismaON) {
                        pagrabaGaismaON = false;
                    } else {
                        pagrabaGaismaON = true;
                    }
                }
            } else if (Ievade.ievade.equals("")) {
                System.out.print("\033[F");
            }
        } catch (Exception e) {
            // : handle exception
        }
        istabasVirziens(); // Varoņa galvas kustināšana (Skatās pa labi, kreisi).
    }

    public static void pagrieztiesPaKreisi() {
        virzienaSkaitlis--;
        if (virzienaSkaitlis < 0) { // Lai masīvs neizietu no diapazonas.
            virzienaSkaitlis = 3;
        }
    }

    public static void pagrieztiesPaLabi() {
        virzienaSkaitlis++;
        if (virzienaSkaitlis > 3) { // Lai masīvs neizietu no diapazonas.
            virzienaSkaitlis = 0;
        }
    }

    // Kustība pa māju.
    public static void ietUzPrieksu(String tagadejaIstaba, String tagadejaisVirziens) {
        if (tagadejaIstaba.equals("Gulta")) {
            if (tagadejaisVirziens.equals("LabaP")) {
                atrasanasSkaitlis++;
                virzienaSkaitlis = 0; // Skats uz divana logu.
            } else if (tagadejaisVirziens.equals("Zeme")) {
                atrasanasSkaitlis = 3; // Ieiet virtuves istabā (3. jeb pēdējais elements).
                virzienaSkaitlis = 3; // Skats uz logu.
            }
        } else if (tagadejaIstaba.equals("Divans")) {
            if (tagadejaisVirziens.equals("LabaP")) {
                atrasanasSkaitlis++;
                virzienaSkaitlis = 0; // Skats uz durvīm.
            } else if (tagadejaisVirziens.equals("Zeme")) {
                atrasanasSkaitlis--;
                virzienaSkaitlis = 3; // Skats uz spoguli.
            }
        } else if (tagadejaIstaba.equals("Durvis")) {
            if (tagadejaisVirziens.equals("LabaP")) {
                atrasanasSkaitlis++;
                virzienaSkaitlis = 0; // Priekša
            } else if (tagadejaisVirziens.equals("Zeme")) {
                atrasanasSkaitlis--;
                virzienaSkaitlis = 3; // Skats uz dīvānu.
            }
        } else if (tagadejaIstaba.equals("Virtuve")) {
            if (tagadejaisVirziens.equals("LabaP")) {
                atrasanasSkaitlis = 0; // Ieiet gultas istabā (0. elements).
                virzienaSkaitlis = 0; // Skats uz gultu.
            } else if (tagadejaisVirziens.equals("Zeme")) {
                atrasanasSkaitlis--; // Vajadzēs virzienu mirorot.!!!!!!!!!!!!!!!!!!!!
                virzienaSkaitlis = 3; // Skats uz logu no virtuves puses.
            }
        }
    }
}