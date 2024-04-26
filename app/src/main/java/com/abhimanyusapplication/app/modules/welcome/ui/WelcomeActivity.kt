package com.abhimanyusapplication.app.modules.welcome.ui

import androidx.activity.viewModels
import com.abhimanyusapplication.app.R
import com.abhimanyusapplication.app.appcomponents.base.BaseActivity
import com.abhimanyusapplication.app.databinding.ActivityWelcomeBinding
import com.abhimanyusapplication.app.modules.home.ui.HomeActivity
import com.abhimanyusapplication.app.modules.login.ui.LoginActivity
import com.abhimanyusapplication.app.modules.register.ui.RegisterActivity
import com.abhimanyusapplication.app.modules.welcome.`data`.viewmodel.WelcomeVM
import kotlin.String
import kotlin.Unit

class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>(R.layout.activity_welcome) {
  private val viewModel: WelcomeVM by viewModels<WelcomeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.welcomeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnLogin.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnRegister.setOnClickListener {
      val destIntent = RegisterActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtContinueasag.setOnClickListener {
      val destIntent = HomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "WELCOME_ACTIVITY"

  }
}
