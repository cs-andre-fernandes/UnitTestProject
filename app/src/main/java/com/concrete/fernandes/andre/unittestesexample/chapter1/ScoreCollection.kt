package com.concrete.fernandes.andre.unittestesexample.chapter1

/**
 * Created by andre on 06/02/18.
 */
class ScoreCollection {

    private val scores : MutableList<Scoreable> = ArrayList()

    fun add(scoreable : Scoreable) {
        scores.add(scoreable)
    }

    fun arithmeticMean() : Int {
        val total = scores.stream().mapToInt(Scoreable::getScore).sum()
        return total / scores.size
    }
}