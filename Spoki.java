import java.util.Random;

public class Spoki {
    // Instrumenti.
    public static Random rand = new Random(); // Var izmantot, lai iegūtu random ciparus.

    
    
    // Loga spoks.
    // Loga spoka mainīgie jeb objekti.
    public static int virtuvesLogaSpokaSkaitlis; // Neizmantots.
    public static boolean logaSpoksAktivs = false; // Nosaka vai spoks ir pie loga vai nē.
    public static int maxLogaSpokaAgresivitate = 20; // Kustās, ja kustības random skaitlis ir zemāks par norādīto. Atņem vienu, jo rand cipars ir no 0 līdz 20 neieskaitot.
    
    // Visas virtuves loga spoka fāzes vienā masīvā.
    // public static String[][] virtuvesLogaSpokaFazes = {
    //     Rooms.virtuvesLogaSpoks1, 
    //     Rooms.virtuvesLogaSpoks2, 
    //     Rooms.virtuvesLogaSpoks3, 
    //     Rooms.virtuvesLogaSpoks4, 
    //     Rooms.virtuvesLogaSpoks5, 
    //     Rooms.virtuvesLogaSpoks6, 
    //     Rooms.virtuvesLogaSpoks7, 
    //     Rooms.virtuvesLogaSpoks8}; 

    // Visas virtuves loga spoka fāzes ar izslēgtu pagraba gaismu.
    // public static String[][] virtuvesTumsaLogaSpokaFazes = {
    //     Rooms.virtuvesTumsLogaSpoks1, 
    //     Rooms.virtuvesTumsLogaSpoks2, 
    //     Rooms.virtuvesTumsLogaSpoks3, 
    //     Rooms.virtuvesTumsLogaSpoks4, 
    //     Rooms.virtuvesTumsLogaSpoks5, 
    //     Rooms.virtuvesTumsLogaSpoks6, 
    //     Rooms.virtuvesTumsLogaSpoks7, 
    //     Rooms.virtuvesTumsLogaSpoks8}; 

    public static volatile int logaSpokaFazesIndeks = -1; // Nosaka, kurā fāzē ir spoks.
    public static int logaRandomKustibasCipars = 20; // 20 = garantēti nekustās pirmo reizi.
    public static volatile int logaSpokaDrosibasRobezas = 3; // Cik drošības robežu spokam ir jāpārvar katru iešanas iespēju.

    public static volatile String logaSpokaIstaba;
    public static boolean vaiLogaSpoksVarKusteties;

    public static void logaSpoks() {
        // Speciālais random cipars priekš loga spoka.
        logaRandomKustibasCipars = rand.nextInt(20); // Kustības random skaitlis. Nosaka vai spoks kustēsies vai nē.
        vaiLogaSpoksVarKusteties = logaRandomKustibasCipars < maxLogaSpokaAgresivitate; // Ja (spoka random kustības iespēja 0 - 19 katru sekundi) < (Par spēlētāja ievadīto maximālo iespēju jeb kustības robežu šim spokam)
        // Random izvēle, kurā istabā parādīsies spoks.
        if (!logaSpoksAktivs) {
            if (vaiLogaSpoksVarKusteties && rand.nextInt(10) == 0) { // 1/10 jeb 10% iespēja loga spokam parādīties. 
                if (rand.nextInt(4) == 0) {
                    logaSpokaIstaba = "Gulta";
                } else if (rand.nextInt(4) == 1) {
                    logaSpokaIstaba = "Divans";
                } else if (rand.nextInt(4) == 2) {
                    logaSpokaIstaba = "Durvis";
                } else if (rand.nextInt(4) == 3) {
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
                    logaSpokaDrosibasRobezas = 10; // Lai varonis paspētu aizvērt logu.
                } else {
                    logaSpokaDrosibasRobezas = 3; // Cik robežas pēc savas pēdējās kustības būs jāpārkāpj, lai spētu iet uz priekšu.
                }

                if (logaSpoksAktivs) { // Notiks tikai un vienīgi tad, kad spoka kustība ir atļauta un visas drošības robežas būs pārkāptas.
                    Rooms.noteiktLogaSpokaFazesBildi(logaSpokaIstaba); // Nosaka, kuru istabu atjaunot ar spoku.
                }
            }
            
        }

        
        

        if (logaSpokaDrosibasRobezas <= 0 && logaRandomKustibasCipars < maxLogaSpokaAgresivitate) { // Spoka kustība.  Ja kustibas drošības skaitlis ir <= 0, tad spoks var kustēties, citātdi spoks atpūšas.
            
            // if (logaSpoksAktivs) {
            //     String[] faze = fazes[logaSpokaFazesIndeks];
            //     Rooms.virtuveKreisa = faze;   
            //}
            
        }
    }

    public static void testSpokaIzvade(String[][] fazes) {
        
        // for (int i = 0; i < 17; i++) {
        //         Rooms.virtuveKreisa[i] = faze1[i];
        //     }
    }
}
