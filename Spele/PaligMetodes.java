package Spele;

import java.util.ArrayList;

import Spele.Enums.Istabas;
import Spele.Enums.Virzieni;

public class PaligMetodes {
  // Šeit ir metodes, kuras atvieglos koda saprašanu un manu dzīvi.

  public static String saliktAtstarpesSimboluVirkne(String vards, int atstarpes) {
    // Atgriež vārdu ar atstarpēm starp burtiem jeb simboliem.
    String atstarpe = "";
    String apstradataVirkne = "";
    char[] virknesSimboli = vards.toCharArray();

    // 1. Izveido atstarpi pēc pieprasījuma.
    for (int i = atstarpes ; i > 0 ; i --) {
      atstarpe += " ";
    }

    // 2. Saliek atstarpes starp simboliem.
    for (char simbols : virknesSimboli) {
      apstradataVirkne += simbols + atstarpe;
    }

    // 3. Nogriež liekās atstarpes ' ' un atgriež rezultātu.
    return apstradataVirkne.strip();
  }

  public static String nonemtAtstarpes(String ievade) {
    int garums = ievade.length();
    String jaunaisVards = "";

    // Pārbauda visu vārdu.
    for (int i = 0 ; i < garums ; i++) {
      // Ja simbols nav atstarpe, tad ... .
      if (!(ievade.charAt(i) == ' ')) {
        jaunaisVards += ievade.charAt(i);
      }
    }

    return jaunaisVards;
  }

  public static void izvaditArrayListElementus(ArrayList<?> saraksts) {
    for (Object object : saraksts) {
      System.out.println(object);
    }
    System.out.println("--Elementu skaits: " + saraksts.size() + "--");
    System.out.print("\033[H"); // Kursora poz. 0.0
  }

  public static boolean navTuksasIevades(String ievade) {
    // * Pārbauda vai ievadē ir 'tukšas ievades' simbols [ } ].
    if (ievade.equals(K.TUKSA_IEVADE) || ievade.equals("")) {
      return false;
    }
    return true;
  }

  public static boolean navTuksaisIevadesSimbols(String ievade) {
    // * Pārbauda vai ievadē ir 'tukšas ievades' simbols [ } ].
    if (ievade.equals(K.TUKSA_IEVADE)) {
      return false;
    }
    return true;
  }

  public static boolean irSkaitlis(String ievade) {
    // * Pārbauda vai ievadi var pārveidot par skaitli.
    try {
      Integer.parseInt(ievade);
      return true;
    } 
    catch (Exception e) {
      return false;
    }
  }
  
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


  public static Istabas atrastIstabasEnumuPecTaCiparaVertibas(int vertiba) {
    // * Metode atrod no Istabas enumiem enumu, kura vērtība atbilsts norādītajai
    // * vērtībai, un pēc tam atgriež to.
    for (Istabas istaba : Istabas.values()) {
      if (istaba.CIPARS == vertiba) {
        return istaba;
      }
    }
    throw new RuntimeException(" Istabas enums ar norādīto vērtību " + vertiba + " neeksistē! ");
  }

  public static Virzieni atrastVirzienaEnumuPecTaCiparaVertibas(int vertiba) {
    // * Metode atrod no Virziena enumiem enumu, kura vērtība atbilsts norādītajai
    // * vērtībai, un pēc tam atgriež to.
    for (Virzieni virziens : Virzieni.values()) {
      if (virziens.CIPARS == vertiba) {
        return virziens;
      }
    }
    throw new RuntimeException(" Virziena enums ar norādīto vērtību " + vertiba + " neeksistē! ");
  }

  public static void masivuIzvade(String[] masivs) {
    // Izvada visus masīva elementus.
    for (int i = 0 ; i < masivs.length ; i++) {
      System.out.println(masivs[i] + "\033[0K");
    }
    System.out.println("\033[0J"); // Izdzēš visu tekstu līdz ekrāna beigām.
    System.out.print("\033[H"); // Noliek kursoru sākuma pozīcijā 0,0 jeb pirmās rindas pirmajā kolonnā.
  }
}