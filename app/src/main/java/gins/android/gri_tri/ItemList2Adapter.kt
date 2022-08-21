package gins.android.gri_tri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemList2Adapter : RecyclerView.Adapter<ItemList2Adapter.ItemViewHolder>() {


    class ItemViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ItemViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout2,parent,false)

    )


    override fun getItemCount() : Int{
        return 5
    }

    override fun onBindViewHolder(holder: ItemViewHolder,position:Int){

    }
}