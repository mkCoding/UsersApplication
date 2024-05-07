package com.example.usersapplication.model


import com.google.gson.annotations.SerializedName

data class SupportModel(
    @SerializedName("text")
    val text: String? = "",
    @SerializedName("url")
    val url: String? = ""
)