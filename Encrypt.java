public class Encrypt {

  public static void main(String[] args) {
    Pair vert1 = new Pair(1,2);
    Pair vert2 = new Pair(3,4);
    Matrix m = new Matrix(vert1, vert2);
    System.out.println("Encrypt matrix: \n" + m);
    System.out.println("Decrypt matrix: \n" + m.inverseMatrix());

    /*
     *  5  10
     *  6  -2
     *
     *      1             1        -2    -6
     * ------------- = --------
     *  -10 - (60)       -70       -10   5
    */
    char[] mesg;

    String message = "SPONGEBOB SQUAREPANTS AND PATRICK STAR ARE THE COOLEST KIDS IN TOWN";
    if (message.length() % 2 == 1) message+= " ";
    mesg = message.toCharArray();
    int len = message.length();

    int[] code = new int[len];

    int numberOfPairs = message.length() / 2;
    System.out.println(numberOfPairs);

    for (int i = 0 ; i < message.length(); i++ ) {
      if ((int) mesg[i] == 32 ) {
        code[i] = 0;
      } else {
        code[i] = (int) mesg[i] - 64;
      }
    }
    if (mesg.length % 2 == 1 ) {

    }

    // for (int i = 0 ; i < message.length(); i+=2) {
    //   System.out.println(mesg[i] + " " + mesg[i+1] + " : " + code[i] + ", " + code[i+1]);
    //   Pair p = new Pair(code[i], code[i+1]);
    //   int codex = vert1.multiply(p);
    //   int codey = vert2.multiply(p);
    //   System.out.println("Coded: " + codex + ", " + codey);
    // }

    // 12*5 + 21*6 = 60+126 = 186...  12*10 + 21*(-2) = 120 - 42 = 78
    for (int i = 0 ; i < message.length(); i+=2) {
      Pair p = new Pair(code[i], code[i+1]);
      double codex = vert1.multiply(p);
      double codey = vert2.multiply(p);
      System.out.println("pairs[" + i/2 + "] = new Pair(" + codex + ", " + codey + ");");
    }

    System.out.println(message.length()/2);
    for (int i = 0 ; i < message.length(); i+=2) {
      Pair p = new Pair(code[i], code[i+1]);
      double codex = vert1.multiply(p);
      double codey = vert2.multiply(p);
      System.out.println(codex + "," + codey);
    }
  }
}
