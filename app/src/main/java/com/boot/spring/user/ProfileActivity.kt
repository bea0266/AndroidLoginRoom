package com.boot.spring.user

import android.app.Activity
import android.os.Bundle
import com.boot.spring.user.LoginFragment.Companion.login
import com.boot.spring.user.databinding.ActivityProfileBinding
import com.boot.spring.user.domain.LoginDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ProfileActivity : Activity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var db: LoginDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvUserId.text = login.userId
        binding.tvPassword.text = login.password
        binding.tvName.text = login.name
        binding.tvAddress.text = login.address


    }


}