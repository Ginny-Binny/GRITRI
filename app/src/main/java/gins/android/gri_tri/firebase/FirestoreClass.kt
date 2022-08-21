package gins.android.gri_tri.firebase

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import gins.android.gri_tri.MainActivity
import gins.android.gri_tri.SignInActivity
import gins.android.gri_tri.SignUpActivity
import gins.android.gri_tri.models.User
import gins.android.gri_tri.utils.Constants

class FirestoreClass {
    private val  mFirestore = FirebaseFirestore.getInstance()

    fun registerUser(activity:SignUpActivity, userinfo: gins.android.gri_tri.models.User){
        mFirestore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(userinfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }.addOnFailureListener {
                Log.e(activity.javaClass.simpleName, "Error writing the document")
            }

    }

    fun loadUserData(activity: Activity){
        mFirestore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener {document->
                val loggedInUser= document.toObject(User::class.java)!!

                when(activity){
                    is SignInActivity ->{
                        activity.signInSuccess(loggedInUser)
                    }

                }


            }.addOnFailureListener {
                    e->
                when(activity){
                    is SignInActivity ->{
                        activity.hideProgressDialog()
                    }

                }
                Log.e(activity.javaClass.simpleName, "Error writing the document",e)
            }
    }
    fun getCurrentUserId(): String{
        var currentUser= FirebaseAuth.getInstance().currentUser
        var currentUserID=""
        if (currentUser!=null){
            currentUserID=currentUser.uid
        }
        return currentUserID
    }
}