package br.com.fiap.easytask.network

import br.com.fiap.easytask.model.Task
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TaskApi {
    @GET("api/tasks")
    fun getTasks(): Call<List<Task>>

    @POST("api/tasks")
    fun createTask(@Body task: Task): Call<Task>

    @GET("api/tasks/{id}")
    fun getTaskById(@Path("id") id: Long): Call<Task>

    @PUT("api/tasks/{id}")
    fun updateTask(@Path("id") id: Long, @Body task: Task): Call<Task>

    @DELETE("api/tasks/{id}")
    fun deleteTask(@Path("id") id: Long): Call<Void>
}

object TaskApiService {
    private const val ENDERECO = "http://10.0.2.2:8080/" // Use localhost para emulador

    private val retrofit = Retrofit.Builder()
        .baseUrl(ENDERECO)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: TaskApi = retrofit.create(TaskApi::class.java)
}
