package Spele.Majasdarbi;

import Spele.Enums.NavesIemesli;
import Spele.Majasdarbi.AtrodiPari.AtrodiPari;
import Spele.Majasdarbi.AtrodiPari.AtrodiPariSavienojums;
import Spele.Majasdarbi.Karatavas.Karatavas;
import Spele.Majasdarbi.Karatavas.KaratavasSavienojums;
import Spele.Majasdarbi.SamaisitieVardi.SMSavienojums;
import Spele.Majasdarbi.SamaisitieVardi.SamaisitieVardi;
import Spele.K;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.VaronaStatusaEfekti;

// Šinī klasē tiks veiktas visas m-spēlu izvēles.
public class MajasdarbuIzvelesKods {
  // Priekš minigames.
  public static volatile boolean varonisIrMajasdarba = false; // true, ja varonis ir iegājis mazajā spēlē, false, ja nav.
  public static volatile boolean izveletsMajasdarbs; // true, ja spēle izvēlējās, kādu no iespējamajām spēlēm, paratsti, katru stundu. 

  public static int 
  majasdarbuSkaits, // Majasdarbu skaits, kuri varonim ir JĀIZPILDA nakts garumā.
  izpilditoMajasdarbuSkaits = 0, // Majasdarbu skaits, kurus varonis IR izpildījis.

  laiksLidzJaunamMajasdarbamMainigais = 10, // Laiks, kuru pamazinās katru sekundi.
  laiksLidzJaunamMajasdarbamNemainigais = 10; // Laiks, no kura laiksLidzJaunamMajasdarbamMainigais ņems sākuma vērtību, kad viņš tiek līdz nullei.

  public static void palaistMajasdarbu() {
    // Ieslēdz mājasdarba skatu.
    Izvade.ieslegtMasivaIzvadi();
    MajasdarbuIzvelesKods.varonisIrMajasdarba = true;
    TastaturasKlausitajs.komanda = K.TUKSA_IEVADE;
  }

  public static void pamazinatLaikuLidzMajasdarbam() {
    if (!izveletsMajasdarbs) {
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
    MajasdarbuIzvelesKods.varonisIrMajasdarba = false;
    MajasdarbuIzvelesKods.izveletsMajasdarbs = false;
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
      KaratavasSavienojums.MDKaratavas = true;
    }
    else if (randCipars == 1) {
      // Kāršu spēle "Atrodi pāri".
      AtrodiPari.izveidotJaunuKarsuSpeli();
      AtrodiPariSavienojums.MDAtrodiPari = true;
    }
    else if (randCipars == 2) {
      SamaisitieVardi.izveidotJaunuSVObjektu();
      SMSavienojums.MDSamaisitieVardi = true;
    }
    // 3. Apstiprina, ka mājasdarbs ir ieslēgts.
    izveletsMajasdarbs = true; // Ļauj pārbaudīt vai varonis ir uzvarējis m-spēli.
  }

  public static void sagatavotMajasdarbusJaunaiSpelei() {
    // Izslēdz visus MD datus.
    varonisIrMajasdarba = false;
    izveletsMajasdarbs = false;
    izpilditoMajasdarbuSkaits = 0;
    izslegtVisasMazasSpeles();
  }

  public static void izslegtVisasMazasSpeles() {
    AtrodiPariSavienojums.MDAtrodiPari = false;
    KaratavasSavienojums.MDKaratavas = false;
  }
}
