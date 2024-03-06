package Spele.MazasSpeles.AtrodiPari;

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
    
  }

  public void aizpilditRezgi() {
    // Metode aizpilda režģi jeb masīvu ar random cipariem, kuri neatkārtojas vairāk par 2 reizēm,
    // bet atkārtojas vismaz 2 reizes (vienmēr būs 2 vienādi cipari).
    for (int i = 0; i < rindas; i++) {
      for (int j = 0; j < kolonnas ; j++) {
        // while (true) {
          rezgis[i][Main.rand.nextInt(kolonnas)] = rezgaCipari[i][j];

        // }
      }
    }


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
