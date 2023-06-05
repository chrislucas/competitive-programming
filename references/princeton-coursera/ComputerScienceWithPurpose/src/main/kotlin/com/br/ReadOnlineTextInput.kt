package com.br

import java.net.HttpURLConnection
import java.net.URL

/**
 * IDEIA vinda desse link
 * https://stackoverflow.com/questions/36301905/how-to-download-export-txt-file-in-java
 */

fun read(file: String) =

    with(URL(file)) {
        val httpConnection: HttpURLConnection = openConnection() as (HttpURLConnection)
        if (httpConnection.responseCode == HttpURLConnection.HTTP_OK) {
            val lines = mutableListOf<String>()
            httpConnection.inputStream
                .bufferedReader()
                .forEachLine(lines::add)
            lines
        } else {
            emptyList()
        }
    }


fun main() {
    println(read("https://algs4.cs.princeton.edu/11model/cardsUnicode.txt"))
}