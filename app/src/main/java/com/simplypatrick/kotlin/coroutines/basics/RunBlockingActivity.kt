package com.simplypatrick.kotlin.coroutines.basics

import android.os.Bundle
import com.simplypatrick.kotlin.ConsoleActivity
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

class RunBlockingActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("before runBlocking")
        runBlocking {
            println("current thread in runBlocking: ${Thread.currentThread().name}")
            delay(10, TimeUnit.SECONDS)
        }
        println("after runBlocking")
    }
}
