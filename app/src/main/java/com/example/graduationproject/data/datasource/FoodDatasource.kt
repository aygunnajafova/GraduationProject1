package com.example.graduationproject.data.datasource

import android.util.Log
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDatasource(var fdao: FoodsDao) {
    suspend fun add(id:Int, name:String, amount:Int) = fdao.add(id, name, amount)

    suspend fun delete(id:Int) = fdao.delete(id)

    suspend fun loadFoods() : List<Foods> =
        withContext(Dispatchers.IO) {
            fdao.loadFoods().foods
    }

    suspend fun search(searchText:String) : List<Foods> =
        withContext(Dispatchers.IO) {
            fdao.search(searchText).foods
        }
}