package com.br.algo.cp.book2.chp5.java.primes.factorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
       https://mathworld.wolfram.com/PrimeCountingFunction.html
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

public class SieveErathostenesPrimeFactorization {

  private static class ErathostenesSieve {
    private final ArrayList<Integer> primes;
    private final boolean[] isPrime;

    ErathostenesSieve(int n) {
      isPrime = new boolean[n + 1];
      Arrays.fill(isPrime, true);
      isPrime[0] = false;
      isPrime[1] = false;
      primes = new ArrayList<>();
      for (int factor = 2; factor * factor <= n; factor++) {
        if (isPrime[factor]) {
          for (int i = factor; i * factor <= n; i++) {
            isPrime[i * factor] = false;
          }
        }
      }
      for (int i = 2; i <= n; i++) {
        if (isPrime[i]) {
          primes.add(i);
        }
      }
    }

    boolean isPrime(int n) {
      if (n > isPrime.length || n < 0) {
        return false;
      } else {
        return isPrime[n];
      }
    }

    int getSize() {
      return primes.size();
    }

    List<Integer> getPrimes() {
      return primes;
    }

    List<Integer> getPrimeFactor(Integer n) {
      List<Integer> factors = new ArrayList<>();
      int i = 0;
      while (i < primes.size()) {
        int prime = primes.get(i);
        if (prime * prime > n) break;
        while (n % prime == 0) {
          n /= prime;
          factors.add(prime);
        }
        i += 1;
      }
      if (n != 1) {
        factors.add(n);
      }
      return factors;
    }
  }

  private static void init(int size, int value) {
    ErathostenesSieve sieve = new ErathostenesSieve(size);
    System.out.printf("%d%n", value);
    for (int a : sieve.getPrimeFactor(value)) {
      System.out.println(a);
    }
    System.out.println("******************************** Fim ********************************");
  }

  public static void main(String[] args) {
    init(100_000_000, (1 << 31) - 1);
    init(10_000_000, 12246);
    init(10_000_000, 22);
    init(10_000_000, 128);
    init(10000000, (1 << 30) - 1);
    init(100_000_000, (1 << 31) - 2);
  }
}
