package Spele.SpelesProcesi;

import Spele.PaligMetodes;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.Spoki.Spoks;
import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;

public class Laiks extends Thread {
  public static volatile int spelesLaiks; // Visiem pieejamais objekts.
  public static int stundasLaiks = 0;
  public static String laikaTeksts = "1 2 PM";
  
  public static int vienaStunda = Main.spelesIlgums / 6;

  @Override
  public void run() {
  
    while (Main.spelePalaista) {
      // Ja kāds proces padara thrediGul boolu true, tad šis threds gulēs 3 sekundes.
      paguletNoteiktuLaiku();

      // Skaita laiku un nosaka, kad spēle ir beigusies.
      laikaVadiba(); 

      // Spoku kods.
      Spoks.meginatIeslegtSpokus(); // Ja spoks ir neaktīvs, tad ir rand iespēja to aktivizēt.
      Spoks.atjauninatSpokus(); // Nosaka, kāds būs spoka kustības rezultāts.
      Spoks.parbauditSpokuFazes(); // Pārbauda vai spoks var uzbrukt varonim.

      randomIespejaIzslegtKadasIstabasGaismu(); // Iestatījums.

      // Skaitītāji.
      VaronaDarbibas.skaititCikIlgiLidzElektribasPieslegsanas();
      VaronaDarbibas.skaititCikIlgiDegsSerkocins();
      
      // Gulēšana līdz nākamam kadram.
      PaligMetodes.gulet(1);
    }
  }

  private void paguletNoteiktuLaiku() {
    // * Metode apstādina thredu uz noteiktu laiku.
    if (Main.laikaTredsGul) {
      PaligMetodes.gulet(3);
      Main.laikaTredsGul = false;
    }
  }

  private void randomIespejaIzslegtKadasIstabasGaismu() {
    // * Metode izslēdz vienu no 4-trām mājas gaismām.
    if (SakumaDati.spokiSledzAraGaismu) { // Spēles iestatījums.
      int randomIzveletasIstabasCipars = Main.rand.nextInt(4);
      if (Main.rand.nextInt(80) + 1 == 1) { // 1.25 % iespēja.
        if (SakumaDati.istabuGaismasIeslegtas[randomIzveletasIstabasCipars] == true) {
          SakumaDati.istabuGaismasIeslegtas[randomIzveletasIstabasCipars] = false;
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
        }
      }
    }
  }

  private void laikaVadiba() {
    Laiks.spelesLaiks++; // Spēles laiks palielinas, katru sekundi jeb spēlesĀtrumu.

    // Zemāk norādītais kods izpildās tikai tad, kad laiks ir precīzs norādītajam.
    // Tas nozīmē, ka izvēle izpildīsies vienu reizi norādītajā laikā.
    if (spelesLaiks < 2) {
      laikaTeksts = "1 2 PM  ";
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    }
    else if (spelesLaiks == vienaStunda) {
      stundasLaiks = 1;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    }
    else if (spelesLaiks == vienaStunda * 2) {
      stundasLaiks = 2;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 3) {
      stundasLaiks = 3;
      laikaTeksts = "  " + stundasLaiks + " AM  ";
      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();

      SakumaDati.uzstaditSpokusUzPusnaktsRezimu();
    } 
    else if (spelesLaiks == vienaStunda * 4) {
      stundasLaiks = 4;
      laikaTeksts = "  " + stundasLaiks + " AM  ";
      
      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 5) {
      stundasLaiks = 5;
      laikaTeksts = "  " + stundasLaiks + " AM  ";

      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks > vienaStunda * 6) {
      if (MazoSpeluIzvelesKods.izveletaMazaSpele && Main.varonaNemirstiba == false) {
        MazoSpeluIzvelesKods.parbauditVaiVaronisPaspejaIzpilditMajasdarbu(); // Pārbauda vai varonis izpildīja pēdējo mājasdarbu.
      }
      else {
        VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("UZVARA");
      }
    }
  }
}