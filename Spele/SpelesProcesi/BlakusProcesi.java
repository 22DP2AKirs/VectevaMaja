package Spele.SpelesProcesi;

import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;
import Spele.Veikals.Serkocini;

public class BlakusProcesi extends Thread {
  
  @Override
  public void run() {
    while (Main.spelePalaista) {
      // 1. Novēro un maina kameras baterijas vērtības.
      VaronaDarbibas.kamerasBaterijasAprekins();
      // 2. Palielina varoņa stresu, ja viņš ir tumsā.
      VaronaStatusaEfekti.varonaStress();
      // 3. Ieslēdz izslēgtās istabas gaismu.
      Serkocini.serkocini.ieslegtIstabasGaismu();
      try { Thread.sleep(100); } catch (Exception e) {} // 0.1 sec.
    }
  }
}
