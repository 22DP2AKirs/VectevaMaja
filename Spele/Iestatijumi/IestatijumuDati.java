package Spele.Iestatijumi;

import Spele.FailuLietotaji.FailuRedigetajs;

public class IestatijumuDati {
  // * Šī klase nolasa visus datus no Iestatījumi.csv, un atgriež tos mainīgajiem,
  // * lai tos varētu izmantot spēlē.

  // ? Visi iestatījumi, kuri tiek lietoti spēlē:
  // Gaismas dati.
  public static boolean[] istabuGaismasIeslegtas = { // Indeksi: 0. Gulta, 1. Dīvāns, 2. Durvis, 3. Virtuve.
    FailuRedigetajs.booleanDatuAtgriezejs("gultasGaisma"), 
    FailuRedigetajs.booleanDatuAtgriezejs("divanaGaisma"), 
    FailuRedigetajs.booleanDatuAtgriezejs("durvjuGaisma"), 
    FailuRedigetajs.booleanDatuAtgriezejs("virtuvesGaisma")
  }; 
  
  public static boolean spokiSledzAraGaismu = FailuRedigetajs.booleanDatuAtgriezejs("spokiSledzAraGaismu");
  public static boolean ieslegtaSkana = FailuRedigetajs.booleanDatuAtgriezejs("ieslegtaSkana");

  public static int spelesNakts = 6;

  public static boolean elektribaIeslegta = FailuRedigetajs.booleanDatuAtgriezejs("elektribaIeslegta");
  public static boolean pagrabaGaisma = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaisma");
  public static boolean stradaPagrabaGaisma = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaismaStrada");

  // Sērkociņa dati.
  public static int atlikusoSerkocinuDaudzums = FailuRedigetajs.intDatuAtgriezejs("atlikusoSerkocinuDaudzums");
  public static int maxSerkocinaDegsanasLaiks = FailuRedigetajs.intDatuAtgriezejs("maxSerkocinaDegsanasLaiks");

  // Spoku dati.
  public static int logaSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejs("logaSpokaAtlautaAgresivitate");
  public static int durvjuSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejs("durvjuSpokaAtlautaAgresivitate");
  public static int virtuvesSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejs("virtuvesSpokaAtlautaAgresivitate");

  public static int logaSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejs("logaSpokaAtputasLaiks");
  public static int durvjuSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejs("durvjuSpokaAtputasLaiks");
  public static int virtuvesSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejs("virtuvesSpokaAtputasLaiks");
}
