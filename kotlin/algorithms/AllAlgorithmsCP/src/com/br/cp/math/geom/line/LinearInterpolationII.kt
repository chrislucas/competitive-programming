package src.com.br.cp.math.geom.line

/*
    https://matthew-brett.github.io/teaching/linear_interpolation.html
    y =  ya (x - xa) * (yb - ya) / (xb - xa)
    xa <= x <= xb
 */


private data class Point(val x: Double, val y: Double) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())
}

/*
    Point Slope formula
    y - y1 = m(x - x1)
    m = (1 - y1) / (x - x1)
 */

private infix fun Point.slope(q: Point) = (y - q.y) / (x - q.x)


/*
    The slope intercept formula
    Equacao reduzida da reta
    https://mundoeducacao.uol.com.br/matematica/equacao-reduzida-reta.htm
    y = mx + b
    m = coeficiente angular - slope
    b = coeficiente linear
    x = variavel independente
    y = variavel dependente

    -mx + y = b ou
    mx - y = -b
    x - y/m = -b/m
    x = -b/m + y/m
    ou
    mx - y = -b
    x = (-b + y) / m
 */
private fun intercept(m: Double, n: Double, ya: Double, yb: Double) {
    fun lineaEquation(p: Point, q: Point) {
        val ma = p slope q
        val na = p.x * (-ma) + p.y //p.x * ma - p.y
        println("Pontos($p e $q) Coeficiente Angular $ma, Coenficiente Linear $na")
    }

    val xa = -n / m + ya / m
    val xb = -n / m + yb / m
    val p = Point(xa, ya)
    val q = Point(xb, yb)
    println("Pontos($p e $q)  Coeficiente Angular: $m, Coeficiente Linear: $n")
    lineaEquation(p, q)
}


private fun findYIntercept(m: Double, n: Double, xa: Double, xb: Double) {

    fun lineaEquation(p: Point, q: Point) {
        val ma = p slope q
        val na = p.x * (-ma) + p.y //p.x * ma - p.y
        println("Pontos($p e $q) Coeficiente Angular $ma, Coenficiente Linear $na")
    }
    /*
         y = mx + b
     */
    val ya = m * xa + n
    val yb = m * xb + n
    val p = Point(xa, ya)
    val q = Point(xb, yb)
    println("Pontos($p e $q)  Coeficiente Angular: $m, Coeficiente Linear: $n")
    lineaEquation(p, q)
    println("******************************************************************************************")
}

private fun checkFindYIntercept() {
    // https://www.khanacademy.org/math/cc-eighth-grade-math/cc-8th-linear-equations-functions/8th-slope-intercept-form/v/graphing-a-line-in-slope-intercept-form
    findYIntercept(1.0 / 3.0, -2.0, 0.0, -1.0)
    findYIntercept(1.0 / 3.0, -2.0, 1.0, -1.0)
    findYIntercept(1.0 / 3.0, -2.0, 2.0, -1.0)
    findYIntercept(1.0 / 3.0, -2.0, 3.0, -1.0)
    findYIntercept(1.0 / 3.0, -2.0, 6.0, -1.0)
}


private fun checkIntercept() {
    intercept(2.0 / 3.0, 4.0, 2.0, -6.0)
    /*
        https://www.khanacademy.org/math/cc-eighth-grade-math/cc-8th-linear-equations-functions/8th-slope-intercept-form/v/graphing-a-line-in-slope-intercept-form
     */
    intercept(1.0 / 3.0, -2.0, 1.0, -1.0)
}

private fun interpolation(a: Point, b: Point) {
    println("A $a, B $b")
    val t = 0.1
    var x = a.x + t
    while (x <= b.x) {
        val y = (a.y + (x - a.x) * ((b.y - a.y) / (b.x - a.x)))
        val c = Point(x, y)
        println("A: $a, B: $b, C: $c, Slope AC: ${a slope c}, Slope BC ${b slope c}")
        x += t
    }
}

private fun checkInterpolation() {
    val p = Point(2, -1)
    val q = Point(11, 2)
    interpolation(p, q)
}

private fun checkSlope() {
    /*
        https://www.alamo.edu/contentassets/ab5b70d70f264cec9097745e8f30ca0a/graphing/math0303-equations-of-a-line.pdf
     */
    val p = Point(2, -1)
    val q = Point(11, 2)
    println(p.slope(q))
}


fun main() {
    //checkSlope()
    //checkInterpolation()
    //checkIntercept()
    checkFindYIntercept()
}