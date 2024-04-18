package Spele;

import java.util.Arrays;

import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.VekalaIzskati;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.DarbibuIzpilde;

public class VeikalaKods {
  public static boolean vecaKamera = true;
  public static boolean videokamera;

  // Līmeņi:
  public static int vecasKamerasLimenis;
  public static int videokamerasLimenis;
  public static int serkocinuLimenis;

  // Cenas:
  public static int vecasKamerasUzlabojumaCena;
  public static int videokamerasUzlabojumaCena;
  public static int serkocinuUzlabojumaCena;

  // Viena pirkuma uzlabojumi:
  public static boolean durvjuSledzis;

  private static String[] uzlabojumaApraksts = new String[16];

  public static String[] veikalaParklasana(String[] origMasivs) {
    String[] parklajamaisMasivs = Arrays.copyOf(origMasivs, 30);
    // 1. Uzliek veikala piedāvājumus.
    parklajamaisMasivs[5] += "\033[15GK A M E R A S" + K.EKRANA_GARUMA_IZMERS;
    parklajamaisMasivs[10] += "\033[15GS E R K O C I N I" + K.EKRANA_GARUMA_IZMERS;
    parklajamaisMasivs[15] += "\033[15GD U R V J U   S L E D Z I S" + K.EKRANA_GARUMA_IZMERS;

    if (vecaKamera) {
      parklajamaisMasivs[6] += "\033[20GV E C A   K A M E R A  " + K.EKRANA_GARUMA_IZMERS;
      // Pievieno līmeņa līniju.
      if (vecasKamerasLimenis == 1) {
        parklajamaisMasivs[8] += "\033[20G=====";
      }
      else if (vecasKamerasLimenis == 2) {
        parklajamaisMasivs[8] += "\033[20G=====\033[30G=====";
      }
    }
    else {
      parklajamaisMasivs[6] += "\033[20GV I D E O   K A M E R A" + K.EKRANA_GARUMA_IZMERS;
      // Pievieno līmeņa līniju.
      if (videokamerasLimenis == 1) {
        parklajamaisMasivs[8] += "\033[20G=====";
      }
      else if (videokamerasLimenis == 2) {
        parklajamaisMasivs[8] += "\033[20G=====\033[30G=====";
      }
    }

    // Pievieno sērkociņu līmeņu līniju.
    if (serkocinuLimenis == 1) {
      parklajamaisMasivs[12] += "\033[20G=====";
    }
    else if (serkocinuLimenis == 2) {
      parklajamaisMasivs[12] += "\033[20G=====\033[30G=====";
    }
    else if (serkocinuLimenis == 3) {
      parklajamaisMasivs[12] += "\033[20G=====\033[30G=====\033[40G=====";
    }

    // 2. Iekrāso izvēlēto izvēli un izvada uzlabojuma bildi.
    if (DarbibuIzpilde.izvelnesSkaitlis == 0) {
      parklajamaisMasivs[5] += K.ORANZS + "\033[15GK A M E R A S" + K.RESET + K.EKRANA_GARUMA_IZMERS;

      // Izvada priekšmeta bildi.
      if (vecaKamera) {
        for (int i = 0; i < VekalaIzskati.kamerasMasivi[vecasKamerasLimenis].length ; i++) {
          parklajamaisMasivs[21 + i] += "\033[72G" + VekalaIzskati.kamerasMasivi[vecasKamerasLimenis][i] + K.EKRANA_GARUMA_IZMERS;
        }
      }
      else {
        for (int i = 0; i < VekalaIzskati.videokamerasMasivi[videokamerasLimenis].length ; i++) {
          parklajamaisMasivs[21 + i] += "\033[72G" + VekalaIzskati.videokamerasMasivi[videokamerasLimenis][i] + K.EKRANA_GARUMA_IZMERS;
        }
      }
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 1) {
      parklajamaisMasivs[10] += K.ORANZS + "\033[15GS E R K O C I N I" + K.RESET + K.EKRANA_GARUMA_IZMERS;
      // Izvada priekšmeta bildi.
      for (int i = 0; i < VekalaIzskati.serkocinuMasivi[serkocinuLimenis].length ; i++) {
        parklajamaisMasivs[21 + i] += "\033[72G" + VekalaIzskati.serkocinuMasivi[serkocinuLimenis][i] + K.EKRANA_GARUMA_IZMERS;
      }
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 2){
      parklajamaisMasivs[15] += K.ORANZS + "\033[15GD U R V J U   S L E D Z I S" + K.RESET + K.EKRANA_GARUMA_IZMERS;
      // Izvada priekšmeta bildi.
      for (int i = 0; i < VekalaIzskati.spelesUzlabojumuMasivi[0].length ; i++) {
        parklajamaisMasivs[21 + i] += "\033[75G" + VekalaIzskati.spelesUzlabojumuMasivi[0][i] + K.EKRANA_GARUMA_IZMERS;
      }
    }

    // 3. Uzliek līmeņus.
    /// Kameras kamera.
    for (int i = 0 ; i < 3 ; i++) {
      parklajamaisMasivs[7 + i] += "\033[15G" + VekalaIzskati.LIMENI[i] + "\033[25G" + VekalaIzskati.LIMENI[3 + i] + "\033[35G" + VekalaIzskati.LIMENI[6 + i] + K.EKRANA_GARUMA_IZMERS;
    }
    /// Sērkociņi.
    for (int i = 0 ; i < 3 ; i++) {
      parklajamaisMasivs[11 + i] += "\033[15G" + VekalaIzskati.LIMENI[i] + "\033[25G" + VekalaIzskati.LIMENI[3 + i] + "\033[35G" + VekalaIzskati.LIMENI[6 + i] + "\033[45G" + VekalaIzskati.LIMENI[9 + i] + K.EKRANA_GARUMA_IZMERS;
    }
    
    // 4. Izvada uzlabojuma aprakstu.
    for (int i = 0; i < uzlabojumaApraksts.length ; i++) {
      parklajamaisMasivs[i + 5] += "\033[67G" + uzlabojumaApraksts[i] + K.EKRANA_GARUMA_IZMERS;
    }

    return parklajamaisMasivs;
  }

