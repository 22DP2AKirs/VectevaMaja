package Spele.Spoki;

import Spele.SpelesProcesi.Main;

public class Spoks {
  // ? Katra spoka mērķis ir vainu traucēt, vainu novākt varoni.
  private int atnakusoSpokuSkaits = 0; // Statistikas mainīgais, nosaka cik spoku objekti tika izvaidoti.

  private static int spokaAtlautaAgresivitate; // Nosaka cik agresīvs var būt spoks. Max = 20.
  private int spokaAtputasLaiks; // Nosaka cik spoka iespējas gājienus tas stāvēs uz vietas. Glabāšanas mainīgais.
  private static int spokaAtputasLaikaMainamaKopija; // Šo mainīgo visu laiku maina.
  private static int spokaFazesIndekss; // Nosaka, kādu bildi rādīs spēlē. (Progress līdz mērķa izpildei)
  private int randKustibasIespeja; // Skaitlis, kuru salīdzina ar spoka agresivitāti, lai tas spētu kustēties. Vērtība no 1 - 20 aktīvs, 0 neaktīvs.
  private boolean spoksKustasNakosaGajiena; // Kad spoks ir izgaidījis visu savu atpūtas laiku, tad nākošajā gājienā tas kustās uz nākošo fāzi (indeksu).
  private static boolean spoksIrAizbiedets; // Ja spoks ir aizbiedēts, tad viņš pazūd no spēles. (vairs nekustās)

  public Spoks(int spokaAtlautaAgresivitate, int spokaAtputasLaiks) {
    Spoks.spokaAtlautaAgresivitate = spokaAtlautaAgresivitate;
    this.spokaAtputasLaiks = spokaAtputasLaiks;
    spokaAtputasLaikaMainamaKopija = spokaAtputasLaiks; // Izveido mainīgo, kuru mainīs programmas laikā.
    spokaFazesIndekss = 0; // Visi spoki sāk no nultās (sākuma) pozīcijas.
    spoksIrAizbiedets = false;
    atnakusoSpokuSkaits++;
  }

  // Get metodes.
  public int getAtnakusoSpokuSkaits() {
    return atnakusoSpokuSkaits;
  }
  public static int getSpokaAtlautaAgresivitate() {
    return spokaAtlautaAgresivitate;
  }

  public static int getSpokaAtputasLaikaMainamaKopija() {
    return spokaAtputasLaikaMainamaKopija;
  }

  public int getSpokaAtputasLaiks() {
    return spokaAtputasLaiks;
  }

  public int getSpokaFazesIndekss() {
    return spokaFazesIndekss;
  }

  public boolean getSpoksKustasNakosaGajiena() {
    return spoksKustasNakosaGajiena;
  }

  public boolean getSpoksIrAizbiedets() {
    return spoksIrAizbiedets;
  }

  // Set metodes.
  public void setSpokaFazesIndekss(int vertiba) {
    spokaFazesIndekss = vertiba;
  }

  public void setSpoksKustasNakosaGajiena(boolean vertiba) {
    spoksKustasNakosaGajiena = vertiba;
  }

  public void setSpoksIrAizbiedets(boolean vertiba) {
    spoksIrAizbiedets = vertiba;
  }

  // Citas metodes.
  public static void meginatIeslegtSpokus() {
    LogaSpoks.meginatIzveidotLogaSpoku();
    DurvjuSpoks.meginatIzveidotDurvjuSpoku();
    VirtuvesSpoks.meginatIzveidotVirtuvesSpoku();
  }

  public static void spokuInfo() {
    System.out.println();
    System.out.println(LogaSpoks.getLogaSpoks().toString());
    System.out.println(DurvjuSpoks.getDurvjuSpoks().toString());
    System.out.println(VirtuvesSpoks.getVirtuvesSpoks().toString());
  }

  public static void atjauninatSpokus() {
    if (!LogaSpoks.logaSpoks.getSpoksIrAizbiedets()) {
      LogaSpoks.getLogaSpoks().atjauninatSpoku();
    }
    
    if (!DurvjuSpoks.durvjuSpoks.getSpoksIrAizbiedets()) {
      DurvjuSpoks.getDurvjuSpoks().atjauninatSpoku();
    }

    if (!VirtuvesSpoks.virtuvesSpoks.getSpoksIrAizbiedets()) {
      VirtuvesSpoks.getVirtuvesSpoks().atjauninatSpoku();
    }
  }

  public void izslegtSpoku() {
    setSpoksIrAizbiedets(true);
    spokaFazesIndekss = 0;
  }

  public void atjauninatSpoku() {
    if (!spoksIrAizbiedets) {
      noteiktGajienaRezultatu();
    }
  }

  private void noteiktGajienaRezultatu() {
    atjaunotRandKustibasIespeju();
    // Nosaka vai spoks cenšas kustēties vai nē.
    if (randKustibasIespeja < spokaAtlautaAgresivitate) {
      if (spoksKustasNakosaGajiena) {
        pieietTuvak();
      }
      else {
        atpustiesVienuGajienu();
      }
    }
  }

  private void atpustiesVienuGajienu() {
    if (spokaAtputasLaikaMainamaKopija == 0) {
      spoksKustasNakosaGajiena = true;
    }
    else {  
      spokaAtputasLaikaMainamaKopija--;
    }
  }

  private void pieietTuvak() {
    spokaFazesIndekss++;
    spoksKustasNakosaGajiena = false;
    spokaAtputasLaikaMainamaKopija = spokaAtputasLaiks;
  }

  private void atjaunotRandKustibasIespeju() {
    randKustibasIespeja = Main.rand.nextInt(20) + 1;
  }
}
