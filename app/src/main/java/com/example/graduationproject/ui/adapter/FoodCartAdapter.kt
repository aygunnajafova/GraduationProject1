package com.example.graduationproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.FoodsCart
import com.example.graduationproject.databinding.CartCardDesignBinding
import com.example.graduationproject.ui.viewmodel.CartViewModel
import com.google.android.material.snackbar.Snackbar

class FoodCartAdapter(var mContext: Context,
                      var viewModel: CartViewModel,
                      lifecycleOwner: LifecycleOwner)
    : RecyclerView.Adapter<FoodCartAdapter.CartCardDesignHolder>() {

    init {
        viewModel.items.observe(lifecycleOwner) {
            notifyDataSetChanged()
        }
    }

    inner class CartCardDesignHolder(var binding:CartCardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartCardDesignHolder {
        val binding:CartCardDesignBinding =
            DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.cart_card_design, parent, false)
        return CartCardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CartCardDesignHolder, position: Int) {
        val foodCart = viewModel.items.value!![position]
        val b = holder.binding

        b.foodCart = foodCart
        b.imageViewDelete.setOnClickListener {
            Snackbar
                .make(it, "Do you want to remove ${foodCart.name} from cart?", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    viewModel.delete(foodCart.cartId)
                }
                .show()
        }

        val url = "http://kasimadalan.pe.hu/foods/images/${foodCart.image}"
        Glide.with(holder.itemView).load(url).override(300,300).into(b.imageViewCart)
    }

    override fun getItemCount(): Int {
        return viewModel.items.value?.size ?: 0
    }

}