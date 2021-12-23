package com.wipro.testapp.service

import com.wipro.testapp.model.AllFactsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    @GET("s/2iodh4vg0eortkl/facts.json")
    @Headers("Content-type: application/json")
    fun getAllFacts(): Call<AllFactsResponse?>

}