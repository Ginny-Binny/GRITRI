package gins.android.gri_tri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class IntroActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val btnSignUpIntro: Button= findViewById(R.id.btn_sign_up_intro)
        val btnSignInIntro: Button= findViewById(R.id.btn_sign_in_intro)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btnSignUpIntro.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        btnSignInIntro.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}