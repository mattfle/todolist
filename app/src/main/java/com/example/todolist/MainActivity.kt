package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter :TodoAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lst = mutableListOf<Todo>()
        todoAdapter = TodoAdaptor(lst)
        //new comment
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener {
            val todoTitle = etToDoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etToDoTitle.text.clear()
            }
        }

        btnDeleteDoneToDo.setOnClickListener{
            todoAdapter.deleteDoneTodos()
        }

    }
}