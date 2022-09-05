package com.br.algo.cp.book1.chp2.java.bitmanipulation;

import java.util.Arrays;

public class TwoComplement {

  /*
     https://pt.wikipedia.org/wiki/Complemento_para_dois
     https://www.cs.cornell.edu/~tomf/notes/cps104/twoscomp.html

     ler
     https://www.javatpoint.com/2s-complement-in-digital-electronics
  */

  static int complement(int value) {
    return ~value;
  }

  static int complementOf2(int value) {
    return complement(value) + 1;
  }

  static void checkComplements() {
    Arrays.stream(new int[] {10, 12, 127})
        .forEach(
            value ->
                System.out.printf(
                    "1-complement %d, 2-complement %d\n", complement(value), complementOf2(value)));
  }

  public static void main(String[] args) {
    checkComplements();
  }
}
