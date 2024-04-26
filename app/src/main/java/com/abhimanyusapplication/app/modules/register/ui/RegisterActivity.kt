package com.abhimanyusapplication.app.modules.register.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.abhimanyusapplication.app.R
import com.abhimanyusapplication.app.appcomponents.base.BaseActivity
import com.abhimanyusapplication.app.appcomponents.googleauth.GoogleHelper
import com.abhimanyusapplication.app.databinding.ActivityRegisterBinding
import com.abhimanyusapplication.app.modules.home.ui.HomeActivity
import com.abhimanyusapplication.app.modules.login.ui.LoginActivity
import com.abhimanyusapplication.app.modules.register.`data`.viewmodel.RegisterVM
import com.google.firebase.auth.FirebaseAuth
import kotlin.String
import kotlin.Unit

class RegisterActivity : AppCompatActivity() {
  private val viewModel: RegisterVM by viewModels<RegisterVM>()
  private lateinit var binding:ActivityRegisterBinding
  private lateinit var firebaseauth: FirebaseAuth

  private lateinit var googleLogin: GoogleHelper
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding= ActivityRegisterBinding.inflate(layoutInflater)
    setContentView(binding.root)

    firebaseauth=FirebaseAuth.getInstance()

    binding.txtConfirmation.setOnClickListener {
      startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
    }

    binding.btnRegister.setOnClickListener {
      val username=binding.etUsernameInput.text.toString()
      val email=binding.etEmailInput.text.toString()
      val password=binding.etPasswordInput.text.toString()
      if(username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
        firebaseauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
          if(it.isSuccessful){
            startActivity(Intent(this@RegisterActivity,HomeActivity::class.java))
          }
          else{
            Toast.makeText(
              this@RegisterActivity, it.exception?.localizedMessage,
              Toast.LENGTH_SHORT
            ).show()
          }
        }

      }
      else{
        Toast.makeText(this,"Empty Fields Are Not Allowed", Toast.LENGTH_SHORT).show()
      }


    }
  }

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registerVM = viewModel
    googleLogin = GoogleHelper(this,
    { accountInfo ->
      },{ error ->

      })
    }

    override fun setUpClicks(): Unit {

      binding.imageGoogle.setOnClickListener {
        googleLogin.login()
      }
      binding.btnArrowleft.setOnClickListener {
        // TODO please, add your navigation code here
        finish()
      }
      binding.txtConfirmation.setOnClickListener {
        val destIntent = LoginActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "REGISTER_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, RegisterActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
