package com.br.algo.math.lib.circle

/**
 * https://educacao.uol.com.br/disciplinas/matematica/equacao-da-circunferencia-geral-e-reduzida-determinacao-de-centro-e-raio.htm
 * Equacao reduzida da circunferencia
 *
 *
 * (x - cx) ^ 2 + (y - cy) ^2 = R^2
 * cx e cy são as coordenadas do centro da circunferencia
 *
 * A equacao da circunferencia cujo raio eh 8 e o ponto no centro é (5, -7)
 *
 * (x - 5) ^ 2 + (y + 7) ^ 2 = 64
 *
 * Equacao geral
 *
 * A partir da equacao reduzida obtemos a geral desenvolvendo-a/expandindo-a
 * (x2 - 2xcx + cx2) + (y2 - 2ycy + cy2) = r2
 * cx2 + cy2 - 2xcx - 2ycy + x2 + y2 - r2 = 0
 *
 * m = -2xcx
 * n = -2ycy
 * o = x2 + y2 - r2
 *
 * cx2 + cy2 + m + n + o = 0
 *
 * Com essa equacao expandida, um circulo cujo centro é (5, -7) e raio 8
 *
 * 1) x2 + y2  - 10x + 14y + 25 + 49 - 64 = 0 -> x2 + y2  - 10x + 14y + 74 - 64 = 0
 * 2) x2 + y2  - 10x + 14y + 10 = 0
 *
 *
 * Equacao Reduzida
 * https://brasilescola.uol.com.br/matematica/equacao-reduzida-circunferencia.htm
 * https://www.varsitytutors.com/hotmath/hotmath_help/topics/equation-of-a-circle#
 *
 */
