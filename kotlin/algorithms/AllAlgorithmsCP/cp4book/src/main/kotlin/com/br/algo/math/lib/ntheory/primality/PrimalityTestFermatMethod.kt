package com.br.algo.math.lib.ntheory.primality

/**
 * https://www.geeksforgeeks.org/primality-test-set-2-fermet-method/
 *
 * Pequeno teorema de fermat
 * https://www.geeksforgeeks.org/fermats-little-theorem/
 * https://en.wikipedia.org/wiki/Fermat's_little_theorem
 *
 * Se p é primo entao para qualquer inteiro A o numero A ^ p - A é um inteiro multiplo de p
 * Em notacao de aritmetica modular a expressao fica
 * A ^ p congruente A (mod p) - A ^ p % p  == A % p
 *
 * A = 2
 * p = 7
 * 2 ^ 7 = 128
 *
 * 128 - 2 = 126 e 7 x 18 = 126 - existe um numero que quando multiplica 7 da 126
 *
 * congruencia
 * 128 % 7 == 2 % 7 ( = 2) ambos dao resto == 2
 *
 * Se A nao for divisivel por p, o 'pequeno teorema de fermat' é equivalente a A^(p-1) - 1
 * A ^ (p - 1) congruente 1 (mod p)
 *
 * A = 2
 * p = 7
 *
 * 2 ^ (7 - 1) - 1 = 63
 * 63 = 7 * 9
 *
 * 64 % 7 == 1 % 7 ( = 1) ambos dao resto - 1
 *
 *
 */


fun main() {

}