package com.boot.spring.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import com.boot.spring.user.databinding.ActivityMainBinding
import com.boot.spring.user.domain.LoginDatabase

/*  앞으로 해야 할 일
 *  1. room database
 *      1.1 회원가입 구현 ( insert 처리 완료 )
 *      1.2 로그인 구현(완료)
 *      1.3 crud 적용
 *       1.3.1 read(select) - 유저 recyclerview 구현
 *
 *  2. viewmodel 사용
 *  3. retrofit2 추가 repository 구현
 *  4. hilt 적용 (dagger)
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: LoginDatabase
    val fragmentJoin = JoinFragment()
    val fragmentLogin = LoginFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonJoinView.setOnClickListener {
            setChangeView(JOIN_FRAGMENT)
        }

        binding.buttonLoginView.setOnClickListener {
            setChangeView(LOGIN_FRAGMENT)
        }

    }

    fun setChangeView(fragment: String): Unit {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            when (fragment) {
                JOIN_FRAGMENT -> {
                    replace(R.id.container, fragmentJoin)
                    now = JOIN_FRAGMENT
                }
                LOGIN_FRAGMENT -> {
                    replace(R.id.container, fragmentLogin)
                    now = LOGIN_FRAGMENT
                }
            }
        }
    }

    companion object {
        val JOIN_FRAGMENT = "joinFragment"
        val LOGIN_FRAGMENT = "loginFragment"
        var now = JOIN_FRAGMENT

    }

}




