package Spele.MazasSpeles;

import java.util.ArrayList;
import java.util.Arrays;

import Spele.IzvadeUzTerminalu;
import Spele.K;
import Spele.PaligMetodes;
import Spele.Izskati.EkranuIzskati;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;

// Karātavas algoritms jeb spēle.
public class Karatavas {
  public static int karatavuKluduSkaits = 0;
  public static boolean atminejaVardu = false;

  private String izveletaisVards;
  private String[] vardaSkelets;
  private static char[] neatminetieBurti;

  // Iespējamo vārdu masīvs.
  private String[][] karatavasVardi = 
  { // Rindas - Grūtības pakāpe, Kolonnas - Vārds no izvēlētās grūtības pakāpes.
  { "AKA" , "BITE" , "OLA" , "BISE" , "OGA" , "KOKS" , "ALA" }, // Viegls 3 - 4 burti.
  { "RIEPA" , "LAIVA" , "BILDE" , "KASTE" , "PUTNS" , "SKAPIS" , "PUDELE" }, // Normāls 5 - 6 burti. R I E P A
  { "BASEINS" , "CITRONS" , "TELEFONS" , "AUTOBUSS" }, // Grūts 7 - 8 burti.
  { "BUMBIERIS" , "KLAVIERES" , "AKVAPARKS" , "TALISMANS" } // Sarežģīts 9 - 10 burti.
  }; 

  // Komentāri, lai vieglāk noteiktu izdomāto vārdu garumu:
  // 1234567891
  // 


  // Karātavu kods savienots izmantojamā jeb spēlējamā stāvoklī:
  static Karatavas karatavasObjekts = new Karatavas(0,1); // rand.nextInt(3), rand.nextInt(3)
  
  public static void karatavuKods() {
    if (Main.karatavas || Main.mazasSpelesRezultataParskats) { // Ja karātavas ir palaistas vai, ja varonis tiko uzvarēja karātavas.
      // Kamēr varonis nav uzvarējis karātavas, tikmēr viņš var ievadīt burtus.
      if (Main.karatavas) {
        // Izdara tā, lai nezināmo vārdu izvadītu uz ekrānu.
        Main.karatavasVards = karatavasObjekts.toString();
        karatavasObjekts.parbauditBurtu(Ievade.ievade, EkranuParklajumi.burti);
      }
      else {
        Main.karatavasVards = karatavasObjekts.nokrasotToString();
      }
      
      // Izvada masīvu vispirms pārklājot to.
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.ekranuAtjaunosana()[3]));
      
      // Ļauj varonim redzēt pabeigto vārdu n sekundes.
      if (!Main.karatavas && Main.mazasSpelesRezultataParskats == true) {
        PaligMetodes.gulet(3);
        Main.mazasSpelesRezultataParskats = false;
        Main.varonisIrMazajaSpele = false;
      }
      // Ja karātavu vārds ir atminēts, tad karātavas padara false, un minigamePārskatu padara true.
      if (Karatavas.atminejaVardu && Main.karatavas == true) {
        Main.karatavas = false;
        Main.mazasSpelesRezultataParskats = true;
      }
    }
  }

  public Karatavas(int vardaGrutiba, int vardsPecKartas) {
    // Konstruktors izvēlas vārdu, izveido vārdam skeleta izmēru un aizpilda to ar tukša burta simbolu "_ ".
    izveletaisVards = karatavasVardi[vardaGrutiba][vardsPecKartas];
    vardaSkelets = new String[izveletaisVards.length()];
    Arrays.fill(vardaSkelets, "_  ");

    neatminetieBurti = izveletaisVards.toCharArray();
  }

  public String nokrasotToString() {
    // Metode nokrāso vārdu izvēlētajā krāsā.
    return K.ZALS + toString() + K.GRAMATA;
  }

  public void parbauditBurtu(String ievaditaisBurts, String[] iespejamieBurti) {
    // * Metode pārbauda ievadīto burtu, ja tas burts ir vārdā, tad to parāda.
    // [ } ] - simbols tiek skaitīts kā tukša ievade jeb nekas nebija ievadīts.
    // [ Q ] - simbols tiek izmantots, lai izietu ārā no minigame.
    // [ trešais arguments ] - pārbauda vai ievadītais burts nebija ievadīts jau agrāk.
    if (ievaditaisBurts != "}" && ievaditaisBurts != "Q") {
      if (izveletaisVards.contains(ievaditaisBurts) && !ievaditaisBurts.equals("*")) { //  && !neatminetieBurti.toString().contains(ievaditaisBurts)
        noteiktBurtaPareizibu(true, ievaditaisBurts, iespejamieBurti); // Nomaina burta krāsu.
        atklatBurtus(atrastBurtaIndeksus(ievaditaisBurts), ievaditaisBurts);
      }
      else {
        noteiktBurtaPareizibu(false, ievaditaisBurts, iespejamieBurti); // Nomaina burta krāsu.
      }
      atminejaVardu = parbauditVardaStavokli();
    }
  }

  private boolean parbauditVardaStavokli() {
    // * Metode pārbauda vai visi masīva simboli ir vienādi.
    // * Spēles kodā tiek izmantots, lai uzvarētu karātavu minigame.
    // Paņem pirmo masīva elementu, lai pārbaudītu ar pārējiem.
    char pirmaisSimbols = neatminetieBurti[0];
    for (char simbols : neatminetieBurti) {
      // Ja kāds simbols nav vienāds ar pirmo simbolu, tad visi elementi nav vienādi.
      if (pirmaisSimbols != simbols) {
        return false;
      }
    }
    return true;
  }

  public String toString() {
    String vards = "";
    // Cikls "salīmē" visus masīva elementus kopā, veidojot vienu vārdu.
    for (String elemetns : vardaSkelets) {
      vards += elemetns;
    }
    return vards;
  }

  private void noteiktBurtaPareizibu(boolean pareizs, String ievaditaisBurts, String[] iespejamieBurti) {
    // * Metode nomaina "Grāmatā" burtu krāsu. Zaļā ja pareizs. Sarkanā ja nepareizs.
    if (pareizs) {
      PaligMetodes.nomainitMasivaElementu(iespejamieBurti, ievaditaisBurts, K.ZALS + ievaditaisBurts + K.GRAMATA);
    }
    else {
      PaligMetodes.nomainitMasivaElementu(iespejamieBurti, ievaditaisBurts, K.TPELEKS + ievaditaisBurts + K.GRAMATA);
      karatavuKluduSkaits++;
    }
  }
  
  private void atklatBurtus(ArrayList<Integer> indeksuSaraksts, String ievaditaisBurts) {
    // Metode ciklā nomaina visus indeksus ar vienādo burtu uz ievadīto burtu. 
    // Piem.: vārds "bumba" => _ _ _ _ _ , burts: B => B _ _ B _ .

    // Aizvieto visus norādītos indeksa elementus ar burtu.
    for (int indeks : indeksuSaraksts) {
      vardaSkelets[indeks] = ievaditaisBurts + "  "; // "  " ir izvadei atstarpe starp burtiem.
      neatminetieBurti[indeks] = '*';
    }
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

    // Atgriež indeksuSarakstu.
    return indeksuSaraksts;
  }
}
