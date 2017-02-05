public class Matrix {
  double[][] matrix;

  public Matrix(Pair v1, Pair v2) {
    matrix = new double[2][2];

    matrix[0][0] = v1.x;
    matrix[1][0] = v1.y;
    matrix[0][1] = v2.x;
    matrix[1][1] = v2.y;
  }

  public Matrix(double a, double b, double c, double d) {
    matrix = new double[2][2];

    matrix[0][0] = a;
    matrix[1][0] = b;
    matrix[0][1] = c;
    matrix[1][1] = d;
  }

  public double determinant() {
    double a = matrix[0][0];
    double b = matrix[0][1];
    double c = matrix[1][0];
    double d = matrix[1][1];
    double det = 1 / (a*d - b*c);
    return det;
  }

  public Matrix inverseMatrix() {
    double a = matrix[0][0];
    double b = matrix[0][1];
    double c = matrix[1][0];
    double d = matrix[1][1];
    double det = determinant();

    Matrix inverse = new Matrix(d*det, -b*det, -c*det, a*det);
    return inverse;
  }

  public String toString() {
    String dlm = "|";
    return dlm + matrix[0][0] + ", " + matrix[0][1] + dlm + "\n" +
           dlm + matrix[1][0] + ", " + matrix[1][1] + dlm;
  }

  public static void main(String[] args) {
    Pair v1 = new Pair(1,2);
    Pair v2 = new Pair(3,4);
    Matrix m = new Matrix(v1, v2);
    System.out.println("Start Matrix:\n"+m);
    System.out.println("Matrix inverse:\n"+m.inverseMatrix());

  }
}
