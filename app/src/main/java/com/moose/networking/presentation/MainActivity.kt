package com.moose.networking.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.moose.networking.databinding.ActivityMainBinding
import com.moose.networking.domain.Post

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Get one post using random id
        binding.getBtn.setOnClickListener {
            val id: Int = (0..100).random()
            viewModel.getPost(id)
        }

        // Post one object
        binding.postBtn.setOnClickListener {
            val post = Post(id = 1, body = "Kotlin is awesome!", title = "Kotlin", userId = 1)
            viewModel.addPost(post)
        }

        viewModel.data.observe(this, {
            binding.data.text = it.toString()
        })

        viewModel.error.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        setContentView(binding.root)
    }
}