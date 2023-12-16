import java.util.Random;

public class Spoki {
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
            if (logaSpokaDrosibasRobezas <= 0) {
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
                    Rooms.noteiktLogaSpokaFazesBildi(logaSpokaIstaba); // Nosaka, kuru istabu atjaunot ar spoku.
                }
            }
        }
    }
}
