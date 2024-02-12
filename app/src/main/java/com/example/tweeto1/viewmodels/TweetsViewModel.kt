package com.example.tweeto1.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweeto1.model.Tweet
import com.example.tweeto1.repository.TweetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(private val tweetrepo: TweetRepo,private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val tweets: StateFlow<List<Tweet>>
        get() = tweetrepo.tweets
    init {
        viewModelScope.launch {
            val category:String = savedStateHandle.get<String>("category") ?: "motivation"
            tweetrepo.getTweets(category)
        }
    }

}