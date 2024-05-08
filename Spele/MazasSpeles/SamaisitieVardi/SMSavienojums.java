package Spele.MazasSpeles.SamaisitieVardi;

import Spele.Enums.EkranuVeidi;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;

public class SMSavienojums {
  // Savienojums ar spēles kodu.
  public static boolean MDSamaisitieVardi = false;

  public static void palaistSamaisitosVardus() {
    // 1. Ļauj lietotājam veidot savu vārdu.
    SamaisitieVardi.samaisitieVardi.lietotajaVards = TastaturasKlausitajs.limetVardu(SamaisitieVardi.samaisitieVardi.lietotajaVards, Main.ciklaKomanda, SamaisitieVardi.samaisitieVardi.izveletaisVards.length());
    // 2. Izvade.
    Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.SAMAISITIE_VARDI);
    // 3. Pārbauda vai lietotāja izveidotais vārds atbilst pareizajam vārdam.
    SamaisitieVardi.samaisitieVardi.parbauditVardu();
  }
}
