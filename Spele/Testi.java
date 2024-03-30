package Spele;

import java.util.Scanner;
import Spele.Enums.EkranuVeidi;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Main;

public class Testi {
  public static void testaProgramma() throws InterruptedException { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    try ( Scanner iLasitajs = new Scanner(System.in) ) { // Izslēdz erroru 'lasītājs nav aizvērts'.
      Main.nodzestTerminali();
      
      System.out.print("Piespiesta ievade: ");
      String ievade = iLasitajs.nextLine();

      // AtrodiPari.izveidotJaunuKarsuSpeli();
      // AtrodiPari.atrodiPariObjekts.sagatavotRezgiSpelesanai();

    //   Karatavas.izveidotJaunuKaratavasSpeli();
    //   Karatavas.karatavasObjekts.sagatavotGramatuSpelesanai();

      // Cikls.
      while (true) {
        // Galvenā domāšana.
        Karatavas.karatavasObjekts.parbauditBurtu(ievade);

        // Izveido vārdu, kuru rādīs grāmatas lejā.
        Karatavas.karatavasObjekts.saliktCentretuVardaSkeletu();

        // Izvade terminālī.
        IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuVeidi.KARATAVU_EKRANS));
        // Izslēgšanas jeb uzvaras kods:
        if (Karatavas.karatavasObjekts.irAtminetsVards()) {
          PaligMetodes.gulet(2); // Gulēšana.
          break;
        }
        
        // Lietotāja ievade:
        System.out.print("\rJusu ievade: " + "\033[0K");
        ievade = iLasitajs.nextLine().toUpperCase();
      }

      Main.nodzestTerminali();
      System.out.println("Vards atminets!!!!");
    }
  }
}
