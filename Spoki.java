import java.util.Random;

public class Spoki {

    static boolean spokuInfoIzvadeBoolean = false;
    // Instrumenti.
    public static Random rand = new Random(); // Var izmantot, lai iegūtu random ciparus.
    
    // ================================================================================= Loga spoks ============================================================================== //
    // Loga spoka mainīgie jeb objekti.
    public static boolean logaSpoksAktivs = false; // Nosaka vai spoks ir pie loga vai nē.

    // Kustību cipari.
    public static int maxLogaSpokaAgresivitate = 20; // Kustās, ja kustības random skaitlis ir zemāks par norādīto. Atņem vienu, jo rand cipars ir no 0 līdz 20 neieskaitot.
    public static int logaRandomKustibasCipars;

    // Soļu cipari.
    public static volatile int logaSpokaFazesIndeks = -1; // Nosaka, kurā fāzē ir spoks.
    public static volatile int logaSpokaDrosibasRobezas = 3; // Cik drošības robežu spokam ir jāpārvar katru iešanas iespēju.

    // Optimizēšana.
    public static volatile String logaSpokaIstaba = "";
    public static volatile boolean vaiLogaSpoksVarKusteties;

    public static void logaSpoks() {
        // Speciālais random cipars priekš loga spoka.
        logaRandomKustibasCipars = rand.nextInt(20); // Kustības random skaitlis. Nosaka vai spoks kustēsies vai nē.
        vaiLogaSpoksVarKusteties = logaRandomKustibasCipars < maxLogaSpokaAgresivitate; // Ja (spoka random kustības iespēja 0 - 19 katru sekundi) < (Par spēlētāja ievadīto maximālo iespēju jeb kustības robežu šim spokam)
        // Random izvēle, kurā istabā parādīsies spoks.
        if (!logaSpoksAktivs) {
            if (vaiLogaSpoksVarKusteties && rand.nextInt(50) == 1) { // 1/50 jeb 2% iespēja loga spokam parādīties, katru "refrešu".
                int logaSpokaIstabasIzvele = rand.nextInt(4);
                if (logaSpokaIstabasIzvele == 0) {
                    logaSpokaIstaba = "Gulta";
                } else if (logaSpokaIstabasIzvele == 1) {
                    logaSpokaIstaba = "Divans";
                } else if (logaSpokaIstabasIzvele == 2) {
                    logaSpokaIstaba = "Durvis";
                } else if (logaSpokaIstabasIzvele == 3) {
                    logaSpokaIstaba = "Virtuve";
                }
                logaSpoksAktivs = true;
            }
        } else {
            // Visas darbības notiks tikai tad, kad spoks būs pārkāpis visām robežām.
            if (logaSpokaDrosibasRobezas < 0) {
                // Spoka kustības robežu pieskatīšana.
                if (logaSpokaFazesIndeks > 7) { // Pieskata, lai spoka index neiziet ārpus robežas (7 array elementi) un izslēdz loga spoku.
                        logaSpokaFazesIndeks = -1;
                        logaSpoksAktivs = false;
                        logaSpokaIstaba = "";
                } else if (logaSpokaFazesIndeks == 6) { // Cik robežas ir jāpārkāpj, kad ir pēdējā kustības fāzē.
                    logaSpokaDrosibasRobezas = 20; // Lai varonis paspētu aizvērt logu.
                } else {
                    logaSpokaDrosibasRobezas = 10; // Cik robežas pēc savas pēdējās kustības būs jāpārkāpj, lai spētu iet uz priekšu.
                }

                if (logaSpoksAktivs) { // Notiks tikai un vienīgi tad, kad spoka kustība ir atļauta un visas drošības robežas būs pārkāptas.
                    Istabu_Izskati.noteiktLogaSpokaFazesBildi(logaSpokaIstaba); // Nosaka, kuru istabu atjaunot ar spoku.
                }
            }
        }
    }

    // ================================================================================== Durvju spoks =========================================================================== //

    public static boolean durSpoksAktivs; // Aktivizē spoku.

    public static int maxDurSpokaAgresivitate = 20;
    public static int durRandomKustibasCipars;

    public static volatile int durSpokaFazesIndeks = -1;
    public static volatile int durSpokaDrosibasRobezas = 3;

    public static volatile boolean vaiDurSpoksVarKusteties;

