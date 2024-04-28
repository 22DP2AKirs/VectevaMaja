package Spele.SakumaDatuSagatavosana;

import java.util.ArrayList;

import Spele.K;
import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Iestatijumi.Iestatijumi;
import Spele.KontaKods.Konts;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.VirtuvesSpoks;
import Spele.Veikals.VeikalaKods;

public class SakumaDati {
  // ? Visi iestatījumi, kuri tiek lietoti spēlē:
  public static String[] kamera = new String[16];

  // Parastie dati:
  public static boolean[] istabuGaismasIeslegtas = new boolean[4]; // Indeksi: 0. Gulta, 1. Dīvāns, 2. Durvis, 3. Virtuve.
  public static ArrayList<String> naktsDati;

  public static boolean durvisSlegtas;
  public static boolean elektribaIeslegta;
  public static boolean pagrabaGaisma;
  public static boolean spuldziteSaplesta;
  public static boolean spokiSledzAraGaismu;

  // Spoku dati.
  public static int logaSpokaAtlautaAgresivitate;
  public static int durvjuSpokaAtlautaAgresivitate;
  public static int virtuvesSpokaAtlautaAgresivitate;

  public static int logaSpokaAtputasLaiks;
  public static int durvjuSpokaAtputasLaiks;
  public static int virtuvesSpokaAtputasLaiks;

  // Dati, kurus nolasa no lietotāja konta:
  public static boolean ieslegtaSkana;
  public static int nauda;
  public static int spelesNakts; // Saglabā spēles nakti.

  public static void sagatavotDatus() {
    // Nakts datiem ir jābūt pirmajiem, jo pārējie dati tiek ņemti no tā.
    SakumaDati.naktsDati = FailuRedigetajs.atgriestDaluNoFaila("#Nakts" + SakumaDati.spelesNakts, K.NAKTS_DATU_FAILS);

    ieslegtGaismas();
    sagatavotSpokus();
    citiSpelesDati();
  }

  public static void saglabatProgrammasDatusUzKontu() {
    // 1. Iegūst konta datus (lietotāj v., parole un drošības v.), lai tos nepazaudētu vai nesabojātu.
    String kontaDati = atgriestKontaDatus();
    // 2. Iegūst visus saglabājamos programmas datus.
    String programmasDati = atgriestSpelesDatus() + atgriestIestatijumuDatus() + atgriestVeikalaDatus();
    // 3. Pārraksta jeb saglabā datus kontā.
    FailuRedigetajs.failuParrakstitajs(kontaDati + programmasDati, Konts.lietotajaKontaCels);
  }

  public static void nodzestProgrammasDatus() {
    // 1. Iegūst konta datus (lietotāj v., parole un drošības v.), lai tos nepazaudētu vai nesabojātu.
    String kontaDati = atgriestKontaDatus();
    // 2. Iegūst datu sākumu vērtības.
    String programmasDati = FailuRedigetajs.failuParveidotajsParTekstu(K.PARAUGA_KONTS, 4);
    // 3. Pārraksta jeb nodzēš datus kontā.
    FailuRedigetajs.failuParrakstitajs(kontaDati + programmasDati, Konts.lietotajaKontaCels);
  }

  private static String atgriestKontaDatus() {
    // Sagatavo programmas datus kategorijai '#KontaDati'.
    String kontaDati = FailuRedigetajs.failuParveidotajsParTekstu(Konts.lietotajaKontaCels, 0);
    return kontaDati.substring(0, kontaDati.indexOf("#SpelesDati") - 1);
  }

  private static String atgriestSpelesDatus() {
    // Sagatavo programmas datus kategorijai '#SpelesDati'.
    return "#SpelesDati:\nspelesNakts=" + spelesNakts + "\nnauda=" + nauda;
  }

  private static String atgriestIestatijumuDatus() {
    // Sagatavo programmas datus kategorijai '#Iestatijumi'.
    return "\n\n#Iestatijumi:\nieslegtaSkana=" + PaligMetodes.booleanVertiba(ieslegtaSkana);
  }

  private static String atgriestVeikalaDatus() {
    // Sagatavo programmas datus kategorijai '#Veikals'.
    return "";
  }

