package src.com.br.cp.book.handbookgeoalgorithm.chp.precision

/*
    1.1 Small imprecisions can become big imprecisions


    O problema de interseccao de linhas eh um exemplo onde pequenos problemas de imprecisao acumulados
    podem causar um resultado desastroso.

    Exemplo:

    Seja A,B,C e D pontos num plano e que foram obtidos atraves de um processo impreciso onde a posicao
    de cada um deles pode variar numa distancia de valor R = 10 ^ -6 e precisamos calcular
    a interssecao do segmento AB e CD
 */


private data class Point2DFloat(val x: Double, val y: Double, val offset: Double = 10E-6) {
    val offsetXLeft: Double get() = x - offset
    val offsetXRight: Double get() = x + offset

    val offsetYLeft: Double get() = y - offset
    val offsetYRight: Double get() = y + offset

    val possibleDots = arrayOf(
        Point2DFloat(x, offsetYLeft),
        Point2DFloat(x, offsetYRight),
        Point2DFloat(offsetXLeft, y),
        Point2DFloat(offsetXRight, y),
        Point2DFloat(offsetXLeft, offsetYLeft),
        Point2DFloat(offsetXLeft, offsetYRight),
        Point2DFloat(offsetXRight, offsetYLeft),
        Point2DFloat(offsetXRight, offsetYRight),
    )
}