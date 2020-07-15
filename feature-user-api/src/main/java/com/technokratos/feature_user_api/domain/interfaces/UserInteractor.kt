package com.technokratos.feature_user_api.domain.interfaces

import com.technokratos.feature_user_api.domain.model.User
import io.reactivex.Observable

interface UserInteractor {

    fun getUser(id: Int): Observable<User>

    fun getUsers(): Observable<List<User>>
}