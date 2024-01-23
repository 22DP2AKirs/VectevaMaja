package Spele;
import java.util.Scanner;

import Spele.MazasSpeles.Karatavas;
import Spele.SpelesProcesi.Main;

public class Testi {
    public static void testaProgramma() throws InterruptedException {
        Scanner iLasitajs = new Scanner(System.in);
        Main.tiritEkranu();
        while (true) {
            System.out.print("\rJusu ievade: ");
            String ievade = iLasitajs.nextLine();


            Karatavas.apvienotaisKaratavasKods(ievade);

            for (String burts : Karatavas.ieprieksejieAtklatieBurti) {
                System.out.print(burts);
            }
            System.out.print("\033[F"); // Noliek mirgojošo kursoru vienu līniju uz augšu.


            Thread.sleep(0);
        }
    }
}
