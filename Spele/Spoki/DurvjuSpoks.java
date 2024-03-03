package Spele.Spoki;

import Spele.K;
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

  public DurvjuSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    setSpokuFazuSkaitu(K.DURVJU_SPOKA_FAZES);
  }

  // * Getters:
  public String toString() {
    return 
    "Durvju sp aktivs: " + durvjuSpoks.getSpoksIrAktivs() + 
    ", Atputas gajieni: " + getMainamoAtputasLaiku() + 
    ", Fazes indekss: " + getSpokaFazesIndekss() + " no " + getSpokuFazuSkaitu() +
    ", Durvis aizslegtas: " + IestatijumuDati.durvisSlegtas + ", " +
    getRandKustibasIespeja() + " < " + getSpokaAtlautaAgresivitate() + "\033[0K";
  }

  // * Citas Metodes:
  /// Public:
  public String[] izveletiesBildiPecFazes() {
    if (getSpokaFazesIndekss() < 9) {
      if (IestatijumuDati.durvisSlegtas) {
        return SpokuIzskati.durvjuSpokaFazesBildes[9];
      }
      return SpokuIzskati.durvjuSpokaFazesBildes[getSpokaFazesIndekss()];
    }
    else {
      return SpokuIzskati.durvjuSpokaFazesBildes[0];
    }
  }

  public void noteiktGajienaRezultatu() {
    // Nosaka vai spoks cenšas kustēties vai nē.
    if (atgrieztRandomKustibasSkaitli() < getSpokaAtlautaAgresivitate()) {
      if (getMainamoAtputasLaiku() == 0) {
        if (!IestatijumuDati.durvisSlegtas) {
          // Ja durvis nebija aizslēgtas, tad ...
          pieietTuvak();
        }
        else {
          // citādi ...
          if (Main.rand.nextInt(5) + 1 == 5) {
            // Skaņa --->
            IestatijumuDati.durvisSlegtas = false;
          }
        }
      }
      else {
        atpustiesVienuGajienu();
      }
    }
  }

  /// Protected:
  protected void parbauditSpokaFazi() {
    if (getSpokaFazesIndekss() == getSpokuFazuSkaitu()) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("D U R V J U   S P O K S");
    }
  }

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
