import java.util.Arrays;

public class Istabu_Izskati {
    // Durju istabas parastie skati jeb stāvokļi.
    public static String[] durvjuLeja = {
        "   |                                                   | \\                   \\  ",
        " . |              ________________                     |  \\___________________\\ ",
        "/| |   _______   /                \\            |       |  |           | | | | | ",
        " | |  |       |  |                |           \\|/      |  |___________| |f|_| | ",
        " | |  |   |   |  |                |   _        |       |  |____________\\|_|__\\| ",
        " | |  |  \\|/  |  |                |  |=|       |       |  || | | | |        | | ",
        " | |  |  \\|/  |  |                |  |_|       |       |  || |e|a|d|________| | ",
        " | |  |  \\|/  |  |                |            |       |  |_\\|_|_|_|_________\\| ",
        " | |  |___|___|  |                |            |       |  |          | | | || | ",
        " | |             |                |            |       |  |__________| |y|u|| | ",
        " | |             |                |            |       |  |___________\\|_|_|_\\| ",
        " | |             |                |           /|\\      |  | | | |           | | ",
        " | |_____________|                |__________/_|_\\_____|  |_| |p|___________| | ",
        " |/                                         /  |  \\     \\ |__\\|_|____________\\| ",
        " /                                             |         \\|___________________| ",
        "/                                                                              \\"
        };

    public static String[] durvjuKreisaPuse = {
        "         /     /|     ___.----.___            |  \\_____________\\ |              ",
        "        /     / |  .--            --.         |  |      |      | |              ",
        "       /     /__|  |                |         |  |      |      | |    .         ",
        "      /     /| /|  |                |         |  |      |      | |    |\\        ",
        "     /     /||/ |  |                |         |  |      |      | |    | \\       ",
        "    /     / |/__|  |                |         |  |      |      | |    | |\\      ",
        "   /     /  /  /|  |                |         |  |   +  |  +   | |    | | \\     ",
        "  /     /  /  / |  |                |         |  |      |      | |    | |. \\    ",
        " /     /  /| /|_|  |                |         |  |______|______| |    | |   \\   ",
        "/_____/  /||/||/|  |                |         |  |           | | |    | | /  \\  ",
        "|     | /||/||/ |  |                |  .---.  |  |           | | |    |_|   \\ \\ ",
        "|     |/||/ |/__|  |                |  \\___/  |  |___________| | |    \\  \\ .   \\",
        "|     | |/  /  /|__|                |__|_|_|__|  |____________\\|_|     \\  \\ /   ",
        "|     | /  /  //                       | | |   \\ |             |  \\     \\  \\ .  ",
        "|     |/  /| //                          |      \\|_____________|   \\     \\  \\   ",
        "|     |  /||//                                                      \\     \\  \\  "
        };

    public static String[] modificetaDurvjuPrieksasBildesIzvade() {
        String[] durKreisaPuse = {
        " /  |    |       ________________________________                           |   ",
        "/   |    |      " + durvjuLogaSpokaFazesBilde[0] + "                          |   ",
        "    |    |      " + durvjuLogaSpokaFazesBilde[1] + "                          |   ",
        "    |    |      " + durvjuLogaSpokaFazesBilde[2] + "                          |   ",
        "    |    |      " + durvjuLogaSpokaFazesBilde[3] + "                          |   ",
        "    | +  |      " + durvjuLogaSpokaFazesBilde[4] + "                          |   ",
        "    |   /|      " + durvjuLogaSpokaFazesBilde[5] + "                          |   ",
        "    |  / |      " + durvjuLogaSpokaFazesBilde[6] + "                          |   ",
        "  + | /  |      |/______________________________\\|               ___________|   ",
        "    |/   |                                                       \\           \\  ",
        "    /____|                                                        \\           \\ ",
        "   /    /|                                                        |\\           \\", 
        "  /    / |________________________________________________________|_\\           ",
        " /    /  |                                                           \\          ",
        "/    /  /                                                             \\         ",
        "    /  /                                                               \\        "};
        return durKreisaPuse;
    }

    
    public static String[] durSpokaFazesBilde = Spoku_Izskati.durvisCiet;

