package Spele.SpelesProcesi;

import Spele.Spoki;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Varonis.VaronaDarbibas;


public class Laiks extends Thread {
    public static volatile int spelesLaiks; // Visiem pieejamais objekts.
    public static String laikaTeksts = "1 2 P M ";
    public static int vienaStunda = Main.spelesIlgums / 6;

    public static int laiksCikIlgiElektribaBusIzslegta;

    @Override
    public void run() {
        // Izveido visus spokus.
        Spoki logaSpoks = new Spoki("loga", Main.logaSpokaAgresivitatesLimits);
        Spoki durvjuSpoks = new Spoki("durvju", Main.durvjuSpokaAgresivitatesLimits);
        Spoki virtuvesSpoks = new Spoki("virtuves", Main.virtuvesSpokaAgresivitatesLimits);

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
            if (!Main.elektribaIeslegta) { // Ja false, tad ...
                if (laiksCikIlgiElektribaBusIzslegta < 1) {
                    SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
                    Main.elektribaIeslegta = true;
                }
                laiksCikIlgiElektribaBusIzslegta--;
            }

            if (VaronaDarbibas.aizdedzinatsSerkocins && VaronaDarbibas.serkocinaDeksanasLaikaSkaititajs != Main.maxSerkocinaDegsanasLaiks) {
                VaronaDarbibas.serkocinaDeksanasLaikaSkaititajs++;
            } else {
                VaronaDarbibas.aizdedzinatsSerkocins = false;
                VaronaDarbibas.serkocinaDeksanasLaikaSkaititajs = 0;
            }

            // Spoku informācijas savākšana.
            Spoki.spokuStati = Spoki.spokuInformacijasSavaksana(logaSpoks, durvjuSpoks, virtuvesSpoks);
            
            // Gulēšana līdz nākamam kadram.
            try {
                Thread.sleep(1000); // 1000 = 1 sekunde.
            } catch (Exception e) {}
        }
        logaSpoks.izslegtSpoku();
        durvjuSpoks.izslegtSpoku();
        virtuvesSpoks.izslegtSpoku();
    }

    void randomIespejaIzslegtKadasIstabasGaismu() {
        if (Main.spokiSledzAraGaismu) { // Spēles iestatījums.
            int randomIzveletasIstabasCipars = Spoki.rand.nextInt(4);
            if (Spoki.rand.nextInt(60) + 1 == 1) {
                if (Main.istabuGaismasIeslegtas[randomIzveletasIstabasCipars] == true) {
                    Main.istabuGaismasIeslegtas[randomIzveletasIstabasCipars] = false;
                    SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
                }
            }
        }
    }

    void laikaVadiba() {
        Laiks.spelesLaiks++; // Spēles laiks palielinas, katru sekundi jeb spēlesĀtrumu.
            
        if (spelesLaiks == vienaStunda) {
            laikaTeksts = " 1 A M  ";
        } else if (spelesLaiks == vienaStunda * 2) {
            laikaTeksts = " 2 A M  ";
        } else if (spelesLaiks == vienaStunda * 3) {
            laikaTeksts = " 3 A M  ";
        } else if (spelesLaiks == vienaStunda * 4) {
            laikaTeksts = " 4 A M  ";
        } else if (spelesLaiks == vienaStunda * 5) {
            laikaTeksts = " 5 A M  ";
        } else if (spelesLaiks > vienaStunda * 6) {
            laikaTeksts = " 6 A M  ";
            Main.spelePalaista = false;
        }
    }
}