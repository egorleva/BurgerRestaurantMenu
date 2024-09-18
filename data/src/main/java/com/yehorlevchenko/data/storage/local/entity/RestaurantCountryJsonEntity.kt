package com.yehorlevchenko.data.storage.local.entity

import com.google.gson.annotations.SerializedName

data class RestaurantCountryJsonEntity(
    @SerializedName("country_code")
    val code: String,

    @SerializedName("name")
    val name: String
)
