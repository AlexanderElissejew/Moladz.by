package com.example.moladzby.utils

import android.view.textclassifier.ConversationActions
import androidx.lifecycle.LiveData

sealed class Resource<T> (
    val data: T? = null,
    val message: String? = null
        ) {
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Error<T>(message: String?) : Resource<T>(message = message)
    class Loading<T> : Resource<T>()
}