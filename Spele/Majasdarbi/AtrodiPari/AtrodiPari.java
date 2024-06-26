package Spele.Majasdarbi.AtrodiPari;

import java.util.ArrayList;
import java.util.Arrays;

import Spele.K;
import Spele.PaligMetodes;
import Spele.Majasdarbi.MajasdarbuIzvelesKods;
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

  private int izveletaRinda = -1;
  private int izveletaKolonna = -1;

  private boolean izvelejasPirmoKarti;
  private boolean izvelejasOtroKarti;

  // Saglabātās kāršu pozīcijas:
  private int[] otrasKartsPozicija = new int[2];
  private int[] pirmasKartsPozicija = new int[2];

  // Iespējamie tabulas izskati (izmēri):
  private static int[][] tabulasIzmeri = 
  {
    // R - rinda, K - kolonna.
    // R , K.
    { 2 , 2 },
    { 2 , 3 },
    { 2 , 4 },
  };

  // Tabulas ar paslēpto informāciju:
  public static int[][] atklataisRezgis;
  public static int[][] speletajaRezgis;

  // Objekts.
  public static AtrodiPari atrodiPariObjekts;

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

  // * Metodes:
  /// Public:
  public String[] uzMasivu(ArrayList<String> saraksts, String koordTeksts) {
    int elementuSkaits = saraksts.size() + 1;
    String[] masivs = new String[elementuSkaits];

    // 1. Pievieno konsoli, kur var rakstīt izvēlētās kārts koordinātas.
    masivs[0] = ">> " + koordTeksts + "\033[0K";

    // 2. Pārveido sarakstu par masīvu.
    for (int i = 1 ; i != elementuSkaits ; i++) {
      masivs[i] = saraksts.get(i - 1);
    }

    return masivs;
  }

  public ArrayList<String> salipinatKartisVienaSaraksta() {
    ArrayList<String> salimetaBilde = new ArrayList<>(); // Saraksts pie kura pievieno, katru salīmēto rindu.
    String[] bildesRinda = new String[9]; // Masīvs, kurā savienos/pievienos tekstu, un pēc tam pieliks to pie saraksta.

    // Pie saraksta pievieno 4 elementus (rindas), kuras ir domātas priekš kolonnu numurēšanas.
    for (int i = 0 ; i < 4 ; i++) {
      salimetaBilde.add("           ");
    }

    // Saliek saraksta pirmo lielo rindu kā kolonnu sarakstu.
    for (int i = 0 ; i < kolonnas ; i++) {
      for (int k = 0 ; k < 4 ; k++) {
        // Izvēlas masīva elementu, paņem tā vērtību, un pie tās pieskaita jauno vērtību.
        salimetaBilde.set(k, salimetaBilde.get(k) + "   " + AtrodiPariIzskati.ciparuMasivs[i][k] + "  | ");
      }
    }
    
    // Lai izveidotu kāršu rāmi.
    Arrays.fill(bildesRinda, " ");
    bildesRinda[8] = "+"; // Lai dizains sakristu.

    // Rindu cikls.
    for (int i = 0; i < rindas ; i++) {
      /* Cikls pievieno rindas ciparu:
         '1.' k k k k ...
         '2.' k k k ...
      */
      for (int k = 0; k < 8 ; k++) {
        // 1. Pieliek ciparu rindas priekšā.
        if (k > 1 && k < 6) {
          bildesRinda[k] += AtrodiPariIzskati.ciparuMasivs[i][k - 2];
        }
        else {
          bildesRinda[k] += "          ";
        }
        bildesRinda[8] = "----------";
        bildesRinda[k] += K.RESET;
      }

      // Kolonnu cikls.
      for (int j = 0 ; j < kolonnas ; j++ ) { 
        /* Cikla laikā pie masīva visiem elementiem (rindām) pievienos citu              | 1 | + | pieliktā rinda. |  __\  | 1 || pieliktā rinda. |
           kāršu rindu, kamēr salipinās vienu lielu saraksta rindu jeb izvades rindu.    | 2 | + | pieliktā rinda. |    /  | 2 || pieliktā rinda. |
           Cikls izpildīsies tik reizes, cik izvēlētajā masīvā ir elementu (8).*/
        for (int k = 0 ; k < 8 ; k++) {
          // 1. Ja lietotājs ir izvēlējies šo kolonnu, tad iekrāso to.
          if (j == izveletaKolonna) {
            bildesRinda[k] += K.DZELTENS;
          }

          // 1. Ja lietotājs ir izvēlējies šo rindu, tad iekrāso to.
          if (i == izveletaRinda) {
            bildesRinda[k] += K.DZELTENS;
          }


          bildesRinda[k] += AtrodiPariIzskati.karsuMasivs[speletajaRezgis[i][j]][k] + K.RESET +" | ";
        }
        bildesRinda[8] += "----------------+";
      }

      // Pievieno katru masīva līniju (elementu) sarakstam.
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
    // Izvēlas vienu no 10 tabulas izmēru kombinācijām.
    int izmeruKombinacija = Main.rand.nextInt(3);
    // Izveido tabulu pēc izvēlētās kombinācijas izmēriem (0 - pirmais cipars (y), 1 - otrs (x)).
    atrodiPariObjekts = new AtrodiPari(tabulasIzmeri[izmeruKombinacija][0], tabulasIzmeri[izmeruKombinacija][1]);
    atrodiPariObjekts.sagatavotRezgiSpelesanai();
  }

  private void sagatavotRezgiSpelesanai() {
    aizpilditRezgi();
    samaisitRezgi();
  }

  public void parbauditKarsuRezultatu() {
    if (karsuPari == 0) {
      AtrodiPariSavienojums.MDAtrodiPari = false;
      AtrodiPariSavienojums.ievaditasKoord = "";
      MajasdarbuIzvelesKods.izpildijaMajasdarbu();
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
       Katrs cipars atkārtojas 1 reizi.*/
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
  
  private void apgriestKartisAtpakal() {
    // Ja abu kāršu vērtības ir identiskas, tad tās apgriež (parāda spēlētājaRežģī).
    if (atklataisRezgis[pirmasKartsPozicija[0]][pirmasKartsPozicija[1]] == atklataisRezgis[otrasKartsPozicija[0]][otrasKartsPozicija[1]]) {
      // Nodzēš skaitli no atklātā režģa, aizliedzot to atminēt vēlreiz.
      atklataisRezgis[pirmasKartsPozicija[0]][pirmasKartsPozicija[1]] = atklataisRezgis[otrasKartsPozicija[0]][otrasKartsPozicija[1]] = 0;

      karsuPari--;
    }
    else {
      // Ja kāda no nevienādā pāra kārtīm bija jau atminēta, tad to neapgriež atpakaļ, bet ja nebija, tad apgriež.
      if (speletajaRezgis[pirmasKartsPozicija[0]][pirmasKartsPozicija[1]] != 0) {
        speletajaRezgis[pirmasKartsPozicija[0]][pirmasKartsPozicija[1]] = 0;
      }

      if (speletajaRezgis[otrasKartsPozicija[0]][otrasKartsPozicija[1]] != 0) {
        speletajaRezgis[otrasKartsPozicija[0]][otrasKartsPozicija[1]] = 0;
      }
    }
  }

  public void parbauditIevadi(String komanda, String koordTeksts) {
    // Ievadei ir jāsastāv no 2 cipariem, piem., '25' vai '91', vai '02' u.t.t.
   
    // 1. Pārbauda vai komanda atbilst prasībām.
    if (komanda.equals("ENTER") && PaligMetodes.irSkaitlis(koordTeksts) && koordTeksts.length() == 2) {
      apstradatIevadi(koordTeksts);
    }
  }

  private void apstradatIevadi(String ievade) {
    // * Metode pārveido iegūto tekstu par 2 int[] elementiem, kuri atbilsts 0 - rindai, 1 - kolonnai.
    String[] masivs = ievade.split(""); // sadala uz , piem., 0 2 vai 5 3, vai 9 0 u.t.t..
    int[] ciparuMasivs = {Integer.parseInt(masivs[0]), Integer.parseInt(masivs[1])}; // Pārveido abus masīva teksta elementus par int.

    // Ja ievadītie skaitļi ir ārpus masīva robežām, tad to ievadi ignorē.
    if (ciparuMasivs[0] <= rindas && ciparuMasivs[0] > 0 && ciparuMasivs[1] <= kolonnas && ciparuMasivs[1] > 0) {
      saglabatKarsuPozicijas(ciparuMasivs);
    }
  }

  private void saglabatKarsuPozicijas(int[] kartsKoordinatas) {
    if (!izvelejasPirmoKarti) {
      // ciparuMasivs[x] '- 1' Samazina lietotāja ievadīto skaitli par 1 vērtību, lai to varētu izmantot kā masīva indeksu.
      pirmasKartsPozicija[0] = kartsKoordinatas[0] - 1;
      pirmasKartsPozicija[1] = kartsKoordinatas[1] - 1;

      // Pārbaude, vai ievadītās koordinātes ir atļautas (nav jau atminētas).
      if (speletajaRezgis[pirmasKartsPozicija[0]][pirmasKartsPozicija[1]] == 0) {
        // Vieta kārts bildītes nomaiņai.
        apgriestIzveletoKarti(pirmasKartsPozicija);
        izvelejasPirmoKarti = true;
      }
    }
    else {
      otrasKartsPozicija[0] = kartsKoordinatas[0]- 1;
      otrasKartsPozicija[1] = kartsKoordinatas[1] - 1;

      // Pārbaude, vai ievadītās koordinātes ir atļautas (nav jau atminētas).
      if (speletajaRezgis[otrasKartsPozicija[0]][otrasKartsPozicija[1]] == 0) {
        // Vieta kārts bildītes nomaiņai.
        apgriestIzveletoKarti(otrasKartsPozicija);
        izvelejasOtroKarti = true;
      }
    }
  }

  public void abuKarsuKoordinasuParbaude() {
    // Tālākais izpildes kods:
    if (!Arrays.equals(pirmasKartsPozicija, otrasKartsPozicija) && izvelejasPirmoKarti && izvelejasOtroKarti) {
      // Ļauj lietotājam redzēt kādas kārtis ir apgriestas.
      PaligMetodes.gulet(1);
      
      // Nevienādās kārtis apgriež ar muguru uz augšu.
      apgriestKartisAtpakal();

      // Nodzēš abu kāršu pozicijas.
      nodzestAbuKarsuKoordinatas();

      // Atļauj vadīt jaunas koord. priekš kārtīm.
      izvelejasPirmoKarti = izvelejasOtroKarti = false;
    }
  }

  private void apgriestIzveletoKarti(int[] kartsKoordinatas) {
    // Pārbauda vai kārts jau bija atminēta.
    if (atklataisRezgis[kartsKoordinatas[0]][kartsKoordinatas[1]] != 0) {
      speletajaRezgis[kartsKoordinatas[0]][kartsKoordinatas[1]] = atklataisRezgis[kartsKoordinatas[0]][kartsKoordinatas[1]];
    }
  }

  public void izveletiesKoIekrasot(String koordinatas) {
    if (PaligMetodes.irSkaitlis(koordinatas)) {
      // Ja komanda nav 'garāka par 2 simboliem'
      if (!(koordinatas.length() > 2)) {
        if (koordinatas.length() == 1) {
          izveletaRinda = Character.getNumericValue(koordinatas.charAt(0)) - 1;
          izveletaKolonna = -1; // Vērtība, kura nevar tikt izmantota sarakstā.
        }
        else if (koordinatas.length() == 2) {
          izveletaKolonna = Character.getNumericValue(koordinatas.charAt(1)) - 1;
        }      
      }
    }
    else {
      izveletaRinda = -1;
      izveletaKolonna = -1;
    }
  }

}