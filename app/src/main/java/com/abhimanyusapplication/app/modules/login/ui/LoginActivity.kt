package com.abhimanyusapplication.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.abhimanyusapplication.app.R
import com.abhimanyusapplication.app.appcomponents.base.BaseActivity
import com.abhimanyusapplication.app.appcomponents.googleauth.GoogleHelper
import com.abhimanyusapplication.app.databinding.ActivityLoginBinding
import com.abhimanyusapplication.app.modules.home.ui.HomeActivity
import com.abhimanyusapplication.app.modules.login.`data`.viewmodel.LoginVM
import com.abhimanyusapplication.app.modules.register.ui.RegisterActivity
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
  private val viewModel: LoginVM by viewModels<LoginVM>()

  private lateinit var googleLogin: GoogleHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel
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
        val destIntent = RegisterActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      binding.btnLogin.setOnClickListener {
        val destIntent = HomeActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "LOGIN_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, LoginActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
