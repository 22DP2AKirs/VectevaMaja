package Spele.SpelesProcesi;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import Spele.K;

public class TastaturasKlausitajs implements NativeKeyListener {
  public static String komanda = K.TUKSA_IEVADE;
  public static String komandasTeksts = K.TUKSA_IEVADE;
  public static String ieprieksejaKomanda = K.TUKSA_IEVADE;

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

      // 1.1. Izvēlas vai komanda būs ar lielajiem vai mazajiem burtiem.
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

        komanda = K.TUKSA_IEVADE; // Nodzēš ievadi, lai nebūtu konfliktu ar komandām.
        nodzestKomandasTekstu();
      }
      // 1.2. Saglabā ievadi.
      else if (lielieBurti) {
        komanda = taustins.toUpperCase();
      }
      else {
        komanda = taustins.toLowerCase();
      }

      // 1.3. Saglabā iepriekšējo komandu.
      ieprieksejaKomanda = komanda;
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
    turTaustinu = false;
  }

  public static void ieslegtIespejuRakstitKomandasTekstu() {
    // Atļauj jebkurā programmas daļā pieņemt 'komandasTekstu' kā ievades opciju.
    if (komandasTekstaRakstisana) {
      limetKomandasTekstu();
      System.out.println(">>> " + komandasTeksts + "\033[0K");
      ieprieksejaKomanda = komandasTeksts; // Saglabā iepriekšējo komandu.
    }
    else {
      nodzestKomandasTekstu();
    }
  }

  public static void nodzestKomandasTekstu() {
    komandasTeksts = K.TUKSA_IEVADE;
  }

  public static String limetVardu(String vards) {
    // Līmē nospiestos burtus, lai veidotu vārdu, piem., : <- a ; :a <- b ; : ab <- o ; u.t.t.

    // 1. Nosaka, kāda darbība būs veikta ar simbolu virkni.
    if (komanda.toUpperCase().equals("BACKSPACE") && vards.length() > 0) {
      // Atņem pēdējo simbolu.
      vards = vards.substring(0, vards.length() - 1);
    }
    else {
      // Ja komanda ir 1 simbols, tad ... .
      if (komanda.length() < 2) {
        vards += komanda;
      }
    }

    return vards;
  }

  public static void limetKomandasTekstu() {
    // 1. Ļauj līmēt komandasTekstu ar visiem pielāgojumiem programmai.
    komandasTeksts = limetVardu(komandasTeksts);

    // 2. Atļauj programmā veikt 'teksts' + 'Enter' darbības.
    if (!komanda.toUpperCase().equals("ENTER")) {
      uzreizNodzestKomandu();
    }
    else {
      // Izslēdz komandas teksta rakstīšanas funkc..
      komandasTekstaRakstisana = false;
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
