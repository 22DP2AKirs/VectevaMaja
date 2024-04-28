package Spele.KontaKods;

import Spele.Enums.EkranuVeidi;
import Spele.K;
import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Main;
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
      
      TastaturasKlausitajs.komandasTekstaFunkcija();

      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS);
      
      // 2. Kustina izvēlni.
      DarbibuIzpilde.izvelnesKustiba(TastaturasKlausitajs.komanda, 2);

      // 3. Komandas pārbaude.
      /// Drošības v..
      if (Konts.ievaditsLietotajvards && TastaturasKlausitajs.komandasTeksts.equals("AIZMIRSU") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        drosibasVardaCikls();
      }
      /// Lietotājvārds.
      else if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 0 && !TastaturasKlausitajs.rakstaKomandasTekstu) {
        lietotajvardaIevade();
      }
      /// Parole.
      else if (Konts.ievaditsLietotajvards && TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 1 && !TastaturasKlausitajs.rakstaKomandasTekstu) {
        parolesIevade();
      }
      
      // 4. Ja visa informācija ir ievadīta, tad pieslēdz kontam.
      if (Konts.ievaditsLietotajvards && (Konts.ievaditaParole || Konts.ieavaditsDrosibasVards)) {
        Konts.lietotajsPiesledzies = true;
        Konts.displejaLietotajvards = PaligMetodes.saliktAtstarpesSimboluVirkne(Konts.lietotajvards, 1);
      }
    }

    TastaturasKlausitajs.uzreizNodzestKomandu();
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
    Konts.notiritLietotajaDatus();
  }

  // ? Lietotājvārda daļa:

  private static void lietotajvardaIevade() {
    // Drīkst būt tikai 10 simbolus garš!
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.atslegtaIevade = true;

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS);
      // 2. Ievāc ievadi.
      TastaturasKlausitajs.definetCiklaKomandu();
      // 2. Saglabā izveidoto lietotājvārdu.
      Konts.lietotajvards = TastaturasKlausitajs.limetVardu(Konts.lietotajvards, Main.ciklaKomanda, 10);
      // 3. Atrod kontu ar norādīto lietotājvārdu.
      String failaNosaukums = Konts.atrastKontuPecLietotajavarda(Konts.lietotajvards);
      // 4. Pārbauda vai liet.vārds atbilst prasībām.
      if (failaNosaukums != null) {
        Konts.lietotajvardaNoteikumuKluda = "";
        Konts.lietotajaKontaCels = "Spele/KontaKods/Konti/" + failaNosaukums;
        Konts.ievaditsLietotajvards = true;
      }
      else {
        Konts.lietotajvardaNoteikumuKluda = K.SARKANS + "N A V  T A D A  V A R D A" + K.RESET;
        Konts.ievaditsLietotajvards = false;
      }
    }

    TastaturasKlausitajs.atslegtaIevade = false;
    TastaturasKlausitajs.lielieBurti = true;
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }

  // ? Paroles daļa:

  private static void parolesIevade() {
    // Drīkst būt tikai 15 simbolus garš!
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.atslegtaIevade = true;

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS);
      // 2. Ievāc ievadi.
      TastaturasKlausitajs.definetCiklaKomandu();
      // 3. Saglabā izveidoto paroli, un limitē paroli uz 15 simb..
      Konts.parole = TastaturasKlausitajs.limetVardu(Konts.parole, Main.ciklaKomanda, 15);
      // 4. Pārbauda vai parole atbilst prasībām.
      if (Konts.parole.equals(FailuRedigetajs.stringDatuAtgriezejs("Parole", Konts.lietotajaKontaCels))) {
        Konts.parolesNoteikumuKluda = "";
        Konts.ievaditaParole = true;
      }
      else {
        Konts.parolesNoteikumuKluda = K.SARKANS + "N E P A R E I Z A" + K.RESET;
        Konts.ievaditaParole = false;
      }
    }

    TastaturasKlausitajs.atslegtaIevade = false;
    TastaturasKlausitajs.lielieBurti = true;
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }

  // ? Drošības vārda daļa:

  private static void drosibasVardaCikls() {
    TastaturasKlausitajs.beigtRakstitKomandasTekstu();
    TastaturasKlausitajs.nodzestKomandasTekstu();

    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      // 1. Pārbauda vai lietotājs jau ir ierakstījis pareizo drošības v..
      if (Konts.ieavaditsDrosibasVards) {
        break;
      }
      // 2. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.KONTA_DROSIBAS_V);
      // 3. Ievada drosības v..
      if (TastaturasKlausitajs.komanda.equals("ENTER")) {
        drosibasVardaIevade();
      }
    }

    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }
  
  private static void drosibasVardaIevade() {
    // Drīkst būt tikai 15 simbolus garš!
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.atslegtaIevade = true;

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.KONTA_DROSIBAS_V);
      // 2. Ievāc ievadi.
      TastaturasKlausitajs.definetCiklaKomandu();
      // 2. Saglabā izveidoto drosibas v..
      Konts.drosibasVards = TastaturasKlausitajs.limetVardu(Konts.drosibasVards, Main.ciklaKomanda, 15);
      // 4. Pārbauda vai drosibas v. atbilst prasībām.

      if (Konts.drosibasVards.equals(FailuRedigetajs.stringDatuAtgriezejs("DrosibasVards", Konts.lietotajaKontaCels))) {
        Konts.drosibasVardaNoteikumuKluda = "";
        Konts.ieavaditsDrosibasVards = true;
      }
      else {
        Konts.drosibasVardaNoteikumuKluda = K.SARKANS + "N E P A R E I Z S" + K.RESET;
        Konts.ieavaditsDrosibasVards = false;
      }
    }

    TastaturasKlausitajs.atslegtaIevade = false;
    TastaturasKlausitajs.lielieBurti = true;
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }
}