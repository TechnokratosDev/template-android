package com.technokratos.users.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.technokratos.common.base.BaseViewModel
import com.technokratos.feature_user_api.domain.interfaces.UserInteractor
import com.technokratos.feature_user_api.domain.model.User
import com.technokratos.users.UsersRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserViewModel(
    private val interactor: UserInteractor,
    private val userId: Int,
    private val router: UsersRouter
) : BaseViewModel() {

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    init {
        disposables.add(
            interactor.getUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe({
                    _userLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    fun backClicked() {
        router.returnToUsers()
    }
}