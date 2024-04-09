package Spele.Iestatijumi;


import java.util.ArrayList;

import Spele.K;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.KontaKods.Konts;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.VirtuvesSpoks;

public class IestatijumuDati {
  // * Šī klase nolasa visus datus no Iestatījumi.csv, un atgriež tos mainīgajiem,
  // * lai tos varētu izmantot spēlē.

  public static boolean spokiPusnaktsRezima = false;
  public static int spelesNakts; // Saglabā spēles nakti.

  public static ArrayList<String> naktsDati; //  = FailuRedigetajs.atgriestDaluNoFaila("#Nakts" + FailuRedigetajs.intDatuAtgriezejs("spelesNakts", Konts.lietotajaKontaCels), K.NAKTS_DATU_FAILS)
  // ? Visi iestatījumi, kuri tiek lietoti spēlē:
  // Gaismas dati.
  public static boolean[] istabuGaismasIeslegtas = { // Indeksi: 0. Gulta, 1. Dīvāns, 2. Durvis, 3. Virtuve.
    FailuRedigetajs.booleanDatuAtgriezejs("gultasGaisma", K.IESTATIJUMU_FAILS), 
    FailuRedigetajs.booleanDatuAtgriezejs("divanaGaisma", K.IESTATIJUMU_FAILS), 
    FailuRedigetajs.booleanDatuAtgriezejs("durvjuGaisma", K.IESTATIJUMU_FAILS), 
    FailuRedigetajs.booleanDatuAtgriezejs("virtuvesGaisma", K.IESTATIJUMU_FAILS)
  };
  
  public static boolean ieslegtaSkana = FailuRedigetajs.booleanDatuAtgriezejs("ieslegtaSkana", K.IESTATIJUMU_FAILS);
  
  public static boolean durvisSlegtas = FailuRedigetajs.booleanDatuAtgriezejs("durvisSlegtas", K.IESTATIJUMU_FAILS);
  public static boolean elektribaIeslegta = FailuRedigetajs.booleanDatuAtgriezejs("elektribaIeslegta", K.IESTATIJUMU_FAILS);
  public static boolean pagrabaGaisma = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaisma", K.IESTATIJUMU_FAILS);
  public static boolean spuldziteSaplesta = FailuRedigetajs.booleanDatuAtgriezejs("spuldziteSaplesta", K.IESTATIJUMU_FAILS);

  public static boolean spokiSledzAraGaismu;

  // Sērkociņa dati.
  public static int atlikusoSerkocinuDaudzums;
  public static int maxSerkocinaDegsanasLaiks;

  // Spoku dati.
  public static int logaSpokaAtlautaAgresivitate;
  public static int durvjuSpokaAtlautaAgresivitate;
  public static int virtuvesSpokaAtlautaAgresivitate;

  public static int logaSpokaAtputasLaiks;
  public static int durvjuSpokaAtputasLaiks;
  public static int virtuvesSpokaAtputasLaiks;

  public static void sagatavotDatusNaktij() {
    if (Konts.lietotajsPiesledzies) {
      IestatijumuDati.spelesNakts = FailuRedigetajs.intDatuAtgriezejs("spelesNakts", Konts.lietotajaKontaCels);
    }

    MazoSpeluIzvelesKods.mdPapildusLaikaIespeja = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("mdPapildusLaikaIespeja",  naktsDati);

    spokiSledzAraGaismu = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("spokiSledzAraGaismu", naktsDati);

    atlikusoSerkocinuDaudzums = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("atlikusoSerkocinuDaudzums", naktsDati);
    maxSerkocinaDegsanasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("maxSerkocinaDegsanasLaiks", naktsDati);

    logaSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("logaSpokaAtlautaAgresivitate", naktsDati);
    durvjuSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("durvjuSpokaAtlautaAgresivitate", naktsDati);
    virtuvesSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("virtuvesSpokaAtlautaAgresivitate", naktsDati);

    logaSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("logaSpokaAtputasLaiks", naktsDati);
    durvjuSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("durvjuSpokaAtputasLaiks", naktsDati);
    virtuvesSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("virtuvesSpokaAtputasLaiks", naktsDati);
  }

  public static void uzstaditSpokusUzPusnaktsRezimu() {
    // Pārslēdz spoku datus uz pusnakts režīmu.
    if (!spokiPusnaktsRezima) {
      // Atjauno jau aktīvo un topošos spokus.
      LogaSpoks.logaSpoks.spokaAtlautaAgresivitate = logaSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsLogaSpokaAtlautaAgresivitate", naktsDati);
      DurvjuSpoks.durvjuSpoks.spokaAtlautaAgresivitate = durvjuSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsDurvjuSpokaAtlautaAgresivitate", naktsDati);
      VirtuvesSpoks.virtuvesSpoks.spokaAtlautaAgresivitate = virtuvesSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsVirtuvesSpokaAtlautaAgresivitate", naktsDati);

      LogaSpoks.logaSpoks.spokaAtputasLaiks = logaSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsLogaSpokaAtputasLaiks", naktsDati);
      DurvjuSpoks.durvjuSpoks.spokaAtputasLaiks = durvjuSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsDurvjuSpokaAtputasLaiks", naktsDati);
      VirtuvesSpoks.virtuvesSpoks.spokaAtputasLaiks = virtuvesSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsVirtuvesSpokaAtputasLaiks", naktsDati);

      spokiPusnaktsRezima = true;
    }
  }
}
