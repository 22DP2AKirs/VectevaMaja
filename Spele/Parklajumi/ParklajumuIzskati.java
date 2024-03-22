package Spele.Parklajumi;

import Spele.K;

public class ParklajumuIzskati {
  // * Šinī klasē ir pārklāji izskati jeb pārklāji, kurus izmantos, lai pārklātu bildes.

  // Galvenā ekrāna (main menu) pārklājumi.
  public static final String[] izvelnesBultinas = { Spele.K.DEBESU_ZILS + ">", "<" + Spele.K.RESET };
  public static String[] sakumaEkranaIzvelesVarduVarianti = 
  {
  "  T U R P I N A T   X ",
  "  S P E L E T ",
  "  I E S T A T I J U M I   X ",
  "  P A M A C I B A   X ",
  "  K O N T S ",
  "  I Z I E T "
};
 
  // Sērkocins.
  public static String[] serkocinaIzskats = {
    // Ja apstrādāto līniju pārdefinē ar sērkociņu, tad pārdefinētā līnija neatjaunosies iepriekšējā ciklā "Iegūst neapstrādāto bildi". Būs statiska bilde ar sērkociņu klāt un nodzēstu galu.
    // Ja apstrādātai līnijai pieliks klāt sērkociņu, tad pārveidotā līnija tiks atjaunot, bet būs ar nodzēstu galu.
    // \r nepalīdz atstāt galu.
    // Pieliekot RESET vai krāsas maiņu arī nepalīdz.

    // * Pieliekot beigās ANSI \033[#G kodu (Pārvietot rakstīšanas kursoru uz # kolonnu) ar # esot visa teksta līnijas beigas (arī aiz sērkociņa) nenodzēsa tālākos tekstu. !!!!!!!!!
    // K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA

    "\033[61G" + K.DZELTENS + "/\\_" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
    "\033[60G"+ K.ORANZS + "/   \\" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
    "\033[60G" + K.SARKANS + "| O  |" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
    "\033[61G" + K.SARKANS + "'-\\'" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
    "\033[64G" + K.BRUNS + "\\" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA
  };

  // Durvju arkām.
  public static final String[] arkuGaismasAizpilditajs = { 
    // * Masīva elementus izmanto, lai aizpildītu arkas jeb durvju rāmīšus.
    K.TPELEKS + "░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
    K.TPELEKS +  "░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA
  };

  // Virtuves pagraba arka.
  public static final String[] virtuvesPagrabaParklajs = {
    "\033[10G" + K.TPELEKS + "░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA,
    "\033[8G" + K.TPELEKS + "░░░░░░░░░░░░░░░░░" + K.RESET + K.BILDES_MASIVA_BEIGU_KURSORA_POZICIJA
  };
}
