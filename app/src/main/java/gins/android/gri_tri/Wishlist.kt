package gins.android.gri_tri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class Wishlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)


        val shopNowBtn : FrameLayout = findViewById(R.id.button_wishlist)
        shopNowBtn.setOnClickListener{
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            onBackPressed()
        }
    }
}