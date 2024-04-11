package Spele.Parklajumi;

import java.util.Arrays;

import Spele.FailuLietotaji.FailuRedigetajs;
import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.EkranuIzskati;
import Spele.KontaKods.Konts;
import Spele.K;
import Spele.Enums.EkranuVeidi;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.KaratavuIzskati;
import Spele.SpelesProcesi.Laiks;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.DarbibuIzpilde;
import Spele.Varonis.VaronaStatusaEfekti;

// * Pārklāj Ekrānu.
public class EkranuParklajumi {
  
  public static String[] parklatEkranu(EkranuVeidi EKRANA_TIPS) {
    String[] ekranaKopija = null;

    // Caur iesniegto enum "EKRANA_TIPS", šī metode var viegli noteikt, kurus ekrānus un to pārklājumus izmantot.
    if (EKRANA_TIPS.equals(EkranuVeidi.GALVENAIS_EKRANS)) {
      galvenaEkranaParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[0], EkranuIzskati.visiEkrani[0].length));
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.UZVARAS_EKRANS)) {
      uzvarasEkranaParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[1], EkranuIzskati.visiEkrani[1].length));
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.KARATAVU_EKRANS)) {
      gramatasParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[3], EkranuIzskati.visiEkrani[3].length));
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.KONTA_IZVELES_EKRANS)) {
      kontaIzvelesParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[4], EkranuIzskati.visiEkrani[4].length));
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.KONTA_APSKATES_EKRANS)) {
      kontaApskatesParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[5], EkranuIzskati.visiEkrani[5].length));
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.REGISTRACIJAS_EKRANS)) {
      registracijasParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[6], EkranuIzskati.visiEkrani[6].length));
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.PIESLEGSANAS_EKRANS)) {
      pieslegsanasParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[7], EkranuIzskati.visiEkrani[7].length));
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.DROSIBAS_VARDA_EKRANS)) {
      drosibasVardaParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[8], EkranuIzskati.visiEkrani[8].length));
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.REDIGESANAS_EKRANS)) {
      redigesanasParklasana(ekranaKopija = Arrays.copyOf(EkranuIzskati.visiEkrani[9], EkranuIzskati.visiEkrani[9].length));
    }

    return ekranaKopija;
  }

  private static void redigesanasParklasana(String[] mainamaisMasivs) {
    if (DarbibuIzpilde.izvelnesSkaitlis == 0) {
      mainamaisMasivs[4] += K.DEBESU_ZILS + "\033[68G.:" + K.RESET + "\033[106G";
      mainamaisMasivs[5] += K.DEBESU_ZILS + "\033[64G. '  :" + K.RESET + "\033[106G";
      mainamaisMasivs[6] += K.DEBESU_ZILS + "\033[64G' .  :" + K.RESET + "\033[106G";
      mainamaisMasivs[7] += K.DEBESU_ZILS + "\033[68G':" + K.RESET + "\033[106G";
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 1) {
      mainamaisMasivs[12] += K.DEBESU_ZILS + "\033[68G.:" + K.RESET + "\033[106G";
      mainamaisMasivs[13] += K.DEBESU_ZILS + "\033[64G. '  :" + K.RESET + "\033[106G";
      mainamaisMasivs[14] += K.DEBESU_ZILS + "\033[64G' .  :" + K.RESET + "\033[106G";
      mainamaisMasivs[15] += K.DEBESU_ZILS + "\033[68G':" + K.RESET + "\033[106G";
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 2) {
      mainamaisMasivs[20] += K.DEBESU_ZILS + "\033[68G.:" + K.RESET + "\033[106G";
      mainamaisMasivs[21] += K.DEBESU_ZILS + "\033[64G. '  :" + K.RESET + "\033[106G";
      mainamaisMasivs[22] += K.DEBESU_ZILS + "\033[64G' .  :" + K.RESET + "\033[106G";
      mainamaisMasivs[23] += K.DEBESU_ZILS + "\033[68G':" + K.RESET + "\033[106G";
    }

    mainamaisMasivs[7] += "\033[20G" + Konts.lietotajvards + "\033[82G" + FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", Konts.lietotajaKontaCels) + "\033[106G";
    mainamaisMasivs[15] += "\033[20G" + Konts.parole + "\033[82G" + FailuRedigetajs.stringDatuAtgriezejs("Parole", Konts.lietotajaKontaCels) + "\033[106G";
    mainamaisMasivs[23] += "\033[20G" + Konts.drosibasVards + "\033[82G" + FailuRedigetajs.stringDatuAtgriezejs("DrosibasVards", Konts.lietotajaKontaCels) + "\033[106G";
  }

  private static void drosibasVardaParklasana(String[] mainamaisMasivs) {
    mainamaisMasivs[17] += "\033[37G" + Konts.drosibasVards + "\033[106G";
  }

  private static void kontaApskatesParklasana(String[] mainamaisMasivs) {
    mainamaisMasivs[6] += "\033[47G" + FailuRedigetajs.stringDatuAtgriezejs("Lietotajvards", Konts.lietotajaKontaCels) + "\033[106G";
    mainamaisMasivs[14] += "\033[47G" + FailuRedigetajs.stringDatuAtgriezejs("Parole", Konts.lietotajaKontaCels) + "\033[106G";
    mainamaisMasivs[22] += "\033[47G" + FailuRedigetajs.stringDatuAtgriezejs("DrosibasVards", Konts.lietotajaKontaCels) + "\033[106G";

    if (Konts.atceretiesMani) {
      mainamaisMasivs[24] += K.ZALS + "\033[32G_" + K.RESET + "\033[106G"; 
      mainamaisMasivs[25] += K.ZALS + "\033[12G[ ATC ] - A T C E R E T I E S   M A N I" + K.RESET + "\033[106G"; 
    }
  }

private static void pieslegsanasParklasana(String[] mainamaisMasivs) {
    if (!Konts.ievaditsLietotajvards) {
      mainamaisMasivs[18] += "\033[27G" + K.TPELEKS + "|''''''''''''''''''''''''''''''''''''''''''''''''''|" + K.RESET + "\033[106G";
      mainamaisMasivs[19] += "\033[27G" + K.TPELEKS + "|                                                  |" + K.RESET + "\033[106G"; 
      mainamaisMasivs[20] += "\033[27G" + K.TPELEKS + "|        I E V A D I E T   P A R O L I :           |" + K.RESET + "\033[106G"; 
      mainamaisMasivs[21] += "\033[27G" + K.TPELEKS + "|                                                  |" + K.RESET + "\033[106G"; 
      mainamaisMasivs[22] += "\033[27G" + K.TPELEKS + "|     >>>                  | M A X   15   S I M B. |" + K.RESET + "\033[106G"; 
      mainamaisMasivs[23] += "\033[27G" + K.TPELEKS + "|__________________________________________________|" + K.RESET + "\033[106G";

      mainamaisMasivs[26] += K.TPELEKS + "\033[78G_" + K.RESET + "\033[106G";
      mainamaisMasivs[27] += "\033[49G" + K.TPELEKS + "[ AIZMIRSU ] - A I Z M I R S A T   P A R O L I ?" + K.RESET + "\033[106G";
    }
    

    // Pārvieto bultiņu.
    if (DarbibuIzpilde.izvelnesSkaitlis == 0) {
      mainamaisMasivs[11] += K.DEBESU_ZILS + "\033[23G\\" + "\033[82G/" + K.RESET + "\033[106G";
      mainamaisMasivs[12] += K.DEBESU_ZILS + "\033[24G\\" + "\033[81G/" + K.RESET + "\033[106G";
      mainamaisMasivs[13] += K.DEBESU_ZILS + "\033[24G/" + "\033[81G\\" + K.RESET + "\033[106G";
      mainamaisMasivs[14] += K.DEBESU_ZILS + "\033[23G/" + "\033[82G\\" + K.RESET + "\033[106G";
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 1) {
      mainamaisMasivs[19] += K.DEBESU_ZILS + "\033[23G\\" + "\033[82G/" + K.RESET + "\033[106G";
      mainamaisMasivs[20] += K.DEBESU_ZILS + "\033[24G\\" + "\033[81G/" + K.RESET + "\033[106G";
      mainamaisMasivs[21] += K.DEBESU_ZILS + "\033[24G/" + "\033[81G\\" + K.RESET + "\033[106G";
      mainamaisMasivs[22] += K.DEBESU_ZILS + "\033[23G/" + "\033[82G\\" + K.RESET + "\033[106G";
    }

    // Ievieto vārdus to pozīcijās.
    mainamaisMasivs[14] += "\033[37G" + Konts.lietotajvards + "\033[106G";
    mainamaisMasivs[22] += "\033[37G" + Konts.parole + "\033[106G";

    mainamaisMasivs[24] += Konts.lietotajaKontaCels; // TODO jānoņem.
  }

  private static void registracijasParklasana(String[] mainamaisMasivs) {
    // Pārvieto bultiņu.
    if (DarbibuIzpilde.izvelnesSkaitlis == 0) {
      mainamaisMasivs[4] += K.DEBESU_ZILS + "\033[72G.:" + K.RESET + "\033[106G";
      mainamaisMasivs[5] += K.DEBESU_ZILS + "\033[68G. '  :.............." + K.RESET + "\033[106G";
      mainamaisMasivs[6] += K.DEBESU_ZILS + "\033[68G' .  :''''''''''''''" + K.RESET + "\033[106G";
      mainamaisMasivs[7] += K.DEBESU_ZILS + "\033[72G':" + K.RESET + "\033[106G";
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 1) {
      mainamaisMasivs[12] += K.DEBESU_ZILS + "\033[72G.:" + K.RESET + "\033[106G";
      mainamaisMasivs[13] += K.DEBESU_ZILS + "\033[68G. '  :.............." + K.RESET + "\033[106G";
      mainamaisMasivs[14] += K.DEBESU_ZILS + "\033[68G' .  :''''''''''''''" + K.RESET + "\033[106G";
      mainamaisMasivs[15] += K.DEBESU_ZILS + "\033[72G':" + K.RESET + "\033[106G";
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 2) {
      mainamaisMasivs[20] += K.DEBESU_ZILS + "\033[72G.:" + K.RESET + "\033[106G";
      mainamaisMasivs[21] += K.DEBESU_ZILS + "\033[68G. '  :.............." + K.RESET + "\033[106G";
      mainamaisMasivs[22] += K.DEBESU_ZILS + "\033[68G' .  :''''''''''''''" + K.RESET + "\033[106G";
      mainamaisMasivs[23] += K.DEBESU_ZILS + "\033[72G':" + K.RESET + "\033[106G";
    }

    mainamaisMasivs[7] += "\033[20G" + Konts.lietotajvards + "\033[106G";
    mainamaisMasivs[15] += "\033[20G" + Konts.parole + "\033[106G";
    mainamaisMasivs[23] += "\033[20G" + Konts.drosibasVards + "\033[106G";
  }


  private static void kontaIzvelesParklasana(String[] mainamaisMasivs) {
    // Pārvieto bultiņu.
    if (DarbibuIzpilde.izvelnesSkaitlis == 0) {
      mainamaisMasivs[13] += K.DEBESU_ZILS + "\033[30G\\" + "\033[74G/" + K.RESET + "\033[106G";
      mainamaisMasivs[14] += K.DEBESU_ZILS + "\033[31G\\" + "\033[73G/" + K.RESET + "\033[106G";
      mainamaisMasivs[15] += K.DEBESU_ZILS + "\033[31G/" + "\033[73G\\" + K.RESET + "\033[106G";
      mainamaisMasivs[16] += K.DEBESU_ZILS + "\033[30G/" + "\033[74G\\" + K.RESET + "\033[106G";
    }
    else if (DarbibuIzpilde.izvelnesSkaitlis == 1) {
      mainamaisMasivs[19] += K.DEBESU_ZILS + "\033[30G\\" + "\033[74G/" + K.RESET + "\033[106G";
      mainamaisMasivs[20] += K.DEBESU_ZILS + "\033[31G\\" + "\033[73G/" + K.RESET + "\033[106G";
      mainamaisMasivs[21] += K.DEBESU_ZILS + "\033[31G/" + "\033[73G\\" + K.RESET + "\033[106G";
      mainamaisMasivs[22] += K.DEBESU_ZILS + "\033[30G/" + "\033[74G\\" + K.RESET + "\033[106G";
    }
  }


  public static String[] parklatZaudesanasEkranu(String[] originalaisEkrans, String iemesls) {
    String[] ekranaKopija = Arrays.copyOf(originalaisEkrans, originalaisEkrans.length);

    zaudesanasEkranaParklasana(ekranaKopija, zaudesanasInformacijasNoteiksana(iemesls));

    return ekranaKopija;
  }

  private static void uzvarasEkranaParklasana(String[] mainamaisMasivs) {
    mainamaisMasivs[15] += "\033[37G" + VaronaStatusaEfekti.varonaStresaLimenis + "\033[106G";
    mainamaisMasivs[17] += "\033[59G" + IestatijumuDati.atlikusoSerkocinuDaudzums + "\033[106G";
  }

  private static String[] zaudesanasInformacijasNoteiksana(String iemesls) {
    // * Metode sagatavo visu informāciju, par nāves iemeslu.

    // Informācijas elementu saturs.
    // 0 - Nāves iemesls;
    // 1 - Laiks līdz 6 AM;
    // 2 - Ieteikums.
    // 3 - Ieteikums.
    // 4 - Ieteikums.
    // 5 - Ieteikums.
    // 6 - Ieteikums.
    // 7 - Ieteikums.

    String[] informacija = new String[8];

    informacija[0] = iemesls;
    informacija[1] = "" + (Main.spelesIlgums - Laiks.spelesLaiks); // Pārveido int uz String.
    if (iemesls.equals("KARATAVAS")) {
      informacija[2] = "G E T   G U D.";
      informacija[3] = "";
      informacija[4] = "";
      informacija[5] = "";
      informacija[6] = "";
      informacija[7] = "";
      // Papildus darbības:
      SkanasSpeletajs.SpeletSkanu("Spele\\SkanasFaili\\karatavas_pakarts.wav", 6);
    } 
    else if (iemesls.equals("L O G A   S P O K S")) {
      informacija[2] = "                                    _   _                   _               _";
      informacija[3] = "L O G A   S P O K S   V A R   P A R A D I T I E S   V I E N A   N O   4   M A J A S   L O G I E M .";
      informacija[4] = "        _                                 _";
      informacija[5] = "P I E V E R S I E T   T I E M   U Z M A N I B U !";
      informacija[6] = "";
      informacija[7] = "";
    }
    else if (iemesls.equals("D U R V J U   S P O K S")) {
      informacija[2] = "                                      _   _               _             _       _             _";
      informacija[3] = "D U R V J U   S P O K S   L I E N   M A J A   C A U R   T A S   V I E N I G A J A M   D U R V I M .";
      informacija[4] = "  _       _       V _       _";
      informacija[5] = "T A S   M E D Z   C I K S T E T .";
      informacija[6] = "                                _                               _           _   _       _                 _";
      informacija[7] = "D U R V I S   V A R   A I Z S L E G T,  L A I   S P O K A M   B U T U   G R U T A K   T A S   A T T A I S I T .";
    }
    else if (iemesls.equals("V I R T U V E S   S P O K S")) {
      informacija[2] = "                                                      _";
      informacija[3] = "V I R T U V E S   S P O K S   P A L I E K   A G R E S I V S,";
      informacija[4] = "                    _                 _";
      informacija[5] = "K A D   P A G R A B A   I R   I E S L E G T A   G A I S M A .";
      informacija[6] = "        _               _                     _                                   _";
      informacija[7] = "I Z S L E D Z I E T   M A J A S   E L E K T R I B U,  L A I   T O   A I Z B I E D E T U !";
    }
    else if (iemesls.equals("STRESS")) {
      informacija[2] = "                                    _                                     v _             _";
      informacija[3] = "J U M S   N A V   B A I G I   P A T I K A M I   A T R A S T I E S   T U M S A   I S T A B A . . .";
      informacija[4] = "        _             _                   _";
      informacija[5] = "V A R B U T   I E S L E D Z I E T   T A J A   G A I S M U ?";
      informacija[6] = "";
      informacija[7] = "";
    }
    else if (iemesls.equals("MAJASDARBA_LAIKS")) {
      informacija[2] = "                      _                                       _                           _";
      informacija[3] = "I Z P I L D I E T   M A J A S D A R B U S   N O T E I K T A J A   L A I K A   P E R I O D A !";
      informacija[4] = "";
      informacija[5] = "";
      informacija[6] = "";
      informacija[7] = "";
    }

    return informacija;
  }

  private static void zaudesanasEkranaParklasana(String[] mainamaisMasivs, String[] informacija) {
    // * Metode saliek visu sagatavoto informāciju nāves jeb Zaudesanas ekrānā.
    mainamaisMasivs[15] += "\033[41G" + informacija[0] + "\033[106G";
    mainamaisMasivs[17] += "\033[43G" + informacija[1] + "\033[106G";
    mainamaisMasivs[20] += "\033[7G" + informacija[2] + "\033[106G";
    mainamaisMasivs[21] += "\033[7G" + informacija[3] + "\033[106G";
    mainamaisMasivs[22] += "\033[7G" + informacija[4] + "\033[106G";
    mainamaisMasivs[23] += "\033[7G" + informacija[5] + "\033[106G";
    mainamaisMasivs[24] += "\033[7G" + informacija[6] + "\033[106G";
    mainamaisMasivs[25] += "\033[7G" + informacija[7] + "\033[106G";
  }

  private static void galvenaEkranaParklasana(String[] mainamaisMasivs) {
    // * Metode pārklās galveno ekrānu.

    // Pie teksta pieliek bultiņas.
    ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[DarbibuIzpilde.izvelnesSkaitlis] = 
    ParklajumuIzskati.izvelnesBultinas[0] + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[DarbibuIzpilde.izvelnesSkaitlis]
    .substring(1) + ParklajumuIzskati.izvelnesBultinas[1];

    // Uzklāj tekstus.
    mainamaisMasivs[11] += "\033[13G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[0] + "   " + IestatijumuDati.spelesNakts + ".  N A K T I " + "\033[106G";
    mainamaisMasivs[13] += "\033[10G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[1] + "\033[106G";
    mainamaisMasivs[15] += "\033[10G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[2] + "\033[106G";
    mainamaisMasivs[17] += "\033[13G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[3] + "\033[106G";
    mainamaisMasivs[19] += "\033[16G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[4] + "\033[106G";
    mainamaisMasivs[21] += "\033[16G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[5] + "\033[106G";

    mainamaisMasivs[27] += "\033[26G" + Konts.displejaLietotajvards + "\033[106G";

    // No teksta noņem pieliktās bultiņas.
    ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[DarbibuIzpilde.izvelnesSkaitlis] = 
    " " + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[DarbibuIzpilde.izvelnesSkaitlis]
    .substring(12, ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[DarbibuIzpilde.izvelnesSkaitlis].length() - 5);
  }

  private static void gramatasParklasana(String[] mainamaisMasivs) {
    // * Metode pārklās grāmatu ar burtiem un zīmējumu.

    // Uz grāmatas saliek burtus.
    mainamaisMasivs[9] += "\033[13G" + Karatavas.burti[0] + Karatavas.rAtstarpes[0] + Karatavas.burti[1] + Karatavas.rAtstarpes[1] + Karatavas.burti[2] + Karatavas.rAtstarpes[2] + Karatavas.burti[3] + Karatavas.rAtstarpes[3] + Karatavas.burti[4] + "\033[106G";
    mainamaisMasivs[11] += "\033[8G" + Karatavas.burti[5] + Karatavas.rAtstarpes[4] + Karatavas.burti[6] + Karatavas.rAtstarpes[5] + Karatavas.burti[7] + Karatavas.rAtstarpes[6] + Karatavas.burti[8] + Karatavas.rAtstarpes[7] + Karatavas.burti[9] + "\033[106G";
    mainamaisMasivs[13] += "\033[11G" + Karatavas.burti[10] + Karatavas.rAtstarpes[8] + Karatavas.burti[11] + Karatavas.rAtstarpes[9] + Karatavas.burti[12] + Karatavas.rAtstarpes[10] + Karatavas.burti[13] + "\033[106G";
    mainamaisMasivs[15] += "\033[9G" + Karatavas.burti[14] + Karatavas.rAtstarpes[11] + Karatavas.burti[15] + Karatavas.rAtstarpes[12] + Karatavas.burti[16] + Karatavas.rAtstarpes[13] + Karatavas.burti[17] + Karatavas.rAtstarpes[14] + Karatavas.burti[18] + "\033[106G";
    mainamaisMasivs[17] += "\033[18G" + Karatavas.burti[19] + Karatavas.rAtstarpes[15] + Karatavas.burti[20] + Karatavas.rAtstarpes[16] + Karatavas.burti[21] + "\033[106G";

    // Grāmatā ievieto izvēlēto vārdu.
    mainamaisMasivs[22] += "\033[13G" + Karatavas.karatavasVards + "\033[106G";

    // Grāmatā uzzīmē zīmējumu.
    String[] zimejumaVeids = KaratavuIzskati.karatavuZimejums[Karatavas.karatavuKluduSkaits];
    for (int i = 0; i < zimejumaVeids.length; i++) {
      mainamaisMasivs[5 + i] += "\033[61G" + zimejumaVeids[i] + "\033[106G";
    }
  }

  public static String atgrieztRandAtstarpi() {
    String atstarpesLielums = "";
    // Nosaka cik liela būs atstarpe.
    for (int j = Main.rand.nextInt(5) + 4; j > 0; j--) {
      atstarpesLielums += " ";
    }
    return atstarpesLielums;
  }

  public static void saliktRandAtstarpesKaratavuGramata() {
    for (int i = 0; i < Karatavas.rAtstarpes.length ;i++) {
      Karatavas.rAtstarpes[i] = EkranuParklajumi.atgrieztRandAtstarpi();
    }
  }
}
