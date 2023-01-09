package com.br.algorithms.exp.matrix;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class AnotherBigIntMatrixExponentiation {

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

  private static boolean lessThan(BigInteger a, BigInteger b) {
    return a.compareTo(b) < 0;
  }

  private static BigInteger multiply(BigInteger a, BigInteger b, BigInteger m) {
    return (a.mod(m).multiply(b.mod(m))).mod(m);
  }

  private static boolean isOdd(BigInteger a) {
    return ONE.equals(a.and(ONE));
  }

  private static void fill(BigInteger[][] matrix, BigInteger value) {
    for (BigInteger[] bigIntegers : matrix) {
      Arrays.fill(bigIntegers, value);
    }
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

  /*
     Calculadora online de exponenciacao de matriz
     https://www.dcode.fr/matrix-power
  */
  private static BigInteger[][] exp(BigInteger[][] base, BigInteger e, BigInteger m) {
    if (ONE.compareTo(e) >= 0) {
      return base;
    } else {
      BigInteger[][] cpy = copy(base);
      while (lessThan(ZERO, e)) {
        if (isOdd(e)) {
          cpy = multiply(cpy, base, m);
        }
        base = multiply(base, base, m);
        e = e.shiftRight(1);
      }
      return cpy;
    }
  }

  private static void checkExp() {
    BigInteger[][] base =
        new BigInteger[][] {
          {BigInteger.valueOf(1), BigInteger.valueOf(2)},
          {BigInteger.valueOf(3), BigInteger.valueOf(4)}
        };

    // https://www.dcode.fr/matrix-power
    // para obter matrix ^ n mod m precisamos passar para funcao n - 1
    // exp(base, n - 1, m)
    BigInteger m = BigInteger.valueOf(100000000);
    print(exp(base, BigInteger.valueOf(10), m));

    System.out.println("********************************************************");
    Stream.of(
            new BigInteger[][] {{ZERO, ONE}, {ZERO, ZERO}},
            base,
            new BigInteger[][] {{ONE, ONE, ONE}, {ONE, ZERO, ZERO}, {ZERO, ONE, ZERO}})
        .forEach(
            matrix -> {
              print(exp(matrix, BigInteger.valueOf(6), m));
              System.out.println("********************************************************");
            });
  }

  private static void check1() {
    final Stream<BigInteger[][]> matrixes =
        Stream.of(
            // new BigInteger[][]{{ZERO, ZERO}, {ZERO, ONE}},
            // new BigInteger[][]{{ZERO, ZERO}, {ONE, ZERO}},
            // new BigInteger[][]{{ZERO, ONE}, {ZERO, ZERO}},
            new BigInteger[][] {{ONE, ZERO}, {ZERO, ZERO}},
            new BigInteger[][] {{ONE, ZERO, ZERO}, {ZERO, ZERO, ZERO}, {ZERO, ZERO, ZERO}},
            new BigInteger[][] {{ONE, BigInteger.valueOf(2)}, {BigInteger.valueOf(2), ONE}});

    matrixes.forEach(
        matrix -> {
          BigInteger m = BigInteger.valueOf(1000000000);
          print(exp(matrix, BigInteger.valueOf(10), m));
          System.out.println("********************************************");
        });
  }

  public static void main(String[] args) {
    // checkExp();
    check1();
  }
}
