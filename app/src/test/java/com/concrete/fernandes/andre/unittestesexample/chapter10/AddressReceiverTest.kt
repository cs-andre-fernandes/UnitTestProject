package com.concrete.fernandes.andre.unittestesexample.chapter10

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.Matchers.contains
import org.mockito.Mockito.*

/**
 * Created by andre on 08/02/18.
 */
class AddressReceiverTest {

    @Test
    fun answerAppropriateAddressForValidCoordinates() {
        //Arrange
        val http: Http = mock(Http::class.java)
        `when`(http.get(contains("lat=38.0&lon=-104.0"))).thenReturn(
                "{\"address\":{"
                        + "\"house_number\":\"324\","
                        + "\"road\":\"North Tejon Street\","
                        + "\"city\":\"Colorado Springs\","
                        + "\"state\":\"Colorado\","
                        + "\"postcode\":\"80903\","
                        + "\"country_code\":\"us\"}"
                        + "}"
        )

        val retriever = AddressReceiver(http)

        //Act
        val address = retriever.receive(38.0, -104.0)

        //Assert
        assertThat(address.houseNumber, equalTo("324"))
        assertThat(address.road, equalTo("North Tejon Street"))
        assertThat(address.city, equalTo("Colorado Springs"))
        assertThat(address.state, equalTo("Colorado"))
        assertThat(address.postCode, equalTo("80903"))
    }

}