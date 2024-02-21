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
  }
  
  // Metodes:
  public String[] izveletiesBildiPecFazes() {
    if (getSpokaFazesIndekss() < 10) {
      return SpokuIzskati.durvjuSpokaFazesBildes[getSpokaFazesIndekss()];
    }
    else {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("D U R V J U   S P O K S");
      return null;
    }
  }

  public String toString() {
    return "Durvju sp aktivs: " + !durvjuSpoks.getSpoksIrAizbiedets() + ", Atputas gajieni: " + getSpokaAtputasLaikaMainamaKopija() + ", Fazes indekss: " + getSpokaFazesIndekss();
  }

  public static DurvjuSpoks getDurvjuSpoks() {
    return durvjuSpoks;
  }

  public static void meginatIzveidotDurvjuSpoku() {
    if (durvjuSpoks.getSpoksIrAizbiedets() && Main.rand.nextInt(1) + 1 == 0) {
      izveidotJaunuDurvjuSpokaObjektu();
    }
  }

  private static void izveidotJaunuDurvjuSpokaObjektu() {
    durvjuSpoks = new DurvjuSpoks(IestatijumuDati.durvjuSpokaAtlautaAgresivitate, IestatijumuDati.durvjuSpokaAtputasLaiks);
  }

  // Get metodes:
  public boolean getDurvisIrSlegtas() {
    return durvisIrSlegtas;
  }

  // Set metodes:
  public void setDurvisIrSlegtas(boolean vertiba) {
    durvisIrSlegtas = vertiba;
  }

}
