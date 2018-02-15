package com.simplypatrick.android.coroutines

import android.os.Bundle
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withTimeoutOrNull

class TimeoutActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        launch {
            val deferred = async {
                println("Begin launch: $coroutineContext")
                delay(10_000)
                println("End launch")
                42
            }

            val result = withTimeoutOrNull(5_000) {
                println("Begin join: $coroutineContext")
                val ret = deferred.await()
                println("End join")
                ret
            }
            println("Result is $result")
        }

        println("End onCreate")
    }
}
