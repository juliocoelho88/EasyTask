package br.com.fiap.easytask.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.easytask.network.TaskApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks

    fun fetchTasks() {
        viewModelScope.launch {
            TaskApiService.api.getTasks().enqueue(object : Callback<List<Task>> {
                override fun onResponse(call: Call<List<Task>>, response: Response<List<Task>>) {
                    if (response.isSuccessful) {
                        Log.d("TaskViewModel", "Tasks fetched successfully")
                        _tasks.value = response.body() ?: emptyList()
                    } else {
                        Log.e("TaskViewModel", "Failed to fetch tasks: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<List<Task>>, t: Throwable) {
                    Log.e("TaskViewModel", "Error fetching tasks", t)
                }
            })
        }
    }

    fun createTask(task: Task) {
        viewModelScope.launch {
            Log.d("TaskViewModel", "Creating task with title: ${task.title}")
            TaskApiService.api.createTask(task).enqueue(object : Callback<Task> {
                override fun onResponse(call: Call<Task>, response: Response<Task>) {
                    if (response.isSuccessful) {
                        Log.d("TaskViewModel", "Task created successfully with ID: ${response.body()?.id}")
                        fetchTasks() // Atualiza a lista de tarefas após criar uma nova
                    } else {
                        Log.e("TaskViewModel", "Failed to create task: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Task>, t: Throwable) {
                    Log.e("TaskViewModel", "Error creating task", t)
                }
            })
        }
    }

    fun updateTask(id: Long, task: Task) {
        viewModelScope.launch {
            Log.d("TaskViewModel", "Updating task with ID: $id")
            TaskApiService.api.updateTask(id, task).enqueue(object : Callback<Task> {
                override fun onResponse(call: Call<Task>, response: Response<Task>) {
                    if (response.isSuccessful) {
                        Log.d("TaskViewModel", "Task updated successfully with ID: ${response.body()?.id}")
                        fetchTasks() // Atualiza a lista de tarefas após atualizar uma tarefa
                    } else {
                        Log.e("TaskViewModel", "Failed to update task: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Task>, t: Throwable) {
                    Log.e("TaskViewModel", "Error updating task", t)
                }
            })
        }
    }

    fun deleteTask(id: Long) {
        viewModelScope.launch {
            Log.d("TaskViewModel", "Deleting task with ID: $id")
            TaskApiService.api.deleteTask(id).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Log.d("TaskViewModel", "Task deleted successfully")
                        fetchTasks() // Atualiza a lista de tarefas após deletar uma tarefa
                    } else {
                        Log.e("TaskViewModel", "Failed to delete task: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.e("TaskViewModel", "Error deleting task", t)
                }
            })
        }
    }
}
