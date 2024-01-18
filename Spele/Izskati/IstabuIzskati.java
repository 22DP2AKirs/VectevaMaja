package Spele.Izskati;
import Spele.SpelesProcesi.Main;
import Spele.K;

public class IstabuIzskati {
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
        "/   |    |      " + SpokuIzskati.durvjuLogaSpokaFazesBilde[0] + "                          |   ",
        "    |    |      " + SpokuIzskati.durvjuLogaSpokaFazesBilde[1] + "                          |   ",
        "    |    |      " + SpokuIzskati.durvjuLogaSpokaFazesBilde[2] + "                          |   ",
        "    |    |      " + SpokuIzskati.durvjuLogaSpokaFazesBilde[3] + "                          |   ",
        "    | +  |      " + SpokuIzskati.durvjuLogaSpokaFazesBilde[4] + "                          |   ",
        "    |   /|      " + SpokuIzskati.durvjuLogaSpokaFazesBilde[5] + "                          |   ",
        "    |  / |      " + SpokuIzskati.durvjuLogaSpokaFazesBilde[6] + "                          |   ",
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

    
    

    public static String[] modificetasDurvjuLabasPusesBildesIzvade() {
        String[] durvisPrieksa= {
            "             |                                                   |              ",
            "             |                              __________________   |              ",
            "             |                        " + SpokuIzskati.durSpokaFazesBilde[0]+ " |              ",
            " /|          |                        " + SpokuIzskati.durSpokaFazesBilde[1]+ " |   |\\       __",
            "/ |          |                        " + SpokuIzskati.durSpokaFazesBilde[2]+ " |   | \\     /  ",
            "| |          |                        " + SpokuIzskati.durSpokaFazesBilde[3]+ " |   |  \\   /   ",
            "| |          |                        " + SpokuIzskati.durSpokaFazesBilde[4]+ " |   |\\| |  |   ",
            "| |          |                        " + SpokuIzskati.durSpokaFazesBilde[5]+ " |   |\\|/|  |   ",
            "| |          |___________________     " + SpokuIzskati.durSpokaFazesBilde[6]+ " |   | |/|  |   ",
            "| |         /                    \\    " + SpokuIzskati.durSpokaFazesBilde[7]+ " |    \\| |  |   ",
            "| |        /                      \\   " + SpokuIzskati.durSpokaFazesBilde[8]+ " |     \\ |  |   ",
            "| |       /________________________\\  " + SpokuIzskati.durSpokaFazesBilde[9]+ " |      \\|  |   ",
            "|_|        ||___________________||____" + SpokuIzskati.durSpokaFazesBilde[10]+ "_|          |   ",
            " /         |                     |    " + SpokuIzskati.durSpokaFazesBilde[11]+ "  \\         |   ",
            "/         /|                     |    " + SpokuIzskati.durSpokaFazesBilde[12]+ "   \\        |   ",
            "         /                            " + SpokuIzskati.durSpokaFazesBilde[13]+ "    \\       |   "
        };
        return durvisPrieksa;
    }

