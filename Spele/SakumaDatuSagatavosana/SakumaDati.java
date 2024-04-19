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
  public static boolean spokiPusnaktsRezima = false;
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
  public static boolean ieslegtaSkana = FailuRedigetajs.booleanDatuAtgriezejs("ieslegtaSkana", K.IESTATIJUMU_FAILS);
  public static int nauda = 9000;
  public static int spelesNakts; // Saglabā spēles nakti.

  public static void sagatavotDatus() {
    izveletiesKameru();
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

  public static void sagatavotDatusNaktij() {

    // Cits:
    istabuGaismasIeslegtas[0] = FailuRedigetajs.booleanDatuAtgriezejs("gultasGaisma", K.IESTATIJUMU_FAILS);
    istabuGaismasIeslegtas[1] = FailuRedigetajs.booleanDatuAtgriezejs("divanaGaisma", K.IESTATIJUMU_FAILS);
    istabuGaismasIeslegtas[2] = FailuRedigetajs.booleanDatuAtgriezejs("durvjuGaisma", K.IESTATIJUMU_FAILS);
    istabuGaismasIeslegtas[3] = FailuRedigetajs.booleanDatuAtgriezejs("virtuvesGaisma", K.IESTATIJUMU_FAILS);

    durvisSlegtas = FailuRedigetajs.booleanDatuAtgriezejs("durvisSlegtas", K.IESTATIJUMU_FAILS);
    elektribaIeslegta = FailuRedigetajs.booleanDatuAtgriezejs("elektribaIeslegta", K.IESTATIJUMU_FAILS);
    pagrabaGaisma = FailuRedigetajs.booleanDatuAtgriezejs("pagrabaGaisma", K.IESTATIJUMU_FAILS);
    spuldziteSaplesta = FailuRedigetajs.booleanDatuAtgriezejs("spuldziteSaplesta", K.IESTATIJUMU_FAILS);

    // Nakts: 
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