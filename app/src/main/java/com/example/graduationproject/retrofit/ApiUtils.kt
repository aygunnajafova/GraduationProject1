package com.example.graduationproject.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getFoodsDao() : FoodsDao {
            return RetrofitClients.getClient(BASE_URL).create(FoodsDao::class.java)
        }
    }
}