    public static String[] modificetasDurvjuLabasPusesBildesIzvade() {
        String[] durvisPrieksa= {
            "             |                                                   |              ",
            "             |                              __________________   |              ",
            "             |                        " + durSpokaFazesBilde[0]+ " |              ",
            " /|          |                        " + durSpokaFazesBilde[1]+ " |   |\\       __",
            "/ |          |                        " + durSpokaFazesBilde[2]+ " |   | \\     /  ",
            "| |          |                        " + durSpokaFazesBilde[3]+ " |   |  \\   /   ",
            "| |          |                        " + durSpokaFazesBilde[4]+ " |   |\\| |  |   ",
            "| |          |                        " + durSpokaFazesBilde[5]+ " |   |\\|/|  |   ",
            "| |          |___________________     " + durSpokaFazesBilde[6]+ " |   | |/|  |   ",
            "| |         /                    \\    " + durSpokaFazesBilde[7]+ " |    \\| |  |   ",
            "| |        /                      \\   " + durSpokaFazesBilde[8]+ " |     \\ |  |   ",
            "| |       /________________________\\  " + durSpokaFazesBilde[9]+ " |      \\|  |   ",
            "|_|        ||___________________||____" + durSpokaFazesBilde[10]+ "_|          |   ",
            " /         |                     |    " + durSpokaFazesBilde[11]+ "  \\         |   ",
            "/         /|                     |    " + durSpokaFazesBilde[12]+ "   \\        |   ",
            "         /                            " + durSpokaFazesBilde[13]+ "    \\       |   "
        };
        return durvisPrieksa;
    }

    static String[] divanaKreisaPuse = {
            "   |                                                                        |   " ,
            "   |                                                                        |   " ,
            "   |                                                                        |   " ,
            "   |                    ___                                                 |   " ,
            "   |                   |<=]|                                                |   " ,
            "   |                   | | |             _________________________________  |   " ,
            "   |             _     |===|            /       \\                 /       \\ |   " ,
            "   |         _  / \\    | | |            |_   x   |       x       |   x   _| |   " ,
            "   |        /\\\\/ //    |___|           /  \\      |               |      /  \\|   " ,
            "   |        \\ /  /                    /_  /______|_______________|______\\  _\\   " ,
            "   |         // /                    |  \\/______/_________________\\______\\/  |  " ,
            "   |        /  / \\                   |  |      |                   |      |  |  " ,
            "   |_______/  /\\\\ \\__________________|  |      |                   |      |  |  ",
            "  /    ___// /__\\ \\\\____             |_______________________________________|  ",
            " /     \\__\\_/____\\  \\___\\                                                     \\ ",
            "/                 \\_/                                                          \\"};

    static String[] divanaLeja = {
            "             |       ________________               _______      |              ",
            "             |      /                \\             /   |   \\     |              ",
            "    ______   |      |                |            |    |    |    |              ",
            "   /      |  |      |                |            |    O--  |    |              ",
            "  /       |  |      |                |            |         |    |              ",
            " /        |  |      |                |             \\_______/     |              ",
            "/         |  |      |                |                           |           |\\ ",
            "          |  |      |                |                           |           | \\",
            "          |  |      |                |                           |           |  ",
            "          |  |      |                |                           |   /\\      |/\\",
            "          |  |      |                |  _______________          |  /  \\     |\\ ",
            "          |  |      |                | /___/_____/___/ |         | /   /     | |",
            "          |  |______|                |_|   $     $   | |_________|/   /      | |",
            "          | /                          |   |     |   | |   ____  /   /        \\ ",
            "          |/                           |_____________|/    \\   \\/   /          \\",
            "                                                            \\  /   /\\           "};
            

    static String[] divanaLabaPuse = {
            "   |                                                                        |   ",
            "   |                                                    ___.---.___         |   ",
            "   |         \\        /                             .---           ---.     |   ",
            "   |          \\      /                              |                 |     |   ",
            "   |        ___\\____/____                       _   |                 |     |   ",
            "   |       /___________ /|                     |=|  |                 |     |   ",
            "   |      |.--------.| | |               _     |_|  |                 |     |   ",
            "   |      ||        ||+| |               U          |                 |     |   ",
            "   |______||________||-| |____           |          |                 |     |   ",
            "   /      |__________|_|/     /|         |          |                 |     |   ",
            "  /__________________________/ |         |          |                 |     |   ",
            "  |       |         |        | |         |_         |                 |     |   ",
            "  |  O    |    O    |    O   | |_______ |--| _______|                 |_____|   ",
            "  |       |         |        | /        \\__/                                 \\  ",
            " /|_______|_________|________|/                                               \\ ",
            "/                                                                              \\"};

    

