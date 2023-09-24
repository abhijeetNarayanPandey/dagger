package com.nasacode.daggermvvm.repository

import com.nasacode.daggermvvm.retrofit.NasaAPI

import javax.inject.Inject

class MostPopularTVShowsRepository@Inject constructor(val fakeAPI: NasaAPI) {
 /*   private var quotesLiveData = MutableLiveData<Resource<Details>>()

    val quotes: LiveData<Resource<Details>>
    get() = quotesLiveData
    suspend fun getDetails(){
        var result = fakeAPI.getDetails()
        if(result?.body()!=null){
       //     quotesLiveData.postValue(result.body())
        }
    }
*/
}