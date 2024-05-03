package Spele;

public final class K {
  // * K - Konstanti (Constants).
  // * Mainīgie, kuriem ir nemainīga vērtība.
  // Folderu jeb mapju lokācijas:
  public static final String 
  KONTU_MAPE = "Spele/KontaKods/Konti",
  PARAUGA_KONTS = "Spele/KontaKods/Konti/KontaParaugs.txt",
  SAKUMA_DATU_MAPE = "Spele/SakumaDatuSagatavosana/SakumaDati.txt",
  NAKTS_DATU_FAILS = "Spele/SakumaDatuSagatavosana/NaktsDati.txt";

  // Krāsas:
  public static final String 
  RESET = "\u001B[0m",
  MELNS = "\u001B[30m",
  TPELEKS = "\u001B[38;5;237m",
  SARKANS = "\u001B[31m",
  ORANZS = "\u001B[38;5;214m",
  BRUNS = "\u001B[38;5;130m",
  ZALS = "\u001B[32m",
  DZELTENS = "\u001B[33m",
  ZILS = "\u001B[34m",
  DEBESU_ZILS = "\u001B[38;5;117m",
  VIOLETS = "\u001B[35m",
  BALTS = "\u001B[37m",
  GRAMATA = "\u001B[38;5;180m",
  OBJEKTS = "\u001B[38;5;187m";

  // Masīvu elementa garumi.
  public static final String 
  EKRANA_GARUMA_IZMERS = "\033[106G",
  BILDES_MASIVA_BEIGU_KURSORA_POZICIJA = "\033[82G";

  // Masīvu elementu skaits.
  public static final int BILDES_MASIVA_IZMERS = 16;

  // Tukšā ievade:
  public static String TUKSA_IEVADE = "";

  // Spoku pēdējās fāzes:
  public static int 
  LOGA_SPOKA_FAZES = 7,
  DURVJU_SPOKA_FAZES = 7,
  PAGRABA_SPOKA_FAZES = 10;
}