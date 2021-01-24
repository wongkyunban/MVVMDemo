package com.wong.mvvmdemo.data.api

import com.wong.mvvmdemo.data.model.User
import io.reactivex.Single

interface ApiService {
    fun getUsers():Single<List<User>>
}