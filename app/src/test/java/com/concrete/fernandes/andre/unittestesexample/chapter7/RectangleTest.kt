package com.concrete.fernandes.andre.unittestesexample.chapter7

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Test



/**
 * Created by andre on 08/02/18.
 */
class RectangleTest {

    lateinit var rectangle : Rectangle

    @Test
    fun answersArea() {
        //Arrange
        rectangle = Rectangle(Point(5,5), Point(15, 10))

        //Act
        val areaResult = rectangle.area()

        //Assert
        assertThat(areaResult, equalTo(50))
    }

    @Test
    fun answerAreaModifyingSize() {
        //Arrange
        rectangle = Rectangle(Point(5,5))

        //Act
        rectangle.setOppositeCorners(Point(130, 130))
        val areaResult = rectangle.area()

        //Assert
        assertThat(areaResult, equalTo(15625))

    }

    @After
    fun ensureInvariant() {
        assertThat(rectangle, ConstrainsSidesTo.constrainsSidesTo(100))
    }
}