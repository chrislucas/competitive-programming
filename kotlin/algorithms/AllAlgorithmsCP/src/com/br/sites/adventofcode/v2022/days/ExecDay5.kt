package src.com.br.sites.adventofcode.v2022.days

import java.util.*

/*
    https://adventofcode.com/2022/day/5
 */

private fun s1() {
    val qStacks = 9
    val stacks = Array(qStacks) { Stack<String>() }
    val qLines = 8
    repeat(qLines) {
        val data = readLine()!!//.replace(Regex("[\\[\\]]"), " ")
        //val line = data.split(" ")
        var counter = 1
        var idx = 0
        while (counter < data.length) {
            val value = "${data[counter]}"
            if (value.isNotBlank()) {
                stacks[idx].push(value)
            }
            idx += 1
            counter += 4
        }
    }

    readLine()
    readLine()

    for (stack in stacks) {
        stack.reverse()
    }

    while (true) {
        val instruction = readLine()
        if (instruction?.isNotEmpty() == true) {
            val split = instruction.split(" ")
            val q = split[1].toInt()
            val f = split[3].toInt()
            val t = split[5].toInt()
            val stackOrigin = stacks[f - 1]
            val stackDestiny = stacks[t - 1]
            repeat(q) {
                stackDestiny.push(stackOrigin.pop())
            }
        } else {
            val str = StringBuilder()
            for (stack in stacks) {
                if (stack.isNotEmpty()) {
                    str.append(stack.peek())
                }
            }
            println(str)
            break
        }
    }
}

private fun s2() {
    val qStacks = 9
    val stacks = Array(qStacks) { Stack<String>() }
    val qLines = 8
    repeat(qLines) {
        val data = readLine()!!//.replace(Regex("[\\[\\]]"), " ")
        //val line = data.split(" ")
        var counter = 1
        var idx = 0
        while (counter < data.length) {
            val value = "${data[counter]}"
            if (value.isNotBlank()) {
                stacks[idx].push(value)
            }
            idx += 1
            counter += 4
        }
    }

    readLine()
    readLine()

    for (stack in stacks) {
        stack.reverse()
    }

    val aux: Stack<String> = Stack()

    while (true) {
        val instruction = readLine()
        if (instruction?.isNotEmpty() == true) {
            val split = instruction.split(" ")
            val q = split[1].toInt()
            val f = split[3].toInt()
            val t = split[5].toInt()
            val stackOrigin = stacks[f - 1]
            val stackDestiny = stacks[t - 1]
            repeat(q) {
                aux.add(stackOrigin.pop())
            }
            while (aux.isNotEmpty()) {
                stackDestiny.push(aux.pop())
            }
        } else {
            val str = StringBuilder()
            for (stack in stacks) {
                if (stack.isNotEmpty()) {
                    str.append(stack.peek())
                }
            }
            println(str)
            break
        }
    }
}

fun main() {
    s2()
}

/*
Exemplo 1
    [D]
[N] [C]
[Z] [M] [P]
 1   2   3

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2

Exemplo 2
[S]                 [T] [Q]
[L]             [B] [M] [P]     [T]
[F]     [S]     [Z] [N] [S]     [R]
[Z] [R] [N]     [R] [D] [F]     [V]
[D] [Z] [H] [J] [W] [G] [W]     [G]
[B] [M] [C] [F] [H] [Z] [N] [R] [L]
[R] [B] [L] [C] [G] [J] [L] [Z] [C]
[H] [T] [Z] [S] [P] [V] [G] [M] [M]
 1   2   3   4   5   6   7   8   9
 */