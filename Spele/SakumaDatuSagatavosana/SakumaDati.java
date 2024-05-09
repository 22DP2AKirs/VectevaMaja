package Spele.SakumaDatuSagatavosana;

import java.util.ArrayList;

import Spele.Iestatijumi;
import Spele.K;
import Spele.PaligMetodes;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.KontaKods.Konts;
import Spele.Majasdarbi.MajasdarbuIzvelesKods;
import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.PagrabaSpoks;
import Spele.Spoki.Spoks;
import Spele.Veikals.Fotokamera;
import Spele.Veikals.Piederumi;
import Spele.Veikals.Serkocini;
import Spele.Veikals.VeikalaKods;
import Spele.Veikals.Videokamera;

public class SakumaDati {
  // ? Visi iestatījumi, kuri tiek lietoti spēlē:
  public static String[] kamera = new String[16];

  // Parastie dati:
  public static boolean[] istabuGaismasIeslegtas = new boolean[4]; // Indeksi: 0. Gulta, 1. Dīvāns, 2. Durvis, 3. Virtuve.
  public static ArrayList<String> naktsDati;
  
  public static boolean durvisSlegtas, elektribaIeslegta, pagrabaGaisma, spuldziteSaplesta, spokiSledzAraGaismu;

  // Spoku dati.
  public static int 
  logaSpokaAtlautaAgresivitate, durvjuSpokaAtlautaAgresivitate, virtuvesSpokaAtlautaAgresivitate,
  logaSpokaAtputasLaiks, durvjuSpokaAtputasLaiks, virtuvesSpokaAtputasLaiks;

  // Dati, kurus nolasa no lietotāja konta:
  public static boolean ieslegtaSkana;
  public static int nauda, spelesNakts, naves;

  public static void sagatavotSpelesDatus() {
    // Nakts datiem ir jābūt pirmajiem, jo pārējie dati tiek ņemti no tā.
    SakumaDati.naktsDati = FailuRedigetajs.atgriestDaluNoFaila("#Nakts" + SakumaDati.spelesNakts, K.NAKTS_DATU_FAILS);

    ieslegtGaismas();
    citiSpelesDati();
    sagatavotSpokus();
    Spoks.izveidotSpokus();
    Piederumi.definetKameru();
  }

  public static void saglabatProgrammasDatusUzKontu() {
    // * Izmanto, lai saglabātu spēles datus lietotāja kontā.
    // 1. Iegūst konta datus (lietotāj v., parole un drošības v.), lai tos nepazaudētu vai nesabojātu.
    String kontaDati = savaktKontaDatus();
    // 2. Iegūst visus saglabājamos programmas datus.
    String programmasDati = atgriestSpelesDatus() + atgriestIestatijumuDatusNoSpeles() + atgriestVeikalaDatusNoSpeles();
    // 3. Pārraksta jeb saglabā datus kontā.
    FailuRedigetajs.failuParrakstitajs(kontaDati + programmasDati, Konts.lietotajaKontaCels);
  }

  public static void nodzestProgrammasDatus() {
    // * Šo izmanto, lai nodzēstu visus lietotāja konta datus.
    // 1. Iegūst konta datus (lietotāj v., parole un drošības v.), lai tos nepazaudētu vai nesabojātu.
    String kontaDati = savaktKontaDatus();
    // 2. Iegūst datu sākumu vērtības.
    String programmasDati = FailuRedigetajs.failuParveidotajsParTekstu(K.PARAUGA_KONTS, 4);
    // 3. Pārraksta jeb nodzēš datus kontā.
    FailuRedigetajs.failuParrakstitajs(kontaDati + programmasDati, Konts.lietotajaKontaCels);
  }


  public static void nolasitDatusNoKonta() {
    // Nolasa un uzstāda visus datus no spēlētāja konta.
    if (Konts.atceretiesMani) {
      Konts.lietotajaKontaCels = FailuRedigetajs.stringDatuAtgriezejs("lietotajaKontaCels", K.SAKUMA_DATU_MAPE);
    }

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
    naves = FailuRedigetajs.intDatuAtgriezejs("naves", Konts.lietotajaKontaCels);
  }

  private static void ieslegtGaismas() {
    // Ieslēdz visas spēles gaismas.
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
    MajasdarbuIzvelesKods.majasdarbuSkaits = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("majasdarbuSkaits",  naktsDati);
    durvisSlegtas = (VeikalaKods.durvjuSledzis) ? true : false; // Ternary Operator.
    elektribaIeslegta = true;
  }

