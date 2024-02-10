package Spele.Iestatijumi;

import Spele.FailuLietotaji.FailuRedigetajs;

public class IestatijumuDati {
  // * Šī klase nolasa visus datus no Iestatījumi.csv, un atgriež tos mainīgajiem,
  // * lai tos varētu izmantot spēlē.

  // ? Visi iestatījumi, kuri tiek lietoti spēlē:
  // Gaismas dati.
  public static boolean[] istabuGaismasIeslegtas = {FailuRedigetajs.booleanDatuAtgriezejs("gultasGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("divanaGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("durvjuGaisma"), FailuRedigetajs.booleanDatuAtgriezejs("virtuvesGaisma")}; // Indeksi: 0. Gulta, 1. Dīvāns, 2. Durvis, 3. Virtuve.
  public static boolean spokiSledzAraGaismu = FailuRedigetajs.booleanDatuAtgriezejs("spokiSledzAraGaismu");
  public static boolean ieslegtaSkana = FailuRedigetajs.booleanDatuAtgriezejs("ieslegtaSkana");

  int spelesNakts = 6;

  public static boolean elektribaIeslegta = FailuRedigetajs.booleanDatuAtgriezejs("elektribaIeslegta");
  public static boolean pagrabaGaisma = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaisma");
  public static boolean pagrabaGaismaStrada = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaismaStrada");

  // Sērkociņa dati.
  public static int atlikusoSerkocinuDaudzums = FailuRedigetajs.intDatuAtgriezejs("atlikusoSerkocinuDaudzums");
  public static int maxSerkocinaDegsanasLaiks = FailuRedigetajs.intDatuAtgriezejs("maxSerkocinaDegsanasLaiks");

  // Spoku dati.
  public static int logaSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("logaSpokaAgresivitatesLimits");
  public static int durvjuSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("durvjuSpokaAgresivitatesLimits");
  public static int virtuvesSpokaAgresivitatesLimits = FailuRedigetajs.intDatuAtgriezejs("virtuvesSpokaAgresivitatesLimits");

  int logaSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("logaSpokaDrosibasRobezas");
  int durvjuSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("durvjuSpokaDrosibasRobezas");
  int virtuvesSpokaDrosibasRobezas = FailuRedigetajs.intDatuAtgriezejs("virtuvesSpokaDrosibasRobezas");
}
