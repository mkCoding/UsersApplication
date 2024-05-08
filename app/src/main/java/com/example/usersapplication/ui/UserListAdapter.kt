package com.example.usersapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.usersapplication.R
import com.example.usersapplication.databinding.ElementUserBinding
import com.example.usersapplication.model.DataModel
import com.example.usersapplication.model.UserModel

//To create listview Adapter you typically use ListAdapter or its subclass RecycleViewAdapter
class UserListAdapter(
    val userList: List<DataModel?>?
): RecyclerView.Adapter <UserListAdapter.MyViewHolder>() {

    //1 Create view holder class
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ElementUserBinding.bind(itemView)
        fun updateUI(userItemModel: DataModel) {
            //Handle the UI changes based on current state

            binding.apply {
                Glide.with(itemView.context).load(userItemModel.avatar).placeholder(R.drawable.person_icon).into(ivUserPic)
                tvId.text = "Id: ${userItemModel.id}"
                tvEmail.text = "Email:\n${userItemModel.email.toString()}"
                tvFirstname.text  = "Firstname: ${userItemModel.firstName}"
                tvLastname.text = "Lastname: ${userItemModel.lastName}"
            }
        }
    }







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.element_user, parent, false))    }

    override fun onBindViewHolder(holder: UserListAdapter.MyViewHolder, position: Int) {
        userList?.get(position)?.let { holder.updateUI(it) }
    }

    override fun getItemCount(): Int
    {
       return userList?.size ?: 0

    }




}