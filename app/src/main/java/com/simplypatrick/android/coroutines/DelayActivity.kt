package com.simplypatrick.android.coroutines

import android.os.Bundle
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

class DelayActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        runBlocking {
            println("Begin runBlocking: $coroutineContext")
            delay(1000)
            println("End runBlocking")
        }

        launch {
            println("Begin launch: $coroutineContext")
            launch {
                println("Thread.sleep 500")
                Thread.sleep(500)
            }
            println("Thread.sleep 1000")
            Thread.sleep(1000)
            println("End launch")
        }

        // To illustrate that delay is non-blocking
        launch {
            println("Begin launch: $coroutineContext")
            launch {
                println("Delay 500")
                delay(500)
            }
            println("Delay 1000")
            delay(1000)
            println("End launch")
        }

        println("End onCreate")
    }
}
