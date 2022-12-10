package com.example.graduationproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.repo.BasketRepository
import com.example.graduationproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(var brepo: BasketRepository) : ViewModel() {
    val amount = MutableLiveData(0)

    fun increment() {
        amount.value = (amount.value ?: 0) + 1
    }

    fun decrement() {
        if ((amount.value ?: 0) > 0)
            amount.value = amount.value!! - 1
    }

    fun add(food: Foods) {
        CoroutineScope(Dispatchers.Main).launch {
            brepo.add(food, amount.value!!)
        }
    }
}