package Spele;

public class Enums {
  // * Šī klase satur sevī visas enum klases, priekš vieglākas atrašanas un organizēšanas.

  public static Istabas V_Istaba = Istabas.GULTA;
  public static Virzieni V_Virziens = Virzieni.PRIEKSA;

  public enum EkranuVeidi {
    GALVENAIS_EKRANS,
    KARATAVU_EKRANS,
    UZVARAS_EKRANS,
    KONTA_IZVELES_EKRANS, // 
    KONTA_APSKATES_EKRANS,
    REGISTRACIJAS_EKRANS,
    PIESLEGSANAS_EKRANS,
    DROSIBAS_VARDA_EKRANS,
    REDIGESANAS_EKRANS
  }
  // Konta apskates ekrāns (apskata visus konta datus).
  // Konta izvēles ekrāns (pieslēgties, reģistrēties).
  // Reģistrācijas ekrāns (izveido kontu).
  // Pieslēgšanās ekrāns (pieslēdzas jau izveidotam kontam).

  public enum NavesIemesli {

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

  public enum Istabas {
    GULTA(0 , "GULTA"),
    DIVANS(1 , "DIVANS"),
    DURVIS(2 , "DURVIS"),
    VIRTUVE(3 , "VIRTUVE");

    // Ļauj enumiem piešķirt vērtību.
    public final int CIPARS;
    public final String ISTABA;

    private Istabas (int CIPARS, String ISTABA) {
      // Šie dati ir vajadzīgi, lai šo enum varētu salīdzināt ne tikai ar citiem enumiem,
      // bet arī ar citiem String un int tipiem, kuri atbilst to lietotai secībai un vērtībām.
      // Lai būtu ērtāk lietot.
      this.CIPARS = CIPARS;
      this.ISTABA = ISTABA;
    }
  }

  public enum Virzieni {
    PRIEKSA(0),
    LABA_PUSE(1),
    LEJA(2),
    KREISA_PUSE(3);

    // Ļauj enumiem piešķirt vērtību.
    public final int CIPARS;

    private Virzieni (int CIPARS) {
      this.CIPARS = CIPARS;
    }
  }
}
