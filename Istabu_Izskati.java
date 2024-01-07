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
        "/   |    |      " + durLogaSpokaFazesBilde[0] + "                          |   ",
        "    |    |      " + durLogaSpokaFazesBilde[1] + "                          |   ",
        "    |    |      " + durLogaSpokaFazesBilde[2] + "                          |   ",
        "    |    |      " + durLogaSpokaFazesBilde[3] + "                          |   ",
        "    | +  |      " + durLogaSpokaFazesBilde[4] + "                          |   ",
        "    |   /|      " + durLogaSpokaFazesBilde[5] + "                          |   ",
        "    |  / |      " + durLogaSpokaFazesBilde[6] + "                          |   ",
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

    public static void noteiktDurIstabasSpokaFazesSkatu() {
        // Skatoties uz loga spoka fāzes indeksu nosaka kādu bildi izvadīs.
        if (Spoki.logaSpokaFazesIndeks == -1) {
            durLogaSpokaFazesBilde = Spoku_Izskati.durvjuLogsCiet;
        } else if (Spoki.logaSpokaFazesIndeks == 0) {
            durLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDurvim0; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 1) {
            durLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDurvim1; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 2) {
            durLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDurvim2; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 3) {
            durLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDurvim3; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 4) {
            durLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDurvim4; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 5) {
            durLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDurvim5; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 6) {
            durLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDurvim6; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 7) {
            durLogaSpokaFazesBilde = Spoku_Izskati.durvjuLogsVala; // Nomaina visas jaunā array vērtības.
        } 
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
    
    public static void noteiktDurSpokaFazesSkatu() {
        // Skatoties uz loga spoka fāzes indeksu nosaka kādu bildi izvadīs.
        if (Spoki.durSpokaFazesIndeks == -1) {
            durSpokaFazesBilde = Spoku_Izskati.durvisCiet;
        } else if (Spoki.durSpokaFazesIndeks == 0) {
            durSpokaFazesBilde = Spoku_Izskati.durvjuSp0; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.durSpokaFazesIndeks == 1) {
            durSpokaFazesBilde = Spoku_Izskati.durvjuSp1; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.durSpokaFazesIndeks == 2) {
            durSpokaFazesBilde = Spoku_Izskati.durvjuSp2; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.durSpokaFazesIndeks == 3) {
            durSpokaFazesBilde = Spoku_Izskati.durvjuSp3; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.durSpokaFazesIndeks == 4) {
            durSpokaFazesBilde = Spoku_Izskati.durvjuSp4; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.durSpokaFazesIndeks == 5) {
            durSpokaFazesBilde = Spoku_Izskati.durvjuSp5; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.durSpokaFazesIndeks == 6) {
            durSpokaFazesBilde = Spoku_Izskati.durvjuSp6; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.durSpokaFazesIndeks == 7) {
            durSpokaFazesBilde = Spoku_Izskati.durvjuSp7; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.durSpokaFazesIndeks == 8) {
            durSpokaFazesBilde = Spoku_Izskati.durvisVala; // Nomaina visas jaunā array vērtības.
        } 
    }
    // -------------------------------------------------------------- 2 Dimensiju masīva darbības paraugs -------------------------------------------------------------------------------- //
    // // [rinda][kolonna]
    // String [][] tests = {
    //     // Kolonnas V  V  V
    //     {"veikals", "Parks", "Maja"}, // Rinda 1.
    //     {"Ola", "Maize", "Nazis"}}; // Rinda 2.
    
    // // System.out.println(vieta[1][2]); // Nazis
    // -------------------------------------------------------------- 2 Dimensiju masīva darbības paraugs -------------------------------------------------------------------------------- //

    // public static String[] durvisKreisa = {
    //     "| 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0|",
    //     "| 1 /  |    |       ________________________________                           |  |",
    //     "| 2/   |    |      | |       /            \\\\     || |                          |  |",
    //     "| 3    |    |      | |          |                || |                          |  |",
    //     "| 4    |    |      | |   \\\\           |          || |                          |  |",
    //     "| 5    |    |      | |          \\         /      || |                          |  |",
    //     "| 6    | +  |      | |                      /    || |                          |  |",
    //     "| 7    |   /|      | |     /           \\         || |                          |  |",
    //     "| 8    |  / |      | |___________________________|| |                          |  |",
    //     "| 9  + | /  |      |/______________________________\\|               ___________|  |",
    //     "|10    |/   |                                                       \\          \\  |",
    //     "|11    /____|                                                        \\          \\  |",
    //     "|12   /    /|                                                        |\\          \\  |",
    //     "|13  /    / |________________________________________________________|_\\          \\  |",
    //     "|14 /    /  |                                                           \\         |",
    //     "|15/    /  /                                                             \\         |",
    //     "|16    /  /                                                               \\        |"
    // };

    // ------------------------------------------------------ Dīvāna istaba ar logu.
    // static String[] divanaPrieksa = {
    //         " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
    //         " 1             |           ____________________________            |  ",
    //         " 2             |          | | .  \\        .     /   || |           |  ",
    //         " 3             |          | |    .     .   /        || |           |  ",
    //         " 4             |          | |    \\         .  /  /  || |           |  ",
    //         " 5             |          | |     .               . || |           |  ",
    //         " 6           __|          | |. /     /        . \\\\  || |           | |  ",
    //         " 7          /   \\         | |_______________________|| |           | |  ",
    //         " 8         /    |         |/__________________________\\|         __|_|_    /  ",
    //         " 9        /     |                                           ____|\\   | \\  /  ",
    //         "10       /.  x  |                                          |\\   |.\\     \\/  ",
    //         "11      /  \\    |________                                  | \\  ||\\\\    /\\  ",
    //         "12     /   |   /         \\                                 | o\\ || .\\_____\\  ",
    //         "13    /    |  /________  /_________________________________|  |\\ | ||     |  ",
    //         "14   /  x  | /         \\/|                                 \\  | \\ \\||     |  ",
    //         "15  / \\    |/________  /|/                                  \\ | o\\ ||     |  ",
    //         "16 /  |    /         \\/|/                                    \\|   \\ |     |"};

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

    public static void noteiktDivanaSpokaFazesSkatu() {
        // Skatoties uz loga spoka fāzes indeksu nosaka kādu bildi izvadīs.
        if (Spoki.logaSpokaFazesIndeks == -1) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.divanaLogsCiet;
        } else if (Spoki.logaSpokaFazesIndeks == 0) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDivana0; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 1) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDivana1; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 2) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDivana2; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 3) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDivana3; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 4) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDivana4; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 5) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDivana5; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 6) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieDivana6; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 7) {
            divanaLogaSpokaFazesBilde = Spoku_Izskati.divanaLogsVala; // Nomaina visas jaunā array vērtības.
        } 
    }

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

    // Gultas istaba.
    // static String[] gultasPrieksa = {
    //         " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0" , 
    //         " 1             |                         ________________________  |",  
    //         " 2             |                        | ||  .      ||.       | | |", 
    //         " 3             |                        | ||       \\ ||    \\   | | | |\\" , 
    //         " 4             |                        | ||   /  .  ||\\     . | | | | \\" , 
    //         " 5             |_                       | ||  .      ||.       | | | |  \\" , 
    //         " 6             ( )                      | ||     .   ||   /    | | | ||\\_|" , 
    //         " 7         ____| |                      | || /       ||      . | | | |\\ /|" , 
    //         " 8    _   /    | |                   _  | ||_________||________| | | | | |" , 
    //         " 9   ( ) /     | |                  ( ) |/______________________\\| | | | |" , 
    //         "10   | |/      |_|__________________| | ^   _________________      |  \\  |" , 
    //         "11   | |      / /                   | |$|==|_|___|__|__|___|_|     |   \\ |" , 
    //         "12   | |    /  /              _   / | | |  |_________________|     |    \\|" , 
    //         "13   | |  /    |             ( )/   | |_|____|_____________|_______|" , 
    //         "14   | |/_____/______________| |    | |                             \\" , 
    //         "15   | |      |              | |  / |_|                              \\" , 
    //         "16   | |______|______________| |/                                     \\"};

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

    static String[] gultasLabaPuse = {
            "             |                       ________________            |              " , 
            "   _____     |         _______      /                \\           |  __          " , 
            "  /     \\    |        /       |     |                |           | |  \\         " , 
            " /       |   |       /|  =  ON|     |                |           | | / |        " , 
            "/        ||| |      | | _|_   |     |                |           | |   |        " , 
            "         ||| |      | |       |     |                |           | |\\  |        " , 
            "         |   |      | |    OFF|     |                |           | |   |        " , 
            "         |   |      | |_______|     |                |     ______| | . |        " , 
            "         |   |      | /             |                |    |\\     \\  \\__|        " , 
            "         |   |      |/              |                |    | \\     \\             " , 
            "         |   |                      |                |    | O\\     \\            " , 
            "         |   |                      |                |    |\\  \\     \\           " , 
            "         |   |______________________|                |____| \\  \\_____\\          " , 
            "         |  /                                             | O\\ |     |          " , 
            "         | /                                              \\\\  \\|     |          " , 
            "         |/                                                \\\\  |     |          "};

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
        "             |                        " + gultLogaSpokaFazesBilde[0] + " |              ", 
        "             |                        " + gultLogaSpokaFazesBilde[1] + " | |\\           " , 
        "             |                        " + gultLogaSpokaFazesBilde[2] + " | | \\          " , 
        "             |_                       " + gultLogaSpokaFazesBilde[3] + " | |  \\         " , 
        "             ( )                      " + gultLogaSpokaFazesBilde[4] + " | ||\\_|        " , 
        "         ____| |                      " + gultLogaSpokaFazesBilde[5] + " | |\\ /|        " , 
        "    _   /    | |                   _  " + gultLogaSpokaFazesBilde[6] + " | | | |        " , 
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

    // Virtuve.
    // static String[] virtuvePrieksa = { 
    //    " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3",
    //    " 1    |      __.-------.__                                      |      |      |        ",
    //    " 2    |   .--             --.                                   |   ( )|( )   |    __  ",
    //    " 3/|  |   |                 |   _                               |______|______|   /  \\ ",
    //    " 4 |  |   |                 |  |=|                              |_____________|  |    \\",
    //    " 5 |  |   |                 |  |_|                              |      |      |  |     ",
    //    " 6 |  |   |                 |            |==^                   |      |      |  |     ",
    //    " 7 |  |   |                 |   _______V__||__V_________________|      |      |  |     ",
    //    " 8 |  |   |                 |  / O    /|______|\\    |           |      |      |  |     ",
    //    " 9 /  |   |                 | / /     \\________/ |  | {+}   {+} |   ( )|( )   |  |     ",
    //    "10    |   |                 |/______________________| __________|      |      |  |     ",
    //    "11    |   |                 ||  ____   ____   ____   ==(-)=(-)==|      |      |  |     ",
    //    "12    |   |                 || | () | | () | | () |   |       | |      |      |  |     ",
    //    "13    |___|                 || |____| |____| |____|   |_______| |______|______|  |     ",
    //    "14   /                       |__________________________________|_____________|  |     ",
    //    "15  /                                                                          \\ |     ",
    //    "16 /                                                                            \\|     "};

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
        "  {}  //| | |   |//                                          | ||         |  |()"};

    // Parastais kreisās puses virtuves izskats.
    // " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 ",
    // " 1            /              /|                                       |          ",
    // " 2           /_____________ / |        ___________________________    |   ______   ",
    // " 3   ___    |  ____   ____ |  |       | | .   \                || |   |  /      \    ",
    // " 4__/   \   | |    | |    ||  |       | | \       .  /    \  / || |   | |        \ ",
    // " 5      |   | |    | |    ||  |       | |    .  \      .       || |   | |         \",
    // " 6      |   | |    | |    ||  |       | |           \   /    . || |   | |          ",
    // " 7      |   | |    | |    ||  ||      | | .   /   .        \   || |   | |          ",
    // " 8      |   | |    | |    || |/|      | |______________________|| |   | |          ",
    // " 9      |   | | ( )| |( ) || | |      |/_________________________\|   | |          ",
    // "10      |   | |    | |    || |/| ____                                 | |          ",
    // "11      |   | |    | |    || | /     /                                | |          ",
    // "12      |   | |    | |    || |/____ /|                                | |          ",
    // "13      |   | |____| |____|| |_|___|_|________________________________| |          ",
    // "14      |   |              | |     |                                   \|          ",
    // "15      |   |______________|/|     |                                               ",
    // "16      |  /                                                                       "
    
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

    // ==================================================================================== Loga spoks ===================================================================================== //
    public static void noteiktVirtSpokaFazesSkatu() {
        // Skatoties uz loga spoka fāzes indeksu nosaka kādu bildi izvadīs.
        if (Spoki.logaSpokaFazesIndeks == -1) {
            virtLogaSpokaFazesBilde = Spoku_Izskati.virtuvesLogsCiet;
        } else if (Spoki.logaSpokaFazesIndeks == 0) {
            virtLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieVirtuves0; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 1) {
            virtLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieVirtuves1; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 2) {
            virtLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieVirtuves2; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 3){
            virtLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieVirtuves3; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 4) {
            virtLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieVirtuves4; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 5) {
            virtLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieVirtuves5; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 6) {
            virtLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieVirtuves6; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 7) {
            virtLogaSpokaFazesBilde = Spoku_Izskati.virtuvesLogsVala; // Nomaina visas jaunā array vērtības.
        } 
    }

    public static String[] modificetasVirtLabasPusesIzvade() {
        // Modificētā, galējā bilde.
        String[] virtuveKreisa = {
            "           /              /|                                     |              ",
            "          /              / |                                     |              ",
            "         /______________/  |      ___________________________    |   ______     ",
            "    __   | ____   ____ |   |     " + virtLogaSpokaFazesBilde[0] + virtKreisaPusesPagrabaSkats[0] + "    ",
            "   /  \\  ||    | |    ||   |     " + virtLogaSpokaFazesBilde[1] + virtKreisaPusesPagrabaSkats[1] + "   ",
            "  /   |  ||    | |    ||   |     " + virtLogaSpokaFazesBilde[2] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            " /    |  ||    | |    ||   |     " + virtLogaSpokaFazesBilde[3] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "/     |  ||    | |    ||   ||    " + virtLogaSpokaFazesBilde[4] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "      |  ||    | |    ||   /|    " + virtLogaSpokaFazesBilde[5] + virtKreisaPusesPagrabaSkats[2] + "|  ",
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
    // " 9   ( ) /     | |                  ( ) |/______________________\\| | | | |" , 
    // "10   | |/      |_|__________________| | ^   _________________      |  \\  |" , 
    // "11   | |      / /                   | |$|==|_|___|__|__|___|_|     |   \\ |" , 
    // "12   | |    /  /              _   / | | |  |_________________|     |    \\|" , 
    // "13   | |  /    |             ( )/   | |_|____|_____________|_______|" , 
    // "14   | |/_____/______________| |    | |                             \\" , 
    // "15   | |      |              | |  / |_|                              \\" , 
    // "16   | |______|______________| |/                                     \\"};  

    public static void noteiktGultSpokaFazesSkatu() {
        // Skatoties uz loga spoka fāzes indeksu nosaka kādu bildi izvadīs.
        if (Spoki.logaSpokaFazesIndeks == -1) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.gultasLogsCiet;
        } else if (Spoki.logaSpokaFazesIndeks == 0) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieGultas0; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 1) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieGultas1; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 2) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieGultas2; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 3) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieGultas3; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 4) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieGultas4; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 5) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieGultas5; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 6) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.logaSpPieGultas6; // Nomaina visas jaunā array vērtības.
        } else if (Spoki.logaSpokaFazesIndeks == 7) {
            gultLogaSpokaFazesBilde = Spoku_Izskati.gultasLogsVala; // Nomaina visas jaunā array vērtības.
        } 
    }

    public static void gultPreiksasSagatavosanaIzvadei() {
        noteiktGultSpokaFazesSkatu();
    }

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

    static String[] virtLogaSpokaFazesBilde = Spoku_Izskati.virtuvesLogsCiet; // Definē jauno array.
    static String[] divanaLogaSpokaFazesBilde = Spoku_Izskati.divanaLogsCiet; // Definē jauno array.
    static String[] gultLogaSpokaFazesBilde = Spoku_Izskati.gultasLogsCiet; // Definē jauno array.
    static String[] durLogaSpokaFazesBilde = Spoku_Izskati.durvjuLogsCiet; // Definē jauno array.

    // Loga spoka fāzes nosakošā metode.
    public static void noteiktLogaSpokaFazesBildi(String logaSpokaEsosaIstaba) {
        if (logaSpokaEsosaIstaba.equals("Gulta")) {
            noteiktGultSpokaFazesSkatu();
        } else if (logaSpokaEsosaIstaba.equals("Divans")) {
            noteiktDivanaSpokaFazesSkatu();
        } else if (logaSpokaEsosaIstaba.equals("Durvis")) {
            noteiktDurIstabasSpokaFazesSkatu();
        } else if (logaSpokaEsosaIstaba.equals("Virtuve")) {
            noteiktVirtSpokaFazesSkatu();
        } else {

        }
        
    }

    // Loga spoka apvienojošā metode.
    public static void logaSpokaIzveletasIstabasKustiba() {

    }
    // ============================================================================ Loga spoka beigas ==================================================================================== //

    // =============================================================================== Durvju spoks ======================================================================================= //
    // public static String[] durvisPrieksa= 
    //     {" 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0  ",
    //     " 1             |                                                   |  ",
    //     " 2             |                              __________________   |  ",
    //     " 3             |                            /|                  |  |  ",
    //     " 4 /|          |                           / |                  |  |   |\\       __  ",
    //     " 5/ |          |                          /  |                  |  | \\     /  ",
    //     " 6| |          |                         /   |   --__     __--  |  |   |  \\   /  ",
    //     " 7| |          |                        /    |  ( O )  _  ( O ) |  |   |\\| |  |  ",
    //     " 8| |          |____________________    |    |         V    _^_ |  |   |\\|/|  |  ",
    //     " 9| |          /                    \   |  / | -^__      ^_|v ^ |  |   |  |/|  |  ",
    //     " 0| |         /                      \  |()  | ^-V |__^_| v_^   |  |    \\| |  |  ",
    //     " 1| |        /________________________\ |    |    ^-vv_^- ^     |  |     \\ |  |  ",
    //     " 2| |         ||____________________||__|    |                  |__|      \\|  |  ",
    //     "13|_|         |                      |  |   /                    \\         |  ",
    //     "14 /         /|                      |  |  /                      \\        |  ",
    //     "15/         /                           | /                        \\       |  ",
    //     "16         /                            |/                          \\      |"
    //     };

    public static void noteiktVirPrieksasSpokaFazesSkatu() {
        if (Main.pagrabaGaismaON) {
                // Skatoties uz loga spoka fāzes indeksu nosaka kādu bildi izvadīs.
            if (Spoki.virSpokaFazesIndeks == -1) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.ieslegtaPagrabaGaisma;
            } else if (Spoki.virSpokaFazesIndeks == 0) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp0; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 1) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp1; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 2) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp2; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 3) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp3; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 4) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp4; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 5) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp5; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 6) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp6; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 7) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp7; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 8) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp8; // Nomaina visas jaunā array vērtības.
            } else if (Spoki.virSpokaFazesIndeks == 9) {
                virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.virtuvesSp9; // Nomaina visas jaunā array vērtības.
                Main.pagrabaGaismaON = false;
            }
        } else {
            virtPrieksasPagrabaBildesArSpoku = Spoku_Izskati.izslegtaPagrabaGaisma;
        }
    }

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
        {gultasPrieksa, gultasLabaPuse, gultasLeja, modificetasGultasKreisasPusesIzvade()}, // Gultas istaba [x][].
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

    static String[] istabasArIzslegtuElektribu(String[] varonaAktualaIstaba) {
        String[] tumsaIstaba = {
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
            K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET,
        };
        
        if (VaronaDarbibas.aizdedzinatsSerkocins) {
            tumsaIstaba[8] = K.TPELEKS + varonaAktualaIstaba[8] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + "\033[70G░░░░░░░░░░░░" + K.RESET;
            tumsaIstaba[9] = K.TPELEKS + varonaAktualaIstaba[9] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + "\033[73G░░░░░░░░░" + K.RESET;
            tumsaIstaba[10] = K.TPELEKS + varonaAktualaIstaba[10] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + "\033[76G░░░░░░" + K.RESET;
            tumsaIstaba[11] = K.TPELEKS + varonaAktualaIstaba[11] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + "\033[61G" + K.DZELTENS + "/\\_" + K.TPELEKS + "\033[79G░░░" + K.RESET;
            tumsaIstaba[12] = K.TPELEKS + varonaAktualaIstaba[12] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + "\033[60G"+ K.ORANZS + "/   \\" + K.TPELEKS + "\033[80G░░" + K.RESET;
            tumsaIstaba[13] = K.TPELEKS + varonaAktualaIstaba[13] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + "\033[60G" + K.SARKANS + "| O  |" + K.TPELEKS + "\033[80G░░" + K.RESET;
            tumsaIstaba[14] = K.TPELEKS + varonaAktualaIstaba[14] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + "\033[61G" + K.SARKANS + "'-\\'" + K.TPELEKS + "\033[80G░░" + K.RESET;
            tumsaIstaba[15] = K.TPELEKS + varonaAktualaIstaba[15] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + "\033[64G" + K.BRUNS + "\\" + K.TPELEKS + "\033[80G░░" + K.RESET;
        }
        return tumsaIstaba;
    }
}
