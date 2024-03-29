package Spele.Konts;

import Spele.Enums.EkranuVeidi;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.IzvadeUzTerminalu;
import Spele.PaligMetodes;
import Spele.Izskati.EkranuIzskati;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.DarbibuIzpilde;

public class LietotajaRegistracija {
  // Jaunā lietotāja dati:
  public static String lietotajvards = ""; // (Username).
  public static String parole = ""; 
  public static String drosibasVards = ""; // Vārds ar kā palīdzību var pieslēgties kontā, ja ir aizmirsta parole.

  public static void registreties() {
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    while (!Ievade.lietotajaIevade.equals("Q")) {
      // Izvada izvadi.
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[6], EkranuVeidi.REGISTRACIJAS_EKRANS));
      
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
      else if (Ievade.lietotajaIevade.equals("SAVE")) {
        // Konta izveidošanas kods:
        FailuRedigetajs.failuVeidotajs(FailuRedigetajs.failuParveidotajsParTekstu());
        Ievade.pilnibaNotiritIevadi(); 
      }

      // FPS (Frames per second).
      try {Thread.sleep(Main.framesPerSecond);} catch (Exception e) {}
      Ievade.notiritIevadi();
    }
    Ievade.pilnibaNotiritIevadi(); // Notīra ievadi, lai ieejot iepriekšējā ciklā, momentāli neiziet arī no tā, jo [ Q ] ir kā unikālais 'atpakaļ' taustiņš.
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
  }

  private static void drosibasVardaIevade() {
    // Max. 15 simboli.
    String pagaiduDrosibasVards;
    while (true) {
      pagaiduDrosibasVards = PaligMetodes.nonemtAtstarpes(vardaIevadesCikls(2));
      // Pārbauda vai vārds atbilst prasībām.
      if (pagaiduDrosibasVards.length() < 16) {
        Main.nodzestTerminali();
        drosibasVards = pagaiduDrosibasVards;
        break;
      }
      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[6], EkranuVeidi.REGISTRACIJAS_EKRANS));
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static void parolesIevade() {
    String pagaiduParole;
    while (true) {
      pagaiduParole = PaligMetodes.nonemtAtstarpes(vardaIevadesCikls(1));
      // Pārbauda vai vārds atbilst prasībām.
      if (pagaiduParole.length() < 16) {
        Main.nodzestTerminali();
        parole = pagaiduParole;
        break;
      }
      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[6], EkranuVeidi.REGISTRACIJAS_EKRANS));
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static void lietotajvardaIevade() {
    // Drīkst būt tikai 10 simbolus garš!
    String pagaiduVards;
    while (true) {
      pagaiduVards = vardaIevadesCikls(0);
      // Pārbauda vai vārds atbilst prasībām.
      if (pagaiduVards.length() < 11) {
        Main.nodzestTerminali();
        lietotajvards = pagaiduVards;
        break;
      }
      // Izvada ekrānu vēlreizs, lai nodzēstu visu lieko tekstu.
      Main.nodzestTerminali();
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[6], EkranuVeidi.REGISTRACIJAS_EKRANS));
    }
    Ievade.pilnibaNotiritIevadi();
  }

  private static String vardaIevadesCikls(int izvelne) {
    Ievade.pilnibaNotiritIevadi();

    String vards; // Lietotāja ievade, ko atgriezīs metode.
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

    // Ļauj rediģēt ievadi pirms to aizsūtīt.
    while (true) {
      if (PaligMetodes.navTuksasIevades(Ievade.lietotajaIevade)) {
        vards = Ievade.neapstradataLietotajaIevade; // Saglabā vārdu.
        
        break;
      }
      // Noliek kursoru atpakaļ.
      else if (Ievade.lietotajaIevade.equals("")) {
        Ievade.pilnibaNotiritIevadi();
        System.out.print(pozicija);
      }
    }

    return vards;
  }
}
