package Spele.Izskati;

import Spele.K;

public class SpokuIzskati {
  // ==================================================================================== Loga spoks ===================================================================================== //
  // ----------------------------------------------------------------------------- Loga spoks pie virtuves -------------------------------------------------------------------------------- //
  // Normāla virt. loga izskats.
  public static final String[] virtuvesLogsCiet = {
      "| | .   \\                || |",
      "| | \\       .  /    \\  / || |",
      "| |    .  \\      .       || |",
      "| |           \\   /    . || |",
      "| | .   /   .        \\   || |",
      "| |______________________|| |",
  };

  // Virtuves loga spoka fāzes.
  public static final String[] logaSpPieVirtuves0 = {
      "| | .   \\                || |",
      "| | \\       .  /    \\  / || |",
      "| |    .  \\      .       || |",
      "| | ..        \\   /    . || |",
      "| | .   /   .        \\   || |",
      "| |______________________|| |",
  };
  
  public static final String[] logaSpPieVirtuves1 = {
      "| | .   \\                || |",
      "| | \\       .  /    \\  / || |",
      "| |    .  \\      .       || |",
      "| | o o       \\   /    . || |",
      "| | .   /   .        \\   || |",
      "| |______________________|| |"
  };

  public static final String[] logaSpPieVirtuves2 = {
      "| | .   \\                || |",
      "| | \\       .  /    \\  / || |",
      "| |    .  \\      .       || |",
      "| |  O     O  \\   /    . || |",
      "| | .   /   .        \\   || |",
      "| |______________________|| |"
  };

  public static final String[] logaSpPieVirtuves3 = {
      "| | .   \\                || |",
      "| | \\       .  /    \\  / || |",
      "| |    .  \\      .      (|| |",
      "| |           \\   /    .(|| |",
      "| | .   /   .        \\   || |",
      "| |______________________|| |",
  };

  public static final String[] logaSpPieVirtuves4 = {
      "| | .   \\             ||  | |",
      "| | \\       .  /    \\ ||  | |",
      "| |    .  \\      .   (||) | |",
      "| |           \\   /  (||  | |",
      "| | .   /   .        \\||  | |",
      "| |___________________||__| |"
  };

  public static final String[] logaSpPieVirtuves5 = {
      "| | .   \\        ||       | |",
      "| | \\       .  / ||^ ^    | |",
      "| |    .  \\     (||)O _O  | |",
      "| |           \\ (||  v-v  | |",
      "| | .   /   .    ||       | |",
      "| |______________||_______| |"
  };

  public static final String[] logaSpPieVirtuves6 = {
      "| | .   \\  ||  ^       ^  | |",
      "| | \\      || / \\ ___ / \\ | |",
      "| |    .  (||)\\ (0)_(0) / | |",
      "| |       (||  -\\ _V_ /-  | |",
      "| | .   /  ||   ^V-~-V^  (| |",
      "| |________||____^___^___(| |"
  };

  public static final String[] virtuvesLogsVala = {
      "| | .   \\  ||             | |",
      "| | \\      ||             | |",
      "| |    .  \\||             | |",
      "| |        ||             | |",
      "| | .   /  ||             | |",
      "| |________||_____________| |"
  };

  // -------------------------------------------------------------------------------- Loga spoks pie gultas -------------------------------------------------------------------------------- //
  public static final String[] gultasLogsCiet = {
      "| ||  .      ||.       | |",
      "| ||       \\ ||    \\   | |",
      "| ||   /  .  ||\\     . | |",
      "| ||  .      ||.       | |",
      "| ||     .   ||   /    | |",
      "| || /       ||      . | |",
      "| ||_________||________| |"
  };

  public static final String[] logaSpPieGultas0 = {
      "| ||  .      ||.       | |",
      "| ||   ..  \\ ||    \\   | |",
      "| ||   /  .  ||\\     . | |",
      "| ||  .      ||.       | |",
      "| ||     .   ||   /    | |",
      "| || /       ||      . | |",
      "| ||_________||________| |"
  };

