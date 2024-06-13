package br.com.fiap.easytask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.easytask.model.TaskViewModel
import br.com.fiap.easytask.ui.AddTaskScreen
import br.com.fiap.easytask.ui.TaskListScreen
import br.com.fiap.easytask.ui.UpdateTaskScreen

class MainActivity : ComponentActivity() {
    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "taskList") {
                composable("taskList") {
                    TaskListScreen(taskViewModel = taskViewModel, navController = navController)
                }
                composable("addTask") {
                    AddTaskScreen(navController = navController, taskViewModel = taskViewModel)
                }
                composable("updateTask/{taskId}") { backStackEntry ->
                    val taskId = backStackEntry.arguments?.getString("taskId")?.toLong() ?: -1L
                    UpdateTaskScreen(navController = navController, taskId = taskId, taskViewModel = taskViewModel)
                }
            }
        }
        taskViewModel.fetchTasks()
    }
}
