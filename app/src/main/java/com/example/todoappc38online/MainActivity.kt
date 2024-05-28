package com.example.todoappc38online

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todoappc38online.database.TodoDatabase
import com.example.todoappc38online.fragment.AddTodoBottomSheetFragment
import com.example.todoappc38online.fragment.TodoListFragment
import com.example.todoappc38online.fragment.TodoSettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnNavView:BottomNavigationView
    private lateinit var addTodoButton:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNavView=findViewById(R.id.bottom_navigation_view)
        btnNavView.menu.getItem(1).isEnabled=false
        initView()
    }
    private fun initView(){


        btnNavView.setOnItemSelectedListener {
            if (it.itemId==R.id.navigation_list){
                pushFragment(TodoListFragment())
            }else if (it.itemId==R.id.navigation_setting){
                pushFragment(TodoSettingFragment())
            }
            return@setOnItemSelectedListener true
        }
        btnNavView.selectedItemId=R.id.navigation_list
        addTodoButton=findViewById(R.id.add_todo_button)
        addTodoButton.setOnClickListener {
            val bottomSheetFragment=AddTodoBottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager,"add_todo")
        }
    }
    private fun pushFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }
}