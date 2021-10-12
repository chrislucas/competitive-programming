package src.com.br.cp.book.cphandbook.chp10.shift

infix fun Int.isSet(i: Int) = (this and (1 shl i)) > 0

val Int.binaryString: String
    get() {
        val builder = StringBuilder()
        for (i in 31 downTo 0) {
            builder.append(if (this isSet i) "1" else "0")
        }
        return builder.toString()
    }


private fun check1() {
    val k = 31
    val range = ((1 shl k) - 2) .. (1 shl k) -1

    range.forEach {
        println("$it: ${it.binaryString} ${it.binaryString.length}")
    }
}

private fun check2() {
    fun checkShift(x: Int): String {
        val builder = StringBuilder()
        for (i in 31 downTo 0) {
            builder.append( if(x and (1 shl i) > 0) "1" else "0")   // check se o ith bit eh 1 ou 0
        }
        return builder.toString()
    }

    //val k = 31
    val range = 0 .. 1024 //((1 shl k) - 2) .. (1 shl  k) -1

    range.forEach {
        println("$it: ${checkShift(it)}")
    }
}

fun main() {
    check1()
    check2()
}