  public static void veikalaPalaisana() {
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.nodzestKomandasTekstu();
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    String komanda = TastaturasKlausitajs.komanda; // Saglabā komandu.
    
    while (!komanda.equals("Q")) {
      komanda = TastaturasKlausitajs.komanda;
      DarbibuIzpilde.izvelnesKustiba(komanda, 3); // Izveido izvēlnes opcijas.
      PaligMetodes.masivuIzvade(veikalaParklasana(VekalaIzskati.VEIKALA_SKATS)); // Izvade uz terminālu.

      if (DarbibuIzpilde.izvelnesSkaitlis == 0) {
        // Kameras:
        kamerasKods(komanda);
      }
      else if (DarbibuIzpilde.izvelnesSkaitlis == 1) {
        // Sērkociņi:
        serkocinuKods(komanda);
      }
      else if (DarbibuIzpilde.izvelnesSkaitlis == 2) {
        // Durvju slēdzis:
        durvjuSledzaKods(komanda);
      }

      // --- Cikla beigas.
      try { Thread.sleep(Main.framesPerSecond); } catch (Exception e) {}
    }
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
    if (komanda.equals("SPACE") && IestatijumuDati.nauda >= serkocinuUzlabojumaCena && !durvjuSledzis) {
      durvjuSledzis = true;
      TastaturasKlausitajs.uzreizNodzestKomandu();
    }
  }

  private static void serkocinuKods(String komanda) {
    // 1. Izvēlas aprakstu.
    if (serkocinuLimenis == 4) {
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
      uzlabojumaApraksts[7] = "  + 5 GAB.                          ";
      uzlabojumaApraksts[8] = "                                    ";
      uzlabojumaApraksts[9] = "                                    ";
      uzlabojumaApraksts[10] = "                                    ";
      uzlabojumaApraksts[11] = "                                    ";
      uzlabojumaApraksts[12] = "                                    ";
      uzlabojumaApraksts[13] = "                                    ";
      uzlabojumaApraksts[14] = "                                    ";
      uzlabojumaApraksts[15] = "                                    ";
    }

    // 2. Veic uzlabojumus.
    if (komanda.equals("SPACE") && IestatijumuDati.nauda >= serkocinuUzlabojumaCena && serkocinuLimenis + 1 < 4) {
      serkocinuLimenis++;
      TastaturasKlausitajs.uzreizNodzestKomandu();
    }
  }

  private static void kamerasKods(String komanda) {
    // 1. Pārslēdz variantus.
    if (komanda.equals("D")) {
      videokamera = true;
      vecaKamera = false;
    }
    else if (komanda.equals("A")) {
      vecaKamera = true;
      videokamera = false;
    }

    // 2. Izvēlas atbilstošos datus.
    if (vecaKamera) {
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
      // 2.2. Veic uzlabojumus.
      if (komanda.equals("SPACE") && IestatijumuDati.nauda >= vecasKamerasUzlabojumaCena && vecasKamerasLimenis + 1 < 3) {
        vecasKamerasLimenis++;
        TastaturasKlausitajs.uzreizNodzestKomandu();
      }
    }
    else if (videokamera) {
      // 2.1. Saglabā aprakstu.
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
      // 2.2. Veic uzlabojumus.
      if (komanda.equals("SPACE") && IestatijumuDati.nauda >= videokamerasUzlabojumaCena && videokamerasLimenis + 1 < 3) {
        videokamerasLimenis++;
        TastaturasKlausitajs.uzreizNodzestKomandu();
      }
    }
  }
}