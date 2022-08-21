package gins.android.gri_tri

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemListAdapter(private val context: Context, private val categoriesList: MutableList<Category>) : BaseAdapter() {
    override fun getCount(): Int {
        return categoriesList.size
    }

    override fun getItem(p0: Int): Any {
        return categoriesList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(index: Int, view: View?, viewGroup: ViewGroup?): View {
        val currentView : View = view
            ?: LayoutInflater.from(context).inflate(R.layout.activity_categories,
                viewGroup, false)
        val currentCategory : Category = this.getItem(index) as Category
        val name : String = currentCategory.name
        val imageLoc: Int = currentCategory.imageId

        val image : ImageView = currentView.findViewById(R.id.image_category)
        val caption: TextView = currentView.findViewById(R.id.category_name)

        println(name)

        image.setImageResource(imageLoc)
        caption.text = name

        image.setOnClickListener {
           when(name) {
               "Accessories" -> {
                   val i: Intent = Intent(context, Accessories::class.java)
                   context.startActivity(i)
               }
               "Pots" -> {
                   val i: Intent = Intent(context, Pots::class.java)
                   context.startActivity(i)
               }
               "Soils" -> {
                   val i: Intent = Intent(context, Soils::class.java)
                   context.startActivity(i)
               }
               "Indoor Plants" -> {
                   val i: Intent = Intent(context, IndoorPlants::class.java)
                   context.startActivity(i)
               }
               "Outdoor Plants" -> {
                   val i: Intent = Intent(context, OutdoorPlants::class.java)
                   context.startActivity(i)
               }
               "Flowering Plants" -> {
                   val i: Intent = Intent(context, FloweringPlants::class.java)
                   context.startActivity(i)
               }

           }
        }

        return currentView
    }


}