package com.boot.spring.user

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.boot.spring.user.adapter.UsersAdapter
import com.boot.spring.user.databinding.ActivityListBinding
import com.boot.spring.user.domain.LoginDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ListActivity : Activity() {
    private lateinit var binding : ActivityListBinding

    private lateinit var userAdapter : UsersAdapter

    private lateinit var db : LoginDatabase
    private lateinit var verticalManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        db = LoginDatabase.getInstance(applicationContext)!!

        CoroutineScope(IO).launch {
            val users = db.userDao()!!.findAll()
            Log.d("users result size", users.size.toString())
            userAdapter = UsersAdapter(users)
            verticalManager = LinearLayoutManager(this@ListActivity)
            verticalManager.orientation = LinearLayoutManager.VERTICAL

            binding.userRecyclerView.apply {
                layoutManager = verticalManager
                adapter = userAdapter
            }

        }

    }
}