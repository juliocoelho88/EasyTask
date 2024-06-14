package br.com.fiap.easytask.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
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
                val newTask = Task(0, title, description, dueDate, status)
                taskViewModel.createTask(newTask)
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Tarefa")
        }
    }
}
