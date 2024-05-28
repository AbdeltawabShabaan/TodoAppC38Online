package com.example.todoappc38online.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.todoappc38online.R
import com.example.todoappc38online.todoListAdapter.TodoListAdapter
import com.example.todoappc38online.database.TodoDatabase

class TodoListFragment:Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TodoListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.todo_list_recyclerView)
        val todoList=TodoDatabase.getInstance(requireActivity().applicationContext).getDao().getAll()
        adapter= TodoListAdapter(todoList)
        recyclerView.adapter=adapter
        val item=TodoDatabase.getInstance(requireContext()).getDao().getAll()
        adapter.refreshData(item)
    }
}