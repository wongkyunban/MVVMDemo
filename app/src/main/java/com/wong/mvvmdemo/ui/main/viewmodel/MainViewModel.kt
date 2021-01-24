package com.wong.mvvmdemo.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wong.mvvmdemo.utils.Resource
import com.wong.mvvmdemo.data.model.User
import com.wong.mvvmdemo.data.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val users = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        users.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { userList -> users.postValue(Resource.success(userList)) },
                    { throwable ->
                        users.postValue(Resource.error("Something went wrong", null))
                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
    fun getUsers():LiveData<Resource<List<User>>>{
        return users
    }
}