package com.wong.mvvmdemo.data.repository

import com.wong.mvvmdemo.data.model.User
import com.wong.mvvmdemo.data.api.ApiHelper
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {
    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }
}