package Spele;

import java.util.ArrayList;

import Spele.Enums.EkranuVeidi;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.KontaKods.Konts;
import Spele.Parklajumi.EkranuParklajumi;
import Spele.SpelesProcesi.Izvade;
import Spele.SpelesProcesi.TastaturasKlausitajs;
import Spele.Varonis.DarbibuIzpilde;

public class Iestatijumi {
  // Kontrole.
  public static String // Mainīgie, kurus izmanto, lai pārbaudītu lietotāja ievadi. Var saukt par filtriem.
  ietUzPrieksu, griestiesPaLabi, griestiesPaKreisi, 
  izmantotObj, aizdedzinatSerkocinu, izietNoMD , izmantotKameru,
  izmantotGaismu, parslegtRakstisanasRezimu, parslegtBurtuIzmeru;

  public static int kadriSekunde = 30;

  public static String[] kontrole = new String[10]; // Šī masīva elementus izmanto, lai izvadītu (rādītu lietotājam) aktuālos iestatījumus.

  public static void IestatijumuKods() {
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.ieslegtKomandasTekstaFunkciju();
    DarbibuIzpilde.izvelnesSkaitlis = 0;

    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      // 1. Izvade uz termināli.
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.IESTATIJUMI);
      // 2. Ieslēdz komandas teksta rakstīšanu.
      TastaturasKlausitajs.komandasTekstaFunkcija();
      // 3. Ieslēdz 'toggle' pogu uz taustiņa 'ENTER'.
      TastaturasKlausitajs.enterSledzis();
      // 4. Pārvietošanās pār izvelnēm.
      DarbibuIzpilde.izvelnesKustiba(TastaturasKlausitajs.komanda, 10);
      // 5. Nomaina masīva elementu uz tiko ievadīto.
      if (TastaturasKlausitajs.bijaEnter && TastaturasKlausitajs.komandaNavTuksa()) {
        kontrole[DarbibuIzpilde.izvelnesSkaitlis] = TastaturasKlausitajs.komanda;
        TastaturasKlausitajs.bijaEnter = false;
        TastaturasKlausitajs.uzreizNodzestKomandu();
      }

      // 6. Darbību apstrāde.
      if (TastaturasKlausitajs.komandasTeksts.equals("SAVE") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        if (!PaligMetodes.masivaIrElementuDuplikati(kontrole)) {
          // Saglabā izmaiņas.
          atjauninatKontrolesMainigos();
          kontaSaglabatIestatijumus();
        }
        else {
          // Atjauno uz iepriekšējiem datiem.
          if (Konts.lietotajsPiesledzies) {
            nolasitKontaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Iestatijumi:", Konts.lietotajaKontaCels));
          }
          else {
            nolasitKontaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Iestatijumi:", K.PARAUGA_KONTS));
          }
        }
      }
      else if (TastaturasKlausitajs.komandasTeksts.equals("RESET") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Atjauno uz noklusējumu.
        nolasitKontaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Iestatijumi:", K.PARAUGA_KONTS));
        atjauninatKontrolesMasivu();
      }
      else if (TastaturasKlausitajs.komandasTeksts.equals("FPS") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        // Pārslēdz kadruSekundē vērtības.
        kadriSekunde = (kadriSekunde == 30) ? 60 : 30;
        // Atjauno spēles fps.
        Izvade.framesPerSecond = 1000 / kadriSekunde;
      }
    }

    TastaturasKlausitajs.bijaEnter = false;
    DarbibuIzpilde.izvelnesSkaitlis = 0;
  }
  
  public static void atjauninatKontrolesMainigos() {
    ietUzPrieksu = kontrole[0];
    griestiesPaLabi = kontrole[1];
    griestiesPaKreisi = kontrole[2];
    izmantotObj = kontrole[3];
    aizdedzinatSerkocinu = kontrole[4];
    izietNoMD = kontrole[5];
    izmantotKameru = kontrole[6];
    izmantotGaismu =kontrole[7];
    parslegtRakstisanasRezimu = kontrole[8];
    parslegtBurtuIzmeru = kontrole[9];
  }

  public static void atjauninatKontrolesMasivu() {
    String[] jaunaisMasivs = {
      ietUzPrieksu, griestiesPaLabi, griestiesPaKreisi, 
      izmantotObj, aizdedzinatSerkocinu, izietNoMD , izmantotKameru,
      izmantotGaismu, parslegtRakstisanasRezimu, parslegtBurtuIzmeru
    };
    kontrole = jaunaisMasivs;
  }

  public static void izvaditMainigos() {
    System.out.println("ietUzPrieksu : " + ietUzPrieksu + "\033[0K");
    System.out.println("griestiesPaLabi : " + griestiesPaLabi + "\033[0K");
    System.out.println("griestiesPaKreisi : " + griestiesPaKreisi + "\033[0K");
    System.out.println("izmantotObj : " + izmantotObj + "\033[0K");
    System.out.println("aizdedzinatSerkocinu : " + aizdedzinatSerkocinu + "\033[0K");
    System.out.println("izietNoMD : " + izietNoMD + "\033[0K");
    System.out.println("izmantotKameru : " + izmantotKameru + "\033[0K");
    System.out.println("izmantotGaismu : " + izmantotGaismu + "\033[0K");
    System.out.println("parslegtRakstisanasRezimu : " + parslegtRakstisanasRezimu + "\033[0K");
    System.out.println("parslegtBurtuIzmeru : " + parslegtBurtuIzmeru + "\033[0K");
  }

  //
  // ? Darbības ar kontu.
  //

  public static void nolasitKontaDatus(ArrayList<String> datuDala) {
    ietUzPrieksu = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("ietUzPrieksu", datuDala);
    griestiesPaLabi = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("griestiesPaLabi", datuDala);
    griestiesPaKreisi = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("griestiesPaKreisi", datuDala);
    izmantotObj = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("izmantotObj", datuDala);
    aizdedzinatSerkocinu = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("aizdedzinatSerkocinu", datuDala);
    izietNoMD = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("izietNoMD", datuDala);
    izmantotKameru = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("izmantotKameru", datuDala);
    izmantotGaismu = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("izmantotGaismu", datuDala);
    parslegtRakstisanasRezimu = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("parslegtRakstisanasRezimu", datuDala);
    parslegtBurtuIzmeru = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("parslegtBurtuIzmeru", datuDala);
    kadriSekunde = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("kadriSekunde", datuDala);
    Izvade.framesPerSecond = 1000 / kadriSekunde;

    atjauninatKontrolesMasivu();
  }

  public static void kontaSaglabatIestatijumus() {
    if (Konts.lietotajsPiesledzies) {
      FailuRedigetajs.mainitFailaMainigaVertibu("ietUzPrieksu", ietUzPrieksu, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("griestiesPaLabi", griestiesPaLabi, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("griestiesPaKreisi", griestiesPaKreisi, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("izmantotObj", izmantotObj, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("izmantotGaismu", izmantotGaismu, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("izmantotKameru", izmantotKameru, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("izietNoMD", izietNoMD, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("aizdedzinatSerkocinu", aizdedzinatSerkocinu, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("parslegtBurtuIzmeru", parslegtBurtuIzmeru, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("parslegtRakstisanasRezimu", parslegtRakstisanasRezimu, Konts.lietotajaKontaCels);
      FailuRedigetajs.mainitFailaMainigaVertibu("kadriSekunde", kadriSekunde+"", Konts.lietotajaKontaCels);
    }
  }
}
