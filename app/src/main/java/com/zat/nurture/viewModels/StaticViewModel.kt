package com.zat.nurture.viewModels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zat.nurture.models.ResultWrapper
import com.zat.nurture.models.requestModels.SupportRequestModel
import com.zat.nurture.models.staticModels.StaticMainModels
import com.zat.nurture.models.supportModels.SupportMainModels
import com.zat.nurture.utils.source.DataRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class StaticViewModel(val dataRepository: DataRepository, application: Application) :
    BaseViewModel(application) {
    var staticLiveData = MutableLiveData<StaticMainModels>()
    var feedSupportLiveData = MutableLiveData<SupportMainModels>()



    fun aboutUS() {
        viewModelScope.launch {
            when (val apiResponse = dataRepository.aboutUs()) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            staticLiveData.postValue(apiResponse.value.body())
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()!!.message)
                        }
                    }
                }
            }
        }
    }

    fun termsAndCondition() {
        viewModelScope.launch {
            when (val apiResponse = dataRepository.termsAndCondition()) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            staticLiveData.postValue(apiResponse.value.body())
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()!!.message)
                        }
                    }
                }
            }
        }
    }

    fun privacyPolicy() {
        viewModelScope.launch {
            when (val apiResponse = dataRepository.privacyPolicy()) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            staticLiveData.postValue(apiResponse.value.body())
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()!!.message)
                        }
                    }
                }
            }
        }
    }

    fun feedSupport(supportRequestModel: SupportRequestModel) {
        MainScope().launch {
            when (val apiResponse = dataRepository.feedSupport(supportRequestModel)) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            feedSupportLiveData.postValue(apiResponse.value.body())
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()?.message)
                        }
                    }
                }
            }

        }

    }

}