package com.wipro.testapp.viewmodel

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wipro.testapp.model.AllFactsResponse
import com.wipro.testapp.model.ResultsItem
import com.wipro.testapp.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetAllFactsViewModel : ViewModel()  {

    var getFacts = MutableLiveData<List<ResultsItem>>()
    var title = String()

    private lateinit var application: Application
    private lateinit var apiClient : ApiClient


    fun initialize(app: Application){
        application = app
        apiClient = ApiClient()
    }

    fun getAllFacts(){
        apiClient
            .getApi()
            .getAllFacts()
            .enqueue(object : Callback<AllFactsResponse?> {
                override fun onResponse(
                    call: Call<AllFactsResponse?>,
                    response: Response<AllFactsResponse?>) {
                    if (response.isSuccessful() && response.body() != null) {
                        title = response.body()!!.title!!
                        getFacts.value = response.body()!!.results!!
                    } else if (response.code() == 400 && response.errorBody() != null) {
                        Log.d(TAG, "onResponse: ")
                    }
                }

                override fun onFailure(call: Call<AllFactsResponse?>, t: Throwable)
                {
                    Log.d(TAG, "onResponse: ")
                }
            })
    }


}