package com.br.algorithms.exp.matrix;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
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
 * <p>
 *
 * <p>Com esses as matriz tendo esses valores a equacao F_Mat_1 = F_Mat_2 * F_Mat_3 eh verdadeira
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
 */
public class MatrixExpBigInteger {

  static final List<BigInteger[][]> matrixes =
      List.of(
          new BigInteger[][] {{ZERO, ZERO}, {ZERO, ONE}},
          new BigInteger[][] {{ZERO, ZERO}, {ONE, ZERO}},
          new BigInteger[][] {{ZERO, ONE}, {ZERO, ZERO}},
          new BigInteger[][] {{ONE, ZERO}, {ZERO, ZERO}},
          new BigInteger[][] {{ONE, ZERO, ZERO}, {ZERO, ZERO, ZERO}, {ZERO, ZERO, ZERO}});

  private static BigInteger[][] fibexp(int n) {
    BigInteger[][] res = new BigInteger[][] {{ZERO}, {ZERO}, {ZERO}};

    return res;
  }

  private static BigInteger multipler(BigInteger a, BigInteger b, BigInteger m) {
    return (a.mod(m).multiply(b.mod(m))).mod(m);
  }

  private static BigInteger[][] exp(BigInteger[][] matriz, BigInteger n, BigInteger m) {
    return null;
  }

  public static void main(String[] args) {}
}
