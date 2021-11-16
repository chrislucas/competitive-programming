package src.com.br.cp.math.geom.plana

import kotlin.math.PI

val Double.fromDegreeToRadian: Double
    get() =  this * PI / 180.0

val Double.fromRadianRoDegree: Double
    get() = this * 180.0 / PI