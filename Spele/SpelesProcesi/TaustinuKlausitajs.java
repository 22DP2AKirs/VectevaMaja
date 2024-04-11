package Spele.SpelesProcesi;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import Spele.K;

public class TaustinuKlausitajs implements NativeKeyListener {
  public static volatile String komanda = K.TUKSA_IEVADE;
  private boolean turTaustinu;
  private static boolean vaiIzpildijaKomandu;

  

  public static void palaistKlaviaturasLasitaju() {
    try {
      GlobalScreen.registerNativeHook();
    }
    catch (NativeHookException ex) {
      System.err.println("There was a problem registering the native hook.");
      System.err.println(ex.getMessage());

      System.exit(1);
    }
    GlobalScreen.addNativeKeyListener(new TaustinuKlausitajs());
  }

  public void nativeKeyPressed(NativeKeyEvent taustins) {
    // 1. Atļauj nolasīt taustiņu tikai vienu reizi (netiek lasīti vairāki eventi, kad tur taustinu (pirms: aaaaaaaaaa, pēc: a (Kad atlaiž) a ...)).
    if (!turTaustinu) {
      turTaustinu = true;
      vaiIzpildijaKomandu = false;
      komanda = NativeKeyEvent.getKeyText(taustins.getKeyCode()).toUpperCase();
      // System.out.println("Key Pressed: " + komanda);
    }

    if (taustins.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
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
    
    // System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
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
