package Spele.Varonis;
import java.util.Arrays;

import Spele.SpelesProcesi.Main;
import Spele.Spoki;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Izskati.EkranuIzskati;
import Spele.MazasSpeles.MazoSpeluPalaisanasKods;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Laiks;

public class VaronaDarbibas {
  public static int infoLapasSecibasSkaitlis = 1; // Nosaka vai varoņa ievade būs ar kustību saistīta vai ar darbu darbību saistīta.

  public static boolean aizdedzinatsSerkocins = false; 
  public static int serkocinaDeksanasLaikaSkaititajs;

  // Šie masīvi tiek pārbaudīti, lai labāk spētu noteikt, kāda darbība ir, kādai metodei.
  private static final String[] testesanasKomandas = {"INFO", "EXIT", "POWER OFF", "KILL", "WIN"};
  private static final String[] parastasKomandas = {"F", "A", "W", "D", "1", "2", "3", "4"};
  
  public static void varonaDarbibas(String ievade) {
      // Garantē, lai lietotāja ievade tiktu izpildīta, pirms tā ir nodzēsta ar notiritIevadi().
      if (!Ievade.vaiIevadiIzpildija) { 
          Ievade.vaiIevadiIzpildija = true;
      }

      if (Main.varonisIrMazajaSpele) {
        if (ievade.equals("Q")) {
          Main.varonisIrMazajaSpele = false;
        }
      }

      // Ja ievades nebija, tad nepārbauda pārējās komandas.
      if (!ievade.equals("}") && !Main.varonisIrMazajaSpele) {
          // Darbības jeb komandas pareizai situācijai.
          if (Main.sakumaEkrans) {
              sakumaEkranaDarbibas(ievade);
          } 
          else if (Main.spelePalaista) {
              if (Arrays.asList(parastasKomandas).contains(ievade)) {
                  parastasDarbibas(ievade);
              }
              else if (Arrays.asList(testesanasKomandas).contains(ievade)) {
                  testesanasDarbibas(ievade);
              }
              else if (Main.varonaIstabasSkaitlis == 0) { // Gultas darbības.
                  gultasDarbibas(ievade);
              }
              else if (Main.varonaIstabasSkaitlis == 1) { // Divana darbības.
                  divanaDarbibas(ievade);
              }
              else if (Main.varonaIstabasSkaitlis == 2) { // Durvju darbības.
                  durvjuDarbibas(ievade);
              }
              else if (Main.varonaIstabasSkaitlis == 3) { // Virtuves darbības.
                  virtuvesDarbibas(ievade);
              }
          }
      }
  }


