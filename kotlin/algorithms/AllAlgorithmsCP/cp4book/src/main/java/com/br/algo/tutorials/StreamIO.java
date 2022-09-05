package com.br.algo.tutorials;

import java.util.Arrays;

public class StreamIO {

  static int rsb(int value) {
    return value & (-value);
  }

  static void testForeach() {
    Arrays.stream(new int[] {12, 8, 11, 24, 40, 48})
        .forEach(value -> System.out.println(rsb(value)));
  }

  public static void main(String[] args) {
    testForeach();
  }
}
