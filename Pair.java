public class Pair {
  double x;
  double y;

  // The Constructor
  public Pair(double x1, double y1) {
    this.x = x1;
    this.y = y1;
  }

  public double multiply(Pair p) {
    return this.x * p.x + this.y * p.y;
  }

  public Pair add(Pair p) {
    return new Pair(this.x+p.x,this.y+p.y);
  }
  public Pair subtract(Pair p) {
    return new Pair(this.x-p.x,this.y-p.y);
  }

  public Matrix inverseMatrix(Pair v1, Pair v2) {
    return new Matrix(v1, v2);
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
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
