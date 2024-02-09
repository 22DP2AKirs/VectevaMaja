package Spele.Parklajumi;

import java.util.Arrays;

import Spele.K;
import Spele.MazasSpeles.Karatavas;
import Spele.MazasSpeles.KaratavuIzskati;
import Spele.SpelesProcesi.Main;

public class EkranuParklajumi {
  public static String[] burti = "A B C D E F G H I J K L M N O P R S T U V Z".split(" "); // Burti, kurus var izmantot vārdu minēšanai.

  public static String[] parklatEkranu(String[] originalaisEkrans) {
    String[] ekranaKopija = Arrays.copyOf(originalaisEkrans, originalaisEkrans.length);
    gramatasParklasana(ekranaKopija);

    return ekranaKopija;
  }

  private static void gramatasParklasana(String[] mainamaisMasivs) {
    // * Metode pārklās grāmatu ar burtiem un zīmējumu.

    // Uz grāmatas saliek burtus.
    mainamaisMasivs[9] += "\033[13G" + burti[0] + Main.rAtstarpes[0] + burti[1] + Main.rAtstarpes[1] + burti[2] + Main.rAtstarpes[2] + burti[3] + Main.rAtstarpes[3] + burti[4] + "\033[106G";
    mainamaisMasivs[11] += "\033[8G" + burti[5] + Main.rAtstarpes[4] + burti[6] + Main.rAtstarpes[5] + burti[7] + Main.rAtstarpes[6] + burti[8] + Main.rAtstarpes[7] + burti[9] + "\033[106G";
    mainamaisMasivs[13] += "\033[11G" + burti[10] + Main.rAtstarpes[8] + burti[11] + Main.rAtstarpes[9] + burti[12] + Main.rAtstarpes[10] + burti[13] + "\033[106G";
    mainamaisMasivs[15] += "\033[9G" + burti[14] + Main.rAtstarpes[11] + burti[15] + Main.rAtstarpes[12] + burti[16] + Main.rAtstarpes[13] + burti[17] + Main.rAtstarpes[14] + burti[18] + "\033[106G";
    mainamaisMasivs[17] += "\033[18G" + burti[19] + Main.rAtstarpes[15] + burti[20] + Main.rAtstarpes[16] + burti[21] + "\033[106G";

    // Grāmatā ievieto izvēlēto vārdu.
    mainamaisMasivs[22] += "\033[15G" + Main.karatavasVards + "\033[106G";

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
}
