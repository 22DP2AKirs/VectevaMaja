package Spele.KontaKods;

import Spele.Enums.EkranuVeidi;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.K;
import Spele.PaligMetodes;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.DarbibuIzpilde;

public class LietotajaRegistracija {
  public static void registreties() {
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.rakstaKomandasTekstu = false;

    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      // 1. Atļauj rakstīt komandas tekstu.
      TastaturasKlausitajs.komandasTekstaFunkcija();

      // 2. Izvēlas, vai 'metīs' lietotāju ārā no šī ekrāna.
      if (!Konts.redigeKontu) {
        // Ja lietotājs ir pieslēdzies, tad viņu aizsūta uz konta apskati.
        if (Konts.lietotajsPiesledzies) {
          break;
        }
      }

      // 3. Izvēlas, kuru ekrānu izvadīs.
      if (Konts.redigeKontu) {
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.REDIGESANAS_EKRANS);
      }
      else {
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.REGISTRACIJAS_EKRANS);
      }
      
      // 4. Kustina izvēlni.
      DarbibuIzpilde.izvelnesKustiba(TastaturasKlausitajs.komanda, 3);

      // 5. Komandas teksta darbības.
      if (TastaturasKlausitajs.komandasTeksts.equals("SAVE") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Konta datu rediģēšanas kods:
        if (Konts.redigeKontu) {
          // Lietotāja konta dati tiek mainīti uz jaunajiem.
          if (Konts.ievaditsLietotajvards) {
            FailuRedigetajs.mainitFailaMainigaVertibu("Lietotajvards", Konts.lietotajvards, Konts.lietotajaKontaCels);
          }
          
          if (Konts.ievaditaParole) {
            FailuRedigetajs.mainitFailaMainigaVertibu("Parole", Konts.parole, Konts.lietotajaKontaCels);
          }
          
          if (Konts.ieavaditsDrosibasVards) {
            FailuRedigetajs.mainitFailaMainigaVertibu("DrosibasVards", Konts.drosibasVards, Konts.lietotajaKontaCels);
          }
        }
        // Reģistrācijas kods:
        else {
          /// Konta veidošanas kods:
          if (Konts.ievaditsLietotajvards && Konts.ievaditaParole && Konts.ieavaditsDrosibasVards) {
            // 1. Izveido konta failu ar ierakstīto tekstu.
            FailuRedigetajs.failuVeidotajs("#KontaDati:\nLietotajvards=" + Konts.lietotajvards + "\nParole=" + Konts.parole + "\nDrosibasVards=" + Konts.drosibasVards + 
            "\n" + FailuRedigetajs.failuParveidotajsParTekstu("Spele/KontaKods/Konti/KontaParaugs.txt", 4));
            // 2. Izveido ceļu uz konta failu.
            Konts.lietotajaKontaCels = "Spele/KontaKods/Konti/" + Konts.atrastKontuPecLietotajavarda(Konts.lietotajvards);
            // 3. Pieslēdz lietotāja kontu (ieslēdz iespēju to apskatīt un rediģēt).
            Konts.lietotajsPiesledzies = true;
            // 4. Atjauno konta lietotājvārda izskatu (Sākuma ekrānā/Galvenajā ekrānā) => [L  I  E  T  O  T  A  J  S].
            Konts.displejaLietotajvards = PaligMetodes.saliktAtstarpesSimboluVirkne(FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", Konts.lietotajaKontaCels), 1);
          }
        }
        // Nodzēš liekos datus.
        Konts.notiritLietotajaDatus(); // Nodzēš visu datu vērtības.
      }

      // 6. Komandas darbības.
      if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 0 && !TastaturasKlausitajs.rakstaKomandasTekstu) {    
        /// Lietotājvārds.
        lietotajvardaIevade();
      }
      else if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 1 && !TastaturasKlausitajs.rakstaKomandasTekstu) {
        /// Parole.
        parolesIevade();
      }
      else if (TastaturasKlausitajs.komanda.equals("ENTER") && DarbibuIzpilde.izvelnesSkaitlis == 2 && !TastaturasKlausitajs.rakstaKomandasTekstu) {
        /// Drošības vārds.
        drosibasVardaIevade();
      }
    }
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
    Konts.notiritLietotajaDatus();
  }

  private static void lietotajvardaIevade() {
    // Drīkst būt tikai 10 simbolus garš!
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.nodzestKomandasTekstu();

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Ļauj rakstīt komandas tekstu.
      TastaturasKlausitajs.limetKomandasTekstu();
      // 2. Saglabā izveidoto lietotājvārdu.
      Konts.lietotajvards = TastaturasKlausitajs.komandasTeksts;
      // 3. Izvade uz termināli.
      if (Konts.redigeKontu) {
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.REDIGESANAS_EKRANS);
      }
      else {
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.REGISTRACIJAS_EKRANS);
      }

      // 4. Pārbauda vai vārds atbilst prasībām.
      if (Konts.lietotajvards.length() > 0) {
        if (Konts.lietotajvards.length() < 11) {
          if (Konts.parbauditVaiLietotajvardsIrPieejams(Konts.lietotajvards)) {
            Konts.lietotajvardaNoteikumuKluda = "";
            Konts.ievaditsLietotajvards = true;
          }
          else {
            Konts.lietotajvardaNoteikumuKluda = K.SARKANS + "V A R D S  A I Z N E M T S" + K.RESET;
            Konts.ievaditsLietotajvards = false;
          }
        }
        else {
          Konts.lietotajvardaNoteikumuKluda = K.SARKANS + "M A X  10  S I M B." + K.RESET;
        }
      }
      else {
        Konts.ievaditsLietotajvards = false;
      }
    }
    TastaturasKlausitajs.lielieBurti = true;
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }

  private static void parolesIevade() {
    // Drīkst būt 15 simbolus garš!
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.nodzestKomandasTekstu();

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Ļauj rakstīt komandas tekstu.
      TastaturasKlausitajs.limetKomandasTekstu();
      // 2. Saglabā izveidoto paroli.
      Konts.parole = TastaturasKlausitajs.komandasTeksts;
      // 3. Izvade uz termināli.
      if (Konts.redigeKontu) {
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.REDIGESANAS_EKRANS);
      }
      else {
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.REGISTRACIJAS_EKRANS);
      }

      // 4. Pārbauda vai vārds atbilst prasībām.
      if (Konts.parole.length() > 0) {
        if (Konts.parole.length() < 16) {
          // 4.1. Izvēlas, kuru pārbaudi veiks.
          if (Konts.redigeKontu)  {
            if (!Konts.parole.equals(FailuRedigetajs.stringDatuAtgriezejs("Parole", Konts.lietotajaKontaCels))) {
              Konts.parolesNoteikumuKluda = "";
              Konts.ievaditaParole = true;
            }
            else {
              Konts.parolesNoteikumuKluda = K.SARKANS + "V E C A   P A R O L E" + K.RESET;
              Konts.ievaditaParole = false;
            }
          }
          else {
            Konts.parolesNoteikumuKluda = "";
            Konts.ievaditaParole = true;
          }
        }
        else {
          Konts.parolesNoteikumuKluda = K.SARKANS + "M A X  15  S I M B." + K.RESET;
        }
      }
      else {
        // Ja ir tukš lauciņš.
        Konts.ievaditaParole = false;
      }
    }
    TastaturasKlausitajs.lielieBurti = true;
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }

  private static void drosibasVardaIevade() {
    // Drīkst būt 15 simbolus garš!
    TastaturasKlausitajs.nodzestKomandasTekstu();
    TastaturasKlausitajs.uzreizNodzestKomandu();

    while (!TastaturasKlausitajs.komanda.toUpperCase().equals("ENTER")) {
      // 1. Ļauj rakstīt komandas tekstu.
      TastaturasKlausitajs.limetKomandasTekstu();
      // 2. Saglabā izveidoto drosibas v..
      Konts.drosibasVards = TastaturasKlausitajs.komandasTeksts;
      // 3. Izvade uz termināli.
      if (Konts.redigeKontu) {
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.REDIGESANAS_EKRANS);
      }
      else {
        Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.REGISTRACIJAS_EKRANS);
      }

      // 4. Pārbauda vai vārds atbilst prasībām.
      if (Konts.drosibasVards.length() > 0) {
        if (Konts.drosibasVards.length() < 16) {
          // 4.1. Izvēlas, kuru pārbaudi veiks.
          if (Konts.redigeKontu)  {
            if (!Konts.drosibasVards.equals(FailuRedigetajs.stringDatuAtgriezejs("DrosibasVards", Konts.lietotajaKontaCels))) {
              Konts.drosibasVardaNoteikumuKluda = "";
              Konts.ieavaditsDrosibasVards = true;
            }
            else {
              Konts.drosibasVardaNoteikumuKluda = K.SARKANS + "V E C S  D R O S I B. V." + K.RESET;
              Konts.ieavaditsDrosibasVards = false;
            }
          }
          else {
            Konts.drosibasVardaNoteikumuKluda = "";
            Konts.ieavaditsDrosibasVards = true;
          }
        }
        else {
          Konts.drosibasVardaNoteikumuKluda = K.SARKANS + "M A X  15  S I M B." + K.RESET;
        }
      }
      else {
        // Ja ir tukš lauciņš.
        Konts.ieavaditsDrosibasVards = false;
      }
    }
    TastaturasKlausitajs.lielieBurti = true;
    TastaturasKlausitajs.uzreizNodzestKomandu();
  }
}