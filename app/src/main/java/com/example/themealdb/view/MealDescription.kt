package com.example.themealdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themealdb.adapter.MealAdapter
import com.example.themealdb.MealContract
import com.example.themealdb.R
import com.example.themealdb.model.MealModel
import com.example.themealdb.network.KEY_VALUE
import com.example.themealdb.presenter.MealPresenter
import kotlinx.android.synthetic.main.activity_meal_description.*

class MealDescription : AppCompatActivity(), MealContract.MealView<MealModel> {
    private lateinit var presenter : MealContract.MealPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_description)

        val categoryName = intent.getStringExtra(KEY_VALUE)
        presenter = MealPresenter(this,categoryName)
        presenter.getCategory()
    }

    override fun showCategory(mealModel: MealModel) {
        recyclerViewMeals.adapter =
            MealAdapter(mealModel)
        recyclerViewMeals.layoutManager = LinearLayoutManager(parent)
    }


    override fun showError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
    }


}
