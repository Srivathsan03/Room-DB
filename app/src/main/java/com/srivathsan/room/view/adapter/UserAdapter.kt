package com.srivathsan.room.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.srivathsan.room.R
import com.srivathsan.room.model.response.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]
        holder.itemView.tvUsername.text = user.name
        holder.itemView.tvEmail.text = user.email
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view)
}