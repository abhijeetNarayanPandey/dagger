package com.nasacode.daggermvvm.retrofit

import com.nasacode.daggermvvm.models.Details
import com.nasacode.daggermvvm.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaAPI {
    @GET("planetary/apod")
    suspend fun getDetails(@Query("api_key") apiKey:String = Constants.API_KEY) : Response<Details>
}