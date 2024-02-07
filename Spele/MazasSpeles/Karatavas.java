package Spele.MazasSpeles;

import java.util.ArrayList;
import java.util.Arrays;

// Karātavas algoritms.
public class Karatavas {
    
    // private int karatavasGrutiba; // 0 - viegls, 1 - normāls, 2 - grūts, 3 - sarežģīts.
    // private int karatavasVards; // Kurš no izvēlētās grūtības vārdiem, būs izvēlēts.

    private String izveletaisVards;
    private String[] vardaSkelets;

    // Iespējamo vārdu masīvs.
    public static String[][] karatavasVardi = 
    { // Rindas - Grūtības pakāpe, Kolonnas - Vārds no izvēlētās grūtības pakāpes.
    { "AKA" , "BITE" , "OLA" , "BISE" , "OGA" , "KOKS" , "ALA" }, // Viegls 3 - 4 burti.
    { "RIEPA" , "LAIVA" , "BILDE" , "KASTE" , "PUTNS" , "SKAPIS" , "PUDELE" }, // Normāls 5 - 6 burti. R I E P A
    { "BASEINS" , "CITRONS" , "TELEFONS" , "AUTOBUSS" }, // Grūts 7 - 8 burti.
    { "BUMBIERIS" , "KLAVIERES" , "AKVAPARKS" , "TALISMANS" } // Sarežģīts 9 - 10 burti.
    }; 
    // 1234567891
    // 

    public Karatavas(int vardaGrutiba, int vardsPecKartas) {
        // Konstruktors izvēlas vārdu, izveido vārdam skeleta izmēru un aizpilda to ar tukša burta simbolu "_ ".
        izveletaisVards = karatavasVardi[vardaGrutiba][vardsPecKartas];
        vardaSkelets = new String[izveletaisVards.length()];
        Arrays.fill(vardaSkelets, "_  ");
    }

    public void parbauditBurtu(String ievaditaisBurts) {
        // Metode pārbauda ievadīto burtu, ja tas burts ir vārdā, tad to parāda.
        if (izveletaisVards.contains(ievaditaisBurts) && !ievaditaisBurts.equals("*")) {
            atklatBurtus(atrastBurtaIndeksus(ievaditaisBurts), ievaditaisBurts);
        }
    }

    public String toString() {
        String vards = "";
        // Cikls "salīmē" visus masīva elementus kopā, veidojot vienu vārdu.
        for (String elemetns : vardaSkelets) {
            vards += elemetns;
        }
        return vards;
    }

    private void nonemtBurtus(String ievaditaisBurts) {
        /* Metode aizvieto visus norādītos burtus ar "*" zīmi, lai tie indeksi netiktu programmā
        izmantoti vēlreiz, un lai pašā vārdā neņemtu nost burtus uzrādītajos indeksos.*/
        izveletaisVards.replaceAll(ievaditaisBurts, "*");
    }
    
    private void atklatBurtus(ArrayList<Integer> indeksuSaraksts, String ievaditaisBurts) {
        // Metode ciklā nomaina visus indeksus ar vienādo burtu uz ievadīto burtu. 
        // Piem.: vārds "bumba" => _ _ _ _ _ , burts: B => B _ _ B _ .

        // Aizvieto visus norādītos indeksa elementus ar burtu.
        for (int indeks : indeksuSaraksts) {
            vardaSkelets[indeks] = ievaditaisBurts + "  "; // "  " ir izvadei atstarpe starp burtiem.
        }

        // Noņem atrastos burtus no vārda.
        nonemtBurtus(ievaditaisBurts);
    }

    private ArrayList<Integer> atrastBurtaIndeksus(String ievaditaisBurts) {
        // Metode pārbauda sadala mināmo vārdu pa burtiem, un pārbauda katru burtu.
        // Ja atrod lietotāja ievadīto burtu, tad tā indeksu pievieno sarakstam "indeksuSaraksts".

        // Sadala vārdu pa burtiem.
        String[] sadalitaisVards = izveletaisVards.split("");

        // Šis saraksts uzglabā visus atrastos burtu indeksus.
        ArrayList<Integer> indeksuSaraksts = new ArrayList<>();

        // Pārbauda katru saraksta elementu jeb burtu.
        for (int i = 0; i < sadalitaisVards.length; i++) {
            // Ja atrod burtu, tad pievieno tā indeksu indeksuSarakstā.
            if (sadalitaisVards[i].equals(ievaditaisBurts)) {indeksuSaraksts.add(i);}
        }

        // Atgriež indeksuSaraksts.
        return indeksuSaraksts;
    }
}
