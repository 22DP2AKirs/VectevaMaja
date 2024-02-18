package Spele.Varonis;

import Spele.IzvadeUzTerminalu;
import Spele.PaligMetodes;
import Spele.Spoki;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.EkranuIzskati;
import Spele.Izskati.EkranuIzskati.EkranuVeidi;
import Spele.MazasSpeles.Karatavas;
import Spele.MazasSpeles.MazoSpeluPalaisanasKods;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Laiks;
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

    // Pārtrauc spēli.
    Main.mainMenu = true;
    Main.spelePalaista = false;

    // Cerība uz to, ka termināla izvade beigsies šinī laika intervālā.
    try {Thread.sleep(200);} catch (InterruptedException e) {}


    // Nosaka spēles gala rezultātu.
    if (iemesls.equals("UZVARA")) { // Uzvaras kods.
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[1], EkranuVeidi.UZVARAS_EKRANS));
      PaligMetodes.gulet(5);
      IestatijumuDati.spelesNakts++;
    }
    else {
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatZaudesanasEkranu(EkranuIzskati.visiEkrani[2], iemesls));
      PaligMetodes.gulet(5);
    }
    
    // Spēles beigu kods.
    Spoki.logaSpoksAktivs = false;
    Spoki.durvjuSpoksAktivs = false;
    Spoki.virtuvesSpoksAktivs = false;

    Laiks.spelesLaiks = 0; // Lai laika threads momentāli neapstātos pēc tā pališanas, atjauno spēles laiku.
    varonaStresaLimenis = 0;
  }
}
