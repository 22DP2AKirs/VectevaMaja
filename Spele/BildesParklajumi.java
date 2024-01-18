package Spele;
import java.util.Arrays;

import Spele.SpelesProcesi.Main;

public class BildesParklajumi {
    // * Atgriež masīvu, kuru izvadīs terminālī (Pēdējā bildes apstrāde).
    public static String[] istabasArParklajumiem(String[] originalaisMasivs) { 
        // Parametra masīva vērtību pārkopēšana un jauna masīva, lai nebojātu masīvu, kas ir sniegts kā parametrs.
        // mainita - drīkst mainīt, nemainītā - NEDRĪKST MAINĪT.
        String[] mainitaVaronaAktualaIstabasKopija = Arrays.copyOf(originalaisMasivs, originalaisMasivs.length); // Masīva elementu pārkopēšana.

        if (Main.varonaIstabasSkaitlis == 3 && Main.varonaVirzienaSkaitlis == 2) {
            if (!Main.pagrabaGaisma) {
                virtuvesPagrabaParklajs(mainitaVaronaAktualaIstabasKopija, originalaisMasivs);
            }
        }

        istabasGaismasUnSerkocinaParklajumi(mainitaVaronaAktualaIstabasKopija, originalaisMasivs);
        
        return mainitaVaronaAktualaIstabasKopija;
    }

    // * Pārbauda istabu, kurā ir varonis, un nosaka vai gaisma tanī būs ieslēgta vai izslēgta, tas pats ar sērkociņu.
    public static String[] istabasGaismasUnSerkocinaParklajumi(String[] mainamaisMasivs, String[] originalaisMasivs) {
        if (!Main.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && !VaronaDarbibas.aizdedzinatsSerkocins) { // Ja gaismas nav, un sērkocins nav aizdedzināts. 0 0
            istabaArIzslegtuGaismu(mainamaisMasivs);
        }
        else if (!Main.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && VaronaDarbibas.aizdedzinatsSerkocins) { // Ja gaismas nav, un aizdedzināts sērkocins. 0 1
            tumsaIstabaArAizdedzinatuSerkocinu(mainamaisMasivs, originalaisMasivs);
        }
        else if (Main.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && VaronaDarbibas.aizdedzinatsSerkocins) { // Ja ir gaisma, un aizdedzināts sērkocins. 1 1
            serkocinaPieliksanaPieBildes(mainamaisMasivs);
        }

        return mainamaisMasivs;
    }

    // * Pie apstrādjamā masīva pieliek ar sērkociņu apgaismoto laukumu.
    public static String[] tumsaIstabaArAizdedzinatuSerkocinu(String[] apstradajamaisMasivs, String[] originalaisMasivs) {
        istabaArIzslegtuGaismu(apstradajamaisMasivs);
        apstradajamaisMasivs[8] = K.TPELEKS + originalaisMasivs[8] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[70G░░░░░░░░░░░░" + K.RESET;
        apstradajamaisMasivs[9] = K.TPELEKS + originalaisMasivs[9] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[73G░░░░░░░░░" + K.RESET;
        apstradajamaisMasivs[10] = K.TPELEKS + originalaisMasivs[10] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[76G░░░░░░" + K.RESET;
        apstradajamaisMasivs[11] = K.TPELEKS + originalaisMasivs[11] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[79G░░░" + K.RESET;
        apstradajamaisMasivs[12] = K.TPELEKS + originalaisMasivs[12] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
        apstradajamaisMasivs[13] = K.TPELEKS + originalaisMasivs[13] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
        apstradajamaisMasivs[14] = K.TPELEKS + originalaisMasivs[14] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
        apstradajamaisMasivs[15] = K.TPELEKS + originalaisMasivs[15] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
        serkocinaPieliksanaPieBildes(apstradajamaisMasivs);
        
        return apstradajamaisMasivs;
    }


    public static String[] serkocinaPieliksanaPieBildes(String[] apstradajamaisMasivs) {
        apstradajamaisMasivs[11] += serkocinaIzskats[0];
        apstradajamaisMasivs[12] += serkocinaIzskats[1];
        apstradajamaisMasivs[13] += serkocinaIzskats[2];
        apstradajamaisMasivs[14] += serkocinaIzskats[3];
        apstradajamaisMasivs[15] += serkocinaIzskats[4];

        return apstradajamaisMasivs;
    }


    public static String[] serkocinaIzskats = {
        // Ja apstrādāto līniju pārdefinē ar sērkociņu, tad pārdefinētā līnija neatjaunosies iepriekšējā ciklā "Iegūst neapstrādāto bildi". Būs statiska bilde ar sērkociņu klāt un nodzēstu galu.
        // Ja apstrādātai līnijai pieliks klāt sērkociņu, tad pārveidotā līnija tiks atjaunot, bet būs ar nodzēstu galu.
        // \r nepalīdz atstāt galu.
        // Pieliekot RESET vai krāsas maiņu arī nepalīdz.

        // * Pieliekot beigās ANSI \033[#G kodu (Pārvietot rakstīšanas kursoru uz # kolonnu) ar # esot visa teksta līnijas beigas (arī aiz sērkociņa) nenodzēsa tālākos tekstu. !!!!!!!!!
        // "\033[82G"

        "\033[61G" + K.DZELTENS + "/\\_" + K.RESET + "\033[82G",
        "\033[60G"+ K.ORANZS + "/   \\" + K.RESET + "\033[82G",
        "\033[60G" + K.SARKANS + "| O  |" + K.RESET + "\033[82G",
        "\033[61G" + K.SARKANS + "'-\\'" + K.RESET + "\033[82G",
        "\033[64G" + K.BRUNS + "\\" + K.RESET + "\033[82G"
    };


    public static String[] istabaArIzslegtuGaismu(String[] aizpildamaisMasivs) {
        Arrays.fill(aizpildamaisMasivs, K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET); // Aizpilda visus masīva indeksus ar vienu un to pašu elementu.
        
        return aizpildamaisMasivs;
    }

    public static String[] virtuvesPagrabaParklajs(String[] parklajamaisMasivs, String[] originalaisMasivs) {
        // Nosaka, ko izvadīs, ja pagramba gaisma ir izslēgta.
        parklajamaisMasivs[1] += "\033[10G" + K.TPELEKS + "░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[2] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[3] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[4] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[5] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[6] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[7] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[8] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[9] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[10] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[11] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        parklajamaisMasivs[12] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + "\033[82G";
        
        return parklajamaisMasivs;
    } 
}
