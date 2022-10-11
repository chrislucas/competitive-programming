package com.br.algo.cp.book2.chp5.java.primes.factorization;

/*
   Algoritmos para estudo para fatorar um numero em numeros primos


   There is no one single right answer to this question. Different algorithms get used based on how large the number is.
   It goes something like this:
   Small Numbers : Use simple sieve algorithms to create list of primes and do plain factorization.
   Works blazingly fast for small numbers.
   Big Numbers : Use Pollard's rho algorithm, Shanks' square forms factorization
   (Thanks to Dana Jacobsen for the pointer)

   Less Than  1025  : Use Lenstra elliptic curve factorization
   Less Than  10100  : Use Quadratic sieve
   More Than  10100  : Use General number field sieve
*/
