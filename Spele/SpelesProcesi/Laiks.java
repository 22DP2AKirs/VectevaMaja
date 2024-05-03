package Spele.SpelesProcesi;

import Spele.PaligMetodes;
import Spele.Enums.NavesIemesli;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.Spoki.Spoks;
import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;

public class Laiks extends Thread {
  public static volatile int 
  spelesLaiks, // Visiem pieejamais objekts.
  spelesIlgums = 300;// 6 min 360, 5min 300;

  public static int 
  stundasLaiks,
  vienaStunda;
  
  public static String laikaTeksts = "1 2 PM";

  public Laiks() {
    spelesLaiks = stundasLaiks = 0;
    laikaTeksts = "1 2 PM";
    vienaStunda = spelesIlgums / 6;
  }

  @Override
  public void run() {
    while (Main.spelePalaista) {
      // 1. Skaita laiku un nosaka, kad spēle ir beigusies.
      laikaVadiba(); 
      MazoSpeluIzvelesKods.izpildijaVisusMajasdarbus();
      // 2. Izpilda spoku darbības.
      spokuDarbibas();
      // 3. Skaitītāji.
      VaronaDarbibas.skaititCikIlgiLidzElektribasPieslegsanas();
      VaronaDarbibas.skaititCikIlgiDegsSerkocins();
      MazoSpeluIzvelesKods.pamazinatLaikuLidzMajasdarbam();
      // 4. Citas darbības.
      randomIespejaIzslegtKadasIstabasGaismu(); // Iestatījums.
      // Gulēšana līdz nākamam kadram.
      PaligMetodes.gulet(1);
    }
  }

  private void spokuDarbibas() {
    Spoks.meginatIeslegtSpokus(); // Ja spoks ir neaktīvs, tad ir rand iespēja to aktivizēt.
    Spoks.atjauninatSpokus(); // Nosaka, kāds būs spoka kustības rezultāts.
    Spoks.parbauditSpokuFazes(); // Pārbauda vai spoks var uzbrukt varonim.
  }

  private void randomIespejaIzslegtKadasIstabasGaismu() {
    // * Izslēdz vienu no 4-trām mājas gaismām.
    if (SakumaDati.spokiSledzAraGaismu) { // Spēles iestatījums.
      int randomIzveletasIstabasCipars = Main.rand.nextInt(4);
      if (Main.rand.nextInt(80) + 1 == 1 && SakumaDati.istabuGaismasIeslegtas[randomIzveletasIstabasCipars] == true) { // 1.25 % iespēja.
        SakumaDati.istabuGaismasIeslegtas[randomIzveletasIstabasCipars] = false;
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
      }
    }
  }

  private void laikaVadiba() {
    // 1. Palielina spēles laiku.
    Laiks.spelesLaiks++;

    // 2. Izpilda darbības, katru spēles stundu.
    if (spelesLaiks < 2) {
      laikaTeksts = "1 2 PM  ";
    }
    else if (spelesLaiks == vienaStunda) {
      stundasLaiks = 1;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

    }
    else if (spelesLaiks == vienaStunda * 2) {
      stundasLaiks = 2;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

    } 
    else if (spelesLaiks == vienaStunda * 3) {
      stundasLaiks = 3;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

      SakumaDati.uzstaditSpokusUzPusnaktsRezimu();
    } 
    else if (spelesLaiks == vienaStunda * 4) {
      stundasLaiks = 4;
      laikaTeksts = "  " + stundasLaiks + " AM  ";
      
    } 
    else if (spelesLaiks == vienaStunda * 5) {
      stundasLaiks = 5;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

    } 
    else if (spelesLaiks > vienaStunda * 6) {
      VaronaStatusaEfekti.spelesRezultats(NavesIemesli.PULKSTENIS);
    }
  }
}