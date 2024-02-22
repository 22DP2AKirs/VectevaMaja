package Spele.Spoki;

import Spele.SpelesProcesi.Main;

public class Spoks {
  // ? Katra spoka mērķis ir vainu traucēt, vainu novākt varoni.
  // Statistika.
  private int atnakusoSpokuSkaits = 0; // Statu mainīgias, kurš skaita cik spoka objekti ir izveidoti spēles laikā.

  // Spoka limiti. (Nemainīgas vērtības)
  private int spokaAtlautaAgresivitate; // Nosaka cik agresīvs var būt spoks. Max = 20.
  private int spokaAtputasLaiks; // Nosaka cik spoka iespējas gājienus tas stāvēs uz vietas. Glabāšanas mainīgais.
  
  // Spoka progressa vērtības. (Mainīgās vērtības)
  private int spokaAtputasLaikaMainamaKopija; // Šo mainīgo visu laiku maina.
  private int spokaFazesIndekss; // Nosaka, kādu bildi rādīs spēlē. (Progress līdz mērķa izpildei)
  private int randKustibasIespeja; // Skaitlis, kuru salīdzina ar spoka agresivitāti, lai tas spētu kustēties. Vērtība no 1 - 20 aktīvs, 0 neaktīvs.

  // Spoka stāvoklis. (ON vai OFF)
  private boolean spoksIrAktivs; // Ja spoks ir aktīvs, tad tas var kustēties, savādāk tas stāvēs netiks atjaunināts.

  public Spoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    this.spokaAtlautaAgresivitate = spokaAtlautaAgresivitate;
    this.spokaAtputasLaiks = spokaAtputasLaikaMainamaKopija = spokaAtputasLaiks;

    spokaFazesIndekss = 0; // Visi spoki sāk no nultās (sākuma) pozīcijas.
    spoksIrAktivs = true; // Kad izveido spoku, tad to uzreiz aktivizē.
    atnakusoSpokuSkaits++; // + 1.
  }

  // * setters:
  /// Public (Izmantojami jebkurā failā):
  public void setSpokaAtputasLaikaMainamaKopija(int spokaAtputasLaikaMainamaKopija) {
    this.spokaAtputasLaikaMainamaKopija = spokaAtputasLaikaMainamaKopija;
  }

  public void setSpoksIrAktivs(boolean vertiba) {
    spoksIrAktivs = vertiba;
  }

  public void deaktivizetSpoku() {
    setSpoksIrAktivs(false);
    spokaFazesIndekss = 0;
  }
  
  // * Getters:
  /// Protected (Izmantojami tikai starp inheritējamiem bērniem (children)):
  protected int getSpokaAtlautaAgresivitate() {
    return spokaAtlautaAgresivitate;
  }

  protected int getMainamoAtputasLaiku() {
    return spokaAtputasLaikaMainamaKopija;
  }

  protected int getRandKustibasIespeja() {
    return randKustibasIespeja;
  }

  protected int getSpokaFazesIndekss() {
    return spokaFazesIndekss;
  }

  /// Public (Izmantojami jebkurā failā):
  public boolean getSpoksIrAktivs() {
    return spoksIrAktivs;
  }
  
  public int getAtnakusoSpokuSkaits() {
    return atnakusoSpokuSkaits;
  }
  
  // * Citas metodes:
  /// Public:
  public void atjauninatSpoku() {
    // Ja spoks ir aktīvs, tad tam atļauj kustēties.
    if (spoksIrAktivs) {
      noteiktGajienaRezultatu();
    }
  }

  /// Private:
  private void noteiktGajienaRezultatu() {
    // Nosaka vai spoks cenšas kustēties vai nē.
    if (atgrieztRandomKustibasSkaitli() < spokaAtlautaAgresivitate) {
      if (spokaAtputasLaikaMainamaKopija == 0) {
        pieietTuvak();
      }
      else {
        atpustiesVienuGajienu();
      }
    }
  }

  private void pieietTuvak() {
    spokaFazesIndekss++;
    spokaAtputasLaikaMainamaKopija = spokaAtputasLaiks; // Atjauno atpūtas jeb gaidīšanas laiku.
  }

  private void atpustiesVienuGajienu() {
    spokaAtputasLaikaMainamaKopija--;
  }

  private int atgrieztRandomKustibasSkaitli() {
    return randKustibasIespeja =  Main.rand.nextInt(20) + 1; // Vērtības no 1 - 20.
  }
  
  /// Statiskās metodes (Izmantojamas main programmā):
  public static void atjauninatSpokus() {
    if (LogaSpoks.logaSpoks.getSpoksIrAktivs()) {
      LogaSpoks.logaSpoks.atjauninatSpoku();
    }
    
    if (DurvjuSpoks.durvjuSpoks.getSpoksIrAktivs()) {
      DurvjuSpoks.durvjuSpoks.atjauninatSpoku();
    }

    if (VirtuvesSpoks.virtuvesSpoks.getSpoksIrAktivs()) {
      VirtuvesSpoks.virtuvesSpoks.atjauninatSpoku();
    }
  }
  
  public static void meginatIeslegtSpokus() {
    LogaSpoks.logaSpoks.meginatIzveidotLogaSpoku();
    DurvjuSpoks.durvjuSpoks.meginatIzveidotDurvjuSpoku();
    VirtuvesSpoks.virtuvesSpoks.meginatIzveidotVirtuvesSpoku();
  }

  public static void spokuInfo() {
    System.out.println(); // Vieta priekš ievades.
    System.out.println(LogaSpoks.logaSpoks.toString());
    System.out.println(DurvjuSpoks.durvjuSpoks.toString());
    System.out.println(VirtuvesSpoks.virtuvesSpoks.toString());
  }
}
