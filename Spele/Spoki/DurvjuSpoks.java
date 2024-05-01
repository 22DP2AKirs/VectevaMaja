package Spele.Spoki;

import Spele.K;
import Spele.Enums.NavesIemesli;
import Spele.Izskati.SpokuIzskati;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;
import Spele.Veikals.Piederumi;

public final class DurvjuSpoks extends Spoks {
  /* Spoka apraksts:
     Durvju spoks vienmēr nāk no vienas un tās pašas vietas - mājas āras durvīm.
     Durvis var aizvērt aizbiedējot spoku, kā arī tās var aizslēgt, lai spokam
     būtu grūtāk tikt iekšā. Spoku var aizbiedēt ar komandu "DURVIS", un durvis
     var aizslēgt ar komandu "SLEGT". Spoka mērķis ir novākt spēlētāju, tas notiek
     tad, kad spoks ir pilnībā atvēris durvis.
  */

  public static DurvjuSpoks durvjuSpoks = new DurvjuSpoks(SakumaDati.durvjuSpokaAtlautaAgresivitate, SakumaDati.durvjuSpokaAtputasLaiks); // Publiskais spoka objekts.

  public DurvjuSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    setSpokuFazuSkaitu(K.DURVJU_SPOKA_FAZES);
    pecUzbrukumaAtputa = 10;
  }

  public String toString() {
    return "F. " + spokaFazesIndekss + " no " + SPOKA_FAZU_SKAITS + " : Aktivs? " + spoksAtnacis +
    " atp. gaj. " + spokaAtputasLaikaMainamaKopija + " : Aizslegtas " + SakumaDati.durvisSlegtas + 
    " rand " + randKustibasIespeja + " <= " + spokaAtlautaAgresivitate + "\033[0K";
  }

  /// Protected:
  protected void noteiktRezultatu() {
    // Pārbauda vai spoks ir savā beigu jeb uzbrukuma fāzē.
    if (spokaFazesIndekss >= SPOKA_FAZU_SKAITS) {
      deaktivizetSpoku();
      VaronaStatusaEfekti.spelesRezultats(NavesIemesli.DURVJU_SPOKS);
    }
  }

  protected void censtiesAtnakt() {
    // Apskata iespēju atnākt uz māju jeb spēli.

    // 1. Neļauj spokam nāk pirmās 'n' sekundes pēc aizbiedēšanas.
    if (pecUzbrukumaAtputa <= 0) {
      // 1.1. Rand. iespēja atnakt uz māju.
      if (!spoksAtnacis && Main.rand.nextInt(7) == 0) {
        izveidotJaunuDurvjuSpokaObjektu();
      }
    }
    else {
      pecUzbrukumaAtputa--;
    }
  }

  public void izveidotJaunuDurvjuSpokaObjektu() {
    // Pārdefinē mainīgo ar jaunu vērtību mainīgo.
    durvjuSpoks = new DurvjuSpoks(SakumaDati.durvjuSpokaAtlautaAgresivitate, SakumaDati.durvjuSpokaAtputasLaiks);
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

  public void atjaunotIzskatu() {
    if (spokaFazesIndekss <= 3) { // Fāzes, kur spokam ir identiski izskati.
      izskats = SpokuIzskati.durvjuSpokaFazesBezKameras[spokaFazesIndekss + 1];
    }
    else {
      // - n, lai iegūto nulto indeksu citam masīvam.
      if (Piederumi.ieslegtaKamera) {
        izskats = SpokuIzskati.durvjuSpokaFazesKamera[spokaFazesIndekss - 4];
      }
      else {
        izskats = SpokuIzskati.durvjuSpokaFazesBezKameras[spokaFazesIndekss + 1];
      }
    }
  }

  public void noteiktGajienaRezultatu() {
    // Nosaka vai spoks cenšas kustēties vai nē.
    if (randKustibasIespeja <= spokaAtlautaAgresivitate) {
      if (spokaAtputasLaikaMainamaKopija == 0) {
        if (!SakumaDati.durvisSlegtas) {
          // Ja durvis nebija aizslēgtas, tad ...
          pieietTuvak(); // Palielina fāzi par 1.
        }
        else {
          // citādi ...
          if (Main.rand.nextInt(5) + 1 == 5) {
            // Skaņa --->
            SakumaDati.durvisSlegtas = false;
          }
        }
      }
      else {
        atpustiesVienuGajienu();
      }
    }
  }
}