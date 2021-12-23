package com.wipro.testapp.service

import com.wipro.testapp.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private var retrofit: Retrofit? = null
    var httpClient: OkHttpClient? = null

    // API call using Retrofit to fetch the data from server
    fun getApi(): Api {
        if (retrofit == null) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor).build()
            retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(Api::class.java)
    }
}