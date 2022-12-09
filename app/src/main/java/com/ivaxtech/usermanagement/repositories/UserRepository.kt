package com.ivaxtech.usermanagement.repositories

import androidx.lifecycle.LiveData
import com.ivaxtech.usermanagement.domain.user.User



interface UserRepository {
    suspend fun getNewUser():User
    suspend fun deleteUser(toDelete:User)
    fun getAllUsers():LiveData<List<User>>
}