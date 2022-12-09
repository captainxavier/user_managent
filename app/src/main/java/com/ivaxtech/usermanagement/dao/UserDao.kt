package com.ivaxtech.usermanagement.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ivaxtech.usermanagement.domain.user.User


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query(value = "SELECT * FROM user ORDER BY id DESC")
    fun getAllUsers():LiveData<List<User>>


    @Delete
    fun deleteUser(user: User)
}