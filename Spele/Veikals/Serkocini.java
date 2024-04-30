package Spele.Veikals;

import Spele.Enums;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.SakumaDatuSagatavosana.SakumaDati;

public class Serkocini extends Piederumi {
  // Klases objekts.
  public static Serkocini serkocini = new Serkocini();

  int serkocinuDaudzums;
  int serkocinuDegsanasLaiks;
  boolean aizdedzinatsSerkocins; 


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

  public void ieslegtIstabasGaismu() {
    if (aizdedzinatsSerkocins && maxLimenis && !SakumaDati.istabuGaismasIeslegtas[Enums.V_Istaba.CIPARS] && SakumaDati.elektribaIeslegta) {
      SakumaDati.istabuGaismasIeslegtas[Enums.V_Istaba.CIPARS] = true;
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
    }
  }

  public int getSerkocinuDaudzums() {
    return serkocinuDaudzums;
  }

  public void aizdedzinat() {
    if (serkocinuDaudzums > 0) {
      serkocinuDaudzums--;
      aizdedzinatsSerkocins = true;
    }
  }

  public int getDegsanasLaiku() {
    return serkocinuDegsanasLaiks;
  }

  public boolean getAizdedzinatsSerkocins() {
    return aizdedzinatsSerkocins;
  }

  public void setAizdedzinatsSerkocins(boolean b) {
    aizdedzinatsSerkocins = b;
  }
}
