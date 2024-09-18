package com.yehorlevchenko.data.storage.local.entity

import com.google.gson.annotations.SerializedName

data class BurgerJsonEntity(
    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("weight_grams")
    val weightGrams: Int?,

    @SerializedName("price_usd")
    val priceUsd: Double,

    @SerializedName("tags")
    val tags: List<String>?,

    @SerializedName("info")
    val info: BurgerInfoJsonEntity
)
