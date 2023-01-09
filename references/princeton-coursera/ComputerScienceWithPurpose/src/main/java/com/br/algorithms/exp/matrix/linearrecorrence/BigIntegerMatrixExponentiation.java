package com.br.algorithms.exp.matrix.linearrecorrence;

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
public class BigIntegerMatrixExponentiation {

  private static void print(BigInteger[][] mat) {
    StringBuilder sb = new StringBuilder();
    for (BigInteger[] values : mat) {
      for (int j = 0; j < values.length; j++) {
        sb.append(String.format(j == 0 ? "%s" : " %s", values[j]));
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  private static BigInteger multiply(BigInteger a, BigInteger b, BigInteger m) {
    return (a.mod(m).multiply(b.mod(m))).mod(m);
  }

  private static BigInteger[][] copy(BigInteger[][] source) {
    BigInteger[][] cpy = new BigInteger[source.length][];
    for (int i = 0; i < source.length; i++) {
      cpy[i] = new BigInteger[source[i].length];
      System.arraycopy(source[i], 0, cpy[i], 0, source[i].length);
    }
    return cpy;
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

  private static BigInteger[][] recLinearRecorrence(
      BigInteger[][] base, BigInteger n, BigInteger m) {
    /*
       f(n) = a * f(n-1) + b * f(n-2) + c f(n-3) para n > 2
        a = b = c = 1. Sendo = 1 nao interfere
        // casos base
        f(0) = 0
        f(1) = 1
        f(2) = 1
        // demais casos
        f(3) = f(2) + f(1) + f(0) = 1 + 1 + 0 = 2
        f(4) = f(3) + f(2) + f(1) = 2 + 1 + 1 = 4
        f(5) = f(4) + f(3) + f(2) = 4 + 2 + 1 = 7
        f(6) = f(5) + f(4) + f(3) = 7 + 4 + 2 = 13
        f(7) = f(6) + f(5) + f(4) = 13 + 7 + 4 = 24
        f(8) = f(7) + f(6) + f(5) = 24 + 13 + 7 = 34
    */
    BigInteger[][] cpy = new BigInteger[][] {{ONE, ONE, ONE}, {ONE, ZERO, ZERO}, {ZERO, ONE, ZERO}};
    if (ONE.equals(n)) {
      return base;
    }
    // n / 2
    recLinearRecorrence(base, n.shiftRight(1), m);
    base = multiply(base, base, m);
    if (isOdd(n)) {
      base = multiply(base, cpy, m);
    }
    return base;
  }

  private static void checkRecLinearRecorrence() {
    BigInteger[][] base =
        new BigInteger[][] {
          {ONE, ONE, ONE},
          {ONE, ZERO, ZERO},
          {ZERO, ONE, ZERO}
        };
    List.of(3, 4, 5, 6, 7, 8, 9, 10)
        .forEach(
            i -> {
              BigInteger[][] res =
                  recLinearRecorrence(
                      base, BigInteger.valueOf(i - 2), BigInteger.valueOf(100000000));
              print(res);
              System.out.println("*************************************************");
            });
  }

  private static BigInteger recLinearRecorrenceV2(BigInteger[][] base, BigInteger n, BigInteger m) {
    BigInteger[][] cpy = new BigInteger[][] {{ONE, ONE, ONE}, {ONE, ZERO, ZERO}, {ZERO, ONE, ZERO}};
    if (ONE.equals(n)) {
      return base[0][0].add(base[0][1]);
    }
    // n / 2
    recLinearRecorrence(base, n.shiftRight(1), m);
    base = multiply(base, base, m);
    if (isOdd(n)) {
      base = multiply(base, cpy, m);
    }
    return base[0][0].add(base[0][1]);
  }

  private static void checkRecLinearRecorrenceV2() {
    BigInteger[][] base =
        new BigInteger[][] {
          {ONE, ONE, ONE},
          {ONE, ZERO, ZERO},
          {ZERO, ONE, ZERO}
        };

    List.of(100)
        .forEach(
            i -> {
              BigInteger res =
                  recLinearRecorrenceV2(
                      base, BigInteger.valueOf(i - 2), BigInteger.valueOf(100000000));
              System.out.printf("%d\n", res);
              System.out.println("*************************************************");
            });
  }

  private static boolean isOdd(BigInteger a) {
    return ONE.equals(a.and(ONE));
  }

  private static BigInteger[][] iterativeSolvingLinearRecorrence(BigInteger n, BigInteger m) {
    // veja explicacao da recorrencia no metodo
    BigInteger[][] base = new BigInteger[][] {{ONE}, {ONE}, {ZERO}};
    BigInteger[][] recorrence =
        new BigInteger[][] {{ONE, ONE, ONE}, {ONE, ZERO, ZERO}, {ZERO, ONE, ZERO}};
    BigInteger[][] cpy = copy(recorrence);
    if (ONE.equals(n)) {
      return base;
    } else {
      // se (ZERO < n) entao  compareTo < 0
      while (ZERO.compareTo(n) < 0) {
        if (isOdd(n)) {
          cpy = multiply(cpy, recorrence, m);
        }
        recorrence = multiply(recorrence, recorrence, m);
        n = n.shiftRight(1);
      }
    }
    return multiply(cpy, base, m);
  }

  private static void checkFibIt() {
    for (int i = 1; i <= 10; i++) {
      System.out.printf("%d)\n", i);
      print(iterativeSolvingLinearRecorrence(BigInteger.valueOf(i), BigInteger.valueOf(100000000)));
      System.out.println("*************************************************");
    }
  }

  public static void main(String[] args) {
    // checkFibA();
    // checkFibIt();
    // checkRecLinearRecorrenceV2();
    checkFibIt();
  }
}
