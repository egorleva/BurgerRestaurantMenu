package com.yehorlevchenko.data.storage.remote.entity

import com.google.gson.annotations.SerializedName

data class RestaurantCountryApiEntity(
    @SerializedName("country_code")
    val code: String,

    @SerializedName("name")
    val name: String
)
