package Spele.MazasSpeles.Karatavas;

import Spele.IzvadeUzTerminalu;
import Spele.PaligMetodes;
import Spele.Enums.EkranuVeidi;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;

// Karātavu kods savienots izmantojamā jeb spēlējamā stāvoklī:
public class KaratavasSavienojums {
  public static boolean mSpeleKaratavas = false;

  // Metode caur kuru spēlē strādā karātavu kods.
  public static void palaistKaratavasMazoSpeli() {
    // -------- Galvenā domāšana.
    Karatavas.karatavasObjekts.parbauditBurtu(Ievade.lietotajaIevade);
    // -------- Izveido vārdu, kuru rādīs grāmatas lejā.
    Karatavas.karatavasObjekts.saliktCentretuVardaSkeletu();
    // -------- Izvade terminālī.
    IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.KARATAVU_EKRANS));
    // Izslēgšanas jeb uzvaras kods:
    if (Karatavas.karatavasObjekts.irAtminetsVards()) {
      PaligMetodes.gulet(2); // Ļauj spēlētājam redzēt atminēto vārdu.
      mSpeleKaratavas = false;
      MazoSpeluIzvelesKods.varonisIrMazajaSpele = false;
      MazoSpeluIzvelesKods.izveletaMazaSpele = false;
    }
  }
}
