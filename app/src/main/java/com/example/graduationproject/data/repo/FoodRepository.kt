package com.example.graduationproject.data.repo

import com.example.graduationproject.data.datasource.FoodDatasource
import com.example.graduationproject.data.entity.Foods

class FoodRepository(var fds: FoodDatasource) {

    suspend fun add(id:Int, name:String, amount:Int)  = fds.add(id,name,amount)

    suspend fun delete(id:Int) = fds.delete(id)

    suspend fun loadFoods() : List<Foods> = fds.loadFoods()

    suspend fun search(searchText:String) : List<Foods> = fds.search(searchText)
}