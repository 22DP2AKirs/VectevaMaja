package Spele.Veikals;

import java.util.Arrays;

import Spele.K;
import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Izskati.VekalaIzskati;
import Spele.KontaKods.Konts;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.DarbibuIzpilde;

public class VeikalaKods {
  // Kameras varianti.
  public static boolean fotoKamera = true;
  public static boolean videokamera;

  // Paņemti/Izvēlētie piederumi.
  public static boolean izveletaFotokamera;
  public static boolean izveletaVideokamera;

  public static String durvjuSledzaCena = "50";

  // Viena pirkuma uzlabojumi:
  public static boolean durvjuSledzis;

  private static String[] uzlabojumaApraksts = new String[16];

  private static void pievienotLimenaLinijas(String[] mainamaisMasivs, int limenis, int masivaElements) {
    if (limenis == 1) {
      mainamaisMasivs[masivaElements] += "\033[20G=====";
    }
    else if (limenis == 2) {
      mainamaisMasivs[masivaElements] += "\033[20G=====\033[30G=====";
    }
    else if (limenis == 3) {
      mainamaisMasivs[masivaElements] += "\033[20G=====\033[30G=====\033[40G=====";
    }
    else if (limenis == 4) {
      mainamaisMasivs[masivaElements] += "\033[20G=====\033[30G=====\033[40G=====\033[50G=====";
    }
  }

