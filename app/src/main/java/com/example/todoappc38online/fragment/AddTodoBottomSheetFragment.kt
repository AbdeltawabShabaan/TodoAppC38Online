package com.example.todoappc38online.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.todoappc38online.R
import com.example.todoappc38online.database.TodoDatabase
import com.example.todoappc38online.database.model.TodoModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Calendar

class AddTodoBottomSheetFragment:BottomSheetDialogFragment() {
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var timeTextView:TextView
    private lateinit var timeValueTextView: TextView
    private lateinit var addTodoButton: Button
    private lateinit var calendar: Calendar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_todo_bottom_sheet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView(){
        calendar= Calendar.getInstance()
        titleEditText=requireView().findViewById(R.id.title_edit_text)
        descriptionEditText=requireView().findViewById(R.id.description_edit_text)
        timeTextView=requireView().findViewById(R.id.select_time_text)
        timeValueTextView=requireView().findViewById(R.id.select_time_value)
        addTodoButton=requireView().findViewById(R.id.add_todo_btn)
        timeValueTextView.text="${calendar.get(Calendar.DAY_OF_MONTH)} / ${calendar.get(Calendar.MONTH) +1} / ${calendar.get(Calendar.YEAR)}"
        timeValueTextView.setOnClickListener {
            showDatePicker()
        }
        addTodoButton.setOnClickListener {
            addTodoToDatabase()
        }
    }
    private fun showDatePicker(){
        val datePicker=DatePickerDialog(requireContext())
        datePicker.show()
        datePicker.setOnDateSetListener { view, year, month, dayOfMonth ->
            timeValueTextView.text="$dayOfMonth / ${month +1} / $year"
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
        }
    }

    private fun validateFields():Boolean{
        if (titleEditText.text.toString().isEmpty() || titleEditText.text.toString().isBlank()){
            titleEditText.error="require text"
        }else{
            titleEditText.error=null
        }
        if (descriptionEditText.text.toString().isEmpty()||descriptionEditText.text.toString().isBlank()){
            descriptionEditText.error="description require"
        }else{
            descriptionEditText.error=null
        }
        return true
    }

    private fun addTodoToDatabase(){
        if (validateFields()){
            val title=titleEditText.text.toString()
            val description=descriptionEditText.text.toString()
            TodoDatabase
                .getInstance(requireContext())
                .getDao()
                .insertTodo(
                    TodoModel(
                        title=title, description = description, isDone = false, time = calendar.time,
                    )
                )
        }
        dismiss()
    }
}