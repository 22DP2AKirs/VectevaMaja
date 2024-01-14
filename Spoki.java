import java.util.Random;

public class Spoki {
    public static Random rand = new Random(); // Priekš random darbībām.
    static boolean spokuInfoIzvadeBoolean = false;
    // Statistikas objekti.
    int spokuSkaits; // Nedefinēta int vērtība ir 0. !!! NAV IZMANTOTS !!!

    // Klases instances jeb objekti, jeb mainīgie.
    boolean spoksAktivs;
    String spokaVeids;

    int spokaAgresivitatesLimits; // Šo pielīdzina RAND ciparam un nosaka vai spoks kustēsies.
    int randomKustibasIespejasCipars; // Dod spokam RAND ciparu, lai to pielīdzinātu agresivitātes limitam un noteiktu vai spoks kustēsies.

    boolean vaiSpoksKustas; // Nosaka vai spoks šinī iespējā kustas.

    int spokaFazesIndeks; // Nosaka spoka fāzi.
    int spokaDrosibasRobezas; // Nosaka cik robežas spokam ir jāpāriet, lai palielinātu savu fāzi.

    String spokaIstaba; // Nosaka, kurā istabā ir loga spoks.

    // Spoku masīvi jeb array's.
    String[] logaSpokaIstabas = {"Gulta","Divans","Durvis","Virtuve"};
    String[] spokuVeidi = {"loga", "durvju", "virtuves"};

    public Spoki(String spokaVeids) { // Konstruktors.
        if (spokaVeids.equals("loga")) {
            this.spokaAgresivitatesLimits = Main.logaSpokaAgresivitatesLimits;
            this.spokaIstaba = logaSpokaIstabas[rand.nextInt(4)]; // 4, jo mājā ir četras istabas.
        } 
        else if (spokaVeids.equals("durvju")) {
            this.spokaAgresivitatesLimits = Main.durvjuSpokaAgresivitatesLimits;
        } 
        else if (spokaVeids.equals("virtuves")) {
            this.spokaAgresivitatesLimits = Main.virtuvesSpokaAgresivitatesLimits;
        }
        this.spokaDrosibasRobezas = 3;
        this.spokaVeids = spokaVeids;
        this.spokaFazesIndeks = 0; // 0 nozīmē, ka spoks nav sācis uzbrukt.
        this.vaiSpoksKustas = false;
        this.spoksAktivs = false;
    }

    void randomKustibasCiparaAtjaunosana() {
        randomKustibasIespejasCipars = rand.nextInt(20) + 1; // + 1, lai skaitļa intervāls būtu no 1 - 20, nevis no 0 - 19.
        this.vaiSpoksKustas = randomKustibasIespejasCipars < spokaAgresivitatesLimits;
    }

    void spokuVirzisanasUzPrieksu() {
        if (this.spoksAktivs && this.vaiSpoksKustas) {
            if (this.spokaDrosibasRobezas < 1) { // Kad spoks pārkāpj visas drošības robežas, tad viņš nākošajā kustībā nāk par 1 fāzi tuvāk un pēc tam, kāpj pāri nākošām robežām.
                this.spokaFazesIndeks++; // Pietuvina spoku mērķim.
                this.spokaDrosibasRobezas = 4;
            }
            this.spokaDrosibasRobezas--; // Noņem vienu drošības robežu.
        }
    }

    void istabuBildesFazuAtjaunosana(String spokaVeids, String istaba) {
        if (spokaVeids.equals("loga") && spokaFazesIndeks < 9) {
            if (istaba.equals("Gulta")) {
                Istabu_Izskati.gultasLogaSpokaFazesBilde = Spoku_Izskati.logaSpokaSkatiPieGultas[spokaFazesIndeks];
            }
            else if (istaba.equals("Divans")) {
                Istabu_Izskati.divanaLogaSpokaFazesBilde = Spoku_Izskati.logaSpokaSkatiPieDivana[spokaFazesIndeks];
            }
            else if (istaba.equals("Durvis")) {
                Istabu_Izskati.durvjuLogaSpokaFazesBilde = Spoku_Izskati.logaSpokaSkatiPieDurvim[spokaFazesIndeks];
            }
            else if (istaba.equals("Virtuve")) {
                Istabu_Izskati.virtuvesLogaSpokaFazesBilde = Spoku_Izskati.logaSpokaSkatiPieVirtuves[spokaFazesIndeks];
            }
        }
        else if (spokaVeids.equals("durvju") && spokaFazesIndeks < 10) {
            Istabu_Izskati.durSpokaFazesBilde = Spoku_Izskati.durvjuSpokaIzskati[spokaFazesIndeks];
        }
        else if (spokaVeids.equals("virtuves") && spokaFazesIndeks < 11) {
            Istabu_Izskati.virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSpokaIzskati[spokaFazesIndeks];
        }
        else { // Kods kurš strādās, tikai tad, kad spēlētājs nomirs no spoka. TODO: ! ! ! Z A U D Ē Š A N A S   K O D S ! ! !
            if (!Main.varonaNemirstiba) {
                Main.spelePalaista = false;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                Main.tiritEkranu();
                System.out.println("Jus nomirat!\nNaves iemesls: " + spokaVeids + " spoks.");
            }
        }
    }

    void iespejaPadaritSpokuAktivu() { 
        if ((rand.nextInt(20) + 1) == 1) { // Ja 1/20-ā jeb 5/100-ās iespēja ir patiesa, tad spoks paliek aktīvs.
            spoksAktivs = true;
        }
    }

    static Spoki[] spokuInformacijasSavaksana(Spoki logaSpoks, Spoki durvjuSpoks, Spoki virtuvesSpoks) {
        Spoki[] visiSpoki = new Spoki[3];
        visiSpoki[0] = logaSpoks;
        visiSpoki[1] = durvjuSpoks;
        visiSpoki[2] = virtuvesSpoks;

        return visiSpoki;
    }

    static Spoki[] spokuStati = {
        new Spoki("loga"),
        new Spoki("durvju"),
        new Spoki("virtuves")
    };

    static void spokuInformacijasIzvade() {
        System.out.println();

        System.out.println("Loga spoks" + K.VIOLETS + " aktivs?: " + spokuStati[0].spoksAktivs + K.ZALS + " RAND cipars: " + spokuStati[0].randomKustibasIespejasCipars + K.ZILS + " Drosibas robezas: " + spokuStati[0].spokaDrosibasRobezas + " Fazes indekss: " + spokuStati[0].spokaFazesIndeks + " Istaba: " + spokuStati[0].spokaIstaba + K.RESET + "\033[0K");
        System.out.println("Durvju spoks" + K.VIOLETS + " aktivs?: " + spokuStati[1].spoksAktivs + K.ZALS + " RAND cipars: " + spokuStati[1].randomKustibasIespejasCipars + K.ZILS + " Drosibas robezas: " + spokuStati[1].spokaDrosibasRobezas + " Fazes indekss: " + spokuStati[1].spokaFazesIndeks + K.RESET + "\033[0K");
        System.out.println("Virtuves spoks" + K.VIOLETS + " aktivs?: " + spokuStati[2].spoksAktivs + K.ZALS + " RAND cipars: " + spokuStati[2].randomKustibasIespejasCipars + K.ZILS + " Drosibas robezas: " + spokuStati[2].spokaDrosibasRobezas + " Fazes indekss: " + spokuStati[2].spokaFazesIndeks + K.RESET + "\033[0K");
        
        System.out.println("Laiks ms: " + Laiks.spelesLaiks + " / " + Laiks.vienaStunda * 6 + K.RESET + "\033[0K");
    }
}