package com.br

import java.nio.file.Files
import java.nio.file.Path

/*
    https://www.baeldung.com/kotlin/read-file
 */

private fun readFile(filename: String) =
    Files.newBufferedReader(Path.of(filename))
        .useLines { lines ->
            with(StringBuilder()) {
                lines.forEach {
                    this.append(it)
                }
                lines.toString()
            }
        }


fun main() {

}