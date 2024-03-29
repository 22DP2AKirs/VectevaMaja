package Spele.Konts;

import Spele.Enums.EkranuVeidi;
import Spele.IzvadeUzTerminalu;
import Spele.Izskati.EkranuIzskati;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.DarbibuIzpilde;

public class KontaIzvele {
  public static void kontaIzvelesDarbibas() {
    // Uzstāda izvēlni uz 1. pozīciju.
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    while (!Ievade.lietotajaIevade.equals("Q")) {
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[4], EkranuVeidi.KONTA_IZVELES_EKRANS));
      
      
      // Izvēles veidotājs.
      DarbibuIzpilde.izvelnesKustiba(Ievade.lietotajaIevade, 2);

      // Pieslēgšanās kods.
      if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 0) {

      }
      // Reģistrēšanās kods.
      else if (Ievade.lietotajaIevade.equals("") && DarbibuIzpilde.izvelnesSkaitlis == 1) {
        Ievade.pilnibaNotiritIevadi();
        LietotajaRegistracija.registreties();
      }

      try {Thread.sleep(Main.framesPerSecond);} catch (Exception e) {}
      Ievade.notiritIevadi();
    }
    Ievade.pilnibaNotiritIevadi();
    DarbibuIzpilde.izvelnesSkaitlis = 0;
  }
}
