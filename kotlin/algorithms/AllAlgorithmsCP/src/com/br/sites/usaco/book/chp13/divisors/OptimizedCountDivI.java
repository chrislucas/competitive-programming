package src.com.br.sites.usaco.book.chp13.divisors;

import java.util.ArrayList;
import java.util.List;

public class OptimizedCountDivI {

    /**
     * https://www.geeksforgeeks.org/count-divisors-n-on13/
     * Calculadora online
     * https://www.dcode.fr/divisors-list-number
     */

    private static List<Integer> sieveOfEratosthenes(int n, boolean[] isPrime, boolean[] isSquareOfPrime) {
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p; i * p <= n; i++) {
                    isPrime[i * p] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                isSquareOfPrime[i * i] = true;
            }
        }

        return primes;
    }

    private static int counterDivisors(int number) {
        if (number == 1)
            return 1;
        int acc = 1;

        boolean[] isPrimes = new boolean[number + 1];
        boolean[] isSquareOfPrime = new boolean[number * number + 1];

        List<Integer> primes = sieveOfEratosthenes(number, isPrimes, isSquareOfPrime);
        for (int a : primes) {
            if (a * a * a > number)
                break;
            int counter = 1;
            while (number % a == 0) {
                number /= a;
                counter += 1;
            }
            acc *= counter;
        }

        if (isPrimes[number])
            acc *= 2;

        else if (isSquareOfPrime[number])
            acc *= 3;

        else if (number != 1)
            acc *= 4;

        return acc;
    }

    private static void checkNumberOfDivisors() {
        for (int i = 100000; i <= 100000 ; i++) {
            System.out.printf("%d, %d\n", i, counterDivisors(i));
        }
    }


    public static void main(String[] args) {
        checkNumberOfDivisors();
    }
}
