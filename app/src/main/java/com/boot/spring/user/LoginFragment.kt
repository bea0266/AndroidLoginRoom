package com.boot.spring.user

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boot.spring.user.databinding.FragmentLoginBinding
import com.boot.spring.user.domain.LoginDatabase
import com.boot.spring.user.domain.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var db: LoginDatabase
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)

        db = context?.let { LoginDatabase.getInstance(it) }!!

        binding.buttonLogin.setOnClickListener {
           val userId  = binding.etUserId.text.toString()
           val password = binding.etPassword.text.toString()

           CoroutineScope(IO).launch {
               val result = db!!.userDao().findByUserId(userId)
               if(result.password.equals(password)) {
                   val intent = Intent(activity, HomeActivity::class.java)
                   intent.putExtra("userId", result.userId)
                   login = result
                   startActivity(intent)
                   Log.d("login result", "success" )
               } else {
                   Log.d("login result", "fail")
               }
           }
        }

        return view
    }

    companion object {
        lateinit var login : User
    }
}