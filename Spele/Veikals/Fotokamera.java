package Spele.Veikals;

public final class Fotokamera extends Piederumi {
  // Klases objekts.
  public static Fotokamera fotokamera = new Fotokamera();

  private double baterija;
  private double izladesanasDaudzums;
  private String[] kamerasIzskats = {
    // Ansi esc. sequences veido 'tukšus logus' jeb caurumus šinī bildē, kuros var redzēt iepriekšējā masīva elementus.

    "▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒",
    "▒▒.''''''\033[73G''''''.▒▒",
    "▒▒|\033[79G|▒▒",
    "▒▒|\033[79G|░░",
    "▒▒\033[80G░░",
    "▒▒\033[80G░░",
    "▒▒\033[41G.\033[80G▒▒",
    "▒▒\033[39G--|--\033[80G▒▒",
    "▒▒\033[41G'\033[80G▒▒",
    "▒▒\033[80G▒▒",
    "▒▒\033[80G░░",
    "▒▒\033[80G░░",
    "▒▒|\033[79G|░░",
    "▒▒|\033[79G|░░",
    "▒▒'-----\033[74G-----'▒▒",
    "▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒",
  };

  public Fotokamera() {
    nopirkaPiederumuNosauk = "nopirktaFotokamera";
    piederumaUzlabojumaCenasNosaukums = "fotokamerasUzlabojumaCena";
    piederumaLimenaNosaukums = "fotokamerasLimenis";
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

      izladesanasDaudzums = 1.0 / piederumaLimenis + 1;
    }
    else {
      piederumaUzlabojumaCena = "100";
    }
  }

  public String[] atgriestIzskatu() {
    return kamerasIzskats;
  } 

  public void baterijasAprekins() {
    // Kamera tur uzlādi aptuveni 5 - 10 sek.
    if (ieslegtaKamera) {
      // 1. Ja kamera ir izlādējusies, tad to izslēdz.
      if (baterija < 1) {
        ieslegtaKamera = false;
      }

      // 2. Atņem baterijas uzlādes procentus.
      baterija -= izladesanasDaudzums; // + 1, jo visi piederumi sākas no '0' līmeņa.
    }
    else if (!ieslegtaKamera && baterija < 100) {
      baterija += 0.5;
    }
  }
}
