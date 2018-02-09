package com.concrete.fernandes.andre.unittestesexample.chapter10

import com.google.gson.annotations.SerializedName

/**
 * Created by andre on 08/02/18.
 */

data class Address(@SerializedName("house_number") var houseNumber: String, var road: String, var city: String, var state: String, @SerializedName("postcode") var postCode: String,
                   @SerializedName("country_code") var countryCode: String)
