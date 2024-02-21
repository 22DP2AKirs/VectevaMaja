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
  public static LogaSpoks logaSpoks = new LogaSpoks(IestatijumuDati.logaSpokaAtlautaAgresivitate, IestatijumuDati.logaSpokaAtputasLaiks); // Objekts, kuru var atjaunot (izveidot jaunu n reizes) spēles gaitas laikā.

  private static String istaba; // Nosaka, kurā istabā parādīsies spoks.

  public LogaSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    izveletiesIstabu(Main.rand.nextInt(4));
  }
 
  // Metodes:
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
      return null;
    }
  }

  public String toString() {
    return "Loga sp aktivs: " + !getSpoksIrAizbiedets() + ", Atputas gajieni: " + getSpokaAtputasLaikaMainamaKopija() + ", Fazes indekss: " + getSpokaFazesIndekss();
  }

//   public static boolean logaSpoksIrAktivs() {
//     if (!getSpoksIrAizbiedets() && ) {
//       return true;
//     }
//     return false;
//   }

  public static LogaSpoks getLogaSpoks() {
    return logaSpoks;
  }

  public static void meginatIzveidotLogaSpoku() {
    if (logaSpoks.getSpoksIrAizbiedets() && Main.rand.nextInt(1) + 1 == 1) {
      izveidotJaunuLogaSpokaObjektu();
    }
  }

  public static String getIstabu() {
    return istaba;
  }

  private static void izveidotJaunuLogaSpokaObjektu() {
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
