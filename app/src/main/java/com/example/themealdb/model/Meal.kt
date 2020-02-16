package com.example.themealdb.model


import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal")
    val idMeal: Int,
    @SerializedName("strMeal")
    val strMeal: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String
)