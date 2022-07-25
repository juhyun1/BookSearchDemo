package com.booksearch.feature.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _done = mutableStateOf(false)
    val done get() = _done

    init {
        splashDone()
    }

    private fun splashDone() {
        viewModelScope.launch {
            delay(2_000L)
            _done.value = true
        }
    }
}