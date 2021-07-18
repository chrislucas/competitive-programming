package com.br.problems.geom.algorithms.convexhull.gs.geeksforgeeks

/**
 * https://codegolf.stackexchange.com/questions/183191/area-of-a-2d-convex-hull
 * https://www.geeksforgeeks.org/convex-hull-set-2-graham-scan/
 * https://www.geeksforgeeks.org/convex-hull-using-divide-and-conquer-algorithm/
 *
 * https://en.wikipedia.org/wiki/Convex_hull_algorithms
 * https://arxiv.org/pdf/1710.10888.pdf
 *
 * https://en.wikipedia.org/wiki/Convex_hull_algorithms
 * https://brilliant.org/wiki/convex-hull/
 * https://medium.com/@harshitsikchi/convex-hulls-explained-baab662c4e94
 *
 * Area convexhull
 * https://brilliant.org/wiki/convex-hull/
 *
 * Jarvis’s Algorithm or Wrapping
 * https://www.geeksforgeeks.org/convex-hull-set-1-jarviss-algorithm-or-wrapping/
 *
 * */


private fun readInt() = readLine()!!.toInt()

private fun <T> readValues(delimiter: String = " ", transform: (String) -> T ) =
    readLine()!!.split(delimiter).map(transform)

data class Point(val p: Int, val q: Int)