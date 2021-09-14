package com.br.cp.site.algebra.java;

import java.util.HashMap;

import static java.lang.Math.sqrt;

public class DiscreteLog {


    public static long multiply(long a, long b, long m) {
        return ((a%m) * (b%m)) % m;
    }

    // https://www.dcode.fr/modular-exponentiation
    public static long exp(long b, long e, long m) {
        if (e == 0)
            return 1;
        else if (e == 1) {
            return b%m;
        }
        else {
            long acc = 1;
            while (e > 0) {
                if ((e & 1) == 1) {
                    acc = multiply(acc, b, m);
                }
                b = multiply(b, b, m);
                e >>= 1;
            }
            return acc;
        }
    }

    /**
     * https://cp-algorithms.com/algebra/discrete-log.html
     * a congruente b (mod m)
     *
     * Algorithm
     *
     * congruente -> =/
     *
     * Considere a equacao -> a^x =/ (b mod m)
     * Onde a e m sao coprimos
     *
     * Seja x = np - q
     * n -> Uma constante pre-selecionada
     * p -> Conhecido como "Giant Step". Quando seu valor aumento de 1 em 1, x aumente em n
     * q -> Conhecido como "Bany Step"
     *
     * Podemos reescrever a eq da seguinte forma
     *
     * a ^ (np-q) =/ b (mod m)
     *
     * ou, multiplicando por a^q
     *
     * a ^ (np) =/ b(a^q) (mod m)
     *
     * Podemos simplificar a nova equacao da seguinte forma
     *
     * f1(p) = f2(q)
     *
     * f1 e f2 funcao que recebe argumentos p e q que satisfacao a equacao
     *
     * Seguindo o artigo, para termos uma solucao com desempenho podemos utilizar a tecnica
     * meet-in-the-middle
     *  - Calcular f1 para todas os possiveis argumentos p, armazenar numa estrutura ordenada 'E'
     *  o par de valores p e f(p)
     *
     *  - Calcular f2 para todos os possiveis argumentos q, usar o resultado 'r para procurar em 'E' se existe
     *  um p = r
     *
     * */
    static long discreteLog(long a, long b, long m) {
        a %= m;
        b %= m;
        HashMap<Long, Long> table = new HashMap<>();
        long n = (long) (sqrt(m) + 1L);
        // f1(p)
        for (long p = 0; p <= n; p++) {
            table.put(exp(a, p * n, m), p);
        }
        // f2(q)
        for (int q = 0; q <= n ; q++) {
            // (b(a^q%m))%m
            long r = multiply(exp(a, q, m), b, m);
            if (table.containsKey(r)) {
                long s = table.get(r);
                return s * n - q;
            }
        }
        return -1;
    }

    public static long discreteLog2() {
        return -1;
    }

    public static void testExp() {
        System.out.println(exp(0, 0, 32));
        System.out.println(exp(123, 456, 32));
        System.out.println(exp(123, 12, 124));
        System.out.println(exp(12443, 12, 124));
        System.out.println(exp(12, 98765, 124));
    }
    public static void main(String[] args) {
        testExp();
    }
}
