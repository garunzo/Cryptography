public class Pair {
  int x;
  int y;

  // The Constructor
  public Pair(int x1, int y1) {
    this.x = x1;
    this.y = y1;
  }

  public int multiply(Pair p) {
    return this.x * p.x + this.y * p.y;
  }

  public Pair add(Pair p) {
    return new Pair(this.x+p.x,this.y+p.y);
  }
  public Pair subtract(Pair p) {
    return new Pair(this.x-p.x,this.y-p.y);
  }
}

// Pair x, y;
// x = new Pair(1,2);
// z = new Pair(90,80);
// x.multiply(z);

/*
  primitives - int, float, boolean, double, long, short, char
  they don't objects.

  reference -> address in memory where that object resides

  They an object is defined is by a CLASS
*/
