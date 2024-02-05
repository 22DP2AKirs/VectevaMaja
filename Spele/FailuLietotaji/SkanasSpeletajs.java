package Spele.FailuLietotaji;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import Spele.SpelesProcesi.Main;


public class SkanasSpeletajs extends Thread {
    @Override
    public void run() {
        if (Main.ieslegtaSkana) { // Nosaka vai spēlē būs skaņa.
            while (Main.spelePalaista) {
                SpeletSkanu("Spele\\SkanasFaili\\ambiance-sakana.wav", -5);
                try {
                    Thread.sleep(96000);
                } catch (Exception e) {
                    //  handle exception
                }
            }
        }
    }

    public static void SpeletSkanu(String celsUzFailu, float skalumsDecibelos) {
        if (Main.ieslegtaSkana) {  // Nosaka vai spēlē būs skaņa.
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
                    throw new RuntimeException("Nevar atrast skaņas failu.");
                }
            } catch (Exception e) {}
        }
    }
}
