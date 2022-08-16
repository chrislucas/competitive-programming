package src.com.br.cp.math.geom.line;

/*
   Interpolacao
   https://ic.ufal.br/professor/thales/icg/Aula1.2.pdf
   https://edisciplinas.usp.br/pluginfile.php/4689221/mod_resource/content/1/Revisao%202%202019.pdf

   Interpolacao linear
   https://www.youtube.com/watch?v=_QQU9OIPGYE
   https://www.ufsj.edu.br/portal2-repositorio/File/nepomuceno/mn/12MN_Interpola.pdf

   https://www.portalsaofrancisco.com.br/matematica/interpolacao
   https://pt.wikihow.com/Interpolar
   https://www.codesansar.com/numerical-methods/linear-interpolation-method-algorithm.htm
   https://en.wikipedia.org/wiki/Linear_interpolation
   https://docs.unity3d.com/ScriptReference/Vector3.Lerp.html

   algoritmos
   https://www.ufsj.edu.br/portal2-repositorio/File/nepomuceno/mn/12MN_Interpola.pdf
   https://pt.khanacademy.org/partner-content/pixar-latam/animation-latam/mathematics-of-animation-curves-latam/v/anim6#
   https://www.dca.ufrn.br/~meneghet/FTP/MCEC/Transp05.pdf
   https://www.ime.unicamp.br/~roman/courses/MS211/1s2020/interpolacao1.pdf
   https://www.ime.unicamp.br/~roman/courses/MS211/1s2020/interpolacao1.pdf

   https://brasilescola.uol.com.br/matematica/interpolacao-meios-geometricos.htm
   https://www.novaconcursos.com.br/arquivos-digitais/erratas/14729/19072/regressao-interpolacao-extrapolacao-numericas.pdf


   Bezier Curve
   https://www.khanacademy.org/computing/pixar/animate/parametric-curves/a/lesson-brief-animation


   Linear interpolator help
   https://www.johndcook.com/interpolatorhelp.html

   codeforces
   https://codeforces.com/blog/entry/82953

   INTERPOLATION SEARCH
   https://www.geeksforgeeks.org/interpolation-search/
   https://www.topcoder.com/thrive/articles/interpolation-search

   Linear Interpolation Formula
   https://www.geeksforgeeks.org/linear-interpolation-formula/

   Interpolation Search Algorithm
   https://iq.opengenus.org/interpolation-search-algorithm/

   Troubleshooting interpolator
   https://www.johndcook.com/interpolatorhelp.html

   interpolation competitive programming
   https://cp-algorithms.com/algebra/polynomial.html

   Polynomial interpolation #9
   https://github.com/kth-competitive-programming/kactl/issues/9

   lagrange-interpolation
   https://www.codechef.com/tags/problems/lagrange-interpolation

   Lagrange interpolation
   http://kmyk.github.io/competitive-programming-library/number/lagrange_interpolation.hpp

   slope line intercept
   https://www.khanacademy.org/math/algebra/x2f8bb11595b61c86:forms-of-linear-equations/x2f8bb11595b61c86:intro-to-slope-intercept-form/a/introduction-to-slope-intercept-form

   y = mx + n
   m = coeficiente angular
   n = coeficiente linear - valor de y onde a reta da equacao passa
       quando x = 0 o ponto (0, n) é o ponto em Y em que a reta da equacao intercepta

   Por que 'n' n é o y do ponto em que a reta da equacao intercepta ?

   O valor de x do ponto que a reta intercepta é sempre zero entao se queremos encontrar o y
   desse ponto interceptado pela reta representada na equacao y = mx + n subsituimos x por 0 e temos
   y = m0 + n que eh o mesmo que y = n

   por isso dizemos que o coeficiente linear é o valor de y do ponto interceptado pela reta y = mx + n

   Por que 'm' nos da o coeficiente angular ?

   coeficiente angular = variacao de y (yb - ya) / variacao de x (xb - xa)

   o coeficiente angular é a variacao dos valores de y (yb - ya)
   pela variacao de x (xb - xa) dos pontos A(x,y) e B(x, y)

   Se na equacao m = (yb - ya) /  (xb - xa)
   a diferenca entre os x for = 1 o coeficiente angular = (yb - ya)
   ou seja se o ponto B desloca-se uma unidade para a direita em relacao
   ao ponto A o coeficiente angular entre A e B é a diferenca entre (yb - ya)

   Seja a equacao da reta
   y = 2x + 1
   variando x de 1 em 1 unidade
   y = 2 * 0 + 1 = 1
   y = 2 * 1 + 1 = 3
   y = 2 * 2 + 1 = 5
   y = 2 * 3 + 1 = 7
   y = 2 * 4 + 1 = 9
   y = 2 * -1 + 1 = -1
   y = 2 * -2 + 1 = -3
   y = 2 * -3 + 1 = -5
   X crescendo em 1 unidade Y cresce em 2 unidades

   Conforme x varia em 1 unidade y varia em 2 e por isso
   o coeficiente angular eh 2

   Dados os pontos A(1, 1) e B (0, -3) encontre
   a equacao reduzida da reta
   -3 - 1 / 0 - 1 =
   -4 / -1 = 4
   m = 4
   n = -3
   y = mx + n
   y = 4x - 3

   O ponto B nos diz qual é o coeficiente linear
   visto que possui x = 0
   enquanto x varia em 1 unidade, y varia em 4
   portanto o coeficiente angular = 4
*/
