package com.ivaxtech.usermanagement.data_sources.remote

import com.ivaxtech.usermanagement.domain.user.UserResponse
import retrofit2.http.GET

interface UserApi {

    @GET("?inc=name")
    suspend fun getUsername():UserResponse
    @GET("?inc=picture")
    suspend fun getPicture():UserResponse
    @GET("?inc=location")
    suspend fun getLocation():UserResponse
}