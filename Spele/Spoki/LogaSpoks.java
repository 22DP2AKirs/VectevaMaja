package Spele.Spoki;

import Spele.K;
import Spele.PaligMetodes;
import Spele.Enums.Istaba;
import Spele.Enums.NavesIemesli;
import Spele.Izskati.SpokuIzskati;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;
import Spele.Veikals.Piederumi;

public class LogaSpoks extends Spoks {
  /* Spoka apraksts:
     Loga spoks parādās vienā no mājas istabu logiem. Ar katru fāzi tuvojas tuvāk un tuvāk, līdz tas sāk
     vērt vaļā logu. Kad logs ir pietiekami atvērts tas ielien mājā, ar ko viņa mērķis beidzas, tas ir, 
     viņš novāc varoni. To var aizbiedēt ar komandu "LOGS", pēc kuras varonis aizver logu, aizbiedējot spoku.

     Dati:
     Spokam ir 6 fāzes (pēc indeksa 6), un tas uzbrūk pēc 6.
  */

  // Objekts, kuru var atjaunot (izveidot no jauna n reizes) spēles gaitas laikā.
  public static LogaSpoks logaSpoks = new LogaSpoks(SakumaDati.logaSpokaAtlautaAgresivitate, SakumaDati.logaSpokaAtputasLaiks); 

  private Istaba istaba; // Nosaka, kurā istabā parādīsies spoks.

  public LogaSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    SPOKA_FAZU_SKAITS = K.LOGA_SPOKA_FAZES;
    izveletiesIstabu(Main.rand.nextInt(4));
    pecUzbrukumaAtputa = 10;
  }

  public String toString() {
    return "F. " + spokaFazesIndekss + " no " + SPOKA_FAZU_SKAITS + " : Aktivs? " + spoksAtnacis +
    " atp. gaj. " + spokaAtputasLaikaMainamaKopija + " : Istaba " + istaba.ISTABA + 
    " rand " + randKustibasIespeja + " <= " + spokaAtlautaAgresivitate + "\033[0K";
  }

  public Istaba getIstabu() {
    return istaba;
  }

  private void izveletiesIstabu(int istabasNum) {
    // Definē mainīgo ar vienu no mājas istabām.
    istaba = PaligMetodes.atrastIstabasEnumuPecTaCiparaVertibas(istabasNum);
  }

  public void deaktivizetSpoku() {
    // Deaktivizē spoku (padara to neaktīvu).
    spoksAtnacis = false;
    spokaFazesIndekss = 0;
    pecUzbrukumaAtputa = 10;
    istaba = Istaba.NAV;
  }

  public void izveidotJaunuLogaSpokaObjektu() {
    // Pārdefinē mainīgo ar jaunu vērtību mainīgo.
    logaSpoks = new LogaSpoks(SakumaDati.logaSpokaAtlautaAgresivitate, SakumaDati.logaSpokaAtputasLaiks);
  }

  protected void noteiktRezultatu() {
    // Pārbauda vai spoks ir savā beigu jeb uzbrukuma fāzē.
    if (spokaFazesIndekss >= SPOKA_FAZU_SKAITS) {
      deaktivizetSpoku();
      VaronaStatusaEfekti.spelesRezultats(NavesIemesli.LOGA_SPOKS);
    }
  }

  protected void censtiesAtnakt() {
    // Apskata iespēju atnākt uz māju jeb spēli.

    // 1. Neļauj spokam nāk pirmās 'n' sekundes pēc aizbiedēšanas.
    if (pecUzbrukumaAtputa <= 0) {
      // 1.1. Rand. iespēja atnakt uz māju.
      if (!spoksAtnacis && Main.rand.nextInt(10) == 0) {
        izveidotJaunuLogaSpokaObjektu();
      }
    }
    else {
      pecUzbrukumaAtputa--;
    }
  }

  public String[] getIzskats() {
    // 'Override' vecāka metodi.

    // 1. Atjauno spoka izskatu.
    if (spokaFazesIndekss <= 6) { // 7. fāzē spoks uzbrūk (šis aizliedz izmantot indeksu, kas ir ārpus masīva robežām.)
      atjaunotIzskatu();
    }
    // 2. Atgriež izskatu.
    return izskats;
  }

  private void atjaunotIzskatu() {
    // Atjauno spoka izskata masīvu.

    // 1. Skatās uz spoku ar ieslēgtu kameru.
    if (spokaFazesIndekss <= 6 && Piederumi.ieslegtaKamera) {
      if (istaba.CIPARS == Istaba.GULTA.CIPARS) {
        izskats = SpokuIzskati.gulamistabasLogaSpokaFazesKamera[spokaFazesIndekss];
      }
      else if (istaba.CIPARS == Istaba.DIVANS.CIPARS) {
        izskats = SpokuIzskati.divanaIstabasLogaSpokaFazesKamera[spokaFazesIndekss];
      }
      else if (istaba.CIPARS == Istaba.DURVIS.CIPARS) {
        izskats = SpokuIzskati.durvjuIstabasLogaSpokaFazesKamera[spokaFazesIndekss];
      }
      else if (istaba.CIPARS == Istaba.VIRTUVE.CIPARS) {
        izskats = SpokuIzskati.virtuvesLogaSpokaFazesKamera[spokaFazesIndekss];
      }
    }
    // 2. Skatās uz spoku ar izslēgtu kameru.
    else if (spokaFazesIndekss >= 3 && !Piederumi.ieslegtaKamera){
      if (istaba.CIPARS == Istaba.GULTA.CIPARS) {
        izskats = SpokuIzskati.gulamistabasLogaSpokaFazesBezKameras[spokaFazesIndekss - 3];
      }
      else if (istaba.CIPARS == Istaba.DIVANS.CIPARS) {
        izskats = SpokuIzskati.divanaIstabasLogaSpokaFazesBezKameras[spokaFazesIndekss - 3];
      }
      else if (istaba.CIPARS == Istaba.DURVIS.CIPARS) {
        izskats = SpokuIzskati.durvjuIstabasLogaSpokaFazesBezKameras[spokaFazesIndekss - 3];
      }
      else if (istaba.CIPARS == Istaba.VIRTUVE.CIPARS) {
        izskats = SpokuIzskati.virtuvesLogaSpokaFazesBezKameras[spokaFazesIndekss - 3];
      }
    }
    // 3. Skatās uz spoku ar ieslēgtu kameru (Fāze ir zem 3).
    else {
      if (istaba.CIPARS == Istaba.GULTA.CIPARS) {
        izskats = SpokuIzskati.gulamistabasLogaSpokaFazesBezKameras[0];
      }
      else if (istaba.CIPARS == Istaba.DIVANS.CIPARS) {
        izskats = SpokuIzskati.divanaIstabasLogaSpokaFazesBezKameras[0];
      }
      else if (istaba.CIPARS == Istaba.DURVIS.CIPARS) {
        izskats = SpokuIzskati.durvjuIstabasLogaSpokaFazesBezKameras[0];
      }
      else if (istaba.CIPARS == Istaba.VIRTUVE.CIPARS) {
        izskats = SpokuIzskati.virtuvesLogaSpokaFazesBezKameras[0];
      }
    }
  }
}
