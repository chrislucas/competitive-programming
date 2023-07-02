package src.com.br.cp.site.ds.kotlin.site.hackerearth

private fun check(n: Int) {

    fun lsb(n: Int) = n and (-n)

    if (n > 0) {
        val mutableList = mutableListOf<Pair<Int, IntRange>>()
        for (i in 1 .. n) {
            mutableList += if(i and 1 == 1) {
                i to (i .. i)
            } else {
                i to ((i - lsb(i)) + 1 .. i)
            }
        }
        println(mutableList)
        println("****************************************************************************")
        println(mutableList.joinToString(", "))
    }
}


fun main() {
   arrayOf(1, 2, 3, 16, 32).forEach {
       check(it)
   }
}