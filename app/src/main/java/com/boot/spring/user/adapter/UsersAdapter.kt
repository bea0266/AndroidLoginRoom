package com.boot.spring.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.boot.spring.user.R
import com.boot.spring.user.domain.User

class UsersAdapter (private var list: List<User>) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    inner class UserViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvId = view.findViewById<TextView>(R.id.tvId)
        val tvUserId = view.findViewById<TextView>(R.id.tvUserId)
        val tvPassword = view.findViewById<TextView>(R.id.tvPassword)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvAddress = view.findViewById<TextView>(R.id.tvAddress)

        fun bind(position: Int) {
            tvId.text = list.get(position).id.toString()
            tvUserId.text = list.get(position).userId
            tvPassword.text = list.get(position).password
            tvName.text = list.get(position).name
            tvAddress.text = list.get(position).address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}