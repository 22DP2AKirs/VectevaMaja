package Spele.Varonis;
import java.util.Arrays;

import Spele.SpelesProcesi.Main;
import Spele.Spoki.DurvjuSpoks;
// import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.VirtuvesSpoks;
import Spele.Enums;
import Spele.Enums.Istabas;
// import Spele.Spoki.VirtuvesSpoks;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Laiks;

public class VaronaDarbibas {
  public static int infoLapasSecibasSkaitlis = 1; // Nosaka vai varoņa ievade būs ar kustību saistīta vai ar darbu darbību saistīta.

  public static boolean aizdedzinatsSerkocins = false; 
  public static int serkocinaDeksanasLaikaSkaititajs;

  // Šie masīvi tiek pārbaudīti, lai labāk spētu noteikt, kāda darbība ir, kādai metodei.
  private static final String[] testesanasKomandas = { "I", "O", "P" , "SI", "MI", "EXIT", "POWER OFF", "KILL", "WIN"};
  private static final String[] parastasKomandas = {"F", "A", "W", "D", "1", "2", "3", "4"};



  public static void parastasDarbibas(String panemtaIevade) {
      if (panemtaIevade.equals("F") && IestatijumuDati.atlikusoSerkocinuDaudzums != 0 && !aizdedzinatsSerkocins) {
          if (Main.rand.nextInt(3) == 0) { // 33.33 % iespēja aizdedzināt sērkociņu.
            SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\lighting-matches.wav", 0);
            aizdedzinatsSerkocins = true;
            IestatijumuDati.atlikusoSerkocinuDaudzums--;
          } 
          else {
              SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\failing-to-lit-matches.wav", 0);
          }
      } 
      else if (panemtaIevade.equals("A")) { // Pagriezties pa kreisi.
          pagrieztiesPaKreisi();
      } 
      else if (panemtaIevade.equals("W")) { // Iet uz priekšu.
          ietUzPrieksu();
      } 
      else if (panemtaIevade.equals("D")) { // Pagriezties pa labi.
          pagrieztiesPaLabi();
      } 
      else if (panemtaIevade.equals("1")) { // Pārslēdz režīmu.
          infoLapasSecibasSkaitlis = 1;
      } 
      else if (panemtaIevade.equals("2")){
          infoLapasSecibasSkaitlis = 2;
      } 
      else if (panemtaIevade.equals("3")) {
          infoLapasSecibasSkaitlis = 3;
      } 
      else if (panemtaIevade.equals("4")) {
          infoLapasSecibasSkaitlis = 4;
      } 
  }


