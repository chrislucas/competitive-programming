package src.com.br.sites.adventofcode.v2022.days

/*
    https://adventofcode.com/2022/day/2
    DONE = 14827
 */

fun main() {

    fun translate(shape: String): String {
        return when (shape) {
            "A", "X" -> {
                "A"
            }
            "B", "Y" -> {
                "B"
            }
            else -> {
                "C"
            }
        }
    }

    fun valueOfShape(shape: String): Int {
        return when (shape) {
            "A" -> 1
            "B" -> 2
            else -> 3
        }
    }

    fun evaluateForPlayerB(shapeA: String, shapeB: String): Int {
        return if (shapeA == shapeB) {
            0
        } else if (shapeA < shapeB && (shapeA != "A" || shapeB != "C") || shapeA == "C" && shapeB == "A") {
            1
        } else {
            -1
        }
    }

    fun firstProblem() {
        var accA = 0
        var accB = 0

        while (true) {
            val line = readLine()
            if (line != null && line.isNotEmpty()) {
                val (a, b) = line.split(" ")
                val shapeB = translate(b)
                val rs = evaluateForPlayerB(a, shapeB)
                when (rs) {
                    0 -> {
                        accA += valueOfShape(a) + 3
                        accB += valueOfShape(shapeB) + 3
                    }
                    1 -> {
                        accB += valueOfShape(shapeB) + 6
                        accA += valueOfShape(a)
                    }
                    else -> {
                        accB += valueOfShape(shapeB)
                        accA += valueOfShape(a) + 6
                    }
                }
                println("A: $accA, B: $accB -> $a x $shapeB ($rs)")

            } else {
                break
            }
        }
    }

    fun secondProblem() {

        fun mockResult(value: String): Int {
            return when (value) {
                "X" -> -1
                "Y" -> 0
                else -> 1
            }
        }

        fun mockNewShape(shape: String, whichResult: Int) : String {
            return when (whichResult) {
                0 -> { shape }
                1 -> {
                    when (shape) {
                        "A" -> { "B" }
                        "B" -> { "C" }
                        else -> { "A" }
                    }
                }
                else -> {
                    when (shape) {
                        "A" -> { "C" }
                        "B" -> { "A" }
                        else -> { "B" }
                    }
                }
            }
        }

        var accA = 0
        var accB = 0

        while (true) {

            val line = readLine()
            if (line != null && line.isNotEmpty()) {
                val (a, b) = line.split(" ")
                val result = mockResult(b)
                val shapeB =   mockNewShape(a, result)
                val rs = evaluateForPlayerB(a, shapeB)
                when (rs) {
                    0 -> {
                        accA += valueOfShape(a) + 3
                        accB += valueOfShape(shapeB) + 3
                    }
                    1 -> {
                        accB += valueOfShape(shapeB) + 6
                        accA += valueOfShape(a)
                    }
                    else -> {
                        accB += valueOfShape(shapeB)
                        accA += valueOfShape(a) + 6
                    }
                }
                println("MockResult($result) - A: $accA, B: $accB -> $a x $shapeB ($rs)")
            }
        }
    }

    secondProblem()

}