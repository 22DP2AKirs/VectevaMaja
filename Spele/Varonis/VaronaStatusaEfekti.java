package Spele.Varonis;

import Spele.PaligMetodes;
import Spele.Izskati.EkranuIzskati;
import Spele.KontaKods.Konts;
import Spele.Enums;
import Spele.Enums.EkranuVeidi;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Laiks;
import Spele.SpelesProcesi.Main;
import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.VirtuvesSpoks;
import Spele.Veikals.Piederumi;
import Spele.Veikals.Serkocini;
import Spele.Veikals.VeikalaKods;
import Spele.Veikals.Videokamera;

public class VaronaStatusaEfekti {
  public static float varonaStresaLimenis;

  public static void varonaStress() {
    // Viss, kas ietekmē varoņa stresa līmeni.
    if (!(VeikalaKods.izveletaVideokamera && Videokamera.videokamera.getMaxLimenis() && Piederumi.ieslegtaKamera) && !SakumaDati.istabuGaismasIeslegtas[Enums.V_Istaba.CIPARS] && !Serkocini.serkocini.getAizdedzinatsSerkocins()) { // Ja istabā, kurā atrodas varonis ir izslēgta gaisma, tad ...
      varonaStresaLimenis += 0.4;
    }
  }

  public static void parbauditEffektus() {
    // Ja varona stresa līmenis pārsniedz 100.
    if (VaronaStatusaEfekti.varonaStresaLimenis > 100) {
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

    // Nosaka spēles gala rezultātu.
    if (iemesls.equals("UZVARA")) { // Uzvaras kods.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.UZVARAS_EKRANS);
      PaligMetodes.gulet(5);
      // Palielina konta nakts vērtību par vienu (+1).
      if (SakumaDati.spelesNakts != 5) {
        SakumaDati.nauda += 90 * SakumaDati.spelesNakts;
        SakumaDati.spelesNakts++;

        // Ja ir konts, tad saglabā.
        if (Konts.lietotajsPiesledzies) {
          FailuRedigetajs.mainitFailaMainigaVertibu("spelesNakts", SakumaDati.spelesNakts + "", Konts.lietotajaKontaCels);
          FailuRedigetajs.mainitFailaMainigaVertibu("nauda", SakumaDati.nauda + "", Konts.lietotajaKontaCels);
        }
      }
    }
    else {
      Izvade.izvadesMasivs = EkranuParklajumi.parklatZaudesanasEkranu(EkranuIzskati.visiEkrani[2], iemesls);
      PaligMetodes.gulet(5);
    }
    
    // Spēles beigu kods.
    LogaSpoks.logaSpoks.deaktivizetSpoku();
    DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    VirtuvesSpoks.virtuvesSpoks.deaktivizetSpoku();

    Laiks.spelesLaiks = 0; // Lai laika threads momentāli neapstātos pēc tā pališanas, atjauno spēles laiku.
    Laiks.stundasLaiks = 0;
    
    varonaStresaLimenis = 0;

    MazoSpeluIzvelesKods.sagatavotMajasdarbusJaunaiSpelei();
  }
}