    public static String[] modificetaDivanaPrieksasBildesIzvade() {
        String[] divanaPrieksa = {
        "             |           ____________________________            |              ",
        "             |          " + divanaLogaSpokaFazesBilde[0] + "           |              ",
        "             |          " + divanaLogaSpokaFazesBilde[1] + "           |              ",
        "             |          " + divanaLogaSpokaFazesBilde[2] + "           |              ",
        "             |          " + divanaLogaSpokaFazesBilde[3] + "           |              ",
        "           __|          " + divanaLogaSpokaFazesBilde[4] + "           | |            ",
        "          /   \\         " + divanaLogaSpokaFazesBilde[5] + "           | |            ",
        "         /    |         |/__________________________\\|         __|_|_    /      ",
        "        /     |                                           ____|\\   | \\  /       ",
        "       /.  x  |                                          |\\   |.\\     \\/        ",
        "      /  \\    |________                                  | \\  ||\\\\    /\\        ",
        "     /   |   /         \\                                 | o\\ || .\\_____\\       ",
        "    /    |  /________  /_________________________________|  |\\ | ||     |       ",
        "   /  x  | /         \\/|                                 \\  | \\ \\||     |       ",
        "  / \\    |/________  /|/                                  \\ | o\\ ||     |       ",
        " /  |    /         \\/|/                                    \\|   \\ |     |       "};
        return divanaPrieksa;
    }

    static String[] gultasLeja = {
            "             |      _____                                        |              " ,
            "__           |     /     \\                                       |              " , 
            "  \\          |    |    .  |                                      |              " , 
            "   |         |    |  \\    |                                      |              " , 
            "   |         |    |       |                   _                 _|              " , 
            "   |         |    | .  /  |                  ( )      ___      ( )              " ,
            "   |         |     \\_____/                   | |___---   ---___| |              " , 
            "   |         |_____________________          | |               | |              " , 
            "   |        /                     /|         | |               | |              " , 
            "   |       /_____________________/ |         | |_______________| |              " , 
            "   |       | |       ( )       | | |         ||\\       _________\\|              " , 
            "   |       | |_________________| | |         || \\_____/          \\              ", 
            "   |       | |       ( )       | | |_________|| |\\                \\             ", 
            "   |       | |_________________| | |         ||\\| \\                \\            " , 
            "   |       |_____________________|/             \\  \\                \\           " , 
            "   |      /                                      \\  \\                \\          "};

    static String[] gultasLabaPuse() {
        String[] elektriskaKaste = new String[9]; // Masīvs priekš elektriskās kastes bildes.

        if (VaronaDarbibas.elektribaIeslegta) { // Ieslēgts.
            elektriskaKaste[0] = K.OBJEKTS + "_______" + K.RESET;
            elektriskaKaste[1] = K.OBJEKTS + "/       |" + K.RESET;
            elektriskaKaste[2] = K.OBJEKTS + "/|  =  ON|" + K.RESET;
            elektriskaKaste[3] = K.OBJEKTS + "| | _|_   |" + K.RESET;
            elektriskaKaste[4] = K.OBJEKTS + "| |       |" + K.RESET;
            elektriskaKaste[5] = K.OBJEKTS + "| |    OFF|" + K.RESET;
            elektriskaKaste[6] = K.OBJEKTS + "| |_______|" + K.RESET;
            elektriskaKaste[7] = K.OBJEKTS + "| /" + K.RESET;
            elektriskaKaste[8] = K.OBJEKTS + "|/" + K.RESET;
        } else { // Izslēgts.
            elektriskaKaste[7] = "   ";
            elektriskaKaste[8] = "  ";
        }

        String[] gultasLabaPuse = {
            "             |                       ________________            |              " , 
            "   _____     |         " + elektriskaKaste[0] + "      /                \\           |  __          " , 
            "  /     \\    |        " + elektriskaKaste[1] + "     |                |           | |  \\         " , 
            " /       |   |       " + elektriskaKaste[2] + "     |                |           | | / |        " , 
            "/        ||| |      " + elektriskaKaste[3] + "     |                |           | |   |        " , 
            "         ||| |      " + elektriskaKaste[4] + "     |                |           | |\\  |        " , 
            "         |   |      " + elektriskaKaste[5] + "     |                |           | |   |        " , 
            "         |   |      " + elektriskaKaste[6] + "     |                |     ______| | . |        " , 
            "         |   |      " + elektriskaKaste[7] + "             |                |    |\\     \\  \\__|        " , 
            "         |   |      " + elektriskaKaste[8] + "              |                |    | \\     \\             " , 
            "         |   |                      |                |    | O\\     \\            " , 
            "         |   |                      |                |    |\\  \\     \\           " , 
            "         |   |______________________|                |____| \\  \\_____\\          " , 
            "         |  /                                             | O\\ |     |          " , 
            "         | /                                              \\\\  \\|     |          " , 
            "         |/                                                \\\\  |     |          "
        };
        return gultasLabaPuse;
    }

