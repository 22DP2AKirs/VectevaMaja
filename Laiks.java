public class Laiks extends Thread {
    public static volatile int spelesLaiks; // Visiem pieejamais objekts.

    @Override
    public void run() {
        while (Main.speleSakas) {
            Laiks.spelesLaiks++; // Spēles laiks palielinas, katru sekundi jeb spēlesĀtrumu.

            // Katru sekundi nosaka vai spoks nāk par 1 fāzi tuvāk, vai pārkāpj 1 robežu.
            if (Spoki.logaSpoksAktivs && Spoki.vaiLogaSpoksVarKusteties) { // Pārbauda vai spoka kustība ir atļauta (vai spoks ir izvēlējies savu istabu) un 
                Spoki.logaSpokaDrosibasRobezas--; // Noņem vienu drošības robežu.
                if (Spoki.logaSpokaDrosibasRobezas <= 0) { // Kad spoks pārkāpj visas drošības robežas, tad viņš nākošajā kustībā nāk par 1 fāzi tuvāk un pēc tam, kāpj pāri nākošām robežām.
                    Spoki.logaSpokaFazesIndeks++; // Pietuvina spoku tuvāk logam.
                }
            }

            // Atbild par robežu pārkāpšanu un indeksu palielināšanu.
            if (Spoki.durSpoksAktivs && Spoki.vaiDurSpoksVarKusteties) {
                Spoki.durSpokaDrosibasRobezas--;
                if (Spoki.durSpokaDrosibasRobezas <= 0) {
                    Spoki.durSpokaFazesIndeks++;
                }
            }
            
            // Gulēšana līdz nākamam kadram.
            try {
                Thread.sleep(Main.spelesAtrums);
            } catch (Exception e) {
                // handle exception
                System.out.println("Ak nē! Kaut kas notika ar laiku!");
            }
        }
    }
}