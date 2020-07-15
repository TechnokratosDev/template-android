package com.technokratos.users.presentation.details.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.technokratos.common.di.viewmodel.ViewModelKey
import com.technokratos.common.di.viewmodel.ViewModelModule
import com.technokratos.feature_user_api.domain.interfaces.UserInteractor
import com.technokratos.users.UsersRouter
import com.technokratos.users.presentation.details.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class UserModule {

    @Provides
    fun provideMainViewModel(fragment: Fragment, factory: ViewModelProvider.Factory): UserViewModel {
        return ViewModelProviders.of(fragment, factory).get(UserViewModel::class.java)
    }

    @Provides
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun provideSignInViewModel(interactor: UserInteractor, userId: Int, router: UsersRouter): ViewModel {
        return UserViewModel(interactor, userId, router)
    }
}