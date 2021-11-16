package src.com.br.cp.math.geom.plana


private fun checkArea(baseMaior: Double, baseMenor: Double, h: Double) {
    val a = Trapezio.areaAcimaBaseMedia(baseMaior, baseMenor, h)
    val b = Trapezio.areaAbaixoBaseMedia(baseMaior, baseMenor, h)
    val areaTotal = Trapezio.area(baseMaior, baseMenor, h)

    println(a + b == areaTotal)
}


fun main() {

}