package com.example.graduationproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(var frepo: FoodRepository) : ViewModel() {

    fun add(id:Int, name:String, amount:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            frepo.add(id,name,amount)
        }
    }
}