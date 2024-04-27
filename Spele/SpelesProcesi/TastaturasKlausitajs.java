package Spele.SpelesProcesi;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import Spele.K;

public class TastaturasKlausitajs implements NativeKeyListener {
  public static volatile String komanda = K.TUKSA_IEVADE;
  public static volatile String komandasTeksts = K.TUKSA_IEVADE;
  public static volatile String ieprieksejaKomanda = K.TUKSA_IEVADE;

  public static volatile boolean rakstaKomandasTekstu;
  public static volatile boolean atlautRakstitKomandasTekstu;

  public static boolean lielieBurti = true;
  public static boolean atslegtaIevade; // Atļauj spiest un turēt jebkurus taustiņus vienlaicīgi.
  public static boolean bijaEnter;

  static boolean vaiIzpildijaKomandu;
  private static boolean turTaustinu;

  public static volatile boolean pabeidzaRakstitKomandasTekstu;

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

  public void nativeKeyPressed(NativeKeyEvent e) {
    // ? Darbības, kad nospiež taustiņu.
    // 1. Nosaka, kāds taustiņš tika nospiests.
    String taustins = NativeKeyEvent.getKeyText(e.getKeyCode());

    // 2. Izvēlas rakstīšanas režīmu.
    if (atslegtaIevade) {
      komandasApstrade(taustins);
    }
    else {
      if (!turTaustinu) {   
        turTaustinu = true; 
        komandasApstrade(taustins);
      }
    }

    // 3. Paziņo, ka ir jauna komanda, kura ir gatava izpildei.
    vaiIzpildijaKomandu = false;

    // 5. Iziet no spēles.
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
    // uzreizNodzestKomandu();
  }

  public static void komandasTekstaFunkcija() {
    // 1. Nodzēš komandas tekstu.
    if (pabeidzaRakstitKomandasTekstu) {
      pabeidzaRakstitKomandasTekstu = false;
      nodzestKomandasTekstu();
    }

    // 2. Darbības ar komandas tekstu.
    if (!komanda.equals(K.TUKSA_IEVADE)) { // ! Noņem visus 'delays' jeb komandas rakstīšanas kavēšanos!!!
      TastaturasKlausitajs.komandasTekstaSledzis();
      TastaturasKlausitajs.rakstitKomandasTekstu();
    }
  }

  public static void definetCiklaKomandu() {
    // 1. Jauna cikla sākumā nodzēš iepriekšējo jeb jau apstrādāto komandu.
    if (!Main.ciklaKomanda.equals(K.TUKSA_IEVADE)) {
      Main.ciklaKomanda = K.TUKSA_IEVADE;
    }
    
    // 2. Ja komanda nav tukša, tad definē jauno cikla komandu. // ! Šis noņem milzīgo ievades kavēšanos.
    if (!komanda.equals(K.TUKSA_IEVADE)) {
      Main.ciklaKomanda = komanda;
      ieprieksejaKomanda = komanda;
      uzreizNodzestKomandu();
    }
  }

  public static boolean komandaNavTuksa() {
    return !komanda.equals(K.TUKSA_IEVADE);
  }

  public static void beigtRakstitKomandasTekstu() {
    rakstaKomandasTekstu = false;
    atslegtaIevade = false;
  }

  public static void ieslegtKomandasTekstaFunkciju() {
    atlautRakstitKomandasTekstu = true;
    beigtRakstitKomandasTekstu();
  }

  public static void izslegtKomandasTekstaFunkciju() {
    atlautRakstitKomandasTekstu = false;
    beigtRakstitKomandasTekstu();
  }

  public static void komandasTekstaSledzis() {
    if (komanda.toUpperCase().equals("X")) {
      // Ieslēdz/Izslēdz komandasTekstaRakstisana režīmu.
      if (rakstaKomandasTekstu) { // Ja ieslēgts.
        atlautRakstitKomandasTekstu = false;
        beigtRakstitKomandasTekstu();
      } else { // Ja izslēgts.
        atlautRakstitKomandasTekstu = true;
        rakstaKomandasTekstu = true;
        atslegtaIevade = true;
      }
      uzreizNodzestKomandu();
      nodzestKomandasTekstu();
    }
  }

  public static void rakstitKomandasTekstu() {
    // Atļauj jebkurā programmas daļā pieņemt 'komandasTekstu' kā ievades opciju.
    // 1. Ja kTR ir true jeb ir uzspiests 'x'.
    if (rakstaKomandasTekstu && atlautRakstitKomandasTekstu) {
      // 1.1 Raksta kT (komandasTekstu), un izsdzēš komandas ja tās nav 'ENTER', bet ja ir, tad izsauc metodi 'izslegtKomandasTekstaRakstisanu()'.
      limetKomandasTekstu();
    }
  }

  public static void nodzestKomandasTekstu() {
    komandasTeksts = K.TUKSA_IEVADE;
  }

  public static void limetKomandasTekstu() {
    // 1. Ļauj līmēt komandasTekstu ar visiem pielāgojumiem programmai.
    komandasTeksts = limetVardu(komandasTeksts, komanda);

    // 2. Izslēdz komandas rakstīšanas funkc.
    if (komanda.toUpperCase().equals("ENTER")) {
      pabeidzaRakstitKomandasTekstu = true; // Aizvietojums 'ENTER' taustiņam, lai nerastos kļūdas ar komanda='ENTER' programmā.
      ieprieksejaKomanda = komandasTeksts;
      beigtRakstitKomandasTekstu();
    }
    else {
      // Izslēdz komandas teksta rakstīšanas funkc..
      pabeidzaRakstitKomandasTekstu = false;
    }

    uzreizNodzestKomandu();
  }

  //
  // ? Vārdu līmēšanas metodes.
  //

  public static String limetVardu(String vards, String ievade) {
    // Līmē nospiestos burtus, lai veidotu vārdu, piem., : <- a ; :a <- b ; : ab <- o ; u.t.t.

    // 1. Nosaka, kāda darbība būs veikta ar simbolu virkni.
    if (ievade.toUpperCase().equals("BACKSPACE") && vards.length() > 0) {
      // Atņem pēdējo simbolu.
      vards = vards.substring(0, vards.length() - 1);
    }
    else {
      // Ja komanda ir 1 simbols, tad ... .
      if (ievade.length() < 2) {
        vards += ievade;
      }
    }

    return vards;
  }

  public static String limetVardu(String vards, String ievade, int maxVardaGarums) {
    // Līmē nospiestos burtus, lai veidotu vārdu, piem., : <- a ; :a <- b ; : ab <- o ; u.t.t.

    // 1. Nosaka, kāda darbība būs veikta ar simbolu virkni.
    if (ievade.toUpperCase().equals("BACKSPACE") && vards.length() > 0) {
      // Atņem pēdējo simbolu.
      vards = vards.substring(0, vards.length() - 1);
    }
    else {
      // Ja komanda ir 1 simbols un ja vārds nav pāri max garumam, tad ... .
      if (ievade.length() < 2 && vards.length() < maxVardaGarums) {
        vards += ievade;
      }
    }

    return vards;
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

  public static void enterSledzis() {
    if (komanda.toUpperCase().equals("ENTER")) {
      bijaEnter = (bijaEnter) ? false : true; // Toggle slēdzis.
      uzreizNodzestKomandu();
    }
  }

  // public void nativeKeyTyped(NativeKeyEvent e) {
  //     System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
  // }
}
