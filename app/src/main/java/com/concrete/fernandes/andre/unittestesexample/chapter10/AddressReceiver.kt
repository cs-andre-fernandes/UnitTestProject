package com.concrete.fernandes.andre.unittestesexample.chapter10

import com.google.gson.Gson

/**
 * Created by andre on 08/02/18.
 */
class AddressReceiver(val http: Http) {

    fun receive(latitude: Double, longitude: Double) : Address {

        val params = "lat=$latitude&lon=$longitude"
        val response = http.get("http://open.mapquestapi.com/nominatim/v1/reverse?format=json&$params")
        var addressParent: AddressParent

        addressParent = Gson().fromJson(response, AddressParent::class.java)


        return addressParent.address
    }

}