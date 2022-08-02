package com.boot.spring.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.boot.spring.user.databinding.FragmentJoinBinding
import com.boot.spring.user.domain.LoginDatabase
import com.boot.spring.user.domain.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class JoinFragment : Fragment() {
    private lateinit var db: LoginDatabase
    private lateinit var binding: FragmentJoinBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_join, container, false)
        binding = FragmentJoinBinding.bind(view)

        db = context?.let { LoginDatabase.getInstance(it) }!!

        binding.buttonJoin.setOnClickListener {
            val userId = binding.etUserId.text.toString()
            val password = binding.etPassword.text.toString()
            val name = binding.etName.text.toString()
            val address = binding.etAddress.text.toString()

            val user = User(null, userId, password, name, address)

            CoroutineScope(IO).launch {
                db!!.userDao().addUser(user)
            }
            Toast.makeText(context, "가입에 성공하였습니다. 로그인을 해주세요",
                Toast.LENGTH_SHORT).show()

        }
        return view
    }
}