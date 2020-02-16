package com.example.themealdb.model

import com.google.gson.annotations.SerializedName


data class CategoryModel(

    @SerializedName("categories")
    val categories: List<Category>
)