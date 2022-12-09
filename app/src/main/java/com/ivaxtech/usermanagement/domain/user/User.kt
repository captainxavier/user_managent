package com.ivaxtech.usermanagement.domain.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "last_name")
    val lastName:String,
    @ColumnInfo(name = "city")
    val city:String,
    @ColumnInfo(name = "thumbnail")
    val thumbnail:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0)
