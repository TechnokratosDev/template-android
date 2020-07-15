package com.technokratos.users.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.technokratos.common.base.BaseViewModel
import com.technokratos.feature_user_api.domain.interfaces.UserInteractor
import com.technokratos.feature_user_api.domain.model.User
import com.technokratos.users.UsersRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersViewModel(
    private val interactor: UserInteractor,
    private val router: UsersRouter
) : BaseViewModel() {

    private val _usersLiveData = MutableLiveData<List<User>>()
    val usersLiveData: LiveData<List<User>> = _usersLiveData

    fun userClicked(user: User) {
        router.openUser(user.id)
    }

    fun getUsers() {
        disposables.add(
            interactor.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe({
                    _usersLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}