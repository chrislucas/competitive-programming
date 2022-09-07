package com.br.algo.cp.book1.chp2.java.bitmanipulation;

import java.util.Arrays;
import java.util.List;

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

    final int[] tree;

    FenwickTree(int[] values) {
      tree = new int[values.length + 1];
      System.arraycopy(values, 0, tree, 1, values.length);
      for (int i = 1; i < tree.length; i++) {
        int parent = rsb(i) + 1;
        if (parent < values.length) {
          tree[parent] += tree[i];
        }
      }
    }

    void print() {}

    /**
     * @param i
     * @return
     */
    private int prefixSum(int i) {
      int rs = 0;
      // i = i - rsb(i), remove o bit ligado mais a direita de i
      for (; i > 0; i -= rsb(i)) {
        rs += tree[i];
      }
      return rs;
    }

    /**
     * https://www.baeldung.com/cs/fenwick-tree Com a estrutura BIT (binary index tree) podemos
     * fazer as operacoes de update e sim em O(logn) - se tivermos n operacoes de update e sum, em
     * media gastaremos no total O(nlogn) com todas as operacoes
     *
     * <p>- Range of responsibility - Na solucao usando prefix sum usamos o i para atualizar a
     * i-esima posicao do array e tambem o i pode representar no array de prefixo a soma dos i
     * primeiros elementos - Na Fenwick Tree usamos a representacao binaria desse mesmo indice i -
     * por isso chamamos de binary index tree - Na Fenwick Tree cada indice tem um intervalo de
     * responsabilidade - Calculamos o valor do intervalo baseado na posicao do bit que esta mais a
     * direita e está "ligado" ou rightmost set bit ou RSB
     *
     * <p>- Exemplo 11 = 1011 base 2 - O "intervalo de responsabilidade" do 11 é 1 - 1 na base 2 = 1
     * na base 10 - Exemplo 12 = 1100 base 2 - O bit ligado mais a direita é o 3 bit da direita para
     * esquerda - 100 base 2 = 4 base 10
     *
     * <p>https://www.baeldung.com/cs/fenwick-tree#range-calculation
     *
     * @see RSB
     * @see TwoComplement
     *     <p>A operacao de update eh oposta a prefixSum, comecao do input
     */
    private void add(int i, int delta) {
      for (; i < tree.length; i += rsb(i)) {
        tree[i] += delta;
      }
    }

    private void update(int i, int value) {
      int delta = value - tree[i];
      add(i, delta);
      tree[i] = value;
    }

    int sum(int s, int e) {
      return prefixSum(e) - prefixSum(s - 1);
    }

    private int rsb(int value) {
      return value & (-value); // range
    }

    /**
     * Fenwick Tree Structure https://www.baeldung.com/cs/fenwick-tree#tree-structure - A ideia
     * dessa estrutura eh precomputar/tabelar o "intervalo de responsabilidade" de cada indice - com
     * a tabela de intervalos podemos calcular a soma para cada intervalo [a1]; [a1...a2], [a1 ...
     * a3] ...
     *
     * <p>- seja F[i] o intervalo de responsabilidade de i. Para um Array A {a1, a2, a3, ... an}
     *
     * <p>temos o seguinte array F
     *
     * <p>exemplo: Fenwick para valores de 1 a 16 n — binary - rsb — fenwik/intervalo 1 – 0000 0001
     * 1 sum(a1) 2 – 0000 0010 2 sum(a1 ... a2) 3 - 0000 0011 1 sum(a3) 4 – 0000 0100 4 sum(a1 ...
     * a4)
     *
     * <p>5 – 0000 0101 1 sum(a5) 6 – 0000 0110 2 sum(a5 ... a6) 7 – 0000 0111 1 sum(a7) 8 – 0000
     * 1000 8 sum(a1 ... a8) 9 – 0000 1001 1 sum(a9)
     *
     * <p>10 – 0000 1010 2 sum(a9 .. a10) 11 – 0000 1011 1 sum(a11) 12 – 0000 1100 4 sum(a9 .. a12)
     * 13 – 0000 1101 1 sum(a13)
     *
     * <p>14 – 0000 1110 2 sum(a13 ... a14) 15 – 0000 1111 1 sum(a15) 16 – 0001 0000 16 sum(a1 ..
     * a16)
     *
     * <p>F[i] = Somatorio (k .. i) para k = i - rightmost_set_bit(i) + i
     *
     * <p>1 -> 1 2 -> 1. 2 3 -> 3 4 -> [1.2.3.4] 5 -> 5 6 -> 5, 6 7 -> 7 8 -> [1 .. 8] 9 -> 9 10 ->
     * 9, 10 11 -> 11 12 -> [9, 10, 11, 12] 13 -> 13 14 -> [13, 14] 15 -> 15 16 -> [1 .. 16]
     */
  }

  static class TestCaseFenwick {
    TestCaseFenwick(Update update, RangeSum rangeSum, FenwickTree fenwickTree) {
      this.update = update;
      this.fenwickTree = fenwickTree;
      this.rangeSum = rangeSum;
    }

    interface Operation {}

    static class Update implements Operation {
      final int index, value;

      Update(int index, int value) {
        this.index = index;
        this.value = value;
      }
    }

    static class RangeSum implements Operation {
      final int start, end;

      RangeSum(int start, int end) {
        this.start = start;
        this.end = end;
      }
    }

    final Update update;
    final FenwickTree fenwickTree;
    final RangeSum rangeSum;

    void execute(List<Operation> operations) {
      for (Operation operation : operations) {
        if (operation instanceof RangeSum) {

        } else if (operation instanceof Update) {

        }
      }
    }
  }

  private static void checkFenwickTree() {

    TestCaseFenwick[] cases =
        new TestCaseFenwick[] {
          new TestCaseFenwick(
              new TestCaseFenwick.Update(1, 10),
              new TestCaseFenwick.RangeSum(2, 4),
              new FenwickTree(new int[] {1, 2, 3, 4, 5, 19}))
        };
    Arrays.stream(cases)
        .forEach(
            testCase -> {
              TestCaseFenwick.RangeSum rangeSum = testCase.rangeSum;

              System.out.println(testCase.fenwickTree.sum(rangeSum.start, rangeSum.end));

              TestCaseFenwick.Update update = testCase.update;
              testCase.fenwickTree.add(update.index, update.value);
            });
  }

  public static void main(String[] args) {
    checkFenwickTree();
  }
}
