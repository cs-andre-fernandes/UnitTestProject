package com.concrete.fernandes.andre.unittestesexample.chapter1

/**
 * Created by andre on 07/02/18.
 */

class Score(val value: Int) : Scoreable {

    override fun getScore(): Int {
        return value
    }
}