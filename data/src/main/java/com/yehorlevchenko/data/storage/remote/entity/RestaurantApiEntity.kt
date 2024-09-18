package com.yehorlevchenko.data.storage.remote.entity

import com.google.gson.annotations.SerializedName

data class RestaurantApiEntity(
    @SerializedName("name")
    val name: String,

    @SerializedName("address")
    val address: RestaurantAddressApiEntity,

    @SerializedName("offered_burgers")
    val burgers: List<BurgerApiEntity>,

    @SerializedName("offered_drinks")
    val drinks: List<DrinkApiEntity>
)