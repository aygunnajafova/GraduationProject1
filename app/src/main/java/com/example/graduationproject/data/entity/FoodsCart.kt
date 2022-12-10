package com.example.graduationproject.data.entity

import java.io.Serializable

data class FoodsCart(var cartId:Int,
                     var name:String,
                     var image:String,
                     var price:Int,
                     var category:String,
                     var orderAmount:Int,
                     var userName:String) : Serializable{
}