package com.example.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themealdb.R
import com.example.themealdb.model.MealModel
import kotlinx.android.synthetic.main.meals_list.view.*

class MealAdapter (private val mealModel: MealModel) : RecyclerView.Adapter<MealAdapter.mealViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mealViewHolder {
        return mealViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.meals_list, parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mealModel.meals.size
    }

    override fun onBindViewHolder(holder: mealViewHolder, position: Int) {
        holder.mealName.text = mealModel.meals[position].strMeal
        Glide.with(holder.imgMeal.context).load(mealModel.meals[position].strMealThumb).into(holder.imgMeal)

    }
    class mealViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val mealName = itemView.mealName
        val imgMeal = itemView.imgMeal


    }


}