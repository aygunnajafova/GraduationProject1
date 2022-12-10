package com.example.graduationproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(var frepo: FoodRepository) : ViewModel() {

    fun delete(id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            frepo.delete(id)

        }
    }
}