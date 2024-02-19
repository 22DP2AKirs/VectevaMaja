package Spele.Parklajumi;
import java.util.Arrays;

import Spele.K;
import Spele.Spoki;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.SpokuIzskati;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaDarbibas;

// * Pārklāj bildes.
public class BildesParklajumi {

  public static String[] istabasArParklajumiem(String[] originalaisMasivs) {
    // * Atgriež masīvu, kuru izvadīs terminālī (Pēdējā bildes apstrāde).
    // * Metode uz bildes saliek visus pārklājumus.
    // Parametra masīva vērtību pārkopēšana un jauna masīva, lai nebojātu masīvu, kas ir sniegts kā parametrs.
    // kopija - drīkst mainīt, oriģinālā - NEDRĪKST MAINĪT.
    String[] varonaIstabasKopija = Arrays.copyOf(originalaisMasivs, originalaisMasivs.length); // Masīva elementu pārkopēšana. copyOf(kopējamaisMasīvs, cik elementus no masīva nokopēts)

    spokaParklajumuUzlicejs(varonaIstabasKopija); // Uzliek spoka bildes.
    istabuParklajumuUzlicejs(varonaIstabasKopija); // Uzliek apgaismojuma bildes.
    izmantojamoObjektuUzlicejs(varonaIstabasKopija); // Uzliek objektus ar kuriem var darboties varonis.

    istabasGaismasUnSerkocinaParklajumi(varonaIstabasKopija, originalaisMasivs);

    return varonaIstabasKopija;
  }


