import java.util.Random;

public class Spoki {
    // Instrumenti.
    public static Random rand = new Random(); // Var izmantot, lai iegūtu random ciparus.

    
    
    // Loga spoks.

    // Loga spoka mainīgie jeb objekti.
    public static int virtuvesLogaSpokaSkaitlis; // Neizmantots.
    public static boolean logaSpoksAktivs = false; // Nosaka vai spoks ir pie loga vai nē.
    public static int maxLogaSpokaAgresivitate = 10; // Kustās, ja kustības random skaitlis ir zemāks par norādīto. Atņem vienu, jo rand cipars ir no 0 līdz 20 neieskaitot.
    public static String[][] virtuvesLogaSpokaFazes = {Rooms.virtuvesLogaSpoks1, Rooms.virtuvesLogaSpoks2, Rooms.virtuvesLogaSpoks3, Rooms.virtuvesLogaSpoks4, Rooms.virtuvesLogaSpoks5, Rooms.virtuvesLogaSpoks6, Rooms.virtuvesLogaSpoks7, Rooms.virtuvesLogaSpoks8}; // Visas virtuves loga spoka fāzes vienā masīvā.
    public static volatile int logaSpokaFazesIndeks = -1; // Nosaka, kurā fāzē ir spoks.
    public static int logaRandomKustibasCipars = 20; // 20 = garantēti nekustās pirmo reizi.
    public static int logaSpokaDrosibasSkaitlis = 3; // Cik kustības iespējas spoks būs neaktīvs.

    public static void logaSpoks(String[][] fazes) {
        // Random izvēle, kurā istabā parādīsies spoks.


        logaRandomKustibasCipars = rand.nextInt(20); // Kustības random skaitlis. Nosaka vai spoks kustēsies vai nē.
        
        // Spoka kustības kods.
        if (logaSpoksAktivs == false && logaRandomKustibasCipars < maxLogaSpokaAgresivitate) { // Aktivizē spoka kustību.
            logaSpoksAktivs = true;

        } else if (logaSpoksAktivs && logaSpokaDrosibasSkaitlis <= 0 && logaRandomKustibasCipars < maxLogaSpokaAgresivitate) { // Spoka kustība.  Ja kustibas drošības skaitlis ir <= 0, tad spoks var kustēties, citātdi spoks atpūšas.
            if (logaSpokaFazesIndeks > 7) { // Seko, lai index Faze neaiziet ārpus robežas.
                logaSpokaFazesIndeks = 0;
                logaSpoksAktivs = false;
            }
            if (logaSpoksAktivs) {
                String[] faze = fazes[logaSpokaFazesIndeks];
                Rooms.virtuveKreisa = faze;   
            }
            if (logaSpokaFazesIndeks == 6) {
                logaSpokaDrosibasSkaitlis = 10; // Lai varonis paspētu aizvērt logu.
            } else {
                logaSpokaDrosibasSkaitlis = 4; // Cik iespējas spoks atpūtīsies.
            }
        }
    }

    public static void testSpokaIzvade(String[][] fazes) {
        
        // for (int i = 0; i < 17; i++) {
        //         Rooms.virtuveKreisa[i] = faze1[i];
        //     }
    }
}
