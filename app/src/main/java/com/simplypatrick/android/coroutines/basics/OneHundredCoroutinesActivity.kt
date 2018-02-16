package com.simplypatrick.android.coroutines.basics

import android.os.Bundle
import com.simplypatrick.android.coroutines.ConsoleActivity
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.TimeUnit

class OneHundredCoroutinesActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("before launch")
        for (i in 1..100L) {
            launch(CommonPool) {
                println("current thread in launch($i): ${Thread.currentThread().name}")
                delay(i, TimeUnit.SECONDS)
                println("after delay($i)")
            }
        }
        println("after launch")
    }
}
