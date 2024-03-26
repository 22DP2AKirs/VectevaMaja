package Spele.Konts;

import Spele.Enums.EkranuVeidi;
import Spele.IzvadeUzTerminalu;
import Spele.Izskati.EkranuIzskati;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.DarbibuIzpilde;

public class LietotajaRegistracija {
  public static void kontaIzvelesDarbibas() {
    // Uzstāda izvēlni uz 1. pozīciju.
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    while (!Ievade.lietotajaIevade.equals("Q")) {
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[4], EkranuVeidi.KONTA_IZVELES_EKRANS));
      try {Thread.sleep(Main.framesPerSecond);}catch (Exception e){}
        
      DarbibuIzpilde.izvelnesKustiba(Ievade.lietotajaIevade, 2);
      // Pieslēgšanās kods.
      if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 0) {

      }
      // Reģistrēšanās kods.
      else if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
        registreties();
      }

      Ievade.notiritIevadi();
    }
    Ievade.pilnibaNotiritIevadi();
    DarbibuIzpilde.izvelnesSkaitlis = 0;
  }


  private static void registreties() {
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    while (!Ievade.lietotajaIevade.equals("Q")) {
      Ievade.pilnibaNotiritIevadi();

      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[6], EkranuVeidi.REGISTRACIJAS_EKRANS));
      try {Thread.sleep(Main.framesPerSecond);}catch (Exception e){}

      DarbibuIzpilde.izvelnesKustiba(Ievade.lietotajaIevade, 3);

      // Lietotājvārds.
      if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 0) {

      }
      // Parole.
      else if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
        
      }
      // Drošības vārds.
      else if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 2) {
        
      }

      Ievade.notiritIevadi();
    }
    Ievade.pilnibaNotiritIevadi(); // Notīra ievadi, lai ieejot iepriekšējā ciklā, momentāli neiziet arī no tā, jo [ Q ] ir kā unikālais 'atpakaļ' taustiņš.
    DarbibuIzpilde.izvelnesSkaitlis = 0; // Novieto izvēlnes poz. uz pirmo jeb pēc indeksa 0.
  }
}
