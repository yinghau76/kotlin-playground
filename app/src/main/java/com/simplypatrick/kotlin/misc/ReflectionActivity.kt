package com.simplypatrick.kotlin.misc

import android.os.Bundle
import com.simplypatrick.kotlin.ConsoleActivity

class ReflectionActivity : ConsoleActivity() {

    class A(val p: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val strs = listOf("apple", "banana", "cheery")
        println(strs.map(String::length))

        println(A::p)
        println(A::p.get(A(1)))
        println(A::p.javaClass)
        println(A::p.getter)
    }
}
