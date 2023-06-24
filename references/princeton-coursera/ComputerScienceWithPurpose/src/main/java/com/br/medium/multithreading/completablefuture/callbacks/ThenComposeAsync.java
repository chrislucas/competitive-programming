package com.br.medium.multithreading.completablefuture.callbacks;

public class ThenComposeAsync {

  /*
      https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
      thenComposeAsync

  */

  public static void main(String[] args) {}

  static class Test {
    private static int fn1(int x) {
      return fn2(3, x);
    }

    private static int fn2(int x, int y) {
      if (x <= 0) return y;
      else return fn2(x - 1, y * y);
    }

    private static int fn(int x) {
      if (x == 0 || x == 1) {
        return x;
      } else {
        return fn(x - 1) + fn(x - 2);
      }
    }

    private static int s1(int x) {
      if (x < 10) return x;
      else return x % 10 + s1(x / 10);
    }

    private static boolean bs(int[] data, int target) {
      int p = 0;
      int q = data.length - 1;
      int aux = -1;

      while (p <= q) {
        int m = (p + q) / 2;
        System.out.println(data[m]);
        if (data[m] == target) {
          return true;
        } else if (data[m] < target) {
          p = m + 1;
        } else {
          q = m - 1;
        }
      }

      return false;
    }

    private static void check() {
      /*
      for (int i = 0; i < 10; i++) {
          System.out.println(i + " " + fn(i));
      }

       */

      bs(new int[] {2, 4, 5, 8, 9, 12, 13, 17, 20}, 14);

      // System.out.println(fn1(2));
    }
  }
}
