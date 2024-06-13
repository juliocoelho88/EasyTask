package br.com.fiap.easytask.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.easytask.model.TaskViewModel

@Composable
fun UpdateTaskScreen(navController: NavController, taskId: Long, taskViewModel: TaskViewModel) {
    val task = taskViewModel.tasks.collectAsState().value.find { it.id == taskId }

    if (task != null) {
        var title by remember { mutableStateOf(task.title) }
        var description by remember { mutableStateOf(task.description) }
        var dueDate by remember { mutableStateOf(task.dueDate) }
        var status by remember { mutableStateOf(task.status) }

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
                val updatedTask = task.copy(title = title, description = description, dueDate = dueDate, status = status)
                taskViewModel.updateTask(taskId, updatedTask)
                navController.popBackStack()
            }) {
                Text("Update Task")
            }
        }
    }
}
