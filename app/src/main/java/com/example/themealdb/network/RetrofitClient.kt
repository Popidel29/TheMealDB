package com.example.themealdb.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private val retrofitInstance by lazy {
        Retrofit.Builder()
             .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

        val getMealClient: MealClient by lazy {
        retrofitInstance.create(MealClient::class.java)
    }
}