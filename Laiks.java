public class Laiks extends Thread {
    public static volatile int spelesLaiks; // Visiem pieejamais objekts.
    public static String laikaTeksts = "1 2 PM";
    public static int vienaStunda = Main.spelesIlgums / 6;
    @Override
    public void run() {
        while (Main.speleSakas) {
            Laiks.spelesLaiks++; // Spēles laiks palielinas, katru sekundi jeb spēlesĀtrumu.

            if (spelesLaiks == vienaStunda) {
                laikaTeksts = "  1 AM";
            } else if (spelesLaiks == vienaStunda * 2) {
                laikaTeksts = "  2 AM";
            } else if (spelesLaiks == vienaStunda * 3) {
                laikaTeksts = "  3 AM";
            } else if (spelesLaiks == vienaStunda * 4) {
                laikaTeksts = "  4 AM";
            } else if (spelesLaiks == vienaStunda * 5) {
                laikaTeksts = "  5 AM";
            } else if (spelesLaiks == vienaStunda * 6) {
                laikaTeksts = "  6 AM";
                Main.speleSakas = false;
                Main.tiritEkranu();
                System.out.println("Jūs izdzīvojāt!!!\n\n\n\n\n");
                System.out.println("<SPIEDIET ENTER>");
                break;
            }

            // Katru sekundi nosaka vai spoks nāk par 1 fāzi tuvāk, vai pārkāpj 1 robežu.
            if (Spoki.logaSpoksAktivs && Spoki.vaiLogaSpoksVarKusteties) { // Pārbauda vai spoka kustība ir atļauta (vai spoks ir izvēlējies savu istabu) un 
                if (Spoki.logaSpokaDrosibasRobezas <= 0) { // Kad spoks pārkāpj visas drošības robežas, tad viņš nākošajā kustībā nāk par 1 fāzi tuvāk un pēc tam, kāpj pāri nākošām robežām.
                    Spoki.logaSpokaFazesIndeks++; // Pietuvina spoku tuvāk logam.
                }
                Spoki.logaSpokaDrosibasRobezas--; // Noņem vienu drošības robežu.
            }

            // Atbild par robežu pārkāpšanu un indeksu palielināšanu.
            if (Spoki.durSpoksAktivs && Spoki.vaiDurSpoksVarKusteties) {
                if (Spoki.durSpokaDrosibasRobezas <= 0) {
                    Spoki.durSpokaFazesIndeks++;
                }
                Spoki.durSpokaDrosibasRobezas--;
            }

            // Virtuves spoks.
            if (Spoki.virSpoksAktivs && Spoki.vaiVirSpoksVarKusteties) {
                if (Spoki.virSpokaDrosibasRobezas <= 0) {
                    Spoki.virSpokaFazesIndeks++;
                }
                Spoki.virSpokaDrosibasRobezas--;
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