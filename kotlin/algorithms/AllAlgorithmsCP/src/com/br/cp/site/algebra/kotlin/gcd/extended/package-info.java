package src.com.br.cp.site.algebra.kotlin.gcd.extended;

/**
 *     // calculadora https://www.dcode.fr/extended-gcd
 * ax + by = gcd(a, b)
 * <p>
 * o algoritmo extendido de euclide encontra os coeficiences x e y
 * da equacao acima
 * <p>
 * Exemplo: https://www.classicistranieri.com/pt/articles/a/l/g/Algoritmo_de_Euclides_estendido_d345.html
 * GCD(120, 23)
 * <p>
 * 1) 120 % 23 = R=5 Q=5
 * 2) 23 % 5 = R=3 Q=4
 * 3) 5 % 3 = R=2 Q=1
 * 4) 3 % 2 = R=1 Q=1
 * 5) 2 % 1 = R=0 Q=2
 * <p>
 * Usando os restos da equacao
 * <p>
 * N) R = D - d * q
 * 1) 5 = 120 - 23 * 5
 * 2) 3 = 23 - 5 * 4 => substituindo o 5 por (120 - 23 * 5)
 * 3 = 23 - 4 * (120 - 23 * 5)
 * 3 = 23 - (4*120 - 4*5*23)
 * 3 = 23 - (4*120 - 20*23)
 * 3 =  -4*120 + 21*23
 * <p>
 * 3) 2 = 5 - 3 * 1 => substituindo 5 e 3 por (120 - 23 * 5) e  -4*120 + 21*23 respectivamente
 * 2 = (120 - 23 * 5) - (-4*120 + 21*23)
 * 2 = (120 - 23 * 5) + (4*120 - 21*23)
 * 2 = (120 - 23 * 5) + (4*120 - 21*23)
 * 2 = 5 * 120 - 26 * 23
 * <p>
 * <p>
 * 4) 1 = 3 - 2 * 1 => substituindo 3 e 2  (-4*120 + 21*23) e (5 * 120 - 26 * 23
 * 1 = (-4*120 + 21*23) - (5 * 120 - 26 * 23)
 * 1 = -4*120 -5*120 + 21*23 + 26*23
 * 1 = -9*120 + 47*23
 * <p>
 * ax + by = gcd(a, b)
 * x = -9 e y = 47
 * <p>
 * a*u + b*v = gcd(a, b)
 * gdc(a, b) = ultimo divisor
 * <p>
 * a = 81, b = 57
 * 81 / 57 = 1 sobra 24
 * 57 / 24 = 2 sobra 9
 * 24 / 9 = 2 sobra 6
 * 9 / 6 = 1 sobra 3
 * 6 / 3 = 2 sobra 0
 * gcd(81, 57) = 3
 * <p>
 * Fazendo o caminho inverso para descobrir os valores de u e v na equacao
 * r = dividendo - divisor * quociente
 * 1) 3 = 9 - 6 * 1
 * 2) 6 = 24 - 9 * 2
 * 3) 9 = 57 - 24 * 2
 * 4) 24 = 81 - 57 * 1
 * <p>
 * 2) 3 = 9 - (24 - 9 * 2)
 * = 3*9 - 24
 * <p>
 * 3) 3 = 3 * (57 - 24 * 2) - 24
 * = 3 * 57 - 6 * 24 - 24
 * = 3 * 57 - 7 * 24
 * <p>
 * 4) 3 = 3 * 57 - 7 * (81 - 57)
 * = 3 * 57 - 7 * 81 + 7 * 57
 * = 10 * 57 - 7 * 81
 * u = 10, v = -7
 * 10 * 57 - 7 * 81 = gcd(81, 57)
 */


/**
 * a*u + b*v = gcd(a, b)
 * gdc(a, b) = ultimo divisor
 *
 * a = 81, b = 57
 * 81 / 57 = 1 sobra 24
 * 57 / 24 = 2 sobra 9
 *  24 / 9 = 2 sobra 6
 *  9 / 6 = 1 sobra 3
 *  6 / 3 = 2 sobra 0
 * gcd(81, 57) = 3
 *
 * Fazendo o caminho inverso para descobrir os valores de u e v na equacao
 * r = dividendo - divisor * quociente
 * 1) 3 = 9 - 6 * 1
 * 2) 6 = 24 - 9 * 2
 * 3) 9 = 57 - 24 * 2
 * 4) 24 = 81 - 57 * 1
 *
 * 2) 3 = 9 - (24 - 9 * 2)
 *      = 3*9 - 24
 *
 * 3) 3 = 3 * (57 - 24 * 2) - 24
 *      = 3 * 57 - 6 * 24 - 24
 *      = 3 * 57 - 7 * 24
 *
 * 4) 3 = 3 * 57 - 7 * (81 - 57)
 *      = 3 * 57 - 7 * 81 + 7 * 57
 *      = 10 * 57 - 7 * 81
 *  u = 10, v = -7
 *  10 * 57 - 7 * 81 = gcd(81, 57)
 */