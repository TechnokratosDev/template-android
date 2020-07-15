package com.technokratos.feature_user_api.di

import com.technokratos.feature_user_api.domain.interfaces.UserInteractor
import com.technokratos.feature_user_api.domain.interfaces.UserRepository

interface UserFeatureApi {

    fun provideUserRepository(): UserRepository

    fun provideUserInteractor(): UserInteractor
}