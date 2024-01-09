public class Laiks extends Thread {
    public static volatile int spelesLaiks; // Visiem pieejamais objekts.
    public static String laikaTeksts = "1 2 P M ";
    public static int vienaStunda = Main.spelesIlgums / 6;

    static int gaidisanasLaiks;

    @Override
    public void run() {
        while (Main.speleSakas) {
            Laiks.spelesLaiks++; // Spēles laiks palielinas, katru sekundi jeb spēlesĀtrumu.
            
            if (spelesLaiks == vienaStunda) {
                laikaTeksts = " 1 A M  ";
            } else if (spelesLaiks == vienaStunda * 2) {
                laikaTeksts = " 2 A M  ";
            } else if (spelesLaiks == vienaStunda * 3) {
                laikaTeksts = " 3 A M  ";
            } else if (spelesLaiks == vienaStunda * 4) {
                laikaTeksts = " 4 A M  ";
            } else if (spelesLaiks == vienaStunda * 5) {
                laikaTeksts = " 5 A M  ";
            } else if (spelesLaiks == vienaStunda * 6) {
                laikaTeksts = " 6 A M  ";
                Main.speleSakas = false;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                Main.tiritEkranu();
                System.out.println("\n\n\n\nJus izdzivojat!!!\n\n\n\n\n");
                System.out.println("<SPIEDIET ENTER>");
                break;
            }

            if (!VaronaDarbibas.elektribaIeslegta) { // Ja false, tad ...
                if (gaidisanasLaiks <= 0) {
                    SkanasSpeletajs.SpeletSkanu("Skanas faili\\fuse-box-turning-on-off.wav", 0);
                    VaronaDarbibas.elektribaIeslegta = true;
                }
                gaidisanasLaiks--;
            }

            if (VaronaDarbibas.aizdedzinatsSerkocins && VaronaDarbibas.serkocinaDegsanasLaiks != Main.maxSerkocinaDegsanasLaiks) {
                VaronaDarbibas.serkocinaDegsanasLaiks++;
            } else {
                VaronaDarbibas.aizdedzinatsSerkocins = false;
                VaronaDarbibas.serkocinaDegsanasLaiks = 0;
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
                Thread.sleep(1000); // 1000 = 1 sekunde.
            } catch (Exception e) {}
        }
    }
}