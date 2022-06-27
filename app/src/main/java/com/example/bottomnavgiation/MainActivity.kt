package com.example.bottomnavgiation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavgiation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity() {
       private lateinit var binding: ActivityMainBinding

       lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //For implementation of  bottom navigation bar
        val navhost=
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController=navhost.navController
        binding.bottomNavigationView.setupWithNavController(navController)


        //For adding Drawer Nav Menu
        toggle=ActionBarDrawerToggle(this,binding.drawerlayout,R.string.open,R.string.close)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //licklisner on Items

        binding.drawer1.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1->
                    Toast.makeText(applicationContext,"Clicked Item 1",Toast.LENGTH_LONG).show()
                R.id.item2->
                    Toast.makeText(applicationContext,"Clicked Item 2",Toast.LENGTH_LONG).show()
                R.id.item3->
                    Toast.makeText(applicationContext,"Clicked Item 3",Toast.LENGTH_LONG).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}