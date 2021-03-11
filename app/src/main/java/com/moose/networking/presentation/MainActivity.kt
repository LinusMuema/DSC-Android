package com.moose.networking.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.moose.networking.databinding.ActivityMainBinding
import com.moose.networking.domain.Post

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Get one post using random id
        val id: Int = (0..100).random()
        viewModel.getPost(id)

        // Post one object
        val post = Post(id = 1, body = "Kotlin is awesome!", title = "Kotlin", userId = 1)
        viewModel.addPost(post)

        viewModel.data.observe(this, {
            Log.d("Networking", "onCreate: $it")
            // TODO: add a recyclerview
        })

        viewModel.error.observe(this, {
            Log.e("Networking", "onCreate: $it")
            // TODO: add a recyclerview
        })

        setContentView(binding.root)
    }
}