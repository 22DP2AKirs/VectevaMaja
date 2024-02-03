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
	public static final String[] divanaLogsCiet = {
		"| | .  \\        .     /   || |",
		"| |    .     .   /        || |",
		"| |    \\         .  /  /  || |",
		"| |     .               . || |",
		"| |. /     /        .  \\  || |",
		"| |_______________________|| |"
	};

	public static final String[] logaSpPieDivana0 = {
		"| | .  \\        .     /   || |",
		"| |    .     .   /        || |",
		"| |    \\         .  /  /  || |",
		"| |     .      ..       . || |",
		"| |. /     /        .  \\  || |",
		"| |_______________________|| |"
	};

	public static final String[] logaSpPieDivana1 = {
		"| | .  \\        .     /   || |",
		"| |    .     .   /        || |",
		"| |    \\         .  /  /  || |",
		"| |     .    o   o      . || |",
		"| |. /     /        .  \\  || |",
		"| |_______________________|| |"
	};

	public static final String[] logaSpPieDivana2 = {
		"| | .  \\        .     /   || |",
		"| |    .     .   /        || |",
		"| |    \\   ^   ^ .  /  /  || |",
		"| |     .    O  _O      . || |",
		"| |. /     /   v-v  .  \\  || |",
		"| |_______________________|| |"
	};

	public static final String[] logaSpPieDivana3 = {
		"| | .  \\        .     /   || |",
		"| |    .     .   /        || |",
		"| |    \\       ^  .^/  /  || |",
		"| |     .       ( )_( ) .(|| |",
		"| |. /     /      V--V \\ (|| |",
		"| |_______________________|| |"
	};

	public static final String[] logaSpPieDivana4 = {
		"| | .  \\        .     |    | |",
		"| |    .     .   /    |    | |",
		"| |    \\          . / |(O) | |",
		"| |     .            (|    | |",
		"| |. /     /         (|    | |",
		"| |___________________|____| |"
	};

	public static final String[] logaSpPieDivana5 = {
		"| | .  \\        .  |       | |",
		"| |    .     .   / |       | |",
		"| |    \\          .|(O) (O)| |",
		"| |     .         (|       | |",
		"| |. /     /      (|       | |",
		"| |________________|_______| |"
	};

	public static final String[] logaSpPieDivana6 = {
		"| | .  \\     |  ^       ^  | |",
		"| |    .     | / \\ ___ / \\ | |",
		"| |    \\     | \\ (O)_(O) / | |",
		"| |     .    |  -\\ _V_ /-  | |",
		"| |. /     / |   ^V-~-V^   | |",
		"| |__________|_mn_^___^_nm_| |"
	};

	public static final String[] divanaLogsVala = {
		"| | .  \\     |             | |",
		"| |    .     |             | |",
		"| |    \\     |             | |",
		"| |     .    |             | |",
		"| |. /     / |             | |",
		"| |__________|_____________| |"
	};

	// -------------------------------------------------------------------------------- Loga spoks pie durvīm -------------------------------------------------------------------------------- //
	public static final String[] durvjuLogsCiet = {
		"| |       /            \\\\     || |",
		"| |          |           .    || |",
		"| |   \\\\                      || |",
		"| |      .   \\         /      || |",
		"| |           .          /    || |",
		"| |     /           \\         || |",
		"| |___________________________|| |"
	};

	public static final String[] logaSpPieDurvim0 = {
		"| |       /            \\\\     || |",
		"| |          |           .    || |",
		"| |   \\\\                      || |",
		"| |      .   \\         /      || |",
		"| |           .          /    || |",
		"| |     /       ..  \\         || |",
		"| |___________________________|| |"
	};

	public static final String[] logaSpPieDurvim1 = {
		"| |       /            \\\\     || |",
		"| |          |           .    || |",
		"| |   \\\\                      || |",
		"| |      .   \\         /      || |",
		"| |           .          /    || |",
		"| |     /       o o \\         || |",
		"| |___________________________|| |"
	};

	public static final String[] logaSpPieDurvim2 = {
		"| |       /            \\\\     || |",
		"| |          |           .    || |",
		"| |   \\\\                      || |",
		"| |      .   \\         /      || |",
		"| |           .          /    || |",
		"| |     /       O  O\\         || |",
		"| |___________________________|| |"
	};

	public static final String[] logaSpPieDurvim3 = {
		"| |       /            \\\\     || |",
		"| |          |           .    || |",
		"| |   \\\\       ^   ^          || |",
		"| |      .   \\  O _ O  /      || |",
		"| |           .   v v    /    || |",
		"| |     /           \\         || |",
		"| |___________________________|| |"
	};

	public static final String[] logaSpPieDurvim4 = {
		"| |       /            \\\\     || |",
		"| |          |           .    || |",
		"| |   \\\\              ( ) ( ) || |",
		"| |      .   \\         /      || |",
		"| |           .          /   (|| |",
		"| |     /           \\        (|| |",
		"| |___________________________|| |"
	};

	public static final String[] logaSpPieDurvim5 = {
		"| |       /            \\\\ |  ^ | |",
		"| |          |           .|   \\| |",
		"| |   \\\\              ( ) |(O) | |",
		"| |      .   \\         /  | v- | |",
		"| |           .          (| ^  | |",
		"| |     /           \\    (|    | |",
		"| |_______________________|____| |"
	};

	public static final String[] logaSpPieDurvim6 = {
		"| |       /      |  ^       ^  | |",
		"| |          |   | / \\ ___ / \\ | |",
		"| |   \\\\         | \\ (O)_(O) / | |",
		"| |      .   \\   |  -\\ _V_ /-  | |",
		"| |           .  |   ^V-~-V^   | |",
		"| |     /        |  _ ^   ^ _  | |",
		"| |______________|_|_|_____|_|_| |"
	};

	public static final String[] durvjuLogsVala = {
		"| |       /      |             | |",
		"| |          |   |             | |",
		"| |   \\\\         |             | |",
		"| |      .   \\   |             | |",
		"| |           .  |             | |",
		"| |     /        |             | |",
		"| |______________|_____________| |"
	};

	// =============================================================================== Durvju spoks ======================================================================================= //
	public static final String[] durvisCiet = {
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

	public static final String[] durvjuSp0 = {
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

	public static final String[] durvjuSp1 = {
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

	public static final String[] durvjuSp2 = {
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

	public static final String[] durvjuSp3 = {
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
	
	public static final String[] durvjuSp4 = {
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

	public static final String[] durvjuSp5 = {
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

	public static final String[] durvjuSp6 = {
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

	public static final String[] durvjuSp7 = {
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

	public static final String[] durvisVala = {
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
	public static final String[] ieslegtaPagrabaGaisma = {
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

	public static final String[] virtuvesSp0 = {
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

	public static final String[] virtuvesSp1 = {
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

	public static final String[] virtuvesSp2 = {
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

	public static final String[] virtuvesSp3 = {
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

	public static final String[] virtuvesSp4 = {
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

	public static final String[] virtuvesSp5 = {
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

	public static final String[] virtuvesSp6 = {
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

	public static final String[] virtuvesSp7 = {
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

	public static final String[] virtuvesSp8 = {
		"--           ",
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

	public static final String[] virtuvesSp9 = {
		K.TPELEKS + "--░░░░░░░░░░░" + K.RESET,
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
	public static final String[] [] logaSpokaSkatiPieDurvim = {durvjuLogsCiet, logaSpPieDurvim0, logaSpPieDurvim1, logaSpPieDurvim2, logaSpPieDurvim3, logaSpPieDurvim4, logaSpPieDurvim5, logaSpPieDurvim6, durvjuLogsVala};
	public static final String[] [] logaSpokaSkatiPieDivana = {divanaLogsCiet, logaSpPieDivana0, logaSpPieDivana1, logaSpPieDivana2, logaSpPieDivana3, logaSpPieDivana4, logaSpPieDivana5, logaSpPieDivana6, divanaLogsVala};
	public static final String[] [] logaSpokaSkatiPieGultas = {gultasLogsCiet, logaSpPieGultas0, logaSpPieGultas1, logaSpPieGultas2, logaSpPieGultas3, logaSpPieGultas4, logaSpPieGultas5, logaSpPieGultas6, gultasLogsVala};
	public static final String[] [] logaSpokaSkatiPieVirtuves = {virtuvesLogsCiet, logaSpPieVirtuves0, logaSpPieVirtuves1, logaSpPieVirtuves2, logaSpPieVirtuves3, logaSpPieVirtuves4, logaSpPieVirtuves5, logaSpPieVirtuves6, virtuvesLogsVala};

	// Durvju un virtuves.
	public static final String[] [] durvjuSpokaIzskati = {durvisCiet, durvjuSp0, durvjuSp1, durvjuSp2, durvjuSp3, durvjuSp4, durvjuSp5, durvjuSp6, durvjuSp7, durvisVala};
	public static final String[] [] virtuvesSpokaIzskati = {ieslegtaPagrabaGaisma, virtuvesSp0, virtuvesSp1, virtuvesSp2, virtuvesSp3, virtuvesSp4, virtuvesSp5, virtuvesSp6, virtuvesSp7, virtuvesSp8, virtuvesSp9};

	// * Izveido masīvus, un liek tiem cita masīva ceļu, lai kad to izmanto, viņš neatgriež vērtību "null".
	// Loga spoka masīvi, kurus pielieto, katru savā istabā.
	public static String[] virtuvesLogaSpokaFazesBilde = SpokuIzskati.virtuvesLogsCiet; 
	public static String[] divanaLogaSpokaFazesBilde = SpokuIzskati.divanaLogsCiet; 
	public static String[] gultasLogaSpokaFazesBilde = SpokuIzskati.gultasLogsCiet; 
	public static String[] durvjuLogaSpokaFazesBilde = SpokuIzskati.durvjuLogsCiet; 

	// Durvju un virtuves spoka izskata masīvi.
	public static String[] virtPrieksasPagrabaBildesArSpoku = SpokuIzskati.virtuvesSp0;
	public static String[] durSpokaFazesBilde = SpokuIzskati.durvisCiet;
}
	