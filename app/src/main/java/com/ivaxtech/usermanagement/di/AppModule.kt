package com.ivaxtech.usermanagement.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ivaxtech.usermanagement.dao.UserDao
import com.ivaxtech.usermanagement.data_sources.local.LocalDatabaseSource
import com.ivaxtech.usermanagement.data_sources.remote.UserApi
import com.ivaxtech.usermanagement.repositories.UserRepository
import com.ivaxtech.usermanagement.repositories.UserRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://randomuser.me/api/"


    @Provides
    @Singleton
    fun provideApiCall(@Named("BaseUrl") baseUrl: String): UserApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMyRepository(api: UserApi, application: Application,userDao: UserDao):UserRepository{
        return UserRepositoryImp(api,application,userDao);
    }

    @Provides
    @Singleton
    fun providesLocalDatabase(@ApplicationContext context: Context):LocalDatabaseSource{
        return Room.databaseBuilder(context,LocalDatabaseSource::class.java,"user_database")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun userDao(localDatabaseSource: LocalDatabaseSource):UserDao = localDatabaseSource.userDao()
}