package Spele.Veikals;

public class Serkocini extends Piederumi {
  // Klases objekts.
  public static Serkocini serkocini = new Serkocini();

  int serkocinuDaudzums;
  int serkocinuDegsanasLaiks;

  public Serkocini() {
    nopirkaPiederumuNosauk = "nopirktiSerkocini";
    piederumaUzlabojumaCenasNosaukums = "serkocinuUzlabojumaCena";
    piederumaLimenaNosaukums = "serkocinuLimenis";
    atjauninatLimenaVertibas();
  }

  public void atjauninatLimenaVertibas() {
    if (nopirkaPiederumu) {
      switch (piederumaLimenis) {
        case 0:
          serkocinuDaudzums = 5;
          serkocinuDegsanasLaiks = 3;
          piederumaUzlabojumaCena = "30";
          break;
        case 1:
          serkocinuDaudzums = 10;
          serkocinuDegsanasLaiks = 3;
          piederumaUzlabojumaCena = "60";
          break;
        case 2:
          serkocinuDaudzums = 15;
          serkocinuDegsanasLaiks = 4;
          piederumaUzlabojumaCena = "80";
          break;
        case 3:
          serkocinuDaudzums = 15;
          serkocinuDegsanasLaiks = 4;
          piederumaUzlabojumaCena = "M A X";
          maxLimenis = true;
          break;
      }
    }
    else {
      piederumaUzlabojumaCena = "20";
    }
  }
}
