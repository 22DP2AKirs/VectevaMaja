package Spele;

import Spele.Varonis.VaronaPozicijaUnSkataVirziens;

public class Enums {
  // * Šī klase satur sevī visas enum klases, priekš vieglākas atrašanas un organizēšanas.

  public static Istabas V_Istaba = Istabas.GULTA;
  public static Virzieni V_Virziens = Virzieni.PRIEKSA;

  public enum EkranuVeidi {
    GALVENAIS_EKRANS,
    KARATAVU_EKRANS,
    UZVARAS_EKRANS
  }

  public enum NavesIemesli {

  }

  public enum Element {
    H("Hydrogen"),
    HE("Helium"),
    // ...
    NE("Neon");

    public final String label;

    private Element(String label) {
        this.label = label;
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

  public static void mainitIstabasUnVirzienaEnumus() {
    // Nosaka varona Istabu.
    if (VaronaPozicijaUnSkataVirziens.varonaIstabasCipars == 0) {
      V_Istaba = Istabas.GULTA;
    }
    else if (VaronaPozicijaUnSkataVirziens.varonaIstabasCipars == 1) {
      V_Istaba = Istabas.DIVANS;
    }
    else if (VaronaPozicijaUnSkataVirziens.varonaIstabasCipars == 2) {
      V_Istaba = Istabas.DURVIS;
    }
    else if (VaronaPozicijaUnSkataVirziens.varonaIstabasCipars == 3) {
      V_Istaba = Istabas.VIRTUVE;
    }

    // Nosaka varona Virzienu.
    if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 0) {
      V_Virziens = Virzieni.PRIEKSA;
    }
    else if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 1) {
      V_Virziens = Virzieni.LABA_PUSE;
    }
    else if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 2) {
      V_Virziens = Virzieni.LEJA;
    }
    else if (VaronaPozicijaUnSkataVirziens.varonaVirzienaCipars == 3) {
      V_Virziens = Virzieni.KREISA_PUSE;
    }
  }
}
