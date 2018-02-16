package com.simplypatrick.kotlin.coroutines

import android.os.Bundle
import com.simplypatrick.kotlin.ConsoleActivity
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

class ProduceActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        val ch = produce {
            println("Begin product: $coroutineContext")
            for (i in 1..10) {
                println("Send $i")
                send(i)
                delay(1000)
            }
        }

        runBlocking {
            ch.consumeEach {
                println("Got $it")
            }
        }

        println("End onCreate")
    }
}
