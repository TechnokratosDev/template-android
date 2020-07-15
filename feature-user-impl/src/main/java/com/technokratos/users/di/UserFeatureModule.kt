package com.technokratos.users.di

import com.technokratos.common.data.network.NetworkApiCreator
import com.technokratos.common.di.scope.FeatureScope
import com.technokratos.feature_user_api.domain.interfaces.UserInteractor
import com.technokratos.feature_user_api.domain.interfaces.UserRepository
import com.technokratos.users.data.network.UserApi
import com.technokratos.users.data.network.UserApiImpl
import com.technokratos.users.data.repository.UserRepositoryImpl
import com.technokratos.users.domain.UsersInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class UserFeatureModule {

    @Provides
    @FeatureScope
    fun provideUserRepository(userRepository: UserRepositoryImpl): UserRepository = userRepository

    @Provides
    @FeatureScope
    fun provideUserInteractor(userInteractor: UsersInteractorImpl): UserInteractor = userInteractor

    @Provides
    @FeatureScope
    fun provideUserApi(apiCreator: NetworkApiCreator): UserApi {
        return UserApiImpl()
    }
}