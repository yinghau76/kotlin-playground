package com.simplypatrick.android.coroutines

import android.os.Bundle
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

class CoroutineContextActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        launch(UI) {
            println("Begin launch(UI): ${Thread.currentThread().name}")
            delay(10_000)
            println("End launch(UI): ${Thread.currentThread().name}")
        }

        launch(CommonPool) {
            println("Begin launch(CommonPool): ${Thread.currentThread().name}")
            delay(10_000)
            println("End launch(CommonPool): ${Thread.currentThread().name}")
        }

        launch(Unconfined) {
            println("Begin launch(Unconfined): ${Thread.currentThread().name}")
            delay(10_000)
            println("End launch(Unconfined): ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyOwnThread")) {
            println("Begin launch(newSingleThreadContext): ${Thread.currentThread().name}")
            delay(10_000)
            println("End launch(newSingleThreadContext): ${Thread.currentThread().name}")
        }

        println("End onCreate")
    }
}
