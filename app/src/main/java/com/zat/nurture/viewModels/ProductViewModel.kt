package com.zat.nurture.viewModels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zat.nurture.models.ResultWrapper
import com.zat.nurture.models.allProductmodels.AllProductsMainModel
import com.zat.nurture.models.categoriesModels.CategoriesMainModel
import com.zat.nurture.models.product_byID.GetPRoductbyIdMAinModel
import com.zat.nurture.utils.source.DataRepository
import kotlinx.coroutines.launch

class ProductViewModel(val dataRepository: DataRepository, application: Application) :
    BaseViewModel(application) {

    var allProductsLiveData = MutableLiveData<AllProductsMainModel>()
    var categoryLiveData = MutableLiveData<CategoriesMainModel>()
    var getProductByIdLiveData = MutableLiveData<GetPRoductbyIdMAinModel>()


    fun getAllProducts() {
        viewModelScope.launch {
            when (val apiResponse = dataRepository.getAllProducts()) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            allProductsLiveData.postValue(apiResponse.value.body())
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()!!.message)
                        }
                    }
                }
            }
        }
    }


    fun getCategory() {
        viewModelScope.launch {
            when (val apiResponse = dataRepository.getCategory()) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            categoryLiveData.postValue(apiResponse.value.body())
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()!!.message)
                        }
                    }
                }
            }
        }
    }

    fun getProductbyID(product_id: Int) {
        viewModelScope.launch {
            when (val apiResponse = dataRepository.getProductByID(product_id)) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            getProductByIdLiveData.postValue(apiResponse.value.body())
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()!!.message)
                        }
                    }
                }
            }
        }
    }

    fun getbyCategory(category_id: Int) {
        viewModelScope.launch {
            when (val apiResponse = dataRepository.getByCategory(category_id)) {
                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
                is ResultWrapper.Success -> {
                    if (apiResponse.value.code() == 401) {
                        errorLiveData.postValue("Unauthenticated User")
                    } else {
                        if (apiResponse.value.code() == 200) {
                            allProductsLiveData.postValue(apiResponse.value.body())
                        } else {
                            errorLiveData.postValue(apiResponse.value.body()!!.message)
                        }
                    }
                }
            }
        }
    }
}