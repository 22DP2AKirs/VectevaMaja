package Spele.Veikals;

import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.KontaKods.Konts;

public class Piederumi {
  /** Klase ir visu veikala inventāra jeb piederumu vecāks (parents).
   * 
   */

  // Piederuma vērtības.
  protected boolean nopirkaPiederumu;
  protected boolean maxLimenis;
  protected String piederumaUzlabojumaCena;
  protected int piederumaLimenis;

  // Pēc kāda nosaukuma varētu atrast mainīgo konta failā.
  protected String nopirkaPiederumuNosauk;
  protected String piederumaUzlabojumaCenasNosaukums;
  protected String piederumaLimenaNosaukums;

  // STATIC
  // Kameras:
  public static volatile boolean ieslegtaKamera;
  public static boolean izveletaKamera;
  public static String[] kamerasIzskats;

  public Piederumi() {}

  public static void definetKameru() {
    izveletaKamera = true;
    if (VeikalaKods.izveletaFotokamera) {
      kamerasIzskats = Fotokamera.fotokamera.atgriestIzskatu();
    }
    else if (VeikalaKods.izveletaVideokamera) {
      kamerasIzskats = Videokamera.videokamera.atgriestIzskatu();
    }
    else {
      izveletaKamera = false;
      kamerasIzskats = null;
    }
  }

  public void atjaunotPiederumus() {
    Fotokamera.fotokamera.atjauninatLimenaVertibas();
    Videokamera.videokamera.atjauninatLimenaVertibas();
    Serkocini.serkocini.atjauninatLimenaVertibas();
  }

  public void kontaSaglabatDatus() {
    // Kontā kategorijā 'veikals' saglabās piederuma datus.
    if (Konts.lietotajsPiesledzies) {
      FailuRedigetajs.mainitFailaMainigaVertibu(nopirkaPiederumuNosauk, PaligMetodes.booleanVertiba(nopirkaPiederumu), Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu(piederumaUzlabojumaCenasNosaukums, piederumaUzlabojumaCena, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu(piederumaLimenaNosaukums, piederumaLimenis+"", Konts.lietotajaKontaCels);
    }
  }

  public static void saglabatKontaVisuPiederumuDatus() {
    Fotokamera.fotokamera.kontaSaglabatDatus();
    Videokamera.videokamera.kontaSaglabatDatus();
    Serkocini.serkocini.kontaSaglabatDatus();
  }
}
