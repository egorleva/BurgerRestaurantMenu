package com.yehorlevchenko.data.storage.remote.entity

import com.google.gson.annotations.SerializedName

data class BurgerInfoApiEntity(
    @SerializedName("in_stock")
    val inStock: Boolean?,

    @SerializedName("vegetarian")
    val isVegetarian: Boolean,

    @SerializedName("allergens_contained_in")
    val allergensContainedIn: List<String>?,

    @SerializedName("availableSince")
    val availableSince: Long?,

    @SerializedName("available_until")
    val availableUntil: String?,

    @SerializedName("img")
    val imageUrl: String
)