    static String[] gultasPrieksa = {
            "       / |   |    ________                 ________________      |              " , 
            "      /| |   |   |        |               /                \\     |              " , 
            "     /|| |   |   | |\\/\\/\\ |               |                |     |              " , 
            "    / || |   |   | | \\  | |               |                |  _  |   /|\\        " , 
            "   /. || |   |   |  \\  /  |               |                | |=| |  / | \\       " , 
            "  /   || |   |   |   ||   |               |                | |_| | / /|  \\      " , 
            " / .  || |   |   |   ||   |               |                |     | |\\ |   \\     " , 
            "/|\\ / || |   |   |________|    _________  |                |     | | \\| | |     " , 
            "||    ||_|   |                |         | |                |     | |/ | | |     " , 
            "||/   |/ /   |                |_________| |                |     | |  |   |     " , 
            "||  \\ / /    |                |  _____  | |                |     | | / \\  |     " , 
            "||.  / / __  |                | |  |  | | |                |     | |/   \\ |     " ,
            "||  / / / /| |________________| | -O- | |_|                |_____|       \\|     " ,
            "|| / / /|/ |/                 | |__|__| |                         \\             " ,
            "||/ / / / //                  |_________|                          \\            " ,
            "|/ / /|/ /|                                                         \\           "};

    public static String[] modificetasGultasKreisasPusesIzvade() {
    String[] gultPrieksa = {   
        "             |                         ________________________  |              ",  
        "             |                        " + gultasLogaSpokaFazesBilde[0] + " |              ", 
        "             |                        " + gultasLogaSpokaFazesBilde[1] + " | |\\           " , 
        "             |                        " + gultasLogaSpokaFazesBilde[2] + " | | \\          " , 
        "             |_                       " + gultasLogaSpokaFazesBilde[3] + " | |  \\         " , 
        "             ( )                      " + gultasLogaSpokaFazesBilde[4] + " | ||\\_|        " , 
        "         ____| |                      " + gultasLogaSpokaFazesBilde[5] + " | |\\ /|        " , 
        "    _   /    | |                   _  " + gultasLogaSpokaFazesBilde[6] + " | | | |        " , 
        "   ( ) /     | |                  ( ) |/______________________\\| | | | |        " , 
        "   | |/      |_|__________________| | ^   _________________      |  \\  |        " , 
        "   | |      / /                   | |$|==|_|___|__|__|___|_|     |   \\ |        " , 
        "   | |    /  /              _   / | | |  |_________________|     |    \\|        " , 
        "   | |  /    |             ( )/   | |_|____|_____________|_______|              " , 
        "   | |/_____/______________| |    | |                             \\             " , 
        "   | |      |              | |  / |_|                              \\            " , 
        "   | |______|______________| |/                                     \\           "};
        return gultPrieksa;
    }

    static String[] virtuvesPrieksa = {
        "   |                 ______________                              ___________|   ",
        "   |               _/____/___/___  \\          ________________  |\\           \\  ",
        "   |              /              \\/|  _____  /                \\ |\\\\           \\ ",
        "   |              |              | | |PHONE| |                | ||\\\\ __________\\",
        "   |              |              | | |  _  | |                | |||\\|          |",
        "   |              |              | | | ( ) | |                | |||||          |",
        "   |              |            - | | |  |  | |                | |||||          |",
        "   |______________|            | | | | (_) | |                | |||||          |",
        "   /     O---     |            | | | |_____| |                | |||||          |",
        "  /    ___________|            - | |         |                | |||||  .    .  |",
        " /    /|       |  |              | |         |                | |||||  |____|  |",
        "/    / |       |  |              | |         |                | |||||  |    |  |",
        "--E /__|_______|__|              | |_________|                |_|\\|||  |____|  |",
        "   /.-.           |______________|/                              \\\\||  |____|  |",
        "  /'._.'                                                          \\\\|  \\     \\ |",
        " /   |                                                             \\|__|\\_____\\|"};

