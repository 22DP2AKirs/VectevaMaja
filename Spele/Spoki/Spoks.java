package Spele.Spoki;

import Spele.SpelesProcesi.Main;

public class Spoks {
  // ? Katra spoka mērķis ir vainu traucēt, vainu novākt varoni.
  // Statistika.
  private int atnakusoSpokuSkaits = 0; // Statu mainīgias, kurš skaita cik spoka objekti ir izveidoti spēles laikā.

  // Spoka limiti. (Nemainīgas vērtības)
  public int spokaAtlautaAgresivitate; // Nosaka cik agresīvs var būt spoks. Max = 20.
  public int spokaAtputasLaiks; // Nosaka cik spoka iespējas gājienus tas stāvēs uz vietas. Glabāšanas mainīgais.
  
  // Spoka progressa vērtības. (Mainīgās vērtības)
  private int spokaAtputasLaikaMainamaKopija; // Šo mainīgo visu laiku maina.
  private int SPOKA_FAZU_SKAITS;
  private int spokaFazesIndekss; // Nosaka, kādu bildi rādīs spēlē. (Progress līdz mērķa izpildei)
  private int randKustibasIespeja; // Skaitlis, kuru salīdzina ar spoka agresivitāti, lai tas spētu kustēties. Vērtība no 1 - 20 aktīvs, 0 neaktīvs.


  // Spoka stāvoklis. (ON vai OFF)
  private boolean spoksIrAktivs; // Ja spoks ir aktīvs, tad tas var kustēties, savādāk tas stāvēs netiks atjaunināts.

  public Spoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    this.spokaAtlautaAgresivitate = spokaAtlautaAgresivitate;
    this.spokaAtputasLaiks = spokaAtputasLaikaMainamaKopija = spokaAtputasLaiks;

    spokaFazesIndekss = 0; // Visi spoki sāk no nultās (sākuma) pozīcijas.

    if (spokaAtlautaAgresivitate != 0) {
      spoksIrAktivs = true;
    }

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

  /// Protected:
  protected void setSpokuFazuSkaitu(int vertiba) {
    SPOKA_FAZU_SKAITS = vertiba;
  }
  
  // * Getters:
  /// Protected (Izmantojami tikai starp inheritējamiem bērniem (children)):
  protected int getSpokuFazuSkaitu() {
    return SPOKA_FAZU_SKAITS;
  }

  protected int getSpokaAtlautaAgresivitate() {
    return spokaAtlautaAgresivitate;
  }

  protected int getMainamoAtputasLaiku() {
    return spokaAtputasLaikaMainamaKopija;
  }

  protected int getRandKustibasIespeja() {
    return randKustibasIespeja;
  }

  /// Public (Izmantojami jebkurā failā):
  public boolean getSpoksIrAktivs() {
    return spoksIrAktivs;
  }
  
  public int getAtnakusoSpokuSkaits() {
    return atnakusoSpokuSkaits;
  }

  public int getSpokaFazesIndekss() {
    return spokaFazesIndekss;
  }
  
  // * Citas metodes:
  /// Protected:
  protected void atjauninatSpoku() {
    // Ja spoks ir aktīvs, tad tam atļauj kustēties.
    if (spoksIrAktivs) {
      noteiktGajienaRezultatu();
    }
  }

  protected void noteiktGajienaRezultatu() {
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

  protected void pieietTuvak() {
    spokaFazesIndekss++;
    spokaAtputasLaikaMainamaKopija = spokaAtputasLaiks; // Atjauno atpūtas jeb gaidīšanas laiku.
  }

  protected void atpustiesVienuGajienu() {
    spokaAtputasLaikaMainamaKopija--;
  }

  protected int atgrieztRandomKustibasSkaitli() {
    return randKustibasIespeja = Main.rand.nextInt(20) + 1; // Vērtības no 1 - 20.
  }
  
  /// Statiskās metodes (Izmantojamas main programmā vai citās metodēs, vai thredos, kuri ir aktivizēti vai izmantoti main metodē):
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
    // Ja spoks ir neaktīvs, tad ir rand iespēja to aktivizēt.
    LogaSpoks.logaSpoks.meginatIzveidotLogaSpoku();
    DurvjuSpoks.durvjuSpoks.meginatIzveidotDurvjuSpoku();
    VirtuvesSpoks.virtuvesSpoks.meginatIzveidotVirtuvesSpoku();
  }

  public static void izslegtSpokus() {
    // Izslēdz visus spokus.
    LogaSpoks.logaSpoks.deaktivizetSpoku();
    DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    VirtuvesSpoks.virtuvesSpoks.deaktivizetSpoku();
  }

  public static void spokuInfo() {
    System.out.println(); // Vieta priekš ievades.
    System.out.println(LogaSpoks.logaSpoks.toString());
    System.out.println(DurvjuSpoks.durvjuSpoks.toString());
    System.out.println(VirtuvesSpoks.virtuvesSpoks.toString());
  }

  public static void parbauditSpokuFazes() {
    // Metode pārbauda visu spoku fāzes, lai tie varētu uzbrukt spēlētājam.
    LogaSpoks.logaSpoks.parbauditSpokaFazi();
    DurvjuSpoks.durvjuSpoks.parbauditSpokaFazi();
    VirtuvesSpoks.virtuvesSpoks.parbauditSpokaFazi();
  }
}
