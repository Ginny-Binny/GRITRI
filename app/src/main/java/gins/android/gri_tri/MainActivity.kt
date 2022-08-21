package gins.android.gri_tri
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.firestore.auth.User
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSliderAdapter=ImageSliderAdapter(this)

        val mainImageSlider = findViewById<SliderView>(R.id.main_image_slider);
        mainImageSlider.setSliderAdapter(imageSliderAdapter);
        mainImageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        mainImageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        mainImageSlider.startAutoCycle()

        imageSliderAdapter.renewItems(fetchSliderItemList())


        val wishlistBtn : TextView = findViewById(R.id.tv_wishlist)
        wishlistBtn.setOnClickListener{
            val intent = Intent(this, Wishlist::class.java)
            startActivity(intent)
        }

        val cartBtn : TextView = findViewById(R.id.tv_cart)
        cartBtn.setOnClickListener{
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }

        val categoryGridView: GridView = findViewById(R.id.category_grid)

        println("Hello")

        val categoriesAdapter = ItemListAdapter(this, generateCategories())

        categoryGridView.adapter = categoriesAdapter


    }

    private fun generateCategories() : MutableList<Category> {
        val categoriesList : MutableList<Category> = ArrayList<Category>()
        categoriesList.add(Category("Accessories", R.drawable.watering_can))
        categoriesList.add(Category("Pots", R.drawable.plastic_indoor_flower_pot))
        categoriesList.add(Category("Soils", R.drawable.redsoil))
        categoriesList.add(Category("Indoor Plants", R.drawable.fortuner_jade_pant))
        categoriesList.add(Category("Outdoor Plants", R.drawable.mandevilla))
        categoriesList.add(Category("Flowering Plants", R.drawable.red_hibiscus_plant))

        return categoriesList
    }

    private fun fetchSliderItemList(): List<String>{
        val items= arrayListOf<String>()
        items.add("https://i.imgur.com/uqUZpzr.jpeg")
        items.add("https://i.imgur.com/2Q5Vu2N.jpeg")
        items.add("https://i.imgur.com/eN3qFdk.jpeg")
        return items

    }

}











