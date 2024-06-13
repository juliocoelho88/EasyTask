package br.com.fiap.easytask.ui

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
import androidx.navigation.NavController
import br.com.fiap.easytask.model.Task
import br.com.fiap.easytask.model.TaskViewModel

@Composable
fun AddTaskScreen(navController: NavController, taskViewModel: TaskViewModel) {
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
            taskViewModel.createTask(newTask)
            navController.popBackStack()
        }) {
            Text("Add Task")
        }
    }
}
