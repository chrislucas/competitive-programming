package com.br.algo.cp.book1.chp2.java.bitmanipulation;

/*
   https://stackoverflow.com/questions/18806481/how-can-i-get-the-value-of-the-least-significant-bit-in-a-number
*/

import static com.br.algo.cp.book1.chp2.java.bitmanipulation.LSB.Test.checkLSB;
import static java.lang.Math.log10;
import static java.lang.Math.round;

import java.util.Arrays;

public class LSB {

  static class Test {
    static void checkLSB() {

      int[] values = new int[] {11, 12, 10, 127, 8};

      Arrays.stream(values)
          .forEach(
              value ->
                  System.out.printf(
                      "LSB(%d) = bit mais a direita %d -> na potentica de 2 = %d | LSB2 = %d\n",
                      value, lsb(value), lsbValue(value), lsbValue2(value)));
    }
  }

  static double log(double value, long base) {
    return round(log10(value) / log10(base));
  }

  private static long lsb(long value) {
    return round(log(value & -value, 2));
  }

  private static long lsbValue(long value) {
    // devolve o bit mais significativo a esquerda da representacao binaria
    return value & -value;
  }

  private static long lsbValue2(long value) {
    int idx = 0;
    while (((~value) & 1) > 0) {
      value >>= 1;
      idx += 1;
    }
    return 1L << idx;
  }

  public static void main(String[] args) {
    checkLSB();
  }
}
