package com.example.graduationproject.retrofit

import com.example.graduationproject.data.entity.CRUDResponse
import com.example.graduationproject.data.entity.FoodsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {
    //http://kasimadalan.pe.hu/foods/getAllFoods.php

    @GET("foods/getAllFoods.php")
    suspend fun loadFoods() : FoodsResponse

    @POST("foods/searchFoods.php")
    @FormUrlEncoded
    suspend fun search(@Field("name") searchText: String) : FoodsResponse

    @POST("foods/addFoods.php")
    @FormUrlEncoded
    suspend fun add(@Field("id") id: Int,
                    @Field("name") searchText: String,
                    @Field("amount") amount: Int) : CRUDResponse

    @POST("foods/deleteFoods.php")
    @FormUrlEncoded
    suspend fun delete(@Field("id") id: Int) : CRUDResponse

}