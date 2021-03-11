package com.moose.networking.data.retrofit

import com.moose.networking.domain.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiEndpoints {

    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Post

    @POST("/posts")
    suspend fun addPost(@Body post: Post): Post
}