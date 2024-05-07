package com.example.usersapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.usersapplication.R
import com.example.usersapplication.databinding.FragmentUserBinding


/**
 * A simple [Fragment] subclass.
 * Use the [UserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding
     lateinit var userListAdapter:UserListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserBinding.inflate(layoutInflater, container, false)
        var root = binding.root

        val userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

//        userViewModel.userList.observe(viewLifecycleOwner) {
//            Log.i("Data_User", "${it.data?.get(0)?.id} - ${it.data?.get(0)?.email} - ${it.data?.get(0)?.firstName} - ${it.data?.get(0)?.lastName} - ${it.data?.get(0)?.avatar}"
//            )
//        }

        userViewModel.getAllUsers()
        userViewModel.userList.observe(viewLifecycleOwner){
            binding.rvUsers.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = UserListAdapter (it.data)
            }
        }

        return root

    }



}