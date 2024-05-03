package Spele.KontaKods;

import java.io.File;
import Spele.Enums.EkranuVeidi;
import Spele.K;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.DarbibuIzpilde;

public class Konts {
  /** Konta doma un darbības.
   * Doma:
   * Konts ļauj lietotājam saglabāt datus teksta failā, uz un no kura programma ieraksta vai nolasa datus, kurus pēc tam izmantos tālākās
   * programmas darbības daļā.
   * 
   * Darbības:
   * Lietotājam ir liela izvēle no darbībām, kuras viņš var izmantot uz sava konta, piem., datu dzēšana, konta dzēšana, datu rediģēšana,
   * funkcija atcerēties viņu, lai katru reizi, kad palaiž porgrammu, lietotājam nebūtu manuāli jāpieslēdzas pie tā, u.c.
   */
  
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

  /** Saglabāt veikala datus uz lietotāja konta:
   * Datu saglabāšanās tiek 'izsaukta' katru reizi, kad lietotājs iziet no veikala.
   * Datu lasīšana no konta tiek izsaukta tikai tad, kad lietotājs palaiž programmu vai, kad pieslēdzas pie sava konta.
   * 
   * 
  */

  public static void kontaIzvelesDarbibas() {
    TastaturasKlausitajs.uzreizNodzestKomandu();
   
    if (lietotajsPiesledzies) {
      kontaApskatesCikls();
    }
    else {
      kontaDarbibuIzvele();
    }

    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.izslegtKomandasTekstaFunkciju();
  }

  private static void kontaDarbibuIzvele() {
    // Rāda izvēli starp pieslēgšanos un reģistrēšanos.
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Uzstāda izvēlni uz 1. pozīciju.

    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      if (Konts.lietotajsPiesledzies) { break; } // Ja lietotājs ir pieslēdzies, tad viņu aizsūta uz konta apskati.

      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.KONTA_IZVELE);
      // 2. Izveido n izvēles opcijas starp kurām var pārslēgties.
      DarbibuIzpilde.izvelnesKustiba(TastaturasKlausitajs.komanda, 2);
      // 3. Visas izvēles jeb darbības, kuras var veikt šinī ekrānā.
      if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 0) {
        /// Pieslēgšanās kods.
        LietotajaPieslegsanas.pieslegties();
      }
      else if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
        /// Reģistrēšanās kods.
        LietotajaRegistracija.registreties();
      }
    }

    DarbibuIzpilde.izvelnesSkaitlis = 0;
  }

  private static void kontaApskatesCikls() {
    // Rāda lietotāja konta informāciju.
    while (!TastaturasKlausitajs.komanda.equals("Q")) { // Cikls turpināsies, kamēr lietotājs neievadīs burtu 'Q'.
      // 1. Ieslēdz iespēju rakstīt un apstrādāt komandas tekstu.
      TastaturasKlausitajs.komandasTekstaFunkcija();
      // 2. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.KONTA_APSKATE);
      // 3. Komandas teksta filtrēšana.
      if (TastaturasKlausitajs.komandasTeksts.equals("RED") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Rediģē konta datus.
        Konts.redigeKontu = true;
        DarbibuIzpilde.izvelnesSkaitlis = 0;
        LietotajaRegistracija.registreties();
        Konts.redigeKontu = false;
      }
      else if (TastaturasKlausitajs.komandasTeksts.equals("DEL") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Izdzēš konta failu.
        FailuRedigetajs.kontuFailuDzesejs();
        displejaLietotajvards = "_ _ _ _ _ _ _ _ _ _";
        break;
      }
      else if (TastaturasKlausitajs.komandasTeksts.equals("ATC") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Liek programmai pierakstīt datus failā, kuru izlasa katru reizi, kad to palaiž. // 'Toggle' slēdzis.
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
      }
      else if (TastaturasKlausitajs.komandasTeksts.equals("IZI") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Iziet no konta.
        FailuRedigetajs.mainitFailaMainigaVertibu("atceretiesMani", "F", K.SAKUMA_DATU_MAPE);
        FailuRedigetajs.mainitFailaMainigaVertibu("lietotajaKontaCels",  "", K.SAKUMA_DATU_MAPE);
        Konts.atceretiesMani = false;
        Konts.lietotajsPiesledzies = false;
        displejaLietotajvards = "_ _ _ _ _ _ _ _ _ _";

        break; // Iziet ārā no šī ekrāna.
      }
      else if (TastaturasKlausitajs.komandasTeksts.equals("SAVE") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Saglabā datus lietotāja kontā.
        SakumaDati.saglabatProgrammasDatusUzKontu();
      }
      else if (TastaturasKlausitajs.komandasTeksts.equals("RESET") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Nodzēš visus konta datus uz sākuma datiem.
        SakumaDati.nodzestProgrammasDatus();
        SakumaDati.nolasitDatusNoKonta();
      }
    }
  }

  public static void notiritLietotajaDatus() {
    ievaditsLietotajvards = false;
    ievaditaParole = false;
    ieavaditsDrosibasVards = false;
    
    lietotajvards = "";
    parole = "";
    drosibasVards = "";

    lietotajvardaNoteikumuKluda = "";
    parolesNoteikumuKluda = "";
    drosibasVardaNoteikumuKluda = "";
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
