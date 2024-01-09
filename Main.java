public class Main {
    // Visur izmantojamie mainīgie jeb objekti.
    static boolean sakumaEkrans = true;
    static volatile boolean speleSakas = true; // Mainīgais bool, kas palaiž visu spēli.

    //////////////////////////////////////////////////////////////////////////// S P Ē L E S   I E S T A T Ī J U M I ///////////////////////////////////////////////////////////////////////////////////////
    static int spelesNakts = 6;

    static int atlikusoSerkocinuDaudzums = 10;
    static int maxSerkocinaDegsanasLaiks = 10;



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static String[] visiVaronaUzdevumi = {"Pildit majasdarbus", "Est", "Mazgat", "Kartot", "Lasit", "Tirit"}; // TODO: Izmantot vai pārveidot.

    // *Beta* spēlētāja darbības.
    volatile static boolean pagrabaGaismaON = false;

    // Iestata tikšķa jeb 1 "refreša" periodu.
    static int framesPerSecond = 1000 / 25; // Pēc cik ilga laika ekrāns "refrešojas". (Milisekundēs)
    static int spelesIlgums = 360;

    public static void main(String[] args) throws InterruptedException {
        // Jaunie rīki.
        Laiks laiks = new Laiks(); // Izveido jaunu Thredu, kas vienlaicīgi pildās
        Ievade ievadesLasitajs = new Ievade(); // Arī threads, bet šis lasa ievadi.
        SkanasSpeletajs skanasSpeletajs = new SkanasSpeletajs();
        ///////// T H R E D I //////////
        ievadesLasitajs.start();
        //////////////////////////////////////////////////////// S P Ē L E S   I Z V Ē L N E //////////////////////////////////////////////////////
        tiritEkranu();
        while (sakumaEkrans) {

            VaronaDarbibas.varonaDarbibas(Ievade.ievade);
            UI_Izskats.masivuIzvade(SakumaEkrans.sakumaEkranaBildesCikls());

            try { // Vienas bildes izvade jeb beigas.
                Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 30 FPS.
            } catch (Exception e) {
                // Kods ko pildīs, ja "try" kods izmetīs kļūdu.
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Sākas atsevišķās darbības jeb patstāvīgie procesi.
        laiks.start();
        
        skanasSpeletajs.start();
        
        ////////////////////////////////////////////////////////////////////// S Ā K A S   S P Ē L E S   K O D S /////////////////////////////////////////////////////////////////////////////////////////
        tiritEkranu();
        while (speleSakas) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.

            // ----------------------------------------------------------- vvv Jāatjauno, jāpārveido vvv --------------------------------------------------------// // TODO: Izmantot vai pārveidot.
            // Atjaunos istabas ar spoka bildēm tikai tad, kad loga spoks būs izvēlējies savu istabu.
            Spoki.logaSpoks();
            Spoki.durSpoks();
            Spoki.virSpoks();
            
            Istabu_Izskati.virtuvesPagrabaGaismasStavoklaNoteiksana();
            // ------------------------------------------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^---------------------------------------------------- // // TODO: Izmantot vai pārveidot.

            VaronaDarbibas.varonaDarbibas(Ievade.ievade); // Lietotāja jeb varoņa ievade un tās darbības (komandas un to darbības).

            if (Spoki.spokuInfoIzvadeBoolean) { // Spoku informācijas izvade. --Debuging--
                Spoki.spokuInformacijasIzvade();
            }

            UI_Izskats.salipinataUIIzvade(); // Izvade uz ekrāna.
            
            Ievade.notiritIevadi(); // Cikla beigās notīra Ievadi, jo visas matodes, kurām tā bija vajadzīga jau to ir paņēmušas.

            try { // Vienas bildes izvade jeb beigas.
                Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 30 FPS.
            } catch (Exception e) {
                // Kods ko pildīs, ja "try" kods izmetīs kļūdu.
            }
        }

        // Noķer un apstādina neatkarīgos procesus.
        laiks.join();
        ievadesLasitajs.join();
        skanasSpeletajs.join();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    static void tiritEkranu() {
        System.out.print("\033[H\033[2J"); // Notīra terminālu.
        System.out.flush(); // Kaut kas ar kursora pozīciju.
    }
}