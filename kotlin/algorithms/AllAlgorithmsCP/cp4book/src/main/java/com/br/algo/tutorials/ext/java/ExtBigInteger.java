package com.br.algo.tutorials.ext.java;

import java.math.BigInteger;

public class ExtBigInteger {

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

  private static boolean lessThan(BigInteger a, BigInteger b) {
    return a.compareTo(b) < 0;
  }

  private static boolean isOdd(BigInteger a) {
    return a.and(BigInteger.ONE).equals(BigInteger.ONE);
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

  public static void main(String[] args) {}
}
