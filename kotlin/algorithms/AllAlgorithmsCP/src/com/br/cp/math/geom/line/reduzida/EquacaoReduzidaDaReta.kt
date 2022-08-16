package src.com.br.cp.math.geom.line.reduzida



/**
 * https://mundoeducacao.uol.com.br/matematica/equacao-reduzida-reta.htm
 *     y = mx + b
        m = coeficiente angular - slope
        b = coeficiente linear - O coeficiente lienar é o ponto em que a reta itnercepta o eixo Y
        x = variavel independente
        y = variavel dependente

 */


private data class Point(val x: Double, val y: Double) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())
}

private infix fun Point.coeficienteAngular(q: Point) = (y - q.y) / (x - q.x)


private fun equacaoReduzida(p: Point, q: Point): Pair<Double, Double>{
    /*
        y = mx + b
        mx - y = b
     */
    val m = p coeficienteAngular q
    val n = m * p.x - p.y
    return m to n
}


fun main() {
    println(equacaoReduzida(Point(-3, 2), Point(-15, -6)))
}