package com.example.todolist_simples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(private val todoList: ArrayList<Todo>) : Adapter<TodoListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoText: TextView = itemView.findViewById(R.id.todo_text)
        val doneButton: Button = itemView.findViewById(R.id.to_delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo: Todo = todoList[position]
        holder?.let {
            holder.todoText.text = todo.item
            holder.doneButton.setOnClickListener {
                todoList.remove(todo)
                notifyItemRemoved(position)
            }
        }
    }

    override fun getItemCount(): Int = todoList.size

}