import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

// try (Scanner failuLasitajs = new Scanner(Paths.get("Iestatijumi.csv"))) { // Scanner() konstruktorā ieliek datus jeb failu, kuru viņam ir jālasa un Paths.get() iegūst ceļu uz šo failu pēc dotā faila nosaukuma.

public class FailuRedigetajs {
    static void failuLasitajs() {
        try (BufferedReader failuLasitajs = new BufferedReader(new FileReader("Iestatijumi.csv"))) {
            String linija;
            while ((linija = failuLasitajs.readLine()) != null) { // Lasa kamēr nav ticis līdz faila pēdējai līnijai.
                System.out.println(linija);
            }
        } catch (Exception e) {}
    }

    static void failuRakstitajs(String rakstamaisTeksts) {
        try (BufferedWriter rakstitajs = new BufferedWriter(new FileWriter("Iestatijumi.csv", true))) { // FileWriter(x, y) x - Faila nosaukums, y - append režīms (true - pieraksta, false - pārraksta).
            rakstitajs.write(rakstamaisTeksts);
            rakstitajs.close();
        } catch (Exception e) {}
    }
}
