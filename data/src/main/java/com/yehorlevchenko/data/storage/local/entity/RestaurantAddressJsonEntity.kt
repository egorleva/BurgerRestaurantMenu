package com.yehorlevchenko.data.storage.local.entity

import com.google.gson.annotations.SerializedName

data class RestaurantAddressJsonEntity(
    @SerializedName("street")
    val street: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("country")
    val country: RestaurantCountryJsonEntity
)
