package Spele.Varonis;

import Spele.IzvadeUzTerminalu;
import Spele.PaligMetodes;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.EkranuIzskati;
import Spele.Izskati.EkranuIzskati.EkranuVeidi;
import Spele.MazasSpeles.Karatavas;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Main;

public class VaronaStatusaEfekti {
  public static float varonaStresaLimenis;

  public static void varonaStress() {
    // Viss, kas ietekmē varoņa stresa līmeni.
    if (!IestatijumuDati.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && !VaronaDarbibas.aizdedzinatsSerkocins) { // Ja istabā, kurā atrodas varonis ir izslēgta gaisma, tad ...
      varonaStresaLimenis += 0.1;
    }
  }

  public static void noteiktSpelesGalaRezultatu(String iemesls) {
    // * Metode beigs spēles procesu un izvadīs noteikto spēles rezultātu.

    // Cerība uz to, ka termināla izvade beigsies šinī laika intervālā.
    try {Thread.sleep(100);} catch (InterruptedException e) {}


    // Nosaka spēles gala rezultātu.
    if (iemesls.equals("UZVARA")) { // Uzvaras kods.
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[1], EkranuVeidi.UZVARAS_EKRANS));
      PaligMetodes.gulet(5);
    }
    else {
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatZaudesanasEkranu(EkranuIzskati.visiEkrani[2], iemesls));
      PaligMetodes.gulet(5);
    }
    
    // Spēles beigu kods.
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
