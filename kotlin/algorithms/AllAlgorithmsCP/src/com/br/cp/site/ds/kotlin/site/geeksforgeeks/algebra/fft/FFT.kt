package src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.algebra.fft

/*
    https://www.tabnews.com.br/LeonardoSaads/como-a-tranformada-rapida-de-fourier-fft-mudou-o-mundo
    https://www.nti-audio.com/pt/suporte/saber-como/transformacao-rapida-de-fourier-fft

    ------------------------
    https://www.geeksforgeeks.org/fast-fourier-transformation-poynomial-multiplication/

    Dado 2 polinomios A(x) e B(x) encontrar o produto
    C(x) = A(x) * B(x)

    Existe uma estrategia em n^2 "ingenua"
    https://www.geeksforgeeks.org/multiply-two-polynomials-2/

    Ela usa os coeficientes do polinomio para calcular o produto.


    Representacao dos coeficientes dum polinomio A(x)

    A(x) = Somatorio(j=0, n-1) aj * x^j
    Ex:
    A(x) = 6x^3 + 7xˆ2 - 10x + 9 = {9, -10, 7, 6} -- i-esima posicao no array esta para o monomio x^i
    B(x) = -2X^3 + 4x -5 = {-5, 4, 0, -2)

    C(x) =-12xˆ6 - 14x^5 + 44x^4 - 20xˆ3- 75x^2 + 86x - 45

    Para acelerar o processo de calculo propoe-se modificar a representacao do polinomio na forma
    de pontos P(x0, y0 ... Xn-1, Yn-1)

    onde:
    i de 0 a n-1
    Xi sao distindos
    Yi = A(Xi)

    Exemplo
    A(x) = x^3 -2x + 1
    xi = X0 = 0, X1 = 1, X2 = 2, X3 = 3
    quando
    yi = Y0 = A(0) = 1; Y1 = A(1) = 0, Y2 = A(2) = 5, y3 = A(3) = 22

    { (0,1), (1,0), (2, 5), (3, 32)}

    C(x) tem grau no limite de 2n
        - n pontos so darao n permiterao criar n pontos para C(x), ou um polinomio
        no maximo de n termos
        - Precisamos de 2n dieferentes valores para x e y
        - Precisamos converter os pontos em um vetor de coeficientes novamente
        - Para fazer isso usamos uma técnica chamada interpolacao
            - Essa interpolacao usa a formula de lagrance
            - Dado um vetor de pontos convertemos num vetor de termos de um polinomio

    ------------------------
    SIMD
    https://pt.wikipedia.org/wiki/SIMD
 */


fun main() {

    println(0xff)

}