package Spele;


import java.util.Scanner;

import Spele.MazasSpeles.AtrodiPari.AtrodiPari;
import Spele.SpelesProcesi.Main;

public class Testi {
  public static void testaProgramma() throws InterruptedException { // throws  InterruptedException, Lai varētu izmantot: Thread.sleep(0); bez try_catch.
    // Sagatave pirms spēles cikla.
    Scanner iLasitajs = new Scanner(System.in);
    Main.nodzestTerminali();
    
    String ievade = iLasitajs.nextLine();

    AtrodiPari.izveidotJaunuKarsuSpeli();
    AtrodiPari.atrodiPari.sagatavotRezgiSpelesanai();

    // Cikls.
    while (true) {
      // Lietotāja ievade.
      Main.nodzestTerminali();
      AtrodiPari.atrodiPari.parbauditKarsuRezultatu();
      System.out.println("Jusu Tabula: ");
      AtrodiPari.atrodiPari.izvaditRezgi();
      AtrodiPari.atrodiPari.izvaditAtklatoRezgi();
      AtrodiPari.atrodiPari.izveletiesKarsuPozicijas(ievade);
      
      AtrodiPari.atrodiPari.salipinatKartisVienaBilde();

      System.out.print("\rJusu ievade: ");
      ievade = iLasitajs.nextLine();
      
    //   System.out.print("\033[F"); // Noliek mirgojošo kursoru vienu līniju uz augšu.

      // Thread.sleep(0);
    }
  }
}
