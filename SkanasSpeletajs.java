import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class SkanasSpeletajs extends Thread {
    @Override
    public void run() {
        while (Main.speleSakas) {
            SpeletSkanu("Skanas faili\\ambiance-sakana.wav", -5);
            try {
                Thread.sleep(96000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    static void SpeletSkanu(String celsUzFailu, float skalumsDecibelos) {
        try {
            File skanasCels = new File(celsUzFailu);
            if (skanasCels.exists()) {
                AudioInputStream audioIevade = AudioSystem.getAudioInputStream(skanasCels);
                Clip klips = AudioSystem.getClip();
                klips.open(audioIevade);
                FloatControl iegutKontroli = (FloatControl) klips.getControl(FloatControl.Type.MASTER_GAIN);
                iegutKontroli.setValue(skalumsDecibelos); // Reduce volume by 10 decibels.
                klips.start();
            } else {
                System.out.println("Nevar atrast failu.");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
