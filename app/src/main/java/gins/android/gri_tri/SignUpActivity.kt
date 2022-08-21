package gins.android.gri_tri

import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import gins.android.gri_tri.firebase.FirestoreClass
import gins.android.gri_tri.models.User
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setupActionBar()
    }
    fun userRegisteredSuccess(){
        Toast.makeText(
            this, "You have successfully registered the email address", Toast.LENGTH_LONG).show()
        hideProgressDialog()
        FirebaseAuth.getInstance().signOut()
        finish()

    }

    private fun setupActionBar() {
        val toolSignUpActivity = findViewById<Toolbar>(R.id.toolbar_sign_up_activity)
        setSupportActionBar(toolSignUpActivity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)
        }
        toolSignUpActivity.setNavigationOnClickListener { onBackPressed() }

        btn_sign_up.setOnClickListener{
            registerUser()
        }

    }
    private fun registerUser(){
        val name: String = et_name.text.toString().trim { it <= ' ' }
        val email: String = et_email.text.toString().trim { it <= ' ' }
        val password: String = et_password.text.toString()

        if (validateForm(name, email, password)) {
//            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    val firebaseUser: FirebaseUser = task.result!!.user!!
                    val registeredEmail = firebaseUser.email!!
//                    val user= User(firebaseUser.uid, name, registeredEmail)
//
//                    FirestoreClass().registerUser(this, user)

                    Toast.makeText(this, "$name You have successfully registered", Toast.LENGTH_LONG).show()
                    FirebaseAuth.getInstance().signOut()
                    finish()
                }
                else{
                    Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter name.")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter email.")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter password.")
                false
            }
            else -> {
                true
            }

        }
    }
}