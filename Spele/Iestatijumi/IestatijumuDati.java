package Spele.Iestatijumi;

import Spele.K;
import Spele.FailuLietotaji.FailuRedigetajs;

public class IestatijumuDati {
  // * Šī klase nolasa visus datus no Iestatījumi.csv, un atgriež tos mainīgajiem,
  // * lai tos varētu izmantot spēlē.

  // ? Visi iestatījumi, kuri tiek lietoti spēlē:
  // Gaismas dati.
  public static boolean[] istabuGaismasIeslegtas = { // Indeksi: 0. Gulta, 1. Dīvāns, 2. Durvis, 3. Virtuve.
    FailuRedigetajs.booleanDatuAtgriezejs("gultasGaisma", K.IESTATIJUMU_FAILS), 
    FailuRedigetajs.booleanDatuAtgriezejs("divanaGaisma", K.IESTATIJUMU_FAILS), 
    FailuRedigetajs.booleanDatuAtgriezejs("durvjuGaisma", K.IESTATIJUMU_FAILS), 
    FailuRedigetajs.booleanDatuAtgriezejs("virtuvesGaisma", K.IESTATIJUMU_FAILS)
  };
  
  public static boolean spokiSledzAraGaismu = FailuRedigetajs.booleanDatuAtgriezejs("spokiSledzAraGaismu", K.IESTATIJUMU_FAILS);
  public static boolean ieslegtaSkana = FailuRedigetajs.booleanDatuAtgriezejs("ieslegtaSkana", K.IESTATIJUMU_FAILS);

  public static int spelesNakts = 6;

  public static boolean durvisSlegtas = FailuRedigetajs.booleanDatuAtgriezejs("durvisSlegtas", K.IESTATIJUMU_FAILS);
  public static boolean elektribaIeslegta = FailuRedigetajs.booleanDatuAtgriezejs("elektribaIeslegta", K.IESTATIJUMU_FAILS);
  public static boolean pagrabaGaisma = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaisma", K.IESTATIJUMU_FAILS);
  public static boolean spuldziteSaplesta = FailuRedigetajs.booleanDatuAtgriezejs("spuldziteSaplesta", K.IESTATIJUMU_FAILS);

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
