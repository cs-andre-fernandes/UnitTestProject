package com.concrete.fernandes.andre.unittestesexample.chapter7

/**
 * Created by andre on 08/02/18.
 */
class Bearing(private val value: Int) {

    init {
        validateValue()
    }

    private fun validateValue() {
        if (value < 0) {
            throw BearingOutOfRangeException("Could not be less than 0")
        } else if (value > MAXVALUE) {
            throw BearingOutOfRangeException("Could not be more than 359")
        }
    }

    companion object {
        val MAXVALUE = 359
    }

    fun angleBetween(bearing: Bearing) : Int {
        return this.value - bearing.value
    }
}