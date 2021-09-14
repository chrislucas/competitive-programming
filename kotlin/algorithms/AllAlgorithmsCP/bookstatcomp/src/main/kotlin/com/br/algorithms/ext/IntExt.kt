package com.br.algorithms.ext

import java.util.*
import kotlin.random.Random


fun IntRange.randomRange(quantity: Int): TreeSet<Int> {
    val set: TreeSet<Int> = TreeSet()

    val mQuantity = kotlin.math.min(quantity, (this.last - this.first) / this.step)

    do {
        val value = Random.nextInt(this.first, this.last)
        if (!set.contains(value))
            set.add(value)
    } while (set.size < mQuantity)


    return set
}