  public static final String[] logaSpPieGultas1 = {
      "| ||  .      ||.       | |",
      "| ||  o o  \\ ||    \\   | |",
      "| ||   /  .  ||\\     . | |",
      "| ||  .      ||.       | |",
      "| ||     .   ||   /    | |",
      "| || /       ||      . | |",
      "| ||_________||________| |"
  };

  public static final String[] logaSpPieGultas2 = {
      "| ||  .      ||.       | |",
      "| ||  O _ O\\ ||    \\   | |",
      "| ||   /-v . ||\\     . | |",
      "| ||  .      ||.       | |",
      "| ||     .   ||   /    | |",
      "| || /       ||      . | |",
      "| ||_________||________| |"
  };

  public static final String[] logaSpPieGultas3 = {
      "| ||  .      ||.       | |",
      "| ||       \\ ||    \\   | |",
      "| ||   /  .  ||\\     . | |",
      "| ||  .      ||.       | |",
      "| ||     .   ||   /    | |",
      "| || /       ||      . | |",
      "| ||_mn___nm_||________| |"
  };

  public static final String[] logaSpPieGultas4 = {
      "| ||  .      ||.       | |",
      "| ||       \\ ||    \\   | |",
      "| ||   /  .  ||\\     . | |",
      "| ||  .      ||.       | |",
      "| ||     .   ||   /    | |",
      "| ||_mn___nm_||      . | |",
      "| |_/_/___\\_\\_|________| |"
  };

  public static final String[] logaSpPieGultas5 = {
      "| ||  .      ||.       | |",
      "| ||       \\ ||    \\   | |",
      "| ||   /  .  ||\\     . | |",
      "| ||_nnnn____||.       | |",
      "| |----       |   /    | |",
      "| | ^       ^ |      . | |",
      "| |/_\\_____/_\\|________| |"
  };

  public static final String[] logaSpPieGultas6 = {
      "| ||  .      ||.       | |",
      "| ||_________||    \\   | |",
      "| | ^       ^ |\\     . | |",
      "| |/ \\ ___ / \\|.       | |",
      "| |\\ (0)_(0) /|   /    | |",
      "| |  \\ _V_ /  |      . | |",
      "| |nm^V-~-V^_(|________| |"
  };

  public static final String[] gultasLogsVala = {
      "| ||  .      ||.       | |",
      "| ||_________||    \\   | |",
      "| |           |\\     . | |",
      "| |           |.       | |",
      "| |           |   /    | |",
      "| |           |      . | |",
      "| |___________|________| |"
  };

  // -------------------------------------------------------------------------------- Loga spoks pie dīvāna -------------------------------------------------------------------------------- //
  private static final String[] divanaLogsCiet = {
    "| | .  \\        .     /   || |",
    "| |    .     .   /        || |",
    "| |    \\         .  /  /  || |",
    "| |     .               . || |",
    "| |. /     /        .  \\  || |",
    "| |_______________________|| |"
  };

  private static final String[] logaSpPieDivana0 = {
    "| | .  \\        .     /   || |",
    "| |    .     .   /        || |",
    "| |    \\         .  /  /  || |",
    "| |     .      ..       . || |",
    "| |. /     /        .  \\  || |",
    "| |_______________________|| |"
  };

  private static final String[] logaSpPieDivana1 = {
    "| | .  \\        .     /   || |",
    "| |    .     .   /        || |",
    "| |    \\         .  /  /  || |",
    "| |     .    o   o      . || |",
    "| |. /     /        .  \\  || |",
    "| |_______________________|| |"
  };

  private static final String[] logaSpPieDivana2 = {
    "| | .  \\        .     /   || |",
    "| |    .     .   /        || |",
    "| |    \\   ^   ^ .  /  /  || |",
    "| |     .    O  _O      . || |",
    "| |. /     /   v-v  .  \\  || |",
    "| |_______________________|| |"
  };

