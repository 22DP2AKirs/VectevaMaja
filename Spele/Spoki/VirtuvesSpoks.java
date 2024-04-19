package Spele.Spoki;

import Spele.K;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Izskati.SpokuIzskati;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;

public class VirtuvesSpoks extends Spoks {
  /* Spoka apraksts:
     Virtuves spoks nāk no pagraba, kas atrodas virtuvē. Tas ir jūtīgs uz gaismu,
     tādēļ, ja pagrabā ir ieslēgta gaisma, tad spoks ātrāk kāps pa kāpnēm, ātrāk
     tuvojoties pie sava mērķa. Mērķis ir novākt varoni. Pagraba gaisma mēdz reizēm
     pati ieslēgties, to var izslēgt ar komandu "G". Kad virtuves spoks ir pie virtuves
     (Pirmspēdējā fāze), tad viņš saplēsīs pagraba gaismu, padarot to par neizmantojamu.

     Lai spoku aizbiedētu varonim ir jāizslēdz mājas elektrība, liekot spokam šoka
     stāvoklī nokrist lejā pa kāpnēm uz viņa sākuma pozīciju (To var dzirdēt).
  */

  public static VirtuvesSpoks virtuvesSpoks = new VirtuvesSpoks(SakumaDati.virtuvesSpokaAtlautaAgresivitate, SakumaDati.virtuvesSpokaAtputasLaiks);

  private int ieslegtasGaismasAgresivitate;

  public VirtuvesSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    setSpokuFazuSkaitu(K.VIRTUVES_SPOKA_FAZES);
    ieslegtasGaismasAgresivitate = spokaAtlautaAgresivitate + 5;
  }
  
  // * Getters:
  public String toString() {
    return
    getRandKustibasIespeja() + " < " + getSpokaAktualoAgresivitati() +
    ", Virt sp aktivs: " + getSpoksIrAktivs() + 
    ", Atputas gajieni: " + getMainamoAtputasLaiku() + 
    ", Fazes indekss: " + getSpokaFazesIndekss() + " no " + getSpokuFazuSkaitu() +
    ", Pagraba gaisma ieslegta: " + SakumaDati.pagrabaGaisma +
    ", Spuldzite saplesta: " + SakumaDati.spuldziteSaplesta +
    "\033[0K";
  }

  public int getIeslegtasGaismasAgresivitate() {
    return ieslegtasGaismasAgresivitate;
  }
      
  private int getSpokaAktualoAgresivitati() {
    if (SakumaDati.pagrabaGaisma) {
      return ieslegtasGaismasAgresivitate;
    }
    return getSpokaAtlautaAgresivitate();
  }
  
  // * Citas metodes:
  /// Public:
  public void izveidotJaunuVirtuvesSpokaObjektu() {
    virtuvesSpoks = new VirtuvesSpoks(SakumaDati.virtuvesSpokaAtlautaAgresivitate, SakumaDati.virtuvesSpokaAtputasLaiks);
  }

  protected void noteiktGajienaRezultatu() {
    // * Metode overwrito super metodi, lai tā atbilsu virtuves spoka unikālajai agresivitātei.
    // Nosaka vai spoks cenšas kustēties vai nē.
    // Iespēja ieslēgt pagraba gaismu.
    if (!SakumaDati.pagrabaGaisma && Main.rand.nextInt(101) <= SakumaDati.virtuvesSpokaAtlautaAgresivitate * 0.5 && !SakumaDati.spuldziteSaplesta) {
      SakumaDati.pagrabaGaisma = true;
      SkanasSpeletajs.SpeletSkanu("Spele/SkanasFaili/gaismas-sledzis-on.wav", 0);
    }

    if (atgrieztRandomKustibasSkaitli() < getSpokaAktualoAgresivitati()) {
      if (getMainamoAtputasLaiku() == 0) {
        pieietTuvak();
      }
      else {
        atpustiesVienuGajienu();
      }
    }
  }

  public String[] izveletiesBildiPecFazes() {
    // Izvēlas labāko bildi.
    if (getSpokaFazesIndekss() < 10) {
      if (SakumaDati.spuldziteSaplesta || !SakumaDati.pagrabaGaisma) {
        return SpokuIzskati.virtuvesSpokaFazesBildes[11]; // Izslēgta pagraba gaisma.
      }
      else {
        return SpokuIzskati.virtuvesSpokaFazesBildes[getSpokaFazesIndekss()];
      }
    }
    // Saplēš spuldzīti.
    else if (getSpokaFazesIndekss() == 10) {
      // Skaņa --->
      SakumaDati.spuldziteSaplesta = true;
      return SpokuIzskati.virtuvesSpokaFazesBildes[getSpokaFazesIndekss()];
    }
    // Uzbrūk varonim.
    else {
      return SpokuIzskati.virtuvesSpokaFazesBildes[0];
    }
  }

  /// Protected:
  protected void parbauditSpokaFazi() {
    if (getSpokaFazesIndekss() == getSpokuFazuSkaitu()) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("V I R T U V E S   S P O K S");
    }
  }

  protected void meginatIzveidotVirtuvesSpoku() {
    if (!getSpoksIrAktivs() && Main.rand.nextInt(5) + 1 == 5) {
      izveidotJaunuVirtuvesSpokaObjektu();
    }
  }

  
}
