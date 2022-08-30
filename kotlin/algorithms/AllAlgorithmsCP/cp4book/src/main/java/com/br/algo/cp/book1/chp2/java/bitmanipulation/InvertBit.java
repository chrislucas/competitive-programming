package com.br.algo.cp.book1.chp2.java.bitmanipulation;

import static com.br.algo.cp.book1.chp2.java.bitmanipulation.InvertBit.Test.checkInvert;

public class InvertBit {

  static class Test {
    static void checkInvert() {

      int[] values = new int[] {10, 15, 328};

      for (int value : values) {
        System.out.printf(
            "Number %d, bin: %s | Inverted: %d Bin(Inverted) %s\n",
            value, binary(value), invert(value), binary(invert(value)));
      }
    }
  }

  static int invert(int value) {
    return ~value;
  }

  /** T0DOpegar a representacao binaria de um numero negativo */
  static String binary(int value) {
    StringBuilder sb = new StringBuilder();
    while (value > 0) {
      sb.append(String.format("%d", (value & 1) == 0 ? 0 : 1));
      value >>= 1;
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    checkInvert();
  }
}
