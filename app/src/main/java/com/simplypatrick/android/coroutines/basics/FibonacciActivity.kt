package com.simplypatrick.android.coroutines.basics

import android.os.Bundle
import com.simplypatrick.android.coroutines.ConsoleActivity
import kotlin.coroutines.experimental.buildSequence

class FibonacciActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fibonacci = buildSequence {
            yield(1)
            var cur = 1
            var next = 1
            while (true) {
                println("yield $next")
                yield(next)
                val tmp = cur + next
                cur = next
                next = tmp
            }
        }
        println(fibonacci.take(10).joinToString())
    }
}
