package com.coccoc.rssreader

import android.animation.LayoutTransition
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        toolbar.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        toolbar.layoutTransition.setDuration(200L)

        appBarConfiguration = AppBarConfiguration.Builder(R.id.feeds_fragment).build()

        initTheme()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

   private fun initTheme(){
        val appSettings: SharedPreferences = getSharedPreferences("darkModePrefs", 0)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettings.edit()
        val isDarkModeOn: Boolean = appSettings.getBoolean("darkMode", false)

        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            dark_mode_toggle_button?.text = "Disable Dark Mode"

        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            dark_mode_toggle_button?.text = "Enable Dark Mode"
        }

        dark_mode_toggle_button?.setOnClickListener {
            if (isDarkModeOn) {
                dark_mode_toggle_button?.text = "Enable Dark Mode"
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefsEdit.putBoolean("darkMode", false)
                sharedPrefsEdit.apply()
                recreate()
            } else {
                dark_mode_toggle_button?.text = "Disable Dark Mode"
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPrefsEdit.putBoolean("darkMode", true)
                sharedPrefsEdit.apply()
                recreate()
            }
        }
    }
}
