package com.abhimanyusapplication.app.modules.home.`data`.model

import com.abhimanyusapplication.app.R
import com.abhimanyusapplication.app.appcomponents.di.MyApp
import kotlin.String

data class HomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcomeToFloo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_welcome_to_floo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOffer: String? = MyApp.getInstance().resources.getString(R.string.msg_20_off_on_your)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategories: String? = MyApp.getInstance().resources.getString(R.string.lbl_categories)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHardwood: String? = MyApp.getInstance().resources.getString(R.string.lbl_hardwood)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLaminate: String? = MyApp.getInstance().resources.getString(R.string.lbl_laminate)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTiles: String? = MyApp.getInstance().resources.getString(R.string.lbl_tiles)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVinyl: String? = MyApp.getInstance().resources.getString(R.string.lbl_vinyl)

)
