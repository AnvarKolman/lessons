package com.oder.lesson5.viewmodel

import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel() {

    private val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getMessage(): LiveData<String> {
        return message
    }

    fun setMessage(@Nullable message: String?) {
        this.message.value = message ?: ""
    }
}