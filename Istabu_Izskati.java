public class Istabu_Izskati {
    // Durju istabas parastie skati jeb stāvokļi.
    public static String[] durvisLaba= {
        " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
        " 1   |                                                   | \\                   \\  ",
        " 2 . |              ________________                     |  \\___________________\\ ",
        " 3/| |   _______   /                \\            |       |  |           | | | | | ",
        " 4 | |  |       |  |                |           \\|/      |  |___________| |f|_| | ",
        " 5 | |  |   |   |  |                |   _        |       |  |____________\\|_|__\\| ",
        " 6 | |  |  \\|/  |  |                |  |=|       |       |  || | | | |        | | ",
        " 7 | |  |  \\|/  |  |                |  |_|       |       |  || |e|a|d|________| | ",
        " 8 | |  |  \\|/  |  |                |            |       |  |_\\|_|_|_|_________\\| ",
        " 9 | |  |___|___|  |                |            |       |  |          | | | || | ",
        "10 | |             |                |            |       |  |__________| |y|u|| | ",
        "11 | |             |                |            |       |  |___________\\|_|_|_\\| ",
        "12 | |             |                |           /|\\      |  | | | |           | | ",
        "13 | |_____________|                |__________/_|_\\_____|  |_| |p|___________| | ",
        "14 |/                                         /  |  \\     \\ |__\\|_|____________\\| ",
        "15 /                                             |         \\|___________________| ",
        "16/                                                                              \\"
        };

    public static String[] durvisZeme = {
        " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
        " 1         /     /|     ___.----.___            |  \\_____________\\ |              ",
        " 2        /     / |  .--            --.         |  |      |      | |              ",
        " 3       /     /__|  |                |         |  |      |      | |    .         ",
        " 4      /     /| /|  |                |         |  |      |      | |    |\\        ",
        " 5     /     /||/ |  |                |         |  |      |      | |    | \\       ",
        " 6    /     / |/__|  |                |         |  |      |      | |    | |\\      ",
        " 7   /     /  /  /|  |                |         |  |   +  |  +   | |    | | \\     ",
        " 8  /     /  /  / |  |                |         |  |      |      | |    | |. \\    ",
        " 9 /     /  /| /|_|  |                |         |  |______|______| |    | |   \\   ",
        "10/_____/  /||/||/|  |                |         |  |           | | |    | | /  \\  ",
        "11|     | /||/||/ |  |                |  .---.  |  |           | | |    |_|   \\ \\ ",
        "12|     |/||/ |/__|  |                |  \\___/  |  |___________| | |    \\  \\ .   \\",
        "13|     | |/  /  /|__|                |__|_|_|__|  |____________\\|_|     \\  \\ /   ",
        "14|     | /  /  //                       | | |   \\ |             |  \\     \\  \\ .  ",
        "15|     |/  /| //                          |      \\|_____________|   \\     \\  \\   ",
        "16|     |  /||//                                                      \\     \\  \\  "
        };

    public static String[] modificetaDurKreisasPusesBildesIzvade() {
        String[] durKreisaPuse = {
        " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
        " 1 /  |    |       ________________________________                           |   ",
        " 2/   |    |      " + durLogaSpokaFazesBilde[0] + "                          |   ",
        " 3    |    |      " + durLogaSpokaFazesBilde[1] + "                          |   ",
        " 4    |    |      " + durLogaSpokaFazesBilde[2] + "                          |   ",
        " 5    |    |      " + durLogaSpokaFazesBilde[3] + "                          |   ",
        " 6    | +  |      " + durLogaSpokaFazesBilde[4] + "                          |   ",
        " 7    |   /|      " + durLogaSpokaFazesBilde[5] + "                          |   ",
        " 8    |  / |      " + durLogaSpokaFazesBilde[6] + "                          |   ",
        " 9  + | /  |      |/______________________________\\|               ___________|   ",
        "10    |/   |                                                       \\           \\  ",
        "11    /____|                                                        \\           \\ ",
        "12   /    /|                                                        |\\           \\", 
        "13  /    / |________________________________________________________|_\\           ",
        "14 /    /  |                                                           \\          ",
        "15/    /  /                                                             \\         ",
        "16    /  /                                                               \\        "};
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

    public static String[] modificetasDurPrieksasBildesIzvade() {
        String[] durvisPrieksa= {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
            " 1             |                                                   |              ",
            " 2             |                              __________________   |              ",
            " 3             |                        " + durSpokaFazesBilde[0]+ " |              ",
            " 4 /|          |                        " + durSpokaFazesBilde[1]+ " |   |\\       __",
            " 5/ |          |                        " + durSpokaFazesBilde[2]+ " |   | \\     /  ",
            " 6| |          |                        " + durSpokaFazesBilde[3]+ " |   |  \\   /   ",
            " 7| |          |                        " + durSpokaFazesBilde[4]+ " |   |\\| |  |   ",
            " 8| |          |                        " + durSpokaFazesBilde[5]+ " |   |\\|/|  |   ",
            " 9| |          |___________________     " + durSpokaFazesBilde[6]+ " |   | |/|  |   ",
            "10| |         /                    \\    " + durSpokaFazesBilde[7]+ " |    \\| |  |   ",
            "11| |        /                      \\   " + durSpokaFazesBilde[8]+ " |     \\ |  |   ",
            "12| |       /________________________\\  " + durSpokaFazesBilde[9]+ " |      \\|  |   ",
            "13|_|        ||___________________||____" + durSpokaFazesBilde[10]+ "_|          |   ",
            "14 /         |                     |    " + durSpokaFazesBilde[11]+ "  \\         |   ",
            "15/         /|                     |    " + durSpokaFazesBilde[12]+ "   \\        |   ",
            "16         /                            " + durSpokaFazesBilde[13]+ "    \\       |   "
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

    static String[] divanaKreisa = {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0" ,
            " 1   |                                                                        |   " ,
            " 2   |                                                                        |   " ,
            " 3   |                                                                        |   " ,
            " 4   |                    ___                                                 |   " ,
            " 5   |                   |<=]|                                                |   " ,
            " 6   |                   | | |             _________________________________  |   " ,
            " 7   |             _     |===|            /       \\                 /       \\ |   " ,
            " 8   |         _  / \\    | | |            |_   x   |       x       |   x   _| |   " ,
            " 9   |        /\\\\/ //    |___|           /  \\      |               |      /  \\|   " ,
            "10   |        \\ /  /                    /_  /______|_______________|______\\  _\\   " ,
            "11   |         // /                    |  \\/______/_________________\\______\\/  |  " ,
            "12   |        /  / \\                   |  |      |                   |      |  |  " ,
            "13   |_______/  /\\\\ \\__________________|  |      |                   |      |  |  ",
            "14  /    ___// /__\\ \\\\____             |_______________________________________|  ",
            "15 /     \\__\\_/____\\  \\___\\                                                     \\ ",
            "16/                 \\_/                                                          \\"};

    static String[] divanaZeme = {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
            " 1             |       ________________               _______      |              ",
            " 2             |      /                \\             /   |   \\     |              ",
            " 3    ______   |      |                |            |    |    |    |              ",
            " 4   /      |  |      |                |            |    O--  |    |              ",
            " 5  /       |  |      |                |            |         |    |              ",
            " 6 /        |  |      |                |             \\_______/     |              ",
            " 7/         |  |      |                |                           |           |\\ ",
            " 8          |  |      |                |                           |           | \\",
            " 9          |  |      |                |                           |           |  ",
            "10          |  |      |                |                           |   /\\      |/\\",
            "11          |  |      |                |  _______________          |  /  \\     |\\ ",
            "12          |  |      |                | /___/_____/___/ |         | /   /     | |",
            "13          |  |______|                |_|   $     $   | |_________|/   /      | |",
            "14          | /                          |   |     |   | |   ____  /   /        \\ ",
            "15          |/                           |_____________|/    \\   \\/   /          \\",
            "16                                                            \\  /   /\\           "};
            

    static String[] divanaLaba = {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
            " 1   |                                                                        |   ",
            " 2   |                                                    ___.---.___         |   ",
            " 3   |         \\        /                             .---           ---.     |   ",
            " 4   |          \\      /                              |                 |     |   ",
            " 5   |        ___\\____/____                       _   |                 |     |   ",
            " 6   |       /___________ /|                     |=|  |                 |     |   ",
            " 7   |      |.--------.| | |               _     |_|  |                 |     |   ",
            " 8   |      ||        ||+| |               U          |                 |     |   ",
            " 9   |______||________||-| |____           |          |                 |     |   ",
            "10   /      |__________|_|/     /|         |          |                 |     |   ",
            "11  /__________________________/ |         |          |                 |     |   ",
            "12  |       |         |        | |         |_         |                 |     |   ",
            "13  |  O    |    O    |    O   | |_______ |--| _______|                 |_____|   ",
            "14  |       |         |        | /        \\__/                                 \\  ",
            "15 /|_______|_________|________|/                                               \\ ",
            "16/                                                                              \\"};

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
        " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
        " 1             |           ____________________________            |              ",
        " 2             |          " + divanaLogaSpokaFazesBilde[0] + "           |              ",
        " 3             |          " + divanaLogaSpokaFazesBilde[1] + "           |              ",
        " 4             |          " + divanaLogaSpokaFazesBilde[2] + "           |              ",
        " 5             |          " + divanaLogaSpokaFazesBilde[3] + "           |              ",
        " 6           __|          " + divanaLogaSpokaFazesBilde[4] + "           | |            ",
        " 7          /   \\         " + divanaLogaSpokaFazesBilde[5] + "           | |            ",
        " 8         /    |         |/__________________________\\|         __|_|_    /      ",
        " 9        /     |                                           ____|\\   | \\  /       ",
        "10       /.  x  |                                          |\\   |.\\     \\/        ",
        "11      /  \\    |________                                  | \\  ||\\\\    /\\        ",
        "12     /   |   /         \\                                 | o\\ || .\\_____\\       ",
        "13    /    |  /________  /_________________________________|  |\\ | ||     |       ",
        "14   /  x  | /         \\/|                                 \\  | \\ \\||     |       ",
        "15  / \\    |/________  /|/                                  \\ | o\\ ||     |       ",
        "16 /  |    /         \\/|/                                    \\|   \\ |     |       "};
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

    static String[] gultasKreisa = {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0" , 
            " 1             |      _____                                        |              " ,
            " 2__           |     /     \\                                       |              " , 
            " 3  \\          |    |    .  |                                      |              " , 
            " 4   |         |    |  \\    |                                      |              " , 
            " 5   |         |    |       |                   _                 _|              " , 
            " 6   |         |    | .  /  |                  ( )      ___      ( )              " ,
            " 7   |         |     \\_____/                   | |___---   ---___| |              " , 
            " 8   |         |_____________________          | |               | |              " , 
            " 9   |        /                     /|         | |               | |              " , 
            "10   |       /_____________________/ |         | |_______________| |              " , 
            "11   |       | |       ( )       | | |         ||\\       _________\\|              " , 
            "12   |       | |_________________| | |         || \\_____/          \\              ", 
            "13   |       | |       ( )       | | |_________|| |\\                \\             ", 
            "14   |       | |_________________| | |         ||\\| \\                \\            " , 
            "15   |       |_____________________|/             \\  \\                \\           " , 
            "16   |      /                                      \\  \\                \\          "};

    static String[] gultasZeme = {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0" , 
            " 1             |                       ________________            |              " , 
            " 2   _____     |         _______      /                \\           |  __          " , 
            " 3  /     \\    |        /       |     |                |           | |  \\         " , 
            " 4 /       |   |       /|  =  ON|     |                |           | | / |        " , 
            " 5/        ||| |      | | _|_   |     |                |           | |   |        " , 
            " 6         ||| |      | |       |     |                |           | |\\  |        " , 
            " 7         |   |      | |    OFF|     |                |           | |   |        " , 
            " 8         |   |      | |_______|     |                |     ______| | . |        " , 
            " 9         |   |      | /             |                |    |\\     \\  \\__|        " , 
            "10         |   |      |/              |                |    | \\     \\             " , 
            "11         |   |                      |                |    | O\\     \\            " , 
            "12         |   |                      |                |    |\\  \\     \\           " , 
            "13         |   |______________________|                |____| \\  \\_____\\          " , 
            "14         |  /                                             | O\\ |     |          " , 
            "15         | /                                              \\\\  \\|     |          " , 
            "16         |/                                                \\\\  |     |          "};

    static String[] gultasLaba = {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0" , 
            " 1       / |   |    ________                 ________________      |              " , 
            " 2      /| |   |   |        |               /                \\     |              " , 
            " 3     /|| |   |   | |\\/\\/\\ |               |                |     |              " , 
            " 4    / || |   |   | | \\  | |               |                |  _  |   /|\\        " , 
            " 5   /. || |   |   |  \\  /  |               |                | |=| |  / | \\       " , 
            " 6  /   || |   |   |   ||   |               |                | |_| | / /|  \\      " , 
            " 7 / .  || |   |   |   ||   |               |                |     | |\\ |   \\     " , 
            " 8/|\\ / || |   |   |________|    _________  |                |     | | \\| | |     " , 
            " 9||    ||_|   |                |         | |                |     | |/ | | |     " , 
            "10||/   |/ /   |                |_________| |                |     | |  |   |     " , 
            "11||  \\ / /    |                |  _____  | |                |     | | / \\  |     " , 
            "12||.  / / __  |                | |  |  | | |                |     | |/   \\ |     " ,
            "13||  / / / /| |________________| | -O- | |_|                |_____|       \\|     " ,
            "14|| / / /|/ |/                 | |__|__| |                         \\             " ,
            "15||/ / / / //                  |_________|                          \\            " ,
            "16|/ / /|/ /|                                                         \\           "};

    public static String[] modificetasGultPrieksasIzvade() {
    String[] gultPrieksa = {   
        " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0" , 
        " 1             |                         ________________________  |              ",  
        " 2             |                        " + gultLogaSpokaFazesBilde[0] + " |              ", 
        " 3             |                        " + gultLogaSpokaFazesBilde[1] + " | |\\           " , 
        " 4             |                        " + gultLogaSpokaFazesBilde[2] + " | | \\          " , 
        " 5             |_                       " + gultLogaSpokaFazesBilde[3] + " | |  \\         " , 
        " 6             ( )                      " + gultLogaSpokaFazesBilde[4] + " | ||\\_|        " , 
        " 7         ____| |                      " + gultLogaSpokaFazesBilde[5] + " | |\\ /|        " , 
        " 8    _   /    | |                   _  " + gultLogaSpokaFazesBilde[6] + " | | | |        " , 
        " 9   ( ) /     | |                  ( ) |/______________________\\| | | | |        " , 
        "10   | |/      |_|__________________| | ^   _________________      |  \\  |        " , 
        "11   | |      / /                   | |$|==|_|___|__|__|___|_|     |   \\ |        " , 
        "12   | |    /  /              _   / | | |  |_________________|     |    \\|        " , 
        "13   | |  /    |             ( )/   | |_|____|_____________|_______|              " , 
        "14   | |/_____/______________| |    | |                             \\             " , 
        "15   | |      |              | |  / |_|                              \\            " , 
        "16   | |______|______________| |/                                     \\           "};
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

    static String[] virtuveZeme = {
        " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
        " 1   |                 ______________                              ___________|   ",
        " 2   |               _/____/___/___  \\          ________________  |\\           \\  ",
        " 3   |              /              \\/|  _____  /                \\ |\\\\           \\ ",
        " 4   |              |              | | |PHONE| |                | ||\\\\ __________\\",
        " 5   |              |              | | |  _  | |                | |||\\|          |",
        " 6   |              |              | | | ( ) | |                | |||||          |",
        " 7   |              |            - | | |  |  | |                | |||||          |",
        " 8   |______________|            | | | | (_) | |                | |||||          |",
        " 9   /     O---     |            | | | |_____| |                | |||||          |",
        "10  /    ___________|            - | |         |                | |||||  .    .  |",
        "11 /    /|       |  |              | |         |                | |||||  |____|  |",
        "12/    / |       |  |              | |         |                | |||||  |    |  |",
        "13--E /__|_______|__|              | |_________|                |_|\\|||  |____|  |",
        "14   /.-.           |______________|/                              \\\\||  |____|  |",
        "15  /'._.'                                                          \\\\|  \\     \\ |",
        "16 /   |                                                             \\|__|\\_____\\|"};

    static String[] virtuveLaba = { 
        " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
        " 1    /        /  |   |  _________________                         |              ",
        " 2   /________/   |()/| /                 \\                        |              ",
        " 3   |        |   | //| |                 |                        |              ",
        " 4   |        | ()|// | |                 |  _                     |              ",
        " 5   |        |   //  | |                 | |=|                    |              ",
        " 6   |        |  //   | |                 | |_|                .---------.        ",
        " 7   |        | //|   | |                 |    ________________|\\         \\       ",
        " 8   |        |// |   | |                 |   /  |             | \\         \\      ",
        " 9   |        |/  |   | |                 |  /___H_____________|  '--------.\\     ",
        "10   |        |   |   | |                 |   |     .-.        |  |         |     ",
        "11   |        |   |() | |                 |   |    '._.'       |  |         |     ",
        "12   |______  |   |   | |                 |   |      |         |  |         |  .  ",
        "13  /      /| | ()|   |_|                 |___|_____/|\\________|  |         |  |\\ ",
        "14 /  {}  //| |   |  //                            / | \\       |  |         |  |~\\",
        "15/      /O | |   | //                               |         | \\|         |  | ~",
        "16  {}  //| | |   |//                                          | ||         |  |()"};

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

    public static String[] modificetasVirtKreisasPusesIzvade() {
        // Modificētā, galējā bilde.
        String[] virtuveKreisa = {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
            " 1           /              /|                                     |              ",
            " 2          /              / |                                     |              ",
            " 3         /______________/  |      ___________________________    |   ______     ",
            " 4    __   | ____   ____ |   |     " + virtLogaSpokaFazesBilde[0] + virtKreisaPusesPagrabaSkats[0] + "    ",
            " 5   /  \\  ||    | |    ||   |     " + virtLogaSpokaFazesBilde[1] + virtKreisaPusesPagrabaSkats[1] + "   ",
            " 6  /   |  ||    | |    ||   |     " + virtLogaSpokaFazesBilde[2] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            " 7 /    |  ||    | |    ||   |     " + virtLogaSpokaFazesBilde[3] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            " 8/     |  ||    | |    ||   ||    " + virtLogaSpokaFazesBilde[4] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            " 9      |  ||    | |    ||   /|    " + virtLogaSpokaFazesBilde[5] + virtKreisaPusesPagrabaSkats[2] + "|  ",
            "10      |  || ( )| |( ) || |/||    |/_________________________\\|   | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "11      |  ||    | |    || | ||                                    | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "12      |  ||    | |    || | /|_____                               | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "13      |  ||    | |    || |//     /_______________________________| |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
            "14      |  ||    | |    || |/_____/|                                \\|" + virtKreisaPusesPagrabaSkats[4] + "|  ",
            "15      |  ||____| |____|| |  |  | |                                    " + virtKreisaPusesPagrabaSkats[5] + "|  ",
            "16      |  |             |/|     |                                        " + virtKreisaPusesPagrabaSkats[6] + "|  "};
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
    public static String[] modificetasVirtPrieksasBildesIzvade() {
        String[] virtuvePrieksa = {
            " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0",
                " 1   |    __.-------.__                                       |  |       |       |",
                " 2   | .--" + virtPrieksasPagrabaBildesArSpoku[0] + "--.                                    |  |    ( )|( )    |",
                " 3  .| |" + virtPrieksasPagrabaBildesArSpoku[1] + "|  _                                 |  |_______|_______|",
                " 4 /|| |" + virtPrieksasPagrabaBildesArSpoku[2] + "| |=|                                |  |_______________|",
                " 5/ || |" + virtPrieksasPagrabaBildesArSpoku[3] + "| |_|                                |  |       |       |",
                " 6| || |" + virtPrieksasPagrabaBildesArSpoku[4] + "|                                    |  |       |       |",
                " 7| || |" + virtPrieksasPagrabaBildesArSpoku[5] + "|          |==^                      |  |       |       |",
                " 8| || |" + virtPrieksasPagrabaBildesArSpoku[6] + "|________V__||__V____________________|  |       |       |",
                " 9|_|| |" + virtPrieksasPagrabaBildesArSpoku[7] + "|\\ ---O |        \\      \\  {+}   {+}  \\ |       |       |",
                "10 / | |" + virtPrieksasPagrabaBildesArSpoku[8] + "| \\_____\\________/_______\\_____________\\|    ( )|( )    |",
                "11/  | |" + virtPrieksasPagrabaBildesArSpoku[9] + "| |  _______    _______  |==(+)====(-)==|       |       |",
                "12   | |" + virtPrieksasPagrabaBildesArSpoku[10] + "| | |       |  |       | | |          | |       |       |",
                "13   |_|" + virtPrieksasPagrabaBildesArSpoku[11] + "| | |    ( )|  |( )    | | |          | |       |       |",
                "14  /                    \\ | |_______|  |_______| | |__________| |_______|_______|",
                "15 /                      \\|______________________|______________|_______________|",
                "16/                                                                               "};
        return virtuvePrieksa;
    }
   
    static String[] [][] istabuMasivaAtjaunosana() {

        String[] [][] istabaUnVirziens = { // {Priekša, LabāPuse, Leja, KreisāPuse} // Istabas virzieni.
        {modificetasGultPrieksasIzvade(), gultasLaba, gultasZeme, gultasKreisa}, // Gultas istaba [x][].
        {modificetaDivanaPrieksasBildesIzvade(), divanaLaba, divanaZeme, divanaKreisa}, // Dīvāna istaba [x][].
        {modificetasDurPrieksasBildesIzvade(),durvisLaba, durvisZeme, modificetaDurKreisasPusesBildesIzvade()}, // Durvju istaba [x][].
        {modificetasVirtPrieksasBildesIzvade(), virtuveLaba, virtuveZeme, modificetasVirtKreisasPusesIzvade()} // Virtuves istaba.
        }; 
        
        return istabaUnVirziens;
    }

    public static String[] aktualaIstabasIzskats = new String[17]; // 17, jo ir pirmā skaitļa līnija.

    public static void aktualasIstabasParrakstisana(String[] istaba) {
        aktualaIstabasIzskats = istaba;
    }
}
