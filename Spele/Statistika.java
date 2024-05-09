package Spele;

import java.io.File;
import java.util.ArrayList;

import Spele.Enums.EkranuVeidi;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.TastaturasKlausitajs;

public class Statistika {
  public static ArrayList<ArrayList<Object>> lietotajuTabula = new ArrayList<>();

  static int kolonnasIndekss;
  static String filtrs;

  public static void statistikasKods() {
    TastaturasKlausitajs.ieslegtKomandasTekstaFunkciju();
    aizpilditLietotajuTabulu();

    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      TastaturasKlausitajs.komandasTekstaFunkcija();
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.STATISTIKA);

      if (TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu && TastaturasKlausitajs.komandasTeksts.length() == 4) { //  && PaligMetodes.nonemtAtstarpes(TastaturasKlausitajs.komandasTeksts).length()
        if (TastaturasKlausitajs.komandasTeksts.matches("[0-4]{1}[A-Z]{3}")) { // pirmais ir cipars [0-5] {n} reizes, pēc tam ir lielie burti [A-Z] {n} reizes pēc kārtas.
          // 1. Paņem pirmo teksta ciparu.
          kolonnasIndekss = Integer.parseInt(TastaturasKlausitajs.komandasTeksts.substring(0, 1));
          // 2. Paņem ievadīto komandu jeb filtru.
          filtrs = TastaturasKlausitajs.komandasTeksts.substring(1);

          if (filtrs.equals("AUG")) {
            kartotAugosaSeciba(kolonnasIndekss);
          }
          else if (filtrs.equals("DIL")) {
            kartotDilstosaSeciba(kolonnasIndekss);
          }
        }
      }
    }
  }

  public static void kartotDilstosaSeciba(int kolonna) {
    // Kārto no b -< (n < 0), piem., n,4,3,2,1,0.
    boolean kustiba = false, kartot = (kolonna != 1) ? true : false;

    while (kartot) {
      // 1. Atjauno, ka kustība starp elementiem nav notikusi.
      kustiba = false;
      // 2. Salīdzina vērtības ar citām.
      for (int i = 0; i < lietotajuTabula.size(); i++) {
        // Kamēr nav ārpus saraksta robežas.
        if (i + 1 != lietotajuTabula.size()) {
          // 2.1. Salīdzina 'n' elementu ar 'n+1' elementu.
          if ((int)lietotajuTabula.get(i).get(kolonna) < (int)lietotajuTabula.get(i + 1).get(kolonna)) {
            PaligMetodes.apmainitSarakstaElementu(lietotajuTabula.get(i), lietotajuTabula.get(i + 1), lietotajuTabula);
            kustiba = true;
          }
        }
      }
      // 3. Kad kustību vairāk nav, tad beidz kārtot.
      if (!kustiba) {
        break;
      }
    }
  }

  public static void kartotAugosaSeciba(int kolonna) {
    // Kārto no 0 -> (n > 0), piem., 0,1,2,3,4,5,n.
    boolean kustiba = false, kartot = (kolonna != 1) ? true : false;

    while (kartot) {
      // 1. Atjauno, ka kustība starp elementiem nav notikusi.
      kustiba = false;
      // 2. Salīdzina vērtības ar citām.
      for (int i = 0; i < lietotajuTabula.size(); i++) {
        // Kamēr nav ārpus saraksta robežas.
        if (i + 1 != lietotajuTabula.size()) {
          // 2.1. Salīdzina 'n' elementu ar 'n+1' elementu.
          if ((int)lietotajuTabula.get(i).get(kolonna) > (int)lietotajuTabula.get(i + 1).get(kolonna)) {
            PaligMetodes.apmainitSarakstaElementu(lietotajuTabula.get(i), lietotajuTabula.get(i + 1), lietotajuTabula);
            kustiba = true;
          }
        }
      }
      // 3. Kad kustību vairāk nav, tad beidz kārtot.
      if (!kustiba) {
        break;
      }
    }
  }

  public static ArrayList<Object> savaktLietotajuDatus(String kontaCels, int kartasSkaitlis) {
    /**  Pievieno lietotāja datu sarakstam visas statistikas vērtības.
      Datu pievienošanas secība:

      1. Kārtas skaitlis (Konta pozīcija kontu mapē);
      2. Lietotāj vārds;
      3. Spēles nakts;
      4. Nauda;
      5. Naves Kopā.
    */

    ArrayList<Object> lietotajaDati = new ArrayList<>();

    lietotajaDati.add((int) kartasSkaitlis);
    lietotajaDati.add(FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", kontaCels));
    lietotajaDati.add((int)FailuRedigetajs.intDatuAtgriezejs("spelesNakts", kontaCels));
    lietotajaDati.add((int)FailuRedigetajs.intDatuAtgriezejs("nauda", kontaCels));
    lietotajaDati.add((int)FailuRedigetajs.intDatuAtgriezejs("naves", kontaCels));

    return lietotajaDati;
  }

  public static void aizpilditLietotajuTabulu() {
    // 1. Notīra visus tabulas elementus.
    lietotajuTabula.clear();
    // 2. Atrod visus speles kontus.
    String[] mapesFaili = new File("Spele/KontaKods/Konti").list();
    // 3. Pievieno katra lietotāja datus.
    for (int i = 1; i < mapesFaili.length ; i++) { // ! Ciklu sāk no 1. faila, jo 0. fails ir paraugs, kuru nav jāuzskata par kontu.
      lietotajuTabula.add(savaktLietotajuDatus("Spele/KontaKods/Konti/" + mapesFaili[i], i));
    }
  }
}
