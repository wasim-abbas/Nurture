package com.zat.nurture.utils.source

import com.zat.nurture.models.allProductmodels.AllProductsMainModel
import com.zat.nurture.models.categoriesModels.CategoriesMainModel
import com.zat.nurture.models.product_byID.GetPRoductbyIdMAinModel
import com.zat.nurture.models.registerModeld.RegisterMainModel
import com.zat.nurture.models.requestModels.RegisterRequestModels
import com.zat.nurture.models.requestModels.SupportRequestModel
import com.zat.nurture.models.staticModels.StaticMainModels
import com.zat.nurture.models.supportModels.SupportMainModels
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiCaller {

    @POST("api/register")
    suspend fun register(@Body registerRequestModels: RegisterRequestModels):
            Response<RegisterMainModel>

    @GET("api/product")
    suspend fun getAllProducts(): Response<AllProductsMainModel>

    @GET("api/about-us")
    suspend fun aboutUS(): Response<StaticMainModels>

    @GET("api/terms-and-conditions")
    suspend fun termsAndCondition(): Response<StaticMainModels>

    @GET("api/privacy-policy")
    suspend fun privacyPolicy(): Response<StaticMainModels>

    @POST("api/send-feedback-request")
    suspend fun feedSupport(@Body supportRequestModel: SupportRequestModel):Response<SupportMainModels>

    @GET("api/categories")
    suspend fun getCategories(): Response<CategoriesMainModel>

    @GET("api/product/{product_id}")
    suspend fun getbyProductId(@Path ("product_id") product_id:Int ):Response<GetPRoductbyIdMAinModel>

    @GET("api/product/get-by-category/{category_id}")
    suspend fun getbyCategory(@Path ("category_id") category_id:Int):Response<AllProductsMainModel>
}