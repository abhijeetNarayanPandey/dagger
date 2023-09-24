package com.nasacode.daggermvvm.repository

import com.nasacode.daggermvvm.retrofit.NasaAPI
import javax.inject.Inject

class NasaShowsRepository @Inject constructor(var nasaAPI: NasaAPI) {


    suspend fun getDetailsNasa() = nasaAPI.getDetails()
}