  public static String[] veikalaParklasana(String[] origMasivs) {
    String[] parklajamaisMasivs = Arrays.copyOf(origMasivs, 30);
    // 1. Uzliek veikala piedāvājumus, to līmeņus un cenas.
    parklajamaisMasivs[5] += "\033[15GK A M E R A S" + K.EKRANA_GARUMA_IZMERS;
    parklajamaisMasivs[10] += "\033[15GS E R K O C I N I,   C E N A : " + Serkocini.serkocini.piederumaUzlabojumaCena + K.EKRANA_GARUMA_IZMERS;
    parklajamaisMasivs[15] += "\033[15GD U R V J U   S L E D Z I S,   C E N A : " + durvjuSledzaCena + K.EKRANA_GARUMA_IZMERS;

    if (fotoKamera) {
      parklajamaisMasivs[6] += "\033[20GF O T O   K A M E R A,   C E N A : " + Fotokamera.fotokamera.piederumaUzlabojumaCena + K.EKRANA_GARUMA_IZMERS;
      // Pievieno līmeņa līniju.
      pievienotLimenaLinijas(parklajamaisMasivs, Fotokamera.fotokamera.piederumaLimenis, 8);
      if (Fotokamera.fotokamera.nopirkaPiederumu) {
        for (int i = 0 ; i < 3 ; i++) {
          parklajamaisMasivs[7 + i] += "\033[15G" + VekalaIzskati.LIMENI[i] + "\033[25G" + VekalaIzskati.LIMENI[3 + i] + "\033[35G" + VekalaIzskati.LIMENI[6 + i] + K.EKRANA_GARUMA_IZMERS;
        }
      }
      // Pievieno 'izvēlējās šo piederumu' pogu.
      if (izveletaFotokamera) {
        parklajamaisMasivs[5] += K.ZALS + "\033[30G[P A N E M T S]" + K.RESET + K.EKRANA_GARUMA_IZMERS;
      }
    }
    else {
      parklajamaisMasivs[6] += "\033[20GV I D E O   K A M E R A,   C E N A : " + Videokamera.videokamera.piederumaUzlabojumaCena + K.EKRANA_GARUMA_IZMERS;
      // Pievieno līmeņa līniju.
      pievienotLimenaLinijas(parklajamaisMasivs, Videokamera.videokamera.piederumaLimenis, 8);
      if (Videokamera.videokamera.nopirkaPiederumu) {
        for (int i = 0 ; i < 3 ; i++) {
          parklajamaisMasivs[7 + i] += "\033[15G" + VekalaIzskati.LIMENI[i] + "\033[25G" + VekalaIzskati.LIMENI[3 + i] + "\033[35G" + VekalaIzskati.LIMENI[6 + i] + K.EKRANA_GARUMA_IZMERS;
        }
      }
      // Pievieno 'izvēlējās šo piederumu' pogu.
      if (izveletaVideokamera) {
        parklajamaisMasivs[5] += K.ZALS + "\033[30G[P A N E M T S]" + K.RESET + K.EKRANA_GARUMA_IZMERS;
      }
    }

    if (Serkocini.serkocini.nopirkaPiederumu) {
      for (int i = 0 ; i < 3 ; i++) {
        parklajamaisMasivs[11 + i] += "\033[15G" + VekalaIzskati.LIMENI[i] + "\033[25G" + VekalaIzskati.LIMENI[3 + i] + "\033[35G" + VekalaIzskati.LIMENI[6 + i] + "\033[45G" + VekalaIzskati.LIMENI[9 + i] + K.EKRANA_GARUMA_IZMERS;
      }
    }
    
    // Pievieno sērkociņu līmeņu līniju.
    pievienotLimenaLinijas(parklajamaisMasivs, Serkocini.serkocini.piederumaLimenis, 12);

    // 2. Iekrāso izvēlēto izvēli un izvada uzlabojuma bildi.
    if (DarbibuIzpilde.izvelnesSkaitlis == 0) {
      parklajamaisMasivs[5] += K.ORANZS + "\033[15GK A M E R A S" + K.RESET + K.EKRANA_GARUMA_IZMERS;

      // Izvada priekšmeta bildi.
      if (fotoKamera) {
        for (int i = 0; i < VekalaIzskati.kamerasMasivi[Fotokamera.fotokamera.piederumaLimenis].length ; i++) {
          parklajamaisMasivs[21 + i] += "\033[72G" + VekalaIzskati.kamerasMasivi[Fotokamera.fotokamera.piederumaLimenis][i] + K.EKRANA_GARUMA_IZMERS;
        }
      }
      else {
        for (int i = 0; i < VekalaIzskati.videokamerasMasivi[Videokamera.videokamera.piederumaLimenis].length ; i++) {
          parklajamaisMasivs[21 + i] += "\033[72G" + VekalaIzskati.videokamerasMasivi[Videokamera.videokamera.piederumaLimenis][i] + K.EKRANA_GARUMA_IZMERS;
        }
      }
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 1) {
      parklajamaisMasivs[10] += K.ORANZS + "\033[15GS E R K O C I N I" + K.RESET + K.EKRANA_GARUMA_IZMERS;
      // Izvada priekšmeta bildi.
      for (int i = 0; i < VekalaIzskati.serkocinuMasivi[Serkocini.serkocini.piederumaLimenis].length ; i++) {
        parklajamaisMasivs[21 + i] += "\033[72G" + VekalaIzskati.serkocinuMasivi[Serkocini.serkocini.piederumaLimenis][i] + K.EKRANA_GARUMA_IZMERS;
      }
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 2){
      parklajamaisMasivs[15] += K.ORANZS + "\033[15GD U R V J U   S L E D Z I S" + K.RESET + K.EKRANA_GARUMA_IZMERS;
      // Izvada priekšmeta bildi.
      for (int i = 0; i < VekalaIzskati.spelesUzlabojumuMasivi[0].length ; i++) {
        parklajamaisMasivs[21 + i] += "\033[75G" + VekalaIzskati.spelesUzlabojumuMasivi[0][i] + K.EKRANA_GARUMA_IZMERS;
      }
    }
    
    // 3. Izvada uzlabojuma aprakstu.
    for (int i = 0; i < uzlabojumaApraksts.length ; i++) {
      parklajamaisMasivs[i + 5] += "\033[67G" + uzlabojumaApraksts[i] + K.EKRANA_GARUMA_IZMERS;
    }

    // 4. Uzliek spēlētāja naudu.
    parklajamaisMasivs[25] += "\033[12G" + PaligMetodes.saliktAtstarpesSimboluVirkne("NAUDA:" + SakumaDati.nauda + "$", 1) + K.EKRANA_GARUMA_IZMERS;

    return parklajamaisMasivs;
  }

