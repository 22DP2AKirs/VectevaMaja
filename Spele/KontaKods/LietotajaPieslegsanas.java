package Spele.KontaKods;

import Spele.Enums.EkranuVeidi;
import Spele.IzvadeUzTerminalu;
import Spele.K;
import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.DarbibuIzpilde;

public class LietotajaPieslegsanas {
  public static void pieslegties() {
    Konts.lietotajaKontaCels = ""; // Nodzēš ceļu uz kontu, lai pēdējais ceļš nerādītos visu laiku, kad ieiet konta ekrānā.
    while (!Ievade.lietotajaIevade.equals("Q")) {
      // Ja lietotājs ir pieslēdzies, tad viņu aizsūta uz konta apskati.
      if (Konts.lietotajsPiesledzies) {
        break;
      }

      // Izvada izvadi.
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS_EKRANS));
      
      // Kustina izvēlni.
      DarbibuIzpilde.izvelnesKustiba(Ievade.lietotajaIevade, 2);

      /// Lietotājvārds.
      if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 0) {    
        lietotajvardaIevade();
      }
      /// Parole.
      else if (Konts.ievaditsLietotajvards && Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
        parolesIevade();
      }
      /// Drošības vārda ievades kods.
      else if (Konts.ievaditsLietotajvards && Ievade.lietotajaIevade.equals("AIZMIRSU")) {
        drosibasVardaCikls();
      }

      // FPS (Frames per second).
      try {Thread.sleep(Main.framesPerSecond);} catch (Exception e) {}
      Ievade.notiritKomandu();
    }
    Ievade.pilnibaNotiritIevadi(); // Notīra ievadi, lai ieejot iepriekšējā ciklā, momentāli neiziet arī no tā, jo [ Q ] ir kā unikālais 'atpakaļ' taustiņš.
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
    Konts.notiritLietotajaDatus();
  }

  private static void lietotajvardaIevade() {
    // Drīkst būt tikai 10 simbolus garš!
    while (true) {
      // Ievāc lietotāja ievadi.
      Konts.lietotajvards = vardaIevadesCikls(0);

      // Atrod kontu ar norādīto lietotājvārdu.
      String failaNosaukums = Konts.atrastKontuPecLietotajavarda(Konts.lietotajvards);

      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS_EKRANS));
      
      // Ļauj lietotājam iziet no ievades cikla.
      if (Ievade.lietotajaIevade.equals("Q")) {
        Konts.lietotajvards = ""; // Notīra ievades vietu.
        break;
      }

      // Pārbauda vai vārds atbilst prasībām.
      if (failaNosaukums != null) { // Vai konts eksistē?
        if (Konts.lietotajvards.length() < 11) {
          Main.nodzestTerminali();
          Konts.lietotajaKontaCels = "Spele/KontaKods/Konti/" + failaNosaukums;
          Konts.ievaditsLietotajvards = true;
          break;
        }
      }
      // Brīdina, ka vārds ir aizņemts vai neeksistē.
      else {
        // Ja ir neatļauta ievade, tad nokrāso bultiņas sarkanas.
        System.out.println("\033[15;33H" + K.SARKANS + ">>>             " + "\033[51GN A V   T A D A   V A R D A" + K.RESET + "\033[108G");
      }
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static void parolesIevade() {
    while (true) {
      Konts.parole = PaligMetodes.nonemtAtstarpes(vardaIevadesCikls(1));

      // Ļauj lietotājam iziet no ievades cikla.
      if (Ievade.lietotajaIevade.equals("Q")) {
        Konts.parole = ""; // Notīra ievades vietu.
        break;
      }

      // Pārbauda vai vārds atbilst prasībām.
      if (Konts.parole.length() < 16 && Konts.parole.equals(FailuRedigetajs.stringDatuAtgriezejs("Parole", Konts.lietotajaKontaCels))) {
        Main.nodzestTerminali();
        Konts.lietotajsPiesledzies = true;
        Konts.displejaLietotajvards = PaligMetodes.saliktAtstarpesSimboluVirkne(Konts.lietotajvards, 1);
        break;
      }

      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.PIESLEGSANAS_EKRANS));
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static void drosibasVardaCikls() {
    while (!Ievade.lietotajaIevade.equals("Q")) {
      // Ja lietotājs ir pieslēdzies, tad viņu aizsūta uz konta apskati.
      if (Konts.lietotajsPiesledzies) {
        break;
      }

      // Izvada izvadi.
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.DROSIBAS_VARDA_EKRANS));

      if (Ievade.lietotajaIevade.equals("")) {
        drosibasVardaIevade();
      }

      // FPS (Frames per second).
      try {Thread.sleep(Main.framesPerSecond);} catch (Exception e) {}
      Ievade.notiritKomandu();
    }
    Ievade.pilnibaNotiritIevadi(); // Notīra ievadi, lai ieejot iepriekšējā ciklā, momentāli neiziet arī no tā, jo [ Q ] ir kā unikālais 'atpakaļ' taustiņš.
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
  }
  
  private static void drosibasVardaIevade() {
    // Max. 15 simboli.
    while (true) {
      Konts.drosibasVards = PaligMetodes.nonemtAtstarpes(vardaIevadesCikls(2));

      // Ļauj lietotājam iziet no ievades cikla.
      if (Ievade.lietotajaIevade.equals("Q")) {
        // Konts.parole = ""; // Notīra ievades vietu.
        break;
      }

      // Pārbauda vai vārds atbilst prasībām.
      if (Konts.drosibasVards.length() < 16 && Konts.drosibasVards.equals(FailuRedigetajs.stringDatuAtgriezejs("DrosibasVards", Konts.lietotajaKontaCels))) {
        Main.nodzestTerminali();
        Konts.lietotajsPiesledzies = true;
        break;
      }

      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.DROSIBAS_VARDA_EKRANS));
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static String vardaIevadesCikls(int izvelne) {
    Ievade.pilnibaNotiritIevadi();

    String pozicija = ""; // Pozīcija, kur terminālī novietos kursoru.
    
    // Nosaka, kur novietos kursoru.
    if (izvelne == 0) {
      pozicija = "\033[15;37H";
    } else if (izvelne == 1) {
      pozicija = "\033[23;37H";
    }
    else if (izvelne == 2) {
      pozicija = "\033[18;37H";
    }
    System.out.print(pozicija);
    
    return Konts.iegutIevadiApstadinotIzvadi(pozicija);
  }
}