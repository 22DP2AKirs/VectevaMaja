package Spele.Iestatijumi;

import Spele.Enums.EkranuVeidi;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.TastaturasKlausitajs;

public class Iestatijumi {
  // Kontrole.
  String ietUzPrieksu, griestiesPaLabi, griestiesPaKreisi, // Kustība.
  izmantotObj, izietNoMD, // Izmantošana.

  public static void IestatijumuKods() {
    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.IESTATIJUMI);

    }
  }



  
}