    static String[] virtuvesKreisaPuse = { 
        "    /        /  |   |  _________________                         |              ",
        "   /________/   |()/| /                 \\                        |              ",
        "   |        |   | //| |                 |                        |              ",
        "   |        | ()|// | |                 |  _                     |              ",
        "   |        |   //  | |                 | |=|                    |              ",
        "   |        |  //   | |                 | |_|                .---------.        ",
        "   |        | //|   | |                 |    ________________|\\         \\       ",
        "   |        |// |   | |                 |   /  |             | \\         \\      ",
        "   |        |/  |   | |                 |  /___H_____________|  '--------.\\     ",
        "   |        |   |   | |                 |   |     .-.        |  |         |     ",
        "   |        |   |() | |                 |   |    '._.'       |  |         |     ",
        "   |______  |   |   | |                 |   |      |         |  |         |  .  ",
        "  /      /| | ()|   |_|                 |___|_____/|\\________|  |         |  |\\ ",
        " /  {}  //| |   |  //                            / | \\       |  |         |  |~\\",
        "/      /O | |   | //                               |         | \\|         |  | ~",
        "  {}  //| | |   |//                                          | ||         |  |()"
    };
    
    // Virtuves durvju izskati.
    static String[] izslegtsPagrabsVirtuveKreisa = { // Tumš pagrabs.
        "   |  /░░░░░░\\",
        "   | |░░░░░░░░\\",
        "   | |░░░░░░░░░",
        "░░░░░░░░░",
        "░░░░░░░░░",
        "░░░░░░░",
        "░░░░░",
        "", // Lai strādātu pārveidojumi.
    };

    static String[] ieslegtsPagrabsVirtuveKreisa = { // Gaiš pagrabs.
        "   |  /      \\",
        "   | |        \\",
        "   | |",
        "",
        "___",
        " \\ __",
        "\\  \\",
        "   \\  \\"
    };

    private static String[] virtKreisaPusesPagrabaSkats = new String[7];
    public static void virtKreisasPusesPagrabs() {
        if (Main.pagrabaGaismaON) {
            virtKreisaPusesPagrabaSkats = ieslegtsPagrabsVirtuveKreisa;
        } else {
            virtKreisaPusesPagrabaSkats = izslegtsPagrabsVirtuveKreisa;
        }
    }   

    public static String[] modificetasVirtLabasPusesIzvade() {
        // Modificētā, galējā bilde.
        String[] virtuveKreisa = {
            "           /              /|                                     |              ",
            "          /              / |                                     |              ",
            "         /______________/  |      ___________________________    |   ______     ",
            "    __   | ____   ____ |   |     " + virtuvesLogaSpokaFazesBilde[0] + virtKreisaPusesPagrabaSkats[0] + "    ",
            "   /  \\  ||    | |    ||   |     " + virtuvesLogaSpokaFazesBilde[1] + virtKreisaPusesPagrabaSkats[1] + "   ",
            "  /   |  ||    | |    ||   |     " + virtuvesLogaSpokaFazesBilde[2] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            " /    |  ||    | |    ||   |     " + virtuvesLogaSpokaFazesBilde[3] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "/     |  ||    | |    ||   ||    " + virtuvesLogaSpokaFazesBilde[4] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "      |  ||    | |    ||   /|    " + virtuvesLogaSpokaFazesBilde[5] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "      |  || ( )| |( ) || |/||    |/_________________________\\|   | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "      |  ||    | |    || | ||                                    | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "      |  ||    | |    || | /|_____                               | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "      |  ||    | |    || |//     /_______________________________| |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "      |  ||    | |    || |/_____/|                                \\|" + virtKreisaPusesPagrabaSkats[4] + "|  ",
            "      |  ||____| |____|| |  |  | |                                    " + virtKreisaPusesPagrabaSkats[5] + "|  ",
            "      |  |             |/|     |                                        " + virtKreisaPusesPagrabaSkats[6] + "|  "};
        return virtuveKreisa; // Atgriež tikko izveidoto array jeb masīvu izvadei.
    }
    
    // Sagatavo virtuves kreiso pusi izvadei.
    public static void virtuvesPagrabaGaismasStavoklaNoteiksana() {
        virtKreisasPusesPagrabs(); // Sagatavo pagraba skatu.
    }

