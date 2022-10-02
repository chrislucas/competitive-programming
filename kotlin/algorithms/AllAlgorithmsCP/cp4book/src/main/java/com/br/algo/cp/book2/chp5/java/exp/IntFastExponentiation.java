package com.br.algo.cp.book2.chp5.java.exp;

public class IntFastExponentiation {

  private static int fast(int base, int e) {
    if (e == 0) {
      return 1;
    } else if (e == 1) {
      return base;
    } else {
      int acc = 1;
      while (e > 0) {
        if ((e & 1) == 1) {
          acc *= base;
        }
        base *= base;
        e >>= 1;
      }
      return acc;
    }
  }

  private static int modular(int base, int e, int m) {
    if (e == 0) {
      return 1;
    } else if (e == 1) {
      return base;
    } else {
      int acc = 1;
      while (e > 0) {
        if ((e & 1) == 1) {
          acc = ((acc % m) * (base % m)) % m;
        }
        base = ((base % m) * (base % m)) % m;
        e >>= 1;
      }
      return acc;
    }
  }

  /*
     https://www.dcode.fr/modular-exponentiation
  */
  private static void testCaseModularExponentiation() {
    int[][] cases =
        new int[][] {
          {123, 2345, 3}, // 0
          {10, 125, 334}, // 28
          {1000, 125, 334}, // 22
        };

    for (int[] args : cases) {
      int b = args[0];
      int e = args[1];
      int m = args[2];
      System.out.println(modular(b, e, m));
    }
  }

  private static void testCaseExponentiation() {
    int[][] cases =
        new int[][] {
          {15, 5}, // 759375
          {3, 15}, // 14348907
        };

    for (int[] args : cases) {
      int b = args[0];
      int e = args[1];

      System.out.println(fast(b, e));
    }
  }

  public static void main(String[] args) {
    testCaseModularExponentiation();
    // testCaseExponentiation();
  }
}
