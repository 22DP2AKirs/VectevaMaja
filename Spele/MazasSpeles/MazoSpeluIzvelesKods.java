package Spele.MazasSpeles;

import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;

// Šinī klasē tiks veiktas visas m-spēlu izvēles.
public class MazoSpeluIzvelesKods {
  // Priekš minigames.
  public static volatile boolean varonisIrMazajaSpele = false; // true, ja varonis ir iegājis mazajā spēlē, false, ja nav.
  public static volatile boolean izveletaMazaSpele; // true, ja spēle izvēlējās, kādu no iespējamajām spēlēm, paratsti, katru stundu. 


  public static void izslegtVisasMazasSpeles() {
    AtrodiPariSavienojums.mSpeleAtrodiPari = false;
    KaratavasSavienojums.mSpeleKaratavas = false;
  }
}
