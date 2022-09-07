package com.br.algo.cp.book1.chp2.java.bitmanipulation;

import static com.br.algo.cp.book1.chp2.java.bitmanipulation.IntBitManipulation.BitManipulationTest.*;
import static java.lang.Math.log10;
import static java.lang.Math.round;

/*
   https://github.com/stevenhalim/cpbook-code/blob/master/ch2/lineards/bit_manipulation.java
   https://www.geeksforgeeks.org/program-to-clear-k-th-bit-of-a-number-n/
*/

public class IntBitManipulation {

  static class BitManipulationTest {

    static void checkSetBit() {
      System.out.println(setbit(10, 0));
      System.out.println(setbit(7, 3));
    }

    static void checkIsSet() {
      System.out.println(isSet(10, 1));
      System.out.println(isSet(10, 3));
      System.out.println(isSet(7, 2));
    }

    static void checkBitIsSet() {
      System.out.printf("ith %d bit is set in %d ? = %d\n", 1, 10, bitIsSet(10, 1));
      System.out.printf("ith %d bit is set in %d ? = %d\n", 3, 10, bitIsSet(10, 3));
      System.out.printf("ith %d bit is set in %d ? = %d\n", 2, 7, bitIsSet(7, 2));
      System.out.printf("ith %d bit is set in %d ? = %d\n", 0, 14, bitIsSet(14, 0));
    }

    static void checkClearBit() {
      System.out.println(clearBit(15, 3));
      System.out.println(clearBit(15, 2));
      System.out.println(clearBit(7, 2));
      System.out.println(clearBit(7, 0));
    }

    static void checkToggle() {
      System.out.printf("%d flip ith %d bit = %d\n", 10, 1, toggle(10, 1));
      System.out.printf("%d flip ith %d bit = %d\n", 127, 6, toggle(127, 6));
      System.out.printf("%d flip ith %d bit = %d\n", 127, 7, toggle(127, 7));
      System.out.printf("%d flip ith %d bit = %d\n", 127, 1, toggle(128, 1));
      System.out.printf("%d flip ith %d bit = %d\n", 19, 0, toggle(19, 0));
    }

    static void checkLowBit() {
      System.out.printf("Low bit of %d = %d\n", 19, lowBit(19));
      System.out.printf("Low bit of %d = %d\n", 11, lowBit(11));
      System.out.printf("Low bit of %d = %d\n", 10, lowBit(10));
      System.out.printf("Low bit of %d = %d\n", 128, lowBit(128));
      System.out.printf("Low bit of %d = %d\n", 127, lowBit(127));
      System.out.printf("Low bit of %d = %d\n", 256, lowBit(256));
      System.out.printf("Low bit of %d = %d\n", 255, lowBit(255));
    }

    static void checklowBitBase2() {
      System.out.printf(
          "Low bit of %d Base 2 = %d Base 10 = %d\n", 19, lowBitBase2(19), lowBit(19));
      System.out.printf(
          "Low bit of %d Base 2 = %d Base 10 = %d\n", 11, lowBitBase2(11), lowBit(11));
      System.out.printf(
          "Low bit of %d Base 2 = %d Base 10 = %d\n", 10, lowBitBase2(10), lowBit(10));
      System.out.printf(
          "Low bit of %d Base 2 = %d Base 10 = %d\n", 128, lowBitBase2(128), lowBit(128));
      System.out.printf(
          "Low bit of %d Base 2 = %d Base 10 = %d\n", 127, lowBitBase2(127), lowBit(127));
      System.out.printf(
          "Low bit of %d Base 2 = %d Base 10 = %d\n", 256, lowBitBase2(256), lowBit(256));
      System.out.printf(
          "Low bit of %d Base 2 = %d Base 10 = %d\n", 255, lowBitBase2(255), lowBit(256));
    }

    static void checkUnsetBit() {
      System.out.printf("Unset %d-ith bit in %d = %d\n", 1, 10, unsetbit(10, 1));
      System.out.printf("Unset %d-ith bit in %d = %d\n", 3, 10, unsetbit(10, 3));
      System.out.printf("Unset %d-ith bit in %d = %d\n", 0, 1, unsetbit(1, 0));
      System.out.printf("Unset %d-ith bit in %d = %d\n", 0, 0, unsetbit(0, 0));
    }

    static void checkModulo() {
      System.out.printf("%d modulo %d = %d\n", 10, 3, modulo(10, 3));
      System.out.printf("%d modulo %d = %d\n", 10, 2, modulo(10, 2));
      System.out.printf("%d modulo %d = %d\n", 10, 4, modulo(10, 4));
      System.out.printf("%d modulo %d = %d\n", 125, 10, modulo(125, 10));
      System.out.printf("%d modulo %d = %d\n", 125, 8, modulo(125, 8));
    }

    static void checkIsPowerOf2() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < (1 << 31) - 1; i++) {
        if (isPowerOf2(i)) {
          String format;
          if (sb.length() == 0) {
            format = String.format("%d", i);
          } else {
            format = String.format(" %d", i);
          }
          sb.append(format);
        }
      }
      System.out.println(sb);
    }

    static void checkMSB() {
      System.out.printf("msb1(%d) = %d; mbb2(%d) = %d\n", 10, msb1(10), 10, msb2(10));
      System.out.printf("msb1(%d) = %d; mbb2(%d) = %d\n", 273, msb1(273), 273, msb2(273));
      System.out.printf("msb1(%d) = %d; mbb2(%d) = %d\n", 127, msb1(127), 127, msb2(127));
      System.out.printf(
          "msb1(%d) = %d; mbb2(%d) = %d\n",
          Integer.MAX_VALUE, msb1(Integer.MAX_VALUE), Integer.MAX_VALUE, msb2(Integer.MAX_VALUE));
    }
  }

  private static int setbit(int value, int i) {
    return value | (1 << i);
  }

  // https://www.geeksforgeeks.org/program-to-clear-k-th-bit-of-a-number-n/
  private static int unsetbit(int value, int i) {
    return value & not(1 << i);
  }

  private static boolean isSet(int value, int i) {
    return (value & (1 << i)) > 0;
  }

  private static int bitIsSet(int value, int i) {
    return value & 1 << i;
  }

  private static int not(int value) {
    return ~value;
  }

  private static int clearBit(int value, int i) {
    return value & not(1 << i);
  }

  private static int toggle(int value, int i) {
    return value ^ (1 << i);
  }

  private static int lowBit(int value) {
    return value & (-value);
  }

  private static long lowBitBase2(int value) {
    /** troca de bases log b base a trocando para log b base c = log b base c / log a base c */
    return round(log10(value & (-value)) / log10(2));
  }

  private static int modulo(int value, int i) {
    return value & (i - 1);
  }

  private static boolean isPowerOf2(int value) {
    return (value & (value - 1)) == 0;
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
    // checkBitIsSet();
    // checkClearBit();
    // checkToggle();
    // checkLowBit();
    // checklowBitBase2();
    // checkUnsetBit();
    // checkModulo();
    // checkIsPowerOf2();
    checkMSB();
  }
}