    public static void durSpoks() {
        durRandomKustibasCipars = rand.nextInt(20);
        vaiDurSpoksVarKusteties = durRandomKustibasCipars < maxDurSpokaAgresivitate;

        if (!durSpoksAktivs) {
            if (vaiLogaSpoksVarKusteties && rand.nextInt(10) == 1) { // 10% iespēja aktivizēt šo spoku.
                durSpoksAktivs = true;
            }
        } else {
            // Visas darbības notiks tikai tad, kad spoks būs pārkāpis visām robežām.
            if (durSpokaDrosibasRobezas < 0) {
                // Spoka kustības robežu pieskatīšana.
                if (durSpokaFazesIndeks > 8) { // Pieskata, lai spoka index neiziet ārpus robežas (8 array elementi) un izslēdz durvju spoku.
                        durSpokaFazesIndeks = -1;
                        durSpoksAktivs = false;
                } else if (durSpokaFazesIndeks == 7) { // Cik robežas ir jāpārkāpj, kad ir pēdējā kustības fāzē.
                    durSpokaDrosibasRobezas = 10; 
                } else {
                    durSpokaDrosibasRobezas = 8; // Cik robežas pēc savas pēdējās kustības būs jāpārkāpj, lai spētu iet uz priekšu.
                }
                Istabu_Izskati.noteiktDurSpokaFazesSkatu();
            }
        }
    }

    // =========================================================================================== Virtuves spoks ================================================================================== //
    public static boolean virSpoksAktivs; // Aktivizē spoku.

    public static int maxVirSpokaAgresivitate = 20;
    public static int virRandomKustibasCipars;

    public static volatile int virSpokaFazesIndeks = -1;
    public static volatile int virSpokaDrosibasRobezas = 3;

    public static volatile boolean vaiVirSpoksVarKusteties;

    public static void virSpoks() {
        virRandomKustibasCipars = rand.nextInt(20);
        vaiVirSpoksVarKusteties = virRandomKustibasCipars < maxVirSpokaAgresivitate;
        Istabu_Izskati.noteiktVirPrieksasSpokaFazesSkatu();
        if (!virSpoksAktivs) {
            if (vaiVirSpoksVarKusteties && rand.nextInt(10) == 1) { // 10% iespēja aktivizēt šo spoku.
                virSpoksAktivs = true;
            }
        } else {
            // Visas darbības notiks tikai tad, kad spoks būs pārkāpis visām robežām.
            if (virSpokaDrosibasRobezas < 0) {
                // Spoka kustības robežu pieskatīšana.
                if (virSpokaFazesIndeks > 9) { // Pieskata, lai spoka index neiziet ārpus robežas (8 array elementi) un izslēdz durvju spoku.
                        virSpokaFazesIndeks = -1;
                        virSpoksAktivs = false;
                } else if (virSpokaFazesIndeks == 7) { // Cik robežas ir jāpārkāpj, kad ir pēdējā kustības fāzē.
                    virSpokaDrosibasRobezas = 10; 
                } else {
                    virSpokaDrosibasRobezas = 8; // Cik robežas pēc savas pēdējās kustības būs jāpārkāpj, lai spētu iet uz priekšu.
                }
            }
        }
    }

    static void spokuInformacijasIzvade() {
        System.out.println("Spoks: Loga, Aktivs?: " + logaSpoksAktivs + " Var kusteties?: " + vaiLogaSpoksVarKusteties + ", RAND kustibas cipars: " + logaRandomKustibasCipars + ", Drosibas robezas: " + logaSpokaDrosibasRobezas + ", Faze: " + logaSpokaFazesIndeks + ", Istaba: " + logaSpokaIstaba + "\033[0K");
        System.out.println("Spoks: Durvju, Aktivs?: " + durSpoksAktivs + " Var kusteties?: " + vaiDurSpoksVarKusteties + ", RAND kustibas cipars: " + durRandomKustibasCipars + ", Drosibas robezas: " + durSpokaDrosibasRobezas + ", Faze: " + durSpokaFazesIndeks + "\033[0K");
        System.out.println("Spoks: Virtuves, Aktivs?: " + virSpoksAktivs + " Var kusteties?: " + vaiVirSpoksVarKusteties + ", RAND kustibas cipars: " + virRandomKustibasCipars + ", Drosibas robezas: " + virRandomKustibasCipars + ", Faze: " + virSpokaFazesIndeks + ", Pagraba gaisma ON?: " + Main.pagrabaGaismaON + "\033[0K");
        System.out.println("Laiks ms: " + Laiks.spelesLaiks + " / " + Main.spelesIlgums + "\033[0K");
    }
}
