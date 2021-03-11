package com.moose.networking.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moose.networking.data.RepositoryImpl
import com.moose.networking.domain.Post
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = RepositoryImpl()

    private val _data = MutableLiveData<Post>()
    val data: LiveData<Post> = _data

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    fun getPost(id: Int){
        viewModelScope.launch {
            try {
                val post = repository.getPost(id)
                _data.postValue(post)
            } catch (e: Throwable){
                _error.postValue(e.message)
            }
        }
    }


    fun addPost(post: Post){
        viewModelScope.launch {
            try {
                val data = repository.createPost(post)
                _data.postValue(data)
            } catch (e: Throwable){
                _error.postValue(e.message)
            }
        }
    }
}