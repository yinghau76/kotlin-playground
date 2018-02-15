package com.simplypatrick.android.coroutines

import android.os.Bundle
import kotlinx.coroutines.experimental.*

class RunBlockingActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        runBlocking {
            println("Begin runBlocking: $coroutineContext")

            val job = async {
                println("Begin async: $coroutineContext")
                delay(10_000)
                println("End async")
            }
            println("Wait async")
            job.await()
            println("End runBlocking")
        }

        println("End onCreate")
    }
}
