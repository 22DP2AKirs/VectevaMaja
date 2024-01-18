package Spele;
import java.util.ArrayList;

import Spele.SpelesProcesi.Main;
import Spele.Izskati.IstabuIzskati;
import Spele.Izskati.UIizskats;
import Spele.SpelesProcesi.Ievade;

public class IzvadeUzTerminalu {
    static ArrayList<String> programmasGalejaIzvadeUzEkrana = new ArrayList<>(); // Masīvs saturēs visu spēles grafisko informāciju.
    // * Metode mainīs un izvadīs "Galveno izvades masīvu". Visu laiku atjaunojot to ar aktuālajām (dinamiskajām bildēm (Katrs freims (FPS))).
    public static void salipinataUIIzvade() { 

        System.out.println("\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\033[0K"); // Ekrāna augšējā daļa.

        // Pievieno apstrādātas mājas bildes ar "Overlayiem (Pārklājumiem)".
        for (String parklataLinija : BildesParklajumi.istabasArParklajumiem(IstabuIzskati.istabuMasivaAtjaunosana()[Main.varonaIstabasSkaitlis][Main.varonaVirzienaSkaitlis])) {
            programmasGalejaIzvadeUzEkrana.add("\r|" + parklataLinija + "|");
        }
        
        // Pievieno apakšējo UI pie gala izvades, pēc mājas bildēm.
        for (String linija : UIizskats.apaksasUISagatavosana(Ievade.ievade)) {
            programmasGalejaIzvadeUzEkrana.add("\r|" + linija + "|");
        }

        // Pie mājas bildēm un apakšējā UI pievieno Labās puses UI.
        for (int i = 0; i < (UIizskats.labasPusesUISagatavosana().length); i++) {
            programmasGalejaIzvadeUzEkrana.set(i, programmasGalejaIzvadeUzEkrana.get(i) + UIizskats.labasPusesUISagatavosana()[i] + "|\033[0K");
        }

        // Izvada visus ArrayList elementus jeb fināla, gala bildi.
        for (int i = 0; i < programmasGalejaIzvadeUzEkrana.size(); i++) {
            System.out.println(programmasGalejaIzvadeUzEkrana.get(i));
        }

        System.out.println("\033[0J"); // Izdzēš visu tekstu līdz ekrāna beigām.

        programmasGalejaIzvadeUzEkrana.removeAll(programmasGalejaIzvadeUzEkrana); // Attīra ArrayLists no visiem viņa elementiem, padarot to pilnībā tukšu.
        System.out.print("\033[H"); // Noliek kursoru sākuma pozīcijā 0,0 jeb pirmās rindas pirmajā kolonnā.
    }

    public static void masivuIzvade(String[] masivs) {
        int masivaGarums = masivs.length;
        for (int i = 0; i < masivaGarums; i++) {
            System.out.println(masivs[i] + "\033[0K");
        }
        System.out.println("\033[0J"); // Izdzēš visu tekstu līdz ekrāna beigām.
        System.out.print("\033[H"); // Noliek kursoru sākuma pozīcijā 0,0 jeb pirmās rindas pirmajā kolonnā.
    }
}
