package com.simplypatrick.kotlin.objects

import android.os.Bundle
import com.simplypatrick.kotlin.ConsoleActivity

class CompanionActivity : ConsoleActivity() {
    companion object A : Runnable {
        override fun run() {
            println("I can be used implicitly with class name")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Kotlin will use the corresponding companion object when it see a class name
        runOnUiThread(CompanionActivity)
    }
}
