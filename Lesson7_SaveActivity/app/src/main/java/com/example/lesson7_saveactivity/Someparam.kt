package com.example.lesson7_saveactivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Someparam : AppCompatActivity() {
    private val userViewModel by lazy { ViewModelProvider(this).get(UserViewModel::class.java)}
    lateinit var userList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_someparam)
        //инициализируем адаптер и присваиваем его списку
        userList = findViewById(R.id.userList)
        val adapter = UserAdapter()
        userList.layoutManager = LinearLayoutManager(this)
        userList.adapter = adapter

        //подписываем адаптер на изменения списка
        userViewModel.getListUsers().observe(this, Observer {
            it?.let {
                adapter.refreshUsers(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //при нажатии пункта меню Refresh обновляем список
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.refresh -> {
                userViewModel.updateListUsers()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}