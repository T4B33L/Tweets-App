package com.example.tweeto1.api

import com.example.tweeto1.model.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header


//It will use retrofit body to create methods that will call endpoints

interface TweetoApi {

    @GET("/v3/b/65a15d1c1f5677401f1bceb1?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<Tweet>>

    /* Static way to get categories
    @GET("/v3/b/65a15d1c1f5677401f1bceb1?meta=false")
    @Headers("X-JSON-Path : tweets..category") //Static header
    suspend fun getCategories():Response<List<String>>
     */

    @GET("/v3/b/65a528e71f5677401f1dee16?meta=false")
    suspend fun getCategories(): Response<List<String>>
}