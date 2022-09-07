package com.br.algo.cp.book1.chp2.java.bitmanipulation;

import static com.br.algo.cp.book1.chp2.java.bitmanipulation.MSB.Test.checkMSB;
import static java.lang.Math.log10;

import java.util.Arrays;

// most significative bit
public class MSB {

  static class Test {
    static void checkMSB() {
      int[] values = new int[] {10, 273, 127, 11, 12, Integer.MAX_VALUE};
      Arrays.stream(values)
          .forEach(
              value ->
                  System.out.printf(
                      "msb1(%d) = %d; mbb2(%d) = %d\n", value, msb1(value), value, msb2(value)));
    }
  }

  /*
     https://www.geeksforgeeks.org/find-significant-set-bit-number/
  */
  private static int msb1(int value) {
    return 1 << (int) (log10(value) / log10(2));
  }

  // https://www.geeksforgeeks.org/find-significant-set-bit-number/
  private static int msb2(int value) {
    value = value | (value >> 1);
    value = value | (value >> 2);
    value = value | (value >> 4);
    value = value | (value >> 8);
    value = value | (value >> 16);
    value += 1;
    return value >> 1;
  }

  public static void main(String[] args) {
    checkMSB();
  }
}
