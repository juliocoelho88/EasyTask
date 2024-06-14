package br.com.fiap.easytask.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
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

        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") }
            )
            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descrição") }
            )
            TextField(
                value = dueDate,
                onValueChange = { dueDate = it },
                label = { Text("Data") }
            )
            TextField(
                value = status,
                onValueChange = { status = it },
                label = { Text("Status") }
            )
            Button(
                onClick = {
                    val updatedTask = task.copy(title = title, description = description, dueDate = dueDate, status = status)
                    taskViewModel.updateTask(taskId, updatedTask)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Atualizar Tarefa")
            }
        }
    }
}
