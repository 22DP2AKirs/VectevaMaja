package Spele.MazasSpeles.AtrodiPari;

import Spele.PaligMetodes;
import Spele.SpelesProcesi.TastaturasKlausitajs;

// Šinī klasē būs m-spēles algoritms apvienots ar galveno spēles programmu.
public class AtrodiPariSavienojums {
  public static boolean mSpeleAtrodiPari = false;

  public static void palaistAtrodiPariMazoSpeli() {
    // 1. Pārbauda vai visas kārtis ir apgriestas (atrastas).
    AtrodiPari.atrodiPariObjekts.parbauditKarsuRezultatu();
    // 2. Iekrāso izvēlēto rindu un komandu.
    AtrodiPari.atrodiPariObjekts.izveletiesKoIekrasot(TastaturasKlausitajs.komandasTeksts);
    // 3. Galvenā domāšana.
    AtrodiPari.atrodiPariObjekts.parbauditIevadi(TastaturasKlausitajs.komanda);
    // 4. Sagatavo un izvada sarakstu ar kāršu spēles galdu.
    PaligMetodes.izvaditArrayListElementus(AtrodiPari.atrodiPariObjekts.salipinatKartisVienaSaraksta());
    // 5. Pārbauda vai izvēlētās kārtis ir pareizas (vienādas vai nepareizi izvēlētas).
    AtrodiPari.atrodiPariObjekts.abuKarsuKoordinasuParbaude();
    // 6. Atļauj mainīt ievadi galvenā cikla beigās.
    TastaturasKlausitajs.sagatavotKomanduDzesanai();
  }
}