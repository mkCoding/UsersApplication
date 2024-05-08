package com.example.usersapplication.repository

import com.example.usersapplication.data.api.RetrofitInstance

class UserRepository {
    suspend fun getUsers () = RetrofitInstance.apiClient.getUsers()

}