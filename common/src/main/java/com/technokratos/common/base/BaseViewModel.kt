package com.technokratos.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.technokratos.common.utils.Event
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    private val _errorLiveData = MutableLiveData<Event<String>>()
    val errorLiveData: LiveData<Event<String>> = _errorLiveData

    private val _errorFromResourceLiveData = MutableLiveData<Event<Int>>()
    val errorFromResourceLiveData: LiveData<Event<Int>> = _errorFromResourceLiveData

    private val _errorWithTitleLiveData = MutableLiveData<Event<Pair<String, String>>>()
    val errorWithTitleLiveData: LiveData<Event<Pair<String, String>>> = _errorWithTitleLiveData

    protected val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        if (!disposables.isDisposed) disposables.dispose()
    }
}