package com.simplypatrick.kotlin.misc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlin.reflect.KProperty

class DelegatedPropertiesActivity : AppCompatActivity() {

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
