package com.abhimanyusapplication.app.modules.welcome.`data`.model

import com.abhimanyusapplication.app.R
import com.abhimanyusapplication.app.appcomponents.di.MyApp
import kotlin.String

data class WelcomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtContinueasag: String? =
      MyApp.getInstance().resources.getString(R.string.msg_continue_as_a_g)

)
