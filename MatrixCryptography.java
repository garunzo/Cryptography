import java.util.*;
import java.io.Console;
import java.io.FileReader;

/*
 * MatrixCryptography
 *
 * Luca Cotter - Feb 2017
 *
 * Attempts to decrypt a message with INTEGERS only.
 * The inverse of the matrix used to encrypt the message must
 * be in the range set in the program.
 *
 */

public class MatrixCryptography {

  static double tolerance = 0.01;

  public static boolean isNotLetter(double a) {
    return a < 0 || a > 26 ;
  }
  public static boolean areNotLetters(Pair p) {
    return isNotLetter(p.x) || isNotLetter(p.y);
  }

  public static boolean valid(Pair[] pairs, Pair v) {
    boolean worked = true;
    for (int i = 0; i < pairs.length; i++) {
      double result = v.multiply(pairs[i]);
      if (isNotInteger(result) || isNotLetter(result)) {
        worked = false;
        break;
      }
    }
    return worked;
  }

  public static char toChar(double c) {
    return (Math.abs(c - 64) < 2*tolerance) ? (char) 32 : (char) c;
  }

  public static boolean isNotInteger(double a) {
    return Math.abs(a - (int) a) > tolerance;
  }

  public static boolean areNotIntegers(Pair p) {
    return isNotInteger(p.x) || isNotInteger(p.y);
  }

  public static String buildSequence(Pair[] pairs, Pair p1, Pair p2) {
    String seq = "";
    for (int i = 0; i < pairs.length; i++) {
      Pair p = new Pair(pairs[i].multiply(p1), pairs[i].multiply(p2));
      if (areNotIntegers(p) || areNotLetters(p)) {
        seq = "";
        break;
      }
      seq = seq + toChar(p.x+64) + toChar(p.y+64);
    }
    return seq;
  }


  public static void main(String[] args) throws Exception  {

    int numberOfPairs = 10;
    Pair[] pairs = new Pair[numberOfPairs];

    Scanner userInputScanner = new Scanner(new FileReader(args[0]));

    // System.out.println("How many pairs are there?");


    numberOfPairs = Integer.parseInt(userInputScanner.nextLine());

    pairs = new Pair[numberOfPairs];

    for (int n = 0; n < numberOfPairs; n++) {
      String xy = userInputScanner.nextLine();
      String[] parts = xy.split(",");
      double x = Double.parseDouble(parts[0]);
      double y = Double.parseDouble(parts[1]);
      pairs[n] = new Pair(x,y);
      System.out.println(pairs[n].x + ", " + pairs[n].y);
    }

    int a, b, c, d;
    int num2;
    double dFactor = 100.0; // powers of 10 for fractions; 10 is 1
    int scope = 20;
    int numMatches;
    String old_sequence = "";
    do {
      numMatches = 0;
      int begin = -scope*((int) dFactor), end = scope*((int) dFactor);
      for(a = begin; a <= end;  a++) {
        for(c = begin; c <= end; c++) {
          Pair first = new Pair(a/dFactor,c/dFactor); // vertical 1
          if (valid(pairs, first)) {
            for (b = begin; b <= end; b++) {
              for (d = begin; d <= end; d++) {
                Pair second = new Pair(b/dFactor, d/dFactor); // vertical 2
                String sequence = buildSequence(pairs, first, second);
                if (sequence != "" && (!sequence.equals(old_sequence)) ) {
                  System.out.println(sequence + " : Vertical_1 : " + first + " Vertical_2 : " + second);
                  old_sequence = sequence; // save sequence to eliminate dupes
                  numMatches += 1;
                }
              }
            }
          }
        }
      }
      dFactor = dFactor*100.0;
    } while (numMatches < 2);
  }
}
