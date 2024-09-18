package com.yehorlevchenko.data.storage.remote.entity

import com.google.gson.annotations.SerializedName

data class DrinkApiEntity(
    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("price")
    val price: Double,

    @SerializedName("allergens")
    val allergens: List<String>?,

    @SerializedName("img")
    val imageUrl: String
)