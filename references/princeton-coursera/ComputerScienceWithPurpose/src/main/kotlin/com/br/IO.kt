package com.br


import java.nio.file.Files
import java.nio.file.Path


private fun content(filename: String): String =
    with(StringBuilder()) {
        Files.newBufferedReader(Path.of(filename))
            .readLines()
            .forEach { this.append(it) }
        toString()
    }
