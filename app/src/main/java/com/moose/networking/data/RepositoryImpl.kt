package com.moose.networking.data

import com.moose.networking.domain.Post

interface Repository {
    suspend fun getPost(id: Int): Post

    suspend fun createPost(post: Post): Post
}

class RepositoryImpl: Repository {

    private val retrofit = RetrofitService.getApi()

    override suspend fun getPost(id: Int) = retrofit.getPost(id)

    override suspend fun createPost(post: Post) = retrofit.addPost(post)
}