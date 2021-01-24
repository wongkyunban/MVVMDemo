package com.wong.mvvmdemo

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun ha(){
        val ints: Array<Int> = arrayOf(1,2,3)
        val an = Array<Any>(3){""}


    }

    fun copy(from:Array<Any>,to:Array<Any>){
        for(i in from.indices){
            to[i] = from[i]
        }
    }
    fun hello(obj:Source<String>){

        val objests:Source<Any> = obj

    }
    interface Source<out T>{
        fun nextT():T
    }
}