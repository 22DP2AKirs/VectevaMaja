package Spele.MazasSpeles.AtrodiPari;

import Spele.PaligMetodes;
import Spele.SpelesProcesi.Ievade;

// Šinī klasē būs m-spēles algoritms apvienots ar galveno spēles programmu.
public class AtrodiPariSavienojums {
  public static boolean mSpeleAtrodiPari = false;

  public static void palaistAtrodiPariMazoSpeli() {
    // -------- Pārbauda vai visas kārtis ir apgriestas (atrastas).
    AtrodiPari.atrodiPariObjekts.parbauditKarsuRezultatu();
    // -------- Galvenā domāšana.
    AtrodiPari.atrodiPariObjekts.parbauditIevadi(Ievade.lietotajaIevade);
    // -------- Sagatavo un izvada sarakstu ar kāršu spēles galdu.
    PaligMetodes.izvaditArrayListElementus(AtrodiPari.atrodiPariObjekts.salipinatKartisVienaSaraksta());
    // -------- Pārbauda vai izvēlētās kārtis ir pareizas (vienādas vai nepareizi izvēlētas).
    AtrodiPari.atrodiPariObjekts.abuKarsuKoordinasuParbaude();
    // -------- Atļauj mainīt ievadi galvenā cikla beigās.
    Ievade.sagatavotKomanduDzesanai();
  }
}