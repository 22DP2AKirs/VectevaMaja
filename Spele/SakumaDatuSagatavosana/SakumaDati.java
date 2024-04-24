package Spele.SakumaDatuSagatavosana;

import java.util.ArrayList;

import Spele.K;
import Spele.PaligMetodes;
import Spele.VeikalaKods;
import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.Izskati.IstabuIzskati;
import Spele.KontaKods.Konts;
import Spele.MazasSpeles.MazoSpeluIzvelesKods;
import Spele.Spoki.DurvjuSpoks;
import Spele.Spoki.LogaSpoks;
import Spele.Spoki.VirtuvesSpoks;

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

  // Dati, kurus nolasa no lietotāja konta:
  public static boolean ieslegtaSkana;
  public static int nauda;
  public static int spelesNakts; // Saglabā spēles nakti.

  private static String booleanVertiba(boolean bools) {
    // Atgriež pirmo burtu no vērtības, lai to varētu saglabāt failos.
    if (bools) {
      return "T";
    }
    return "F";
  }

  public static void sagatavotDatus() {
    // Nakts datiem ir jābūt pirmajiem, jo pārējie dati tiek ņemti no tā.
    SakumaDati.naktsDati = FailuRedigetajs.atgriestDaluNoFaila("#Nakts" + SakumaDati.spelesNakts, K.NAKTS_DATU_FAILS);

    izveletiesKameru();
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
    return kontaDati.substring(0, kontaDati.indexOf("#SpelesDati"));
  }

  private static String atgriestSpelesDatus() {
    // Sagatavo programmas datus kategorijai '#SpelesDati'.
    return "#SpelesDati:\nspelesNakts=" + spelesNakts + "\nnauda=" + nauda;
  }

  private static String atgriestIestatijumuDatus() {
    // Sagatavo programmas datus kategorijai '#Iestatijumi'.
    return "\n\n#Iestatijumi:\nieslegtaSkana=" + booleanVertiba(ieslegtaSkana);
  }

  private static String atgriestVeikalaDatus() {
    // Sagatavo programmas datus kategorijai '#Veikals'.
    return "\n\n#Veikals:\nnopirktaFotokamera=" + booleanVertiba(VeikalaKods.nopirktaFotokamera) + "\nnopirktaVideokamera=" + booleanVertiba(VeikalaKods.nopirktaVideokamera) +
    "\nnopirktiSerkocini=" + booleanVertiba(VeikalaKods.nopirktiSerkocini) + "\n\nfotokamerasUzlabojumaCena=" + VeikalaKods.fotokamerasUzlabojumaCena + "\nvideokamerasUzlabojumaCena=" + 
    VeikalaKods.videokamerasUzlabojumaCena + "\nserkocinuUzlabojumaCena=" + VeikalaKods.serkocinuUzlabojumaCena + "\n\nfotokamerasLimenis=" + VeikalaKods.fotokamerasLimenis + "\nvideokamerasLimenis=" +
    VeikalaKods.videokamerasLimenis + "\nserkocinuLimenis=" + VeikalaKods.serkocinuLimenis + "\n\ndurvjuSledzis=" + booleanVertiba(VeikalaKods.durvjuSledzis) + "\n\nizveletaFotokamera=" +
    booleanVertiba(VeikalaKods.izveletaFotokamera) + "\nizveletaVideokamera=" + booleanVertiba(VeikalaKods.izveletaVideokamera);
  }

  public static void nolasitDatusNoKonta() {
    // Nolasa un uzstāda visus datus no spēlētāja koda.
    ArrayList<String> failaDala;

    Konts.lietotajaKontaCels = FailuRedigetajs.stringDatuAtgriezejs("lietotajaKontaCels", K.SAKUMA_DATU_MAPE);
    Konts.displejaLietotajvards = PaligMetodes.saliktAtstarpesSimboluVirkne(FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", Konts.lietotajaKontaCels), 1);
    Konts.lietotajsPiesledzies = true;
    
    // Veikala dati.
    failaDala = FailuRedigetajs.atgriestDaluNoFaila("#Veikals", Konts.lietotajaKontaCels);    
    VeikalaKods.fotokamerasLimenis = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("fotokamerasLimenis", failaDala);
    VeikalaKods.videokamerasLimenis = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("videokamerasLimenis", failaDala);
    VeikalaKods.serkocinuLimenis = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("serkocinuLimenis", failaDala);

    VeikalaKods.fotokamerasUzlabojumaCena = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("fotokamerasUzlabojumaCena", failaDala);
    VeikalaKods.videokamerasUzlabojumaCena = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("videokamerasUzlabojumaCena", failaDala);
    VeikalaKods.serkocinuUzlabojumaCena = FailuRedigetajs.stringDatuAtgriezejsNoSaraktsa("serkocinuUzlabojumaCena", failaDala);
  
    VeikalaKods.durvjuSledzis = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("durvjuSledzis", failaDala);
    VeikalaKods.nopirktaFotokamera = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("nopirktaFotokamera", failaDala);
    VeikalaKods.nopirktaVideokamera = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("nopirktaVideokamera", failaDala);
    VeikalaKods.nopirktiSerkocini = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("nopirktiSerkocini", failaDala);

    VeikalaKods.izveletaFotokamera = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("izveletaFotokamera", failaDala);;
    VeikalaKods.izveletaVideokamera = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("izveletaVideokamera", failaDala);
  
    // Iestatījumu dati.
    failaDala = FailuRedigetajs.atgriestDaluNoFaila("#Iestatijumi", Konts.lietotajaKontaCels);
    
    // Spēles dati.
    ieslegtaSkana = FailuRedigetajs.booleanDatuAtgriezejs("ieslegtaSkana", Konts.lietotajaKontaCels);
    nauda = FailuRedigetajs.intDatuAtgriezejs("nauda", Konts.lietotajaKontaCels);
    spelesNakts = FailuRedigetajs.intDatuAtgriezejs("spelesNakts", Konts.lietotajaKontaCels);
  }

  private static void izveletiesKameru() {
    if (VeikalaKods.izveletaFotokamera) {
      kamera = IstabuIzskati.fotokamera;
    }
    else if (VeikalaKods.izveletaVideokamera) {
      kamera = IstabuIzskati.videokamera;
    }
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

    spuldziteSaplesta = FailuRedigetajs.booleanDatuAtgriezejs("spuldziteSaplesta", K.IESTATIJUMU_FAILS);
    spokiSledzAraGaismu = FailuRedigetajs.booleanDatuAtgriezejsNoSaraktsa("spokiSledzAraGaismu", naktsDati);
  }

  private static void citiSpelesDati() {
    durvisSlegtas = FailuRedigetajs.booleanDatuAtgriezejs("durvisSlegtas", K.IESTATIJUMU_FAILS);
    MazoSpeluIzvelesKods.mdPapildusLaikaIespeja = FailuRedigetajs.intDatuAtgriezejsNoSaraktsa("mdPapildusLaikaIespeja",  naktsDati);
    elektribaIeslegta = FailuRedigetajs.booleanDatuAtgriezejs("elektribaIeslegta", K.IESTATIJUMU_FAILS);
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
}