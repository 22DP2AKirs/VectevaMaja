package Spele.MazasSpeles.Karatavas;

import Spele.IzvadeUzTerminalu;
import Spele.PaligMetodes;
import Spele.Enums.EkranuVeidi;
import Spele.Izskati.EkranuIzskati;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;

// Karātavu kods savienots izmantojamā jeb spēlējamā stāvoklī:
public class KaratavasSavienojums {
  public static boolean mSpeleKaratavas = false;

  // Metode caur kuru spēlē strādā karātavu kods.
  public static void karatavuKods() {
    // Ja karātavas ir palaistas vai, ja varonis tiko uzvarēja karātavas.
    if (KaratavasSavienojums.mSpeleKaratavas || Main.mazasSpelesRezultataParskats) {

      // Kamēr varonis nav uzvarējis karātavas, tikmēr viņš var ievadīt burtus.
      if (KaratavasSavienojums.mSpeleKaratavas) {
        // Karātavas vārds tiek atjaunots, kad lietotājs ievada iespējamo vārda burtu.
        Main.karatavasVards = Karatavas.karatavasObjekts.toString();
        Karatavas.karatavasObjekts.parbauditBurtu(Ievade.lietotajaIevade, EkranuParklajumi.burti);
      }
      else {
        // Ja vārds ir atminēts, tad to nokrāso zaļā krāsā.
        Main.karatavasVards = Karatavas.karatavasObjekts.nokrasotToString();
      }
      
      // Pārklāj un izvada masīvu jeb grāmatu.
      IzvadeUzTerminalu.masivuIzvade(EkranuParklajumi.parklatEkranu(EkranuIzskati.visiEkrani[3], EkranuVeidi.KARATAVU_EKRANS));
      
      // * Ļauj varonim redzēt pabeigto vārdu n sekundes. // Pēdējais izpildāmais kods.
      if (!KaratavasSavienojums.mSpeleKaratavas && Main.mazasSpelesRezultataParskats == true) {
        MazoSpeluIzvelesKods.izveletaMazaSpele = false; // Atjauno m-spēles izvēli uz "neizvēlēta m-spēle".

        // Liek laika thredam gulēt vienlaicīgi ar main thredu.
        Main.thrediGul = true;
        PaligMetodes.gulet(3);

        // Izmet varoni no mazās spēles skata atpakaļ uz māju.
        Main.mazasSpelesRezultataParskats = false;
        MazoSpeluIzvelesKods.varonisIrMazajaSpele = false;
      }

      // Ļauj karātavu ekrānam atjaunoties vēl vienu reizi, lai lietotājs redzētu atminēto vārdu.
      if (Karatavas.atminejaVardu && KaratavasSavienojums.mSpeleKaratavas == true) {
        KaratavasSavienojums.mSpeleKaratavas = false;
        Main.mazasSpelesRezultataParskats = true;
      }
    }
  }

  public static void izveidotJaunuKaratavasSpeli() {
    // * Šī metode izveido jaunu karātavas objektu, lai to varētu izmantot spēlē ar citām vērtībām.
    restartetKaratavas();
    Karatavas.karatavasObjekts = new Karatavas(Main.rand.nextInt(4), Main.rand.nextInt(7));
    EkranuParklajumi.saliktRandAtstarpesKaratavuGramata(); // Papild process.
  }

  public static void palaistKaratavas() {
    MazoSpeluIzvelesKods.varonisIrMazajaSpele = true;
    Ievade.lietotajaIevade = "}";
  }

  public static void restartetKaratavas() {
    // * Metode restartē visus karātavas datus, lai sākot jaunu spēli varētu spēlēt no jauna.
    Karatavas.karatavuKluduSkaits = 0;
    Karatavas.atminejaVardu = false;
    EkranuParklajumi.burti = "A B C D E F G H I J K L M N O P R S T U V Z".split(" ");
  }
}
