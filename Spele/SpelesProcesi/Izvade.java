package Spele.SpelesProcesi;

import java.util.ArrayList;

import Spele.Iestatijumi;
import Spele.K;
import Spele.PaligMetodes;
import Spele.Izskati.UIizskats;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.MazasSpeles.AtrodiPari.AtrodiPariSavienojums;
import Spele.MazasSpeles.Karatavas.KaratavasSavienojums;
import Spele.Spoki.Spoks;
import Spele.Varonis.VaronaStatusaEfekti;

public class Izvade extends Thread {
  // Atbildīga par spēles izvadi uz konsoli.

  public static volatile String[] 
  izvadesMasivs = new String[30], // Visi ekrāni, piem., veikala ekrāns, karatavu grāmata, u.t.t.
  istabasBilde = new String[16], // Tas, ko redz lietotājs staigājot pa māju (pati māja).
  apaksasUI = new String[14], // Tas, kur ir rakstītas visas iespējamās komandas un kur var pārslēgties starp tām ar '1', '2', '3' un '4'.
  labasPusesUI = new String[30]; // Tas, kur rāda mājas mapi, laiku un mājasdarbus.

  // Būli, kuri nosaka programmas darbību.
  public static volatile boolean 
  jaizvadaMasivs = true, jaizvadaSpele = true;

  // Iestata tikšķa jeb 1 "refreša" periodu.
  public static int framesPerSecond = 1000 / Iestatijumi.kadriSekunde; // [1000] - Skaitlis, kuru dala, lai iegūtu FPS. [n] - Vēlamais FPS daudzums.

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
        // ------------------ Papildus.
        if (Main.programmasKluduLasisana) { // Apstādina spēli, lai varētu izlasīt kļūdas aprakstu (parasti vienmēr izslēgts).
          PaligMetodes.gulet(100);
        }
      }

      // 2. Izvada spēles bildi.
      while (jaizvadaSpele) {
        informacijasIzvade();
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
        PaligMetodes.izvaditArrayListElementus(spelesIzvadesSaraksts, false);

        // 4. Darbības ar izvades kursoru.
        System.out.println("\033[0J"); // Izdzēš visu tekstu līdz ekrāna beigām.
        System.out.print("\033[H"); // Noliek kursoru sākuma pozīcijā 0,0 jeb pirmās rindas pirmajā kolonnā.

        // 5. Attīra ArrayLists no visiem viņa elementiem, padarot to pilnībā tukšu.
        spelesIzvadesSaraksts.removeAll(spelesIzvadesSaraksts); 
        
        // --- Cikla beigas jeb 1 freims 'fps'.
        try { Thread.sleep(framesPerSecond); } catch (Exception e) {}
        // ------------------ Papildus.
        if (Main.programmasKluduLasisana) { // Apstādina spēli, lai varētu izlasīt kļūdas aprakstu (parasti vienmēr izslēgts).
          PaligMetodes.gulet(100);
        }
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

  public static void ieslegtMasivaIzvadi() {
    // Ieslēdz masīvu izvadi, un izslēdz bildes izvadi.
    Izvade.jaizvadaMasivs = true;
    Izvade.jaizvadaSpele = false;
  }

  public static void ieslegtSpelesIzvadi() {
    // Izslēdz masīvu izvadi, un ieslēdz bildes izvadi.
    Izvade.jaizvadaSpele = true;
    Izvade.jaizvadaMasivs = false;
  }

  private static void informacijasIzvade() {
    // * Ievāc info. kategoriju, kuru izvadīt virs ekrana.
    // * Testeru metode.

    // Izvada informāciju par spokiem.
    if (Main.spokuInfo) { 
      Spoks.spokuInfo();
      izvaditSpelesPapildinformaciju();
    }
    // Izvada informāciju par m-spēlēm.
    else if (Main.mSpeluInfo) {
      izvaditMSpelesInfo();
    }
  }

  private static void izvaditMSpelesInfo() {
    System.out.println();
    System.out.println("Ieksa m-spele: " + MazoSpeluIzvelesKods.varonisIrMazajaSpele + ", Izveleta m-spele: " + MazoSpeluIzvelesKods.izveletaMazaSpele + "\033[0K");
    System.out.println("Izveleta spele: (Karatavas : " + KaratavasSavienojums.mSpeleKaratavas + "), (Atrodi pari : " + AtrodiPariSavienojums.mSpeleAtrodiPari + ")\033[0K");
    System.out.println("Laiks lidz majasdarbam: " + MazoSpeluIzvelesKods.laiksLidzJaunamMajasdarbamMainigais + " no " + MazoSpeluIzvelesKods.laiksLidzJaunamMajasdarbamNemainigais + "\033[0K");
    izvaditSpelesPapildinformaciju();
  }

  private static void izvaditSpelesPapildinformaciju() {
    System.out.println("Laiks ms: " + Laiks.spelesLaiks + " / " + Laiks.vienaStunda * 6 + K.RESET + ", Stressa limenis: " + VaronaStatusaEfekti.varonaStresaLimenis + "\033[0K");
  }
}