  public static void testesanasDarbibas(String panemtaIevade) {
    // * Metodē ir darbības, kuras ir domātas spēles testēšanai.

    // Spoku info. izvade.
    if (panemtaIevade.equals("SI")) {
      ieslegtIzslegtSpokuInformaciju();
    }
    // M-Spēļu info. izvade.
    else if (panemtaIevade.equals("MI")) {
      ieslegtIzslegtMspelesInformaciju();
    }
    else if (panemtaIevade.equals("I")) {
      DurvjuSpoks.durvjuSpoks.setSpokaAtputasLaikaMainamaKopija(0);
    }
    else if (panemtaIevade.equals("O")) {

    }
    else if (panemtaIevade.equals("P")) {

    }
    // Iziet no spēles.
    else if (panemtaIevade.equals("EXIT")) {
      Main.programmaPalaista = false;
      System.exit(0);
    }
    // Izslēdz mājas elektrību.
    else if (panemtaIevade.equals("POWER OFF")) {
      if(IestatijumuDati.elektribaIeslegta) {
        IestatijumuDati.elektribaIeslegta = false;
        Laiks.laiksCikIlgiElektribaBusIzslegta = 10;
      } 
      else {
        IestatijumuDati.elektribaIeslegta = true;
      }
    }
    // Novāc varoni.
    else if (panemtaIevade.equals("KILL")) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("PASNAVIBA");
    }
    // Uzvar spēli.
    else if (panemtaIevade.equals("WIN")) {
      Laiks.spelesLaiks = 1000;
    }
  }


  // * Darbības izsauktas pēc komandas:
  /// * Gultas darbības:
  public static void gultasPrieksasKomandas(String komanda) {
    if (komanda.equals("W")) {
      ietUzPrieksu(); ////////////////////////////////////////
    }
    else if (komanda.equals("G")) {
      ieslegtIzslegtIstabasGaismu(Istabas.GULTA);
    }
  }

  public static void gultasLabasPusesKomandas(String komanda) {
    if (komanda.equals("W")) {
      ietUzPrieksu(); ////////////////////////////////////////
    }
    else if (komanda.equals("E")) {
      izslegtElektribu();
    }
  }

  public static void gultasLejasKomandas(String komanda) {
    // Kods:
  }

  public static void gultasKreisasPusesKomandas(String komanda) {
    if (komanda.equals("LOGS")) {
      aizbiedetLogaSpoku(Istabas.GULTA);
    }
  }

  /// * Dīvāna darbības:
  public static void divanaPrieksasKomandas(String komanda) {
    if (komanda.equals("LOGS")) {
      aizbiedetLogaSpoku(Istabas.DIVANS);
    }
  }

  public static void divanaLabasPusesKomandas(String komanda) {
    if (komanda.equals("W")) {
      ietUzPrieksu(); ////////////////////////////////////////
    }
    else if (komanda.equals("G")) {
      ieslegtIzslegtIstabasGaismu(Istabas.DIVANS);
    }
  }

  public static void divanaLejasKomandas(String komanda) {
    if (komanda.equals("W")) {
      ietUzPrieksu(); ////////////////////////////////////////
    }
  }

  public static void divanaKreisasPusesKomandas(String komanda) {
    // Kods:
  }

  /// * Durvju darbības:
  public static void durvjuPrieksasKomandas(String komanda) {
    if (komanda.equals("LOGS")) {
      aizbiedetLogaSpoku(Istabas.DURVIS);
    }
  }

  public static void durvjuLabasPusesKomandas(String komanda) {
    if (komanda.equals("DURVIS")) {
      aizbiedetDurvjuSpoku();
    }
    else if (komanda.equals("E")) {
      // TODO: Karātavu palaišanas kods.
    }
  }

  public static void durvjuLejasKomandas(String komanda) {
    if (komanda.equals("W")) {
      ietUzPrieksu(); ////////////////////////////////////////
    }
    else if (komanda.equals("G")) {
      ieslegtIzslegtIstabasGaismu(Istabas.DURVIS);
    }
  }

  public static void durvjuKreisasPusesKomandas(String komanda) {
    if (komanda.equals("W")) {
      ietUzPrieksu(); ////////////////////////////////////////
    }
  }

  /// * Virtuves darbības.
  public static void virtuvesPrieksasKomandas(String komanda) {
    if (komanda.equals("W")) {
      ietUzPrieksu(); ////////////////////////////////////////
    }
  }

  public static void virtuvesLabasPusesKomandas(String komanda) {
    if (komanda.equals("LOGS")) {
      aizbiedetLogaSpoku(Istabas.VIRTUVE);
    }
  }

  public static void virtuvesLejasKomandas(String komanda) {
    // Ieslēgt izslēgt pagraba gaismu uz kom. 'G'.
  }

  public static void virtuvesKreisaPuseKomandas(String komanda) {
    if (komanda.equals("W")) {
      ietUzPrieksu(); ////////////////////////////////////////
    }
    else if (komanda.equals("G")) {
      ieslegtIzslegtIstabasGaismu(Istabas.VIRTUVE);
    }
  }
  



  // * Darbības kā metodes:
  public static void ieslegtIzslegtIstabasGaismu(Istabas istaba) {
    // Ja ir ieslēgta elektrība, tad var aiztikt lampas/istabu gaismas.
    if (IestatijumuDati.elektribaIeslegta) {
      if (IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS]) {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
        IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS] = false;
      } 
      else {
        SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
        IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS] = true;
      }
    }
  }

  public static void izslegtElektribu() { // Kad izslēdz elektrību nosaka, kādi iestatījumi vai mainīgie mainās.
    SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
    aizbiedetVirtuvesSpoku();

    Arrays.fill(IestatijumuDati.istabuGaismasIeslegtas, false); // Visās istabās izslēdz gaismu.

    IestatijumuDati.elektribaIeslegta = false;
    IestatijumuDati.stradaPagrabaGaisma = true; // Salabo pagraba gaismu.
    Laiks.laiksCikIlgiElektribaBusIzslegta = 3;
  }

  public static void ieslegtIzslegtMspelesInformaciju() {
    if (Main.mSpeluInfo) {
      Main.mSpeluInfo = false;
    } 
    else {
      Main.mSpeluInfo = true;
    }
    Main.tiritEkranu();
  }

  public static void ieslegtIzslegtSpokuInformaciju() {
    if (Main.spokuInfo) {
      Main.spokuInfo = false;
    } 
    else {
      Main.spokuInfo = true;
    }
    Main.tiritEkranu();
  }

  public static void aizbiedetLogaSpoku(Istabas istaba) {
    // Metode var būt izsaukta tikai tad, kad varonis skatās uz iespējamo loga spoka vietu (Visi logi).
    // 1. Pārbauda vai loga spoks ir varoņa aktuālajā istabā. 2. Pārbauda vai spoks ir ieslēgts jeb aktīvs.
    if (LogaSpoks.logaSpoks.getLSIstabu().equals(istaba.ISTABA) && LogaSpoks.logaSpoks.getSpoksIrAktivs()) {
      // Skaņa -->
      LogaSpoks.logaSpoks.deaktivizetSpoku();
    }
  }

  public static void aizbiedetVirtuvesSpoku() {
    if (VirtuvesSpoks.virtuvesSpoks.getSpoksIrAktivs()) {
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\spoks_krit_leja_pa_kapnem.wav", VirtuvesSpoks.virtuvesSpoks.getSpokaFazesIndekss() - 17);
      VirtuvesSpoks.virtuvesSpoks.deaktivizetSpoku();
    }
  }

  public static void aizbiedetDurvjuSpoku() {
    if (DurvjuSpoks.durvjuSpoks.getSpoksIrAktivs()) {
      // Skaņa -->
      DurvjuSpoks.durvjuSpoks.deaktivizetSpoku();
    }
  }

  public static void izietAraNoMspeles(String ievade) {
    if (Main.varonisIrMazajaSpele) {
      if (ievade.equals("Q")) {
        Main.varonisIrMazajaSpele = false;
      }
    }
  }





  

  

  public static void sakumaEkranaDarbibas(String panemtaIevade) {
    // * Šī metode nosaka, kādas darbības būs pieejamas sākuma ekrānā (Main screen), un to darbību izpilde.

    // Skatoties, kāda ir ievade, tāda būs darbība.
    if (panemtaIevade.equals("W")) {
      if (EkranuParklajumi.izvelnesCipars > 0) {
        EkranuParklajumi.izvelnesCipars--;
      }
    } 
    else if (panemtaIevade.equals("S")) {
      if (EkranuParklajumi.izvelnesCipars < 5) {
        EkranuParklajumi.izvelnesCipars++;
      }
    } 
    else if (panemtaIevade.equals("")) {
      if (EkranuParklajumi.izvelnesCipars == 0) {

      }
      else if (EkranuParklajumi.izvelnesCipars == 1) { // Spēlēt.
        Main.mainMenu = false;
        Main.spelePalaista = true;
      } 
      else if (EkranuParklajumi.izvelnesCipars == 2) {
      
      } 
      else if (EkranuParklajumi.izvelnesCipars == 3) {
      
      } 
      else if (EkranuParklajumi.izvelnesCipars == 4) {

      } 
      else if (EkranuParklajumi.izvelnesCipars == 5) {
        Main.programmaPalaista = false;
        System.exit(0); // Pārtrauc spēles darbību.
      } 
    }
    Ievade.notiritIevadi();
  }


  private static void pagrieztiesPaKreisi() {
    VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars--;
      if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars < 0) { // Lai masīvs neizietu no diapazonas.
        VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars = 3;
      }
  }


  private static void pagrieztiesPaLabi() {
    VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars++;
      if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars > 3) { // Lai masīvs neizietu no diapazonas.
        VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars = 0;
      }
  }


  private static void ietUzPrieksu() {  // Kustība pa māju.
      // Kopā mājā ir 4 istabas, kurās var iet iekšā gan pulksteņrādītāja virzienā, gan pret to.
      // 0. Gulta, 1. Dīvāna istaba, 2. Durvju istaba, 3. Virtuve.
      // Istabas virzieni:
      // 0. Priekša, 1. Labā puse, 2. Leja, 3. Kreisā puse.

      

      if (VaronaPozicijaUnSkataVirziens.varonaIstabasCipars == 0) {
          if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 0) {
            VaronaPozicijaUnSkataVirziens.varonaIstabasCipars++;
          } else if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 1) {
            VaronaPozicijaUnSkataVirziens.varonaIstabasCipars = 3; // Pret "pulksteņrādītāja secības" cikla: 0 -3- 2 1 0 -3- 2 1 0.
          }
      } else if (VaronaPozicijaUnSkataVirziens.varonaIstabasCipars == 1) {
          if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 1) { // Labās durvis.
            VaronaPozicijaUnSkataVirziens.varonaIstabasCipars++;
          } else if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 2) { // Lejas durvis.
            VaronaPozicijaUnSkataVirziens.varonaIstabasCipars--;
          }
      } else if (VaronaPozicijaUnSkataVirziens.varonaIstabasCipars == 2) {
          if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 2) { // Lejas durvis.
            VaronaPozicijaUnSkataVirziens.varonaIstabasCipars++;
          } else if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 3) { // Kreisās durvis.
            VaronaPozicijaUnSkataVirziens.varonaIstabasCipars--;
          }
      } else if (VaronaPozicijaUnSkataVirziens.varonaIstabasCipars == 3) {
          if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 3) {
            VaronaPozicijaUnSkataVirziens.varonaIstabasCipars = 0; //  Pēdējā no 4 istabām. Ciparam ir jāmainās pēc "pulksteņrādītāja secības" cikla: 0 1 2 3 -0- 1 2 3 -0-.
          } else if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 0) {
            VaronaPozicijaUnSkataVirziens.varonaIstabasCipars--;
          }
      }
  }
}