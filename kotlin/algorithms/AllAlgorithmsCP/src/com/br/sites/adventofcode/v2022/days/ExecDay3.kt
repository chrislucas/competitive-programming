package src.com.br.sites.adventofcode.v2022.days

/*
    https://adventofcode.com/2022/day/3
 */


private fun <V> String.associate(
    map: MutableMap<Char, V>,
    aggregate: (MutableMap<Char, V>, Char) -> Unit
): Map<Char, V> {
    this.forEach {
        aggregate(map, it)
    }
    return map
}

private fun <V> String.mutableAssoaction(
    map: MutableMap<Char, V>,
    aggregate: (MutableMap<Char, V>, Char) -> Unit
): MutableMap<Char, V> {
    this.forEach {
        aggregate(map, it)
    }
    return map
}

private fun <V> String.associateIndexed(
    map: MutableMap<Char, V>,
    aggregate: (MutableMap<Char, V>, Int, Char) -> Unit
): Map<Char, V> {
    this.forEachIndexed { idx, c ->
        aggregate(map, idx, c)
    }
    return map
}

private fun testStringCounting(str: String) {
    val rs = str.associate<Int>(mutableMapOf()) { map, c ->
        map[c] = map[c]?.plus(1) ?: 1
    }
    println(rs)
}


private fun String.half(): Pair<String, String> {
    return if (isNotEmpty()) {
        val mi = length / 2
        this.substring(0, mi) to this.substring(mi, length)
    } else {
        "" to ""
    }
}

private fun checkStringHalf() {
    /*
    println("chris".half())
    println("chri".half())
    println("ch".half())
    println("c".half())
    println("christoffer".half())
    println("christoffer lucas".half())

     */

    arrayOf(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT",
        "CrZsJsPPZsGzwwsLwLmpwMDw"
    ).forEach { s ->
        val (lf, ri) = s.half()
        println("${lf.length}, ${ri.length}")
    }
}


private fun s1Day3() {

    val priority = (('a'..'z') + ('A'..'Z'))
        .joinToString()
        .filter { it.isLetter() }
        .associateIndexed<Int>(mutableMapOf()) { map, idx, c ->
            map[c] = idx + 1
        }

    var acc = 0

    while (true) {
        val line = readLine()
        if (line?.isNotEmpty() == true) {
            val (lf, ri) = line.half()
            val mapLeft = lf.associate<Int>(mutableMapOf()) { map, c ->
                map[c] = map[c]?.plus(1) ?: 1
            }
            val mapRight = ri.associate<Int>(mutableMapOf()) { map, c ->
                map[c] = map[c]?.plus(1) ?: 1
            }
            val sameKeys = mapLeft.keys.filter { c -> mapRight.containsKey(c) }
            acc += sameKeys.sumOf { c -> priority[c] ?: 0 }
            println(acc)

        } else {
            break
        }
    }
}

private fun s2Day3() {
    val priority = (('a'..'z') + ('A'..'Z'))
        .joinToString()
        .filter { it.isLetter() }
        .associateIndexed<Int>(mutableMapOf()) { map, idx, c ->
            map[c] = idx + 1
        }

    var acc = 0

    while (true) {

        val lines = mutableListOf<Set<Char>>()
        repeat(6) {
            val s = readLine() ?: ""
            lines.add(s.toSet())
        }
        var setA = lines[0]
        for (i in 1 .. 2) {
            setA = setA.intersect(lines[i])
        }

        var setB = lines[3]
        for (i in 4 .. 5) {
            setB = setB.intersect(lines[i])
        }

        val a = setA.sumOf { priority[it] ?: 0 }
        val b = setB.sumOf { priority[it] ?: 0 }
        acc += a + b
        println(acc)
    }
}

fun main() {
    //testStringCounting("abcccbb")
    //testStringCounting("vJrwpWtwJgWrhcsFMMfFFhFp")
    //testStringCounting("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")
    // checkStringHalf()
    //s1Day3()
    s2Day3()
}