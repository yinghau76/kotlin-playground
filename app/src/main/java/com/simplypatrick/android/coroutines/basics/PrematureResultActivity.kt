package com.simplypatrick.android.coroutines.basics

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.simplypatrick.android.coroutines.ConsoleActivity
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.newSingleThreadContext
import java.util.concurrent.atomic.AtomicInteger

class PrematureResultActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val c = AtomicInteger()
        println("c = ${c.get()}")
        for (i in 1..500) {
            launch(newSingleThreadContext("MyOwnThread")) {
                c.addAndGet(1)
            }
        }
        println("c = ${c.get()}") // some coroutines don't finish before printing the result
    }
}
