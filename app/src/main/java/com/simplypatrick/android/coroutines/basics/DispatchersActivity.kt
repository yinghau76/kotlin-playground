package com.simplypatrick.android.coroutines.basics

import android.os.Bundle
import com.simplypatrick.android.coroutines.ConsoleActivity
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

class DispatchersActivity : ConsoleActivity() {

    private class MyDispatcher : AbstractCoroutineContextElement(MyDispatcher) {
        companion object WTF : CoroutineContext.Key<MyDispatcher>
    }

    private val myDispatcher = object : CoroutineDispatcher() {
        override fun dispatch(context: CoroutineContext, block: Runnable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
