package Spele.Majasdarbi.Karatavas;

import java.util.ArrayList;
import java.util.Arrays;

import Spele.K;
import Spele.PaligMetodes;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Main;

// Karātavas algoritms jeb spēle.
public class Karatavas {
  // Mainīgie, kuri ir lietoti citās programmas daļās.
  public static int karatavuKluduSkaits = 0;

  public static String[] burti = "A B C D E F G H I J K L M N O P R S T U V Z".split(" "); // Burti, kurus var izmantot vārdu minēšanai.

  public static String[] rAtstarpes = new String[17];
  public static String karatavasVards;

  // Viss tiek noteikts ar konstruktoru.
  private String atstarpe = "";
  private String izveletaisVards;
  private String[] vardaSkelets;
  private static char[] neatminetieBurti;

  // Karātavās iespējamo vārdu masīvs.
  private String[][] karatavasVardi = 
  { // Rindas - Grūtības pakāpe, Kolonnas - Vārds no izvēlētās grūtības pakāpes.
  { "AKA" , "BITE" , "OLA" , "BISE" , "OGA" , "KOKS" , "ALA" }, // Viegls 3 - 4 burti.
  { "RIEPA" , "LAIVA" , "BILDE" , "KASTE" , "PUTNS" , "SKAPIS" , "PUDELE" }, // Normāls 5 - 6 burti. R I E P A
  { "BASEINS" , "CITRONS" , "TELEFONS" , "AUTOBUSS" , "BINOKLIS" , "GREDZENS" , "ARBALETS" }, // Grūts 7 - 8 burti.
  { "BUMBIERIS" , "KLAVIERES" , "AKVAPARKS" , "TALISMANS" , "STIPENDIJA" , "TEHNIKUMS" , "PILDSPALVA" } // Sarežģīts 9 - 10 burti.
  }; 

  // Komentāri, lai vieglāk noteiktu izdomāto vārdu garumu:
  // 1234567891
  // PILDSPALVA

  // Definē karātavu objektu šeit, lai pēc tam to mierīgi varētu mainīt, netraucējot main ciklu.
  public static Karatavas karatavasObjekts;

  public Karatavas(int vardaGrutiba, int vardsPecKartas) {
    // Konstruktors izvēlas vārdu, izveido vārdam skeleta izmēru un aizpilda to ar tukša burta simbolu "_ ".
    izveletaisVards = karatavasVardi[vardaGrutiba][vardsPecKartas];
    // Izveido vārda skeleta masīvu pēc izvēlētā vārda garuma, kur vēlāk parādīsies atminētie burti. 
    // Un pārdefinē katra tā elementu ar tukšu jeb neatminētu burtu simbolu '_  '.
    Arrays.fill(vardaSkelets = new String[izveletaisVards.length()], "_  ");
    // Izveido atstarpi no kreisās malas sākuma, lai centrētu doto vārdu pa vidu grāmatai.
    atstarpe = noteiktAtstarpesIzmeru(izveletaisVards.length());
    // Izveido char masīvu, kuru izmantos, lai noteiktu vai visi burti ir atminēti, piem., atrastā burta indekss
    // šim masīvam tiks aizvietots ar '*' simbolu. Vārds būs atminēts, kad viss šis masīvs būs aizpildīts ar '*'.
    neatminetieBurti = izveletaisVards.toCharArray();
  }

  public static void izveidotJaunuKaratavasSpeli() {
    // * Izveido jaunu karātavas objektu, lai to varētu izmantot spēlē ar citām vērtībām.
    karatavasObjekts = new Karatavas(Main.rand.nextInt(4), Main.rand.nextInt(7));
    karatavasObjekts.sagatavotGramatuSpelesanai();
  }

  

  private void sagatavotGramatuSpelesanai() {
    restartetKaratavas();
    EkranuParklajumi.saliktRandAtstarpesKaratavuGramata();
    atklatDazusBurtus();
  }

  // Grāmatas vārda salikšana.
  public void saliktCentretuVardaSkeletu() {
    String vards = "";
    // Cikls "salīmē" visus masīva elementus kopā, veidojot vienu vārdu.
    for (String burtaVieta : vardaSkelets) {
      vards += burtaVieta;
    }
    karatavasVards = atstarpe + vards;
  }

  // Grāmatas vārda krāsošana.
  public void nokrasotCentretoVardaSkeletu() {
    // * Nokrāso vārdu izvēlētajā krāsā.
    karatavasVards = K.ZALS + karatavasVards + K.GRAMATA;
  }

  public boolean irAtminetsVards() {
    /*
    * Pārbauda vai visi masīva simboli ir vienādi, tas ir, vai vārds ir atminēts.
    char masīvs ir izvēlētais vārds, un to progresa laikā lēnām aizvieto ar '*' simboliem.
    Piemēram: banans -> b*n*ns -> **n*ns, u.t.t.*/

    // Paņem pirmo masīva elementu, lai salīdzinātu to ar pārējiem.
    char pirmaisSimbols = neatminetieBurti[0];
    for (char simbols : neatminetieBurti) {
      // Ja kāds simbols nav vienāds ar pirmo simbolu, tad visi elementi nav vienādi.
      if (pirmaisSimbols != simbols) {
        return false;
      }
    }
    return true;
  }

