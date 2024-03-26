package Spele.Konts;

import Spele.Enums.EkranuVeidi;
import Spele.IzvadeUzTerminalu;
import Spele.Izskati.EkranuIzskati;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.DarbibuIzpilde;

public class LietotajaRegistracija {
  public static void pieslegsanasLogs() {
    // Uzstāda izvēlni uz 1. pozīciju.
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    while (!Ievade.lietotajaIevade.equals("Q")) {
      DarbibuIzpilde.izvelnesKustiba(Ievade.lietotajaIevade, 3);
      
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[5], EkranuVeidi.KONTA_IZVELES_EKRANS));
      try {Thread.sleep(Main.framesPerSecond);}catch (Exception e){}
    }
    DarbibuIzpilde.izvelnesSkaitlis = 0;
    
  }
}
