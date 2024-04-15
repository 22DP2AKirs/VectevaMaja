package Spele.MazasSpeles.AtrodiPari;

import Spele.PaligMetodes;
import Spele.SpelesProcesi.TastaturasKlausitajs;

// Šinī klasē būs m-spēles algoritms apvienots ar galveno spēles programmu.
public class AtrodiPariSavienojums {
  public static boolean mSpeleAtrodiPari = false;
  public static String ievaditasKoord = "";

  public static void palaistAtrodiPariMazoSpeli() {
    // 1. Ļauj ievadīt koord.
    ievaditasKoord = TastaturasKlausitajs.limetVardu(ievaditasKoord);
    // 2. Pārbauda vai visas kārtis ir apgriestas (atrastas).
    AtrodiPari.atrodiPariObjekts.parbauditKarsuRezultatu();
    // 3. Iekrāso izvēlēto rindu un komandu.
    AtrodiPari.atrodiPariObjekts.izveletiesKoIekrasot(ievaditasKoord);
    // 4. Galvenā domāšana.
    AtrodiPari.atrodiPariObjekts.parbauditIevadi(TastaturasKlausitajs.komanda, ievaditasKoord);
    // 5. Sagatavo un izvada sarakstu ar kāršu spēles galdu.
    PaligMetodes.izvaditArrayListElementus(AtrodiPari.atrodiPariObjekts.salipinatKartisVienaSaraksta());
    // 6. Pārbauda vai izvēlētās kārtis ir pareizas (vienādas vai nepareizi izvēlētas).
    AtrodiPari.atrodiPariObjekts.abuKarsuKoordinasuParbaude();
    // 7. Atļauj mainīt ievadi galvenā cikla beigās.
    TastaturasKlausitajs.sagatavotKomanduDzesanai();
  }
}