  public void parbauditBurtu(String ievaditaisBurts) {
    // * Metode pārbauda ievadīto burtu, ja tas burts ir vārdā, tad to parāda.
    // [ } ] - simbols tiek skaitīts kā tukša ievade jeb nekas nebija ievadīts.
    // [ Q ] - simbols tiek izmantots, lai izietu ārā no minigame.
    if (ievaditaisBurts != K.TUKSA_IEVADE && ievaditaisBurts != "Q" && ievaditaisBurts != "*") {
      apstradatBurtu(ievaditaisBurts);
    }
  }

  private void apstradatBurtu(String ievaditaisBurts) {
    // Ja ievadītais burts ir vārdā, tad ...
    if (izveletaisVards.contains(ievaditaisBurts)) {

      atklatBurtus(atrastBurtaIndeksus(ievaditaisBurts), ievaditaisBurts);
      // Nokrāso burtu zaļā krāsā.
      noteiktBurtaPareizibu(true, ievaditaisBurts); // Nomaina burta krāsu.
    }
    else {
      // Nokrāso burtu sarkanā krāsā.
      noteiktBurtaPareizibu(false, ievaditaisBurts); // Nomaina burta krāsu.
    }
  }
   
  private String noteiktAtstarpesIzmeru(int vardaGarums) {
    // * Metode centrē vārdu grāmatā ar atstarpju palīdzību.
    while (vardaGarums < 10) {
      atstarpe += " ";
      vardaGarums++;
    }
    return atstarpe;
  }

  private void noteiktBurtaPareizibu(boolean pareizs, String ievaditaisBurts) {
    // * Metode nomaina "Grāmatā" burtu krāsu. Zaļā ja pareizs. Sarkanā ja nepareizs.
    if (pareizs) {
      PaligMetodes.nomainitMasivaElementu(burti, ievaditaisBurts, K.ZALS + ievaditaisBurts + K.GRAMATA);
    }
    else {
      PaligMetodes.nomainitMasivaElementu(burti, ievaditaisBurts, K.TPELEKS + ievaditaisBurts + K.GRAMATA);
      karatavuKluduSkaits++;
    }
  }
  
  private void atklatBurtus(ArrayList<Integer> indeksuSaraksts, String ievaditaisBurts) {
    // * Nomaina visus indeksus ar vienādo burtu uz ievadīto burtu. 
    // * Piem.: vārds "bumba" => _ _ _ _ _ , burts: B => B _ _ B _ .

    // Visus saraksta indeksu elementus apmaina ar '*' simbolu.
    for (int indeks : indeksuSaraksts) {
      vardaSkelets[indeks] = ievaditaisBurts + "  "; // "  " ir izvadei atstarpe starp burtiem.
      neatminetieBurti[indeks] = '*';
    }
  }

  private ArrayList<Integer> atrastBurtaIndeksus(String ievaditaisBurts) {
    // * Pārbauda, sadala nezināmo vārdu pa burtiem, un pārbauda katru burtu.
    // * Ja atrod lietotāja ievadīto burtu, tad tā indeksu pievieno sarakstam "indeksuSaraksts".
    // Sadala vārdu pa burtiem.
    String[] sadalitaisVards = izveletaisVards.split("");
    // Šis saraksts uzglabā visus atrastos burtu indeksus.
    ArrayList<Integer> indeksuSaraksts = new ArrayList<>();
    // Pārbauda katru saraksta elementu jeb burtu.
    for (int i = 0; i < sadalitaisVards.length; i++) {
      // Ja atrod burtu, tad pievieno tā indeksu indeksuSarakstā.
      if (sadalitaisVards[i].equals(ievaditaisBurts)) {
        indeksuSaraksts.add(i);
      }
    }
    // Atgriež indeksuSarakstu.
    return indeksuSaraksts;
  }

  private void atklatDazusBurtus() {
    // * Atklāj random burtus, lai spēlētājam būtu vieglāk atminēt vārdu.
    
    // Rand. iespēja atklāt 2 burtus.
    for (int i = Main.rand.nextInt(2) + 1 ; i > 0 ; i--) {
      // Sadala izvēlēto vārdu pa burtiem, un paņem random indeksa elementu jeb vienu burtu.
      apstradatBurtu(izveletaisVards.split("")[Main.rand.nextInt(izveletaisVards.length())]);
    }
  }

  public void restartetKaratavas() {
    // * Metode restartē visus karātavas datus, lai sākot jaunu spēli varētu spēlēt no jauna.
    Karatavas.karatavuKluduSkaits = 0;
    burti = "A B C D E F G H I J K L M N O P R S T U V Z".split(" ");
  }
}
