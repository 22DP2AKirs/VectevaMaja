
import java.util.Scanner;

public class Ievade extends Thread {
    // volatile ir, lai objekts sinhronizējas starp visiem Thrediem.
    private static Scanner ievadesLasitajs = new Scanner(System.in); // Parastais lasītājs, kurš lasīs lietotāja ievadi.
    public static volatile String ievade = ""; // Definēju mainīgo, lai kods tālāk spētu viņu visu laiku dublicēt (šinī gadījumā saglabāt).
    
    public void run() { // Vienmēr lasa ievadi, vienalga uz to, kas notiek apkārt.
        while (Main.speleSakas) {
            ievade = ievadesLasitajs.nextLine().toUpperCase();
            System.out.print("\033[F");
        }
    }
    
    static String[] ieprieksejaIevade(String ievade) { // Atgriež ievadi sadalītu pa burtiem.
        String[] galaIevade = new String[10];

        if (ievade.length() > 10) { // Ja ievade ir garāka par 10 simboliem, tad komandā to uzrādīs ar vairākām issaukuma zīmēm [!].
            ievade = "!!!!!!!!!!";
        } else if (ievade.equals("")) {
            ievade = "ENTER";
        }

        String[] pagaiduIevade = ievade.split(""); // Sadala pa burtiem.
        int pagaiduIevadesElementuSk = pagaiduIevade.length; // Nosaka elementu skaitu.

        if((pagaiduIevadesElementuSk) < 11) {
            for (int i = 0; i < 10; i++) {
                if (i < pagaiduIevadesElementuSk){
                    galaIevade[i] = pagaiduIevade[i];
                } else {
                    galaIevade[i] = "_";
                }
            }
        }

        return galaIevade; 
    }

    static void notiritIevadi() {
        Ievade.ievade = "}";
    }
}
