package Spele.KontaKods;

import Spele.Enums.EkranuVeidi;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.IzvadeUzTerminalu;
import Spele.K;
import Spele.PaligMetodes;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.DarbibuIzpilde;

public class LietotajaRegistracija {
  public static void registreties() {
    while (!Ievade.lietotajaIevade.equals("Q")) {

      if (!Konts.redigeKontu) {
        // Ja lietotājs ir pieslēdzies, tad viņu aizsūta uz konta apskati.
        if (Konts.lietotajsPiesledzies) {
          break;
        }
      }
      // Izvada izvadi.
      if (Konts.redigeKontu) {
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.REDIGESANAS_EKRANS));
      }
      else {
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.REGISTRACIJAS_EKRANS));
      }
      
      // Kustina izvēlni.
      DarbibuIzpilde.izvelnesKustiba(Ievade.lietotajaIevade, 3);

      // Izvēles:
      /// Lietotājvārds.
      if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 0) {    
        lietotajvardaIevade();
      }
      /// Parole.
      else if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
        parolesIevade();
      }
      /// Drošības vārds.
      else if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 2) {
        drosibasVardaIevade();
      }
      /// Konta veidošanas kods:
      else if (Ievade.lietotajaIevade.equals("SAVE")) {
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
          if (Konts.ievaditsLietotajvards && Konts.ievaditaParole && Konts.ieavaditsDrosibasVards) {
            // Teksts, kas tiks ievadīts (ierakstīts), katra jaunā konta sākumā.
            String kontaDati = "#KontaDati:\nLietotajvards=" + Konts.lietotajvards + "\nParole=" + Konts.parole + "\nDrosibasVards=" + Konts.drosibasVards + "\n\n";
            FailuRedigetajs.failuVeidotajs(kontaDati + FailuRedigetajs.failuParveidotajsParTekstu("Spele/KontaKods/Konti/KontaParaugs.txt"));
  
            // Tiek mainīti svarīgie dati un izveidots ceļš uz konta failu.
            Konts.lietotajsPiesledzies = true;
            Konts.lietotajaKontaCels = "Spele/KontaKods/Konti/" + Konts.atrastKontuPecLietotajavarda(Konts.lietotajvards);
          }
        }
        // Nodzēš liekos datus.
        Ievade.pilnibaNotiritIevadi(); // Lai neveidotu +150 kontus triju sekunžu laikā.
        Konts.notiritLietotajaDatus(); // Nodzēš visu datu vērtības.
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
      String pagaiduVards = vardaIevadesCikls(0);

      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      if (Konts.redigeKontu) {
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.REDIGESANAS_EKRANS));
      }
      else {
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.REGISTRACIJAS_EKRANS));
      }

      // Ļauj lietotājam iziet no ievades cikla.
      if (Ievade.lietotajaIevade.equals("Q")) {
        // Notīra ievades vietu.
        break;
      }

      // Pārbauda vai vārds atbilst prasībām.
      if (Konts.parbauditLietotajvardaPieejamibu(pagaiduVards)) {
        if (pagaiduVards.length() < 11) {
          Main.nodzestTerminali();
          Konts.lietotajvards = pagaiduVards;
          Konts.ievaditsLietotajvards = true;
          break;
        }
      }
      // Brīdina, ka vārds ir aizņemts.
      else {
        // Ja ir neatļauta ievade, tad nokrāso bultiņas sarkanas.
        System.out.println("\033[8;14H" + K.SARKANS + ">>>             " + "\033[32GV A R D S   A I Z N E M T S" + K.RESET + "\033[108G");
      }
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static void parolesIevade() {
    while (true) {
      String pagaiduParole = PaligMetodes.nonemtAtstarpes(vardaIevadesCikls(1));

      // Ļauj lietotājam iziet no ievades cikla.
      if (Ievade.lietotajaIevade.equals("Q")) {
        // Notīra ievades vietu.
        break;
      }

      // Pārbauda vai vārds atbilst prasībām.
      if (pagaiduParole.length() < 16) {
        Main.nodzestTerminali();
        Konts.parole = pagaiduParole;
        Konts.ievaditaParole = true;
        break;
      }

      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      if (Konts.redigeKontu) {
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.REDIGESANAS_EKRANS));
      }
      else {
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.REGISTRACIJAS_EKRANS));
      }
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static void drosibasVardaIevade() {
    // Max. 15 simboli.
    while (true) {
      String pagaiduDrosibasVards = PaligMetodes.nonemtAtstarpes(vardaIevadesCikls(2));

      // Ļauj lietotājam iziet no ievades cikla.
      if (Ievade.lietotajaIevade.equals("Q")) {
        // Notīra ievades vietu.
        break;
      }

      // Pārbauda vai vārds atbilst prasībām.
      if (pagaiduDrosibasVards.length() < 16) {
        Main.nodzestTerminali();
        Konts.drosibasVards = pagaiduDrosibasVards;
        Konts.ieavaditsDrosibasVards = true;
        break;
      }

      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      if (Konts.redigeKontu) {
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.REDIGESANAS_EKRANS));
      }
      else {
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.REGISTRACIJAS_EKRANS));
      }
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static String vardaIevadesCikls(int izvelne) {
    Ievade.pilnibaNotiritIevadi();

    String pozicija = ""; // Pozīcija, kur terminālī novietos kursoru.

    // Nosaka, kur novietos kursoru.
    if (izvelne == 0) {
      pozicija = "\033[8;20H";
    } else if (izvelne == 1) {
      pozicija = "\033[16;20H";
    }
    else if (izvelne == 2) {
      pozicija = "\033[24;20H";
    }
    System.out.print(pozicija);

    return Konts.iegutIevadiApstadinotIzvadi(pozicija);
  }
}