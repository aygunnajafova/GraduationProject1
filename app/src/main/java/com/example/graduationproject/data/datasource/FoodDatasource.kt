package com.example.graduationproject.data.datasource

import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDatasource(var fdao: FoodsDao) {
    suspend fun loadFoods() : List<Foods> =
        withContext(Dispatchers.IO) {
            fdao.loadFoods().foods
    }
}