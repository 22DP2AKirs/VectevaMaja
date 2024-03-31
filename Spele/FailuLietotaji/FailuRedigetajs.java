package Spele.FailuLietotaji;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import Spele.KontaKods.Konts;

// try (Scanner failuLasitajs = new Scanner(Paths.get("Iestatijumi.csv"))) { 
// Scanner() konstruktorā ieliek datus jeb failu, kuru viņam ir jālasa un Paths.get() iegūst ceļu uz šo failu pēc dotā faila nosaukuma.

public class FailuRedigetajs {

  public static void mainitFailaMainigaVertibu(String mainigais, String vertiba, String celsUzFailu) {
    // Savāc visu faila saturu pirms appendo failu.
    ArrayList<String> failuSaturs = atgriestFailaSarakstuArMainituMainigo(mainigais, vertiba, celsUzFailu);

    // ! new FileWriter(celsUzFailu, *append*) - append nodzēš visu failu saturu momentāli, kā viņš ieiet failā, tādēļ visas vēlamās darbības ar failu ir jādara pirms viņš ir 'appendots'.
    // ! Ja append ir 'true', tad rakstītājs rakstīs pa virsu failam.
    try (BufferedWriter failuRakstitajs = new BufferedWriter(new FileWriter(celsUzFailu))) { // FileWriter(x, y) x - Faila nosaukums, y - append režīms (true - pieraksta, false - pārraksta).
      // Pārraksta visu failu ar jaunu vērtību.
      for (String linija : failuSaturs) {
        failuRakstitajs.write(linija + "\n");
      }
      failuRakstitajs.close();
    } catch (Exception e) {}
  }

  public static ArrayList<String> atgriestFailaSarakstuArMainituMainigo(String mainigais, String vertiba, String celsUzFailu) {
    ArrayList<String> failuSaturs = atgriestFailuKaSarakstu(celsUzFailu);

    for (int i = 0 ; i < failuSaturs.size() ; i++) {
      // Atrod liniju ar mainīgo.
      if (failuSaturs.get(i).contains(mainigais)) {
        String atrastaLinija = failuSaturs.get(i);
        // x=5   atrod '5' indeksu.
        int mainigaVertibasIndekss = atrastaLinija.indexOf("=") + 1;
        // nomaina x=5 uz x=y.
        failuSaturs.set(i, atrastaLinija.substring(0, mainigaVertibasIndekss) + vertiba); 
        break;
      }
    }

    return failuSaturs;
  }

  public static ArrayList<String> atgriestFailuKaSarakstu(String celsUzFailu) {
    try (BufferedReader failaLasitajs = new BufferedReader(new FileReader(celsUzFailu))) { // Atver norādīto failu.
      String linija; // Faila līnija.
      ArrayList<String> failaSaturs = new ArrayList<>();

      // Sarakstā ievieto katru faila līniju.
      while((linija = failaLasitajs.readLine()) != null) {
        failaSaturs.add(linija);
      }

      return failaSaturs;

    } catch (Exception e) {}
    throw new RuntimeException("Kluda ar saraksta veidosanu. Cels uz failu: " + celsUzFailu);
  }

  public static String failuParveidotajsParTekstu() {
    // Nolasa un saglabā norādītā faila saturu kā vienu 'String' jeb rakstzīmju virknes līniju.
    String linija; // Uz īsu brīdi saglabā nolasīto līniju.
    String failuTeksts = ""; // Metodes darbības rezultāts, ko atgriezīs.

    try (BufferedReader failuLasitajs = new BufferedReader(new FileReader("Spele/Iestatijumi/Iestatijumi.csv"))) {
      while ((linija = failuLasitajs.readLine()) != null) { // Lasa kamēr nav ticis līdz faila pēdējai līnijai.
        failuTeksts += linija + "\n";
      }
    } catch (Exception e) {}

    return failuTeksts;
  }

  public static String nonemtLinijuNoFaila(String tekstaLinijaKoNonemt, String celsUzFailu) {
    // Nolasa, atrod norādīto līniju, noignorē to un turpina lasīt līdz faila beigām, atgriežot visu nolasīto tekstu.
    String linija; // Uz īsu brīdi saglabā nolasīto līniju.
    String failaTeksts = ""; // Metodes darbības rezultāts, ko atgriezīs.

    try (BufferedReader failuLasitajs = new BufferedReader(new FileReader(celsUzFailu))) {
      while ((linija = failuLasitajs.readLine()) != null) { // Lasa kamēr nav ticis līdz faila pēdējai līnijai.
        // Ja līnijā nav norādītā teksta, tad to saglabā.
        if (!linija.contains(tekstaLinijaKoNonemt)) {
          failaTeksts += linija + "\n";
        }
      }
    } catch (Exception e) {}

    return failaTeksts;
  }

