package com.example.usersapplication.ui

import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersapplication.data.api.RetrofitInstance
import com.example.usersapplication.model.DataModel
import com.example.usersapplication.model.UserModel
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    private val _userList = MutableLiveData<UserModel>()
    val userList: LiveData<UserModel> = _userList

    init {
        getAllUsers()
    }

    fun getAllUsers(){
        viewModelScope.launch {

            val result = RetrofitInstance.apiClient.getUsers() //this actually makes the api call to the endpoint

            if(result!=null){
                _userList.postValue(result)

            }

//            Log.d("Name Returned from API",result.toString())
        }
    }




}