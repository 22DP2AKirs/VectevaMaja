package Spele.MazasSpeles;

import java.util.Arrays;

// Karātavas algoritms.
public class Karatavas {
    
    static int karatavasVardaIndeks = 0;
    public static String[] karatavasVardi = {"BUMBIERIS", "OLA"};

    public static String[] ieprieksejieAtklatieBurti = new String[karatavasVardi[karatavasVardaIndeks].length()];
    
    public static void apvienotaisKaratavasKods(String ievaditaisBurts) {
        aizpilditMasivu();
        // Ja tanī vārdā ir tāds burts, tad ..., citādi atgriež veco masīvu.
        if (karatavasVardi[karatavasVardaIndeks].contains(ievaditaisBurts) && !ievaditaisBurts.equals("*")) {
            uzEkranaAtklatieBurti(atrastBurtaIndeksus(ievaditaisBurts), ievaditaisBurts);
        }
    }

    public static void burtuNonemejs(String ievaditaisBurts) {
        /*  Metode aizvieto visus norādītos burtus ar "*" zīmi, lai tie indeksi netiktu programmā
            izmantoti vēlreiz, un lai pašā vārdā neņemtu nost burtus uzrādītajos indeksos.        */
        karatavasVardi[karatavasVardaIndeks].replaceAll(ievaditaisBurts, "*");
    }

    private static void aizpilditMasivu() {
        // Metode izveido burtu lodziņus pēc spēles izvēlētā vārda garuma, piem. ola : _ _ _,
        // un aizpilda masīvu ar "_", ja tā vērtība ir "null".
        if (ieprieksejieAtklatieBurti[0] == null) {
            Arrays.fill(ieprieksejieAtklatieBurti, "_ "); // Aizpilda masīvu ar norādīto vērtību.
        }
    }

    public static void uzEkranaAtklatieBurti(int[] indeksuMasivs, String ievaditaisBurts) {
        // Metode ciklā nomaina visus indeksus ar vienādo burtu uz ievadīto burtu. piem:
        // vārds: bumba => _ _ _ _ _, burts: b => b _ _ b _.

        // Aizvieto visus norādītos indeksa elementus ar burtu.
        for (int indeks : indeksuMasivs) {
            ieprieksejieAtklatieBurti[indeks] = ievaditaisBurts + " ";
        }

        // Noņem atrastos burtus no vārda.
        burtuNonemejs(ievaditaisBurts);

        // Atgriež vārdu ar pieliktiem burtiem.
        // return izvadamaisVards;
    }

    public static int[] atrastBurtaIndeksus(String ievaditaisBurts) {
        // Metode pārbauda katru texta masīva elementu, un ja atrod lietotāja ievadīto burtu, tad jaunā texta tipā pievieno indeksa ciparu.
        String[] burtuMasivs = karatavasVardi[karatavasVardaIndeks].split("");

        String burtaIndeksuKods = "";
        int atrastoBurtuSk = 0;

        // Pārbauda katru masīva elementu jeb burtu.
        for (int i = 0; i < burtuMasivs.length; i++) {
            if (burtuMasivs[i].equals(ievaditaisBurts)) {
                burtaIndeksuKods += i;
                atrastoBurtuSk++;
            }
        }

        String[] indeksuMasivs = burtaIndeksuKods.split(""); // Sadala String pa elementiem jeb burtiem.
        int[] burtuIndeksi = new int[atrastoBurtuSk]; // Izveido jaunu int[] ar tik pat lielu izmēru, cik daudz burtu duplikāciju bija atrasti.

        // Pārveido String[] uz int[].
        for (int i = 0; i < indeksuMasivs.length; i++) {
            burtuIndeksi[i] = Integer.valueOf(indeksuMasivs[i]);
        }

        // Atgriež burtuIndeksu masīvu.
        return burtuIndeksi;
    }
}
