package com.boot.spring.user

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.boot.spring.user.LoginFragment.Companion.login
import com.boot.spring.user.databinding.ActivityEditBinding
import com.boot.spring.user.domain.LoginDatabase
import com.boot.spring.user.domain.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.sql.SQLException
import kotlin.properties.Delegates

class EditActivity : Activity() {
    private lateinit var binding : ActivityEditBinding
    private lateinit var db: LoginDatabase
    private lateinit var userId: String
    private lateinit var password: String
    private var id by Delegates.notNull<Long>()
    private lateinit var name: String
    private lateinit var address: String
    private lateinit var loginIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etUserId.setText(login.userId)
        binding.etPassword.setText(login.password)
        binding.etName.setText(login.name)
        binding.etAddress.setText(login.address)
        loginIntent = getIntent()
        db = LoginDatabase.getInstance(applicationContext)!!

        binding.buttonUpdate.setOnClickListener {
            id = loginIntent.getLongExtra("id", 0)
            userId = binding.etUserId.text.toString()
            password = binding.etPassword.text.toString()
            name = binding.etName.text.toString()
            address = binding.etAddress.text.toString()

            val user = User(id, userId, password, name, address)
            CoroutineScope(IO).launch {
                try {
                    db.userDao()!!.updateUser(user)

                } catch(e: SQLException) {
                    Log.e("[update user]", "faiied user Update")
                    Toast.makeText(applicationContext, "수정을 완료할 수 없습니다.", Toast.LENGTH_SHORT).show()
                }


            }
            finish()
        }



    }
}