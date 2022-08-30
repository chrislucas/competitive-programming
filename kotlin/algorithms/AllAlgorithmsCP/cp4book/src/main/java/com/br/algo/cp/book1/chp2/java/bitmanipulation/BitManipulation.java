package com.br.algo.cp.book1.chp2.java.bitmanipulation;

import static com.br.algo.cp.book1.chp2.java.bitmanipulation.BitManipulation.BitManipulationTest.*;

/*
   https://github.com/stevenhalim/cpbook-code/blob/master/ch2/lineards/bit_manipulation.java
*/

public class BitManipulation {

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
  }

  private static int setbit(int value, int i) {
    return value | (1 << i);
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

  public static void main(String[] args) {
    checkBitIsSet();
    // checkClearBit();
    // checkToggle();
  }
}
