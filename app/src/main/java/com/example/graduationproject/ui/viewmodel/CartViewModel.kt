package com.example.graduationproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.repo.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(var brepo: BasketRepository) : ViewModel() {
    val items = brepo.items

    fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            brepo.reload()
        }
    }

    fun delete(id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            brepo.delete(id)
        }
    }
}