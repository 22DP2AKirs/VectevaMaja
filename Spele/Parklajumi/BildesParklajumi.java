package Spele.Parklajumi;
import java.util.Arrays;

import Spele.K;
import Spele.Spoki;
import Spele.Izskati.IstabuIzskati;
import Spele.Izskati.SpokuIzskati;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaDarbibas;

public class BildesParklajumi {

		// * Atgriež masīvu, kuru izvadīs terminālī (Pēdējā bildes apstrāde).
		// * Metode uz bildes saliek visus pārklājumus.
		public static String[] istabasArParklajumiem(String[] originalaisMasivs) {
				// Parametra masīva vērtību pārkopēšana un jauna masīva, lai nebojātu masīvu, kas ir sniegts kā parametrs.
				// kopija - drīkst mainīt, oriģinālā - NEDRĪKST MAINĪT.
				String[] varonaIstabasKopija = Arrays.copyOf(originalaisMasivs, originalaisMasivs.length); // Masīva elementu pārkopēšana. copyOf(kopējamaisMasīvs, cik elementus no masīva nokopēts)

				spokaParklajumuUzlicejs(varonaIstabasKopija);
				istabuParklajumuUzlicejs(varonaIstabasKopija);

				// Pagraba gaisma.
				if (Main.varonaIstabasSkaitlis == 3 && Main.varonaVirzienaSkaitlis == 2) {
					if (!Main.pagrabaGaisma && Spoki.spokuStati[2].spokaFazesIndeks < 11) {
						virtuvesPagrabaParklajs(varonaIstabasKopija, originalaisMasivs);
					}
				}

				// izslegtasIstabasGaismasParklajiNoCitam(varonaIstabasKopija);

				istabasGaismasUnSerkocinaParklajumi(varonaIstabasKopija, originalaisMasivs);

				return varonaIstabasKopija;
		}

