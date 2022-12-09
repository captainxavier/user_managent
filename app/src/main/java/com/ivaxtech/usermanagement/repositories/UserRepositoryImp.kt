package com.ivaxtech.usermanagement.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.ivaxtech.usermanagement.dao.UserDao
import com.ivaxtech.usermanagement.domain.user.User
import com.ivaxtech.usermanagement.data_sources.remote.UserApi
import javax.inject.Inject


class UserRepositoryImp @Inject constructor(
    private val userApi: UserApi,
    private val appContext:Application,
    private val userDao: UserDao
    ):UserRepository {
    override suspend fun getNewUser(): User {
        val name = userApi.getUsername().results[0].name!!
        val location = userApi.getLocation().results[0].location!!
        val picture = userApi.getPicture().results[0].picture!!
        val user = User(
            name = name.first,
            lastName = name.last,
            city = location.city,
            thumbnail = picture.thumbnail
        )
        userDao.insert(user = user)
        return user
    }

    override suspend fun deleteUser(toDelete: User) = userDao.deleteUser(toDelete)

    override fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers()

}