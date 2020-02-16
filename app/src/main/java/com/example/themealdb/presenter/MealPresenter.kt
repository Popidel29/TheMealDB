package com.example.themealdb.presenter

import com.example.themealdb.MealContract
import com.example.themealdb.model.CategoryModel
import com.example.themealdb.model.MealModel
import com.example.themealdb.network.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MealPresenter(var viewMeals: MealContract.MealView<MealModel>?, var strCategory: String) :
    MealContract.MealPresenter {

    private val retrofitClient = RetrofitClient.getMealClient
    private val call = retrofitClient.getMealDescription(strCategory)
    private val compositeDisposable = CompositeDisposable()

    override fun getCategory() {
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError))
    }


    private fun handleSuccess(mealModel: MealModel) {
        viewMeals?.showCategory(mealModel)
    }

    private fun handleError(t: Throwable) {
        viewMeals?.showError(t)
    }

    override fun onDestroyed() {
        viewMeals = null
    }
}