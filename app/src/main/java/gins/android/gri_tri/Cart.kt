package gins.android.gri_tri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class Cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val addNowBtn : FrameLayout = findViewById(R.id.button_cart)
        addNowBtn.setOnClickListener{
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            onBackPressed()
        }
    }
}