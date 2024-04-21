package Spele.KontaKods;

import Spele.Enums.EkranuVeidi;
import Spele.K;
import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.DarbibuIzpilde;

public class LietotajaPieslegsanas {

  public static void pieslegties() {
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    TastaturasKlausitajs.uzreizNodzestKomandu();
    Konts.lietotajaKontaCels = ""; // Nodzēš ceļu uz kontu, lai pēdējais ceļš nerādītos visu laiku, kad ieiet konta ekrānā.
    TastaturasKlausitajs.ieslegtKomandasTekstaFunkciju();

    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      // Ja lietotājs ir pieslēdzies, tad viņu aizsūta uz konta apskati.
      if (Konts.lietotajsPiesledzies) {
        break;
      }
      
      TastaturasKlausitajs.rakstitKomandasTekstu();

      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS_EKRANS);
      
      // 2. Kustina izvēlni.
      DarbibuIzpilde.izvelnesKustiba(TastaturasKlausitajs.komanda, 2);

      /// 3. Komandas teksta pārbaude.
      if (Konts.ievaditsLietotajvards && TastaturasKlausitajs.komandasTeksts.equals("AIZMIRSU") && TastaturasKlausitajs.komanda.equals("ENTER")) {
        drosibasVardaCikls();
      }

      // 4. Komandas pārbaude.
      /// Lietotājvārds.
      else if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 0) {
        lietotajvardaIevade();
      }
      /// Parole.
      else if (Konts.ievaditsLietotajvards && TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
        TastaturasKlausitajs.uzreizNodzestKomandu();
        parolesIevade();
      }
      

      // 5. Ja visa informācija ir ievadīta, tad pieslēdz kontam.
      if (Konts.ievaditsLietotajvards && (Konts.ievaditaParole || Konts.ieavaditsDrosibasVards)) {
        Konts.lietotajsPiesledzies = true;
        Konts.displejaLietotajvards = PaligMetodes.saliktAtstarpesSimboluVirkne(Konts.lietotajvards, 1);
      }
    }
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
    Konts.notiritLietotajaDatus();
  }

  // ? Lietotājvārda daļa:

  private static void lietotajvardaIevade() {
    // Drīkst būt tikai 10 simbolus garš!
    TastaturasKlausitajs.uzreizNodzestKomandu();

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS_EKRANS);
      // 1. Veido lietotājvārdu.
      TastaturasKlausitajs.limetKomandasTekstu();
      // 2. Saglabā izveidoto lietotājvārdu.
      Konts.lietotajvards = TastaturasKlausitajs.komandasTeksts;
      // 3. Atrod kontu ar norādīto lietotājvārdu.
      String failaNosaukums = Konts.atrastKontuPecLietotajavarda(Konts.lietotajvards);
      // 4. Pārbauda vai liet.vārds atbilst prasībām.
      if (Konts.lietotajvards.length() > 10) {
        Konts.lietotajvardaNoteikumuKluda = K.SARKANS + "M A X  10  S I M B." + K.RESET;
      }
      else if (failaNosaukums != null) {
        Konts.lietotajvardaNoteikumuKluda = "";
        Konts.lietotajaKontaCels = "Spele/KontaKods/Konti/" + failaNosaukums;
        Konts.ievaditsLietotajvards = true;
      }
      else {
        Konts.lietotajvardaNoteikumuKluda = K.SARKANS + "N A V  T A D A  V A R D A" + K.RESET;
        Konts.ievaditsLietotajvards = false;
      }
    }
    TastaturasKlausitajs.lielieBurti = true;
    TastaturasKlausitajs.uzreizNodzestKomandu();

  }

  // ? Paroles daļa:

  private static void parolesIevade() {
    // Drīkst būt tikai 15 simbolus garš!

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS_EKRANS);
      // 1. Veido paroli.
      TastaturasKlausitajs.limetKomandasTekstu();
      // 2. Saglabā izveidoto paroli.
      Konts.parole = TastaturasKlausitajs.komandasTeksts;
      // 4. Pārbauda vai parole atbilst prasībām.
      if (Konts.parole.length() > 15) {
        Konts.parolesNoteikumuKluda = K.SARKANS + "M A X  15  S I M B." + K.RESET;
      }
      else if (Konts.parole.equals(FailuRedigetajs.stringDatuAtgriezejs("Parole", Konts.lietotajaKontaCels))) {
        Konts.parolesNoteikumuKluda = "";
        Konts.ievaditaParole = true;
      }
      else {
        Konts.parolesNoteikumuKluda = K.SARKANS + "N E P A R E I Z A" + K.RESET;
        Konts.ievaditaParole = false;
      }
    }
    TastaturasKlausitajs.lielieBurti = true;
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }

  // ? Drošības vārda daļa:

  private static void drosibasVardaCikls() {
    TastaturasKlausitajs.beigtRakstitKomandasTekstu();
    TastaturasKlausitajs.nodzestKomandasTekstu();

    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      
      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.DROSIBAS_VARDA_EKRANS);
      // 2. Ievada drosības v..
      if (TastaturasKlausitajs.komanda.equals("ENTER")) {
        drosibasVardaIevade();
      }
    }
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
  }
  
  private static void drosibasVardaIevade() {
    // Drīkst būt tikai 15 simbolus garš!
    TastaturasKlausitajs.nodzestKomandasTekstu();

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.DROSIBAS_VARDA_EKRANS);
      // 1. Veido drosibas v..
      TastaturasKlausitajs.limetKomandasTekstu();
      // 2. Saglabā izveidoto drosibas v..
      Konts.drosibasVards = TastaturasKlausitajs.komandasTeksts;
      // 4. Pārbauda vai drosibas v. atbilst prasībām.
      if (Konts.drosibasVards.length() > 15) {
        Konts.drosibasVardaNoteikumuKluda = K.SARKANS + "M A X  15  S I M B." + K.RESET;
      }
      else if (Konts.drosibasVards.equals(FailuRedigetajs.stringDatuAtgriezejs("DrosibasVards", Konts.lietotajaKontaCels))) {
        Konts.drosibasVardaNoteikumuKluda = "";
        Konts.ieavaditsDrosibasVards = true;
      }
      else {
        Konts.drosibasVardaNoteikumuKluda = K.SARKANS + "N E P A R E I Z S" + K.RESET;
        Konts.ieavaditsDrosibasVards = false;
      }
    }
    TastaturasKlausitajs.lielieBurti = true;
  }
}