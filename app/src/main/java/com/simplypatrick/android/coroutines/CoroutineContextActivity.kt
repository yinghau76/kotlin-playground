package com.simplypatrick.android.coroutines

import android.os.Bundle
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

class CoroutineContextActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logThread("Begin onCreate")

        launch(UI) {
            logThread("Begin launch(UI)")
            delay(10_000)
            logThread("End launch(UI)")
        }

        launch(CommonPool) {
            logThread("Begin launch(CommonPool)")
            delay(10_000)
            logThread("End launch(CommonPool)")
        }

        launch(Unconfined) {
            logThread("Begin launch(Unconfined)")
            delay(10_000)
            logThread("End launch(Unconfined)")
        }

        launch(newSingleThreadContext("MyOwnThread")) {
            logThread("Begin launch(newSingleThreadContext)")
            delay(10_000)
            logThread("End launch(newSingleThreadContext)")
        }

        logThread("End onCreate")
    }

    fun logThread(msg: String) {
        println("$msg: ${Thread.currentThread().name}")
    }
}
