package com.concrete.fernandes.andre.unittestesexample.chapter10

import android.os.AsyncTask.execute
import java.net.HttpURLConnection
import java.net.URL


/**
 * Created by andre on 08/02/18.
 */
class HttpImpl : Http {

    override fun get(url: String): String {
        val url = URL(url)
        val urlc = url.openConnection() as HttpURLConnection
        urlc.setRequestProperty("User-Agent", "test")
        urlc.setRequestProperty("Connection", "close")
        urlc.setConnectTimeout(1000) // mTimeout is in seconds
        urlc.connect()
        val response = urlc.responseMessage
        urlc.disconnect()
        return response
    }

}