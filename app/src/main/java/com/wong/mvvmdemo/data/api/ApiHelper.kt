package com.wong.mvvmdemo.data.api

class ApiHelper(private val apiService:ApiService) {
    fun getUsers() = apiService.getUsers()
}