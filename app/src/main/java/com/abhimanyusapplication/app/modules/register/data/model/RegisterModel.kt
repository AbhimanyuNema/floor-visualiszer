package com.abhimanyusapplication.app.modules.register.`data`.model

import com.abhimanyusapplication.app.R
import com.abhimanyusapplication.app.appcomponents.di.MyApp
import kotlin.String

data class RegisterModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHelloRegister: String? =
      MyApp.getInstance().resources.getString(R.string.msg_hello_register)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOrRegisterwit: String? =
      MyApp.getInstance().resources.getString(R.string.msg_or_register_wit)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_already_have_an)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etUsernameInputValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etEmailInputValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etPasswordInputValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etConfirmpassworValue: String? = null
)
