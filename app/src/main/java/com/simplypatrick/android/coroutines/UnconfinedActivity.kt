package com.simplypatrick.android.coroutines

import android.os.Bundle
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class UnconfinedActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        launch(CommonPool) {
            println("Begin launch(CommonPool): ${Thread.currentThread().name}")
            delay(1_000)
            println("End launch(CommonPool): ${Thread.currentThread().name}")
        }

        launch(Unconfined) {
            println("Begin launch(Unconfined): ${Thread.currentThread().name}")
            delay(1_000)
            println("End launch(Unconfined): ${Thread.currentThread().name}")
        }

        println("End onCreate")
    }
}
