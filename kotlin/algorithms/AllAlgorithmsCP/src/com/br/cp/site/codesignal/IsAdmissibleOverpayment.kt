package src.com.br.cp.site.codesignal

/*
    https://app.codesignal.com/challenge/pRuhLib5DdetsY4E7
    DONE
 */



private fun check() {
    arrayOf(
        arrayOf(
            "10.0% higher than in-store",
            "5.0% lower than in-store",
            "Same as in-store"
        ),
        arrayOf(
            "10.0% higher than in-store",
            "23.23% lower than in-store",
        ),
        arrayOf(
            "1210.0% higher than in-store",
            "23.23% lower than in-store",
        ),
        arrayOf(
            "1210.0% higher than in-store",
            "-23.23% lower than in-store",
        )
    ).forEach { array ->

        array.forEach {
            val value = Regex("-*[0-9]+.[0-9]*").find(it)?.value?.toDouble()

            if (it.contains("lower")) {
                println("$value abaixo")
            } else if (it.contains("higher")) {
                println("$value acima")
            } else {
                println("$value igual")
            }
        }
    }
}


private fun solution() {

    fun solution(prices: MutableList<Double>, notes: MutableList<String>, x: Double): Boolean {

        fun getValue(str: String): Double? = Regex("-*[0-9]+.[0-9]*").find(str)?.value?.toDouble()

        /*
            Sabendo que um Valor V esta P % ABAIXO do valor orignal, qual o valor original ?
         */
       // fun getHigher(price: Double, percent: Double) =  price * 100.0 / (100.0 - percent)

        /*
            Sabendo que um valor V esta P % ACIMA do valore original, qual o valor origiinal ?
         */
       // fun getLower(price: Double, percent: Double) = price * 100.0 / (100.0 + percent)

        fun getOriginalPrice(price: Double, percent: Double, isAbove: Boolean) = if(isAbove) {
            price * 100.0 / (100.0 + percent)
        } else {
            price * 100.0 / (100.0 - percent)
        }

        var acc = 0.0

        for (i in prices.indices) {
            val note = notes[i]
            val price = prices[i]
            if (note.contains("higher")) {
                val percent = getValue(note)
                percent?.let {
                   acc += price - getOriginalPrice(price, it, true)
                }
            } else if (note.contains("lower")) {
                val percent = getValue(note)
                percent?.let {
                    acc += price - getOriginalPrice(price, it, false)
                }
            }
        }

        return acc <= x
    }

    data class Cases(val values: MutableList<Double>, val notes: MutableList<String>, val target: Double)

    arrayOf(
        Cases(
            mutableListOf(110.0, 95.0, 70.0),
            mutableListOf("10.0% higher than in-store", "5.0% lower than in-store", "Same as in-store"),
            5.0
        ),

        Cases(
            mutableListOf(48.0, 165.0),
            mutableListOf(
                "20.00% lower than in-store",
                "10.00% higher than in-store"
            ), 2.0

        )
    ).forEach { (values, notes, target) ->

        println(solution(values, notes, target))
    }
}


fun main() {
    solution()
}