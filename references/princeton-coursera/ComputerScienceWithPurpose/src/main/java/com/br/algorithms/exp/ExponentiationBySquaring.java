package com.br.algorithms.exp;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.stream.Stream;

public class ExponentiationBySquaring {

  private static BigInteger multiply(BigInteger a, BigInteger b, BigInteger m) {
    return ((a.mod(m)).multiply(b.mod(m))).mod(m);
  }

  private static boolean greaterThan(BigInteger a, BigInteger b) {
    return a.compareTo(b) > 0;
  }

  private static boolean lessThan(BigInteger a, BigInteger b) {
    return a.compareTo(b) < 0;
  }

  private static BigInteger exp(BigInteger a, BigInteger e, BigInteger m) {
    if (ZERO.equals(e)) {
      return ONE;
    } else if (ONE.equals(e)) {
      return a;
    } else {
      BigInteger acc = BigInteger.valueOf(1);
      while (lessThan(ZERO, e)) {
        if (ONE.equals(e.and(ONE))) {
          acc = multiply(acc, a, m);
        }
        a = multiply(a, a, m);
        e = e.shiftRight(1);
      }
      return acc;
    }
  }

  // https://www.dcode.fr/modular-exponentiation
  private static void checkExp() {
    Stream.of(new int[] {123, 23, 7}, new int[] {1000, 125, 334}, new int[] {123456, 125, 334})
        .forEach(
            values -> {
              BigInteger b = BigInteger.valueOf(values[0]);
              BigInteger e = BigInteger.valueOf(values[1]);
              BigInteger m = BigInteger.valueOf(values[2]);
              System.out.println(exp(b, e, m));
            });
  }

  public static void main(String[] args) {
    checkExp();
  }
}