  private static final String[] logaSpPieDivana3 = {
    "| | .  \\        .     /   || |",
    "| |    .     .   /        || |",
    "| |    \\       ^  .^/  /  || |",
    "| |     .       ( )_( ) .(|| |",
    "| |. /     /      V--V \\ (|| |",
    "| |_______________________|| |"
  };

  private static final String[] logaSpPieDivana4 = {
    "| | .  \\        .     |    | |",
    "| |    .     .   /    |    | |",
    "| |    \\          . / |(O) | |",
    "| |     .            (|    | |",
    "| |. /     /         (|    | |",
    "| |___________________|____| |"
  };

  private static final String[] logaSpPieDivana5 = {
    "| | .  \\        .  |       | |",
    "| |    .     .   / |       | |",
    "| |    \\          .|(O) (O)| |",
    "| |     .         (|       | |",
    "| |. /     /      (|       | |",
    "| |________________|_______| |"
  };

  private static final String[] logaSpPieDivana6 = {
    "| | .  \\     |  ^       ^  | |",
    "| |    .     | / \\ ___ / \\ | |",
    "| |    \\     | \\ (O)_(O) / | |",
    "| |     .    |  -\\ _V_ /-  | |",
    "| |. /     / |   ^V-~-V^   | |",
    "| |__________|_mn_^___^_nm_| |"
  };

  private static final String[] divanaLogsVala = {
    "| | .  \\     |             | |",
    "| |    .     |             | |",
    "| |    \\     |             | |",
    "| |     .    |             | |",
    "| |. /     / |             | |",
    "| |__________|_____________| |"
  };

  // -------------------------------------------------------------------------------- Loga spoks pie durvīm -------------------------------------------------------------------------------- //
  private static final String[] durvjuLogsCiet = {
    "| |       /            \\\\     || |",
    "| |          |           .    || |",
    "| |   \\\\                      || |",
    "| |      .   \\         /      || |",
    "| |           .          /    || |",
    "| |     /           \\         || |",
    "| |___________________________|| |"
  };

  private static final String[] logaSpPieDurvim0 = {
    "| |       /            \\\\     || |",
    "| |          |           .    || |",
    "| |   \\\\                      || |",
    "| |      .   \\         /      || |",
    "| |           .          /    || |",
    "| |     /       ..  \\         || |",
    "| |___________________________|| |"
  };

  private static final String[] logaSpPieDurvim1 = {
    "| |       /            \\\\     || |",
    "| |          |           .    || |",
    "| |   \\\\                      || |",
    "| |      .   \\         /      || |",
    "| |           .          /    || |",
    "| |     /       o o \\         || |",
    "| |___________________________|| |"
  };

  private static final String[] logaSpPieDurvim2 = {
    "| |       /            \\\\     || |",
    "| |          |           .    || |",
    "| |   \\\\                      || |",
    "| |      .   \\         /      || |",
    "| |           .          /    || |",
    "| |     /       O  O\\         || |",
    "| |___________________________|| |"
  };

  private static final String[] logaSpPieDurvim3 = {
    "| |       /            \\\\     || |",
    "| |          |           .    || |",
    "| |   \\\\       ^   ^          || |",
    "| |      .   \\  O _ O  /      || |",
    "| |           .   v v    /    || |",
    "| |     /           \\         || |",
    "| |___________________________|| |"
  };

  private static final String[] logaSpPieDurvim4 = {
    "| |       /            \\\\    | | |",
    "| |          |           .   | | |",
    "| |   \\\\              ( ) ( )| | |",
    "| |      .   \\         /     | | |",
    "| |           .          /  (|>| |",
    "| |     /           \\       (|>| |",
    "| |__________________________|_| |"
  };

