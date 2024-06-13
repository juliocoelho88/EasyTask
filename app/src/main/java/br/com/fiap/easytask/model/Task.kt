package br.com.fiap.easytask.model


data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val dueDate: String,
    val status: String
)
