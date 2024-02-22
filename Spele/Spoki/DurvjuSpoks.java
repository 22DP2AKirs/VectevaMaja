package Spele.Spoki;

import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.SpokuIzskati;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;

public class DurvjuSpoks extends Spoks {
  /* Spoka apraksts:
     Durvju spoks vienmēr nāk no vienas un tās pašas vietas - mājas āras durvīm.
     Durvis var aizvērt aizbiedējot spoku, kā arī tās var aizslēgt, lai spokam
     būtu grūtāk tikt iekšā. Spoku var aizbiedēt ar komandu "DURVIS", un durvis
     var aizslēgt ar komandu "SLEGT". Spoka mērķis ir novākt spēlētāju, tas notiek
     tad, kad spoks ir pilnībā atvēris durvis.
  */

  public static DurvjuSpoks durvjuSpoks = new DurvjuSpoks(IestatijumuDati.durvjuSpokaAtlautaAgresivitate, IestatijumuDati.durvjuSpokaAtputasLaiks); // Publiskais spoka objekts.

  private boolean durvisIrSlegtas; // Nosaka vai durvis ir slēgtas, vai nē.

  public DurvjuSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    // setSpokaAtlautaAgresivitate(IestatijumuDati.durvjuSpokaAtlautaAgresivitate);
    
  }

  // * Getters:
  public String toString() {
    return 
    "Durvju sp aktivs: " + durvjuSpoks.getSpoksIrAktivs() + 
    ", Atputas gajieni: " + getMainamoAtputasLaiku() + 
    ", Fazes indekss: " + getSpokaFazesIndekss() + 
    ", Durvis aizslegtas: " + getDurvisIrSlegtas() + ", " +
    getRandKustibasIespeja() + " < " + getSpokaAtlautaAgresivitate() + "\033[0K";
  }

  public boolean getDurvisIrSlegtas() {
    return durvisIrSlegtas;
  }

  // * Setters:
  public void setDurvisIrSlegtas(boolean vertiba) {
    durvisIrSlegtas = vertiba;
  }

  // * Citas Metodes:
  /// Public:
  public String[] izveletiesBildiPecFazes() {
    if (getSpokaFazesIndekss() < 10) {
      return SpokuIzskati.durvjuSpokaFazesBildes[getSpokaFazesIndekss()];
    }
    else {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("D U R V J U   S P O K S");
      return null;
    }
  }

  /// Protected:
  protected void meginatIzveidotDurvjuSpoku() {
    if (!getSpoksIrAktivs() && Main.rand.nextInt(5) + 1 == 5) {
      izveidotJaunuDurvjuSpokaObjektu();
    }
  }

  /// Private:
  private void izveidotJaunuDurvjuSpokaObjektu() {
    durvjuSpoks = new DurvjuSpoks(IestatijumuDati.durvjuSpokaAtlautaAgresivitate, IestatijumuDati.durvjuSpokaAtputasLaiks);
  }
}
