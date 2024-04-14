package Spele.SpelesProcesi;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import Spele.K;

public class TastaturasKlausitajs implements NativeKeyListener {
  public static volatile String komanda = K.TUKSA_IEVADE;
  public static String komandasTeksts = K.TUKSA_IEVADE;

  public static boolean lielieBurti = true;
  public static boolean komandasTekstaRakstisana;
  private boolean turTaustinu;
  private static boolean vaiIzpildijaKomandu;

  public void nativeKeyPressed(NativeKeyEvent e) {
    // 1. Atļauj nolasīt taustiņu tikai vienu reizi (netiek lasīti vairāki eventi, kad tur taustinu (pirms: aaaaaaaaaa, pēc: a (Kad atlaiž un nospiež no jauna) a ...)).
    if (!turTaustinu) {
      turTaustinu = true;
      vaiIzpildijaKomandu = false;
      String taustins = NativeKeyEvent.getKeyText(e.getKeyCode());

      // 1. Izvēlas vai komanda būs ar lielajiem vai mazajiem burtiem.
      if (taustins.equals("Tab")) {
        // Toggle slēdzis.
        if (lielieBurti) {
          lielieBurti = false;
        } else {
          lielieBurti = true;
        }
      }
      else if (taustins.equals("X")) {
        // Toggle slēdzis.
        if (komandasTekstaRakstisana) {
          komandasTekstaRakstisana = false;
        } else {
          komandasTekstaRakstisana = true;
        }
        nodzestKomandasTekstu();
      }
      // 2. Saglabā ievadi.
      else if (lielieBurti) {
        komanda = taustins.toUpperCase();
      }
      else {
        komanda = taustins.toLowerCase();
      }
    }

    // 2. Iziet no spēles.
    if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
      try {
        GlobalScreen.unregisterNativeHook(); // Atāķē klaviatūras klausītāju.
        System.exit(0); // Iziet no programmas.
      } catch (NativeHookException nativeHookException) {
        nativeHookException.printStackTrace();
      }
    }
  }

  public void nativeKeyReleased(NativeKeyEvent e) {
    // System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
    turTaustinu = false;
  }

  public static void ieslegtIespejuRakstitKomandasTekstu() {
    // Atļauj jebkurā programmas daļā pieņemt 'komandasTekstu' kā ievades opciju.
    if (komandasTekstaRakstisana) {
      limetVardu();
      System.out.println(komandasTeksts + "\033[0K");
    }
  }
  public static void nodzestKomandasTekstu() {
    komandasTeksts = K.TUKSA_IEVADE;
  }

  public static void limetVardu() {
    // Līmē nospiestos burtus, lai veidotu vārdu, piem., : <- a ; :a <- b ; : ab <- o ; u.t.t.

    // 1. Nosaka, kāda darbība būs veikta ar simbolu virkni.
    if (komanda.toUpperCase().equals("BACKSPACE") && komandasTeksts.length() > 0) {
      // Atņem pēdējo simbolu.
      komandasTeksts = komandasTeksts.substring(0, komandasTeksts.length() - 1);
    }
    else {
      // Ja komanda ir 1 simbols, tad ... .
      if (komanda.length() < 2) {
        komandasTeksts += komanda;
      }
    }

    // 2. Atļauj programmā veikt 'teksts' + 'Enter' darbības.
    if (!komanda.toUpperCase().equals("ENTER")) {
      uzreizNodzestKomandu();
    }
  }

  public static void palaistKlaviaturasLasitaju() {
    try {
      GlobalScreen.registerNativeHook();
    }
    catch (NativeHookException ex) {
      System.err.println("There was a problem registering the native hook.");
      System.err.println(ex.getMessage());

      System.exit(1);
    }
    GlobalScreen.addNativeKeyListener(new TastaturasKlausitajs());
  }

  public static void uzreizNodzestKomandu() {
    komanda = K.TUKSA_IEVADE;
  }

  public static void nodzestKomandu() {
    // Nodzēš komandu, ja visas darbības ar to tika paveiktas.
    if (vaiIzpildijaKomandu) { 
      komanda = K.TUKSA_IEVADE;
    }
  }
    
  public static void sagatavotKomanduDzesanai() {
    // ! Atļauj programmas cikla beigās notīrīt ievadi.
    // Šai metodei ir jābūt 'komandu izpildes' metodes beigās.
    // Sagatavo 
    if (!vaiIzpildijaKomandu) { 
      vaiIzpildijaKomandu = true;
    }
  }

  // public void nativeKeyTyped(NativeKeyEvent e) {
  //     System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
  // }
}
