package com.example.graduationproject.retrofit

import com.example.graduationproject.data.entity.CRUDResponse
import com.example.graduationproject.data.entity.CartFoodResponse
import com.example.graduationproject.data.entity.FoodsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {
    //http://kasimadalan.pe.hu/foods/getAllFoods.php

    @GET("foods/getAllFoods.php")
    suspend fun loadFoods() : FoodsResponse

    @POST("foods/getFoodsCart.php")
    @FormUrlEncoded
    suspend fun getCartFoods(@Field("userName") userName : String) : CartFoodResponse

    @POST("foods/insertFood.php")
    @FormUrlEncoded
    suspend fun add(@Field ("name") name : String,
                    @Field ("image") image : String,
                    @Field ("price") price : Int,
                    @Field ("category") category : String,
                    @Field ("orderAmount") orderAmount : Int,
                    @Field ("userName") userName : String) : CRUDResponse

    @POST("foods/deleteFood.php")
    @FormUrlEncoded
    suspend fun delete(@Field("cartId") cartId: Int,
                       @Field ("userName") userName : String) : CRUDResponse

}