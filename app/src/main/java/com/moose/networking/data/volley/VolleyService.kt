package com.moose.networking.data.volley

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleyService(context: Context) {

    companion object {
        @Volatile
        private var instance: VolleyService? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: VolleyService(context).also { instance = it }
            }
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToQueue(request: Request<T>){
        requestQueue.add(request)
    }
}