package com.yehorlevchenko.data.storage.remote.entity

import com.google.gson.annotations.SerializedName

data class RestaurantAddressApiEntity(
    @SerializedName("street")
    val street: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("country")
    val country: RestaurantCountryApiEntity
)
