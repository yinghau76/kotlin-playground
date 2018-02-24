package com.simplypatrick.kotlin.coroutines

import android.os.Bundle
import com.simplypatrick.kotlin.ConsoleActivity
import kotlin.coroutines.experimental.buildSequence

class BuildSequenceActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Begin onCreate")

        val seq = buildSequence({
            println("Begin buildSequence")
            for (i in 1..10) {
                val y = i * i
                println("Yield $y")
                yield(y)
            }
            println("End buildSequence")
        })
        for (i in seq) {
            println("Got $i")
        }

        println("End onCreate")
    }
}
