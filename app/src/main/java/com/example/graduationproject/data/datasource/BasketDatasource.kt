package com.example.graduationproject.data.datasource

import android.util.Log
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsCart
import com.example.graduationproject.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BasketDatasource(var fdao: FoodsDao) {
    companion object {
        const val USERNAME = "aygun"
        const val TAG = "BasketDatasource"
    }

    suspend fun loadBasket() : List<FoodsCart> =
        withContext(Dispatchers.IO) {
            fdao.getCartFoods(USERNAME).foods_cart
        }

    suspend fun add(food: Foods, amount:Int) {
        try {
            fdao.add(food.name, food.image, food.price, food.category, amount, USERNAME)
        } catch (ex: Exception) {
            Log.e(TAG, "Failed to add", ex)
        }
    }

    suspend fun delete(id:Int) {
        try {
            fdao.delete(id, USERNAME)
        } catch (ex: Exception) {
            Log.e(TAG, "Failed to delete", ex)
        }
    }
}