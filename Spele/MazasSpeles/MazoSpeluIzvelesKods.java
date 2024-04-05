package Spele.MazasSpeles;

import Spele.MazasSpeles.AtrodiPari.AtrodiPari;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.SpelesProcesi.Laiks;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;

// Šinī klasē tiks veiktas visas m-spēlu izvēles.
public class MazoSpeluIzvelesKods {
  // Priekš minigames.
  public static volatile boolean varonisIrMazajaSpele = false; // true, ja varonis ir iegājis mazajā spēlē, false, ja nav.
  public static volatile boolean izveletaMazaSpele; // true, ja spēle izvēlējās, kādu no iespējamajām spēlēm, paratsti, katru stundu. 

  public static int majasdarbaIzpildesTermins = 0; // Spēles laiks, līdz cikiem varonis var pildīt mājasdarbu.

  public static void apskatitMajasdarbu() {
    // * Pārbauda un ieslēdz mājasdarbu.
    if (Laiks.stundasLaiks == majasdarbaIzpildesTermins) {
      parbauditVaiVaronisPaspejaIzpilditMajasdarbu();
      ieslegtKaduMajasdarbu();
    }
  }

  public static void parbauditVaiVaronisPaspejaIzpilditMajasdarbu() {
    // * Pārbauda vai varonis ir izpildījis mājasdarbu noteiktajā laikā, ja nav, tad viņš zaudē.
    // Ja m-spēle nav uzvarēta, un varonis ir mirstīgais, tad viņš zaudē.
    if (izveletaMazaSpele && !Main.varonaNemirstiba) {
      VaronaStatusaEfekti.noteiktSpelesGalaRezultatu("MAJASDARBA_LAIKS");
    }
  }

  private static void ieslegtKaduMajasdarbu() {
    // * Ieslēdz vienu no mājasdarbiem.

    // 1. Izvēlas vienu no mājasdarbiem, kurš būs jāpilda varonim.
    int randCipars = Main.rand.nextInt(2); // No 0 ieskaitot, līdz "norādītais" neieskaitot.
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
    
    // TODO: rand cipars ir atkarīgs no natks. Jo lielāka nakts, jo mazāks skaitlis.
    // 2. Izvēlas cik stundas būs varonim, lai izpildītu mājasdarbus.
    randCipars = Main.rand.nextInt(101); // Skaitlis no 0 - 100 ieskaitot.
    
    if (randCipars > 50) { // 50% iespēja.
      if (randCipars > 80) { // 20% iespēja.
        majasdarbaIzpildesTermins += 3;
      }
      else {
        majasdarbaIzpildesTermins += 2;
      }
    }
    else {
      majasdarbaIzpildesTermins++;
    }

    // 3. Pamazina mājasdarba izpildes termiņu, lai tas nepārsniegtu 6 AM laiku.
    while (majasdarbaIzpildesTermins > 6) {
      majasdarbaIzpildesTermins--;
    }

    // 3. Apstiprina, ka mājasdarbs ir ieslēgts.
    izveletaMazaSpele = true; // Ļauj pārbaudīt vai varonis ir uzvarējis m-spēli.
  }

  public static void izslegtVisasMazasSpeles() {
    AtrodiPariSavienojums.mSpeleAtrodiPari = false;
    KaratavasSavienojums.mSpeleKaratavas = false;
  }
}
