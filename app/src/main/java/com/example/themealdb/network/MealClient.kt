package com.example.themealdb.network

import com.example.themealdb.model.CategoryModel
import com.example.themealdb.model.MealModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MealClient {

    @GET("categories.php")
    fun getMealCategories() : Observable<CategoryModel>

    @GET("filter.php")
    fun getMealDescription(@Query("c") category: String): Observable<MealModel>

}