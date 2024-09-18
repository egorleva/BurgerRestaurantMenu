package com.yehorlevchenko.data.storage.local.entity

import com.google.gson.annotations.SerializedName

data class RestaurantJsonEntity(
    @SerializedName("name")
    val name: String,

    @SerializedName("address")
    val address: RestaurantAddressJsonEntity,

    @SerializedName("offered_burgers")
    val burgers: List<BurgerJsonEntity>,

    @SerializedName("offered_drinks")
    val drinks: List<DrinkJsonEntity>
)