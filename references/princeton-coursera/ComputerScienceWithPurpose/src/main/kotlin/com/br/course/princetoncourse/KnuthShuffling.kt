package com.br.course.princetoncourse

import java.net.HttpURLConnection
import java.net.URL
import kotlin.random.Random

/**
 * https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Knuth.java.html
 * https://algs4.cs.princeton.edu/lectures/keynote/21ElementarySorts-2x2.pdf
 * TODO
 */

private fun <T> MutableList<T>.shuffling(): List<T> {

    val copy = MutableList(size) { index -> this[index] }
    fun swap(values: MutableList<T>, i: Int, j: Int) {
        val temp = values[i]
        values[i] = values[j]
        values[j] = temp
    }

    for (i in 0 until size) {
        val rand = Random.nextInt(i, size)
        swap(copy, i, rand)
    }

    return copy.toList()
}


private fun checkShuffling() {
    val s = (1..10).toMutableList()
    val t = s.shuffling()
    println(s)
    println(t)
}

fun readOnlineText(url: String) {
    /**
     * https://stackoverflow.com/questions/36301905/how-to-download-export-txt-file-in-java
     */
    val result = with(URL(url)) {
        val httpConnection: HttpURLConnection = openConnection() as (HttpURLConnection)
        if (httpConnection.responseCode == HttpURLConnection.HTTP_OK) {
            val string = StringBuilder()
            httpConnection.inputStream
                .bufferedReader()
                .forEachLine {
                    string.append("$it ")
                }
            string.split(" ").filter { it.isNotBlank() }

        } else {
            println("Error: ${httpConnection.responseCode}")
            emptyList()
        }
    }

    println("Result\n$result.\nSize: ${result.size}.\nEmbaralhado\n${result.toMutableList().shuffling()}.\n")
}

private fun shufflingCards() {
    arrayOf(
        "https://algs4.cs.princeton.edu/11model/cardsUnicode.txt",
        "https://algs4.cs.princeton.edu/11model/cards.txt"
    ).forEach {
        readOnlineText(it)
    }
}


fun main() {
    shufflingCards()
}