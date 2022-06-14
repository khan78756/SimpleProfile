package com.example.bottomnavgiation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavgiation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity() {
       private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView= binding.bottomNavigationView
        val navhost=supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostController
       // val navController=navhost.navController
        NavigationUI.setupWithNavController(navView, navhost)

    }
}