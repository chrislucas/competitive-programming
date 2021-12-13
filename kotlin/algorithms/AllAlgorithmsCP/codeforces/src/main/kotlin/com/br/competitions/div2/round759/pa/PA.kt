package com.br.competitions.div2.round759.pa


private fun readInt() = readLine()!!.toInt()

private inline fun testCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

fun main() {

    testCases(readInt()) {
        readInt()
        val values = readValues { it.toInt() }

        var i = 0
        var dies = false
        var h = 1
        while (i < values.size - 1) {
            if (values[i] == 0 && values[i + 1] == 0) {
                dies = true
                break
            }
            else if(values[i] == 1 && values[i + 1] == 1) {
                h += 5
            }
            else if(values[i] == 1){
                h += 1
            }
            i += 1
        }

        values.let {
            if (values.last() == 1)
                h += 1
        }

        println(if (dies) -1 else h)
    }
}