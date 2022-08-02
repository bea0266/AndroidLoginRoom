package com.boot.spring.user

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.boot.spring.user.LoginFragment.Companion.login
import com.boot.spring.user.databinding.ActivityHomeBinding
import com.boot.spring.user.domain.LoginDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import android.content.Intent as Intent

class HomeActivity : Activity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var db : LoginDatabase
    private lateinit var requires : Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = LoginDatabase.getInstance(applicationContext)!!

        requires = getIntent()

        binding.tvWelcome.text = "${requires.getStringExtra("userId")}님 환영합니다."

        binding.buttonProfile.setOnClickListener {
            val intent = Intent(applicationContext, ProfileActivity::class.java )
            startActivity(intent)
        }

        binding.buttonLogout.setOnClickListener {
            finish()
        }

        binding.buttonUsers.setOnClickListener {
           val intent = Intent(applicationContext, ListActivity::class.java)
           startActivity(intent)
        }

        binding.buttonEdit.setOnClickListener {
            val intent = Intent(applicationContext, EditActivity::class.java)
            intent.putExtra("id", login.id)
            startActivity(intent)
        }

        binding.buttonDelete.setOnClickListener {
            finish()
        }


    }
}