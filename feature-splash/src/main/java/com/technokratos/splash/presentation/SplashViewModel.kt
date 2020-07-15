package com.technokratos.splash.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.technokratos.common.utils.Event
import com.technokratos.splash.SplashRouter

class SplashViewModel(
    private val router: SplashRouter
) : ViewModel() {

    private val _openUsersEvent = MutableLiveData<Event<Unit>>()
    val openUsersEvent: LiveData<Event<Unit>> = _openUsersEvent

    init {
        _openUsersEvent.value = Event(Unit)
    }

    fun openMain(context: Context) {
        router.openMain(context)
    }
}