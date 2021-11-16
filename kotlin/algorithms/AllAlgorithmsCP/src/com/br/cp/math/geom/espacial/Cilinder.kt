package src.com.br.cp.math.geom.espacial

import kotlin.math.PI

/*
    https://byjus.com/maths/cylinder/
 */

object Cilinder {


    fun lateralSurfaceArea(r: Double, h: Double) = 2 * PI * r * h

    // area das duas bases circulares + area lateral
    fun totalSurfaceArea(r: Double, h: Double) = 2 * PI * r * (r + h)

    fun volume(r: Double, h: Double) = PI * r * r * h

}


private fun checkLateralSurfaceArea(r: Double, h: Double) {
    println(Cilinder.lateralSurfaceArea(r, h))
}

private fun checkTotalSurfaceArea(r: Double, h: Double) {
    println(Cilinder.totalSurfaceArea(r, h))
}

private fun checkVolume(r: Double, h: Double) {
    println(Cilinder.volume(r, h))
}


fun main() {
    checkLateralSurfaceArea(5.0, 10.0)
    checkTotalSurfaceArea(5.0, 10.0)
    checkVolume(5.0, 10.0)
    checkVolume(5.0, 7.0)
}