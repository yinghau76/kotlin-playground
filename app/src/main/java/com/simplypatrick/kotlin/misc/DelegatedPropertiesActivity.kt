package com.simplypatrick.kotlin.misc

import android.os.Bundle
import com.simplypatrick.kotlin.ConsoleActivity
import kotlin.reflect.KProperty

class DelegatedPropertiesActivity : ConsoleActivity() {

    class Example {
        var p: String by Delegate()
    }

    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name} in $thisRef.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val e = Example()
        println(e.p)

        val n: Example? = null
        println(n?.p)
    }
}
