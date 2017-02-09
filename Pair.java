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

  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
