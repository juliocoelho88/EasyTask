package br.com.fiap.easytask.repository

import br.com.fiap.easytask.model.Task
import br.com.fiap.easytask.network.TaskApiService

class TaskRepository {
    private val apiService = TaskApiService.api

    fun getTasks(): retrofit2.Call<List<Task>> = apiService.getTasks()

    fun createTask(task: Task): retrofit2.Call<Task> = apiService.createTask(task)

    fun getTaskById(id: Long): retrofit2.Call<Task> = apiService.getTaskById(id)

    fun updateTask(id: Long, task: Task): retrofit2.Call<Task> = apiService.updateTask(id, task)

    fun deleteTask(id: Long): retrofit2.Call<Void> = apiService.deleteTask(id)
}
