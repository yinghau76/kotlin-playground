package com.simplypatrick.android.coroutines.basics

import android.os.Bundle
import com.simplypatrick.android.coroutines.ConsoleActivity
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

class ParallelExecutionActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        val deferred = (0..1_000).map { n ->
            async(CommonPool) {
                1
            }
        }
        runBlocking {
            val sum = deferred.sumBy { it.await() }
            println("sum = $sum")
        }
    }
}
