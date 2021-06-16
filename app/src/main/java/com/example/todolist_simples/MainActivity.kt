package com.example.todolist_simples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    lateinit var todoText: EditText
    lateinit var addTodoButton: Button
    lateinit var recyclerView: RecyclerView
    lateinit var todoList: ArrayList<Todo>

    // lateinit var layoutManager: StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoList = arrayListOf<Todo>()
        todoText = findViewById(R.id.new_todo_text)

        recyclerView = findViewById(R.id.todoList)
        recyclerView.adapter = TodoListAdapter(todoList())
        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        addTodoButton = findViewById(R.id.new_todo_add_button)
        addTodoButton.setOnClickListener{
            addTodo()
        }

    }

    private fun addTodo() {
        if(todoText.text.toString() == "") {
            Toast.makeText(this, "Insira algum texto!", Toast.LENGTH_SHORT).show()
        } else {
            val todo = Todo(todoText.text.toString())
            todoList.add(todo)

            recyclerView.adapter?.notifyDataSetChanged()
            todoText.setText("")
        }
    }

    private fun todoList(): ArrayList<Todo> {
        return todoList
    }
}