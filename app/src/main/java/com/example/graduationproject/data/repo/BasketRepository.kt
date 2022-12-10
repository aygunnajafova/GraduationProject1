package com.example.graduationproject.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.graduationproject.data.datasource.BasketDatasource
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsCart

class BasketRepository(var bds: BasketDatasource) {
    companion object {
        const val TAG = "BasketRepository"
    }

    val items = MutableLiveData<List<FoodsCart>>(emptyList())

    suspend fun reload() {
        try {
            items.value = bds.loadBasket()
        } catch (ex: Exception) {
            Log.e(TAG, "Failed to reload", ex)
        }
    }

    suspend fun add(food: Foods, amount: Int) {
        bds.add(food, amount)
        reload()
    }

    suspend fun delete(id: Int) {
        bds.delete(id)
        reload()
    }
}