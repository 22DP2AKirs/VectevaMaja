// Adrians Kiršteins, DP2-2.

public class Main {
    // Mainīgie jeb objekti.
    static volatile boolean programmaPalaista = true; // booleans, kas palaiž visu programmu.
    static boolean sakumaEkrans = false; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
    static volatile boolean spelePalaista = true; // Mainīgais bool, kas pašu spēli.

    static boolean varonaNemirstiba = true; // Vai varonis var zaudēt spēli vai nē.

    //* ////////////////////////////////////////////////// S P Ē L E S   I E S T A T Ī J U M I /////////////////////////////////////////////////////////////////

    // Gaismas dati.
    static boolean[] istabuGaismasIeslegtas = {FailuRedigetajs.booleanDatuAtgriezejs("gultasGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("divanaGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("durvjuGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("virtuvesGaisma")}; // Indeksi: 0. Gulta, 1. Dīvāns, 2. Durvis, 3. Virtuve.
    static boolean spokiSledzAraGaismu = FailuRedigetajs.booleanDatuAtgriezejs("spokiSledzAraGaismu");

    static int spelesNakts = 6;

    // Spelētāja pozīcija. 
    static int varonaVirzienaSkaitlis = 0;
    static int varonaIstabasSkaitlis = 0; // 0, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas. 

    static boolean elektribaIeslegta = FailuRedigetajs.booleanDatuAtgriezejs("elektribaIeslegta");

    // Sērkociņa dati.
    static int atlikusoSerkocinuDaudzums = FailuRedigetajs.intDatuAtgriezejs("atlikusoSerkocinuDaudzums");
    static int maxSerkocinaDegsanasLaiks = FailuRedigetajs.intDatuAtgriezejs("maxSerkocinaDegsanasLaiks");

    // Spoku dati.
    static int logaSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("logaSpokaAgresivitatesLimits");
    static int durvjuSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("durvjuSpokaAgresivitatesLimits");
    static int virtuvesSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("virtuvesSpokaAgresivitatesLimits");

    static int logaSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("logaSpokaDrosibasRobezas");
    static int durvjuSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("durvjuSpokaDrosibasRobezas");
    static int virtuvesSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("virtuvesSpokaDrosibasRobezas");

    //* ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static String[] visiVaronaUzdevumi = {"Pildit majasdarbus", "Est", "Mazgat", "Kartot", "Lasit", "Tirit"}; // TODO: Izmantot vai pārveidot.

    volatile static boolean pagrabaGaismaON = false;

    // Iestata tikšķa jeb 1 "refreša" periodu.
    static int framesPerSecond = 1000 / 25; // Pēc cik ilga laika ekrāns "refrešojas". (Milisekundēs)
    static int spelesIlgums = 100;// 6 min 360;

    public static void main(String[] args) throws InterruptedException {
        // Jaunie rīki jeb thredi.
        Ievade ievadesLasitajs = new Ievade(); // Arī threads, bet šis lasa ievadi.
        SkanasSpeletajs skanasSpeletajs = new SkanasSpeletajs();

        //* /////// T H R E D I //////////
        // Sākas atsevišķās darbības jeb patstāvīgie procesi.
        skanasSpeletajs.start(); // Strādā, kamēr spelePalaista bools ir true.
        ievadesLasitajs.start(); // Strādā, kamēr programmaPalaista bools ir true.
        
        while (programmaPalaista) { // Palaiž programmu.
            tiritEkranu();
            //* ////////////////////////////////////////////////////// S P Ē L E S   I Z V Ē L N E //////////////////////////////////////////////////////
            while (sakumaEkrans) {
                VaronaDarbibas.varonaDarbibas(Ievade.ievade);
                UIizskats.masivuIzvade(SakumaEkrans.sakumaEkranaBildesCikls());
                try { // Vienas bildes izvade jeb beigas.
                    Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 30 FPS.
                } catch (Exception e) {}
            }
            
            //* //////////////////////////////////////////////////////////////////// S Ā K A S   S P Ē L E S   K O D S /////////////////////////////////////////////////////////////////////////////////////////
            tiritEkranu();
            Laiks laiks = new Laiks(); // Katru reizi, kad ir palaista spēle, veido jaunu Laika thredu.
            laiks.start(); // Strādā, kamēr spelePalaista bools ir true.
            while (spelePalaista) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.

                // * --------------------------- vvv Jāatjauno, jāpārveido vvv ----------------------------// TODO: Izmantot vai pārveidot.
                
                IstabuIzskati.virtuvesPagrabaGaismasStavoklaNoteiksana();
                // * ------------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^--------------------------
                VaronaDarbibas.varonaDarbibas(Ievade.ievade); // Lietotāja jeb varoņa ievade un tās darbības (komandas un to darbības).

                if (Spoki.spokuInfoIzvadeBoolean) { // Spoku informācijas izvade. --Debuging--
                    Spoki.spokuInformacijasIzvade(); 
                }

                // Visām fāzēm, bildēm un visam vizuālajam ir jābūt gatavam pirms šīs metodes izsaukšanas!!!
                // Spoku vizuālais atjaunojums notiek Laiks.java Klasē.

                UIizskats.salipinataUIIzvade(); // Izvade uz ekrāna.
                
                Ievade.notiritIevadi(); // Cikla beigās notīra Ievadi, jo visas matodes, kurām tā bija vajadzīga jau to ir paņēmušas.

                try { // Vienas bildes izvade jeb beigas.
                    Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 30 FPS.
                } catch (Exception e) {
                    // Kods ko pildīs, ja "try" kods izmetīs kļūdu.
                }
            }

            try { // Laiks, lai spēlētājs varētu izlasīt, vai viņš uzvarēja vai zaudēja.
                Thread.sleep(5000);
            } catch (InterruptedException e) {}

            // Apstādina Laika thredu un izveido jaunu, kad palaiž spēli.
            laiks.join(); // wait for the thread to stop
            Laiks.spelesLaiks = 0; // Lai laika threads momentāli neapstātos pēc tā pališanas, atjauno spēles laiku.
            sakumaEkrans = true;
        }
        //* ///////////////////// L I E K   T H R E D I E M   B E I G T I E S /////////////////////////
        skanasSpeletajs.join();
        ievadesLasitajs.join();
    }

    static void tiritEkranu() {
        System.out.print("\033[H\033[2J"); // Notīra terminālu.
        System.out.flush(); // Kaut kas ar kursora pozīciju.
    }
}