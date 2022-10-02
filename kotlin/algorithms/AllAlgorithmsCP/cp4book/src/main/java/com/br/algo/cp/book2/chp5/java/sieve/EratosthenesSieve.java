package com.br.algo.cp.book2.chp5.java.sieve;

/*
   https://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EratosthenesSieve {

  static class Sieve {
    private final ArrayList<Integer> primes;
    private final boolean[] isPrime;

    Sieve(ArrayList<Integer> primes, boolean[] isPrime) {
      this.primes = primes;
      this.isPrime = isPrime;
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
  }

  private static Sieve getSieve(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;
    ArrayList<Integer> primes = new ArrayList<>();
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

    return new Sieve(primes, isPrime);
  }

  public static void main(String[] args) {

    for (int i = 1; i <= 100000; i++) {
      Sieve sieve = getSieve(i);
      System.out.println(sieve.getSize());
    }
  }
}
