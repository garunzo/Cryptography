import java.util.*;
import java.io.Console;

public class MatrixCryptography {

  public static void main(String[] args) {

    Scanner userInputScanner = new Scanner(System.in);

    System.out.println("How many pairs are there?");
    int numberOfPairs = Integer.parseInt(userInputScanner.nextLine());

    Pair[] pairs = new Pair[numberOfPairs];

      for (int n = 0; n < numberOfPairs; n++) {

        System.out.println("\nType pair " + (n+1) + ".");
        String xy = userInputScanner.nextLine();
        String[] parts = xy.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        pairs[n] = new Pair(x,y);

        // System.out.println(x + "," + y);
      }
      /*  for (int i = 0; i < numberOfPairs; i++) {
          System.out.println("\n" + (i+1) + ") " + pairs[i].x + "," + pairs[i].y);
        }*/
      int a, b, c, d;
      int num2;
      int begin = -10, end = 10;
      for(a = begin; a <= end;  a++) {
        for(b = begin; b <= end; b++) {
          for (c = begin; c <= end; c++) {
            for (d = begin; d <= end; d++) {
              Pair first = new Pair(a,c); // vertical 1
              Pair second = new Pair(b, d); // vertical 2
              boolean worked = true;
              String sequence = "";
              for (int i = 0; i < numberOfPairs; i++) {
                // Loop through horizontal pairs
                int result1 = pairs[i].multiply(first);
                int result2 = pairs[i].multiply(second);
                if (result1 < 0 || result1 > 26 || result2 < 0 || result2 > 26) {
                  worked = false;
                  break;
                }
                System.out.println(a + ", " + b + ", " + c + ", " + d);
                result1 += 64;
                result2 += 64;
                char char1 = (result1 == 64) ? (char) 32 : (char) result1;
                char char2 = (result2 == 64) ? (char) 32 : (char) result2;
                sequence = sequence + char1 + char2;
              }
              if (worked) {
                System.out.println(sequence);
              }
            }
          }
        }
      }
  }

}
