package Spele.MazasSpeles.AtrodiPari;

import java.util.ArrayList;
import java.util.Arrays;

import Spele.PaligMetodes;
import Spele.SpelesProcesi.Main;

// Atrodi pāri algoritms.
// M-Spēles doma:
// Uz galda ir 5 x 5 kārtis (vai vairāk), un lietotājam ir norādot rindu un kolonnu ar
// cipariem 0 - 4 ir jāizvēlas 2 kārtis. Ja kārtis ir vienādas, tad viņas paliek atklātas.
// Ja kārtis ir dažādas, tad viņas apgriežas atpakaļ. Spēli uzvar, kad visas kārtis ir apgriestas.
public class AtrodiPari {
  
  /* Ierobežojumi:  
    ! Rindas un kolonnas abas nedrīkst būt nepāra skaitļi!
    ! Vienam no diviem mainīgajiem ir jābūt pāra.
  */ // Režģis jeb grid:
  private int kolonnas;
  private int rindas;
  private int karsuPari;

  private boolean izvelejasPirmoKarti;

  private int[] otrasKartsPozicija = new int[2];
  private int[] pirmasKartsPozicija = new int[2];

  private static int[] rindasSkaitli = { 1 , 2 , 3 }; // Rindām.
  private static int[] kolonnasSkaitli = { 2 , 4 }; // Kolonnām.

  public static int[][] atklataisRezgis;
  public static int[][] speletajaRezgis;

  public static AtrodiPari atrodiPari;

  public AtrodiPari(int rindas, int kolonnas) {
    this.rindas = rindas;
    this.kolonnas = kolonnas;
    speletajaRezgis = new int[rindas][kolonnas];
    atklataisRezgis = new int[rindas][kolonnas];
    karsuPari = rindas * kolonnas / 2;
  }

  // * Getters:
  public int getRindas() {
    return rindas;
  }

  public int getKolonnas() {
    return kolonnas;
  }
  // TODO var ievadīt kāršu pozīcijas, kuras ir ārpus array robežas!!!!!!!!!!!!!!

  // * Metodes:
  /// Public:
  public ArrayList<String> salipinatKartisVienaSaraksta() {
    ArrayList<String> salimetaBilde = new ArrayList<>(); // Saraksts pie kura pievieno, katru salīmēto rindu.
    String[] bildesRinda = new String[9]; // Masīvs, kurā savienos/pievienos tekstu, un pēc tam pieliks to pie saraksta.

    // Pie saraksta pievieno 4 elementus (rindas), kuras ir domātas priekš kolonnu numurēšanas.
    for (int i = 0 ; i < 4 ; i++) {
      salimetaBilde.add("           ");
    }

    // Saliek saraksta pirmo lielo rindu kā kolonnu sarakstu.
    for (int i = 0 ; i < getKolonnas() ; i++) {
      for (int k = 0 ; k < 4 ; k++) {
        // Izvēlas masīva elementu, paņem tā vērtību, un pie tās pieskaita jauno vērtību.
        salimetaBilde.set(k, salimetaBilde.get(k) + "   " + AtrodiPariIzskati.ciparuMasivs[i][k] + "  | ");
      }
    }
    
    // Lai izveidotu kāršu rāmi.
    Arrays.fill(bildesRinda, " ");
    bildesRinda[8] = "+"; // Lai dizains sakristu.

    // Rindu cikls.
    for (int i = 0; i < getRindas() ; i++) {
      // Cikls pievieno rindas ciparu.   1. ~~~   2. ~~~ u.t.t.
      for (int k = 0; k < 8 ; k++) {
        if (k > 1 && k < 6) {
          bildesRinda[k] += AtrodiPariIzskati.ciparuMasivs[i][k - 2];
        }
        else {
          bildesRinda[k] += "          ";
        }
        bildesRinda[8] = "----------";
      }

      // Kolonnu cikls.
      for (int j = 0 ; j < getKolonnas() ; j++ ) { 
        /* Cikla laikā pie masīva visiem elementiem (rindām) pievienos citu              | 1 | + | pieliktā rinda. |  __\  | 1 || pieliktā rinda. |
           kāršu rindu, kamēr salipinās vienu lielu saraksta rindu jeb izvades rindu.    | 2 | + | pieliktā rinda. |    /  | 2 || pieliktā rinda. |
           Cikls izpildīsies tik reizes, cik izvēlētajā masīvā ir elementu (8).*/
        for (int k = 0 ; k < 8 ; k++) {
          bildesRinda[k] += AtrodiPariIzskati.karsuMasivs[speletajaRezgis[i][j]][k] + " | ";
        }
        bildesRinda[8] += "----------------+";
      }

      // Pievieno lielo saraksta rindu kopējai bildei.
      for (String linija : bildesRinda) {
        salimetaBilde.add(linija);
      }

      // Attīra masīvu no elementiem.
      Arrays.fill(bildesRinda, " ");
    }

    // Atgriež aizpildītu sarakstu.
    return salimetaBilde;
  }

