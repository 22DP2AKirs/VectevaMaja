package Spele.Spoki;

import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.SpokuIzskati;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;

public class LogaSpoks extends Spoks {
  /* Spoka apraksts:
     Loga spoks parādās vienā no mājas istabu logiem. Ar katru fāzi tuvojas tuvāk un tuvāk, līdz tas sāk
     vērt vaļā logu. Kad logs ir pietiekami atvērts tas ielien mājā, ar ko viņa mērķis beidzas, tas ir, 
     viņš novāc varoni. To var aizbiedēt ar komandu "LOGS", pēc kuras varonis aizver logu, aizbiedējot spoku.
  */

  // Objekts, kuru var atjaunot (izveidot no jauna n reizes) spēles gaitas laikā.
  public static LogaSpoks logaSpoks = new LogaSpoks(IestatijumuDati.logaSpokaAtlautaAgresivitate, IestatijumuDati.logaSpokaAtputasLaiks); 

  private String istaba; // Nosaka, kurā istabā parādīsies spoks.

  public LogaSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    izveletiesIstabu(Main.rand.nextInt(4));
  }

  // * Getters:
  public String getLSIstabu() {
    return istaba;
  }

  public String toString() {
    return 
    "Loga sp aktivs: " + getSpoksIrAktivs() + 
    ", Atputas gajieni: " + getMainamoAtputasLaiku() +
    ", Fazes indekss: " + getSpokaFazesIndekss() + 
    ", Istaba: " + getLSIstabu() + ", " +
    getRandKustibasIespeja() + " < " + getSpokaAtlautaAgresivitate() + "\033[0K";
  }
 
  // * Citas Metodes:
  /// Public:
  public String[] izveletiesBildiPecFazes() {
    // Pārbauda vai spoks nav izgājis visas savas fāzes.
    if (getSpokaFazesIndekss() < 9) {
      if (istaba.equals("GULTA")) {
        return SpokuIzskati.logaSpokaBildesGultasIstaba[getSpokaFazesIndekss()];
      }
      else if (istaba.equals("DIVANS")) {
        return SpokuIzskati.logaSpokaBildesDivanaIstaba[getSpokaFazesIndekss()];
      }
      else if (istaba.equals("DURVIS")) {
        return SpokuIzskati.logaSpokaBildesDurvjuIstaba[getSpokaFazesIndekss()];
      }
      else if (istaba.equals("VIRTUVE")) {
        return SpokuIzskati.logaSpokaBildesVirtuve[getSpokaFazesIndekss()];
      }

      throw new RuntimeException("Loga spoka istaba ir arpus pārbaudes vertibam." + istaba + ".-=");
    }
    // Spoks uzbrūk varonim.
    else {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("L O G A   S P O K S");
      String[] tuksMasivs = new String[10];
      return tuksMasivs;
    }
  }

  /// Protected:
  protected void meginatIzveidotLogaSpoku() {
    // ja (Spoks nav aktīvs un random iespēja).
    if (!getSpoksIrAktivs() && Main.rand.nextInt(5) + 1 == 5) {
      izveidotJaunuLogaSpokaObjektu();
    }
  }

  /// Private:
  private void izveidotJaunuLogaSpokaObjektu() {
    logaSpoks = new LogaSpoks(IestatijumuDati.logaSpokaAtlautaAgresivitate, IestatijumuDati.logaSpokaAtputasLaiks);
  }

  private void izveletiesIstabu(int istabasNum) {
    if (istabasNum == 0) {
      istaba = "GULTA";
    }
    else if (istabasNum == 1) {
      istaba = "DIVANS";
    }
    else if (istabasNum == 2) {
      istaba = "DURVIS";
    }
    else if (istabasNum == 3) {
      istaba = "VIRTUVE";
    }
  }
}
