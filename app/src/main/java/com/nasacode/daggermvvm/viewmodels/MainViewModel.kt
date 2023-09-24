package com.nasacode.daggermvvm.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasacode.daggermvvm.db.NasaDB
import com.nasacode.daggermvvm.models.Details
import com.nasacode.daggermvvm.repository.NasaShowsRepository
import com.nasacode.daggermvvm.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NasaShowsRepository,private val db:NasaDB) : ViewModel() {
     var nasaLiveData = MutableLiveData<Resource<Details>>()
    init {
        viewModelScope.launch {
            delay(5000)
            getNasaDetails()
        }
    }

    fun getNasaDetails() = viewModelScope.launch {
        nasaLiveData.postValue(Resource.Loading())
        try{
            val response = repository.getDetailsNasa()
            db.getNasaDAO().addProducts(response.body()!!)
            nasaLiveData.postValue(handleNasaResponse(response))
        }catch (e:Exception){

        }
    }

    private fun handleNasaResponse(response: Response<Details>): Resource<Details>? {
        if(response.isSuccessful){
            response.body()?.let { resultResponse->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


}