  private static final String[] logaSpPieDurvim5 = {
    "| |       /            \\\\ |  ^ | |",
    "| |          |           .|   \\| |",
    "| |   \\\\              ( ) |(O) | |",
    "| |      .   \\         /  | v- | |",
    "| |           .          (| ^  | |",
    "| |     /           \\    (|    | |",
    "| |_______________________|____| |"
  };

  private static final String[] logaSpPieDurvim6 = {
    "| |       /      |  ^       ^  | |",
    "| |          |   | / \\ ___ / \\ | |",
    "| |   \\\\         | \\ (O)_(O) / | |",
    "| |      .   \\   |  -\\ _V_ /-  | |",
    "| |           .  |   ^V-~-V^   | |",
    "| |     /        |  _ ^   ^ _  | |",
    "| |______________|_|_|_____|_|_| |"
  };

  private static final String[] durvjuLogsVala = {
    "| |       /      |             | |",
    "| |          |   |             | |",
    "| |   \\\\         |             | |",
    "| |      .   \\   |             | |",
    "| |           .  |             | |",
    "| |     /        |             | |",
    "| |______________|_____________| |"
  };

  // =============================================================================== Durvju spoks ======================================================================================= //
  private static final String[] durvisCiet = {
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "     |                _ | ",
    "     |           <===(-)| ",
    "     |               |_|| ",
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "_____|__________________|_",
    "                          ",
    "                          ",
    "                          "
  };

  private static final String[] durvjuSp0 = {
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "     |                _ | ",
    "     |           <===(+)| ",
    "     |               |_|| ",
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "_____|__________________|_",
    "                          ",
    "                          ",
    "                          "
  };

  private static final String[] durvjuSp1 = {
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "     |                _ | ",
    "     |             _-(+)| ",
    "     |           -   |_|| ",
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "_____|__________________|_",
    "                          ",
    "                          ",
    "                          "
  };

  private static final String[] durvjuSp2 = {
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "     |                _ | ",
    "     |               (+)| ",
    "     |              /|_|| ",
    "     |                  | ",
    "     |                  | ",
    "     |                  | ",
    "_____|__________________|_",
    "                          ",
    "                          ",
    "                          "
  };

  private static final String[] durvjuSp3 = {
    "     |    ------______  | ",
    "     |                | | ",
    "     |                | | ",
    "     |                | | ",
    "     |                | | ",
    "     |              _ | | ",
    "     |             (+)| | ",
    "     |            /|_|| | ",
    "     |                | | ",
    "     |                | | ",
    "_____|____            | |_",
    "          ------______|   ",
    "                          ",
    "                          "
  };
  
  private static final String[] durvjuSp4 = {
    "     |  --__            | ",
    "     |      --__        | ",
    "     |          --__    | ",
    "     |              |   | ",
    "     |              |   | ",
    "     |              |   | ",
    "     |              |   | ",
    "     |              |   | ",
    "     |            ()|   | ",
    "     |           /  |   | ",
    "_____|__            |   |_",
    "        --__        |     ",
    "            --__    |     ",
    "                --__|     "
  };

  private static final String[] durvjuSp5 = {
      "     |  --__            | ",
      "     |      --__        | ",
      "     |          --__    | ",
      "     |              |   | ",
      "     |              |   | ",
      "     |              | |==>",
      "     |              | |==>",
      "     |              | |==>",
      "     |            ()|  -| ",
      "     |           /  |   | ",
      "_____|__            |   |_",
      "        --__        |     ",
      "            --__    |     ",
      "                --__|     ",
  };

  private static final String[] durvjuSp6 = {
    "     | -_               | ",
    "     |   -_             | ",
    "     |     -_     ___   | ",
    "     |       -_  ( O )  | ",
    "     |         |      |==>",
    "     |         | __   |==>",
    "     |         |_|v   |==>",
    "     |         |v_^    -| ",
    "     |         |        | ",
    "     |     _-()|        | ",
    "_____|_        |        |_",
    "       -_      |          ",
    "         -_    |          ",
    "           -_  |          "
  };

