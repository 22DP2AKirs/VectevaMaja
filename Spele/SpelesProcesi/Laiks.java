package Spele.SpelesProcesi;

import Spele.PaligMetodes;
import Spele.Spoki;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.MazasSpeles.MazoSpeluPalaisanasKods;
import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;


public class Laiks extends Thread {
  public static volatile int spelesLaiks; // Visiem pieejamais objekts.
  public static String laikaTeksts = "1 2 P M ";
  public static int vienaStunda = Main.spelesIlgums / 6;

  public static int laiksCikIlgiElektribaBusIzslegta;

  @Override
  public void run() {
    // Izveido visus spokus.
    Spoki logaSpoks = new Spoki("loga", IestatijumuDati.logaSpokaAgresivitatesLimits);
    Spoki durvjuSpoks = new Spoki("durvju", IestatijumuDati.durvjuSpokaAgresivitatesLimits);
    Spoki virtuvesSpoks = new Spoki("virtuves", IestatijumuDati.virtuvesSpokaAgresivitatesLimits);

    while (Main.spelePalaista) {
      laikaVadiba(); // Skaita laiku un nosaka, kad spēle ir beigusies.

      // Spoku izslēgšana.
      if (!Spoki.logaSpoksAktivs) {logaSpoks.izslegtSpoku();}
      if (!Spoki.durvjuSpoksAktivs) {durvjuSpoks.izslegtSpoku();}
      if (!Spoki.virtuvesSpoksAktivs) {virtuvesSpoks.izslegtSpoku();}
      
      // Spoku objektu RAND kustības atjaunošana.
      logaSpoks.randomKustibasCiparaAtjaunosana();
      durvjuSpoks.randomKustibasCiparaAtjaunosana();
      virtuvesSpoks.randomKustibasCiparaAtjaunosana();

      // Robezu pārkāpšana un fāzes palielināšana.
      logaSpoks.spokuVirzisanasUzPrieksu();
      durvjuSpoks.spokuVirzisanasUzPrieksu();
      virtuvesSpoks.spokuVirzisanasUzPrieksu();

      // Vizuālo skatu atjaunošana.
      logaSpoks.istabuBildesFazuAtjaunosana(logaSpoks.spokaVeids);
      durvjuSpoks.istabuBildesFazuAtjaunosana(durvjuSpoks.spokaVeids);
      virtuvesSpoks.istabuBildesFazuAtjaunosana(virtuvesSpoks.spokaVeids);

      // Iespēja padarīt spokus aktīvus.
      logaSpoks.iespejaPadaritSpokuAktivu();
      durvjuSpoks.iespejaPadaritSpokuAktivu();
      virtuvesSpoks.iespejaPadaritSpokuAktivu();

      randomIespejaIzslegtKadasIstabasGaismu(); // Iestatījums.

      // Skaita, cik ilgi līdz elektrības pieslēgšanas.
      if (!IestatijumuDati.elektribaIeslegta) { // Ja false, tad ...
        if (laiksCikIlgiElektribaBusIzslegta < 1) {
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
          IestatijumuDati.elektribaIeslegta = true;
        }
        laiksCikIlgiElektribaBusIzslegta--;
      }

      if (VaronaDarbibas.aizdedzinatsSerkocins && VaronaDarbibas.serkocinaDeksanasLaikaSkaititajs != IestatijumuDati.maxSerkocinaDegsanasLaiks) {
        VaronaDarbibas.serkocinaDeksanasLaikaSkaititajs++;
      } else {
        VaronaDarbibas.aizdedzinatsSerkocins = false;
        VaronaDarbibas.serkocinaDeksanasLaikaSkaititajs = 0;
      }

      // Spoku informācijas savākšana.
      Spoki.spokuStati = Spoki.spokuInformacijasSavaksana(logaSpoks, durvjuSpoks, virtuvesSpoks);
      
      // Gulēšana līdz nākamam kadram.
      PaligMetodes.gulet(1);
    }
    logaSpoks.izslegtSpoku();
    durvjuSpoks.izslegtSpoku();
    virtuvesSpoks.izslegtSpoku();
  }

  private void randomIespejaIzslegtKadasIstabasGaismu() {
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
    if (spelesLaiks == vienaStunda) {
      laikaTeksts = " 1 A M  ";

      // Mājasdarbu kods.
      apskatitMajasdarbu();
    }
    else if (spelesLaiks == vienaStunda * 2) {
      laikaTeksts = " 2 A M  ";

      // Mājasdarbu kods.
      apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 3) {
      laikaTeksts = " 3 A M  ";

      // Mājasdarbu kods.
      apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 4) {
      laikaTeksts = " 4 A M  ";
      
      // Mājasdarbu kods.
      apskatitMajasdarbu();
    } 
    else if (spelesLaiks == vienaStunda * 5) {
      laikaTeksts = " 5 A M  ";

      // Mājasdarbu kods.
      apskatitMajasdarbu();
    } 
    else if (spelesLaiks > vienaStunda * 6) {
      laikaTeksts = " 6 A M  ";
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("UZVARA");
    }
  }

  private void apskatitMajasdarbu() {
    // * Metode pārbauda un ieslēdz mājasdarbu.

    parbauditVaiVaronisPaspejaIzpilditMajasdarbu();
    ieslegtKaduMajasdarbu();
  }

  private void parbauditVaiVaronisPaspejaIzpilditMajasdarbu() {
    // * Metode pārbauda vai varonis ir izpildījis mājasdarbu noteiktajā laikā.
    // * Ja nav, tad viņš zaudē.

    if (Main.izveletaMazaSpele) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("MAJASDARBA_LAIKS");
    }
  }

  private void ieslegtKaduMajasdarbu() {
    // * Metode norādītajā laikā ieslēdz vieno no m-spēlēm.

    int randCipars = Main.rand.nextInt(1); // No 0 ieskaitot, līdz "norādītais" neieskaitot.
    if (randCipars == 0) {
      MazoSpeluPalaisanasKods.izveidotJaunuKaratavasSpeli();
      Main.karatavas = true;
    }
    else if (randCipars == 1) {
      // kods.
    }
    Main.izveletaMazaSpele = true;
  }

}