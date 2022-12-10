package com.example.graduationproject.data.entity

import java.io.Serializable

data class Foods(var id:Int,
                 var name:String,
                 var image:String,
                 var price:Int,
                 var category:String) : Serializable {
}