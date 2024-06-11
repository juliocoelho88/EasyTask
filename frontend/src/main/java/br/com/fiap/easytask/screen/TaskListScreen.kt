package br.com.fiap.easytask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import br.com.fiap.easytask.model.TaskViewModel

@Composable
fun TaskListScreen(taskViewModel: TaskViewModel, navController: NavController) {
    val tasks by taskViewModel.tasks.collectAsState()

    LaunchedEffect(Unit) {
        taskViewModel.fetchTasks()
    }

    Column {
        Button(onClick = { navController.navigate("addTask") }) {
            Text("Add New Task")
        }
        LazyColumn {
            items(tasks) { task ->
                TaskItem(task)
            }
        }
    }
}