  public static void izveidotJaunuKarsuSpeli() {
    atrodiPari = new AtrodiPari(rindasSkaitli[2] , kolonnasSkaitli[1]); // rindasSkaitli[Main.rand.nextInt(3)], kolonnasSkaitli[Main.rand.nextInt(2)]
  }

  public void sagatavotRezgiSpelesanai() {
    aizpilditRezgi();
    samaisitRezgi();
  }

  public void parbauditKarsuRezultatu() {
    if (karsuPari == 0) {
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
      System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
    }
  }
  
  public void izveletiesKarsuPozicijas(String ievade) {
    if (PaligMetodes.navTuksasIevades(ievade) && PaligMetodes.irSkaitlis(ievade)) {
      parveidotPozicijasIevadiUzIndeksiem(ievade);
    }
  }

  public void izvaditRezgi() {
    // Metode izvada izveidoto masīvu.
    System.out.println("   0. 1. 2. 3.");
    for (int i = 0; i < rindas; i++) {
      System.out.print(i + ". ");
      for (int j = 0; j < kolonnas; j++) {
        System.out.print(speletajaRezgis[i][j] + "  ");
      }
      System.out.println();
    }
  }

  public void izvaditAtklatoRezgi() {
    // Metode izvada izveidoto masīvu.
    System.out.println();
    for (int i = 0; i < rindas; i++) {
      for (int j = 0; j < kolonnas; j++) {
        System.out.print(atklataisRezgis[i][j] + "  ");
      }
      System.out.println();
    }
  }

  /// Private:
  private void aizpilditRezgi() {
    /* Metode aizpilda režģi jeb masīvu ar cipariem no 1 - n.
       Katrs cipars atkārtojas 1 reizi.
    */
    int ciparsXskaitlis = 0; // cipars vai skaitlis, kuru definē kā masīva elementu
    int skaititajs = -1; // Skaita cik reizes iekšējais cikls ir atkārtojies.

    // Cikla beigās, katram skaitlim vai ciparam ir jābūt savam pārim.
    for (int i = 0; i < rindas; i++) {
      for (int j = 0; j < kolonnas ; j++) {
        skaititajs++;
        // Pārbauda vai cikls jau ir atkārtojies 1 reizi un palielina pie masīva pieliekamo ciparu.
        if (skaititajs % 2 == 0) {
          ciparsXskaitlis++;
        }
        // Masīvā ieliek apstrādāto skaitli.
        atklataisRezgis[i][j] = ciparsXskaitlis;
      }
    }
  }

