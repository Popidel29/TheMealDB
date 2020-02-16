package com.example.themealdb

interface MealContract {
    interface MealPresenter {

        fun getCategory()
        fun onDestroyed()
    }

    interface MealView<T> {
        fun showCategory(mealModel : T)
        fun showError(t : Throwable)
    }
}