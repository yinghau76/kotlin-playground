package com.simplypatrick.kotlin.misc

import android.os.Bundle
import com.simplypatrick.kotlin.ConsoleActivity

class ExceptionActivity : ConsoleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val result = try {
            mayFail("x@a.b.c")
            mayFail("")
        } catch (e: IllegalArgumentException) {
            "catch IllegalArgumentException ${e::class.java}"
        }
        catch (e: Throwable) {
            "catch Throwable: ${e::class.java}"
        } finally {
            println("finally")
        }

        println("result: $result")
    }

    private fun mayFail(email: String): String {
        if (email == "") {
            throw IllegalArgumentException()
        } else if (!email.contains("@")) {
            throw IllegalStateException()
        }
        return email
    }
}
