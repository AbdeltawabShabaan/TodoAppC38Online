package com.example.todoappc38online.todoListAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoappc38online.R
import com.example.todoappc38online.database.model.TodoModel

class TodoListAdapter (private var todoList: List<TodoModel>?=null):Adapter<TodoListAdapter.TodoListViewHolder>(){
    class TodoListViewHolder( view:View):ViewHolder(view){
        val titleText:TextView=view.findViewById(R.id.todo_title_text)
        val timeTextView:TextView=view.findViewById(R.id.todo_time_text)
        val imageCheck: ImageView =view.findViewById(R.id.ic_check)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
        return TodoListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList?.size?:0
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(todoList: List<TodoModel>?){
        this.todoList=todoList
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        val item=todoList?.get(position)
        holder.titleText.text=item?.title
        holder.timeTextView.text=item?.time.toString()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(todoLists: List<TodoModel>?){
        todoList=todoLists
        notifyDataSetChanged()
    }
}