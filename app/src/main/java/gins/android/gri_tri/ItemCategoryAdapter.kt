package gins.android.gri_tri

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemCategoryAdapter(private val context: Context) :
    RecyclerView.Adapter<ItemCategoryAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemCategoryAdapter.CategoryViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemCategoryAdapter.CategoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class CategoryViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}