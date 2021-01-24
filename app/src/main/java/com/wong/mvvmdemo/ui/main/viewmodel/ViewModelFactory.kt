package com.wong.mvvmdemo.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wong.mvvmdemo.data.repository.MainRepository
import com.wong.mvvmdemo.data.api.ApiHelper
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper:ApiHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}