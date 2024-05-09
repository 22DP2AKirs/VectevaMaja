package Spele.Majasdarbi.SamaisitieVardi;

import Spele.K;
import Spele.PaligMetodes;
import Spele.Majasdarbi.MajasdarbuIzvelesKods;
import Spele.SpelesProcesi.Main;

public class SamaisitieVardi {
  /** Spēles doma:
   * Lietotājam ir jāizveido vārds no samaisitiem burtiem.
   * Rezultātā ir jāizmanto visi dotie burti.
   */
  public static SamaisitieVardi samaisitieVardi;

  public String lietotajaVards = K.TUKSA_IEVADE;
  public String izveletaisVards;
  public String samaisitoBurtuVirkne;

  // Karātavās iespējamo vārdu masīvs.
  private String[][] karatavasVardi = 
  { // Rindas - Grūtības pakāpe, Kolonnas - Vārds no izvēlētās grūtības pakāpes.
  { "AKA" , "BITE" , "OLA" , "BISE" , "OGA" , "KOKS" , "ALA" }, // Viegls 3 - 4 burti.
  { "RIEPA" , "LAIVA" , "BILDE" , "KASTE" , "PUTNS" , "SKAPIS" , "PUDELE" }, // Normāls 5 - 6 burti. R I E P A
  { "BASEINS" , "CITRONS" , "TELEFONS" , "AUTOBUSS" , "BINOKLIS" , "GREDZENS" , "ARBALETS" }, // Grūts 7 - 8 burti.
  { "BUMBIERIS" , "KLAVIERES" , "AKVAPARKS" , "TALISMANS" , "STIPENDIJA" , "TEHNIKUMS" , "PILDSPALVA" } // Sarežģīts 9 - 10 burti.
  }; 

  public SamaisitieVardi(int vardaGrutiba, int vardsPecKartas) {
    izveletaisVards = karatavasVardi[vardaGrutiba][vardsPecKartas];
    samaisitBurtus();
  }

  public static void izveidotJaunuSVObjektu() {
    samaisitieVardi = new SamaisitieVardi(Main.rand.nextInt(4), Main.rand.nextInt(7));
  }

  public void samaisitBurtus() {
    // Izvēlētajam vārdam samaisa burtu secību.
    char[] simboli = izveletaisVards.toCharArray();
    int vardaGarums = izveletaisVards.length();
    samaisitoBurtuVirkne = K.TUKSA_IEVADE;

    // 1. Samaisa elementus ar vietām 'n' reizes.
    for (int i = 0; i < 30; i++) {
      PaligMetodes.mainitCharElementusArVietam(simboli, Main.rand.nextInt(vardaGarums), Main.rand.nextInt(vardaGarums));
    }

    // 2. Parveido simbolus par String tipu.
    for (char c : simboli) {
      samaisitoBurtuVirkne += c;
    }

    // 3. Saliek atstarpes simbolu virknē, lai simbolus būtu vieglāk salasīt.
    samaisitoBurtuVirkne = PaligMetodes.saliktAtstarpesSimboluVirkne(samaisitoBurtuVirkne, 2);
  }

  public void parbauditVardu() {
    // Pārbauda vai lietotājs ir ievadījis pareizo vārdu.
    if (lietotajaVards.equals(izveletaisVards)) {
      // Uzvaras kods.
      PaligMetodes.gulet(1);
      SMSavienojums.MDSamaisitieVardi = false;
      MajasdarbuIzvelesKods.izpildijaMajasdarbu();
    }
  }
}
