package com.gitlab.faerytea.sampleapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(val layout: LinearLayout) : RecyclerView.ViewHolder(layout) {
    val userName: TextView = layout.user_name
    val userAge: TextView = layout.user_age
}

class UsersAdapter(val users: List<User>) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            ) as LinearLayout
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val (age, name) = users[position]
        holder.userAge.text = age.toString()
        holder.userName.text = name
        holder.layout.setOnClickListener { with(holder.layout.context) {
            startActivity(createUserIntent(users[holder.adapterPosition]))
        } }
    }

    override fun getItemCount() = users.size
}
