package br.com.fiap.easytask

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.easytask.model.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskApp(taskViewModel: TaskViewModel) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Task Manager") },
                colors = TopAppBarDefaults.mediumTopAppBarColors()
            )
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = "taskList", Modifier.padding(innerPadding)) {
            composable("taskList") {
                TaskListScreen(taskViewModel, navController)
            }
            composable("addTask") {
                AddTaskScreen(taskViewModel) {
                    navController.popBackStack()
                }
            }
            // Further routes can be added here
        }
    }
}
