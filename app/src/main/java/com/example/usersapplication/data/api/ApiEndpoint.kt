package com.example.usersapplication.data.api

import com.example.usersapplication.model.DataModel
import com.example.usersapplication.model.UserModel
import retrofit2.http.GET

interface ApiEndpoint {

    @GET(ApiDetails.USERS_ENDPOINT)
//    suspend fun getUsers(): List<DataModel?>?
    suspend fun getUsers(): UserModel

}