  public static void uzstaditSpokusUzPusnaktsRezimu() {
    // Pārslēdz spoku datus uz pusnakts režīmu.
    // 1. Atjauno jau aktīvo un topošos spokus.
    LogaSpoks.logaSpoks.spokaAtlautaAgresivitate = logaSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsLogaSpokaAtlautaAgresivitate", naktsDati);
    DurvjuSpoks.durvjuSpoks.spokaAtlautaAgresivitate = durvjuSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsDurvjuSpokaAtlautaAgresivitate", naktsDati);
    PagrabaSpoks.pagrabaSpoks.spokaAtlautaAgresivitate = virtuvesSpokaAtlautaAgresivitate = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsVirtuvesSpokaAtlautaAgresivitate", naktsDati);

    LogaSpoks.logaSpoks.spokaAtputasLaiks = logaSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsLogaSpokaAtputasLaiks", naktsDati);
    DurvjuSpoks.durvjuSpoks.spokaAtputasLaiks = durvjuSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsDurvjuSpokaAtputasLaiks", naktsDati);
    PagrabaSpoks.pagrabaSpoks.spokaAtputasLaiks = virtuvesSpokaAtputasLaiks = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("pusnaktsVirtuvesSpokaAtputasLaiks", naktsDati);
  }

  public static void uzstaditSpeliUzNoklusejumaDatiem() {
    // ? Parauga kontā ir 'default' jeb noklusējuma dati.
    // Veikala dati. 
    VeikalaKods.nolasitNoKontaVeikalaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Veikals", K.PARAUGA_KONTS));
    // Iestatījumu dati.
    Iestatijumi.nolasitKontaDatus(FailuRedigetajs.atgriestDaluNoFaila("#Iestatijumi", K.PARAUGA_KONTS));

    // Spēles dati.
    ieslegtaSkana = true;
    nauda = 0;
    spelesNakts = 1;
    naves = 0;
  }

  //
  // Atgriež programmas datus kā tekstu.
  //

  private static String savaktKontaDatus() {
    // Atgriež kā faila saturu Konta lietotāja datus.
    String kontaDati = FailuRedigetajs.failuParveidotajsParTekstu(Konts.lietotajaKontaCels, 0);
    return kontaDati.substring(0, kontaDati.indexOf("#SpelesDati") - 1);
  }

  private static String atgriestSpelesDatus() {
    // Atgriež kā faila saturu Spēles datus.
    return 
    "\n#SpelesDati:\nspelesNakts=" + spelesNakts + 
    "\nnauda=" + nauda + 
    "\nnaves=" + naves;
  }

  private static String atgriestIestatijumuDatusNoSpeles() {
    // Atgriež kā faila saturu Iestatījumu datus.
    return 
    "\n\n#Iestatijumi:\nietUzPrieksu=" + Iestatijumi.ietUzPrieksu + 
    "\ngriestiesPaLabi=" + Iestatijumi.griestiesPaLabi + 
    "\ngriestiesPaKreisi=" + Iestatijumi.griestiesPaKreisi +
    "\nizmantotObj=" + Iestatijumi.izmantotObj + 
    "\nizmantotGaismu=" + Iestatijumi.izmantotGaismu + 
    "\nizmantotKameru=" + Iestatijumi.izmantotKameru + 
    "\nizietNoMD=" + Iestatijumi.izietNoMD +
    "\naizdedzinatSerkocinu=" + Iestatijumi.aizdedzinatSerkocinu + 
    "\nparslegtBurtuIzmeru=" + Iestatijumi.parslegtBurtuIzmeru + 
    "\nparslegtRakstisanasRezimu=" + Iestatijumi.parslegtRakstisanasRezimu +
    "\n\nkadriSekunde=" + Iestatijumi.kadriSekunde + 
    "\nieslegtaSkana=" + PaligMetodes.booleanVertiba(SakumaDati.ieslegtaSkana);
  }

  private static String atgriestVeikalaDatusNoSpeles() {
    // Atgriež kā faila saturu Veikala datus.
    return 
    "\n\n#Veikals:\nnopirktaFotokamera=" + PaligMetodes.booleanVertiba(Fotokamera.fotokamera.getNopirkaPiederumu()) + 
    "\nnopirktaVideokamera=" + PaligMetodes.booleanVertiba(Videokamera.videokamera.getNopirkaPiederumu()) + 
    "\nnopirktiSerkocini=" + PaligMetodes.booleanVertiba(Serkocini.serkocini.getNopirkaPiederumu()) + 
    "\n\nfotokamerasUzlabojumaCena=" + Fotokamera.fotokamera.getUzlabojumaCenu() + 
    "\nvideokamerasUzlabojumaCena=" + Videokamera.videokamera.getUzlabojumaCenu() + 
    "\nserkocinuUzlabojumaCena=" + Serkocini.serkocini.getUzlabojumaCenu() + 
    "\n\nfotokamerasLimenis=" + Fotokamera.fotokamera.getLimeni() + 
    "\nvideokamerasLimenis=" + Videokamera.videokamera.getLimeni() + 
    "\nserkocinuLimenis=" + Serkocini.serkocini.getLimeni() + 
    "\n\ndurvjuSledzis=" + PaligMetodes.booleanVertiba(VeikalaKods.durvjuSledzis) + 
    "\n\nizveletaFotokamera=" + PaligMetodes.booleanVertiba(VeikalaKods.izveletaFotokamera) + 
    "\nizveletaVideokamera=" + PaligMetodes.booleanVertiba(VeikalaKods.izveletaVideokamera);
  }
}