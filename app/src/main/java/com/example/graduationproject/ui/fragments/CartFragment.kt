package com.example.graduationproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.FoodsCart
import com.example.graduationproject.databinding.FragmentCartBinding
import com.example.graduationproject.ui.adapter.FoodCartAdapter
import com.example.graduationproject.ui.viewmodel.CartViewModel
import com.example.graduationproject.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        binding.cartFragment = this
        binding.toolbarCartTitle = "Cart"

        val foodsCartList = ArrayList<FoodsCart>()
        val f1 = FoodsCart(9,"Sutlac","sutlac.png",6,"Desserts",5,"Aygun")
        val f2 = FoodsCart(6,"Pizza","pizza.png",9,"Meals",5,"Aygun")
        val f3 = FoodsCart(14,"Water","water.png",1,"Drinks",5,"Aygun")
        foodsCartList.add(f1)
        foodsCartList.add(f2)
        foodsCartList.add(f3)

        val adapter = FoodCartAdapter(requireContext(),foodsCartList, viewModel)
        binding.foodCartAdapter = adapter

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
    }
}