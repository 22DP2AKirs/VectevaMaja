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
  
  public static void apstradatKomandu(String lietotajaIevade) {
    // * Metode ievāc lietotāja ievadi un nosaka atbilstošo darbību.
    // Garantē, lai lietotāja ievade tiktu izpildīta, pirms tā ir nodzēsta ar notiritIevadi().
    if (!Ievade.vaiIevadiIzpildija) { 
      Ievade.vaiIevadiIzpildija = true;
    }

    // Iziet ārā no m-spēles.
    if (Main.varonisIrMazajaSpele) {
      if (lietotajaIevade.equals("Q")) {
        Main.varonisIrMazajaSpele = false;
      }
    }
    // Ja ievades nebija, tad nepārbauda pārējās komandas.
    else if (!lietotajaIevade.equals("}")) {
      // Darbības jeb komandas pareizai situācijai.
      if (Main.mainMenu) {
        sakumaEkranaDarbibas(lietotajaIevade);
      } 
      else if (Main.spelePalaista) {
        if (Arrays.asList(testesanasKomandas).contains(lietotajaIevade)) {
          testesanasDarbibas(lietotajaIevade);
        }
        else if (Arrays.asList(parastasKomandas).contains(lietotajaIevade)) {
          parastasDarbibas(lietotajaIevade);
        }
        else if (Main.varonaIstabasSkaitlis == 0) { // Gultas darbības.
          pilditGultasDarbibas(lietotajaIevade);
        }
        else if (Main.varonaIstabasSkaitlis == 1) { // Divana darbības.
          pilditDivanaDarbibas(lietotajaIevade);
        }
        else if (Main.varonaIstabasSkaitlis == 2) { // Durvju darbības.
          pilditDurvjuDarbibas(lietotajaIevade);
        }
        else if (Main.varonaIstabasSkaitlis == 3) { // Virtuves darbības.
          pilditVirtuvesDarbibas(lietotajaIevade);
        }
      }
    }
  }


  private static void parastasDarbibas(String panemtaIevade) {
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


  private static void testesanasDarbibas(String panemtaIevade) {
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

  // * Darbības kā metodes:
  public void ieslegtIzslegtIstabasGaismu(Istabas istaba) {
    if (IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS]) {
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
      IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS] = false;
    } 
    else {
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
      IestatijumuDati.istabuGaismasIeslegtas[istaba.CIPARS] = true;
    }
  }

  public void izslegtElektribu() { // Kad izslēdz elektrību nosaka, kādi iestatījumi vai mainīgie mainās.
    SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
    VirtuvesSpoks.virtuvesSpoks.deaktivizetSpoku();

    Arrays.fill(IestatijumuDati.istabuGaismasIeslegtas, false); // Visās istabās izslēdz gaismu.

    IestatijumuDati.elektribaIeslegta = false;
    IestatijumuDati.stradaPagrabaGaisma = true; // Salabo pagraba gaismu.
    Laiks.laiksCikIlgiElektribaBusIzslegta = 3;
  }

  public void ieslegtIzslegtMspelesInformaciju() {
    if (Main.mSpeluInfo) {
      Main.mSpeluInfo = false;
    } 
    else {
      Main.mSpeluInfo = true;
    }
    Main.tiritEkranu();
  }

  public void ieslegtIzslegtSpokuInformaciju() {
    if (Main.spokuInfo) {
      Main.spokuInfo = false;
    } 
    else {
      Main.spokuInfo = true;
    }
    Main.tiritEkranu();
  }





  private static void pilditVirtuvesDarbibas(String panemtaIevade) {
    if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
      if (panemtaIevade.equals("LOGS") && LogaSpoks.logaSpoks.getLSIstabu().equals("VIRTUVE") && LogaSpoks.logaSpoks.getSpoksIrAktivs()) {
        LogaSpoks.logaSpoks.deaktivizetSpoku();
      }
    }
    else if (Main.varonaVirzienaSkaitlis == 2) {
    //   if (panemtaIevade.equals("G") && VirtuvesSpoks.virtuvesSpoks.getSpokaFazesIndekss() < 10) {
    //     if (IestatijumuDati.pagrabaGaisma) {
    //       SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
    //       IestatijumuDati.pagrabaGaisma = false;
    //     }
    //     else {
    //       SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
    //       IestatijumuDati.pagrabaGaisma = true;
    //     }
    //   }
    }
    else if (Main.varonaVirzienaSkaitlis == 3) { // Kreisās puses darbības.
      if (panemtaIevade.equals("G") && IestatijumuDati.elektribaIeslegta) {
        
      }
    }
  }


  private static void pilditDurvjuDarbibas(String panemtaIevade) {
    if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
      if (panemtaIevade.equals("LOGS") && LogaSpoks.logaSpoks.getLSIstabu().equals("DURVIS") && LogaSpoks.logaSpoks.getSpoksIrAktivs()) {
        LogaSpoks.logaSpoks.deaktivizetSpoku();
      }
    }
    else if (Main.varonaVirzienaSkaitlis == 1) {
    //   if (panemtaIevade.equals("DURVIS") && !DurvjuSpoks.durvjuSpoks.getSpoksIrAizbiedets()) {
    //     DurvjuSpoks.durvjuSpoks.izslegtSpoku();
    //   }
    //   else if (panemtaIevade.equals("E") && Main.karatavas) {
    //     SavienotaisKaratavuKods.palaistKaratavas();
    //   }
    }
    else if (Main.varonaVirzienaSkaitlis == 2) { // Lejas darbības.
      if (panemtaIevade.equals("G") && IestatijumuDati.elektribaIeslegta) {
        if (IestatijumuDati.istabuGaismasIeslegtas[2]) {
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
          IestatijumuDati.istabuGaismasIeslegtas[2] = false;
        } 
        else {
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
          IestatijumuDati.istabuGaismasIeslegtas[2] = true;
        }
      }
    }
  }


  private static void pilditDivanaDarbibas(String panemtaIevade) {
      if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
          if (panemtaIevade.equals("LOGS") && LogaSpoks.logaSpoks.getLSIstabu().equals("DIVANS") && LogaSpoks.logaSpoks.getSpoksIrAktivs()) {
            LogaSpoks.logaSpoks.deaktivizetSpoku();
          }
      }
      else if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
          if (panemtaIevade.equals("G") && IestatijumuDati.elektribaIeslegta) {
              if (IestatijumuDati.istabuGaismasIeslegtas[1]) {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
                  IestatijumuDati.istabuGaismasIeslegtas[1] = false;
              } 
              else {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
                  IestatijumuDati.istabuGaismasIeslegtas[1] = true;
              }
          }
          
      }
  }


  private static void pilditGultasDarbibas(String panemtaIevade) {
    if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
      if (panemtaIevade.equals("G") && IestatijumuDati.elektribaIeslegta) {
        if (IestatijumuDati.istabuGaismasIeslegtas[0]) {
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
          IestatijumuDati.istabuGaismasIeslegtas[0] = false;
        } 
        else {
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
          IestatijumuDati.istabuGaismasIeslegtas[0] = true;
        }
      }
    }
    else if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
      if (panemtaIevade.equals("E") && IestatijumuDati.elektribaIeslegta) { //* Elektrības izslēgšana.
        if (VirtuvesSpoks.virtuvesSpoks.getSpoksIrAktivs()) {
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\spoks_krit_leja_pa_kapnem.wav", VirtuvesSpoks.virtuvesSpoks.getSpokaFazesIndekss() - 17);
        }
        izslegtElektribu();
      }
    }
    else if (Main.varonaVirzienaSkaitlis == 2) { // Lejas darbības.

    }
    else if (Main.varonaVirzienaSkaitlis == 3) { // Kreisās puses darbības.
      if (panemtaIevade.equals("LOGS") && LogaSpoks.logaSpoks.getLSIstabu().equals("GULTA") && LogaSpoks.logaSpoks.getSpoksIrAktivs()) {
        LogaSpoks.logaSpoks.deaktivizetSpoku();
      }
    }
  }


  

  private static void sakumaEkranaDarbibas(String panemtaIevade) {
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