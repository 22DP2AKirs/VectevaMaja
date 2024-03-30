package Spele.KontaKods;

import java.io.File;

import Spele.Enums.EkranuVeidi;
import Spele.IzvadeUzTerminalu;
import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.DarbibuIzpilde;

public class Konts {
  // Lietotāja dati:
  public static String lietotajaKontaCels;

  public static String lietotajvards = ""; // (Username).
  public static String parole = ""; 
  public static String drosibasVards = ""; // Vārds ar kā palīdzību var pieslēgties kontā, ja ir aizmirsta parole.

  public static boolean ievaditsLietotajvards;
  public static boolean ievaditaParole;
  public static boolean ieavaditsDrosibasVards;

  public static boolean lietotajsPiesledzies;

  public static void kontaIzvelesDarbibas() {

    // Ja lietotājs jau ir pieslēdzies, tad viņš redzēs sava konta informāciju.
    if (lietotajsPiesledzies) {
      // Cikls turpināsies, kamēr lietotājs neievadīs burtu 'Q'.
      while (!Ievade.lietotajaIevade.equals("Q")) {
        // -------- Izvade uz terminālu.
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.KONTA_APSKATES_EKRANS));
        // -------- Izvēles:
        if (Ievade.lietotajaIevade.equals("RED")) {

        }
        else if (Ievade.lietotajaIevade.equals("IZI")) {
          Konts.lietotajsPiesledzies = false;
        }
        // -------- Cikla 'framerate'.
        try {Thread.sleep(Main.framesPerSecond);} catch (Exception e) {}
      }
    }
    // Citādi redzēs izvēli starp pieslēgšanos un reģistrēšanos.
    else {
      DarbibuIzpilde.izvelnesSkaitlis = 0; // Uzstāda izvēlni uz 1. pozīciju.
      while (!Ievade.lietotajaIevade.equals("Q")) {
        // Ja lietotājs ir pieslēdzies, tad viņu aizsūta uz konta apskati.
        if (Konts.lietotajsPiesledzies) {
          break;
        }

        // -------- Apstrādāta izvade uz termināli.
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.KONTA_IZVELES_EKRANS));
        // -------- Izveido n izvēles opcijas starp kurām var pārslēgties.
        DarbibuIzpilde.izvelnesKustiba(Ievade.lietotajaIevade, 2);
        // -------- Visas izvēles jeb darbības, kuras var veikt šinī ekrānā.
        /// Pieslēgšanās kods.
        if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 0) {
          DarbibuIzpilde.izvelnesSkaitlis = 0;
          Ievade.pilnibaNotiritIevadi();
          LietotajaPieslegsanas.pieslegties();
        }
        /// Reģistrēšanās kods.
        else if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
          DarbibuIzpilde.izvelnesSkaitlis = 0;
          Ievade.pilnibaNotiritIevadi();
          LietotajaRegistracija.registreties();
        }
        // -------- Cikla beigas.
        try {Thread.sleep(Main.framesPerSecond);} catch (Exception e) {}
        Ievade.notiritIevadi();
      }
      Ievade.pilnibaNotiritIevadi();
      DarbibuIzpilde.izvelnesSkaitlis = 0;
    }
  }

  public static String iegutIevadiApstadinotIzvadi(String kursoraPozicija) {
    // Apstādina ekrāna tīrīšanu, ļaujot lietotājam mierīgi ierakstīt ievadi.
    // Ļauj rediģēt ievadi pirms to aizsūta.
    while (true) {
      if (PaligMetodes.navTuksasIevades(Ievade.lietotajaIevade)) {
        return Ievade.neapstradataLietotajaIevade; // Saglabā vārdu.
      }
      // Noliek kursoru atpakaļ.
      else if (Ievade.lietotajaIevade.equals("")) {
        Ievade.pilnibaNotiritIevadi();
        System.out.print(kursoraPozicija);
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
  }

  public static boolean parbauditLietotajvardaPieejamibu(String parbaudesVards) {
    // Pārbauda katru failu mapē 'Konti'.
    for (String kontaNosaukums : new File("Spele/KontaKods/Konti").list()) {
      // Ja kontā norādītais vārds jau ir izmantots, tad ... .
      if (FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", "Spele/KontaKods/Konti/" + kontaNosaukums).equals(parbaudesVards)) {
        // Vārds nav unikāls.
        return false;
      }
    }
    // Vārds ir unikāls.
    return true;
  }

  public static String atrastKontuPecLietotajavarda(String parbaudesVards) {
    // Pārbauda katru failu mapē 'Konti'.
    for (String kontaNosaukums : new File("Spele/KontaKods/Konti").list()) {
      // Ja kontā norādītais vārds jau ir izmantots, tad ... .
      if (FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", "Spele/KontaKods/Konti/" + kontaNosaukums).equals(parbaudesVards)) {
        // Vārds nav unikāls.
        return kontaNosaukums;
      }
    }
    // Vārds ir unikāls.
    return null;
  }
}