  public static void veikalaPalaisana() {
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.nodzestKomandasTekstu();
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    
    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      // 1. Definē cikla komandu.
      TastaturasKlausitajs.definetCiklaKomandu();
      // 2. Navigācija starp izvelnēm.
      DarbibuIzpilde.izvelnesKustiba(Main.ciklaKomanda, 3); // Izveido izvēlnes opcijas.
      // 3. Izvade uz ekrānu.
      Izvade.izvadesMasivs = veikalaParklasana(VekalaIzskati.VEIKALA_SKATS); // Izvade uz terminālu.
      // 4. Nosaka darbību.
      if (DarbibuIzpilde.izvelnesSkaitlis == 0) {
        // Kameras:
        kamerasKods(Main.ciklaKomanda);
      }
      else if (DarbibuIzpilde.izvelnesSkaitlis == 1) {
        // Sērkociņi:
        serkocinuKods(Main.ciklaKomanda);
      }
      else if (DarbibuIzpilde.izvelnesSkaitlis == 2) {
        // Durvju slēdzis:
        durvjuSledzaKods(Main.ciklaKomanda);
      }
    }

    Piederumi.saglabatKontaVisuPiederumuDatus();
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }

  private static void durvjuSledzaKods(String komanda) {
    // 1. Saglabā aprakstu:
    uzlabojumaApraksts[0] = "                           _      ";
    uzlabojumaApraksts[1] = "   A T L A U J   A I Z S L E G T  ";
    uzlabojumaApraksts[2] = "       '                          ";
    uzlabojumaApraksts[3] = "D U R V J U   I S T A B A S       ";
    uzlabojumaApraksts[4] = "                                  ";
    uzlabojumaApraksts[5] = "D U R V I S.  D U R V J U         ";
    uzlabojumaApraksts[6] = "                                  ";
    uzlabojumaApraksts[7] = "S P O K A M   I R   M A Z A       ";
    uzlabojumaApraksts[8] = "        _                         ";
    uzlabojumaApraksts[9] = "I E S P E J A   A T S L E G T     ";
    uzlabojumaApraksts[10] = "                                  ";
    uzlabojumaApraksts[11] = "D U R V I S,  K A S   A I Z T U R ";
    uzlabojumaApraksts[12] = "                                  ";
    uzlabojumaApraksts[13] = "T O   U Z   N E N O T E I K T U   ";
    uzlabojumaApraksts[14] = "                                  ";
    uzlabojumaApraksts[15] = "L A I K U.                        ";

    // 2. Veic uzlabojumus.
    if (komanda.equals("SPACE") && !durvjuSledzis && SakumaDati.nauda >= Integer.parseInt(durvjuSledzaCena)) {
      durvjuSledzis = true;
      
      // Atņem naudas summu.
      SakumaDati.nauda -= Integer.parseInt(durvjuSledzaCena);
      FailuRedigetajs.mainitFailaMainigaVertibu("nauda", SakumaDati.nauda+"", Konts.lietotajaKontaCels);

      durvjuSledzaCena = "M A X";
      FailuRedigetajs.mainitFailaMainigaVertibu("durvjuSledzis", "T", Konts.lietotajaKontaCels);
    }
  }

  private static void serkocinuKods(String komanda) {
    // 1. Izvēlas aprakstu.
    if (Serkocini.serkocini.piederumaLimenis == 3) {
      // 1.1. Saglabā aprakstu.
      uzlabojumaApraksts[0] = "               _     _              ";
      uzlabojumaApraksts[1] = "   G A R A N T E   S E R K O C I N A";
      uzlabojumaApraksts[2] = "                  _ v               ";
      uzlabojumaApraksts[3] = "A I Z D E D Z I N A S A N U   N O   ";
      uzlabojumaApraksts[4] = "        _     _       _             ";
      uzlabojumaApraksts[5] = "P I R M A   M E G I N A J U M A.    ";
      uzlabojumaApraksts[6] = "  _             '                   ";
      uzlabojumaApraksts[7] = "S E R K O C I N I   I R   T I K     ";
      uzlabojumaApraksts[8] = "    _   _                 _         ";
      uzlabojumaApraksts[9] = "S P E C I G I,  K A   S P E J       ";
      uzlabojumaApraksts[10] = "        _               _     _     ";
      uzlabojumaApraksts[11] = "I E S L E G T   I Z S L E G T A S   ";
      uzlabojumaApraksts[12] = "                                    ";
      uzlabojumaApraksts[13] = "I S T A B A S   G A I S M U.        ";
      uzlabojumaApraksts[14] = "                                    ";
      uzlabojumaApraksts[15] = "                                    ";
    }
    else {
      // 1.1. Saglabā aprakstu.
      uzlabojumaApraksts[0] = "                         _          ";
      uzlabojumaApraksts[1] = "   P A L I E L I N A   S E R K O -  ";
      uzlabojumaApraksts[2] = "                                    ";
      uzlabojumaApraksts[3] = "C I N U   D A U D Z U M U   U N     ";
      uzlabojumaApraksts[4] = "    '       v                       ";
      uzlabojumaApraksts[5] = "T O   D E G S A N A S   L A I K U.  ";
      uzlabojumaApraksts[6] = "                                    ";
      uzlabojumaApraksts[7] = "            + 5 GAB.                ";
      uzlabojumaApraksts[8] = "  _                         _       ";
      uzlabojumaApraksts[9] = "S E R K O C I N I   A P S T A D I - ";
      uzlabojumaApraksts[10] = "             '            v         ";
      uzlabojumaApraksts[11] = "N A   S T R E S A   A U G S A N U   ";
      uzlabojumaApraksts[12] = "      v _             _             ";
      uzlabojumaApraksts[13] = "T U M S A S   V I E T A S.          ";
      uzlabojumaApraksts[14] = "                                    ";
      uzlabojumaApraksts[15] = "                                    ";
    }

    // 2. Veic uzlabojumus.
    if (komanda.equals("SPACE") && Serkocini.serkocini.piederumaLimenis < 3 && SakumaDati.nauda >= Integer.parseInt(Serkocini.serkocini.piederumaUzlabojumaCena)) {
      // Iegādājas piederumu.
      if (!Serkocini.serkocini.nopirkaPiederumu) {
        Serkocini.serkocini.nopirkaPiederumu = true;
        FailuRedigetajs.mainitFailaMainigaVertibu("nopirktiSerkocini", "T", Konts.lietotajaKontaCels);
      }
      else {
        Serkocini.serkocini.piederumaLimenis++;
      }

      // Atņem pirkuma naudas summu.
      SakumaDati.nauda -= Integer.parseInt(Serkocini.serkocini.piederumaUzlabojumaCena);
      Serkocini.serkocini.atjauninatLimenaVertibas();
    }
  }

  private static void kamerasKods(String komanda) {
    // 1. Pārslēdz variantus.
    if (komanda.equals("D")) {
      videokamera = true;
      fotoKamera = false;
    }
    else if (komanda.equals("A")) {
      fotoKamera = true;
      videokamera = false;
    }
    

    // 2. Izvēlas atbilstošos datus.
    if (fotoKamera) {
      if (Fotokamera.fotokamera.piederumaLimenis < 2) {
        // 2.1. Saglabā aprakstu.
        uzlabojumaApraksts[0] = "                           _        ";
        uzlabojumaApraksts[1] = "   K A M E R A,  K U R A   A T R I  ";
        uzlabojumaApraksts[2] = "  _   _         _   _               ";
        uzlabojumaApraksts[3] = "L A D E J A S   A R A,  B E T       ";
        uzlabojumaApraksts[4] = "    _           _   _               ";
        uzlabojumaApraksts[5] = "S P E J   U Z L A D E T I E S,  J A ";
        uzlabojumaApraksts[6] = "  _                 _               ";
        uzlabojumaApraksts[7] = "T A   I R   I Z S L E G T A   V A I ";
        uzlabojumaApraksts[8] = "      _   _                         ";
        uzlabojumaApraksts[9] = "I Z L A D E J U S I E S.  T O       ";
        uzlabojumaApraksts[10] = "                _                   ";
        uzlabojumaApraksts[11] = "V A R   I E S L E G T   J A   T A I ";
        uzlabojumaApraksts[12] = "              _                     ";
        uzlabojumaApraksts[13] = "I R   V A I R A K   P A R   40 %.   ";
        uzlabojumaApraksts[14] = "                                    ";
        uzlabojumaApraksts[15] = "                                    ";
      }
      else {
        uzlabojumaApraksts[0] = "           _                        ";
        uzlabojumaApraksts[1] = "   I E S P E J O   F U N K C I J U  ";
        uzlabojumaApraksts[2] = "                                    ";
        uzlabojumaApraksts[3] = "'F O T O',  K U R U   V A R   I Z - ";
        uzlabojumaApraksts[4] = "                                    ";
        uzlabojumaApraksts[5] = "M A N T O T   U Z   V I R T U V E S ";
        uzlabojumaApraksts[6] = "                                    ";
        uzlabojumaApraksts[7] = "S P O K A,  L A I   T O   A I Z -   ";
        uzlabojumaApraksts[8] = "        _                      _   _";
        uzlabojumaApraksts[9] = "B I E D E T U.  'F O T O'  B R I D I";
        uzlabojumaApraksts[10] = "                                    ";
        uzlabojumaApraksts[11] = "K A M E R A   Z A U D E   V I S U   ";
        uzlabojumaApraksts[12] = "                _                   ";
        uzlabojumaApraksts[13] = "S A V U   U Z L A D E S   D A U -   ";
        uzlabojumaApraksts[14] = "                                    ";
        uzlabojumaApraksts[15] = "D Z U M U !                         ";
      }

      // 2.2. Apstrādā komandu.
      if (komanda.equals("E") && Fotokamera.fotokamera.nopirkaPiederumu) {
        // Paņem/Izvēlas šo kameru.
        izveletaFotokamera = true;
        izveletaVideokamera = false;
        FailuRedigetajs.mainitFailaMainigaVertibu("izveletaFotokamera", "T", Konts.lietotajaKontaCels);
        FailuRedigetajs.mainitFailaMainigaVertibu("izveletaVideokamera", "F", Konts.lietotajaKontaCels);
      }
      else if (komanda.equals("SPACE") && Fotokamera.fotokamera.piederumaLimenis < 2 && SakumaDati.nauda >= Integer.parseInt(Fotokamera.fotokamera.piederumaUzlabojumaCena)) {
        // Iegādājas piederumu.
        if (!Fotokamera.fotokamera.nopirkaPiederumu) {
          Fotokamera.fotokamera.nopirkaPiederumu = true;
          FailuRedigetajs.mainitFailaMainigaVertibu("nopirktaFotokamera", "T", Konts.lietotajaKontaCels);
        }
        else {
          Fotokamera.fotokamera.piederumaLimenis++;
        }

        // Atņem pirkuma naudas summu.
        SakumaDati.nauda -= Integer.parseInt(Fotokamera.fotokamera.piederumaUzlabojumaCena);
        Fotokamera.fotokamera.atjauninatLimenaVertibas();
      }
    }
    else if (videokamera) {
      // 2.1. Saglabā aprakstu.
      if (Videokamera.videokamera.piederumaLimenis < 2) {
        uzlabojumaApraksts[0] = "                                    ";
        uzlabojumaApraksts[1] = "   V I D E O K A M E R A,  K U R A  ";
        uzlabojumaApraksts[2] = "    _               _               ";
        uzlabojumaApraksts[3] = "S P E J   N O T U R E T   B A T E - ";
        uzlabojumaApraksts[4] = "                                    ";
        uzlabojumaApraksts[5] = "R I J U   I L G U   L A I K U,      ";
        uzlabojumaApraksts[6] = "                _         _   _     ";
        uzlabojumaApraksts[7] = "B E T   J A   T A   I Z L A D E -   ";
        uzlabojumaApraksts[8] = "                                _   ";
        uzlabojumaApraksts[9] = "J A S,  T A D   T O   N E V A R E S ";
        uzlabojumaApraksts[10] = "                                    ";
        uzlabojumaApraksts[11] = "I Z M A N T O T   V I S U           ";
        uzlabojumaApraksts[12] = "            v                       ";
        uzlabojumaApraksts[13] = "A T L I K U S O   N A K T I!        ";
        uzlabojumaApraksts[14] = "                                    ";
        uzlabojumaApraksts[15] = "                                    ";
      }
      else {
        uzlabojumaApraksts[0] = "                                    ";
        uzlabojumaApraksts[1] = "   V I D E O K A M E R A,  I Z -    ";
        uzlabojumaApraksts[2] = "                                    ";
        uzlabojumaApraksts[3] = "M A N T O  9000  V A T U   B A T E -";
        uzlabojumaApraksts[4] = "                                _   ";
        uzlabojumaApraksts[5] = "R I J A S,  K A S   G A R A N T E   ";
        uzlabojumaApraksts[6] = "                                    ";
        uzlabojumaApraksts[7] = "T O,  K A   K A M E R A   N E I Z - ";
        uzlabojumaApraksts[8] = "  _   _                             ";
        uzlabojumaApraksts[9] = "L A D E S I E S   V I S A S   N A - ";
        uzlabojumaApraksts[10] = "                _                   ";
        uzlabojumaApraksts[11] = "K T S   L A I K A.   S K A T O -    ";
        uzlabojumaApraksts[12] = "                                    ";
        uzlabojumaApraksts[13] = "T I E S   C A U R   K A M E R U     ";
        uzlabojumaApraksts[14] = "      _   _                         ";
        uzlabojumaApraksts[15] = "N E T E R E   S T R E S U.          ";
      }

      // 2.2. Apstrādā komandu.
      if (komanda.equals("E") && Videokamera.videokamera.nopirkaPiederumu) {
        // Paņem/Izvēlas šo kameru.
        izveletaVideokamera = true;
        izveletaFotokamera = false;
        FailuRedigetajs.mainitFailaMainigaVertibu("izveletaVideokamera", "T", Konts.lietotajaKontaCels);
        FailuRedigetajs.mainitFailaMainigaVertibu("izveletaFotokamera", "F", Konts.lietotajaKontaCels);
      }
      else if (komanda.equals("SPACE") && Videokamera.videokamera.piederumaLimenis < 2 && SakumaDati.nauda >= Integer.parseInt(Videokamera.videokamera.piederumaUzlabojumaCena)) {
        // Iegādājas piederumu.
        if (!Videokamera.videokamera.nopirkaPiederumu) {
          Videokamera.videokamera.nopirkaPiederumu = true;
          FailuRedigetajs.mainitFailaMainigaVertibu("nopirktaVideokamera", "T", Konts.lietotajaKontaCels);
        }
        else {
          Videokamera.videokamera.piederumaLimenis++;
        }

        // Atņem pirkuma naudas summu.
        SakumaDati.nauda -= Integer.parseInt(Videokamera.videokamera.piederumaUzlabojumaCena);
        Videokamera.videokamera.atjauninatLimenaVertibas();
      }
    }
  }
}