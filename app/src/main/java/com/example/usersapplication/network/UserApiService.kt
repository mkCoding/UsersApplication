package com.example.usersapplication.network

import com.example.usersapplication.data.api.ApiDetails
import com.example.usersapplication.model.UserModel
import retrofit2.http.GET

interface UserApiService {

    @GET(ApiDetails.USERS_ENDPOINT)
//    suspend fun getUsers(): List<DataModel?>?
    suspend fun getUsers(): UserModel

}