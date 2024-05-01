package Spele.Spoki;

import Spele.SpelesProcesi.Main;

public class Spoks {
  // ? Katra spoka mērķis ir vainu traucēt, vainu novākt varoni.
  // Statistika.
  private int atnakusoSpokuSkaits = 0; // Statu mainīgias, kurš skaita cik spoka objekti ir izveidoti spēles laikā.

  // Spoka limiti. (Nemainīgas vērtības)
  public int spokaAtlautaAgresivitate; // Nosaka cik agresīvs var būt spoks. Max = 20.
  public int spokaAtputasLaiks; // Nosaka cik spoka iespējas gājienus tas stāvēs uz vietas. Glabāšanas mainīgais.
  public int pecUzbrukumaAtputa; // 
  
  // Spoka progressa vērtības. (Mainīgās vērtības)
  protected int spokaAtputasLaikaMainamaKopija; // Šo mainīgo visu laiku maina.
  protected int SPOKA_FAZU_SKAITS;
  protected int randKustibasIespeja; // Skaitlis, kuru salīdzina ar spoka agresivitāti, lai tas spētu kustēties. Vērtība no 1 - 20 aktīvs, 0 neaktīvs.
  
  protected int spokaFazesIndekss; // Nosaka, kādu bildi rādīs spēlē. (Progress līdz mērķa izpildei)
  protected boolean spoksAtnacis; // Ja spoks ir aktīvs, tad tas var kustēties, savādāk tas stāvēs netiks atjaunināts. // Spoka stāvoklis. (ON vai OFF)

  protected String[] izskats;
 

  public Spoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    this.spokaAtlautaAgresivitate = spokaAtlautaAgresivitate;
    this.spokaAtputasLaiks = spokaAtputasLaikaMainamaKopija = spokaAtputasLaiks;

    spokaFazesIndekss = 0; // Visi spoki sāk no nultās (sākuma) pozīcijas.

    if (spokaAtlautaAgresivitate != 0) {
      spoksAtnacis = true;
    }

    atnakusoSpokuSkaits++; // + 1.
  }

  public String[] getIzskats() {
    return izskats;
  }

  // * setters:
  /// Public (Izmantojami jebkurā failā):
  public void setSpokaAtputasLaikaMainamaKopija(int spokaAtputasLaikaMainamaKopija) {
    this.spokaAtputasLaikaMainamaKopija = spokaAtputasLaikaMainamaKopija;
  }

  public void setSpoksAtnacis(boolean vertiba) {
    spoksAtnacis = vertiba;
  }

  public void deaktivizetSpoku() {
    spoksAtnacis = false;
    spokaFazesIndekss = 0;
    pecUzbrukumaAtputa = 10;
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
  public boolean getSpoksAtnacis() {
    return spoksAtnacis;
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
    if (spoksAtnacis) {
      atjaunotRandomKustibasIespeju();
      noteiktGajienaRezultatu();
    }
  }

  protected void noteiktGajienaRezultatu() {
    // Nosaka vai spoks cenšas kustēties vai nē.
    if (randKustibasIespeja <= spokaAtlautaAgresivitate) {
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

  protected void atjaunotRandomKustibasIespeju() {
    randKustibasIespeja = Main.rand.nextInt(20) + 1; // Vērtības no 1 - 20.
  }
  
  /// Statiskās metodes (Izmantojamas main programmā vai citās metodēs, vai thredos, kuri ir aktivizēti vai izmantoti main metodē):
  public static void izveidotSpokus() {
    // Izveido spoku objektus.
    LogaSpoks.logaSpoks.izveidotJaunuLogaSpokaObjektu();
    DurvjuSpoks.durvjuSpoks.izveidotJaunuDurvjuSpokaObjektu();
    PagrabaSpoks.pagrabaSpoks.izveidotJaunuPagrabaSpokaObjektu();

    deaktivizetSpokus();
  }

  public static void atjauninatSpokus() {
    if (LogaSpoks.logaSpoks.getSpoksAtnacis()) {
      LogaSpoks.logaSpoks.atjauninatSpoku();
    }
    
    if (DurvjuSpoks.durvjuSpoks.getSpoksAtnacis()) {
      DurvjuSpoks.durvjuSpoks.atjauninatSpoku();
    }

    if (PagrabaSpoks.pagrabaSpoks.getSpoksAtnacis()) {
      PagrabaSpoks.pagrabaSpoks.atjauninatSpoku();
    }
  }
  
  public static void meginatIeslegtSpokus() {
    // Ja spoks ir neaktīvs, tad ir rand iespēja to aktivizēt.
    LogaSpoks.logaSpoks.censtiesAtnakt();
    DurvjuSpoks.durvjuSpoks.censtiesAtnakt();
    PagrabaSpoks.pagrabaSpoks.censtiesAtnakt();
  }

  public static void deaktivizetSpokus() {
    // Izslēdz visus spokus.
    LogaSpoks.logaSpoks.deaktivizetSpoku();
    DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    PagrabaSpoks.pagrabaSpoks.deaktivizetSpoku();
  }

  public static void spokuInfo() {
    System.out.println(); // Vieta priekš ievades.
    System.out.println(LogaSpoks.logaSpoks.toString());
    System.out.println(DurvjuSpoks.durvjuSpoks.toString());
    System.out.println(PagrabaSpoks.pagrabaSpoks.toString());
  }

  public static void parbauditSpokuFazes() {
    // Metode pārbauda visu spoku fāzes, lai tie varētu uzbrukt spēlētājam.
    LogaSpoks.logaSpoks.noteiktRezultatu();
    DurvjuSpoks.durvjuSpoks.noteiktRezultatu();
    PagrabaSpoks.pagrabaSpoks.noteiktRezultatu();
  }
}
