package com.example.graduationproject.data.repo

import android.util.Log
import com.example.graduationproject.data.datasource.FoodDatasource
import com.example.graduationproject.data.entity.Foods

class FoodRepository(var fds: FoodDatasource) {
    companion object {
        const val TAG = "FoodRepository"
    }

    private var cachedFoods: List<Foods> = emptyList()

    suspend fun loadFoods() : List<Foods> {
        try {
            cachedFoods = fds.loadFoods()
        } catch (ex: Exception) {
            Log.e(TAG, "Failed to load foods", ex)
        }
        return cachedFoods
    }

    fun search(searchText:String) : List<Foods> {
        return cachedFoods.filter {
            matches(searchText, it.name) || matches(searchText, it.category)
        }
    }

    /**
     * Returns true if the given query (needle) is satisfied with the content (haystack)
     */
    private fun matches(needle: String, haystack: String): Boolean {
        return haystack.lowercase().contains(needle.lowercase())
    }
}