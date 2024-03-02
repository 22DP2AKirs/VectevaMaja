package Spele.Spoki;

import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.SpokuIzskati;
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

  public static VirtuvesSpoks virtuvesSpoks = new VirtuvesSpoks(IestatijumuDati.virtuvesSpokaAtlautaAgresivitate, IestatijumuDati.virtuvesSpokaAtputasLaiks);

  // Mainīgie.
  private boolean spuldziteIrSaplesta;
  private boolean irIeslegtaPagrabaGaisma;

  private int ieslegtasGaismasAgresivitate;

  public VirtuvesSpoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    super(spokaAtlautaAgresivitate, spokaAtputasLaiks);
    ieslegtasGaismasAgresivitate = spokaAtlautaAgresivitate + 5;
  }

  // * Getters:
  public String toString() {
    return "Virt sp aktivs: " + getSpoksIrAktivs() + 
    ", Atputas gajieni: " + getMainamoAtputasLaiku() + 
    ", Fazes indekss: " + getSpokaFazesIndekss() +
    ", Pagraba gaisma ieslegta: " + getIrIeslegtaPagrabaGaisma() +
    ", Spuldzite saplesta: " + getSpuldziteIrSaplesta() + ", " +
    getRandKustibasIespeja() + " < " + getSpokaAtlautaAgresivitate() + "\033[0K";
  }

  public int getIeslegtasGaismasAgresivitate() {
    return ieslegtasGaismasAgresivitate;
  }
      
  public boolean getIrIeslegtaPagrabaGaisma() {
    return irIeslegtaPagrabaGaisma;
  }

  public boolean getSpuldziteIrSaplesta() {
    return spuldziteIrSaplesta;
  }

  private int getSpokaAktualoAgresivitati() {
    if (irIeslegtaPagrabaGaisma) {
      return ieslegtasGaismasAgresivitate;
    }
    return getSpokaAtlautaAgresivitate();
  }

  // * Setters:
  public void setIrIeslegtaPagrabaGaisma(boolean vertiba) {
    irIeslegtaPagrabaGaisma = vertiba;
  }
  
  // * Citas metodes:
  /// Public:
  
  public void atjauninatSpoku() {
    // * Metode overwrito super metodi, lai tā atbilsu virtuves spoka unikālajai agresivitātei.
    if (getSpoksIrAktivs()) {
      // Nosaka vai spoks cenšas kustēties vai nē.
      if (atgrieztRandomKustibasSkaitli() < getSpokaAktualoAgresivitati()) {
        if (getMainamoAtputasLaiku() == 0) {
          pieietTuvak();
        }
        else {
          atpustiesVienuGajienu();
        }
      }
    }
  }

  public String[] izveletiesBildiPecFazes() {
    if (getSpokaFazesIndekss() < 10) {
      return SpokuIzskati.virtuvesSpokaFazesBildes[getSpokaFazesIndekss()];
    }
    // Saplēš spuldzīti.
    else if (getSpokaFazesIndekss() == 10) {
      spuldziteIrSaplesta = true;
      return SpokuIzskati.virtuvesSpokaFazesBildes[getSpokaFazesIndekss()];
    }
    // Uzbrūk varonim.
    else {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("V I R T U V E S   S P O K S");
      return SpokuIzskati.virtuvesSpokaFazesBildes[0];
    }
  }

  

  // Protected:
  protected void meginatIzveidotVirtuvesSpoku() {
    if (!getSpoksIrAktivs() && Main.rand.nextInt(5) + 1 == 5) {
      izveidotJaunuVirtuvesSpokaObjektu();
    }
  }

  /// Private:
  private static void izveidotJaunuVirtuvesSpokaObjektu() {
    virtuvesSpoks = new VirtuvesSpoks(IestatijumuDati.virtuvesSpokaAtlautaAgresivitate, IestatijumuDati.virtuvesSpokaAtputasLaiks);
  }
}
