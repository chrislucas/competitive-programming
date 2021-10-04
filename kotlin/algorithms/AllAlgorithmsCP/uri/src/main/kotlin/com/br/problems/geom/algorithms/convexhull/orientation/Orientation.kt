package com.br.problems.geom.algorithms.convexhull.orientation

// https://www.geeksforgeeks.org/orientation-3-ordered-points/amp/%C2%A0/

data class Point(val x: Int, val y: Int)

enum class Orientation(val orientation: Int) {
    COUNTERCLOCKWISE(-1),
    CLOCKWISE(1),
    COLLINEAR(0)
}