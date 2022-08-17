package com.example.redditnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redditnews.R
import com.example.redditnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startFragment(MainFragment())
    }

    private fun startFragment(mainFragment: MainFragment) {
        supportFragmentManager.beginTransaction().replace(
            binding.container.id, mainFragment
        ).commitNow()
    }
}