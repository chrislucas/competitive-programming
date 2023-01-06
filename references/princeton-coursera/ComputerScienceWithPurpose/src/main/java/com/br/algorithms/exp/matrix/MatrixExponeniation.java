package com.br.algorithms.exp.matrix;

import java.util.List;

/** https://www.geeksforgeeks.org/matrix-exponentiation/ */
public class MatrixExponeniation {

  /**
   * TODO 1) implementar um algorimto de exponenciacao rapida de matriz para verificar o resultado
   * dessas matrizes sendo multiplicadas N vezes
   *
   * <p>2) Verifica se essas matrizes tem um nome especifoco
   *
   * <p>https://mathworld.wolfram.com/01-Matrix.html
   */
  static final List<int[][]> matrixes =
      List.of(
          new int[][] {{0, 0}, {0, 1}},
          new int[][] {{0, 0}, {1, 0}},
          new int[][] {{0, 1}, {0, 0}},
          new int[][] {{1, 0}, {0, 0}},
          new int[][] {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}});

  private static int[][] exp(int[][] matrix, int ith) {
    return null;
  }

  private static int[][] exp(int[][] matrix, int ith, int mod) {
    return null;
  }

  public static void main(String[] args) {
    int matA[][] = matrixes.get(0);

    exp(matA, 2023);
    exp(matA, 2023, 127);
  }
}
