package Spele.FailuLietotaji;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

// try (Scanner failuLasitajs = new Scanner(Paths.get("Iestatijumi.csv"))) { // Scanner() konstruktorā ieliek datus jeb failu, kuru viņam ir jālasa un Paths.get() iegūst ceļu uz šo failu pēc dotā faila nosaukuma.

public class FailuRedigetajs {
    // Izprintē jeb izvada visus faila datus.
    static void failuPrintetajs() {
        try (BufferedReader failuLasitajs = new BufferedReader(new FileReader("Spele\\Iestatijumi\\Iestatijumi.csv"))) {
            String linija;
            while ((linija = failuLasitajs.readLine()) != null) { // Lasa kamēr nav ticis līdz faila pēdējai līnijai.
                System.out.println(linija);
            }
        } catch (Exception e) {}
    }

    // Jebkurā uzrādītajā failā ieraksta norādīto tekstu.
    static void failuRakstitajs(String rakstamaisTeksts) {
        try (BufferedWriter rakstitajs = new BufferedWriter(new FileWriter("Spele\\Iestatijumi\\Iestatijumi.csv", true))) { // FileWriter(x, y) x - Faila nosaukums, y - append režīms (true - pieraksta, false - pārraksta).
            rakstitajs.write(rakstamaisTeksts);
            rakstitajs.close();
        } catch (Exception e) {}
    }

    // * Atgriež vērtības no nolasītā faila.
    // int.
    public static int intDatuAtgriezejs(String mainigaNosaukums) {
        try (BufferedReader mainigoDatuLasitajs = new BufferedReader(new FileReader("Spele\\Iestatijumi\\Iestatijumi.csv"))) {
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
    static String stringDatuAtgriezejs(String mainigaNosaukums) {
        try (BufferedReader mainigoDatuLasitajs = new BufferedReader(new FileReader("Spele\\Iestatijumi\\Iestatijumi.csv"))) {
            // Pareizās līnijas atrašana.
            String linija;
            // Darbošanās princips. !(boolean) => definē mainīgo "linija", katru reizi, kad nosacījums tiek pārbaudīts un pārbauda vai definējuma iekšā ir norādītā burtu virkne.
            while (!(linija = mainigoDatuLasitajs.readLine()).contains(mainigaNosaukums)) {}
            
            // Atrastās līnijas apstrāde.
            return linija.substring(linija.indexOf("=") + 1);
        } catch (Exception e) {}
        throw new RuntimeException("Iestatijumos vai ka parametrs mainigais String ar nosaukumu: " + mainigaNosaukums + " ir nepareizs!");
    }

    // boolean.
    public static boolean booleanDatuAtgriezejs(String mainigaNosaukums) {
        try (BufferedReader mainigoDatuLasitajs = new BufferedReader(new FileReader("Spele\\Iestatijumi\\Iestatijumi.csv"))) {
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
