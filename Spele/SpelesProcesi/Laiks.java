package Spele.SpelesProcesi;

import Spele.PaligMetodes;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.MazasSpeles.AtrodiPari.AtrodiPari;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.Spoki.Spoks;
import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;


public class Laiks extends Thread {
  public static volatile int spelesLaiks; // Visiem pieejamais objekts.
  public static String laikaTeksts = "1 2 P M ";
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
    if (Main.thrediGul) {
      PaligMetodes.gulet(3);
      Main.thrediGul = false;
    }
  }

  private void randomIespejaIzslegtKadasIstabasGaismu() {
    // * Metode izslēdz vienu no 4-trām mājas gaismām.
    if (IestatijumuDati.spokiSledzAraGaismu) { // Spēles iestatījums.
      int randomIzveletasIstabasCipars = Main.rand.nextInt(4);
      if (Main.rand.nextInt(60) + 1 == 1) {
        if (IestatijumuDati.istabuGaismasIeslegtas[randomIzveletasIstabasCipars] == true) {
          IestatijumuDati.istabuGaismasIeslegtas[randomIzveletasIstabasCipars] = false;
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
      laikaTeksts = "1 2 A M ";
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    }
    else if (spelesLaiks == vienaStunda) {
      laikaTeksts = " 1 A M  ";

      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    }
    else if (spelesLaiks == vienaStunda * 2) {
      laikaTeksts = " 2 A M  ";

      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 3) {
      laikaTeksts = " 3 A M  ";

      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 4) {
      laikaTeksts = " 4 A M  ";
      
      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 5) {
      laikaTeksts = " 5 A M  ";

      // Mājasdarbu kods.
      MazoSpeluIzvelesKods.apskatitMajasdarbu();
    } 
    else if (spelesLaiks > vienaStunda * 6) {
      laikaTeksts = " 6 A M  ";
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("UZVARA");
    }
  }
}