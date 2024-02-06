package Spele.SpelesProcesi;

import Spele.IzvadeUzTerminalu;
import Spele.Spoki;
import Spele.Testi;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Izskati.EkranuIzskati;
import Spele.Varonis.VaronaDarbibas;
import Spele.Varonis.VaronaStatusaEfekti;

public class Main {
		// Mainīgie jeb objekti.
		public static volatile boolean programmaPalaista = true; // booleans, kas palaiž visu programmu.
		public static boolean sakumaEkrans = false; // Nosaka vai spēles sākumā rādīs sākuma ekrānu vai nē.
		public static volatile boolean spelePalaista = true; // Mainīgais bool, kas pašu spēli.

		public static boolean varonaNemirstiba = true; // Vai varonis var zaudēt spēli vai nē.
		static boolean kluduLasisana = false;
		public static boolean varonisDzivs = true;

		//* ////////////////////////////////////////////////// S P Ē L E S   I E S T A T Ī J U M I /////////////////////////////////////////////////////////////////

		// Gaismas dati.
		public static boolean[] istabuGaismasIeslegtas = {FailuRedigetajs.booleanDatuAtgriezejs("gultasGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("divanaGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("durvjuGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("virtuvesGaisma")}; // Indeksi: 0. Gulta, 1. Dīvāns, 2. Durvis, 3. Virtuve.
		static boolean spokiSledzAraGaismu = FailuRedigetajs.booleanDatuAtgriezejs("spokiSledzAraGaismu");
		public static boolean ieslegtaSkana = FailuRedigetajs.booleanDatuAtgriezejs("ieslegtaSkana");

		static int spelesNakts = 6;


		// Spelētāja pozīcija.
		public static int varonaIstabasSkaitlis = 3; // 0, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas.
		public static int varonaVirzienaSkaitlis = 0;

		public static boolean elektribaIeslegta = FailuRedigetajs.booleanDatuAtgriezejs("elektribaIeslegta");
		public static boolean pagrabaGaisma = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaisma");
		public static boolean pagrabaGaismaStrada = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaismaStrada");

		// Sērkociņa dati.
		public static int atlikusoSerkocinuDaudzums = FailuRedigetajs.intDatuAtgriezejs("atlikusoSerkocinuDaudzums");
		static int maxSerkocinaDegsanasLaiks = FailuRedigetajs.intDatuAtgriezejs("maxSerkocinaDegsanasLaiks");

		// Spoku dati.
		public static int logaSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("logaSpokaAgresivitatesLimits");
		public static int durvjuSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("durvjuSpokaAgresivitatesLimits");
		public static int virtuvesSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("virtuvesSpokaAgresivitatesLimits");

		static int logaSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("logaSpokaDrosibasRobezas");
		static int durvjuSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("durvjuSpokaDrosibasRobezas");
		static int virtuvesSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("virtuvesSpokaDrosibasRobezas");

		//* ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		static String[] visiVaronaUzdevumi = {"Pildit majasdarbus", "Est", "Mazgat", "Kartot", "Lasit", "Tirit"}; // TODO: Izmantot vai pārveidot.

		// Iestata tikšķa jeb 1 "refreša" periodu.
		static int framesPerSecond = 1000 / 25; // Pēc cik ilga laika ekrāns "refrešojas". (Milisekundēs)
		static int spelesIlgums = 360;// 6 min 360;

		public static void main(String[] args) throws InterruptedException {
				// Programmas sākums.
				// ! Testi.testaProgramma();

				//* /////// T H R E D I //////////
				// Jaunie rīki jeb thredi.
				Ievade ievadesLasitajs = new Ievade(); // Arī threads, bet šis lasa ievadi.
				SkanasSpeletajs skanasSpeletajs = new SkanasSpeletajs();

				// Sākas atsevišķās darbības jeb patstāvīgie procesi.
				skanasSpeletajs.start(); // Strādā, kamēr spelePalaista bools ir true.
				ievadesLasitajs.start(); // Strādā, kamēr programmaPalaista bools ir true.

				// * Palaiž programmu.
				while (programmaPalaista) {
						tiritEkranu();

						// * ////////////////////////////////////////////////////// S P Ē L E S   I Z V Ē L N E //////////////////////////////////////////////////////
						while (sakumaEkrans) {
								VaronaDarbibas.varonaDarbibas(Ievade.ievade);
								IzvadeUzTerminalu.masivuIzvade(EkranuIzskati.ekranuAtjaunosana()[0]);
								try { // Vienas bildes izvade jeb beigas.
										Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 30 FPS.
								} catch (Exception e) {}
						}

						tiritEkranu();
						Laiks laiks = new Laiks(); // Katru reizi, kad ir palaista spēle, veido jaunu Laika thredu.
						laiks.start(); // Strādā, kamēr spelePalaista bools ir true.

						// * /////////////////////////////////////////// S Ā K A S   S P Ē L E S   K O D S /////////////////////////////////////////////////////////////////////////////////////////
						while (spelePalaista) { // Kamēr laiks nav beidzies, turpināt ciklu jeb spēli.
								VaronaDarbibas.varonaDarbibas(Ievade.ievade); // Lietotāja jeb varoņa ievade un tās darbības (komandas un to darbības).
								VaronaStatusaEfekti.varonaStress();

								// Spoku informācijas izvade. --Debuging--
								if (Spoki.spokuInfoIzvadeBoolean) {
										Spoki.spokuInformacijasIzvade();
								}

								// Visām fāzēm, bildēm un visam vizuālajam ir jābūt gatavam pirms šīs metodes izsaukšanas!!!
								// Spoku vizuālais atjaunojums notiek Laiks.java Klasē.
								IzvadeUzTerminalu.salipinataUIIzvade(); // Izvade uz ekrāna.

								Ievade.notiritIevadi(); // Cikla beigās notīra Ievadi, jo visas matodes, kurām tā bija vajadzīga jau to ir paņēmušas.

								// Ja varona stresa līmenis pārsniedz 100, tad varonis iet bojā.
								if (VaronaStatusaEfekti.varonaStresaLimenis > 100.0) {
										VaronaStatusaEfekti.varonaBojaeja("stress");
								}

								try { // Vienas bildes izvade jeb beigas.
										Thread.sleep(framesPerSecond); // Spēle apstājas uz noteiktu brīdi. 30 FPS.
								} catch (Exception e) {
										// Kods ko pildīs, ja "try" kods izmetīs kļūdu.
								}

								if (kluduLasisana) { // Apstādina spēli, lai varētu izlasīt kļūdas aprakstu.
										Thread.sleep(100000);
								}
						}
						tiritEkranu();

						int skaitlis = 0;
						if (varonisDzivs) {
								// * Uzvaras ekrāns.
								while ((skaitlis++) < 5) {
										IzvadeUzTerminalu.masivuIzvade(EkranuIzskati.ekranuAtjaunosana()[2]);
										Thread.sleep(1000); // 1 sek.
								}
						}
						else {
								// * Zaudēšanas ekrāns.
								while ((skaitlis++) < 5) {
										IzvadeUzTerminalu.masivuIzvade(EkranuIzskati.ekranuAtjaunosana()[1]);
										Thread.sleep(1000); // 1 sek.
								}
						}

						// Apstādina Laika thredu un izveido jaunu, kad palaiž spēli.
						laiks.join(); // wait for the thread to stop
						Laiks.spelesLaiks = 0; // Lai laika threads momentāli neapstātos pēc tā pališanas, atjauno spēles laiku.
						sakumaEkrans = true;
						varonisDzivs = true;
				}
				//* ///////////////////// L I E K   T H R E D I E M   B E I G T I E S /////////////////////////
				skanasSpeletajs.join();
				ievadesLasitajs.join();
		}

		public static void tiritEkranu() {
				System.out.print("\033[H\033[2J"); // Notīra terminālu.
				System.out.flush(); // Kaut kas ar kursora pozīciju.
		}
}