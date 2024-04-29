package Spele;

public class Enums {
  // * Šī klase satur sevī visas enum klases, priekš vieglākas atrašanas un organizēšanas.

  public static Istaba V_Istaba = Istaba.DURVIS;
  public static Virziens V_Virziens = Virziens.LABA_PUSE;

  public enum EkranuVeidi {
    SAKUMA,
    KARATAVAS,
    UZVARA,
    KONTA_IZVELE,
    KONTA_APSKATE,
    REGISTRACIJA,
    PIESLEGSANAS,
    KONTA_DROSIBAS_V,
    KONTA_REDIGESANA,
    IESTATIJUMI
  }
  // Konta apskates ekrāns (apskata visus konta datus).
  // Konta izvēles ekrāns (pieslēgties, reģistrēties).
  // Reģistrācijas ekrāns (izveido kontu).
  // Pieslēgšanās ekrāns (pieslēdzas jau izveidotam kontam).

  public enum NavesIemesli {
    LOGA_SPOKS,
    DURVJU_SPOKS,
    PAGRABA_SPOKS,
    PULKSTENIS,
    STRESS,
    KARATAVAS,
    ATRODI_PARI,
    UZVARA,
    PASNAVIBA;
  }

  public enum KustibasVirziens {
    // Izmanto, lai ērti un bez kļūdām varētu izmantot varoņa kustības metodi.
    POZITIVS(1),
    NEGATIVS(-1);

    public final int CIPARS;
    private KustibasVirziens(int CIPARS) {
      this.CIPARS = CIPARS;
    }
  }

  public enum Istaba {
    GULTA(0 , "GULTA"),
    DIVANS(1 , "DIVANS"),
    DURVIS(2 , "DURVIS"),
    VIRTUVE(3 , "VIRTUVE"),
    NAV(-1 , "NAV");

    // Ļauj enumiem piešķirt vērtību.
    public final int CIPARS;
    public final String ISTABA;

    private Istaba (int CIPARS, String ISTABA) {
      // Šie dati ir vajadzīgi, lai šo enum varētu salīdzināt ne tikai ar citiem enumiem,
      // bet arī ar citiem String un int tipiem, kuri atbilst to lietotai secībai un vērtībām.
      // Lai būtu ērtāk lietot.
      this.CIPARS = CIPARS;
      this.ISTABA = ISTABA;
    }
  }

  public enum Virziens {
    PRIEKSA(0),
    LABA_PUSE(1),
    LEJA(2),
    KREISA_PUSE(3);

    // Ļauj enumiem piešķirt vērtību.
    public final int CIPARS;

    private Virziens (int CIPARS) {
      this.CIPARS = CIPARS;
    }
  }
}
