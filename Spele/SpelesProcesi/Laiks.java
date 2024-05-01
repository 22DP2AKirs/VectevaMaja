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
  public static volatile int spelesLaiks; // Visiem pieejamais objekts.
  public static String laikaTeksts = "1 2 PM";

  public static int 
  stundasLaiks = 0,
  vienaStunda = Main.spelesIlgums / 6;

  @Override
  public void run() {
    while (Main.spelePalaista) {
      // 1. Ja kāds proces padara thrediGul boolu true, tad šis threds gulēs 3 sekundes.
      paguletNoteiktuLaiku();

      // 2. Skaita laiku un nosaka, kad spēle ir beigusies.
      laikaVadiba(); 

      // 3. Izpilda spoku darbības.
      spokuDarbibas();
      
      // 4. Skaitītāji.
      VaronaDarbibas.skaititCikIlgiLidzElektribasPieslegsanas();
      VaronaDarbibas.skaititCikIlgiDegsSerkocins();
      
      // 5. Citas darbības.
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

  private void paguletNoteiktuLaiku() {
    // * Apstādina thredu uz noteiktu laiku.
    if (Main.laikaTredsGul) {
      PaligMetodes.gulet(3);
      Main.laikaTredsGul = false;
    }
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
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    }
    else if (spelesLaiks == vienaStunda) {
      stundasLaiks = 1;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    }
    else if (spelesLaiks == vienaStunda * 2) {
      stundasLaiks = 2;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 3) {
      stundasLaiks = 3;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

      MazoSpeluIzvelesKods.apskatitMajasdarbu();
      SakumaDati.uzstaditSpokusUzPusnaktsRezimu();
    } 
    else if (spelesLaiks == vienaStunda * 4) {
      stundasLaiks = 4;
      laikaTeksts = "  " + stundasLaiks + " AM  ";
      
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 5) {
      stundasLaiks = 5;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks > vienaStunda * 6) {
      if (MazoSpeluIzvelesKods.izveletaMazaSpele && Main.varonaNemirstiba == false) {
        MazoSpeluIzvelesKods.parbauditVaiVaronisPaspejaIzpilditMajasdarbu(); // Pārbauda vai varonis izpildīja pēdējo mājasdarbu.
      }
      else {
        VaronaStatusaEfekti.spelesRezultats(NavesIemesli.UZVARA);
      }
    }
  }
}