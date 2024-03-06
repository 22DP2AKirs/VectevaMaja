package Spele.MazasSpeles.AtrodiPari;

import Spele.SpelesProcesi.Ievade;
import Spele.SpelesProcesi.Main;

// Atrodi pāri algoritms.
// M-Spēles doma:
// Uz galda ir 5 x 5 kārtis (vai vairāk), un lietotājam ir norādot rindu un kolonnu ar
// cipariem 0 - 4 ir jāizvēlas 2 kārtis. Ja kārtis ir vienādas, tad viņas paliek atklātas.
// Ja kārtis ir dažādas, tad viņas apgriežas atpakaļ. Spēli uzvar, kad visas kārtis ir apgriestas.
public class AtrodiPari {
  
  /* Ierobežojumi:  
    ! Rindas un kolonnas abas nedrīkst būt nepāra skaitļi!
    ! Vienam no diviem mainīgajiem ir jābūt pāra.
  */ // Režģis jeb grid:
  private int kolonnas;
  private int rindas;
  int karsuDaudzums;

  int ieprieksejaisIevadesSkaitlis;

  // Iespējamie pozitīvie skaitļi:
  int[] pozitivie = { 2 , 4 , 6 , 8 };
  int[] negativie = { 1 , 3 , 5 , 7 };

  double karsuPari = 0.0;

  public static int[][] rezgis;

  int[][] rezgaCipari = {
    { 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 }, 
    { 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 }
  };

  public AtrodiPari(int rindas, int kolonnas) {
    
    this.rindas = rindas;
    this.kolonnas = kolonnas;
    rezgis = new int[rindas][kolonnas];
    karsuDaudzums = rindas * kolonnas;
  }

  public void izveletiesDivasKartis() {
    ieprieksejaisIevadesSkaitlis = Integer.parseInt(Ievade.lietotajaIevade);
  }


  public void aizpilditRezgi() {
    /* Metode aizpilda režģi jeb masīvu ar cipariem no 1 - n.
       Katrs cipars atkārtojas 1 reizi.
    */
    int ciparsXskaitlis = 0; // cipars vai skaitlis, kuru definē kā masīva elementu
    int skaititajs = -1; // Skaita cik reizes iekšējais cikls ir atkārtojies.

    // Cikla beigās, katram skaitlim vai ciparam ir jābūt savam pārim.
    for (int i = 0; i < rindas; i++) {
      for (int j = 0; j < kolonnas ; j++) {
        skaititajs++;
        // Pārbauda vai cikls jau ir atkārtojies 1 reizi un palielina pie masīva pieliekamo ciparu.
        if (skaititajs % 2 == 0) {
          ciparsXskaitlis++;
        }
        // Masīvā ieliek apstrādāto skaitli.
        rezgis[i][j] = ciparsXskaitlis;
      }
    }
  }

  public void samaisitRezgi() {
    int maisisanasReizes = 30; // 30 reizes, labi samaisa kārtis.
    int elementsKuruMainit; // Saglabā izvēlēto emelento uz noteiktu laiku.

    while (maisisanasReizes-- != 0) {
      // Elementa poz. kuru mainīs.
      int randRinda = Main.rand.nextInt(rindas);
      int randKolonna = Main.rand.nextInt(kolonnas);

      elementsKuruMainit = rezgis[randRinda][randKolonna];

      // Otrā elementa poz. uz kuru mainīs.
      int randRinda2 = Main.rand.nextInt(rindas);
      int randKolonna2 = Main.rand.nextInt(kolonnas);

      // Nomaina pirmo (izvēlēto) elementu uz otro.
      rezgis[randRinda][randKolonna] = rezgis[randRinda2][randKolonna2];

      // Nomaina otro (izvēlēto) elementu uz saglabāto pirmo.
      rezgis[randRinda2][randKolonna2] = elementsKuruMainit;
    }
    System.out.println("Done");
  }

  public void izvaditRezgi() {
    // Metode izvada izveidoto masīvu.
    for (int i = 0; i < rindas; i++) {
      for (int j = 0; j < kolonnas; j++) {
        System.out.print(rezgis[i][j] + "  ");
        karsuPari += 0.5;
      }
      System.out.println();
    }
    System.out.println("Atrasti " + karsuPari + " karsu pari!");
  }
}