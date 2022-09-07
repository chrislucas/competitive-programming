package com.br.algo.cp.book1.chp2;

public class CheckFindRootBitwise {

  private static void checkPlusAndMinus() {
    int acc = 1;
    int lim = 100000;
    while (acc <= lim) {
      int result = acc + acc & (-acc);
      System.out.printf("%d + (%d & %d) = %d\n", acc, acc, -acc, result);
      acc = result;
    }
  }

  private static void checkMinusAndMinus() {
    int acc = 100000;
    while (acc > 0) {
      int result = acc - (acc & (-acc));
      System.out.printf("%d - (%d & %d) = %d\n", acc, acc, -acc, result);
      acc = result;
    }
  }

  private static void checkOperation() {
    checkPlusAndMinus();
    System.out.println("**********");
    checkMinusAndMinus();
  }

  private static void checkPowerOf2() {
    for (int i = 0; i < 31; i++) {
      int powerOf2 = 1 << i;
      System.out.println(powerOf2 & -powerOf2);
    }

    System.out.println("******************************************");
    for (int i = 1000000; i > 0; i--) {
      System.out.printf("%d -> %d\n", i, i & -i);
    }
  }

  public static void main(String[] args) {
    // checkPowerOf2();
    checkOperation();
  }
}
