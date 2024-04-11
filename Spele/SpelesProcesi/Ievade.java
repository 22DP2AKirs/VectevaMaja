package Spele.SpelesProcesi;

import java.util.Scanner;
import Spele.K;

public class Ievade extends Thread {
  // volatile modifier ir, lai objekts sinhronizējas starp visiem Thrediem.
  private Scanner ievadesLasitajs = new Scanner(System.in); // Parastais lasītājs, kurš lasīs lietotāja ievadi.
  // public static volatile String lietotajaIevade = K.TUKSA_IEVADE; // Definēju mainīgo, lai kods tālāk spētu viņu visu laiku dublicēt (šinī gadījumā saglabāt).
  public static String neapstradataLietotajaIevade = ""; // Nepārveidota uz lieliem burtiem.

  public static boolean vaiKomanduIzpildija = true; // Ļauj ievadītajām darbībām būt izpildītām pirms tās tiek nodzēstas.
  
  public void run() { // Threds vienmēr lasa ievadi, vienalga uz to, kas notiek apkārt.
    // Threds strādās, kamēr cikls ir aktīvs.
    while (Main.programmaPalaista) {
      neapstradataLietotajaIevade = ievadesLasitajs.nextLine();
      // lietotajaIevade = neapstradataLietotajaIevade.toUpperCase(); // Pārveido visas ievades uz liliem burtiem.

      vaiKomanduIzpildija = false; // Pēc ievades saglabāšanas, notiritIevadi() netīrīs ievadi, līdz VaronaDarbibas izpildīs ievadīto komandu.
      System.out.print("\033[F"); // Noliek mirgojošo kursoru vienu līniju uz augšu.
      
      // - !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Problēmas ar \033[F , jāatrod aizvietojums. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
  }

  public static void sagatavotKomanduDzesanai() {
      // ! Metode atļauj programmas cikla beigās notīrīt ievadi.
      // Šai metodei ir jābūt 'komandu izpildes' metodes beigās.
    if (!vaiKomanduIzpildija) { 
      vaiKomanduIzpildija = true;
    }
  }
  
  public static String[] ieprieksejaIevade(String ievade) { 
    // * Metode atgriež ievadi sadalītu pa burtiem.

    String[] galaIevade = new String[10];

    // Ja ievade ir garāka par 10 simboliem, tad komandā to uzrādīs ar vairākām issaukuma zīmēm [!].
    if (ievade.length() > 10) { 
      ievade = "!!!!!!!!!!";
    } else if (ievade.equals("")) {
      ievade = "ENTER";
    }

    String[] pagaiduIevade = ievade.split(""); // Sadala ievadi pa burtiem jeb pa simboliem.
    int pagaiduIevadesElementuSk = pagaiduIevade.length; // Nosaka elementu skaitu.

    // Ja komanda bija īsāka par 10 elementiem, tad pie izvades pieliks "_" simbolus,
    // lai uzrādītu cik burtus vēl varēja ievadīt līdz max. Piem:
    // I E T _ _ _ _ _ _ _, A B O L S _ _ _ _ _, B U M B I E R I S _.
    if((pagaiduIevadesElementuSk) < 11) {
      for (int i = 0; i < 10; i++) {
        if (i < pagaiduIevadesElementuSk){
          galaIevade[i] = pagaiduIevade[i];
        } else {
          galaIevade[i] = "_";
        }
      }
    }

    // Atgriež apstrādātu iepriekšējo ievadi.
    return galaIevade; 
  }

  // public static void notiritKomandu() {
  //   // ! Ievade ir jātīra cikla beigās, lai visas metodes (tās, kuras izmanto ievadi) izpildītos pareizi.
  //   // * Šī metode nomaina ievadi uz [ } ] simbolu,
  //   // * jo šinī spēlē tas simbols nozīmē tukša ievade jeb ievades nav (simbols tiks ignorēts).

  //   // Ja komanda tika izpildīta, tad to var nodzēst.
  //   if (vaiKomanduIzpildija) { 
  //     Ievade.lietotajaIevade = K.TUKSA_IEVADE;
  //   }
  // }

  // public static void pilnibaNotiritIevadi() {
  //   // Notīra ievadi bez pārbaudēm un nosacījumiem.
  //   Ievade.lietotajaIevade = K.TUKSA_IEVADE;
  // }
}
