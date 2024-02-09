package Spele.Varonis;

import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.MazasSpeles.Karatavas;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Main;

public class VaronaStatusaEfekti {
  public static float varonaStresaLimenis;

  public static void varonaStress() {
    // Viss, kas ietekmē varoņa stresa līmeni.
    if (!Main.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && !VaronaDarbibas.aizdedzinatsSerkocins) { // Ja istabā, kurā atrodas varonis ir izslēgta gaisma, tad ...
      varonaStresaLimenis += 0.1;
    }
  }

  public static void varonaBojaeja (String iemesls) {
    Main.varonisDzivs = false;
    try {Thread.sleep(100);} catch (InterruptedException e) {} // Cerība uz to, ka termināla izvade beigsies šinī laika intervālā.
    
    // Bojāejas pamatojuma kods:
    if (iemesls.equals("loga")) {

    }
    else if (iemesls.equals("karatavas")) {
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\karatavas_pakarts.wav", 6);
    }
    
    
    // Bojāejas rezultāts.
    Main.spelePalaista = false;
    restartetKaratavas();
  }
  
  private static void restartetKaratavas() {
    // Metode restartē visus karātavas datus, lai sākot jaunu spēli varētu spēlēt no jauna.
    Main.varonisIrMazajaSpele = false;
    Karatavas.karatavuKluduSkaits = 0;
    Karatavas.atminejaVardu = false;
    EkranuParklajumi.burti = "A B C D E F G H I J K L M N O P R S T U V Z".split(" ");
  }
}
