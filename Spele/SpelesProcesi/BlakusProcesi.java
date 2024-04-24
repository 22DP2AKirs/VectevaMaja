package Spele.SpelesProcesi;

import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;

public class BlakusProcesi extends Thread {
  
  @Override
  public void run() {
    while (Main.spelePalaista) {
      // 1. Novēro un maina kameras baterijas vērtības.
      VaronaDarbibas.kamerasBaterijasAprekins();
      // 2. Palielina varoņa stresu, ja viņš ir tumsā.
      VaronaStatusaEfekti.varonaStress();
      try { Thread.sleep(100); } catch (Exception e) {} // 0.1 sec.
    }
  }
}
