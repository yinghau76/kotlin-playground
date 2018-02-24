package com.simplypatrick.kotlin.objects

import android.os.Bundle
import com.simplypatrick.kotlin.ConsoleActivity

class EmptyInterfaceActivity : ConsoleActivity() {
    interface Key<E>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val k1 = object : Key<Int> {}
        val k2 = object : Key<String> {}
        val k3: Key<*> = k2
        println("${k1}")
        println("${k2}")
        println("${k1 === k3}")
    }
}
