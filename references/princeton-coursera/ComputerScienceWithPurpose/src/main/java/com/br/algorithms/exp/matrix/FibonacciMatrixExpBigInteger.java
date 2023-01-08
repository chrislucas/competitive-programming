package com.br.algorithms.exp.matrix;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/matrix-exponentiation/
 *
 * <p>Resumo do texto no link acima
 *
 * <p>Para resolver uma exponenciacao de matriz temos a seguinte recorrencia
 *
 * <p>1) F(n) = aF(n-1) + bF(n-2) + cF(n-3) a,b,c sao constantes
 *
 * <p>Rerepsentando a equacao 1 em termos de matriz
 *
 * <p>F_Mat_1 = F_Mat_2 * F_Mat_3
 *
 * <p>F_Mat_1: Uma matriz 3x1 na seguinte forma { {f(n)}, {f(n-1)}, {f(n-2)} }
 *
 * <p>F_Mat_3 = Tambem uma matriz 3x1 na seguinte forma { {f(n-1)}, {f(n-2)}, {f(n-3)} }
 *
 * <p>Seguindo as regras de multiplicacao a Matriz F_Mat_2 precisa ter dimensao 3x3 para multiplicar
 * F_Mat_3 (numero de colunas da matriz A precisa ser igual a de linhas da matriz B e a matriz
 * resultante tera a quantidade de linhas de A e colunas de B)
 *
 * <p>F_Mat_3 =
 *
 * <p>{ {a, b, c} {1, 0, 0} {0, 1, 0} }
 *
 * <p>Com esses as matrizes tendo esses valores a equacao F_Mat_1 = F_Mat_2 * F_Mat_3 eh verdadeira
 *
 * <p>Assumimos que: f(0) = 0, f(1) = 1 e f(2) = 1 (fibonacci \0/)
 *
 * <p>para n = 3 {{f(3)}, {f(2)}, {f(1)}} = { {a,b,c}, {1,0,0}, {0, 1, 0}} * {{f(2)}, {f(1)},
 * {f(0)}}
 *
 * <p>para n = 4 {{f(4)}, {f(3)}, {f(2)}} = { {a,b,c}, {1,0,0}, {0, 1, 0}} * {{f(3)}, {f(2)},
 * {f(1)}}
 *
 * <p>seja A = {{f(4)}, {f(3)}, {f(2)}} seja B = {{a,b,c}, {1,0,0}, {0, 1, 0}} seja FIB = {{f(2)},
 * {f(1)}, {f(0)}}
 *
 * <p>A = B * B * FIB
 *
 * <p>seja N = {{f(n)}, {f(n-1)}, {f(n-2)}}
 *
 * <p>N = B ^ (n-2) * FIB
 *
 * <p>Matrix Power https://www.dcode.fr/matrix-power
 */
public class FibonacciMatrixExpBigInteger {

  static final List<BigInteger[][]> matrixes =
      List.of(
          new BigInteger[][] {{ZERO, ZERO}, {ZERO, ONE}},
          new BigInteger[][] {{ZERO, ZERO}, {ONE, ZERO}},
          new BigInteger[][] {{ZERO, ONE}, {ZERO, ZERO}},
          new BigInteger[][] {{ONE, ZERO}, {ZERO, ZERO}},
          new BigInteger[][] {{ONE, ZERO, ZERO}, {ZERO, ZERO, ZERO}, {ZERO, ZERO, ZERO}});
  /**
   * nth termo f(n) = f(n-1) + f(n-2) + f(n-3) para n >= 3 casos bases f(0) = 0; f(1) = 1; f(2) = 1
   */
  BigInteger[][] res = new BigInteger[][] {{ZERO}, {ZERO}, {ZERO}};

  BigInteger[][] fib = new BigInteger[][] {{ONE}, {ONE}, {ZERO}};

  private static void print(BigInteger[][] mat) {
    StringBuilder sb = new StringBuilder();
    for (BigInteger[] values : mat) {
      for (int j = 0; j < values.length; j++) {
        sb.append(String.format(j == 0 ? "%s" : " %s", values[j]));
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static BigInteger multiply(BigInteger a, BigInteger b, BigInteger m) {
    return (a.mod(m).multiply(b.mod(m))).mod(m);
  }

  private static void fill(BigInteger[][] matrix, BigInteger value) {
    for (BigInteger[] bigIntegers : matrix) {
      Arrays.fill(bigIntegers, value);
    }
  }

  private static BigInteger[][] multiply(BigInteger[][] a, BigInteger[][] b, BigInteger m) {
    int linA = a.length;
    int colB = b[0].length;
    int linB = b.length;
    BigInteger[][] c = new BigInteger[linA][colB];
    fill(c, ZERO);
    for (int i = 0; i < linA; i++) {
      for (int j = 0; j < colB; j++) {
        for (int k = 0; k < linB; k++) {
          c[i][j] = c[i][j].add(multiply(a[i][k], b[k][j], m));
        }
      }
    }
    return c;
  }

  private static BigInteger[][] fibA(BigInteger[][] base, int n, BigInteger m) {
    BigInteger[][] cpy = new BigInteger[][] {{ONE, ONE, ONE}, {ONE, ZERO, ZERO}, {ZERO, ONE, ZERO}};
    if (n == 1) {
      return base;
    }
    fibA(base, /*n / 2*/ n >> 1, m);
    multiply(base, base, m);
    if ((n & 1) == 1) {
      multiply(base, cpy, m);
    }
    return base;
  }

  private static void checkFibA() {
    BigInteger[][] base =
        new BigInteger[][] {{ONE, ONE, ONE}, {ONE, ZERO, ZERO}, {ZERO, ONE, ZERO}};
    int n = 1023;
    print(fibA(base, n - 2, BigInteger.valueOf(127)));
  }

  /** Calcula */
  private static BigInteger[][] fibexpIt(BigInteger n, BigInteger m) {

    /**
     * nth termo f(n) = f(n-1) + f(n-2) + f(n-3) para n >= 3 casos bases f(0) = 0; f(1) = 1; f(2) =
     * 1
     */
    BigInteger[][] res = new BigInteger[][] {{ZERO}, {ZERO}, {ZERO}};
    BigInteger[][] base =
        new BigInteger[][] {
          {ONE, ONE, ONE},
          {ONE, ZERO, ZERO},
          {ZERO, ONE, ZERO}
        };
    // BigInteger[][] fib = new BigInteger[][]{{ONE}, {ONE}, {ZERO}};
    if (ONE.equals(n)) {
      return res;
    } else {
      // se (ZERO < n) entao  compareTo < 0
      while (ZERO.compareTo(n) < 0) {
        if (ONE.equals(n.and(ONE))) {
          res = multiply(res, base, m);
        }
        base = multiply(base, base, m);
        n = n.shiftRight(1);
      }
    }
    return res;
  }

  private static void checkFibIt() {
    print(fibexpIt(BigInteger.valueOf(10), BigInteger.valueOf(3)));
  }

  public static void main(String[] args) {
    checkFibA();
  }
}
