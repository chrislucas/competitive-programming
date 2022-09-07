package com.br.algo.cp.book1.chp2.java.bitmanipulation;

public class UnsetBitRange {

  static class Test {
    static void checkUnsetBit() {
      int s = 1;
      int e = 4;
      int value = 127;
      System.out.printf(
          "Unset from %d-ith to %d-ith bit in %d = %d", s, e, value, unsetRangeBit(value, s, e));
    }
  }

  /*
     https://www.geeksforgeeks.org/unset-bits-given-range/
  */
  private static int unsetRangeBit(int value, int s, int e) {
    return value;
  }

  public static void main(String[] args) {}
}
