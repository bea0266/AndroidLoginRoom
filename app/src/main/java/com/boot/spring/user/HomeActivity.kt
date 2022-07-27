package com.boot.spring.user

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
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


        binding.buttonLogout.setOnClickListener {
            finish()
        }

        binding.buttonUsers.setOnClickListener {
            CoroutineScope(IO).launch {
                val users = db.userDao()!!.findAll()

                for (user in users) {
                    Log.d("select users results", "id: ${user.id}\n " +
                            "userId: ${user.userId}\n" +
                            "password: ${user.password}\n" +
                            "name: ${user.name}\n" +
                            "address: ${user.address}" )
                }
            }
        }

        binding.buttonEdit.setOnClickListener {
            finish()
        }

        binding.buttonDelete.setOnClickListener {
            finish()
        }


    }
}