  public static String[] divanaKreisaPuse = {
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

  public static String[] divanaLeja = {
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
            

  public static String[] divanaLabaPuse = {
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
        "             |          " + SpokuIzskati.divanaLogaSpokaFazesBilde[0] + "           |              ",
        "             |          " + SpokuIzskati.divanaLogaSpokaFazesBilde[1] + "           |              ",
        "             |          " + SpokuIzskati.divanaLogaSpokaFazesBilde[2] + "           |              ",
        "             |          " + SpokuIzskati.divanaLogaSpokaFazesBilde[3] + "           |              ",
        "           __|          " + SpokuIzskati.divanaLogaSpokaFazesBilde[4] + "           | |            ",
        "          /   \\         " + SpokuIzskati.divanaLogaSpokaFazesBilde[5] + "           | |            ",
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

  public static String[] gultasLeja = {
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

  public static String[] gultasLabaPuse() {
        String[] elektriskaKaste = new String[9]; // Masīvs priekš elektriskās kastes bildes.

        if (Main.elektribaIeslegta) { // Ieslēgts.
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

  public static String[] gultasPrieksa = {
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
        "             |                        " + SpokuIzskati.gultasLogaSpokaFazesBilde[0] + " |              ", 
        "             |                        " + SpokuIzskati.gultasLogaSpokaFazesBilde[1] + " | |\\           " , 
        "             |                        " + SpokuIzskati.gultasLogaSpokaFazesBilde[2] + " | | \\          " , 
        "             |_                       " + SpokuIzskati.gultasLogaSpokaFazesBilde[3] + " | |  \\         " , 
        "             ( )                      " + SpokuIzskati.gultasLogaSpokaFazesBilde[4] + " | ||\\_|        " , 
        "         ____| |                      " + SpokuIzskati.gultasLogaSpokaFazesBilde[5] + " | |\\ /|        " , 
        "    _   /    | |                   _  " + SpokuIzskati.gultasLogaSpokaFazesBilde[6] + " | | | |        " , 
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

  public static String[] virtuvesPrieksa = {
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

  public static String[] virtuvesKreisaPuse = { 
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
    public static String[] izslegtsPagrabsVirtuveKreisa = { // Tumš pagrabs.
        "   |  /" + K.TPELEKS + "░░░░░░" + K.RESET + "\\",
        "   | |" + K.TPELEKS + "░░░░░░░░" + K.RESET + "\\",
        "   | |" + K.TPELEKS + "░░░░░░░░░" + K.RESET,
        K.TPELEKS + "░░░░░░░░░" + K.RESET,
        K.TPELEKS + "░░░░░░░░░" + K.RESET,
        K.TPELEKS + "░░░░░░░" + K.RESET,
        K.TPELEKS + "░░░░░" + K.RESET,
        "", // Lai strādātu pārveidojumi.
    };

    public static String[] ieslegtsPagrabsVirtuveKreisa = { // Gaiš pagrabs.
        "   |  /      \\",
        "   | |        \\",
        "   | |         ",
        "         ",
        "___      ",
        " \\ __  ",
        "\\  \\ ",
        "   \\  \\"
    };

    public static String[] modificetasVirtLabasPusesIzvade() {
        String[] virtKreisaPusesPagrabaSkats = new String[7];
        // Nosaka, kā izskatīsies pagraba skats.
        if (Main.pagrabaGaisma) {
            virtKreisaPusesPagrabaSkats = ieslegtsPagrabsVirtuveKreisa;
        } else {
            virtKreisaPusesPagrabaSkats = izslegtsPagrabsVirtuveKreisa;
            if (!Main.istabuGaismasIeslegtas[3]) { // Salabo krāsu, kad ir izslēgta gaisma.
                virtKreisaPusesPagrabaSkats[3] += K.TPELEKS;
                virtKreisaPusesPagrabaSkats[4] += K.TPELEKS;
                virtKreisaPusesPagrabaSkats[5] += K.TPELEKS;
                virtKreisaPusesPagrabaSkats[6] += K.TPELEKS;
            }
            else {
                virtKreisaPusesPagrabaSkats[3] += K.RESET;
                virtKreisaPusesPagrabaSkats[4] += K.RESET;
                virtKreisaPusesPagrabaSkats[5] += K.RESET;
                virtKreisaPusesPagrabaSkats[6] += K.RESET;
            }
        }

        // Modificētā, galējā bilde.
        String[] virtuveKreisa = {
            "           /              /|                                     |              ",
            "          /              / |                                     |              ",
            "         /______________/  |      ___________________________    |   ______     ",
            "    __   | ____   ____ |   |     " + SpokuIzskati.virtuvesLogaSpokaFazesBilde[0] + virtKreisaPusesPagrabaSkats[0] + "    ",
            "   /  \\  ||    | |    ||   |     " + SpokuIzskati.virtuvesLogaSpokaFazesBilde[1] + virtKreisaPusesPagrabaSkats[1] + "   ",
            "  /   |  ||    | |    ||   |     " + SpokuIzskati.virtuvesLogaSpokaFazesBilde[2] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            " /    |  ||    | |    ||   |     " + SpokuIzskati.virtuvesLogaSpokaFazesBilde[3] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "/     |  ||    | |    ||   ||    " + SpokuIzskati.virtuvesLogaSpokaFazesBilde[4] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "      |  ||    | |    ||   /|    " + SpokuIzskati.virtuvesLogaSpokaFazesBilde[5] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "      |  || ( )| |( ) || |/||    |/_________________________\\|   | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "      |  ||    | |    || | ||                                    | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "      |  ||    | |    || | /|_____                               | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "      |  ||    | |    || |//     /_______________________________| |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "      |  ||    | |    || |/_____/|                                \\|" + virtKreisaPusesPagrabaSkats[4] + "|  ",
            "      |  ||____| |____|| |  |  | |                                    " + virtKreisaPusesPagrabaSkats[5] + "|  ",
            "      |  |             |/|     |                                        " + virtKreisaPusesPagrabaSkats[6] + "|  "
        };

        return virtuveKreisa; // Atgriež tikko izveidoto array jeb masīvu izvadei.
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

    
    

    
    public static String[] modificetasVirtLejasBildesIzvade() {
        String[] virtuvePrieksa = {
                "   |    __.-------.__                                       |  |       |       |",
                "   | .--" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[0] + "--.                                    |  |    ( )|( )    |",
                "  .| |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[1] + "|  _                                 |  |_______|_______|",
                " /|| |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[2] + "| |=|                                |  |_______________|",
                "/ || |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[3] + "| |_|                                |  |       |       |",
                "| || |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[4] + "|                                    |  |       |       |",
                "| || |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[5] + "|          |==^                      |  |       |       |",
                "| || |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[6] + "|________V__||__V____________________|  |       |       |",
                "|_|| |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[7] + "|\\ ---O |        \\      \\  {+}   {+}  \\ |       |       |",
                " / | |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[8] + "| \\_____\\________/_______\\_____________\\|    ( )|( )    |",
                "/  | |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[9] + "| |  _______    _______  |==(+)====(-)==|       |       |",
                "   | |" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[10] + "| | |       |  |       | | |          | |       |       |",
                "   |_|" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[11] + "| | |    ( )|  |( )    | | |          | |       |       |",
                "  /                    \\ | |_______|  |_______| | |__________| |_______|_______|",
                " /                      \\|______________________|______________|_______________|",
                "/                                                                               "
            };

        return virtuvePrieksa;
    }

   
    public static String[] [][] istabuMasivaAtjaunosana() {

        String[] [][] istabaUnVirziens = { // {Priekša, LabāPuse, Leja, KreisāPuse} // Istabas virzieni.
        {gultasPrieksa, gultasLabaPuse(), gultasLeja, modificetasGultasKreisasPusesIzvade()}, // Gultas istaba [x][].
        {modificetaDivanaPrieksasBildesIzvade(), divanaLabaPuse, divanaLeja, divanaKreisaPuse}, // Dīvāna istaba [x][].
        {modificetaDurvjuPrieksasBildesIzvade(), modificetasDurvjuLabasPusesBildesIzvade(), durvjuLeja, durvjuKreisaPuse}, // Durvju istaba [x][].
        {virtuvesPrieksa, modificetasVirtLabasPusesIzvade(),  modificetasVirtLejasBildesIzvade(), virtuvesKreisaPuse} // Virtuves istaba.
        }; 
        
        return istabaUnVirziens;
    }
}
