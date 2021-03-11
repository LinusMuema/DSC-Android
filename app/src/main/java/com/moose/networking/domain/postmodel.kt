package com.moose.networking.domain

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)