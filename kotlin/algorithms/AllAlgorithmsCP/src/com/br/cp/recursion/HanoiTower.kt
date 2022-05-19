package src.com.br.cp.recursion

// https://www.mathsisfun.com/games/towerofhanoi.html
private fun count(n: Int): Int {
    return if (n == 1) {
        1
    } else {
        count(n - 1) + count(1) + count(n - 1)
    }
}


private fun memorize(n: Int): Int {
    fun solver(n: Int, memo: Array<Int>): Int {
        return if (memo[n] > 0) {
            memo[n]
        } else {
            /*
            memo[n] = count(n - 1)
            memo[1] = count(1) + memo[n]
            memo[n] = count(n - 1) + memo[1]
            memo[n]

             */
            memo[n] = count(n - 1) + count(n - 1) + 1
            memo[n]
        }
    }

    val memo = Array(n + 1) { 0 }
    memo[1] = 1
    solver(n, memo)
    return memo[n]
}

private fun checkMemorize() {
    (1..31).forEach {
        println("$it: ${memorize(it)} == ${(1 shl it) - 1}")
    }
}

private fun steps(n: Int) = (1 shl n) - 1

private fun checkCountAndSteps() {
    (1..31).forEach {
        println("$it: ${count(it)}, ${steps(it)}")
    }
}

fun main() {
    checkMemorize()
}