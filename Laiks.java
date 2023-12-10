public class Laiks extends Thread {
    public static volatile int spelesLaiks; // Visiem pieejamais objekts.

    @Override
    public void run() {
        while (Main.speleSakas) {
            Laiks.spelesLaiks++; // Spēles laiks palielinas, katru sekundi.
            // Loga spoka kustības katru sekundi.
            if (Spoki.logaSpoksAktivs && Spoki.logaRandomKustibasCipars < Spoki.maxLogaSpokaAgresivitate) {
                Spoki.logaSpokaDrosibasSkaitlis--;
                if (Spoki.logaSpokaDrosibasSkaitlis <= 0) {
                    Spoki.logaSpokaFazesIndeks++;
                }
            }
            
            // Gulēšana līdz nākamam kadram.
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // handle exception
                System.out.println("Ak nē! Kaut kas notika ar laiku!");
            }
        }
    }
}