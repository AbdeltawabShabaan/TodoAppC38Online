package com.example.todoappc38online.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.todoappc38online.database.dao.TodoDao
import com.example.todoappc38online.database.model.TodoModel

@Database(entities =[TodoModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase:RoomDatabase() {
    abstract fun getDao():TodoDao
    companion object{

        private var todoDataInstance:TodoDatabase?=null
        fun getInstance(context:Context):TodoDatabase{
            if (todoDataInstance==null)
                todoDataInstance=Room.databaseBuilder(context.applicationContext,TodoDatabase::class.java,"todo app")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
        return todoDataInstance!!
        }
    }
}