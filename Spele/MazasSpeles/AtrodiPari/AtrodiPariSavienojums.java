package Spele.MazasSpeles.AtrodiPari;

import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.Main;
import Spele.SpelesProcesi.TastaturasKlausitajs;

// Šinī klasē būs m-spēles algoritms apvienots ar galveno spēles programmu.
public class AtrodiPariSavienojums {
  public static boolean mSpeleAtrodiPari = false;
  public static String ievaditasKoord = "";

  public static void palaistAtrodiPariMazoSpeli() {
    // 1. Ļauj ievadīt koord.
    ievaditasKoord = TastaturasKlausitajs.limetVardu(ievaditasKoord, Main.ciklaKomanda, 2);
    // 2. Pārbauda vai visas kārtis ir apgriestas (atrastas).
    AtrodiPari.atrodiPariObjekts.parbauditKarsuRezultatu();
    // 3. Iekrāso izvēlēto rindu un komandu.
    AtrodiPari.atrodiPariObjekts.izveletiesKoIekrasot(ievaditasKoord);
    // 4. Galvenā domāšana.
    AtrodiPari.atrodiPariObjekts.parbauditIevadi(Main.ciklaKomanda, ievaditasKoord);
    // 5. Pārveido sarakstu par masīvu un saglabā to kā izvadi.
    Izvade.izvadesMasivs = AtrodiPari.atrodiPariObjekts.uzMasivu(AtrodiPari.atrodiPariObjekts.salipinatKartisVienaSaraksta(), ievaditasKoord);
    // 6. Pārbauda vai izvēlētās kārtis ir pareizas (vienādas vai nepareizi izvēlētas).
    AtrodiPari.atrodiPariObjekts.abuKarsuKoordinasuParbaude();
  }
}