package com.example.apirest.Utils;

import com.example.apirest.Model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TaskService {

    @GET("liste")
    Call<List<Task>> getTasks();
    //Call<List<Task>> getTasks();

    @POST("add")
    Call<Task> addTask(@Body Task task);
    //Call<Task>addTask(@Body Task task);

    @POST("update/{id}")
    Call<Task> updateTask(@Body Task task, @Path("id") int id);
    //Call<Task>updateTask(@Body Task task, @Path("id") int id);

    @POST("delete/{id}")
    Call<Task> deleteTask(@Path("id")int id);
    //Call<Task>deleteTask(@Path("id")int id);

}
