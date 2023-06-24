package com.br.multitask

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/*
    https://medium.com/androiddevelopers/bridging-the-gap-between-coroutines-jvm-threads-and-concurrency-problems-864e563bd7c

    TODO
 */

private fun CoroutineScope.log(message: String) = String.format(
    "Scope: %s | ThreadName: %s | message: %s",
    this, Thread.currentThread().name, message
)

private fun check() {
    runBlocking(Dispatchers.IO) {
        println(log("runblocking Dispatcher.IO"))
    }

    runBlocking(Dispatchers.Unconfined) {
        println(log("runblocking Dispatcher.Unconfined"))
    }

    runBlocking(Dispatchers.Default) {
        println(log("runblocking Dispatcher.Default"))
    }

    println("************************************************************************")

    CoroutineScope(Dispatchers.Default).run {
        println(log("coroutineScope Dispatchers.Default"))
    }

    CoroutineScope(Dispatchers.Unconfined).run {
        println(log("coroutineScope Dispatchers.Unconfined"))
    }

    CoroutineScope(Dispatchers.IO).run {
        println(log("coroutineScope Dispatchers.IO"))
    }
}


fun main() {
    check()
}