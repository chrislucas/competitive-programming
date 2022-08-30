package com.br.algo.cp.book1.chp2.java.binaryindextree;

/*
   https://www.geeksforgeeks.org/segment-tree-data-structure/

   Sgement Tree also known as a statistic tree, is a tree used for storing information about inrevals.

   - Essa estrutura permite consultar quais dos segmentos contem o objeto procurado
       - Em principio essa, Segment Tree (ST) é uma estrutura estatisca
       - Similar a uma interval Tree

   - Uma ST para um conjunto S de N intervalos usa O(n log n) de espaco e pode
   ser construido em O(n log n)
       - Suporta pesquisa em todos os intervalo em O(log n + k), k sendo o numero de
       intervalos recuperados para pesquisa

   https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/

   --
*/
public class BinaryIndexTreeFenwickTree {

  static class Tree {

    /*
       Vamos lidar com os indices da arvore a partir do 1
    */
    private final int[] tree;

    Tree() {
      this(1000);
    }

    Tree(int size) {
      if (size < 1000) {
        size = 1000;
      }
      tree = new int[size];
    }

    Tree(int[] data) {
      this();
      constructTree(data);
    }

    int getSum(int index) {
      int sum = 0;
      index += 1;
      while (index > 0) {
        sum += tree[index];
        index = index - (index & (-index));
      }
      return sum;
    }

    void update(int qAncestors, int index, int value) {
      index += 1;
      while (index <= qAncestors) {
        tree[index] += value;
        index = index + (index & (-index));
      }
    }

    void constructTree(int[] data) {}
  }

  public static void main(String[] args) {}
}
