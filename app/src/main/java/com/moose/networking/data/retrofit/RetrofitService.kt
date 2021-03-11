package com.moose.networking.data.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitService {
    private val url = "https://jsonplaceholder.typicode.com/"

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private val retrofit = Retrofit.Builder().baseUrl(url).client(client).build()

    fun getApi(): ApiEndpoints = retrofit.create(ApiEndpoints::class.java)
}