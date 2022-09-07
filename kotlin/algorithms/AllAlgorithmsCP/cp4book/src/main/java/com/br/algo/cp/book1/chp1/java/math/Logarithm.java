package com.br.algo.cp.book1.chp1.java.math;

import static java.lang.Math.log10;
import static java.lang.Math.round;

public class Logarithm {

  /*
     Troca de bases
     log b base a trocando para log b base c =
     log b base c / log a base c
  */

  static double log(double value, long base) {
    return round(log10(value) / log10(base));
  }

  public static void main(String[] args) {
    System.out.println(log(27, 3));
    System.out.println(log(81, 3));
    System.out.println(log(32, 2));
    System.out.println(log(125, 5));
  }
}
