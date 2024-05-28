package com.example.todoappc38online.database.model

import android.provider.ContactsContract.RawContacts.Data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity("TodoTable")
data class TodoModel(
    @ColumnInfo("ID")
    @PrimaryKey
    val id:Int?=null,
    @ColumnInfo
    val title:String?=null,
    @ColumnInfo
    val description:String?=null,
    @ColumnInfo
    val isDone:Boolean?=false,
    @ColumnInfo
    val time:Date?=null
)