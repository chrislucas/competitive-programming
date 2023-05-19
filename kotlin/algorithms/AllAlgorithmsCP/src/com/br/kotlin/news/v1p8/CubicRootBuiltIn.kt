package src.com.br.kotlin.news.v1p8

import java.lang.Math.cbrt


/*
    https://kotlinlang.org/docs/whatsnew18.html?utm_source=ide&utm_medium=release-notification&utm_campaign=1-8-0-release#cbrt
 */

private fun checkCubicRootBuiltiIn() {
    println(cbrt(27.0))
    println(cbrt(64.0))
    println(cbrt(1728.0))
    println(cbrt(81.0))
}
fun main() {
    checkCubicRootBuiltiIn()
}