  private static final String[] durvjuSp7 = {
    "    /|                  | ",
    "   / |                  | ",
    "  /  |                  | ",
    " /   |   --__     __--  | ",
    "/    |  ( O )  _  ( O ) | ",
    "|    |         V    _^_ | ",
    "|    | -^__      ^_|v ^ | ",
    "|  / | ^-V |__^_| v_^   | ",
    "|()  |    ^-vv_^- ^     | ",
    "|    |                  | ",
    "|    |                  |_",
    "|   /                     ",
    "|  /                      ",
    "| /                       "
  };

  private static final String[] durvisVala = {
    "    /|                  | ",
    "   / |                  | ",
    "  /  |                  | ",
    " /   |                  | ",
    "/    |                  | ",
    "|    |                  | ",
    "|    |                  | ",
    "|  / |                  | ",
    "|()  |                  | ",
    "|    |                  | ",
    "|    |                  |_",
    "|   /                     ",
    "|  /                      ",
    "| /                       "
  };

  // =========================================================================================== Virtuves spoks ======================================================================================= //
  private static final String[] izslegtsPagrabs = {
    K.TPELEKS + "░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET
  };
  
  private static final String[] virtuvesSp0 = {
    "---------------",
    "|---------------|",
    "| |-----------| |",
    "| | |-------| | |",
    "| | | |---| | | |",
    "| | | |   | | | |",
    "| | | |   | | | |",
    "| | | |___| | | |",
    "| | |_/___\\_| | |",
    "| |_/_______\\_| |",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp1 = {
    "---------------",
    "|---------------|",
    "| |-----------| |",
    "| | |-------| | |",
    "| | | |---| | | |",
    "| | | |.. | | | |",
    "| | | |   | | | |",
    "| | | |___| | | |",
    "| | |_/___\\_| | |",
    "| |_/_______\\_| |",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp2 = {
    "---------------",
    "|---------------|",
    "| |-----------| |",
    "| | |-------| | |",
    "| | | |---| | | |",
    "| | | |.. | | | |",
    "| | | |  -| | | |",
    "| | | |___| | | |",
    "| | |_/___\\_| | |",
    "| |_/_______\\_| |",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp3 = {
    "---------------",
    "|---------------|",
    "| |-----------| |",
    "| | |-------| | |",
    "| | | |---| | | |",
    "| | | |o o| | | |",
    "| | | |   | | | |",
    "| | | |___| | | |",
    "| | |_/___\\_| | |",
    "| |_/_______\\_| |",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp4 = {
    "---------------",
    "|---------------|",
    "| |-----------| |",
    "| | |-------| | |",
    "| | | -   _ | | |",
    "| | |( ) ( )| | |",
    "| | |  ~    | | |",
    "| | |  ___  | | |",
    "| | |_/___\\_| | |",
    "| |_/_______\\_| |",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp5 = {
    "---------------",
    "|---------------|",
    "| |-----------| |",
    "| | |-------| | |",
    "| | |-_   _-| | |",
    "| | |( ) ( )| | |",
    "| | |  ~    | | |",
    "| | |  ___  | | |",
    "| | |_/___\\_| | |",
    "| |_/_______\\_| |",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp6 = {
    "---------------",
    "|---------------|",
    "| |-----------| |",
    "| |  __    __ | |",
    "| | (  )  (  )| |",
    "| | =-\\_W_/-= | |",
    "| |    U      | |",
    "| |           | |",
    "| |  _______  | |",
    "| |_/_______\\_| |",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp7 = {
    "---------------",
    "|---------------|",
    "| |-----------| |",
    "| |\\__     __/| |",
    "| |(  )   (  )| |",
    "| | =-\\_W_/-= | |",
    "| |  ^-___-^  | |",
    "| |           | |",
    "| |  _______  | |",
    "| |_/_______\\_| |",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp8 = {
    "---------------",
    "|---------------|",
    "| ^          ^  |",
    "|/ \\________/ \\ |",
    "| ---__   __--- |",
    "| ( 0 )   ( 0 ) |",
    "|  ==\\__W__/==  |",
    "|       ~~~     |",
    "|   _ _        (>",
    "|  _v_v_______ (>",
    "|_/___________\\_|",
    "/               \\"
  };

  private static final String[] virtuvesSp9 = {
    "             ",
    "  \\           /  ",
    " ___\\       /___ ",
    "/   \\ \\/ \\/ /   \\",
    "|( )|       |( )|",
    "\\___/  ____ \\___/",
    "  ----_ VV _---- ",
    "   --- _/\\_ ---  ",
    "     ^V____V^    ",
    "  ___       ___  ",
    " _|||_______|||_ ",
    "/ v v       v v \\"
  };

  private static final String[] virtuvesSp10 = {
    K.TPELEKS + "░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░▒▒░░░░░▒▒░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET,
    K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET
  };

  // * Visu spoku fāzes izskatu masīvi.
  // Loga.
  public static final String[] [] logaSpokaBildesDurvjuIstaba = {durvjuLogsCiet, logaSpPieDurvim0, logaSpPieDurvim1, logaSpPieDurvim2, logaSpPieDurvim3, logaSpPieDurvim4, logaSpPieDurvim5, logaSpPieDurvim6, durvjuLogsVala};
  public static final String[] [] logaSpokaBildesDivanaIstaba = {divanaLogsCiet, logaSpPieDivana0, logaSpPieDivana1, logaSpPieDivana2, logaSpPieDivana3, logaSpPieDivana4, logaSpPieDivana5, logaSpPieDivana6, divanaLogsVala};
  public static final String[] [] logaSpokaBildesGultasIstaba = {gultasLogsCiet, logaSpPieGultas0, logaSpPieGultas1, logaSpPieGultas2, logaSpPieGultas3, logaSpPieGultas4, logaSpPieGultas5, logaSpPieGultas6, gultasLogsVala};
  public static final String[] [] logaSpokaBildesVirtuve = {virtuvesLogsCiet, logaSpPieVirtuves0, logaSpPieVirtuves1, logaSpPieVirtuves2, logaSpPieVirtuves3, logaSpPieVirtuves4, logaSpPieVirtuves5, logaSpPieVirtuves6, virtuvesLogsVala};

  // Durvju un virtuves.
  public static final String[] [] durvjuSpokaFazesBildes = {durvjuSp0, durvjuSp1, durvjuSp2, durvjuSp3, durvjuSp4, durvjuSp5, durvjuSp6, durvjuSp7, durvisVala , durvisCiet };
  public static final String[] [] virtuvesSpokaFazesBildes = {virtuvesSp0 , virtuvesSp1 , virtuvesSp2 , virtuvesSp3 , virtuvesSp4 , virtuvesSp5 , virtuvesSp6 , virtuvesSp7 , virtuvesSp8 , virtuvesSp9 , virtuvesSp10 , izslegtsPagrabs };

  // * Izveido masīvus, un liek tiem cita masīva ceļu, lai kad to izmanto, viņš neatgriež vērtību "null".
  // Loga spoka masīvi, kurus pielieto, katru savā istabā.
  public static String[] virtuvesLogaSpokaFazesBilde = SpokuIzskati.virtuvesLogsCiet; 
  public static String[] divanaLogaSpokaFazesBilde = SpokuIzskati.divanaLogsCiet; 
  public static String[] gultasLogaSpokaFazesBilde = SpokuIzskati.gultasLogsCiet; 
  public static String[] durvjuLogaSpokaFazesBilde = SpokuIzskati.durvjuLogsCiet; 

  // Durvju un virtuves spoka izskata masīvi.
  public static String[] virtPrieksasPagrabaBildesArSpoku = SpokuIzskati.virtuvesSp0;
  public static String[] durvjuSpokaFazesBilde = SpokuIzskati.durvisCiet;
}
  