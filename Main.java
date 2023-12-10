public class Main {
    // Visur izmantojamie mainīgie jeb objekti.
    public static volatile boolean speleSakas = true; // Mainīgais bool, kas palaiž visu spēli.
    static volatile String[] virziens = {"Prieksa", "LabaP", "Zeme", "KreisaP"}; // [P]riekša, [L]aba puse, [Z]eme V, [K]reisā puse.
    static volatile String[] atrasanasVieta = {"Gulta", "Divans", "Durvis", "Virtuve"}; // Specifiska istaba.
    static volatile int virzienaSkaitlis = 3;
    static volatile int atrasanasSkaitlis = 3; // 2, jo testā sāku no durvju istabas. 3, no virtuves istabas.
    public static boolean testesana = false;
    public static void main(String[] args) throws InterruptedException {
        // Jaunie rīki.
        Laiks laiks = new Laiks(); // Izveido jaunu Thredu, kas vienlaicīgi pildās
        Ievade ievadesLasitajs = new Ievade(); // Arī threads, bet šis lasa ievadi.
        // Mainīgie jeb objekti.
        
        // Sākas atsevišķās darbības.
        laiks.start();
        ievadesLasitajs.start();

        // -------------------------------------- Sākas spēles kods ------------------------------------------------------ //
        while (speleSakas) {
            tiritEkranu();
            varonaKustiba();
            // Spoki.testSpokaIzvade(Spoki.virtuvesLogaSpokaFazes);
            Rooms.istabasIzvade();
            System.out.println("Random cipars: " + Spoki.logaRandomKustibasCipars + ", Fazes skaitlis: " +  Spoki.logaSpokaFazesIndeks + ", Spoka drosibas skaitlis: " + Spoki.logaSpokaDrosibasSkaitlis);

            // Rooms.testIstabasIzvade(); // Istabas testa skats.
            if (testesana) {
                Spoki.logaSpoks(Spoki.virtuvesLogaSpokaFazes);
            }
            // Spēles beigas.
            if (Laiks.spelesLaiks >= 1000) { // Kad beidzas laiks, tad notīras ekrāns un beidzas spēle.
                speleSakas = false;
                tiritEkranu();
                System.out.println("<SPIEDIET ENTER>");
            }
            // Spēle apstājas uz brīdi.
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // handle exception
                System.out.println("Ak nē! Kaut kas notika ar laiku!");
            }
        }
        laiks.join();
        ievadesLasitajs.join();
        // ---------------------------------- Beidzas spēles kods ------------------------------------------------------ //
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
                Rooms.aktualasIstabasParrakstisana(Rooms.gultasPrieksa);

            } else if (virziens[virzienaSkaitlis].equals("LabaP")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.gultasLaba);

            } else if (virziens[virzienaSkaitlis].equals("Zeme")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.gultasZeme);

            } else if (virziens[virzienaSkaitlis].equals("KreisaP")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.gultasKreisa);
            }
        // Dīvāna istaba.
        } else if (atrasanasVieta[atrasanasSkaitlis].equals("Divans")) {
            if (virziens[virzienaSkaitlis].equals("Prieksa")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.divanaPrieksa);

            } else if (virziens[virzienaSkaitlis].equals("LabaP")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.divanaLaba);

            } else if (virziens[virzienaSkaitlis].equals("Zeme")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.divanaZeme);

            } else if (virziens[virzienaSkaitlis].equals("KreisaP")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.divanaKreisa);
            }
        // Durvju istaba.    
        } else if (atrasanasVieta[atrasanasSkaitlis].equals("Durvis")) {
            // Skatoties uz masīva elementu var noteikt, uz kuru pusi skatās varonis.
            if (virziens[virzienaSkaitlis].equals("Prieksa")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.durvisPrieksa);

            } else if (virziens[virzienaSkaitlis].equals("LabaP")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.durvisLaba);

            } else if (virziens[virzienaSkaitlis].equals("Zeme")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.durvisZeme);

            } else if (virziens[virzienaSkaitlis].equals("KreisaP")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.durvisKreisa);
            }
        // Virtuves istaba.
        } else if (atrasanasVieta[atrasanasSkaitlis].equals("Virtuve")) {
            if (virziens[virzienaSkaitlis].equals("Prieksa")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.virtuvePrieksa);

            } else if (virziens[virzienaSkaitlis].equals("LabaP")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.virtuveLaba);

            } else if (virziens[virzienaSkaitlis].equals("Zeme")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.virtuveZeme);

            } else if (virziens[virzienaSkaitlis].equals("KreisaP")) {
                Rooms.aktualasIstabasParrakstisana(Rooms.virtuveKreisa);
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
            } else if (Ievade.ievade.equals("t")) {
                testesana = true;
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