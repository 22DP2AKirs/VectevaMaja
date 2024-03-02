package Spele.Varonis;

import Spele.IzvadeUzTerminalu;
import Spele.PaligMetodes;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.EkranuIzskati;
import Spele.Enums;
import Spele.Enums.EkranuVeidi;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.SavienotaisKaratavuKods;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Laiks;
import Spele.SpelesProcesi.Main;
import Spele.Spoki.DurvjuSpoks;
// import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
// import Spele.Spoki.VirtuvesSpoks;
import Spele.Spoki.VirtuvesSpoks;

public class VaronaStatusaEfekti {
  public static float varonaStresaLimenis;

  public static void varonaStress() {
    // Viss, kas ietekmē varoņa stresa līmeni.
    if (!IestatijumuDati.istabuGaismasIeslegtas[Enums.V_Istaba.CIPARS] && !VaronaDarbibas.aizdedzinatsSerkocins) { // Ja istabā, kurā atrodas varonis ir izslēgta gaisma, tad ...
      varonaStresaLimenis += 0.1;
    }
  }

  public static void parbauditEffektus() {
    // Ja varona stresa līmenis pārsniedz 100.
    if (VaronaStatusaEfekti.varonaStresaLimenis > 100.0) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("STRESS");
    }
    // Ja zaudē karātavas.
    else if (Karatavas.karatavuKluduSkaits > 7) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("KARATAVAS");
    }
  }

  public static void noteiktSpelesGalaRezultatu(String iemesls) {
    // * Metode beigs spēles procesu un izvadīs noteikto spēles rezultātu.

    // Pārtrauc spēli.
    Main.sakumaEkrans = true;
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
    LogaSpoks.logaSpoks.deaktivizetSpoku();
    DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    VirtuvesSpoks.virtuvesSpoks.deaktivizetSpoku();

    SavienotaisKaratavuKods.restartetKaratavas();
    Laiks.spelesLaiks = 0; // Lai laika threads momentāli neapstātos pēc tā pališanas, atjauno spēles laiku.
    varonaStresaLimenis = 0;
    Main.varonisIrMazajaSpele = false;
    Main.nodzestTerminali();
  }
}
