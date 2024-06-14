package br.com.fiap.easytask

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.easytask.model.Task
import br.com.fiap.easytask.model.TaskViewModel

@Composable
fun TaskItem(task: Task, navController: NavController, taskViewModel: TaskViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate("updateTask/${task.id}") },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = task.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = task.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Due: ${task.dueDate}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Status: ${task.status}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                IconButton(onClick = { navController.navigate("updateTask/${task.id}") }) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar Tarefa")
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = { taskViewModel.deleteTask(task.id) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Excluir Tarefa")
                }
            }
        }
    }
}
