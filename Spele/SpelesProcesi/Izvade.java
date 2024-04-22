package Spele.SpelesProcesi;

import java.util.ArrayList;

import Spele.PaligMetodes;
import Spele.Izskati.UIizskats;

public class Izvade extends Thread {
  // Atbildīga par spēles izvadi uz konsoli.

  public static volatile String[] izvadesMasivs = new String[30]; // Visi ekrāni, piem., veikala ekrāns, karatavu grāmata, u.t.t.
  public static volatile String[] istabasBilde = new String[16]; // Tas, ko redz lietotājs staigājot pa māju (pati māja).
  public static volatile String[] apaksasUI = new String[14]; // Tas, kur ir rakstītas visas iespējamās komandas un kur var pārslēgties starp tām ar '1', '2', '3' un '4'.
  public static volatile String[] labasPusesUI = new String[30]; // Tas, kur rāda mājas mapi, laiku un mājasdarbus.

  // Būli, kuri nosaka programmas darbību.
  public static volatile boolean jaizvadaMasivs = true;

  // Iestata tikšķa jeb 1 "refreša" periodu.
  public static int framesPerSecond = 1000 / 60; // [1000] - Skaitlis, kuru dala, lai iegūtu FPS. [n] - Vēlamais FPS daudzums.

  private ArrayList<String> spelesIzvadesSaraksts = new ArrayList<>(); // Masīvs saturēs visu spēles grafisko informāciju.

  @Override
  public void run() {
    while(Main.programmaPalaista) {
      // 1. Ja spēles laikā ir jāizvada, kādu specifisku masīvu, tad to izdara.
      while (jaizvadaMasivs) {
        // Atver >> konsoli, kurā var redzēt rakstīto komandas tekstu.
        izvaditKonsoli();
        PaligMetodes.masivuIzvade(izvadesMasivs);
        
        // --- Cikla beigas jeb 1 freims 'fps'.
        try { Thread.sleep(framesPerSecond); } catch (Exception e) {}
      }

      // 2. Izvada spēles bildi.
      while (Main.spelePalaista) {
        izvaditKonsoli();
        
        System.out.println("\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\033[0K"); // Ekrāna augšējā daļa.

        // 2. Salīmē jeb sagatavo spēles izvadi.
        /// 2.1. Pievieno bildi.
        for (String bildesLinija : istabasBilde) {
          spelesIzvadesSaraksts.add("|" + bildesLinija + "|");
        }
        // 2.2. Pievieno apakšasUI.
        for (String linija : UIizskats.apaksasUISagatavosana()) {
          spelesIzvadesSaraksts.add("|" + linija + "|");
        }
        // 2.3. Pievieno labas puses UI.
        for (int i = 0; i < (UIizskats.labasPusesUISagatavosana().length); i++) {
          spelesIzvadesSaraksts.set(i, spelesIzvadesSaraksts.get(i) + UIizskats.labasPusesUISagatavosana()[i] + "|\033[0K");
        }

        // 3. Izvade terminālī.
        PaligMetodes.izvaditArrayListElementus(spelesIzvadesSaraksts);

        // 4. Darbības ar izvades kursoru.
        // System.out.println("\033[0J"); // Izdzēš visu tekstu līdz ekrāna beigām.
        System.out.print("\033[H"); // Noliek kursoru sākuma pozīcijā 0,0 jeb pirmās rindas pirmajā kolonnā.

        // 5. Attīra ArrayLists no visiem viņa elementiem, padarot to pilnībā tukšu.
        spelesIzvadesSaraksts.removeAll(spelesIzvadesSaraksts); 
        
        // --- Cikla beigas jeb 1 freims 'fps'.
        try { Thread.sleep(framesPerSecond); } catch (Exception e) {}
      }
    }
  }

  private void izvaditKonsoli() {
    System.out.println(TastaturasKlausitajs.rakstaKomandasTekstu + " >GK> " + 
    TastaturasKlausitajs.komandasTeksts + " >K> " + TastaturasKlausitajs.komanda + " >CK> " + Main.ciklaKomanda + " >Pabeidza> " + TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu + "\033[0K");


    if (TastaturasKlausitajs.atlautRakstitKomandasTekstu && TastaturasKlausitajs.rakstaKomandasTekstu) {
      System.out.println(">>> " + TastaturasKlausitajs.komandasTeksts + "\033[0K");
    }
  }
}
