package com.br.algo.cp.book2.chp5.java.exp;

import java.math.BigInteger;

public class BigIntFastExponentiation {

  private static BigInteger mod(BigInteger a, BigInteger b) {
    return a.remainder(b);
  }

  private static BigInteger multiply(BigInteger a, BigInteger b) {
    return a.multiply(b);
  }

  private static BigInteger multiply(BigInteger a, BigInteger b, BigInteger m) {
    return mod(multiply(mod(a, m), mod(b, m)), m);
  }

  private static boolean greaterThan(BigInteger a, BigInteger b) {
    return a.compareTo(b) > 0;
  }

  private static boolean isOdd(BigInteger a) {
    return BigInteger.ONE.equals(a.and(BigInteger.ONE));
  }

  private static BigInteger create(String value) {
    return new BigInteger(value);
  }

  private static BigInteger create(int value) {
    return new BigInteger(String.valueOf(value));
  }

  private static BigInteger shr(BigInteger a, int i) {
    return a.shiftRight(i);
  }

  private static BigInteger shl(BigInteger a, int i) {
    return a.shiftLeft(i);
  }

  private static BigInteger fast(BigInteger base, BigInteger e) {
    if (BigInteger.ZERO.equals(e)) {
      return BigInteger.ONE;
    } else if (BigInteger.ONE.equals(e)) {
      return base;
    } else {
      BigInteger acc = BigInteger.ONE;
      while (greaterThan(e, BigInteger.ZERO)) {
        if (isOdd(e)) {
          acc = multiply(acc, base);
        }
        base = multiply(base, base);
        e = shr(e, 1);
      }
      return acc;
    }
  }

  private static BigInteger fastModular(BigInteger base, BigInteger e, BigInteger m) {
    if (BigInteger.ZERO.equals(e)) {
      return BigInteger.ONE;
    } else if (BigInteger.ONE.equals(e)) {
      return base;
    } else {
      BigInteger acc = BigInteger.ONE;
      while (greaterThan(e, BigInteger.ZERO)) {
        if (isOdd(e)) {
          acc = multiply(acc, base, m);
        }
        base = multiply(base, base, m);
        e = shr(e, 1);
      }
      return acc;
    }
  }

  private static void testCaseModularExponentiation() {
    int[][] cases =
        new int[][] {
          {123, 2345, 3}, // 0
          {10, 125, 334}, // 28
          {1000, 125, 334}, // 180
        };

    for (int[] args : cases) {
      BigInteger b = create(args[0]);
      BigInteger e = create(args[1]);
      BigInteger m = create(args[2]);
      System.out.println(fastModular(b, e, m));
    }
  }

  private static void testCaseExponentiation() {
    int[][] cases =
        new int[][] {
          {15, 5}, // 759375
          {3, 15}, // 14348907
        };

    for (int[] args : cases) {
      BigInteger b = create(args[0]);
      BigInteger e = create(args[1]);
      System.out.println(fast(b, e));
    }
  }

  public static void main(String[] args) {
    testCaseExponentiation();
    testCaseModularExponentiation();
  }
}
