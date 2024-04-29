package Spele.Spoki;

import Spele.K;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Izskati.SpokuIzskati;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;
import Spele.Veikals.Piederumi;

public final class PagrabaSpoks extends Spoks {
  /** Spoka apraksts:
     Pagraba spoks nāk no pagraba, kas atrodas virtuvē. Tas ir jūtīgs uz gaismu,
     tādēļ, ja pagrabā ir ieslēgta gaisma, tad spoks ātrāk kāps pa kāpnēm, ātrāk
     tuvojoties pie sava mērķa. Mērķis ir novākt varoni. Pagraba gaisma mēdz reizēm
     pati ieslēgties, to var izslēgt ar komandu "G". Kad pagraba spoks ir pie virtuves
     (Pirmspēdējā fāze), tad viņš saplēsīs pagraba gaismu, padarot to par neizmantojamu.

     Lai spoku aizbiedētu varonim ir jāizslēdz mājas elektrība, liekot spokam šoka
     stāvoklī nokrist lejā pa kāpnēm uz viņa sākuma pozīciju (To var dzirdēt).

     Dati:
     Spoks uzbrūk uz 10 fāzes.
  */

  public static PagrabaSpoks pagrabaSpoks = new PagrabaSpoks(SakumaDati.virtuvesSpokaAtlautaAgresivitate, SakumaDati.virtuvesSpokaAtputasLaiks);

  private int ieslegtasGaismasAgresivitate;

  public PagrabaSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    setSpokuFazuSkaitu(K.PAGRABA_SPOKA_FAZES);
    ieslegtasGaismasAgresivitate = spokaAtlautaAgresivitate + 5;
    pecUzbrukumaAtputa = 10;
  }

  public String toString() {
    return "F. " + spokaFazesIndekss + " no " + SPOKA_FAZU_SKAITS + " : Aktivs? " + spoksAtnacis +
    " atp. gaj. " + spokaAtputasLaikaMainamaKopija + " : Saplesta " + SakumaDati.spuldziteSaplesta + " Pagraba G. " + SakumaDati.pagrabaGaisma +
    " rand " + randKustibasIespeja + " <= " + getSpokaAktualoAgresivitati() + "\033[0K";
  }
      
  private int getSpokaAktualoAgresivitati() {
    if (SakumaDati.pagrabaGaisma) {
      return ieslegtasGaismasAgresivitate;
    }
    return getSpokaAtlautaAgresivitate();
  }
  
  // * Citas metodes:
  /// Public:
  public void izveidotJaunuPagrabaSpokaObjektu() {
    pagrabaSpoks = new PagrabaSpoks(SakumaDati.virtuvesSpokaAtlautaAgresivitate, SakumaDati.virtuvesSpokaAtputasLaiks);
  }

  protected void noteiktGajienaRezultatu() {
    // * Metode override super metodi, lai tā atbilsu virtuves spoka unikālajai agresivitātei.
    // Nosaka vai spoks cenšas kustēties vai nē.
    // Iespēja ieslēgt pagraba gaismu.
    if (!SakumaDati.pagrabaGaisma && Main.rand.nextInt(101) <= SakumaDati.virtuvesSpokaAtlautaAgresivitate * 0.5 && !SakumaDati.spuldziteSaplesta) {
      SakumaDati.pagrabaGaisma = true;
      SkanasSpeletajs.SpeletSkanu("Spele/SkanasFaili/gaismas-sledzis-on.wav", 0);
    }

    if (randKustibasIespeja <= getSpokaAktualoAgresivitati()) {
      if (spokaAtputasLaikaMainamaKopija == 0) {
        pieietTuvak();
      }
      else {
        atpustiesVienuGajienu();
      }
    }
  }

  public String[] getIzskats() {
    // 'Override' vecāka metodi.

    // 1. Atjauno spoka izskatu.
    if (spokaFazesIndekss <= 9) { // 7. fāzē spoks uzbrūk (šis aizliedz izmantot indeksu, kas ir ārpus masīva robežām.)
      atjaunotIzskatu();
    }
    // 2. Atgriež izskatu.
    return izskats;
  }

  public void atjaunotIzskatu() {
    // Izvēlas labāko bildi.
    if (spokaFazesIndekss == 10 && !SakumaDati.spuldziteSaplesta) { // Saplēš spuldzīti.
      SakumaDati.spuldziteSaplesta = true;
      // ---> Skaņa.
      izskats = SpokuIzskati.pagrabaSpokaFazesKamera[spokaFazesIndekss - 1];
    }
    else if (!SakumaDati.spuldziteSaplesta && SakumaDati.pagrabaGaisma) { // Ja ir ieslēgta pagraba gaisma.
      if (Piederumi.ieslegtaKamera) { 
        izskats = SpokuIzskati.pagrabaSpokaFazesKamera[spokaFazesIndekss];
      }
      else {
        izskats = SpokuIzskati.pagrabaSpokaFazesBezKameras[1];
      }
    }
    else {
      if (spokaFazesIndekss == 10 && Piederumi.ieslegtaKamera) {
        izskats = SpokuIzskati.pagrabaSpokaFazesKamera[spokaFazesIndekss - 1];
      }
      else {
        izskats = SpokuIzskati.pagrabaSpokaFazesBezKameras[0];
      }
    }
  }

  /// Protected:
  protected void noteiktRezultatu() {
    if (spokaFazesIndekss >= SPOKA_FAZU_SKAITS) {
      deaktivizetSpoku();
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("V I R T U V E S   S P O K S");
    }
  }

  protected void censtiesAtnakt() {
    // Apskata iespēju atnākt uz māju jeb spēli.

    // 1. Neļauj spokam nāk pirmās 'n' sekundes pēc aizbiedēšanas.
    if (pecUzbrukumaAtputa <= 0) {
      // 1.1. Rand. iespēja atnakt uz māju.
      if (!spoksAtnacis && Main.rand.nextInt(10) == 0) {
        izveidotJaunuPagrabaSpokaObjektu();
      }
    }
    else {
      pecUzbrukumaAtputa--;
    }
  }

}
