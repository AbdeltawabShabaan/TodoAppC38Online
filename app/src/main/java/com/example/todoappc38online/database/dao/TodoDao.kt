package com.example.todoappc38online.database.dao

import androidx.annotation.RequiresPermission
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoappc38online.database.model.TodoModel

@Dao
interface TodoDao {
    @Insert
    fun insertTodo(todoModel: TodoModel)
    @Update
    fun updateTodo(todoModel: TodoModel)
    @Delete
    fun deleteTodo(todoModel: TodoModel)
    @Query("SELECT * FROM TodoTable")
    fun getAll(): List<TodoModel>
}