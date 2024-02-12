package com.example.tweeto1.dI

import com.example.tweeto1.api.TweetoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//DI is used to create retrofit object using hilt

@Module
@InstallIn(SingletonComponent::class)//for a single retrofit object in whole application
class NetworkModule {
    @Singleton
    @Provides
    fun providesretrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesTweetoApi(retrofit: Retrofit):TweetoApi{
        return retrofit.create(TweetoApi::class.java)
    }
}