  private static void spokaParklajumuUzlicejs(String[] mainamaisMasivs) {
    // * Metode uz masīva uzliks visus pārklājumus ar spoka fāzēm.
    // Virtuve ar skatu uz izlietni.
    if (Main.varonaIstabasSkaitlis == 3 && Main.varonaVirzienaSkaitlis == 2) {
      // Pie masīva kopijas pievieno spoka fāzes bildi.
      mainamaisMasivs[1] += "\033[10G" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[0] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
      for (int i = 2; i - 1 < SpokuIzskati.virtPrieksasPagrabaBildesArSpoku.length; i++) { // i - 1, lai sāktu skaitīšanu no 0. rindas.
        mainamaisMasivs[i] += "\033[8G" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
    // Virtuve ar skatu uz logu.
    else if (Main.varonaIstabasSkaitlis == 3 && Main.varonaVirzienaSkaitlis == 1) {
      // Pie masīva kopijas pievieno spoka fāzes bildi.
      for (int i = 3; i - 3 < SpokuIzskati.virtuvesLogaSpokaFazesBilde.length; i++) { // i - 1, lai sāktu skaitīšanu no 0. rindas.
        mainamaisMasivs[i] += "\033[35G" + SpokuIzskati.virtuvesLogaSpokaFazesBilde[i - 3] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
    // Gulta ar skatu uz logu.
    else if (Main.varonaIstabasSkaitlis == 0 && Main.varonaVirzienaSkaitlis == 3) {
      for (int i = 1; i - 1 < SpokuIzskati.gultasLogaSpokaFazesBilde.length; i++) {
        mainamaisMasivs[i] += "\033[40G" + SpokuIzskati.gultasLogaSpokaFazesBilde[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
    // Divans ar skatu uz logu.
    else if (Main.varonaIstabasSkaitlis == 1 && Main.varonaVirzienaSkaitlis == 0) {
      for (int i = 1; i - 1 < SpokuIzskati.divanaLogaSpokaFazesBilde.length; i++) {
        mainamaisMasivs[i] += "\033[26G" + SpokuIzskati.divanaLogaSpokaFazesBilde[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
    // Durvis ar skatu uz logu.
    else if (Main.varonaIstabasSkaitlis == 2 && Main.varonaVirzienaSkaitlis == 0) {
      for (int i = 1; i - 1 < SpokuIzskati.durvjuLogaSpokaFazesBilde.length; i++) {
        mainamaisMasivs[i] += "\033[18G" + SpokuIzskati.durvjuLogaSpokaFazesBilde[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
      }
    }
    // Durvis ar skatu uz durvīm...
    else if (Main.varonaIstabasSkaitlis == 2 && Main.varonaVirzienaSkaitlis == 1) {
      for (int i = 2; i - 2 < SpokuIzskati.durSpokaFazesBilde.length; i++) {
        mainamaisMasivs[i] += "\033[40G" + SpokuIzskati.durSpokaFazesBilde[i - 2] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -2, jo i = mainamāMasīva kārtas rinda. i - 2 = sākt rediģēšanu no otrās rindas.
      }
    }
  }


  private static void istabuParklajumuUzlicejs(String[] mainamaisMasivs) {
      // * Metode uz masīva uzliks visus pārklājumus ar istabu stāvokļiem, piem., istabu gaismas, gaismas istabas stūros, u.c.
      // * Nosaka varona atrasanās vietu ; virzienu uz kurieni skatās varonis.
      // 0. Gulta. ; Prieksa.
      // 1. Dīvāns. ; Laba puse.
      // 2. Durvis. ; Leja.
      // 3. Virtuve. ; Kreisa puse.

      // * Nosaka, kurā no blakus esošajām istabām ir izslēgta gaisma.
      // ^ - Skats uz priekšu.
      // < - Skata kreisā puse.
      // > - Skata labā puse.

      // * Gulta.
      if (Main.varonaIstabasSkaitlis == 0) {

          // ? Priekša.
          if (Main.varonaVirzienaSkaitlis == 0) {
              // ^
              if (!IestatijumuDati.istabuGaismasIeslegtas[1]) {
                  for (int i = 1; i < 13; i++) {
                      mainamaisMasivs[i] += "\033[45G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  }
              }
          }

          // ? Labā puse.
          else if (Main.varonaVirzienaSkaitlis == 1) {
              // <
              String[] gultasLabasPusesKreisaPuse = new String[4];
              if (!IestatijumuDati.istabuGaismasIeslegtas[1]) {
                  gultasLabasPusesKreisaPuse[0] = "\033[5G" + K.TPELEKS + "░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  gultasLabasPusesKreisaPuse[1] = "\033[4G" + K.TPELEKS + "░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  gultasLabasPusesKreisaPuse[2] = "\033[3G" + K.TPELEKS + "░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  gultasLabasPusesKreisaPuse[3] = "\033[2G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              }
              else {
                  gultasLabasPusesKreisaPuse[0] = "\033[5G" + "     " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  gultasLabasPusesKreisaPuse[1] = "\033[4G" + "       " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  gultasLabasPusesKreisaPuse[2] = "\033[3G" + "        " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  gultasLabasPusesKreisaPuse[3] = "\033[2G" + "         " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              }

              mainamaisMasivs[2] += gultasLabasPusesKreisaPuse[0];
              mainamaisMasivs[3] += gultasLabasPusesKreisaPuse[1];
              mainamaisMasivs[4] += gultasLabasPusesKreisaPuse[2];
              for (int i = 5; i < K.BILDES_MASIVA_IZMERS; i++) {
                  mainamaisMasivs[i] += gultasLabasPusesKreisaPuse[3];
              }

              // ^
              if (!IestatijumuDati.istabuGaismasIeslegtas[3]) {
                  for (int i = 1; i < 13; i++) {
                      mainamaisMasivs[i] += "\033[39G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  }
              }
          }

          // ? Leja.
          else if (Main.varonaVirzienaSkaitlis == 2) {
              // <
              String[] gultasLejasKreisaPuse = new String[2];
              if (!IestatijumuDati.istabuGaismasIeslegtas[3]) {
                  gultasLejasKreisaPuse[0] = "\033[2G" + K.TPELEKS + "░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  gultasLejasKreisaPuse[1] = "\033[2G" + K.TPELEKS + "░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              }
              else {
                  gultasLejasKreisaPuse[0] = "\033[2G" + "  " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  gultasLejasKreisaPuse[1] = "\033[2G" + "   " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              }

              mainamaisMasivs[2] += gultasLejasKreisaPuse[0];
              for (int i = 3; i < K.BILDES_MASIVA_IZMERS; i++) {
                  mainamaisMasivs[i] += gultasLejasKreisaPuse[1];
              }
          }
      }


      // * Dīvāns.
      else if (Main.varonaIstabasSkaitlis == 1) {

          // ? Labā puse.
          if (Main.varonaVirzienaSkaitlis == 1) {
              if (!IestatijumuDati.istabuGaismasIeslegtas[2]) {
                  mainamaisMasivs[2] += "\033[57G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[1] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  for (int i = 3; i < 13; i++) {
                      mainamaisMasivs[i] += "\033[55G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  }
              }
          }

          // ? Leja.
          else if (Main.varonaVirzienaSkaitlis == 2) {
              // ^
              if (!IestatijumuDati.istabuGaismasIeslegtas[0]){
                  for (int i = 1; i < 13; i++) {
                      mainamaisMasivs[i] += "\033[23G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  }
              }

              // <
              String[] divanaLejasKreisaPuse = new String[5];
              if (!IestatijumuDati.istabuGaismasIeslegtas[2]) {
                  divanaLejasKreisaPuse[0] = "\033[6G" + K.TPELEKS + "░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  divanaLejasKreisaPuse[1] = K.TPELEKS + "░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  divanaLejasKreisaPuse[2] = "\033[4G" + K.TPELEKS + "░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // Dīvaini 4 atstarpju bīdējumi?????? Tie bija saistīti ar TAB un SPACES.
                  divanaLejasKreisaPuse[3] = "\033[3G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  divanaLejasKreisaPuse[4] = "\033[2G" + K.TPELEKS + "░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              }
              else {
                  divanaLejasKreisaPuse[0] = "\033[6G" + "      " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  divanaLejasKreisaPuse[1] = "       " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  divanaLejasKreisaPuse[2] = "\033[4G" + "        " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  divanaLejasKreisaPuse[3] = "\033[3G" + "         " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  divanaLejasKreisaPuse[4] = "\033[2G" + "          " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              }

              mainamaisMasivs[3] += divanaLejasKreisaPuse[0];
              mainamaisMasivs[4] += "\033[5G" + divanaLejasKreisaPuse[1];
              mainamaisMasivs[5] += divanaLejasKreisaPuse[2];
              mainamaisMasivs[6] += divanaLejasKreisaPuse[3];
              for (int i = 7; i < K.BILDES_MASIVA_IZMERS - 1; i++) {
                  mainamaisMasivs[i] += divanaLejasKreisaPuse[4];
              }
              mainamaisMasivs[15] += "\033[2G" +  divanaLejasKreisaPuse[1];
          }
      }


      // * Durvis.
      else if (Main.varonaIstabasSkaitlis == 2) {

        // ? Labā puse (Durvju puse).
        if (Main.varonaVirzienaSkaitlis == 1) {
          // >
          if (!IestatijumuDati.istabuGaismasIeslegtas[3]) {
            String[] durvjuLabasPusesLabaPuse = new String[2];
            if (!IestatijumuDati.istabuGaismasIeslegtas[3]) {
              durvjuLabasPusesLabaPuse[0] = "\033[80G" + K.TPELEKS + "░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              durvjuLabasPusesLabaPuse[1] = "\033[79G" + K.TPELEKS + "░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
            } 
            else {
              durvjuLabasPusesLabaPuse[0] = "\033[80G" + "  " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              durvjuLabasPusesLabaPuse[1] = "\033[79G" + "   " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
            }

            mainamaisMasivs[4] += durvjuLabasPusesLabaPuse[0];
            for (int i = 5; i < K.BILDES_MASIVA_IZMERS; i++) {
              mainamaisMasivs[i] += durvjuLabasPusesLabaPuse[1];
            }
          }
          
        }

          // ? Leja.
          else if (Main.varonaVirzienaSkaitlis == 2) {
              // ^
              if (!IestatijumuDati.istabuGaismasIeslegtas[3]) {
                  for (int i = 2; i < 13; i++) {
                      mainamaisMasivs[i] += "\033[20G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  }
              }
          }

          // ? Kreisa puse.
          else if (Main.varonaVirzienaSkaitlis == 3) {
              // ^
              if (!IestatijumuDati.istabuGaismasIeslegtas[1]) {
                  mainamaisMasivs[1] += "\033[24G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[1] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  for (int i = 2; i < 13; i++) {
                      mainamaisMasivs[i] += "\033[22G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  }
              }
          }
      }

      // * Virtuve.
      else if (Main.varonaIstabasSkaitlis == 3) {

          // ? Priekša.
          if (Main.varonaVirzienaSkaitlis == 0) {
              // ^
              if (!IestatijumuDati.istabuGaismasIeslegtas[2]) {
                  for (int i = 2; i < 13; i++) {
                      mainamaisMasivs[i] += "\033[48G" + K.TPELEKS + ParklajumuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  }
              }
          }

          // ? Labā puse.
          else if (Main.varonaVirzienaSkaitlis == 1) {
              // <
              String[] virtuvesLabasPusesKreisaPuse = new String[4];
              if (!IestatijumuDati.istabuGaismasIeslegtas[2]) {
                  virtuvesLabasPusesKreisaPuse[0] = "\033[5G" + K.TPELEKS + "░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesKreisaPuse[1] = "\033[4G" + K.TPELEKS + "░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesKreisaPuse[2] = "\033[3G" + K.TPELEKS + "░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesKreisaPuse[3] = "\033[2G" + K.TPELEKS + "░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              } else {
                  virtuvesLabasPusesKreisaPuse[0] = "\033[5G" + "   " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesKreisaPuse[1] = "\033[4G" + "    " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesKreisaPuse[2] = "\033[3G" + "     " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesKreisaPuse[3] = "\033[2G" + "      " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              }

              mainamaisMasivs[4] += virtuvesLabasPusesKreisaPuse[0];
              mainamaisMasivs[5] += virtuvesLabasPusesKreisaPuse[1];
              mainamaisMasivs[6] += virtuvesLabasPusesKreisaPuse[2];
              for (int i = 7; i < K.BILDES_MASIVA_IZMERS; i++) {
                  mainamaisMasivs[i] += virtuvesLabasPusesKreisaPuse[3];
              }

              // > Pagraba gaisma.
              String[] virtuvesLabasPusesPagrabaSkats = new String[6];
              if (!IestatijumuDati.pagrabaGaisma) {
                  virtuvesLabasPusesPagrabaSkats[0] = "\033[71G" + K.TPELEKS + "░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesPagrabaSkats[1] = "\033[70G" + K.TPELEKS + "░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesPagrabaSkats[2] = "\033[70G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // Identisks ar [3] elementu.
                  virtuvesLabasPusesPagrabaSkats[3] = "\033[70G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // Identisks ar [2] elementu.
                  virtuvesLabasPusesPagrabaSkats[4] = "\033[72G" + K.TPELEKS + "░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesPagrabaSkats[5] = "\033[74G" + K.TPELEKS + "░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              } 
              else {
                  virtuvesLabasPusesPagrabaSkats[0] = "\033[70G" + "	   " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesPagrabaSkats[1] = "\033[69G" + "		" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesPagrabaSkats[2] = "\033[69G" + "		 " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesPagrabaSkats[3] = "\033[70G" + "___      " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesPagrabaSkats[4] = "\033[72G" + " \\ __  " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
                  virtuvesLabasPusesPagrabaSkats[5] = "\033[74G" + "\\  \\ " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
              }

              mainamaisMasivs[3] += virtuvesLabasPusesPagrabaSkats[0];
              mainamaisMasivs[4] += virtuvesLabasPusesPagrabaSkats[1];
              for (int i = 5; i < K.BILDES_MASIVA_IZMERS - 3; i++) {
                  mainamaisMasivs[i] += virtuvesLabasPusesPagrabaSkats[2];
              }
              mainamaisMasivs[13] += virtuvesLabasPusesPagrabaSkats[3];
              mainamaisMasivs[14] += virtuvesLabasPusesPagrabaSkats[4];
              mainamaisMasivs[15] += virtuvesLabasPusesPagrabaSkats[5];
          }

          // ? Leja.
          else if (Main.varonaVirzienaSkaitlis == 2) {
            // ^
            if (!IestatijumuDati.pagrabaGaisma && Spoki.spokuStati[2].spokaFazesIndeks < 11) {
              mainamaisMasivs[1] += ParklajumuIzskati.virtuvesPagrabaParklajs[0];
              for (int i = 2; i < 13; i++) {
                mainamaisMasivs[i] += ParklajumuIzskati.virtuvesPagrabaParklajs[1];
              }
            }
          }

          // ? Kreisā puse.
          else if (Main.varonaVirzienaSkaitlis == 3) {
              // ^
              if (!IestatijumuDati.istabuGaismasIeslegtas[0] && Main.varonaVirzienaSkaitlis == 3) {
                  for (int i = 1; i < 13; i++) {
                      mainamaisMasivs[i] += "\033[26G" + ParklajumuIzskati.arkuGaismasAizpilditajs[0];
                  }
              }
          }
      }
  }
  
  
  private static void izmantojamoObjektuUzlicejs(String[] mainamaisMasivs) {
    if (Main.varonaIstabasSkaitlis == 0) {
      if (Main.varonaVirzienaSkaitlis == 1) {
        String[] elektriskaKaste = new String[9]; // Masīvs priekš elektriskās kastes bildes.
        if (IestatijumuDati.elektribaIeslegta) { // Ieslēgts.
          elektriskaKaste[0] = "\033[22G" + K.OBJEKTS + "   _______" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          elektriskaKaste[1] = "\033[22G" + K.OBJEKTS + "  /       |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          elektriskaKaste[2] = "\033[22G" + K.OBJEKTS + " /|  =  ON|" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          elektriskaKaste[3] = "\033[22G" + K.OBJEKTS + "| | _|_   |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          elektriskaKaste[4] = "\033[22G" + K.OBJEKTS + "| |       |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          elektriskaKaste[5] = "\033[22G" + K.OBJEKTS + "| |    OFF|" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          elektriskaKaste[6] = "\033[22G" + K.OBJEKTS + "| |_______|" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          elektriskaKaste[7] = "\033[22G" + K.OBJEKTS + "| /" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          elektriskaKaste[8] = "\033[22G" + K.OBJEKTS + "|/" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
        } 
        // += pieliek pie masīva elementa.
        for (int i = 0; i < elektriskaKaste.length; i++) {
          mainamaisMasivs[i + 1] += elektriskaKaste[i];
        }	
      }
    }
    else if (Main.varonaIstabasSkaitlis == 2) {
      if (Main.varonaVirzienaSkaitlis == 1) {
        if (Main.karatavas) {
          mainamaisMasivs[9] += "\033[21G" + K.OBJEKTS + "/  ~~ /" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          mainamaisMasivs[10] += "\033[20G" + K.OBJEKTS + "/_____/" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
        }
        else {
          mainamaisMasivs[9] += "\033[21G" + "/  ~~ /" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
          mainamaisMasivs[10] += "\033[20G" + "/_____/" + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
        }
      }
    }
  }

  public static String[] istabasGaismasUnSerkocinaParklajumi(String[] mainamaisMasivs, String[] originalaisMasivs) {
    // * Pārbauda istabu, kurā ir varonis, un nosaka vai gaisma tanī būs ieslēgta vai izslēgta, tas pats ar sērkociņu.
    if (!IestatijumuDati.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && !VaronaDarbibas.aizdedzinatsSerkocins) { // Ja gaismas nav, un sērkocins nav aizdedzināts. 0 0
      istabaArIzslegtuGaismu(mainamaisMasivs);
    }
    else if (!IestatijumuDati.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && VaronaDarbibas.aizdedzinatsSerkocins) { // Ja gaismas nav, un aizdedzināts sērkocins. 0 1
      tumsaIstabaArAizdedzinatuSerkocinu(mainamaisMasivs, originalaisMasivs);
    }
    else if (IestatijumuDati.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && VaronaDarbibas.aizdedzinatsSerkocins) { // Ja ir gaisma, un aizdedzināts sērkocins. 1 1
      serkocinaPieliksanaPieBildes(mainamaisMasivs);
    }

    return mainamaisMasivs;
  }


  public static String[] tumsaIstabaArAizdedzinatuSerkocinu(String[] apstradajamaisMasivs, String[] originalaisMasivs) {
    // * Pie apstrādjamā masīva pieliek ar sērkociņu apgaismoto laukumu.
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
    apstradajamaisMasivs[11] += ParklajumuIzskati.serkocinaIzskats[0];
    apstradajamaisMasivs[12] += ParklajumuIzskati.serkocinaIzskats[1];
    apstradajamaisMasivs[13] += ParklajumuIzskati.serkocinaIzskats[2];
    apstradajamaisMasivs[14] += ParklajumuIzskati.serkocinaIzskats[3];
    apstradajamaisMasivs[15] += ParklajumuIzskati.serkocinaIzskats[4];

    return apstradajamaisMasivs;
  }

  public static String[] istabaArIzslegtuGaismu(String[] aizpildamaisMasivs) {
    Arrays.fill(aizpildamaisMasivs, K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET); // Aizpilda visus masīva indeksus ar vienu un to pašu elementu.

    return aizpildamaisMasivs;
  }
}