  private static void parastasDarbibas(String panemtaIevade) {
      if (panemtaIevade.equals("F") && Main.atlikusoSerkocinuDaudzums != 0 && !aizdedzinatsSerkocins) {
          if (Main.rand.nextInt(3) == 0) { // 33.33 % iespēja aizdedzināt sērkociņu.
              SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\lighting-matches.wav", 0);
              aizdedzinatsSerkocins = true;
              Main.atlikusoSerkocinuDaudzums--;
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
      if (panemtaIevade.equals("INFO")) {
          if (Spoki.spokuInfoIzvadeBoolean) {
              Spoki.spokuInfoIzvadeBoolean = false;
          } 
          else {
              Spoki.spokuInfoIzvadeBoolean = true;
          }
          Main.tiritEkranu();
      } 
      else if (panemtaIevade.equals("EXIT")) {
          Main.programmaPalaista = false;
          System.exit(0);
      }
      else if (panemtaIevade.equals("POWER OFF")) {
          if(Main.elektribaIeslegta) {
              Main.elektribaIeslegta = false;
              Laiks.laiksCikIlgiElektribaBusIzslegta = 10;
          } 
          else {
              Main.elektribaIeslegta = true;
          }
      }
      else if (panemtaIevade.equals("KILL")) {
          VaronaStatusaEfekti.varonaBojaeja("PASNAVIBA");
      }
      else if (panemtaIevade.equals("WIN")) {
          Laiks.spelesLaiks = 1000;
      }
  }


  private static void virtuvesDarbibas(String panemtaIevade) {
      if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
          if (panemtaIevade.equals("LOGS") && Spoki.spokuStati[0].spokaIstaba.equals("Virtuve") && Spoki.spokuStati[0].spoksAktivs) {
              Spoki.logaSpoksAktivs = false;
          }
      }
      else if (Main.varonaVirzienaSkaitlis == 2) {
          if (panemtaIevade.equals("G") && Spoki.spokuStati[2].spokaFazesIndeks < 10) {
              if (Main.pagrabaGaisma) {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
                  Main.pagrabaGaisma = false;
              }
              else {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
                  Main.pagrabaGaisma = true;
              }
          }
      }
      else if (Main.varonaVirzienaSkaitlis == 3) { // Kreisās puses darbības.
          if (panemtaIevade.equals("G") && Main.elektribaIeslegta) {
              if (Main.istabuGaismasIeslegtas[3]) {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
                  Main.istabuGaismasIeslegtas[3] = false;
              } 
              else {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
                  Main.istabuGaismasIeslegtas[3] = true;
              }
          }
      }
  }


  private static void durvjuDarbibas(String panemtaIevade) {
    if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
      if (panemtaIevade.equals("LOGS") && Spoki.spokuStati[0].spokaIstaba.equals("Durvis") && Spoki.spokuStati[0].spoksAktivs) {
        Spoki.logaSpoksAktivs = false;
      }
    }
    else if (Main.varonaVirzienaSkaitlis == 1) {
      if (panemtaIevade.equals("DURVIS") && Spoki.spokuStati[1].spoksAktivs) {
        Spoki.durvjuSpoksAktivs = false;
      }
      else if (panemtaIevade.equals("E")) {
        MazoSpeluPalaisanasKods.palaistKaratavas();
      }
    }
    else if (Main.varonaVirzienaSkaitlis == 2) { // Lejas darbības.
      if (panemtaIevade.equals("G") && Main.elektribaIeslegta) {
        if (Main.istabuGaismasIeslegtas[2]) {
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
          Main.istabuGaismasIeslegtas[2] = false;
        } 
        else {
          SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
          Main.istabuGaismasIeslegtas[2] = true;
        }
      }
    }
  }