  public static void nolasitDatusNoKonta() {
    // Nolasa un uzstāda visus datus no spēlētāja konta.
    Konts.lietotajaKontaCels = FailuRedigetajs.stringDatuAtgriezejs("lietotajaKontaCels", K.SAKUMA_DATU_MAPE);
    Konts.displejaLietotajvards = PaligMetodes.saliktAtstarpesSimboluVirkne(FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", Konts.lietotajaKontaCels), 1);
    Konts.lietotajsPiesledzies = true;
    
    // Veikala dati. 
    VeikalaKods.nolasitNoKontaVeikalaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Veikals", Konts.lietotajaKontaCels));
    
    // Iestatījumu dati.
    Iestatijumi.nolasitKontaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Iestatijumi", Konts.lietotajaKontaCels));

    // Spēles dati.
    ieslegtaSkana = FailuRedigetajs.booleanDatuAtgriezejs("ieslegtaSkana", Konts.lietotajaKontaCels);
    nauda = FailuRedigetajs.intDatuAtgriezejs("nauda", Konts.lietotajaKontaCels);
    spelesNakts = FailuRedigetajs.intDatuAtgriezejs("spelesNakts", Konts.lietotajaKontaCels);
  }

  private static void ieslegtGaismas() {
    istabuGaismasIeslegtas[0] = true;
    istabuGaismasIeslegtas[1] = true;
    istabuGaismasIeslegtas[2] = true;
    istabuGaismasIeslegtas[3] = true;
    pagrabaGaisma = false;
  }

  private static void sagatavotSpokus() {
    logaSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("logaSpokaAtlautaAgresivitate", naktsDati);
    durvjuSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("durvjuSpokaAtlautaAgresivitate", naktsDati);
    virtuvesSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("virtuvesSpokaAtlautaAgresivitate", naktsDati);

    logaSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("logaSpokaAtputasLaiks", naktsDati);
    durvjuSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("durvjuSpokaAtputasLaiks", naktsDati);
    virtuvesSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("virtuvesSpokaAtputasLaiks", naktsDati);

    spuldziteSaplesta = false;
    spokiSledzAraGaismu = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("spokiSledzAraGaismu", naktsDati);
  }

  private static void citiSpelesDati() {
    durvisSlegtas = (VeikalaKods.durvjuSledzis) ? true : false;
    MazoSpeluIzvelesKods.mdPapildusLaikaIespeja = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("mdPapildusLaikaIespeja",  naktsDati);
    elektribaIeslegta = true;
  }

  public static void uzstaditSpokusUzPusnaktsRezimu() {
    // Pārslēdz spoku datus uz pusnakts režīmu.
    // 1. Atjauno jau aktīvo un topošos spokus.
    LogaSpoks.logaSpoks.spokaAtlautaAgresivitate = logaSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsLogaSpokaAtlautaAgresivitate", naktsDati);
    DurvjuSpoks.durvjuSpoks.spokaAtlautaAgresivitate = durvjuSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsDurvjuSpokaAtlautaAgresivitate", naktsDati);
    VirtuvesSpoks.virtuvesSpoks.spokaAtlautaAgresivitate = virtuvesSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsVirtuvesSpokaAtlautaAgresivitate", naktsDati);

    LogaSpoks.logaSpoks.spokaAtputasLaiks = logaSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsLogaSpokaAtputasLaiks", naktsDati);
    DurvjuSpoks.durvjuSpoks.spokaAtputasLaiks = durvjuSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsDurvjuSpokaAtputasLaiks", naktsDati);
    VirtuvesSpoks.virtuvesSpoks.spokaAtputasLaiks = virtuvesSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsVirtuvesSpokaAtputasLaiks", naktsDati);
  }

  public static void parastieDati() {
    // ? Parauga kontā ir 'default' jeb noklusējuma dati.
    // Veikala dati. 
    VeikalaKods.nolasitNoKontaVeikalaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Veikals", K.PARAUGA_KONTS));
    // Iestatījumu dati.
    Iestatijumi.nolasitKontaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Iestatijumi", K.PARAUGA_KONTS));

    // Spēles dati.
    ieslegtaSkana = true;
    nauda = 0;
    spelesNakts = 1;
  }
}