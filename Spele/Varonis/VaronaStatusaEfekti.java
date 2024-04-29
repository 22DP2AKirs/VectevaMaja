package Spele.Varonis;

import Spele.PaligMetodes;
import Spele.KontaKods.Konts;
import Spele.Enums;
import Spele.Enums.NavesIemesli;
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
import Spele.Spoki.PagrabaSpoks;
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
      VaronaStatusaEfekti.spelesRezultats(NavesIemesli.STRESS);
    }
    // Ja zaudē karātavas.
    else if (Karatavas.karatavuKluduSkaits > 7) {
      VaronaStatusaEfekti.spelesRezultats(NavesIemesli.KARATAVAS);
    }
  }

  public static void spelesRezultats(NavesIemesli iemesls) {
    // Beidz spēli parādot uzvaru vai nāves/zaudēšanas iemeslu.
    // 1. Pārtrauc spēli.
    Main.sakumaEkrans = true;
    Main.spelePalaista = false;

    // 2. Izvade uz termināli.
    Izvade.ieslegtMasivaIzvadi();
    Izvade.izvadesMasivs = EkranuParklajumi.parklatSpelesBeigas(iemesls);

    // 3. Rezultāta apstrāde.
    if (iemesls == NavesIemesli.UZVARA) {
      // Palielina konta nakts vērtību par vienu (+1).
      if (SakumaDati.spelesNakts != 5) {
        SakumaDati.nauda += 100 * SakumaDati.spelesNakts;
        SakumaDati.spelesNakts++;
      }
      // Ja ir konts, tad saglabā.
      if (Konts.lietotajsPiesledzies) {
        FailuRedigetajs.mainitFailaMainigaVertibu("spelesNakts", SakumaDati.spelesNakts+"", Konts.lietotajaKontaCels);
        FailuRedigetajs.mainitFailaMainigaVertibu("nauda", SakumaDati.nauda+"", Konts.lietotajaKontaCels);
      }
    }

    // 4. Izvade uz termināli ilgst 5 sec.
    PaligMetodes.gulet(5);

    // 5. Sagatavo datus nākošai spēlei.
    LogaSpoks.logaSpoks.deaktivizetSpoku();
    DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    PagrabaSpoks.pagrabaSpoks.deaktivizetSpoku();

    Laiks.spelesLaiks = 0; // Lai laika threads momentāli neapstātos pēc tā pališanas, atjauno spēles laiku.
    Laiks.stundasLaiks = 0;
    
    varonaStresaLimenis = 0;

    MazoSpeluIzvelesKods.sagatavotMajasdarbusJaunaiSpelei();
  }
}
