package Spele.Parklajumi;

import java.util.Arrays;

import Spele.FailuLietotaji.SkanasSpeletajs;
import Spele.Iestatijumi.IestatijumuDati;
import Spele.Izskati.EkranuIzskati.EkranuVeidi;
import Spele.MazasSpeles.Karatavas.Karatavas;
import Spele.MazasSpeles.Karatavas.KaratavuIzskati;
import Spele.SpelesProcesi.Laiks;
import Spele.SpelesProcesi.Main;
import Spele.Varonis.VaronaStatusaEfekti;

// * Pārklāj Ekrānu.
public class EkranuParklajumi {
  
  public static String[] parklatEkranu(String[] originalaisEkrans, EkranuVeidi EKRANA_TIPS) {
    String[] ekranaKopija = Arrays.copyOf(originalaisEkrans, originalaisEkrans.length);

    // Caur iesniegto enum "EKRANA_TIPS", šī metode var viegli noteikt, kurus pārklājumus izmantot.
    if (EKRANA_TIPS.equals(EkranuVeidi.GALVENAIS_EKRANS)) {
      galvenaEkranaParklasana(ekranaKopija);
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.KARATAVU_EKRANS)) {
      gramatasParklasana(ekranaKopija);
    }
    else if (EKRANA_TIPS.equals(EkranuVeidi.UZVARAS_EKRANS)) {
      uzvarasEkranaParklasana(ekranaKopija);
    }

    return ekranaKopija;
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

  public static int izvelnesCipars = 0;
  private static void galvenaEkranaParklasana(String[] mainamaisMasivs) {
    // * Metode pārklās galveno ekrānu.

    // Pie teksta pieliek bultiņas.
    ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[izvelnesCipars] = 
    ParklajumuIzskati.izvelnesBultinas[0] + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[izvelnesCipars]
    .substring(1) + ParklajumuIzskati.izvelnesBultinas[1];

    // Uzklāj tekstus.
    mainamaisMasivs[11] += "\033[13G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[0] + "\033[106G";
    mainamaisMasivs[13] += "\033[15G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[1] + "\033[106G";
    mainamaisMasivs[15] += "\033[10G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[2] + "\033[106G";
    mainamaisMasivs[17] += "\033[13G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[3] + "\033[106G";
    mainamaisMasivs[19] += "\033[14G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[4] + "\033[106G";
    mainamaisMasivs[21] += "\033[16G" + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[5] + "\033[106G";

    // No teksta noņem pieliktās bultiņas.
    ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[izvelnesCipars] = 
    " " + ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[izvelnesCipars]
    .substring(12, ParklajumuIzskati.sakumaEkranaIzvelesVarduVarianti[izvelnesCipars].length() - 5);
  }

  public static String[] burti = "A B C D E F G H I J K L M N O P R S T U V Z".split(" "); // Burti, kurus var izmantot vārdu minēšanai.
  private static void gramatasParklasana(String[] mainamaisMasivs) {
    // * Metode pārklās grāmatu ar burtiem un zīmējumu.

    // Uz grāmatas saliek burtus.
    mainamaisMasivs[9] += "\033[13G" + burti[0] + Main.rAtstarpes[0] + burti[1] + Main.rAtstarpes[1] + burti[2] + Main.rAtstarpes[2] + burti[3] + Main.rAtstarpes[3] + burti[4] + "\033[106G";
    mainamaisMasivs[11] += "\033[8G" + burti[5] + Main.rAtstarpes[4] + burti[6] + Main.rAtstarpes[5] + burti[7] + Main.rAtstarpes[6] + burti[8] + Main.rAtstarpes[7] + burti[9] + "\033[106G";
    mainamaisMasivs[13] += "\033[11G" + burti[10] + Main.rAtstarpes[8] + burti[11] + Main.rAtstarpes[9] + burti[12] + Main.rAtstarpes[10] + burti[13] + "\033[106G";
    mainamaisMasivs[15] += "\033[9G" + burti[14] + Main.rAtstarpes[11] + burti[15] + Main.rAtstarpes[12] + burti[16] + Main.rAtstarpes[13] + burti[17] + Main.rAtstarpes[14] + burti[18] + "\033[106G";
    mainamaisMasivs[17] += "\033[18G" + burti[19] + Main.rAtstarpes[15] + burti[20] + Main.rAtstarpes[16] + burti[21] + "\033[106G";

    // Grāmatā ievieto izvēlēto vārdu.
    mainamaisMasivs[22] += "\033[13G" + Main.karatavasVards + "\033[106G";

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
    for (int i = 0; i < Main.rAtstarpes.length ;i++) {
      Main.rAtstarpes[i] = EkranuParklajumi.atgrieztRandAtstarpi();
    }
  }
}