	// * Metode uz masīva uzliks visus pārklājumus ar spoka fāzēm.
	private static void spokaParklajumuUzlicejs(String[] mainamaisMasivs) {
		// Virtuve ar skatu uz izlietni.
		if (Main.varonaIstabasSkaitlis == 3 && Main.varonaVirzienaSkaitlis == 2) {
			// Pie masīva kopijas pievieno spoka fāzes bildi.
			for (int i = 1; i - 1 < SpokuIzskati.virtPrieksasPagrabaBildesArSpoku.length; i++) { // i - 1, lai sāktu skaitīšanu no 0. rindas.
				mainamaisMasivs[i] += "\033[8G" + SpokuIzskati.virtPrieksasPagrabaBildesArSpoku[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
			}
		}
		// Virtuve ar skatu uz logu.
		else if (Main.varonaIstabasSkaitlis == 3 && Main.varonaVirzienaSkaitlis == 1) {
			// Pie masīva kopijas pievieno spoka fāzes bildi.
			for (int i = 3; i - 3 < SpokuIzskati.virtuvesLogaSpokaFazesBilde.length; i++) { // i - 1, lai sāktu skaitīšanu no 0. rindas.
				mainamaisMasivs[i] += "\033[35G" + SpokuIzskati.virtuvesLogaSpokaFazesBilde[i - 3] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
			}
		}
		// Gulta ar skatu uz logu.
		else if (Main.varonaIstabasSkaitlis == 0 && Main.varonaVirzienaSkaitlis == 3) {
			for (int i = 1; i - 1 < SpokuIzskati.gultasLogaSpokaFazesBilde.length; i++) {
				mainamaisMasivs[i] += "\033[40G" + SpokuIzskati.gultasLogaSpokaFazesBilde[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
			}
		}
		// Divans ar skatu uz logu.
		else if (Main.varonaIstabasSkaitlis == 1 && Main.varonaVirzienaSkaitlis == 0) {
			for (int i = 1; i - 1 < SpokuIzskati.divanaLogaSpokaFazesBilde.length; i++) {
				mainamaisMasivs[i] += "\033[26G" + SpokuIzskati.divanaLogaSpokaFazesBilde[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
			}
		}
		// Durvis ar skatu uz logu.
		else if (Main.varonaIstabasSkaitlis == 2 && Main.varonaVirzienaSkaitlis == 0) {
			for (int i = 1; i - 1 < SpokuIzskati.durvjuLogaSpokaFazesBilde.length; i++) {
				mainamaisMasivs[i] += "\033[18G" + SpokuIzskati.durvjuLogaSpokaFazesBilde[i - 1] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -1, jo i = mainamāMasīva kārtas rinda. i - 1 = sākt rediģēšanu no otrās rindas.
			}
		}
		// Durvis ar skatu uz durvīm...
		else if (Main.varonaIstabasSkaitlis == 2 && Main.varonaVirzienaSkaitlis == 1) {
			for (int i = 2; i - 2 < SpokuIzskati.durSpokaFazesBilde.length; i++) {
				mainamaisMasivs[i] += "\033[40G" + SpokuIzskati.durSpokaFazesBilde[i - 2] + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // -2, jo i = mainamāMasīva kārtas rinda. i - 2 = sākt rediģēšanu no otrās rindas.
			}
		}
	}

	// * Metode uz masīva uzliks visus pārklājumus ar istabu stāvokļiem.
	private static void istabuParklajumuUzlicejs(String[] mainamaisMasivs) {
		// * Nosaka varona atrasanās vietu.
		// 0. Gulta. ; Prieksa.
		// 1. Dīvāns. ; Laba puse.
		// 2. Durvis. ; Leja.
		// 3. Virtuve. ; Kreisa puse.

		// * Nosaka, kurā no blakus esošajām istabām ir izslēgta gaisma.
		// ^ - Skats uz priekšu.
		// < - Skata kreisā puse.
		// > - Skata labā puse.

		// * Gulta.
		if (Main.varonaIstabasSkaitlis == 0) {
			// ? Priekša.
			if (Main.varonaVirzienaSkaitlis == 0) {
				// ^
				if (!Main.istabuGaismasIeslegtas[1]) {
					for (int i = 1; i < 13; i++) {
						mainamaisMasivs[i] += "\033[45G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					}
				}
			}
			// ? Labā puse.
			else if (Main.varonaVirzienaSkaitlis == 1) {
				// <
				String[] gultasLabasPusesKreisaPuse = new String[4];
				if (!Main.istabuGaismasIeslegtas[1]) {
					gultasLabasPusesKreisaPuse[0] = "\033[5G" + K.TPELEKS + "░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					gultasLabasPusesKreisaPuse[1] = "\033[4G" + K.TPELEKS + "░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					gultasLabasPusesKreisaPuse[2] = "\033[3G" + K.TPELEKS + "░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					gultasLabasPusesKreisaPuse[3] = "\033[2G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}
				else {
					gultasLabasPusesKreisaPuse[0] = "\033[5G" + "     " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					gultasLabasPusesKreisaPuse[1] = "\033[4G" + "       " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					gultasLabasPusesKreisaPuse[2] = "\033[3G" + "        " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					gultasLabasPusesKreisaPuse[3] = "\033[2G" + "         " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}

				mainamaisMasivs[2] += gultasLabasPusesKreisaPuse[0];
				mainamaisMasivs[3] += gultasLabasPusesKreisaPuse[1];
				mainamaisMasivs[4] += gultasLabasPusesKreisaPuse[2];
				for (int i = 5; i < K.BILDES_MASIVA_IZMERS; i++) {
					mainamaisMasivs[i] += gultasLabasPusesKreisaPuse[3];
				}

				// ^
				if (!Main.istabuGaismasIeslegtas[3]) {
					for (int i = 1; i < 13; i++) {
						mainamaisMasivs[i] += "\033[39G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					}
				}
      }
			// ? Leja.
			else if (Main.varonaVirzienaSkaitlis == 2) {
				// <
				String[] gultasLejasKreisaPuse = new String[2];
				if (!Main.istabuGaismasIeslegtas[3]) {
					gultasLejasKreisaPuse[0] = "\033[2G" + K.TPELEKS + "░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					gultasLejasKreisaPuse[1] = "\033[2G" + K.TPELEKS + "░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}
				else {
					gultasLejasKreisaPuse[0] = "\033[2G" + "  " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					gultasLejasKreisaPuse[1] = "\033[2G" + "   " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}

				mainamaisMasivs[2] += gultasLejasKreisaPuse[0];
				for (int i = 3; i < K.BILDES_MASIVA_IZMERS; i++) {
					mainamaisMasivs[i] += gultasLejasKreisaPuse[1];
				}
			}
		}
		// * Dīvāns.
		else if (Main.varonaIstabasSkaitlis == 1) {
			// ? Labā puse.
			if (Main.varonaVirzienaSkaitlis == 1) {
				if (!Main.istabuGaismasIeslegtas[2]) {
					mainamaisMasivs[2] += "\033[57G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[1] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					for (int i = 3; i < 13; i++) {
						mainamaisMasivs[i] += "\033[55G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					}
				}
			}
			// ? Leja.
			else if (Main.varonaVirzienaSkaitlis == 2) {
				// ^
				if (!Main.istabuGaismasIeslegtas[0]){
					for (int i = 1; i < 13; i++) {
						mainamaisMasivs[i] += "\033[23G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					}
				}

				// <
				String[] divanaLejasKreisaPuse = new String[5];
				if (!Main.istabuGaismasIeslegtas[2]) {
					divanaLejasKreisaPuse[0] = "\033[6G" + K.TPELEKS + "░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					divanaLejasKreisaPuse[1] = K.TPELEKS + "░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					divanaLejasKreisaPuse[2] = "\033[4G" + K.TPELEKS + "░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA; // Dīvaini 4 atstarpju bīdējumi??????
					divanaLejasKreisaPuse[3] = "\033[3G" + K.TPELEKS + "░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					divanaLejasKreisaPuse[4] = "\033[2G" + K.TPELEKS + "░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}
				else {
					divanaLejasKreisaPuse[0] = "\033[6G" + "      " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					divanaLejasKreisaPuse[1] = "       " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					divanaLejasKreisaPuse[2] = "\033[4G" + "        " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					divanaLejasKreisaPuse[3] = "\033[3G" + "         " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
					divanaLejasKreisaPuse[4] = "\033[2G" + "          " + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}

				mainamaisMasivs[3] += divanaLejasKreisaPuse[0];
				mainamaisMasivs[4] += "\033[5G" + divanaLejasKreisaPuse[1];
				mainamaisMasivs[5] += divanaLejasKreisaPuse[2];
				mainamaisMasivs[6] += divanaLejasKreisaPuse[3];
				for (int i = 7; i < K.BILDES_MASIVA_IZMERS - 1; i++) {
					mainamaisMasivs[i] += divanaLejasKreisaPuse[4];
				}
				mainamaisMasivs[15] += "\033[2G" +  divanaLejasKreisaPuse[1];
			}
			
			
		}
		// * Durvis.
		else if (Main.varonaIstabasSkaitlis == 2) {
			// ^
			if (!Main.istabuGaismasIeslegtas[3] && Main.varonaVirzienaSkaitlis == 2) {
				for (int i = 2; i < 13; i++) {
					mainamaisMasivs[i] += "\033[20G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}
			}
			// ^
			else if (!Main.istabuGaismasIeslegtas[1] && Main.varonaVirzienaSkaitlis == 3){
				mainamaisMasivs[1] += "\033[24G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[1] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				for (int i = 2; i < 13; i++) {
					mainamaisMasivs[i] += "\033[22G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}
			}
		}
		// * Virtuve.
		else if (Main.varonaIstabasSkaitlis == 3) {
			// ^
			if (!Main.istabuGaismasIeslegtas[2] && Main.varonaVirzienaSkaitlis == 0){
				for (int i = 2; i < 13; i++) {
					mainamaisMasivs[i] += "\033[48G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}
			}
			// ^
			else if (!Main.istabuGaismasIeslegtas[0] && Main.varonaVirzienaSkaitlis == 3) {
				for (int i = 1; i < 13; i++) {
					mainamaisMasivs[i] += "\033[26G" + K.TPELEKS + IstabuIzskati.arkuGaismasAizpilditajs[0] + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				}
			}
		}
	}
	
	


	// 	private static String[] izslegtasIstabasGaismasParklajiNoCitam(String[] aizpildamaisMasivs) {
			
	// }





		// * Pārbauda istabu, kurā ir varonis, un nosaka vai gaisma tanī būs ieslēgta vai izslēgta, tas pats ar sērkociņu.
		public static String[] istabasGaismasUnSerkocinaParklajumi(String[] mainamaisMasivs, String[] originalaisMasivs) {
				if (!Main.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && !VaronaDarbibas.aizdedzinatsSerkocins) { // Ja gaismas nav, un sērkocins nav aizdedzināts. 0 0
						istabaArIzslegtuGaismu(mainamaisMasivs);
				}
				else if (!Main.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && VaronaDarbibas.aizdedzinatsSerkocins) { // Ja gaismas nav, un aizdedzināts sērkocins. 0 1
						tumsaIstabaArAizdedzinatuSerkocinu(mainamaisMasivs, originalaisMasivs);
				}
				else if (Main.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && VaronaDarbibas.aizdedzinatsSerkocins) { // Ja ir gaisma, un aizdedzināts sērkocins. 1 1
						serkocinaPieliksanaPieBildes(mainamaisMasivs);
				}

				return mainamaisMasivs;
		}

		// * Pie apstrādjamā masīva pieliek ar sērkociņu apgaismoto laukumu.
		public static String[] tumsaIstabaArAizdedzinatuSerkocinu(String[] apstradajamaisMasivs, String[] originalaisMasivs) {
				istabaArIzslegtuGaismu(apstradajamaisMasivs);
				apstradajamaisMasivs[8] = K.TPELEKS + originalaisMasivs[8] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[70G░░░░░░░░░░░░" + K.RESET;
				apstradajamaisMasivs[9] = K.TPELEKS + originalaisMasivs[9] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[73G░░░░░░░░░" + K.RESET;
				apstradajamaisMasivs[10] = K.TPELEKS + originalaisMasivs[10] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[76G░░░░░░" + K.RESET;
				apstradajamaisMasivs[11] = K.TPELEKS + originalaisMasivs[11] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[79G░░░" + K.RESET;
				apstradajamaisMasivs[12] = K.TPELEKS + originalaisMasivs[12] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
				apstradajamaisMasivs[13] = K.TPELEKS + originalaisMasivs[13] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
				apstradajamaisMasivs[14] = K.TPELEKS + originalaisMasivs[14] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
				apstradajamaisMasivs[15] = K.TPELEKS + originalaisMasivs[15] + K.RESET + "\r|" + K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.TPELEKS + "\033[80G░░" + K.RESET;
				serkocinaPieliksanaPieBildes(apstradajamaisMasivs);

				return apstradajamaisMasivs;
		}


		public static String[] serkocinaPieliksanaPieBildes(String[] apstradajamaisMasivs) {
				apstradajamaisMasivs[11] += serkocinaIzskats[0];
				apstradajamaisMasivs[12] += serkocinaIzskats[1];
				apstradajamaisMasivs[13] += serkocinaIzskats[2];
				apstradajamaisMasivs[14] += serkocinaIzskats[3];
				apstradajamaisMasivs[15] += serkocinaIzskats[4];

				return apstradajamaisMasivs;
		}


		public static String[] serkocinaIzskats = {
				// Ja apstrādāto līniju pārdefinē ar sērkociņu, tad pārdefinētā līnija neatjaunosies iepriekšējā ciklā "Iegūst neapstrādāto bildi". Būs statiska bilde ar sērkociņu klāt un nodzēstu galu.
				// Ja apstrādātai līnijai pieliks klāt sērkociņu, tad pārveidotā līnija tiks atjaunot, bet būs ar nodzēstu galu.
				// \r nepalīdz atstāt galu.
				// Pieliekot RESET vai krāsas maiņu arī nepalīdz.

				// * Pieliekot beigās ANSI \033[#G kodu (Pārvietot rakstīšanas kursoru uz # kolonnu) ar # esot visa teksta līnijas beigas (arī aiz sērkociņa) nenodzēsa tālākos tekstu. !!!!!!!!!
				// K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA

				"\033[61G" + K.DZELTENS + "/\\_" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
				"\033[60G"+ K.ORANZS + "/   \\" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
				"\033[60G" + K.SARKANS + "| O  |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
				"\033[61G" + K.SARKANS + "'-\\'" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
				"\033[64G" + K.BRUNS + "\\" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA
		};


		public static String[] istabaArIzslegtuGaismu(String[] aizpildamaisMasivs) {
				Arrays.fill(aizpildamaisMasivs, K.TPELEKS + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + K.RESET); // Aizpilda visus masīva indeksus ar vienu un to pašu elementu.

				return aizpildamaisMasivs;
		}

		public static String[] virtuvesPagrabaParklajs(String[] parklajamaisMasivs, String[] originalaisMasivs) {
				// Nosaka, ko izvadīs, ja pagramba gaisma ir izslēgta.
				parklajamaisMasivs[1] += "\033[10G" + K.TPELEKS + "░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[2] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[3] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[4] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[5] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[6] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[7] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[8] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[9] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[10] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[11] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;
				parklajamaisMasivs[12] += "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA;

				return parklajamaisMasivs;
		}

		
}
