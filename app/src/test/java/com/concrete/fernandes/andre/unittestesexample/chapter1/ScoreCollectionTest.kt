package com.concrete.fernandes.andre.unittestesexample.chapter1

import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Assert.fail
import org.junit.Test

/**
 * Created by andre on 06/02/18.
 */

class ScoreCollectionTest {

    private val FIRST_VALUE = 5
    private val SECOND_VALUE = 7
    private val ARITHMETIC_RESULT_VALUE = 6

    @Test
    fun arithmeticAverageWithTwoNumbers() {
        //Arrange
        val scoreCollection = ScoreCollection()
        scoreCollection.add(Score(FIRST_VALUE))
        scoreCollection.add(Score(SECOND_VALUE))

        //Act
        val average = scoreCollection.arithmeticMean()

        //Assert
        assertThat(average, equalTo(ARITHMETIC_RESULT_VALUE))
    }

}