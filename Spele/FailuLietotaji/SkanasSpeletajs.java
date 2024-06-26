package Spele.FailuLietotaji;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import Spele.PaligMetodes;
import Spele.SakumaDatuSagatavosana.SakumaDati;
import Spele.SpelesProcesi.Main;

public class SkanasSpeletajs extends Thread {
  @Override
  public void run() {
    if (SakumaDati.ieslegtaSkana) {
      while (Main.programmaPalaista) {
        SpeletSkanu("Spele\\SkanasFaili\\ambiance-sakana.wav", -3);
        PaligMetodes.gulet(360);
      }
    }
  }

  public static void SpeletSkanu(String celsUzFailu, float skalumsDecibelosMax6) {
    if (SakumaDati.ieslegtaSkana) {
      try {
        File skanasCels = new File(celsUzFailu);
        if (skanasCels.exists()) {
          AudioInputStream audioIevade = AudioSystem.getAudioInputStream(skanasCels);
          Clip klips = AudioSystem.getClip();
          klips.open(audioIevade);
          FloatControl iegutKontroli = (FloatControl) klips.getControl(FloatControl.Type.MASTER_GAIN);
          iegutKontroli.setValue(skalumsDecibelosMax6); // Reduce volume by 10 decibels.
          klips.start();
        } else {
          throw new RuntimeException("Nevar atrast skaņas failu.");
        }
      } catch (Exception e) {}
    }
  }
}
