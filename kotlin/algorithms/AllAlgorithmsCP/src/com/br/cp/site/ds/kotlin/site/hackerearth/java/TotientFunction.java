package src.com.br.cp.site.ds.kotlin.site.hackerearth.java;

public class TotientFunction {

  static long phi(long n) {
    long result = n;
    for (long p = 2; p * p <= n; p++) {
      if (n % p == 0) {
        while (n % p == 0) {
          n /= p;
        }
        result -= result / p;
      }
    }
    if (n > 1) {
      result -= result / n;
    }
    return result;
  }

  static void checkPhi() {
    for (int i = 1; i < 100; i++) {
      System.out.printf("Phi(%d) = %d\n", i, phi(i));
    }
  }

  public static void main(String[] args) {
    checkPhi();
  }
}
