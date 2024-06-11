package br.com.fiap.easytask

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.easytask.model.Task
import br.com.fiap.easytask.model.TaskViewModel

@Composable
fun AddTaskScreen(taskViewModel: TaskViewModel, onTaskAdded: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        TextField(
            value = dueDate,
            onValueChange = { dueDate = it },
            label = { Text("Due Date") }
        )
        TextField(
            value = status,
            onValueChange = { status = it },
            label = { Text("Status") }
        )
        Button(onClick = {
            val newTask = Task(0, title, description, dueDate, status)
            Log.d("AddTaskScreen", "Creating task with title: $title")
            taskViewModel.createTask(newTask)
            onTaskAdded()
        }) {
            Text("Add Task")
        }
    }
}
