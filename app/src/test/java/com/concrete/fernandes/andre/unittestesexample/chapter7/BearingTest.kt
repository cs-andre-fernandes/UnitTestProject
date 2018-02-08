package com.concrete.fernandes.andre.unittestesexample.chapter7

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by andre on 08/02/18.
 */
class BearingTest {

    private lateinit var bearingTwelve: Bearing
    private lateinit var bearingFifteen: Bearing

    @Before
    fun create() {
        bearingFifteen = Bearing(15)
        bearingTwelve= Bearing(12)
    }

    @Test(expected = BearingOutOfRangeException::class)
    fun throwsOnNegativeNumber() {
        Bearing(-1)
    }

    @Test(expected = BearingOutOfRangeException::class)
    fun throwWhenBearingAreTooLarge() {
        Bearing(Bearing.MAXVALUE + 1)
    }

    @Test
    fun answersAngleBetweenTwoBearings() {
        //Act
        val angleResult = bearingFifteen.angleBetween(bearingTwelve)
        //Assert
        assertThat(angleResult, equalTo(3))
    }

    @Test
    fun answersNegativeAngleBetweenTwoBearing() {
        //Act
        val angleResult = bearingTwelve.angleBetween(bearingFifteen)
        //Assert
        assertThat(angleResult, equalTo(-3))
    }

}