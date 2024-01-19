package Spele.Varonis;

import Spele.SpelesProcesi.Main;

public class VaronaStatusaEfekti {
    public static float varonaStresaLimenis;

    public static void varonaStress() {
        // Viss, kas ietekmē varoņa stresa līmeni.
        if (!Main.istabuGaismasIeslegtas[Main.varonaIstabasSkaitlis] && !VaronaDarbibas.aizdedzinatsSerkocins) { // Ja istabā, kurā atrodas varonis ir izslēgta gaisma, tad ...
            varonaStresaLimenis += 0.1;
        }
    }

    public static void varonaBojaeja (String iemesls) {
        Main.varonisDzivs = false;
        try {Thread.sleep(100);} catch (InterruptedException e) {} // Cerība uz to, ka termināla izvade beigsies šinī laika intervālā.
        
        // Bojāejas pamatojuma kods:
        if (iemesls.equals("loga")) {

        }
        

        // Bojāejas rezultāts.
        Main.spelePalaista = false;
    }
}
