package com.simplypatrick.android.coroutines

import android.os.Bundle
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

class ManyCoroutinesActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        runBlocking {
            val jobs = List(1000) {
                launch {
                    println("Begin launch: $coroutineContext")
                    delay(1000L)
                    println("End launch")
                }
            }
            jobs.forEach { it.join() }
        }

        println("End onCreate") // onCreate should finish in 1~2 seconds
    }
}
