package com.example.usersapplication.injection

import android.app.Application
import android.content.Context
import com.example.usersapplication.data.api.RetrofitInstance
import com.example.usersapplication.network.UserApiService
import com.example.usersapplication.network.interceptors.CacheInterceptor
import com.example.usersapplication.network.interceptors.LoggingInterceptor
import com.example.usersapplication.repository.UserRepository
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class UserModule{

    fun provideApplicationContext(application: Application): Context {
        return application
    }

    fun provideApiServiceObject(context: Context): UserApiService {
        /**
         * where to store - place - file
         * how much  : size : MB
         * how long : time
         */
        val cacheSize = 20L * 1024L * 1024L // 20 MB
        val cache = Cache(File(context.cacheDir, "http_cache"), cacheSize)


        val okHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(LoggingInterceptor())
            .addInterceptor(CacheInterceptor())
            .addNetworkInterceptor(CacheInterceptor())
            .build()

//        return Retrofit.Builder()
//            .baseUrl("https://gateway.marvel.com/v1/")
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(UserApiService::class.java)

        return RetrofitInstance.apiClient


    }

    fun provideMarvelRepo():UserApiService {
        val userApiService2 = RetrofitInstance.apiClient
        return userApiService2
    }
}