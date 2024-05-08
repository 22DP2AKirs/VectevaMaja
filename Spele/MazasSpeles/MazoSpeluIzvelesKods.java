package Spele.MazasSpeles;

import Spele.Enums.NavesIemesli;
import Spele.K;
import Spele.MazasSpeles.AtrodiPari.AtrodiPari;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.MazasSpeles.SamaisitieVardi.SMSavienojums;
import Spele.MazasSpeles.SamaisitieVardi.SamaisitieVardi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.VaronaStatusaEfekti;

// Šinī klasē tiks veiktas visas m-spēlu izvēles.
public class MazoSpeluIzvelesKods {
  // Priekš minigames.
  public static volatile boolean varonisIrMazajaSpele = false; // true, ja varonis ir iegājis mazajā spēlē, false, ja nav.
  public static volatile boolean izveletaMazaSpele; // true, ja spēle izvēlējās, kādu no iespējamajām spēlēm, paratsti, katru stundu. 

  public static int 
  majasdarbuSkaits, // Majasdarbu skaits, kuri varonim ir JĀIZPILDA nakts garumā.
  izpilditoMajasdarbuSkaits = 0, // Majasdarbu skaits, kurus varonis IR izpildījis.

  laiksLidzJaunamMajasdarbamMainigais = 10, // Laiks, kuru pamazinās katru sekundi.
  laiksLidzJaunamMajasdarbamNemainigais = 10; // Laiks, no kura laiksLidzJaunamMajasdarbamMainigais ņems sākuma vērtību, kad viņš tiek līdz nullei.

  public static void palaistMajasdarbu() {
    // Ieslēdz mājasdarba skatu.
    Izvade.ieslegtMasivaIzvadi();
    MazoSpeluIzvelesKods.varonisIrMazajaSpele = true;
    TastaturasKlausitajs.komanda = K.TUKSA_IEVADE;
  }

  public static void pamazinatLaikuLidzMajasdarbam() {
    if (!izveletaMazaSpele) {
      // 1. Beidz skaitīšanu un izvēlas mājasdarbu.
      if (laiksLidzJaunamMajasdarbamMainigais == 0) {
        laiksLidzJaunamMajasdarbamMainigais = laiksLidzJaunamMajasdarbamNemainigais;
        ieslegtKaduMajasdarbu();
      }
      // 2. Pamazina laiku.
      else if (laiksLidzJaunamMajasdarbamMainigais > 0) {
        laiksLidzJaunamMajasdarbamMainigais--;
      }
    }
  }

  public static void izpildijaVisusMajasdarbus() {
    if (izpilditoMajasdarbuSkaits == majasdarbuSkaits) {
      VaronaStatusaEfekti.spelesRezultats(NavesIemesli.UZVARA);
    }
  }

  public static void izpildijaMajasdarbu() {
    // Kods, kas tiks izpildīts, kad kāds no mājasdarbiem tiek izpildīts.
    // 1. Iziet no mājasdarba.
    MazoSpeluIzvelesKods.varonisIrMazajaSpele = false;
    MazoSpeluIzvelesKods.izveletaMazaSpele = false;
    // 2. Pārslēdz izvades režīmu.
    Izvade.ieslegtSpelesIzvadi();
    izpilditoMajasdarbuSkaits++;
  }

  private static void ieslegtKaduMajasdarbu() {
    // 1. Izvēlas vienu no mājasdarbiem, kurš būs jāpilda varonim.
    int randCipars = Main.rand.nextInt(2); // No 0 ieskaitot, līdz "norādītais" neieskaitot.
    // 2. Uzstāda izvēlēto mājasdarbu.
    if (randCipars == 0) {
      // Karātavas.
      Karatavas.izveidotJaunuKaratavasSpeli();
      KaratavasSavienojums.mSpeleKaratavas = true;
    }
    else if (randCipars == 1) {
      // Kāršu spēle "Atrodi pāri".
      AtrodiPari.izveidotJaunuKarsuSpeli();
      AtrodiPariSavienojums.mSpeleAtrodiPari = true;
    }
    else if (randCipars == 2) {
      SamaisitieVardi.izveidotJaunuSVObjektu();
      SMSavienojums.MDSamaisitieVardi = true;
    }
    // 3. Apstiprina, ka mājasdarbs ir ieslēgts.
    izveletaMazaSpele = true; // Ļauj pārbaudīt vai varonis ir uzvarējis m-spēli.
  }

  public static void sagatavotMajasdarbusJaunaiSpelei() {
    // Izslēdz visus MD datus.
    varonisIrMazajaSpele = false;
    izveletaMazaSpele = false;
    izslegtVisasMazasSpeles();
  }

  public static void izslegtVisasMazasSpeles() {
    AtrodiPariSavienojums.mSpeleAtrodiPari = false;
    KaratavasSavienojums.mSpeleKaratavas = false;
  }
}
