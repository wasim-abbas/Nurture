package com.zat.nurture.utils.source

import android.content.Context
import android.util.Log
import com.zat.nurture.models.ResultWrapper
import com.zat.nurture.models.requestModels.RegisterRequestModels
import com.zat.nurture.models.requestModels.SupportRequestModel
import retrofit2.HttpException
import java.io.IOException

class DataRepository(private var context: Context) {

    private var apiCaller = RetrofitClient(context).getService()

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultWrapper<T> {
        try {
            return ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            return when (throwable) {
                is IOException -> {
                    Log.d("laksjdcas", throwable.toString())
                    ResultWrapper.NetworkError
                }
                is HttpException -> {
                    Log.d("laksjdcas", throwable.toString())
                    val code = throwable.code()
                    val errorResponse = throwable.toString()

                    ResultWrapper.GenericError(code, errorResponse)
                }
                else -> {
                    Log.d("laksjdcas", throwable.toString())
                    ResultWrapper.GenericError(null, throwable.message)
                }
            }

        }
    }

    //code here for login api
//    suspend fun login(loginRequestModel: LoginRequestModel) =
//        safeApiCall { apiCaller.login(loginRequestModel) }

    suspend fun register(registerRequestModels: RegisterRequestModels) =
        safeApiCall { apiCaller.register(registerRequestModels) }

    suspend fun getAllProducts() = safeApiCall { apiCaller.getAllProducts() }

    suspend fun aboutUs() = safeApiCall { apiCaller.aboutUS() }

    suspend fun termsAndCondition() = safeApiCall { apiCaller.termsAndCondition() }
    suspend fun privacyPolicy() = safeApiCall { apiCaller.privacyPolicy() }

    suspend fun feedSupport(supportRequestModel: SupportRequestModel) =
        safeApiCall { apiCaller.feedSupport(supportRequestModel) }

    suspend fun getCategory() = safeApiCall {
        apiCaller.getCategories()
    }

    suspend fun getProductByID(product_id:Int) = safeApiCall {
        apiCaller.getbyProductId(product_id)
    }

    suspend fun getByCategory(category_id:Int) = safeApiCall {
        apiCaller.getbyCategory(category_id)
    }


}

























