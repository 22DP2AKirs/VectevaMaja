package Spele;

public class PaligMetodes {
  // Šeit ir metodes, kuras atvieglos koda saprašanu un manu dzīvi.
  
  public static String[] nomainitMasivaElementu(String[] masivs, String mainamaisElements, String jaunaisElements) {
    // * Metode pareizi izpildās tikai tad, ja masīvā nav identisku elementu.
    // Atrod masīvā meklējamo elementu.
    for (int i = 0; i < masivs.length; i++) {
      // Kad atrod elementu, tad to nomaina.
      if (masivs[i].equals(mainamaisElements)) {
        // Ja nomaina elementu, tad iet ārā no cikla.
        masivs[i] = jaunaisElements;
        break;
      }
    }
    // Atgriež masīvu ar nomainīto elementu.
    return masivs;
  }

  public static void gulet(int sekundes) {
    // * Metode atvieglo dzīvi visu laiku, kad man vajag izmantot
    // * Thread.sleep(); Vairs nevajag uztraukties par try_catch 
    // * rakstīšanu.
    try {
      Thread.sleep(sekundes * 1000);
    } catch (Exception e) {}
  }
}