  private void samaisitRezgi() {
    int maisisanasReizes = 30; // 30 reizes, labi samaisa kārtis.
    int elementsKuruMainit; // Saglabā izvēlēto emelento uz noteiktu laiku.

    while (maisisanasReizes-- != 0) {
      // Elementa poz. kuru mainīs.
      int randRinda = Main.rand.nextInt(rindas);
      int randKolonna = Main.rand.nextInt(kolonnas);

      elementsKuruMainit = atklataisRezgis[randRinda][randKolonna];

      // Otrā elementa poz. uz kuru mainīs.
      int randRinda2 = Main.rand.nextInt(rindas);
      int randKolonna2 = Main.rand.nextInt(kolonnas);

      // Nomaina pirmo (izvēlēto) elementu uz otro.
      atklataisRezgis[randRinda][randKolonna] = atklataisRezgis[randRinda2][randKolonna2];

      // Nomaina otro (izvēlēto) elementu uz saglabāto pirmo.
      atklataisRezgis[randRinda2][randKolonna2] = elementsKuruMainit;
    }
  }

  private void nodzestAbuKarsuKoordinatas() {
    // Nodzēš abu kāršu koord. jeb izveido jaunus masīvus.
    pirmasKartsPozicija = new int[2];
    otrasKartsPozicija = new int[2];
  }
  
  private void apgriestKartis() {
    // Ja abu kāršu vērtības ir identiskas, tad tās apgriež (parāda spēlētājaRežģī).
    if (atklataisRezgis[pirmasKartsPozicija[0]][pirmasKartsPozicija[1]] == atklataisRezgis[otrasKartsPozicija[0]][otrasKartsPozicija[1]]) {
      // Nomaina abas spēlētāja režģa elementus.
      speletajaRezgis[pirmasKartsPozicija[0]][pirmasKartsPozicija[1]] = 
      speletajaRezgis[otrasKartsPozicija[0]][otrasKartsPozicija[1]] = 
      atklataisRezgis[pirmasKartsPozicija[0]][pirmasKartsPozicija[1]];

      // Noņem atrastās kārtis no kopējā neatrasto kāršu skaita.
      karsuPari--;
    }
  }

  private void parveidotPozicijasIevadiUzIndeksiem(String ievade) {
    // * Pārbauda vai ievade var būt sadalīta uz 2 elementiem, un ja var, tad sadla tos
    if (ievade.length() == 2) { // 02 vai 53, vai 90 u.t.t..
      String[] masivs = ievade.split(""); // sadala uz , piem., 0 2 vai 5 3, vai 9 0 u.t.t..
      // Integer.parseInt(masivs[0]) [- 1] Samazina lietotāja ievadīto skaitli par 1 vērtību, lai to varētu izmantot kā masīva indeksu.
      if (!izvelejasPirmoKarti) {
        pirmasKartsPozicija[0] = Integer.parseInt(masivs[0]) - 1;
        pirmasKartsPozicija[1] = Integer.parseInt(masivs[1]) - 1;

        // Vieta kārts bildītes nomaiņai.
        System.out.println(pirmasKartsPozicija[0] + ", " + pirmasKartsPozicija[1]);
        System.out.println(otrasKartsPozicija[0] + ", " + otrasKartsPozicija[1]);

        izvelejasPirmoKarti = true;
      }
      else {
        otrasKartsPozicija[0] = Integer.parseInt(masivs[0]) - 1;
        otrasKartsPozicija[1] = Integer.parseInt(masivs[1]) - 1;
        
        // Vieta kārts bildītes nomaiņai.
        System.out.println(pirmasKartsPozicija[0] + ", " + pirmasKartsPozicija[1]);
        System.out.println(otrasKartsPozicija[0] + ", " + otrasKartsPozicija[1]);

        // Tālākais izpildes kods:
        if (!Arrays.equals(pirmasKartsPozicija, otrasKartsPozicija)) {
          apgriestKartis();
        }

        // Nodzēš abu kāršu pozicijas.
        nodzestAbuKarsuKoordinatas();

        izvelejasPirmoKarti = false;
      }
    }
  } 
}