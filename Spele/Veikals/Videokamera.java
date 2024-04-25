package Spele.Veikals;

public class Videokamera extends Piederumi {
  // Klases objekts.
  public static Videokamera videokamera = new Videokamera();

  private double baterija;
  private double izladesanasDaudzums;

  private String[] kamerasIzskats = {
    // Ansi esc. sequences veido 'tukšus logus' jeb caurumus šinī bildē, kuros var redzēt iepriekšējā masīva elementus.

    "▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒",
    "▒▒ . '''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''' . ▒▒",
    "▒▒|" + "\033[6G" + ".''." + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[6G" + "'..'" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒|" + "\033[79G" + "|▒▒",
    "▒▒ ' ---------------------------------------------------------------------- ' ▒▒",
    "▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒",
  };

  public Videokamera() {
    nopirkaPiederumuNosauk = "nopirktaVideokamera";
    piederumaUzlabojumaCenasNosaukums = "videokamerasUzlabojumaCena";
    piederumaLimenaNosaukums = "videokamerasLimenis";
    baterija = 100;
    atjauninatLimenaVertibas();
  }

  public void atjauninatLimenaVertibas() {
    if (nopirkaPiederumu) {
      switch (piederumaLimenis) {
        case 0:
          piederumaUzlabojumaCena = "75";
          break;
        case 1:
          piederumaUzlabojumaCena = "140";
          break;
        case 2:
          piederumaUzlabojumaCena = "M A X";
          maxLimenis = true;
          break;
      }

      izladesanasDaudzums = (0.1 / (piederumaLimenis + 1 * 10));
    }
    else {
      piederumaUzlabojumaCena = "100";
    }
  }

  public String[] atgriestIzskatu() {
    return kamerasIzskats;
  } 

  public void baterijasAprekins() {
    // Kamera tur ļoti ilgu laiku.
    if (ieslegtaKamera) {
      // 1. Ja kamera ir izlādējusies, tad to izslēdz.
      if (baterija < 1) {
        ieslegtaKamera = false;
      }

      // 2. Atņem baterijas uzlādes procentus.
      baterija -= izladesanasDaudzums; // + 1, jo visi piederumi sākas no '0' līmeņa.
    }
  }
}