    // ------------------------------------------------------------------------------ Gultas loga spoks ------------------------------------------------------------------------ //
    // " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0" , 
    // " 1             |                         ________________________  |",  
    // " 2             |                        | ||  .      ||.       | | |", 
    // " 3             |                        | ||       \ ||    \   | | | |\\" , 
    // " 4             |                        | ||   /  .  ||\     . | | | | \\" , 
    // " 5             |_                       | ||  .      ||.       | | | |  \\" , 
    // " 6             ( )                      | ||     .   ||   /    | | | ||\\_|" , 
    // " 7         ____| |                      | || /       ||      . | | | |\\ /|" , 
    // " 8    _   /    | |                   _  | ||_________||________| | | | | |" , 
    // " 9   ( ) /     | |                  ( ) |/______________________\\ | | | | |" , 
    // "10   | |/      |_|__________________| | ^   _________________      |  \\  |" , 
    // "11   | |      / /                   | |$|==|_|___|__|__|___|_|     |   \\ |" , 
    // "12   | |    /  /              _   / | | |  |_________________|     |    \\|" , 
    // "13   | |  /    |             ( )/   | |_|____|_____________|_______|" , 
    // "14   | |/_____/______________| |    | |                             \\" , 
    // "15   | |      |              | |  / |_|                              \\" , 
    // "16   | |______|______________| |/                                     \\"};  

    

    // ------------------------------------------------------------------------------ Dīvāna loga spoks --------------------------------------------------------------------- //

    // " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0  ",
    // " 1             |           ____________________________            |  ",
    // " 2             |          | | .  \        .     /   || |           |  ",
    // " 3             |          | |    .     .   /        || |           |  ",
    // " 4             |          | |    \         .  /  /  || |           |  ",
    // " 5             |          | |     .               . || |           |  ",
    // " 6           __|          | |. /     /        .  \  || |           | |  ",
    // " 7          /   \         | |_______________________|| |           | |  ",
    // " 8         /    |         |/__________________________\|         __|_|_    /  ",
    // " 9        /     |                                           ____|\\   | \\  /  ",
    // "10       /.  x  |                                          |\\   |.\\     \\/  ",
    // "11      /  \\    |________                                  | \\  ||\\\\    /\\  ",
    // "12     /   |   /         \\                                 | o\\ || .\\_____\\  ",
    // "13    /    |  /________  /_________________________________|  |\\ | ||     |  ",
    // "14   /  x  | /         \\/|                                 \\  | \\ \\||     |  ",
    // "15  / \\    |/________  /|/                                  \\ | o\\ ||     |  ",
    // "16 /  |    /         \\/|/                                    \\|   \\ |     |"};

    // ----------------------------------------------------------------------------- Durvju loga spoks ------------------------------------------------------------------------ //

    // public static String[] durvisKreisa = {
    //     " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0  ",
    //     " 1 /  |    |       ________________________________                           |  ",
    //     " 2/   |    |      | |       /            \\     || |                          |  ",
    //     " 3    |    |      | |          |                || |                          |  ",
    //     " 4    |    |      | |   \\           |          || |                          |  ",
    //     " 5    |    |      | |          \         /      || |                          |  ",
    //     " 6    | +  |      | |                      /    || |                          |  ",
    //     " 7    |   /|      | |     /           \         || |                          |  ",
    //     " 8    |  / |      | |___________________________|| |                          |  ",
    //     " 9  + | /  |      |/______________________________\|               ___________|  ",
    //     " 0    |/   |                                                       \\          \\  ",
    //     " 1    /____|                                                        \\          \\  ",
    //     " 2   /    /|                                                        |\\          \\  ",
    //     "13  /    / |________________________________________________________|_\\          \\  ",
    //     "14 /    /  |                                                           \\  ",
    //     "15/    /  /                                                             \\  ",
    //     "16    /  /                                                               \\"};

    static String[] virtuvesLogaSpokaFazesBilde = Spoku_Izskati.virtuvesLogsCiet; // Definē jauno array.
    static String[] divanaLogaSpokaFazesBilde = Spoku_Izskati.divanaLogsCiet; // Definē jauno array.
    static String[] gultasLogaSpokaFazesBilde = Spoku_Izskati.gultasLogsCiet; // Definē jauno array.
    static String[] durvjuLogaSpokaFazesBilde = Spoku_Izskati.durvjuLogsCiet; // Definē jauno array.

