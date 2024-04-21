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

  public static volatile boolean komandasTekstaRakstisana;
  public static volatile boolean atlautRakstitKomandasTekstu;

  public static boolean lielieBurti = true;
  public static boolean atslegtaIevade; // Atļauj spiest un turēt jebkurus taustiņus vienlaicīgi.

  static boolean vaiIzpildijaKomandu;
  private static boolean turTaustinu;

  public static void beigtRakstitKomandasTekstu() {
    komandasTekstaRakstisana = false;
    atslegtaIevade = false;
    nodzestKomandasTekstu();
  }

  public static void ieslegtKomandasTekstaFunkciju() {
    atlautRakstitKomandasTekstu = true;
    beigtRakstitKomandasTekstu();
  }

  public static void izslegtKomandasTekstaFunkciju() {
    atlautRakstitKomandasTekstu = false;
    beigtRakstitKomandasTekstu();
  }

  public static void rakstitKomandasTekstu() {
    // Atļauj jebkurā programmas daļā pieņemt 'komandasTekstu' kā ievades opciju.
    // 1. Ja kTR ir true jeb ir uzspiests 'x'.
    if (komandasTekstaRakstisana && atlautRakstitKomandasTekstu) {
      // 1.1 Raksta kT (komandasTekstu), un izsdzēš komandas ja tās nav 'ENTER', bet ja ir, tad izsauc metodi 'izslegtKomandasTekstaRakstisanu()'.
      limetKomandasTekstu();
      // 1.2 Saglabā komandas tekstu, kā iepriekšējo ievadi.
      ieprieksejaKomanda = komandasTeksts; // Saglabā iepriekšējo komandu.
    }
    else {
      // 1b. Nodzēš KomandasTekstu.
      nodzestKomandasTekstu();
    }
  }

  public void nativeKeyPressed(NativeKeyEvent e) {
    String taustins = NativeKeyEvent.getKeyText(e.getKeyCode());

    // 1. Izvēlas rakstīšanas režīmu.
    if (atslegtaIevade) {
      komandasApstrade(taustins);
    }
    else {
      if (!turTaustinu) {   
        turTaustinu = true; 
        komandasApstrade(taustins);
      }
    }

    // 2. Paziņo, ka ir jauna komanda, kura ir gatava izpildei.
    vaiIzpildijaKomandu = false;

    // 3. Saglabā iepriekšējo komandu.
    ieprieksejaKomanda = komanda;

    // 4. Iziet no spēles.
    if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
      try {
        GlobalScreen.unregisterNativeHook(); // Atāķē klaviatūras klausītāju.
        System.exit(0); // Iziet no programmas.
      } catch (NativeHookException nativeHookException) {
        nativeHookException.printStackTrace();
      }
    }
  }

  private void komandasApstrade(String taustins) {
    // 1. Izvēlas vai komanda būs ar lielajiem vai mazajiem burtiem.
    if (taustins.equals("Tab")) {
      // Toggle slēdzis.
      if (lielieBurti) {
        lielieBurti = false;
      } else {
        lielieBurti = true;
      }
    }
    // 2. Ieslēdz/Izslēdz komandasTekstaRakstisana režīmu.
    else if (taustins.equals("X")) {
      // Toggle slēdzis.
      if (komandasTekstaRakstisana) {
        beigtRakstitKomandasTekstu();
      } else {
        komandasTekstaRakstisana = true;
        atslegtaIevade = true;
      }

      komanda = K.TUKSA_IEVADE; // Nodzēš ievadi, lai nebūtu konfliktu ar komandām.
    }
    // 3. Saglabā ievadi jeb komandu.
    else if (lielieBurti) {
      komanda = taustins.toUpperCase();
    }
    else {
      komanda = taustins.toLowerCase();
    }
  }

 

  public void nativeKeyReleased(NativeKeyEvent e) {
    turTaustinu = false;
    uzreizNodzestKomandu();
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
      beigtRakstitKomandasTekstu();
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

  //
  //? Komandu jeb ievažu dzēšanas varianti:
  //

  public static void uzreizNodzestKomandu() {
    komanda = K.TUKSA_IEVADE;
  }
  
  public static void sagatavotKomanduDzesanai() {
    // Atļauj metodei 'nodzēstKomandu' pildīt savu darbu.
    if (!vaiIzpildijaKomandu) { 
      vaiIzpildijaKomandu = true;
    }
  }

  public static void nodzestKomandu() {
    // Nodzēš komandu, ja visas darbības ar to tika paveiktas.
    if (vaiIzpildijaKomandu) { 
      komanda = K.TUKSA_IEVADE;
    }
  }
    
  public static void nodzestCiklaKomandu() {
    Main.ciklaKomanda = K.TUKSA_IEVADE;
  }

  public static void nodzestKomanduJaNeENTER() {
    if (!komanda.toUpperCase().equals("ENTER")) {
      uzreizNodzestKomandu();
    }
  }

  // public void nativeKeyTyped(NativeKeyEvent e) {
  //     System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
  // }
}
