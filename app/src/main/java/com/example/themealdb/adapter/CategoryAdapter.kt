package com.example.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themealdb.R
import com.example.themealdb.model.CategoryModel
import kotlinx.android.synthetic.main.categories_list.view.*

class CategoryAdapter(
    private val categoryModel: CategoryModel, private val clickAction: ClickAction
)
    : RecyclerView.Adapter<CategoryAdapter.categoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoryViewHolder {
        return categoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.categories_list, parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categoryModel.categories.size
    }

    override fun onBindViewHolder(holder: categoryViewHolder, position: Int) {
        holder.categoryName.text = categoryModel.categories[position].strCategory
        holder.categoryDescription.text = categoryModel.categories[position].strCategoryDescription
        val clickOnCategory =categoryModel.categories[position].strCategory
        holder.bind(clickOnCategory, clickAction)
        Glide.with(holder.imageCategory.context).load(categoryModel.categories[position].strCategoryThumb).into(holder.imageCategory)


    }


    class categoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName = itemView.categoryName
        val categoryDescription = itemView.categoryDescription
        val imageCategory = itemView.imageCategory

        fun bind(categoryName: String, clickAction: ClickAction) {
            itemView.setOnClickListener {
                clickAction.onClick(categoryName)
            }
        }
    }
}