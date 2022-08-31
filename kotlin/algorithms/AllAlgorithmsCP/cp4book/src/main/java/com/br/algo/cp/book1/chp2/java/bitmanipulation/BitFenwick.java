package com.br.algo.cp.book1.chp2.java.bitmanipulation;

public class BitFenwick {

  /*
     https://www.baeldung.com/cs/fenwick-tree

     Dado um array A {a1, a2 ... an} cujo indice inicial é 1,
     e possiveis 2 operacoes que podem ser feitas em A UPDATE e SUM,
     para UPDATE(idx, value) aplicaos A[idx] = value e  SUM aplicamos
     SUM(s, e) sendo soma entre os elemensot A[s ... e].

     Implementar essas operacoes de forma eficiente
  */

  static class PrefixSum {

    private final int[] prefixSum;

    PrefixSum(int[] init) {
      prefixSum = new int[init.length + 1];
      prefixSum[1] = 0;
      for (int i = 1; i < prefixSum.length; i++) {
        prefixSum[i] = prefixSum[i - 1] + init[i - 1];
      }
    }

    // O(1)
    int sum(int s, int e) {
      if (s > 0 && e < prefixSum.length) {
        return prefixSum[e] - prefixSum[s - 1];
      } else if (e < prefixSum.length) {
        return prefixSum[e] - prefixSum[0];
      } else {
        return -1;
      }
    }

    // O(n)
    void update(int i, int value) {
      if (i > 0 && i < prefixSum.length) {
        int diff = prefixSum[i] - value;
        for (int j = i + 1; j < prefixSum.length; j++) {
          prefixSum[j] += diff;
        }
        prefixSum[i] = value;
      }
    }
  }

  static class FenwickTree {

    /**
     * As operacoes de update e soma a partir de i-esimo indice do array sao baseados na forma
     * binario do indice i
     */
    void update() {}

    void sum() {}
  }

  public static void main(String[] args) {}
}
