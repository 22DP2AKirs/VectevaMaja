package Spele.Konts;

import Spele.Enums.EkranuVeidi;
import Spele.IzvadeUzTerminalu;
import Spele.Izskati.EkranuIzskati;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;

public class LietotajaRegistracija {
  public static void pieslegsanasLogs() {
    while (!Ievade.lietotajaIevade.equals("Q")) {
      
      while (!Ievade.lietotajaIevade.equals("")) { // ENTER
        // Izvada pārklātu 'Konta izvades ekrānu'.
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[5], EkranuVeidi.KONTA_IZVELES_EKRANS));
        try {Thread.sleep(Main.framesPerSecond);}catch (Exception e){}
      }
    }
    
  }
}
