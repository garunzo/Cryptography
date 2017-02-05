import java.util.*;
import java.io.Console;

/*
 * MatrixCryptography
 *
 * Luca Cotter - Feb 2017
 *
 * Attempts to decrypt a message with INTEGERS only.
 * The inverse of the matrix used to encrypt the message must
 * be all integers.
 *
 * Adding some fractions
 */

public class MatrixCryptography {

  static double tolerance = 0.01;

  public static boolean isNotLetter(double value) {
    return value < 0 || value > 26;
  }

  public static boolean valid(Pair[] pairs, Pair v) {
    boolean worked = true;
    for (int i = 0; i < pairs.length; i++) {
      double result = v.multiply(pairs[i]);
      if (Math.abs(result - (int) result) > tolerance || isNotLetter(result)) {
        worked = false;
        break;
      }
    }
    return worked;
  }

  public static void main(String[] args) {

    int numberOfPairs = 10;
    Pair[] pairs = new Pair[numberOfPairs];
    // pairs[0] = new Pair(-9,27);
    // pairs[1] = new Pair(18,111);
    // pairs[2] = new Pair(-12,91);
    // pairs[3] = new Pair(26,65);
    // pairs[4] = new Pair(39,103);
    // pairs[5] = new Pair(0,99);
    // pairs[6] = new Pair(7,34);
    // pairs[7] = new Pair(-19,57);

    // pairs[0] = new Pair(8,21);
    // pairs[1] = new Pair(-15,-10);
    // pairs[2] = new Pair(-13,-13);
    // pairs[3] = new Pair(5,10);
    // pairs[4] = new Pair(5,25);
    // pairs[5] = new Pair(5,19);
    // pairs[6] = new Pair(-1,6);
    // pairs[7] = new Pair(20,40);
    // pairs[8] = new Pair(-18,-18);
    // pairs[9] = new Pair(1,16);

    // pairs[0] = new Pair(12,-5);
    // pairs[1] = new Pair(88,-110);
    // pairs[2] = new Pair(28,-5);
    // pairs[3] = new Pair(28,-35);

    // pairs[0] = new Pair(55.0, 41.0);
    // pairs[1] = new Pair(104.0, 76.0);
    // pairs[2] = new Pair(27.0, 18.0);
    // pairs[3] = new Pair(76.0, 57.0);
    // pairs[4] = new Pair(87.0, 60.0);
    // pairs[5] = new Pair(56.0, 42.0);
    pairs[0] = new Pair(55.0, 41.0);
    pairs[1] = new Pair(104.0, 76.0);
    pairs[2] = new Pair(27.0, 18.0);
    pairs[3] = new Pair(76.0, 57.0);
    pairs[4] = new Pair(87.0, 60.0);
    pairs[5] = new Pair(56.0, 42.0);
    pairs[6] = new Pair(103.0, 76.0);
    pairs[7] = new Pair(147.0, 104.0);
    pairs[8] = new Pair(18.0, 12.0);
    pairs[9] = new Pair(126.0, 91.0);
    //Scanner userInputScanner = new Scanner(System.in);

    // System.out.println("How many pairs are there?");

    for (int n = 0; n < numberOfPairs; n++) {
      System.out.println(pairs[n].x + ", " + pairs[n].y);
    }
    //numberOfPairs = Integer.parseInt(userInputScanner.nextLine());

    //Pair[] pairs = new Pair[numberOfPairs];


      // for (int n = 0; n < numberOfPairs; n++) {
      //
      //   System.out.println("Type pair " + (n+1) + ".");
      //   String xy = userInputScanner.nextLine();
      //   String[] parts = xy.split(",");
      //   int x = Integer.parseInt(parts[0]);
      //   int y = Integer.parseInt(parts[1]);
      //   pairs[n] = new Pair(x,y);
      //
      //   // System.out.println(x + "," + y);
      // }
      /*  for (int i = 0; i < numberOfPairs; i++) {
          System.out.println("\n" + (i+1) + ") " + pairs[i].x + "," + pairs[i].y);
        }*/
      int a, b, c, d;
      int num2;
      double dFactor = 10.0; // powers of 10 for fractions
      int scope = 20;
      int begin = -scope*((int) dFactor), end = scope*((int) dFactor);
      String old_sequence = "";
      for(a = begin; a <= end;  a++) {
        for(c = begin; c <= end; c++) {
          Pair first = new Pair(a/dFactor,c/dFactor); // vertical 1
          if (valid(pairs, first)) {
            for (b = begin; b <= end; b++) {
              for (d = begin; d <= end; d++) {
                Pair second = new Pair(b/dFactor, d/dFactor); // vertical 2
                boolean worked = true;
                String sequence = "";
                for (int i = 0; i < numberOfPairs; i++) {
                  // Loop through horizontal pairs
                  double result1 = pairs[i].multiply(first);
                  double result2 = pairs[i].multiply(second);
                  if (Math.abs(result1 - (int) result1) > tolerance) {
                    worked = false;
                    break;
                  }
                  if (Math.abs(result2 - (int) result2) > tolerance) {
                    worked = false;
                    break;
                  }
                  if (isNotLetter(result1) || isNotLetter(result2)) {
                    worked = false;
                    break;
                  }
                  //System.out.println(a + ", " + b + ", " + c + ", " + d);
                  result1 += 64;
                  result2 += 64;
                  char char1 = (Math.abs(result1 - 64) < 2*tolerance) ? (char) 32 : (char) result1;
                  char char2 = (Math.abs(result2 - 64) < 2*tolerance) ? (char) 32 : (char) result2;
                  sequence = sequence + char1 + char2;
                }
                if (worked && (!sequence.equals(old_sequence)) ) {
                  System.out.println(sequence + " : " + first.toString() + " " + second.toString());
                  old_sequence = sequence;
                }
              }
            }
        }
      }
    }
  }

}
