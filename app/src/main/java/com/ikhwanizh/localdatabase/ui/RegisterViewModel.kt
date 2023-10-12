package com.ikhwanizh.localdatabase.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ikhwanizh.localdatabase.AppRepository
import com.ikhwanizh.localdatabase.data.local.AppDatabase
import com.ikhwanizh.localdatabase.data.local.UserEntity

class RegisterViewModel(application: Application): AndroidViewModel(application) {
    private val repository: AppRepository
    private val appDatabase: AppDatabase

    init {
        appDatabase = AppDatabase.getInstance(application)!!
        repository = AppRepository(appDatabase)
    }

    suspend fun insertUser(userEntity: UserEntity){
        repository.insertUser(userEntity)
    }
}