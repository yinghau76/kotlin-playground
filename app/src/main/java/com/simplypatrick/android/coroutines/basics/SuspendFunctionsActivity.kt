package com.simplypatrick.android.coroutines.basics

import android.os.Bundle
import com.simplypatrick.android.coroutines.ConsoleActivity
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.suspendCoroutine
import kotlin.system.measureTimeMillis

class SuspendFunctionsActivity : ConsoleActivity() {
    suspend fun timeConsuming(t: Int): Long {
        return measureTimeMillis {
            delay(t.toLong(), TimeUnit.SECONDS)
        }
    }

    suspend fun <T> CompletableFuture<T>.await(): T =
            suspendCoroutine<T> { cont: Continuation<T> ->
            }

    fun produceSquares() = produce<Int>(CommonPool) {
        for (x in 1..5) send(x * x)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        launch {
            println("Begin launch")
            val duration = timeConsuming(5)
            println("timeConsuming: $duration")
            val squares = produceSquares()
            squares.consumeEach {
                println("consume $it")
            }
        }
    }
}
