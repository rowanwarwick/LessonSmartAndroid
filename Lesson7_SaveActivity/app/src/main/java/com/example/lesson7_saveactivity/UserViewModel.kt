package com.example.lesson7_saveactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    var userList : MutableLiveData<List<User>> = MutableLiveData()

    //инициализируем список и заполняем его данными пользователей
    init {
        userList.value = Users.getUsers()
    }

    fun getListUsers() = userList

    //для обновления списка передаем второй список пользователей
    fun updateListUsers() {
        userList.value = Users.getAnotherUsers()
    }
}