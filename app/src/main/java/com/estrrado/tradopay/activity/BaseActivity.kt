package com.estrrado.tradopay.activity

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
/*import com.neyyar.learning.helpers.IDLogger
import com.neyyar.learning.helpers.Preferences*/
import java.util.*

/**
 * Wrapper class for all activities. This will include common functions  applicable to all the
 * activities. In onCreate, we will set the language as per shared preferences.
 *
 * Before making any changes, please talk to author
 *
 * @author Vishnu Mohan
 * @Date   11 Nov 2020
 */
abstract class BaseActivity: AppCompatActivity() {
    //lateinit var preferences: Preferences
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //preferences = Preferences.getInstance(this)

        // All activities are using full screen layout. So hide the actionbar
        supportActionBar?.hide()

        // If phone version is less than O, set the  language using updateConfiguration(). For
        // other devices, see attachBaseContext()

        initLayout()
        initListeners()
        initObservers()
    }

    override fun attachBaseContext(newBase: Context?) {
      //  preferences = Preferences.getInstance(newBase!!)

        // Get localized context
        super.attachBaseContext(newBase)
    }

    /**
     * Method for setting the language  for devices  having android version  from O. This will
     * create a context based on locale and return it
     *
     * @param newBase The current context
     *
     * @return Localized context
     */


    /**
     * Method to set language for older devices. This will get the app  language from settings
     * and update the app using this locale.
     */


    /**
     * Activity layout initialization related code goes here. View component initialization if
     * any etc will be set here
     */
    abstract fun initLayout()

    /**
     * Method to initialize all listeners
     */
    abstract fun initListeners()

    /**
     * Method to initialize observers
     */
    abstract fun initObservers()

    companion object {
        private const val TAG = "BaseActivity"
    }
}