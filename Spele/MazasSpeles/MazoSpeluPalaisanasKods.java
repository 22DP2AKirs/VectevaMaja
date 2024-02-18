package Spele.MazasSpeles;

import Spele.IzvadeUzTerminalu;
import Spele.PaligMetodes;
import Spele.Izskati.EkranuIzskati;
import Spele.Izskati.EkranuIzskati.EkranuVeidi;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;

public class MazoSpeluPalaisanasKods {
  // Karātavu kods savienots izmantojamā jeb spēlējamā stāvoklī:
  public static Karatavas karatavasObjekts; // 
  public static void karatavuKods() {
    if (Main.karatavas || Main.mazasSpelesRezultataParskats) { // Ja karātavas ir palaistas vai, ja varonis tiko uzvarēja karātavas.
      // Kamēr varonis nav uzvarējis karātavas, tikmēr viņš var ievadīt burtus.
      if (Main.karatavas) {
        // Izdara tā, lai nezināmo vārdu izvadītu uz ekrānu.
        Main.karatavasVards = karatavasObjekts.toString();
        karatavasObjekts.parbauditBurtu(Ievade.ievade, EkranuParklajumi.burti);
      }
      else {
        Main.karatavasVards = karatavasObjekts.nokrasotToString();
      }
      
      // Izvada masīvu vispirms pārklājot to.
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[3], EkranuVeidi.KARATAVU_EKRANS));
      
      // * Ļauj varonim redzēt pabeigto vārdu n sekundes. // Pēdējais izpildāmais kods.
      if (!Main.karatavas && Main.mazasSpelesRezultataParskats == true) {
        Main.izveletaMazaSpele = false;
        PaligMetodes.gulet(2);
        Main.mazasSpelesRezultataParskats = false;
        Main.varonisIrMazajaSpele = false;
      }
      // Ja karātavu vārds ir atminēts, tad karātavas padara false, un minigamePārskatu padara true.
      if (Karatavas.atminejaVardu && Main.karatavas == true) {
        Main.karatavas = false;
        Main.mazasSpelesRezultataParskats = true;
      }
    }
  }


  public static void izveidotJaunuKaratavasSpeli() {
    // * Šī metode izveido jaunu objektu, lai to varētu izmantot spēlē ar citām vērtībām.
    restartetKaratavas();
    karatavasObjekts = new Karatavas(Main.rand.nextInt(3), Main.rand.nextInt(3));
    EkranuParklajumi.saliktRandAtstarpesKaratavuGramata(); // Papild process.
  }

  public static void palaistKaratavas() {
    Main.varonisIrMazajaSpele = true;
    Main.karatavas = true;
    Ievade.ievade = "}";
  }

  public static void restartetKaratavas() {
    // Metode restartē visus karātavas datus, lai sākot jaunu spēli varētu spēlēt no jauna.
    Main.varonisIrMazajaSpele = false;
    Karatavas.karatavuKluduSkaits = 0;
    Karatavas.atminejaVardu = false;
    EkranuParklajumi.burti = "A B C D E F G H I J K L M N O P R S T U V Z".split(" ");
  }
}
