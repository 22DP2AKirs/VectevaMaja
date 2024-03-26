package Spele.MazasSpeles;

import Spele.MazasSpeles.AtrodiPari.AtrodiPari;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;

// Šinī klasē tiks veiktas visas m-spēlu izvēles.
public class MazoSpeluIzvelesKods {
  // Priekš minigames.
  public static volatile boolean varonisIrMazajaSpele = false; // true, ja varonis ir iegājis mazajā spēlē, false, ja nav.
  public static volatile boolean izveletaMazaSpele; // true, ja spēle izvēlējās, kādu no iespējamajām spēlēm, paratsti, katru stundu. 


  public static void apskatitMajasdarbu() {
    // * Metode pārbauda un ieslēdz mājasdarbu.
    parbauditVaiVaronisPaspejaIzpilditMajasdarbu();
    ieslegtKaduMajasdarbu();
  }

  private static void parbauditVaiVaronisPaspejaIzpilditMajasdarbu() {
    // * Pārbauda vai varonis ir izpildījis mājasdarbu noteiktajā laikā, ja nav, tad viņš zaudē.
    // Ja m-spēle nav uzvarēta, un varonis ir mirstīgais, tad viņš zaudē.
    if (izveletaMazaSpele && !Main.varonaNemirstiba) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("MAJASDARBA_LAIKS");
    }
  }

  private static void ieslegtKaduMajasdarbu() {
    // * Ieslēdz vienu no mājasdarbiem.
    // Ļauj pārbaudīt vai varonis ir uzvarējis m-spēli.
    izveletaMazaSpele = true;

    // Main.rand.nextInt(3); // No 0 ieskaitot, līdz "norādītais" neieskaitot.
    int randCipars = 0; 
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
      // Iespēja, ka nav mājasdarba.
      izveletaMazaSpele = false;
    }
  }

  public static void izslegtVisasMazasSpeles() {
    AtrodiPariSavienojums.mSpeleAtrodiPari = false;
    KaratavasSavienojums.mSpeleKaratavas = false;
  }
}
