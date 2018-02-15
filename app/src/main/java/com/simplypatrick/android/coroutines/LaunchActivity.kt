package com.simplypatrick.android.coroutines

import android.os.Bundle
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class LaunchActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        launch(UI) {
            println("Begin launch: $coroutineContext")

            val job = async {
                println("Begin async: $coroutineContext")
                delay(10000)
                println("End async")
                42
            }
            println("Wait async")
            val result = job.await()
            println("End launch: $result")
        }

        println("End onCreate")
    }
}