  public static void failuVeidotajs(String rakstamaisTeksts) {
    // Izveido failu norādītajā vietā.
    System.out.println(new File("Spele/KontaKods/Konti").list().length);
    try (BufferedWriter rakstitajs = new BufferedWriter(new FileWriter("Spele/KontaKods/Konti/Konts" + new File("Spele/KontaKods/Konti").list().length + ".txt", false))) { // FileWriter(x, y) x - Faila nosaukums, y - append režīms (true - pieraksta, false - pārraksta).
      rakstitajs.write(rakstamaisTeksts);
      rakstitajs.close();
    } catch (Exception e) {}
  }

  public static void failuPrintetajs() {
    // Izprintē jeb izvada visus faila datus.
    try (BufferedReader failuLasitajs = new BufferedReader(new FileReader("Spele/Iestatijumi/Iestatijumi.csv"))) {
      String linija;
      while ((linija = failuLasitajs.readLine()) != null) { // Lasa kamēr nav ticis līdz faila pēdējai līnijai.
        System.out.println(linija);
      }
    } catch (Exception e) {}
  }

  public static void failuRakstitajs(String rakstamaisTeksts, String celsUzFailu) {
    // Jebkurā uzrādītajā failā ieraksta norādīto tekstu.
    try (BufferedWriter rakstitajs = new BufferedWriter(new FileWriter(celsUzFailu, true))) { // FileWriter(x, y) x - Faila nosaukums, y - append režīms (true - pieraksta, false - pārraksta).
      rakstitajs.write(rakstamaisTeksts + "\n");
      rakstitajs.close();
    } catch (Exception e) {}
  }

    // * Atgriež vērtības no nolasītā faila.
    // int.
    public static int intDatuAtgriezejs(String mainigaNosaukums) {
        try (BufferedReader mainigoDatuLasitajs = new BufferedReader(new FileReader("Spele/Iestatijumi/Iestatijumi.csv"))) {
            // Pareizās līnijas atrašana.
            String linija;
            // Darbošanās princips. !(boolean) => definē mainīgo "linija", katru reizi, kad nosacījums tiek pārbaudīts un pārbauda vai definējuma iekšā ir norādītā burtu virkne.
            while (!(linija = mainigoDatuLasitajs.readLine()).contains(mainigaNosaukums)) {}
            
            // Atrastās līnijas apstrāde.
            int saglabataMainigaVertiba = Integer.valueOf(linija.substring(linija.indexOf("=") + 1));

            return saglabataMainigaVertiba;
        } catch (Exception e) {}
        throw new RuntimeException("Iestatijumos vai ka parametrs mainigais int ar nosaukumu: " + mainigaNosaukums + " ir nepareizs!");
    }

    // String.
    public static String stringDatuAtgriezejs(String mainigaNosaukums, String celsUzFailu) {
        try (BufferedReader mainigoDatuLasitajs = new BufferedReader(new FileReader(celsUzFailu))) {
            // Pareizās līnijas atrašana.
            String linija;
            // Darbošanās princips. !(boolean) => definē mainīgo "linija", katru reizi, kad nosacījums tiek pārbaudīts un pārbauda vai definējuma iekšā ir norādītā burtu virkne.
            while (!(linija = mainigoDatuLasitajs.readLine()).contains(mainigaNosaukums)) {}
            
            // Atrastās līnijas apstrāde.
            return linija.substring(linija.indexOf("=") + 1);
        } catch (Exception e) {}
        throw new RuntimeException("Iestatijumos vai ka parametrs mainigais String ar nosaukumu: " + mainigaNosaukums + " ir nepareizs! : " + Konts.lietotajaKontaCels);
    }

    // boolean.
    public static boolean booleanDatuAtgriezejs(String mainigaNosaukums, String celsUzFailu) {
        try (BufferedReader mainigoDatuLasitajs = new BufferedReader(new FileReader(celsUzFailu))) {
          
            // Pareizās līnijas atrašana.
            String linija;
            // Darbošanās princips. !(boolean) => definē mainīgo "linija", katru reizi, kad nosacījums tiek pārbaudīts un pārbauda vai definējuma iekšā ir norādītā burtu virkne.
            while (!(linija = mainigoDatuLasitajs.readLine()).contains(mainigaNosaukums)) {}
            
            // Atrastās līnijas apstrāde.
            String tekstaDala = linija.substring(linija.indexOf("=") + 1);
            if (tekstaDala.equals("T")) {
                return true;
            } 
            else if (tekstaDala.equals("F")){
                return false;
            }
        } catch (Exception e) {}
        throw new RuntimeException("Iestatijumos vai ka parametrs mainigais boolean ar nosaukumu: " + mainigaNosaukums + " ir nepareizs!");
    }
}
