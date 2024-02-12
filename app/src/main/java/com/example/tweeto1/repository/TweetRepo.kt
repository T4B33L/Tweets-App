package com.example.tweeto1.repository

import com.example.tweeto1.api.TweetoApi
import com.example.tweeto1.model.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

//repostiory is where to get data from api,database or file systems


class TweetRepo @Inject constructor(private val tweetoapi: TweetoApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>>
        get() = _tweets


    suspend fun getCategories(){
        val response = tweetoapi.getCategories()
        if(response.isSuccessful && response.body()!=null){
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category:String){
        val response = tweetoapi.getTweets("tweets[?(@.category==\"$category\")]")
        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }

}