    public static String[] virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp0;
    public static String[] modificetasVirtLejasBildesIzvade() {
        String[] virtuvePrieksa = {
                "   |    __.-------.__                                       |  |       |       |",
                "   | .--" + virtPrieksasPagrabaBildesArSpoku[0] + "--.                                    |  |    ( )|( )    |",
                "  .| |" + virtPrieksasPagrabaBildesArSpoku[1] + "|  _                                 |  |_______|_______|",
                " /|| |" + virtPrieksasPagrabaBildesArSpoku[2] + "| |=|                                |  |_______________|",
                "/ || |" + virtPrieksasPagrabaBildesArSpoku[3] + "| |_|                                |  |       |       |",
                "| || |" + virtPrieksasPagrabaBildesArSpoku[4] + "|                                    |  |       |       |",
                "| || |" + virtPrieksasPagrabaBildesArSpoku[5] + "|          |==^                      |  |       |       |",
                "| || |" + virtPrieksasPagrabaBildesArSpoku[6] + "|________V__||__V____________________|  |       |       |",
                "|_|| |" + virtPrieksasPagrabaBildesArSpoku[7] + "|\\ ---O |        \\      \\  {+}   {+}  \\ |       |       |",
                " / | |" + virtPrieksasPagrabaBildesArSpoku[8] + "| \\_____\\________/_______\\_____________\\|    ( )|( )    |",
                "/  | |" + virtPrieksasPagrabaBildesArSpoku[9] + "| |  _______    _______  |==(+)====(-)==|       |       |",
                "   | |" + virtPrieksasPagrabaBildesArSpoku[10] + "| | |       |  |       | | |          | |       |       |",
                "   |_|" + virtPrieksasPagrabaBildesArSpoku[11] + "| | |    ( )|  |( )    | | |          | |       |       |",
                "  /                    \\ | |_______|  |_______| | |__________| |_______|_______|",
                " /                      \\|______________________|______________|_______________|",
                "/                                                                               "};
        return virtuvePrieksa;
    }
   
    static String[] [][] istabuMasivaAtjaunosana() {

        String[] [][] istabaUnVirziens = { // {Priekša, LabāPuse, Leja, KreisāPuse} // Istabas virzieni.
        {gultasPrieksa, gultasLabaPuse(), gultasLeja, modificetasGultasKreisasPusesIzvade()}, // Gultas istaba [x][].
        {modificetaDivanaPrieksasBildesIzvade(), divanaLabaPuse, divanaLeja, divanaKreisaPuse}, // Dīvāna istaba [x][].
        {modificetaDurvjuPrieksasBildesIzvade(), modificetasDurvjuLabasPusesBildesIzvade(), durvjuLeja, durvjuKreisaPuse}, // Durvju istaba [x][].
        {virtuvesPrieksa, modificetasVirtLabasPusesIzvade(),  modificetasVirtLejasBildesIzvade(), virtuvesKreisaPuse} // Virtuves istaba.
        }; 
        
        return istabaUnVirziens;
    }

    public static String[] aktualaIstabasIzskats = new String[16]; // 16, jo ir pirmā skaitļa līnija.

    public static String[] aktualasIstabasParrakstisana(String[] istaba) {
        return istaba;
    }

    static String[] istabasArParklajumiem(String[] nemainitaVaronaAktualaIstabas) {
        // Parametra masīva vērtību pārkopēšana un jauna masīva, lai nebojātu masīvu, kas ir sniegts kā parametrs.
        // mainita - drīkst mainīt, nemainītā - NEDRĪKST MAINĪT.
        String[] mainitaVaronaAktualaIstabasKopija = Arrays.copyOf(nemainitaVaronaAktualaIstabas, nemainitaVaronaAktualaIstabas.length); // Masīva elementu pārkopēšana.

        // Dažādie nosacījumi, lai noteiktu pareizo pārklājumu, pareizai situācijai.
        if (VaronaDarbibas.elektribaIeslegta && VaronaDarbibas.aizdedzinatsSerkocins){
            mainitaVaronaAktualaIstabasKopija = serkocinaPieliksanaPieBildes(mainitaVaronaAktualaIstabasKopija);
        }
        else if (!VaronaDarbibas.elektribaIeslegta && VaronaDarbibas.aizdedzinatsSerkocins) {
            mainitaVaronaAktualaIstabasKopija = tumsaIstabaArAizdedzinatuSerkocinu(mainitaVaronaAktualaIstabasKopija, nemainitaVaronaAktualaIstabas);
        }
        else if (!VaronaDarbibas.elektribaIeslegta && !VaronaDarbibas.aizdedzinatsSerkocins) { // Ja mājā ir izslēgta elektrība un sērkociņš ir neaizdedzināts.
            mainitaVaronaAktualaIstabasKopija = istabaArIzslegtuGaismu();
        }

        // Pārbauda katru istabu, un nosaka vai gaisma tanī būs izslēgta vai izslēgta ar sērkociņu.
        mainitaVaronaAktualaIstabasKopija = katrasIstabasParbaudeParGaismasStatusu(mainitaVaronaAktualaIstabasKopija, nemainitaVaronaAktualaIstabas);
        
        return mainitaVaronaAktualaIstabasKopija;
    }

