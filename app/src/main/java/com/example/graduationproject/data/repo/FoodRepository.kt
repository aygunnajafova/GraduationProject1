package com.example.graduationproject.data.repo

import com.example.graduationproject.data.datasource.FoodDatasource
import com.example.graduationproject.data.entity.Foods

class FoodRepository(var fds: FoodDatasource) {
    suspend fun loadFoods() : List<Foods> = fds.loadFoods()

    suspend fun search(searchText:String) : List<Foods> = fds.search(searchText)
}