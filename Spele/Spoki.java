package Spele;

import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.SpokuIzskati;
import Spele.SpelesProcesi.Laiks;

public class Spoki {
    public static boolean spokuInfoIzvadeBoolean = false;
    // Statistikas objekti.
    int spokuSkaits; // Nedefinēta int vērtība ir 0. !!! NAV IZMANTOTS !!!

    // Mainīgie, kas nodrošina spoku izslēgšanos no citām Klasēm.
    public static boolean logaSpoksAktivs;
    public static boolean durvjuSpoksAktivs;
    public static boolean virtuvesSpoksAktivs;

    // Klases instances, jeb klases mainīgie.
    boolean bilesAtjaunosanaIespejaPirmsIzslegsanas;
    boolean vaiSpoksKustas; // Nosaka vai spoks šinī iespējā kustas.
    public boolean spoksAktivs;
    
    int spokaAgresivitatesLimits; // Šo pielīdzina RAND ciparam un nosaka vai spoks kustēsies.
    int randomKustibasIespejasCipars; // Dod spokam RAND ciparu, lai to pielīdzinātu agresivitātes limitam un noteiktu vai spoks kustēsies.

    public int spokaFazesIndeks; // Nosaka spoka fāzi.
    int spokaDrosibasRobezas; // Nosaka cik robežas spokam ir jāpāriet, lai palielinātu savu fāzi.

    public String spokaVeids;
    public String spokaIstaba; // Nosaka, kurā istabā ir loga spoks.

    // Spoku masīvi jeb array's.
    String[] logaSpokaIstabas = {"Gulta","Divans","Durvis","Virtuve"};
    String[] spokuVeidi = {"loga", "durvju", "virtuves"};

    public Spoki(String spokaVeids, int spokaAgresivitatesLimits) { // Konstruktors.
      this.spokaAgresivitatesLimits = spokaAgresivitatesLimits;
      this.spokaVeids = spokaVeids;

      spokaDrosibasRobezas = 3;
      spokaFazesIndeks = 0; // 0 nozīmē, ka spoks nav sācis uzbrukt.
      vaiSpoksKustas = false;
      spoksAktivs = false;
      bilesAtjaunosanaIespejaPirmsIzslegsanas = true;
    }

    public void randomKustibasCiparaAtjaunosana() {
        if (spoksAktivs) { // Darbojas tikai tad, kad spoks ir aktīvs (optimizācija).
            randomKustibasIespejasCipars = Main.rand.nextInt(20) + 1; // + 1, lai skaitļa intervāls būtu no 1 - 20, nevis no 0 - 19.
            vaiSpoksKustas = randomKustibasIespejasCipars < spokaAgresivitatesLimits;
        }
    }

    void spokuRobezuKapsana() {
      spokaDrosibasRobezas--; // Noņem vienu drošības robežu.
    }

    public void spokuVirzisanasUzPrieksu() { // Nosaka, vai spoks kustās uz priekšu, vai pārkāpj robežu.
      if (spoksAktivs) {
        if (vaiSpoksKustas && spokaDrosibasRobezas < 1) {
          spokaFazesIndeks++; // Pietuvina spoku mērķim.
          spokaDrosibasRobezas = 4;
        }
        else if (spokaDrosibasRobezas > 0) {
          spokuRobezuKapsana();
        }
      }
    }

    public void istabuBildesFazuAtjaunosana(String spokaVeids) {
      // Atjauno fāzi tikai tad, kad spoks ir aktīvs vai aizbiedēts, un tam vajag nomainīt bildi.
      if (spoksAktivs || bilesAtjaunosanaIespejaPirmsIzslegsanas) {
        if (spokaVeids.equals("loga") && spokaFazesIndeks < 9 && spokaIstaba != null) {
          if (spokaIstaba.equals("Gulta")) {
            SpokuIzskati.gultasLogaSpokaFazesBilde = SpokuIzskati.logaSpokaSkatiPieGultas[spokaFazesIndeks];
          }
          else if (spokaIstaba.equals("Divans")) {
            SpokuIzskati.divanaLogaSpokaFazesBilde = SpokuIzskati.logaSpokaSkatiPieDivana[spokaFazesIndeks];
          }
          else if (spokaIstaba.equals("Durvis")) {
            SpokuIzskati.durvjuLogaSpokaFazesBilde = SpokuIzskati.logaSpokaSkatiPieDurvim[spokaFazesIndeks];
          }
          else if (spokaIstaba.equals("Virtuve")) {
            SpokuIzskati.virtuvesLogaSpokaFazesBilde = SpokuIzskati.logaSpokaSkatiPieVirtuves[spokaFazesIndeks];
          }
        }
        else if (spokaVeids.equals("durvju") && spokaFazesIndeks < 10) {
          SpokuIzskati.durSpokaFazesBilde = SpokuIzskati.durvjuSpokaIzskati[spokaFazesIndeks];
        }
        else if (spokaVeids.equals("virtuves") && spokaFazesIndeks < 11) {
          SpokuIzskati.virtPrieksasPagrabaBildesArSpoku = SpokuIzskati.virtuvesSpokaIzskati[spokaFazesIndeks];
          IestatijumuDati.pagrabaGaismaStrada = true;
        }
        else { // Kods kurš strādās, tikai tad, kad spēlētājs nomirs no spoka. ! ! ! Z A U D Ē Š A N A S   K O D S ! ! !
          if (!Main.varonaNemirstiba) {
            VaronaStatusaEfekti.noteiktSpelesGalaRezultatu(spokaVeids.toUpperCase());
            
            Main.tiritEkranu();
            System.out.println("Jus nomirat!\nNaves iemesls: " + spokaVeids + " spoks.");
          }
        }
        // Kad aizbiedē spoku, tad bildei dod iespēju nomainīties uz bildi bez spoka.
        if (!spoksAktivs) {
          bilesAtjaunosanaIespejaPirmsIzslegsanas = false;
        }
      }
    }


