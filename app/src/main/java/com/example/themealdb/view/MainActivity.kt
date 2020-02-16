package com.example.themealdb.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themealdb.*
import com.example.themealdb.adapter.CategoryAdapter
import com.example.themealdb.adapter.ClickAction
import com.example.themealdb.model.CategoryModel
import com.example.themealdb.network.KEY_VALUE
import com.example.themealdb.presenter.CategoryPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MealContract.MealView<CategoryModel>,
    ClickAction {

    private lateinit var categoryPresenter: CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryPresenter = CategoryPresenter(this)
        categoryPresenter.getCategory()
    }

    override fun showCategory(mealModel: CategoryModel) {
        recyclerViewCategories.adapter =
            CategoryAdapter(mealModel, this)
        recyclerViewCategories.layoutManager = LinearLayoutManager(parent)
    }

    override fun showError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(strCategory: String) {
        val intent = Intent(this, MealDescription::class.java)
        intent.putExtra(KEY_VALUE, strCategory)
        startActivity(intent)
    }

    override fun onDestroy() {
        categoryPresenter.onDestroyed()
        super.onDestroy()
    }

}