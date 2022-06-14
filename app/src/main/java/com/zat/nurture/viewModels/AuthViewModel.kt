package com.zat.nurture.viewModels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zat.nurture.models.ResultWrapper
import com.zat.nurture.models.registerModeld.RegisterMainModel
import com.zat.nurture.models.requestModels.RegisterRequestModels
import com.zat.nurture.utils.source.DataRepository
import kotlinx.coroutines.launch

class AuthViewModel(val dataRepository: DataRepository, application: Application) :
    BaseViewModel(application) {

    var registerLiveData = MutableLiveData<RegisterMainModel>()


    fun register(registerRequestModels: RegisterRequestModels) {
        viewModelScope.launch {
            when (val apiResponse = dataRepository.register(registerRequestModels)) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            registerLiveData.postValue((apiResponse.value.body()))
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()?.error?.get(0))
                        }
                    }
                }
            }
        }
    }




}