    static String[] katrasIstabasParbaudeParGaismasStatusu(String[] mainamaisMasivs, String[] originalaisMasivs) {
        // Pārbauda katru istabu, un nosaka vai gaisma tanī būs izslēgta vai izslēgta ar sērkociņu.
        if (!Main.istabuGaismasIeslegtas[VaronaDarbibas.varonaIstabasSkaitlis] && !VaronaDarbibas.aizdedzinatsSerkocins) {
            mainamaisMasivs = istabaArIzslegtuGaismu();
        }
        else if (!Main.istabuGaismasIeslegtas[VaronaDarbibas.varonaIstabasSkaitlis] && VaronaDarbibas.aizdedzinatsSerkocins) {
            mainamaisMasivs = tumsaIstabaArAizdedzinatuSerkocinu(mainamaisMasivs, originalaisMasivs);
        }

        return mainamaisMasivs;
    }

    static String[] tumsaIstabaArAizdedzinatuSerkocinu(String[] apstradajamaisMasivs, String[] originalaisMasivs) {
        apstradajamaisMasivs = istabaArIzslegtuGaismu();
        apstradajamaisMasivs[8] = K.TPELEKS + originalaisMasivs[8] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[70G░░░░░░░░░░░░" + K.RESET;
        apstradajamaisMasivs[9] = K.TPELEKS + originalaisMasivs[9] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[73G░░░░░░░░░" + K.RESET;
        apstradajamaisMasivs[10] = K.TPELEKS + originalaisMasivs[10] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[76G░░░░░░" + K.RESET;
        apstradajamaisMasivs[11] = K.TPELEKS + originalaisMasivs[11] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[79G░░░" + K.RESET;
        apstradajamaisMasivs[12] = K.TPELEKS + originalaisMasivs[12] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
        apstradajamaisMasivs[13] = K.TPELEKS + originalaisMasivs[13] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
        apstradajamaisMasivs[14] = K.TPELEKS + originalaisMasivs[14] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
        apstradajamaisMasivs[15] = K.TPELEKS + originalaisMasivs[15] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;

        apstradajamaisMasivs = serkocinaPieliksanaPieBildes(apstradajamaisMasivs);
        return apstradajamaisMasivs;
    }

    static String[] serkocinaPieliksanaPieBildes(String[] apstradajamaisMasivs) {
        apstradajamaisMasivs[11] += serkocinaIzskats[0];
        apstradajamaisMasivs[12] += serkocinaIzskats[1];
        apstradajamaisMasivs[13] += serkocinaIzskats[2];
        apstradajamaisMasivs[14] += serkocinaIzskats[3];
        apstradajamaisMasivs[15] += serkocinaIzskats[4];

        return apstradajamaisMasivs;
    }

    static String[] serkocinaIzskats = {
        // Ja apstrādāto līniju pārdefinē ar sērkociņu, tad pārdefinētā līnija neatjaunosies iepriekšējā ciklā "Iegūst neapstrādāto bildi". Būs statiska bilde ar sērkociņu klāt un nodzēstu galu.
        // Ja apstrādātai līnijai pieliks klāt sērkociņu, tad pārveidotā līnija tiks atjaunot, bet būs ar nodzēstu galu.
        // \r nepalīdz atstāt galu.
        // Pieliekot RESET vai krāsas maiņu arī nepalīdz.

        // !!!!!!!!! Pieliekot beigās ANSI \033[#G kodu (Pārvietot rakstīšanas kursoru uz # kolonnu) ar # esot visa teksta līnijas beigas (arī aiz sērkociņa) nenodzēsa tālākos tekstu. !!!!!!!!!
        // "\033[82G"

        "\033[61G" + K.DZELTENS + "/\\_" + K.RESET + "\033[82G",
        "\033[60G"+ K.ORANZS + "/   \\" + K.RESET + "\033[82G",
        "\033[60G" + K.SARKANS + "| O  |" + K.RESET + "\033[82G",
        "\033[61G" + K.SARKANS + "'-\\'" + K.RESET + "\033[82G",
        "\033[64G" + K.BRUNS + "\\" + K.RESET + "\033[82G"
    };

    static String[] istabaArIzslegtuGaismu() {
        String[] masivs = new String[K.BILDES_MASIVA_IZMERS];
        Arrays.fill(masivs, K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET); // Aizpilda visus masīva indeksus ar vienu un to pašu elementu.
        
        return masivs;
    }
}