  private static void divanaDarbibas(String panemtaIevade) {
      if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
          if (panemtaIevade.equals("LOGS") && Spoki.spokuStati[0].spokaIstaba.equals("Divans") && Spoki.spokuStati[0].spoksAktivs) {
              Spoki.logaSpoksAktivs = false;
          }
      }
      else if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
          if (panemtaIevade.equals("G") && Main.elektribaIeslegta) {
              if (Main.istabuGaismasIeslegtas[1]) {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
                  Main.istabuGaismasIeslegtas[1] = false;
              } 
              else {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
                  Main.istabuGaismasIeslegtas[1] = true;
              }
          }
          
      }
  }


  private static void gultasDarbibas(String panemtaIevade) {
      if (Main.varonaVirzienaSkaitlis == 0) { // Priekšas darbības.
          if (panemtaIevade.equals("G") && Main.elektribaIeslegta) {
              if (Main.istabuGaismasIeslegtas[0]) {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-off.wav", 0);
                  Main.istabuGaismasIeslegtas[0] = false;
              } 
              else {
                  SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\gaismas-sledzis-on.wav", 0);
                  Main.istabuGaismasIeslegtas[0] = true;
              }
          }
      }
      else if (Main.varonaVirzienaSkaitlis == 1) { // Labās puses darbības.
          if (panemtaIevade.equals("E") && Main.elektribaIeslegta) { //* Elektrības izslēgšana.
              izslegtasElektribasNosacijumi();
          }
      }
      else if (Main.varonaVirzienaSkaitlis == 2) { // Lejas darbības.

      }
      else if (Main.varonaVirzienaSkaitlis == 3) { // Kreisās puses darbības.
          if (panemtaIevade.equals("LOGS") && Spoki.spokuStati[0].spokaIstaba.equals("Gulta") && Spoki.spokuStati[0].spoksAktivs) {
              Spoki.logaSpoksAktivs = false;
          }
      }
  }


  private static void izslegtasElektribasNosacijumi() { // Kad izslēdz elektrību nosaka, kādi iestatījumi vai mainīgie mainās.
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\fuse-box-turning-on-off.wav", 0);
      Main.elektribaIeslegta = false;
      Spoki.virtuvesSpoksAktivs = false;
      Arrays.fill(Main.istabuGaismasIeslegtas, false); // Visās istabās izslēdz gaismu.
      Main.pagrabaGaismaStrada = true; // Salabo pagraba gaismu.
      Laiks.laiksCikIlgiElektribaBusIzslegta = 3;
  }

  private static void sakumaEkranaDarbibas(String panemtaIevade) {
      // * Šī metode nosaka, kādas darbības būs pieejamas sākuma ekrānā (Main screen), un to darbību izpilde.
      if (panemtaIevade.equals("W")) {
          if (EkranuIzskati.izvelnesSkaits > 1) {
              EkranuIzskati.izvelnesSkaits--;
          }
      } 
      else if (panemtaIevade.equals("S")) {
          if (EkranuIzskati.izvelnesSkaits < 6) {
              EkranuIzskati.izvelnesSkaits++;
          }
      } 
      else if (panemtaIevade.equals("")) {
          if (EkranuIzskati.izvelnesSkaits == 1) {

          }
          else if (EkranuIzskati.izvelnesSkaits == 2) { // Spēlēt.
              Main.sakumaEkrans = false;
              Main.spelePalaista = true;
          } 
          else if (EkranuIzskati.izvelnesSkaits == 3) {
          
          } 
          else if (EkranuIzskati.izvelnesSkaits == 4) {
          
          } 
          else if (EkranuIzskati.izvelnesSkaits == 5) {

          } 
          else if (EkranuIzskati.izvelnesSkaits == 6) {
              Main.programmaPalaista = false;
              System.exit(0); // Pārtrauc spēles darbību.
          } 
      }
      Ievade.notiritIevadi();
  }


  private static void pagrieztiesPaKreisi() {
      Main.varonaVirzienaSkaitlis--;
      if (Main.varonaVirzienaSkaitlis < 0) { // Lai masīvs neizietu no diapazonas.
          Main.varonaVirzienaSkaitlis = 3;
      }
  }


  private static void pagrieztiesPaLabi() {
      Main.varonaVirzienaSkaitlis++;
      if (Main.varonaVirzienaSkaitlis > 3) { // Lai masīvs neizietu no diapazonas.
          Main.varonaVirzienaSkaitlis = 0;
      }
  }


  private static void ietUzPrieksu() {  // Kustība pa māju.
      // Kopā mājā ir 4 istabas, kurās var iet iekšā gan pulksteņrādītāja virzienā, gan pret to.
      // 0. Gulta, 1. Dīvāna istaba, 2. Durvju istaba, 3. Virtuve.
      // Istabas virzieni:
      // 0. Priekša, 1. Labā puse, 2. Leja, 3. Kreisā puse.

      if (Main.varonaIstabasSkaitlis == 0) {
          if (Main.varonaVirzienaSkaitlis == 0) {
              Main.varonaIstabasSkaitlis++;
          } else if (Main.varonaVirzienaSkaitlis == 1) {
              Main.varonaIstabasSkaitlis = 3; // Pret "pulksteņrādītāja secības" cikla: 0 -3- 2 1 0 -3- 2 1 0.
          }
      } else if (Main.varonaIstabasSkaitlis == 1) {
          if (Main.varonaVirzienaSkaitlis == 1) { // Labās durvis.
              Main.varonaIstabasSkaitlis++;
          } else if (Main.varonaVirzienaSkaitlis == 2) { // Lejas durvis.
              Main.varonaIstabasSkaitlis--;
          }
      } else if (Main.varonaIstabasSkaitlis == 2) {
          if (Main.varonaVirzienaSkaitlis == 2) { // Lejas durvis.
              Main.varonaIstabasSkaitlis++;
          } else if (Main.varonaVirzienaSkaitlis == 3) { // Kreisās durvis.
              Main.varonaIstabasSkaitlis--;
          }
      } else if (Main.varonaIstabasSkaitlis == 3) {
          if (Main.varonaVirzienaSkaitlis == 3) {
              Main.varonaIstabasSkaitlis = 0; //  Pēdējā no 4 istabām. Ciparam ir jāmainās pēc "pulksteņrādītāja secības" cikla: 0 1 2 3 -0- 1 2 3 -0-.
          } else if (Main.varonaVirzienaSkaitlis == 0) {
              Main.varonaIstabasSkaitlis--;
          }
      }
  }
}