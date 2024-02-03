package Spele.Izskati;
import Spele.SpelesProcesi.Main;
import Spele.K;

public class IstabuIzskati {
  // Durju istabas parastie skati jeb stāvokļi.
  // ? ----------------------------------------------------------------------------------- DURVJU ISTABAS VIRZIENI --------------------------------------------------------------------------------------------------
  public static final String[] durvjuLeja = {
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

  public static final String[] durvjuKreisaPuse = {
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
  
	public static final String[] durvjuPrieksa = {
		" /  |    |       ________________________________                           |   ",
		"/   |    |      |                                |                          |   ",
		"    |    |      |                                |                          |   ",
		"    |    |      |                                |                          |   ",
		"    |    |      |                                |                          |   ",
		"    | +  |      |                                |                          |   ",
		"    |   /|      |                                |                          |   ",
		"    |  / |      |                                |                          |   ",
		"  + | /  |      |/______________________________\\|               ___________|   ",
		"    |/   |                                                       \\           \\  ",
		"    /____|                                                        \\           \\ ",
		"   /    /|                                                        |\\           \\",
		"  /    / |________________________________________________________|_\\           ",
		" /    /  |                                                           \\          ",
		"/    /  /                                                             \\         ",
		"    /  /                                                               \\        "
	};
     
  public static String[] modificetasDurvjuLabasPusesBildesIzvade() {
      String[] labasDurvis = new String[2];
      if (!Main.istabuGaismasIeslegtas[3]) {
          labasDurvis[0] = "░░";
          labasDurvis[1] = "░░░";
      } else {
          labasDurvis[0] = "  ";
          labasDurvis[1] = "   ";
      }
      String[] durvisPrieksa= {
          "             |                                                   |              ",
          "             |                              __________________   |              ",
          "             |                             |                  |  |            ",
          " /|          |                             |                  |  |   |\\       __",
          "/ |          |                             |                  |  |   | \\     /" + K.TPELEKS + labasDurvis[0] + K.RESET,
          "| |          |                             |                  |  |   |  \\   /" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "| |          |                             |                  |  |   |\\| |  |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "| |          |                             |                  |  |   |\\|/|  |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "| |          |___________________          |                  |  |   | |/|  |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "| |         /                    \\        |                   |  |    \\| |  |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "| |        /                      \\       |                   |  |     \\ |  |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "| |       /________________________\\      |                   |  |      \\|  |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "|_|        ||___________________||_________|                  |__|          |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          " /         |                     |                                \\         |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "/         /|                     |                                 \\        |" + K.TPELEKS + labasDurvis[1] + K.RESET,
          "         /                                                          \\       |" + K.TPELEKS + labasDurvis[1] + K.RESET
      };
      return durvisPrieksa;
  }
  // ? ----------------------------------------------------------------------------------- DĪVĀNA ISTABAS VIRZIENI --------------------------------------------------------------------------------------------------
	public static final String[] divanaKreisaPuse = {
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
		"/                 \\_/                                                          \\"
	};

  
  public static final String[] divanaLeja = {
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
		"                                                            \\  /   /\\           "
	};

	public static final String[] divanaLabaPuse = {
		"   |                                                                        |   ",
		"   |                                                   ___.----.___         |   ",
		"   |         \\        /                             .--            --.      |   ",
		"   |          \\      /                              |                |      |   ",
		"   |        ___\\____/____                       _   |                |      |   ",
		"   |       /___________ /|                     |=|  |                |      |   ",
		"   |      |.--------.| | |               _     |_|  |                |      |   ",
		"   |      ||        ||+| |               U          |                |      |   ",
		"   |______||________||-| |____           |          |                |      |   ",
		"   /      |__________|_|/     /|         |          |                |      |   ",
		"  /__________________________/ |         |          |                |      |   ",
		"  |       |         |        | |         |_         |                |      |   ",
		"  |  O    |    O    |    O   | |_______ |--| _______|                |______|   ",
		"  |       |         |        | /        \\__/                                 \\  ",
		" /|_______|_________|________|/                                               \\ ",
		"/                                                                              \\"
	};
  
	public static final String[] divanaPrieksa = {
		"             |           ____________________________            |              ",
		"             |          |                            |           |              ",
		"             |          |                            |           |              ",
		"             |          |                            |           |              ",
		"             |          |                            |           |              ",
		"           __|          |                            |           | |            ",
		"          /   \\         |                            |           | |            ",
		"         /    |         |/__________________________\\|         __|_|_    /      ",
		"        /     |                                           ____|\\   | \\  /       ",
		"       /.  x  |                                          |\\   |.\\     \\/        ",
		"      /  \\    |________                                  | \\  ||\\\\    /\\        ",
		"     /   |   /         \\                                 | o\\ || .\\_____\\       ",
		"    /    |  /________  /_________________________________|  |\\ | ||     |       ",
		"   /  x  | /         \\/|                                 \\  | \\ \\||     |       ",
		"  / \\    |/________  /|/                                  \\ | o\\ ||     |       ",
		" /  |    /         \\/|/                                    \\|   \\ |     |       "
	};
  // ? ----------------------------------------------------------------------------------- GULTAS ISTABAS VIRZIENI --------------------------------------------------------------------------------------------------
  public static final String[] gultasLeja = {
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
		"   |      /                                      \\  \\                \\          "
	};

public static String[] gultasLabaPuse() {
		String[] elektriskaKaste = new String[9]; // Masīvs priekš elektriskās kastes bildes.
		if (Main.elektribaIeslegta) { // Ieslēgts.
				elektriskaKaste[0] = K.OBJEKTS + "   _______" + K.RESET;
				elektriskaKaste[1] = K.OBJEKTS + "  /       |" + K.RESET;
				elektriskaKaste[2] = K.OBJEKTS + " /|  =  ON|" + K.RESET;
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
				"   _____     |      " + elektriskaKaste[0] + "      /                \\           |  __          " ,
				"  /     \\    |      " + elektriskaKaste[1] + "     |                |           | |  \\         " ,
				" /       |   |      " + elektriskaKaste[2] + "     |                |           | | / |        " ,
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

  public static final String[] gultasPrieksa = {
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
    "|/ / /|/ /|                                                         \\           "
  };

  public static final String[] gultasKreisaPuse = {
    "             |                         ________________________  |              ",
    "             |                        |                        | |              ",
    "             |                        |                        | | |\\           " ,
    "             |                        |                        | | | \\          " ,
    "             |_                       |                        | | |  \\         " ,
    "             ( )                      |                        | | ||\\_|        " ,
    "         ____| |                      |                        | | |\\ /|        " ,
    "    _   /    | |                   _  |                        | | | | |        " ,
    "   ( ) /     | |                  ( ) |/______________________\\| | | | |        " ,
    "   | |/      |_|__________________| | ^   _________________      |  \\  |        " ,
    "   | |      / /                   | |$|==|_|___|__|__|___|_|     |   \\ |        " ,
    "   | |    /  /              _   / | | |  |_________________|     |    \\|        " ,
    "   | |  /    |             ( )/   | |_|____|_____________|_______|              " ,
    "   | |/_____/______________| |    | |                             \\             " ,
    "   | |      |              | |  / |_|                              \\            " ,
    "   | |______|______________| |/                                     \\           "
  };

  // ? ----------------------------------------------------------------------------------- VIRTUVES ISTABAS VIRZIENI --------------------------------------------------------------------------------------------------

  public static final String[] virtuvesPrieksa = {
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
    " /   |                                                             \\|__|\\_____\\|"
  };

  public static final String[] virtuvesKreisaPuse = {
    "    /        /  |   |   ________________                         |              ",
    "   /________/   |()/|  /                \\                        |              ",
    "   |        |   | //|  |                |                        |              ",
    "   |        | ()|// |  |                |  _                     |              ",
    "   |        |   //  |  |                | |=|                    |              ",
    "   |        |  //   |  |                | |_|                .---------.        ",
    "   |        | //|   |  |                |    ________________|\\         \\       ",
    "   |        |// |   |  |                |   /  |             | \\         \\      ",
    "   |        |/  |   |  |                |  /___H_____________|  '--------.\\     ",
    "   |        |   |   |  |                |   |     .-.        |  |         |     ",
    "   |        |   |() |  |                |   |    '._.'       |  |         |     ",
    "   |______  |   |   |  |                |   |      |         |  |         |  .  ",
    "  /      /| | ()|   |__|                |___|_____/|\\________|  |         |  |\\ ",
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

      // Kreisas puses noteikšana.
      String[] kreisaPuse = new String[4];
      if (!Main.istabuGaismasIeslegtas[2]) {
          kreisaPuse[0] = "░░░";
          kreisaPuse[1] = "░░░░";
          kreisaPuse[2] = "░░░░░";
          kreisaPuse[3] = "░░░░░░";
      } else {
          kreisaPuse[0] = "   ";
          kreisaPuse[1] = "    ";
          kreisaPuse[2] = "     ";
          kreisaPuse[3] = "      ";
      }

      // Modificētā, galējā bilde.
      String[] virtuveKreisa = {
          "           /              /|                                     |              ",
          "          /              / |                                     |              ",
          "         /______________/  |      ___________________________    |   ______     ",
          "   ___   | ____   ____ |   |     |                           |" + virtKreisaPusesPagrabaSkats[0] + "    ",
          "  /" + K.TPELEKS + kreisaPuse[0] + K.RESET + "\\  ||    | |    ||   |     |                           |" + virtKreisaPusesPagrabaSkats[1] + "   ",
          " /" + K.TPELEKS + kreisaPuse[1] + K.RESET + "|  ||    | |    ||   |     |                           |" + virtKreisaPusesPagrabaSkats[2] + "|  ",
          "/" + K.TPELEKS + kreisaPuse[2] + K.RESET + "|  ||    | |    ||   |     |                           |" + virtKreisaPusesPagrabaSkats[2] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  ||    | |    ||   ||    |                           |" + virtKreisaPusesPagrabaSkats[2] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  ||    | |    ||   /|    |                           |" + virtKreisaPusesPagrabaSkats[2] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  || ( )| |( ) || |/||    |/_________________________\\|   | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  ||    | |    || | ||                                    | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  ||    | |    || | /|_____                               | |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  ||    | |    || |//     /_______________________________| |" + virtKreisaPusesPagrabaSkats[3] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  ||    | |    || |/_____/|                                \\|" + virtKreisaPusesPagrabaSkats[4] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  ||____| |____|| |  |  | |                                    " + virtKreisaPusesPagrabaSkats[5] + "|  ",
          K.TPELEKS + kreisaPuse[3] + K.RESET + "|  |             |/|     |                                        " + virtKreisaPusesPagrabaSkats[6] + "|  "
      };

      return virtuveKreisa; // Atgriež tikko izveidoto array jeb masīvu izvadei.
  }

  public static final String[] virtuvesLeja = {
    "   |    __.-------.__                                       |  |       |       |",
    "   | .--             --.                                    |  |    ( )|( )    |",
    "  .| |                 |  _                                 |  |_______|_______|",
    " /|| |                 | |=|                                |  |_______________|",
    "/ || |                 | |_|                                |  |       |       |",
    "| || |                 |                                    |  |       |       |",
    "| || |                 |          |==^                      |  |       |       |",
    "| || |                 |________V__||__V____________________|  |       |       |",
    "|_|| |                 |\\ ---O |        \\      \\  {+}   {+}  \\ |       |       |",
    " / | |                 | \\_____\\________/_______\\_____________\\|    ( )|( )    |",
    "/  | |                 | |  _______    _______  |==(+)====(-)==|       |       |",
    "   | |                 | | |       |  |       | | |          | |       |       |",
    "   |_|                 | | |    ( )|  |( )    | | |          | |       |       |",
    "  /                    \\ | |_______|  |_______| | |__________| |_______|_______|",
    " /                      \\|______________________|______________|_______________|",
    "/                                                                               "
  };

  public static final String[] [][] istabuMasivs =
    { // { Priekša , LabāPuse , Leja , KreisāPuse } // Istabas virzieni.
    { gultasPrieksa , gultasLabaPuse() , gultasLeja , gultasKreisaPuse },                            // Gultas istaba [x][].
    { divanaPrieksa , divanaLabaPuse , divanaLeja , divanaKreisaPuse },                              // Dīvāna istaba [x][].
    { durvjuPrieksa , modificetasDurvjuLabasPusesBildesIzvade() , durvjuLeja, durvjuKreisaPuse },    // Durvju istaba [x][].
    { virtuvesPrieksa , modificetasVirtLabasPusesIzvade() ,  virtuvesLeja , virtuvesKreisaPuse }     // Virtuves istaba.
  };


  public static String[] arkuGaismasAizpilditajs = {"░░░░░░░░░░░░░░░░", "░░░░░░░░░░░░"};
}