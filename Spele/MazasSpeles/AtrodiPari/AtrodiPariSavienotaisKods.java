package Spele.MazasSpeles.AtrodiPari;

import Spele.PaligMetodes;
import Spele.SpelesProcesi.Ievade;

// Šinī klasē būs algoritms apvienots ar galveno spēles programmu.
public class AtrodiPariSavienotaisKods {
  public static void palaistKarsuSpeli() {
    // -------- Pārbauda vai visas kārtis ir apgriestas (atrastas).
    AtrodiPari.atrodiPari.parbauditKarsuRezultatu();
    // -------- Galvenā domāšana.
    AtrodiPari.atrodiPari.izveletiesKarsuPozicijas(Ievade.lietotajaIevade);
    // -------- Sagatavo un izvada sarakstu ar kāršu spēles galdu.
    PaligMetodes.izvaditArrayListElementus(AtrodiPari.atrodiPari.salipinatKartisVienaSaraksta());
    // -------- Pārbauda vai izvēlētās kārtis ir pareizas (vienādas vai nepareizi izvēlētas).
    AtrodiPari.atrodiPari.abuKarsuKoordinasuParbaude();
    // -------- Atļauj mainīt ievadi galvenā cikla beigās.
    Ievade.sagatavotKomanduDzesanai();
  }
}