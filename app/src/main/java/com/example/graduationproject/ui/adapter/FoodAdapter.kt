package com.example.graduationproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.databinding.HomeCardDesignBinding
import com.example.graduationproject.ui.fragments.HomeFragmentDirections
import com.example.graduationproject.utill.go

class FoodAdapter(var mContext: Context, var foodsList:List<Foods>)
    : RecyclerView.Adapter<FoodAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(var binding:HomeCardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding:HomeCardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.home_card_design, parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food = foodsList.get(position)
        val b = holder.binding
        b.food = food

        b.cardViewHome.setOnClickListener {
            val transition = HomeFragmentDirections.toDetail(food = food)
            Navigation.go(it,transition)
        }

        //var url = "http://kasimadalan.pe.hu/foods/images/${food.image}"
        //Glide.with().load(url).override(300,300).into(b.imageView)
    }

    override fun getItemCount(): Int {
        return foodsList.size
    }
}