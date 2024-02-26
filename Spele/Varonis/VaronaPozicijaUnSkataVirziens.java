package Spele.Varonis;

import Spele.Enums.Istabas;
import Spele.Enums.Virzieni;

public class VaronaPozicijaUnSkataVirziens {
  /* Clases doma jeb jēga: 
     Lai katrā klasē nevajadzētu veidot vairākus if-else_if nosacījumus, specifiskām
     pārbaudēm. Šī klases saturēs vienu lielu if-else_if nosacījumu, kurš izsauks visas
     nepieciešamās metodes atkarīgi no tā, kur atrodas un uz kurieni skatās varonis.

     Cerības:
     Programma patērēs mazāk resursus un strādās ātrāk. Programmu varēs vieglāk saprast
     un salasīt koda domu.
  */

  // Spelētāja pozīcija.
  public static int varonaIstabasCipars = 2; // 0, no gultas istabas. 2, jo testā sāku no durvju istabas. 3, no virtuves istabas.
  public static int varonaVirzienaCipars = 1;

  public static void noteiktVisasAktualasDarbibas(Istabas istaba, Virzieni virziens) {
    if (istaba.equals(Istabas.GULTA)) { // ----------------------------- Gulta.
      if (virziens.equals(Virzieni.PRIEKSA)) {

      }
      else if (virziens.equals(Virzieni.LABA_PUSE)) {
        
      }
      else if (virziens.equals(Virzieni.LEJA)) {
        
      }
      else if (virziens.equals(Virzieni.KREISA_PUSE)) {
        
      }
    }
    else if (istaba.equals(Istabas.DIVANS)) { // ----------------------- Dīvāns.
      if (virziens.equals(Virzieni.PRIEKSA)) {

      }
      else if (virziens.equals(Virzieni.LABA_PUSE)) {
        
      }
      else if (virziens.equals(Virzieni.LEJA)) {
        
      }
      else if (virziens.equals(Virzieni.KREISA_PUSE)) {
        
      }
    }
    else if (istaba.equals(Istabas.DURVIS)) { // ----------------------- Durvis.
      if (virziens.equals(Virzieni.PRIEKSA)) {

      }
      else if (virziens.equals(Virzieni.LABA_PUSE)) {
        
      }
      else if (virziens.equals(Virzieni.LEJA)) {
        
      }
      else if (virziens.equals(Virzieni.KREISA_PUSE)) {
        
      }
    }
    else if (istaba.equals(Istabas.VIRTUVE)) { // ---------------------- Virtuve.
      if (virziens.equals(Virzieni.PRIEKSA)) {

      }
      else if (virziens.equals(Virzieni.LABA_PUSE)) {
        
      }
      else if (virziens.equals(Virzieni.LEJA)) {
        
      }
      else if (virziens.equals(Virzieni.KREISA_PUSE)) {
        
      }
    }
  }

  
}