    public void iespejaPadaritSpokuAktivu() { 
        if (!spoksAktivs) {
            if ((Main.rand.nextInt(2) + 1) == 1) { // Ja 1/20-ā jeb 5/100-ās iespēja ir patiesa, tad spoks paliek aktīvs.
                if (spokaVeids.equals("loga")) {
                    spokaIstaba = logaSpokaIstabas[Main.rand.nextInt(4)]; // 4, jo mājā ir četras istabas.
                    logaSpoksAktivs = true;
                }
                else if (spokaVeids.equals("durvju")) {
                    durvjuSpoksAktivs = true;
                }
                else if (spokaVeids.equals("virtuves")){
                    virtuvesSpoksAktivs =  true;
                }

                spoksAktivs = true;
                bilesAtjaunosanaIespejaPirmsIzslegsanas = true;
            }
        }  
    }


    public static Spoki[] spokuInformacijasSavaksana(Spoki logaSpoks, Spoki durvjuSpoks, Spoki virtuvesSpoks) {
        Spoki[] visiSpoki = new Spoki[3];
        visiSpoki[0] = logaSpoks;
        visiSpoki[1] = durvjuSpoks;
        visiSpoki[2] = virtuvesSpoks;

        return visiSpoki;
    }


    public static Spoki[] spokuStati = {
        new Spoki("loga", IestatijumuDati.logaSpokaAgresivitatesLimits),
        new Spoki("durvju", IestatijumuDati.durvjuSpokaAgresivitatesLimits),
        new Spoki("virtuves", IestatijumuDati.virtuvesSpokaAgresivitatesLimits)
    };

    public static void spokuInformacijasIzvade() {
        System.out.println();

        System.out.println("Loga spoks" + K.VIOLETS + " aktivs?: " + spokuStati[0].spoksAktivs + K.ZALS + " RAND cipars: " + spokuStati[0].randomKustibasIespejasCipars + K.ZILS + " Drosibas robezas: " + spokuStati[0].spokaDrosibasRobezas + " Fazes indekss: " + spokuStati[0].spokaFazesIndeks + " Istaba: " + spokuStati[0].spokaIstaba + K.RESET + "\033[0K");
        System.out.println("Durvju spoks" + K.VIOLETS + " aktivs?: " + spokuStati[1].spoksAktivs + K.ZALS + " RAND cipars: " + spokuStati[1].randomKustibasIespejasCipars + K.ZILS + " Drosibas robezas: " + spokuStati[1].spokaDrosibasRobezas + " Fazes indekss: " + spokuStati[1].spokaFazesIndeks + K.RESET + "\033[0K");
        System.out.println("Virtuves spoks" + K.VIOLETS + " aktivs?: " + spokuStati[2].spoksAktivs + K.ZALS + " RAND cipars: " + spokuStati[2].randomKustibasIespejasCipars + K.ZILS + " Drosibas robezas: " + spokuStati[2].spokaDrosibasRobezas + " Fazes indekss: " + spokuStati[2].spokaFazesIndeks + K.RESET + "\033[0K");
        
        System.out.println("Laiks ms: " + Laiks.spelesLaiks + " / " + Laiks.vienaStunda * 6 + K.RESET + ", Stressa limenis: " + VaronaStatusaEfekti.varonaStresaLimenis + "\033[0K");
        
    }

    public void izslegtSpoku() {
        spoksAktivs = false;
        spokaDrosibasRobezas = 3;
        spokaFazesIndeks = 0;
    }
}