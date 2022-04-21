package src.com.br.sites.usaco.book.chp13.divisors;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Calculadora online
 * https://www.dcode.fr/divisors-list-number
 */
public class OptimizedCountDivII {
    /**
     * https://codeforces.com/blog/entry/22317
     * <p>
     * A abordagem simples para o problema de contar os divisores de um numero N
     * leva O (sqnt(N)) para chegar a resposta
     * <p>
     * https://mathschallenge.net/library/number/number_of_divisors
     * Exemplo: 48 = 1x48; 2x24; 3x16; 4x12; 6x8
     * <p>
     * Veja que só precisamos ir até o número 6 que eh o inteiro mais proximo de sqrt(48)
     * <p>
     * Entretando essa abordagem eh lenta para números grandes, mas existe um algoritmo
     * que resolve esse problema em O (raiz cubica de N)
     * <p>
     * <p>
     * Seja d(n) uma funcao que retorne a quantidade de divisores de n
     * - N pode ser escrito atraves de seus fatores primos = p^a * qˆb  * rˆc ...
     * - Entao d(n) = (a+1)*(b+1)*(c+1) ...
     * <p>
     * - Como provar ?
     * - Seja n = p^a
     * - os divisores sao 1, p, p^2, p^3 ... p^a
     * - assim d(p^a) = a+1
     * - Seja n = p^a*q^b
     * - os divisores combinados sao
     * 1, p, p^2 ... p^a
     * q, pq, p^2*q ... p^a*q
     * ...
     * q^b, pq^b, p^2*q^b ... p^a*q^b
     * - assim d(p^a*q^b) = (a+1)(b+1)
     * <p>
     * - Exemplo
     * - n = 48 = p^a * q^b ...
     * - 48 = 2 ^ 4 * 3 ^ 1
     * - d(48) = (4+1) * (1+1) = 10
     */

    /*
     *                  n     Primes <= n
     *  ---------------------------------
     *                 10               4
     *                100              25
     *              1,000             168
     *             10,000           1,229
     *            100,000           9,592
     *          1,000,000          78,498
     *         10,000,000         664,579
     *        100,000,000       5,761,455
     *      1,000,000,000      50,847,534
     */

    static class OpCountI {
        private final HashMap<Integer, Boolean> isPrime;
        private final HashMap<Integer, Boolean> isSquareOfPrime;
        final ArrayList<Long> primes;
        private final long value;

        public OpCountI(long value) {
            this.value = value;
            primes = new ArrayList<>();
            isPrime = new HashMap<>();
            isSquareOfPrime = new HashMap<>();
            init(value);
        }

        private void init(long value) {
            isPrime.put(1, false);
            isSquareOfPrime.put(1, false);
            for (int i = 2; i <= value; i++) {
                isPrime.put(i, true);
            }

            for (int i = 2; (long) i * i <= value; i++) {
                if (isPrime.get(i)) {
                    for (int j = i; (long) i * j <= value; j++) {
                        isPrime.replace(i * j, false);
                    }
                }
            }

            for (int i = 2; i < isPrime.size(); i++) {
                if (isPrime.get(i)) {
                    isSquareOfPrime.put(i * i, true);
                    primes.add((long) i);
                }
            }
        }

        long countDivisors() {
            long acc = 1;
            long cValue = value;
            for (long p : primes) {
                if (p * p * p > cValue)
                    break;
                long aux = 1;
                while (cValue % p == 0) {
                    cValue /= p;
                    aux += 1;
                }
                acc *= aux;
            }

            if (isPrime.get((int) cValue)) {
                acc *= 2;
            } else if (isSquareOfPrime.get((int) cValue)) {
                acc *= 3;
            } else if (cValue != 1) {
                acc *= 4;
            }
            return acc;
        }
    }

    // https://codeforces.com/blog/entry/22317
    static class OpCountII {

        private final ArrayList<Integer> primes;
        private final HashMap<Integer, Boolean> isSquareOfPrime;
        private final HashMap<Integer, Boolean> isPrimes;

        public OpCountII(long value, ArrayList<Integer> primes) {
            this.primes = primes;
            isSquareOfPrime = new HashMap<>();
            isPrimes = new HashMap<>();
            for (int i = 2; i <= value * value; i++) {
                boolean isPrime = isPrimeMillerRabin(i);
                if (isPrime) {
                    isSquareOfPrime.put(i, isPrimeMillerRabin(2));
                }
                isPrimes.put(i, isPrime);
            }
        }

        private boolean isPrimeMillerRabin(long value) {
            return false;
        }


        long count(long value) {
            long acc = 1;
            long cValue = value;
            for (long p : primes) {
                if (p * p * p > cValue)
                    break;
                long aux = 1;
                while (cValue % p == 0) {
                    cValue /= p;
                    aux += 1;
                }
                acc *= aux;
            }
            return acc;
        }
    }

    private static void checkSpecificValue(long value) {
        OpCountI op = new OpCountI(value);
        System.out.println(op.countDivisors());
        op = null;
    }

    private static void benchmark() {
        int[] values = new int[]{
                1000000000, // causa problema de heap
                100000000,
        };
        long s = System.currentTimeMillis();
        checkSpecificValue(values[1]);
        long e = System.currentTimeMillis();
        System.out.println((e - s) / 1000);
    }

    public static void main(String[] args) {
        benchmark();
    }
}
