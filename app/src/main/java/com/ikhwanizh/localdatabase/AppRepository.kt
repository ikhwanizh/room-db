package com.ikhwanizh.localdatabase

import com.ikhwanizh.localdatabase.data.local.AppDatabase
import com.ikhwanizh.localdatabase.data.local.UserEntity

class AppRepository(private val appDatabase: AppDatabase) {
    suspend fun insertUser(userEntity: UserEntity){
        appDatabase.userDao().insertUser(userEntity)
    }
//    suspend fun getUsers(){
//        appDatabase.userDao().getUsers()
//    }
}