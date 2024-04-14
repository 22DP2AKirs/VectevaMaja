package Spele.KontaKods;

import java.io.File;
import Spele.Enums.EkranuVeidi;
import Spele.K;
import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.DarbibuIzpilde;

public class Konts {
  // Lietotāja dati:
  public static String lietotajaKontaCels;

  public static String lietotajvards = ""; // (Username).
  public static String parole = ""; 
  public static String drosibasVards = ""; // Vārds ar kā palīdzību var pieslēgties kontā, ja ir aizmirsta parole.
  public static String displejaLietotajvards = "_ _ _ _ _ _ _ _ _ _";

  public static boolean ievaditsLietotajvards;
  public static boolean ievaditaParole;
  public static boolean ieavaditsDrosibasVards;

  public static boolean lietotajsPiesledzies;
  public static boolean atceretiesMani = FailuRedigetajs.booleanDatuAtgriezejs("atceretiesMani", K.SAKUMA_DATU_MAPE);

  public static boolean redigeKontu;

  // Errori vai nosacījumu neievērošanas teksti:
  public static String lietotajvardaNoteikumuKluda = "";
  public static String parolesNoteikumuKluda = "";
  public static String drosibasVardaNoteikumuKluda = "";

  public static void kontaIzvelesDarbibas() {
    TastaturasKlausitajs.uzreizNodzestKomandu();
    // Ja lietotājs jau ir pieslēdzies, tad viņš redzēs sava konta informāciju.
    if (lietotajsPiesledzies) {
      // Cikls turpināsies, kamēr lietotājs neievadīs burtu 'Q'.
      while (!TastaturasKlausitajs.komanda.equals("Q")) {
        String garaKomanda = TastaturasKlausitajs.komandasTeksts;

        TastaturasKlausitajs.ieslegtIespejuRakstitKomandasTekstu();

        // -------- Izvade uz terminālu.
        PaligMetodes.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.KONTA_APSKATES_EKRANS));
        // -------- Izvēles:
        if (garaKomanda.equals("RED") && TastaturasKlausitajs.komanda.equals("ENTER")) {
          Konts.redigeKontu = true;
          DarbibuIzpilde.izvelnesSkaitlis = 0;
          TastaturasKlausitajs.uzreizNodzestKomandu();
          LietotajaRegistracija.registreties();
          Konts.redigeKontu = false;
        }
        else if (garaKomanda.equals("DEL") && TastaturasKlausitajs.komanda.equals("ENTER")) {
          // Konta dzēšanas kods:
          FailuRedigetajs.kontuFailuDzesejs();
          displejaLietotajvards = "_ _ _ _ _ _ _ _ _ _";
          break;
        }
        else if (garaKomanda.equals("ATC") && TastaturasKlausitajs.komanda.equals("ENTER")) {
          // 'Toggle' slēdzis.
          if (Konts.atceretiesMani) {
            Konts.atceretiesMani = false;
            FailuRedigetajs.mainitFailaMainigaVertibu("atceretiesMani", "F", K.SAKUMA_DATU_MAPE);
            FailuRedigetajs.mainitFailaMainigaVertibu("lietotajaKontaCels",  "", K.SAKUMA_DATU_MAPE);
          }
          else {
            Konts.atceretiesMani = true;
            FailuRedigetajs.mainitFailaMainigaVertibu("atceretiesMani", "T", K.SAKUMA_DATU_MAPE);
            FailuRedigetajs.mainitFailaMainigaVertibu("lietotajaKontaCels",  Konts.lietotajaKontaCels, K.SAKUMA_DATU_MAPE);
          }
          TastaturasKlausitajs.sagatavotKomanduDzesanai();
        }
        else if (garaKomanda.equals("IZI") && TastaturasKlausitajs.komanda.equals("ENTER")) {
          FailuRedigetajs.mainitFailaMainigaVertibu("atceretiesMani", "F", K.SAKUMA_DATU_MAPE);
          FailuRedigetajs.mainitFailaMainigaVertibu("lietotajaKontaCels",  "", K.SAKUMA_DATU_MAPE);
          Konts.atceretiesMani = false;
          Konts.lietotajsPiesledzies = false;
          displejaLietotajvards = "_ _ _ _ _ _ _ _ _ _";
          TastaturasKlausitajs.sagatavotKomanduDzesanai();

          break; // Iziet ārā no šī ekrāna.
        }
        // -------- Cikla 'framerate'.
        try {Thread.sleep(Main.framesPerSecond);} catch (Exception e) {}
        TastaturasKlausitajs.nodzestKomandu();
      }
    }
    // Citādi redzēs izvēli starp pieslēgšanos un reģistrēšanos.
    else {
      DarbibuIzpilde.izvelnesSkaitlis = 0; // Uzstāda izvēlni uz 1. pozīciju.
      while (!TastaturasKlausitajs.komanda.equals("Q")) {
        // Ja lietotājs ir pieslēdzies, tad viņu aizsūta uz konta apskati.
        if (Konts.lietotajsPiesledzies) { break; }

        // 1. Izvade uz termināli.
        PaligMetodes.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.KONTA_IZVELES_EKRANS));
        // 2. Izveido n izvēles opcijas starp kurām var pārslēgties.
        DarbibuIzpilde.izvelnesKustiba(TastaturasKlausitajs.komanda, 2);
        // 3. Visas izvēles jeb darbības, kuras var veikt šinī ekrānā.
        /// Pieslēgšanās kods.
        if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 0) {
          DarbibuIzpilde.izvelnesSkaitlis = 0;
          TastaturasKlausitajs.uzreizNodzestKomandu();
          LietotajaPieslegsanas.pieslegties();
        }
        /// Reģistrēšanās kods.
        else if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
          DarbibuIzpilde.izvelnesSkaitlis = 0;
          TastaturasKlausitajs.uzreizNodzestKomandu();
          LietotajaRegistracija.registreties();
        }
        // -------- Cikla beigas.
        try {Thread.sleep(Main.framesPerSecond);} catch (Exception e) {}
        TastaturasKlausitajs.nodzestKomandu();
      }
      TastaturasKlausitajs.uzreizNodzestKomandu();
      DarbibuIzpilde.izvelnesSkaitlis = 0;
    }
  }

  public static void notiritLietotajaDatus() {
    ievaditsLietotajvards = false;
    ievaditaParole = false;
    ieavaditsDrosibasVards = false;
    
    lietotajvards = "";
    parole = "";
    drosibasVards = "";
  }

  public static boolean parbauditVaiLietotajvardsIrPieejams(String parbaudesVards) {
    // Pārbauda katru failu mapē 'Konti', kas nav parauga fails.
    String[] mapesFaili = new File("Spele/KontaKods/Konti").list();
    for (int i = 1; i < mapesFaili.length ; i++) { // ! Ciklu sāk no 1. faila, jo 0. fails ir paraugs, kuru nav jāuzskata par kontu.
      // Ja kontā norādītais vārds jau ir izmantots, tad ... .
      if (FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", "Spele/KontaKods/Konti/" + mapesFaili[i]).equals(parbaudesVards)) {
        // Vārds nav unikāls.
        return false;
      }
    }
    // Vārds ir unikāls.
    return true;
  }

  public static String atrastKontuPecLietotajavarda(String parbaudesVards) {
    // Pārbauda katru failu mapē 'Konti', kas nav parauga fails.
    String[] mapesFaili = new File("Spele/KontaKods/Konti").list();
    for (int i = 1; i < mapesFaili.length ; i++) { // ! Ciklu sāk no 1. faila, jo 0. fails ir paraugs, kuru nav jāuzskata par kontu.
      // Ja konta failā ir atrasts norādītais lietotājvārds, tad ...
      if (FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", "Spele/KontaKods/Konti/" + mapesFaili[i]).equals(parbaudesVards)) {
        // ... atgriež faila nosaukumu.
        return mapesFaili[i];
      }
    }
    // Vārds ir unikāls.
    return null;
  }
}
