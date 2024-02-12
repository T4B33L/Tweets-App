package com.example.tweeto1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweeto1.repository.TweetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val tweetrepo: TweetRepo) : ViewModel() {

    val categories: StateFlow<List<String>>
        get() = tweetrepo.categories
    init {
        viewModelScope.launch {
            tweetrepo.getCategories()
        }
    }
}