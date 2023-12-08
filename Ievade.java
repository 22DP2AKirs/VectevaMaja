
import java.util.Scanner;

public class Ievade extends Thread {
    // volatile ir, lai objekts sinhronizējas starp visiem Thrediem.
    private static Scanner ievadesLasitajs = new Scanner(System.in); // Parastais lasītājs, kurš lasīs lietotāja ievadi.
    public static volatile String ievade; // Definēju mainīgo, lai kods tālāk spētu viņu visu laiku dublicēt (šinī gadījumā saglabāt).
    
    public void run() { // Vienmēr lasa ievadi, vienalga uz to, kas notiek apkārt.
        while (Main.speleSakas) {
            ievade = ievadesLasitajs.nextLine().toLowerCase();
            // Izvada nākošo spēles darbību.
            System.out.println("Darbiba: " + ievade);
        }
    }

    public static void notiritIevadi() {
        Ievade.ievade = "";
    }
}
