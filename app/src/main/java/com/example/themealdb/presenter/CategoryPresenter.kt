package com.example.themealdb.presenter

import com.example.themealdb.MealContract
import com.example.themealdb.model.CategoryModel
import com.example.themealdb.network.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CategoryPresenter(var viewCategories: MealContract.MealView<CategoryModel>?) :
    MealContract.MealPresenter {

    private val retrofitClient = RetrofitClient.getMealClient
    private val call = retrofitClient.getMealCategories()
    private val compositeDisposable = CompositeDisposable()

    override fun getCategory() {
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess,this::handleError)
        )
    }

    override fun onDestroyed() {
        viewCategories = null}

    private fun handleSuccess(categoryModel : CategoryModel) {
        viewCategories?.showCategory(categoryModel)
    }

    private fun handleError(t: Throwable) {
        viewCategories?.showError(t)

    }
}

