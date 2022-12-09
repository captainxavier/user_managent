package com.ivaxtech.usermanagement.data_sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ivaxtech.usermanagement.dao.UserDao
import com.ivaxtech.usermanagement.domain.user.User

@Database(entities = [User::class], version = 1)
abstract class LocalDatabaseSource:RoomDatabase() {

    abstract fun userDao():UserDao
}