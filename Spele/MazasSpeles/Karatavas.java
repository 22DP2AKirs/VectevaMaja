package Spele.MazasSpeles;

import java.util.ArrayList;
import java.util.Arrays;

import Spele.K;
import Spele.PaligMetodes;

// Karātavas algoritms jeb spēle.
public class Karatavas {
  public static int karatavuKluduSkaits = 0;
  public static int atlikusoBurtuSkaits;

  private String izveletaisVards;
  private String[] vardaSkelets;

  // Iespējamo vārdu masīvs.
  private String[][] karatavasVardi = 
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

    atlikusoBurtuSkaits = izveletaisVards.length();
  }

  public void parbauditBurtu(String ievaditaisBurts, String[] iespejamieBurti) {
    // Metode pārbauda ievadīto burtu, ja tas burts ir vārdā, tad to parāda.
    if (ievaditaisBurts != "}") {
      if (izveletaisVards.contains(ievaditaisBurts) && !ievaditaisBurts.equals("*")) {
          noteiktBurtaPareizibu(true, ievaditaisBurts, iespejamieBurti); // Nomaina burta krāsu.
          atklatBurtus(atrastBurtaIndeksus(ievaditaisBurts), ievaditaisBurts);
      }
      else {
          noteiktBurtaPareizibu(false, ievaditaisBurts, iespejamieBurti); // Nomaina burta krāsu.
      }
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
      atlikusoBurtuSkaits--;
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

    // Atgriež indeksuSaraksts.
    return indeksuSaraksts;
  }
}
