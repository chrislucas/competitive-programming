package com.br.algorithms.exp.matrix;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

/** https://usaco.guide/plat/matrix-expo?lang=cpp */
public class BigIntMatrixExpIthFibonacci {
  private static boolean isOdd(BigInteger a) {
    return ONE.equals(a.and(ONE));
  }

  private static BigInteger[][] multiply(BigInteger[][] a, BigInteger[][] b, BigInteger m) {
    int linA = a.length;
    int colB = b[0].length;
    int linB = b.length;
    BigInteger[][] c = new BigInteger[linA][colB];
    fill(c, ZERO);
    for (int i = 0; i < linA; i++) {
      for (int j = 0; j < colB; j++) {
        for (int k = 0; k < linB; k++) {
          c[i][j] = c[i][j].add(multiply(a[i][k], b[k][j], m));
        }
      }
    }
    return c;
  }

  private static void fill(BigInteger[][] matrix, BigInteger value) {
    for (BigInteger[] bigIntegers : matrix) {
      Arrays.fill(bigIntegers, value);
    }
  }

  private static BigInteger multiply(BigInteger a, BigInteger b, BigInteger m) {
    return (a.mod(m).multiply(b.mod(m))).mod(m);
  }

  private static void print(BigInteger[][] mat) {
    StringBuilder sb = new StringBuilder();
    for (BigInteger[] values : mat) {
      for (int j = 0; j < values.length; j++) {
        sb.append(String.format(j == 0 ? "%s" : " %s", values[j]));
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  private static BigInteger[][] copy(BigInteger[][] source) {
    BigInteger[][] cpy = new BigInteger[source.length][];
    for (int i = 0; i < source.length; i++) {
      cpy[i] = new BigInteger[source[i].length];
      System.arraycopy(source[i], 0, cpy[i], 0, source[i].length);
    }
    return cpy;
  }

  private static BigInteger[][] ith(BigInteger e, BigInteger m) {
    BigInteger fib[][] = new BigInteger[][] {{ONE, ONE}, {ONE, ZERO}};

    if (ONE.equals(e)) {
      return fib;
    } else {
      BigInteger[][] cpy = copy(fib);
      while (ZERO.compareTo(e) < 0) {
        if (isOdd(e)) {
          cpy = multiply(cpy, fib, m);
        }
        fib = multiply(fib, fib, m);
        e = e.shiftRight(1);
      }
      return cpy;
    }
  }

  private static void check() {
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .forEach(
            value -> {
              print(ith(BigInteger.valueOf(value), BigInteger.valueOf(100000000)));
              System.out.println("***********************");
            });
  }

  public static void main(String[] args) {
    check();
  }
}
