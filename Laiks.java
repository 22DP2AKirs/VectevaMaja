public class Laiks extends Thread {
    public static volatile int spelesLaiks; // Visiem pieejamais objekts.
    public static String laikaTeksts = "1 2 P M ";
    public static int vienaStunda = Main.spelesIlgums / 6;

    static int gaidisanasLaiks;

    @Override
    public void run() {
        // Izveido visus spokus.
        Spoki logaSpoks = new Spoki("loga");
        Spoki durvjuSpoks = new Spoki("durvju");
        Spoki virtuvesSpoks = new Spoki("virtuves");

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
            logaSpoks.istabuBildesFazuAtjaunosana(logaSpoks.spokaVeids, logaSpoks.spokaIstaba);
            durvjuSpoks.istabuBildesFazuAtjaunosana(durvjuSpoks.spokaVeids, durvjuSpoks.spokaIstaba);
            virtuvesSpoks.istabuBildesFazuAtjaunosana(virtuvesSpoks.spokaVeids, virtuvesSpoks.spokaIstaba);

            // Iespēja padarīt spokus aktīvus.
            logaSpoks.iespejaPadaritSpokuAktivu();
            durvjuSpoks.iespejaPadaritSpokuAktivu();
            virtuvesSpoks.iespejaPadaritSpokuAktivu();

            randomIespejaIzslegtKadasIstabasGaismu();

            if (!VaronaDarbibas.elektribaIeslegta) { // Ja false, tad ...
                if (gaidisanasLaiks <= 0) {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\fuse-box-turning-on-off.wav", 0);
                    VaronaDarbibas.elektribaIeslegta = true;
                }
                gaidisanasLaiks--;
            }

            if (VaronaDarbibas.aizdedzinatsSerkocins && VaronaDarbibas.serkocinaDegsanasLaiks != Main.maxSerkocinaDegsanasLaiks) {
                VaronaDarbibas.serkocinaDegsanasLaiks++;
            } else {
                VaronaDarbibas.aizdedzinatsSerkocins = false;
                VaronaDarbibas.serkocinaDegsanasLaiks = 0;
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
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\gaismas-sledzis-off.wav", 0);
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
        } else if (spelesLaiks == vienaStunda * 6) {
            laikaTeksts = " 6 A M  ";
            Main.spelePalaista = false;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            Main.tiritEkranu();
            System.out.println("Jus izdzivojat!!\n\n\n\n\n");
        }
    }
}