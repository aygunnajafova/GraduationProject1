package com.example.graduationproject.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.graduationproject.data.datasource.BasketDatasource
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsCart

class BasketRepository(var bds: BasketDatasource) {
    val items = MutableLiveData<List<FoodsCart>>(emptyList())

    suspend fun reload() {
        items.value = bds.loadBasket()
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