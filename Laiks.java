public class Laiks extends Thread {
    public static volatile int spelesLaiks; // Visiem pieejamais objekts.

    @Override
    public void run() {
        while (Main.speleSakas) {
            Laiks.spelesLaiks++;

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