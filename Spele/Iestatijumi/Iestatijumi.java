package Spele.Iestatijumi;

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
  public static String ietUzPrieksu, griestiesPaLabi, griestiesPaKreisi, 
  izmantotObj, aizdedzinatSerkocinu, izietNoMD , izmantotKameru,
  izmantotGaismu, parslegtRakstisanasRezimu, parslegtBurtuIzmeru;

  public static String[] kontrole = new String[10];

  public static void IestatijumuKods() {
    TastaturasKlausitajs.uzreizNodzestKomandu();
    TastaturasKlausitajs.ieslegtKomandasTekstaFunkciju();
    DarbibuIzpilde.izvelnesSkaitlis = 0;

    while (!TastaturasKlausitajs.komanda.equals("Q")) {
      TastaturasKlausitajs.komandasTekstaFunkcija();
      TastaturasKlausitajs.enterSledzis();
      DarbibuIzpilde.izvelnesKustiba(TastaturasKlausitajs.komanda, 10);
      Izvade.izvadesMasivs = EkranuParklajumi.parklatEkranu(EkranuVeidi.IESTATIJUMI);
      if (TastaturasKlausitajs.komandasTeksts.equals("SAVE") && TastaturasKlausitajs.pabeidzaRakstitKomandasTekstu) {
        kontaSaglabatIestatijumus();
      }
    }

    TastaturasKlausitajs.bijaEnter = false;
    DarbibuIzpilde.izvelnesSkaitlis = 0;
  }

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

    atjauninatKontrolesMasivu();
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
    System.out.println(ietUzPrieksu);
    System.out.println(griestiesPaLabi);
    System.out.println(griestiesPaKreisi);
    System.out.println(izmantotObj);
    System.out.println(aizdedzinatSerkocinu);
    System.out.println(izietNoMD);
    System.out.println(izmantotKameru);
    System.out.println(izmantotGaismu);
    System.out.println(parslegtRakstisanasRezimu);
    System.out.println(parslegtBurtuIzmeru);
  }

  public static void kontaSaglabatIestatijumus() {
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
  }
}
