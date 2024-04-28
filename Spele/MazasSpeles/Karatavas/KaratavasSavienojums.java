package Spele.MazasSpeles.Karatavas;

import Spele.PaligMetodes;
import Spele.Enums.EkranuVeidi;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Main;

// Karātavu kods savienots izmantojamā jeb spēlējamā stāvoklī:
public class KaratavasSavienojums {
  public static boolean mSpeleKaratavas = false;

  // Metode caur kuru spēlē strādā karātavu kods.
  public static void palaistKaratavasMazoSpeli() {
    // -------- Galvenā domāšana.
    Karatavas.karatavasObjekts.parbauditBurtu(Main.ciklaKomanda);
    // -------- Izveido vārdu, kuru rādīs grāmatas lejā.
    Karatavas.karatavasObjekts.saliktCentretuVardaSkeletu();
    // -------- Izvade terminālī.
    Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.KARATAVAS);
    // Izslēgšanas jeb uzvaras kods:
    if (Karatavas.karatavasObjekts.irAtminetsVards()) {
      PaligMetodes.gulet(2); // Ļauj spēlētājam redzēt atminēto vārdu.
      mSpeleKaratavas = false;
      Izvade.ieslegtSpelesIzvadi();
      MazoSpeluIzvelesKods.varonisIrMazajaSpele = false;
      MazoSpeluIzvelesKods.izveletaMazaSpele = false;
    }
  }
}
