package com.concrete.fernandes.andre.unittestesexample.chapter7

import org.hamcrest.Description
import org.hamcrest.Factory
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Created by andre on 08/02/18.
 */
class ConstrainsSidesTo(private val length: Int) : TypeSafeMatcher<Rectangle>() {

    override fun describeTo(description: Description?) {
        description?.appendText("both sides must be <= $length")
    }

    override fun matchesSafely(rectangle: Rectangle?): Boolean {
        val widthSide = if(rectangle?.width != null)
            rectangle.width.x - rectangle.length.x else 0

        val lengthSide = if(rectangle?.width?.y != null)
            rectangle.width.y - rectangle.length.y else 0

        return Math.abs(widthSide) <= length &&
                    Math.abs(lengthSide) <= length

    }

    companion object {
        @Factory
        fun constrainsSidesTo(length: Int) : Matcher<Rectangle> {
            return ConstrainsSidesTo(length)
        }
    }

}