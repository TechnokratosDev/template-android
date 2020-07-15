package com.technokratos.users.presentation.list.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.technokratos.common.di.viewmodel.ViewModelKey
import com.technokratos.common.di.viewmodel.ViewModelModule
import com.technokratos.feature_user_api.domain.interfaces.UserInteractor
import com.technokratos.users.UsersRouter
import com.technokratos.users.presentation.list.UsersViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class UsersModule {

    @Provides
    fun provideMainViewModel(fragment: Fragment, factory: ViewModelProvider.Factory): UsersViewModel {
        return ViewModelProviders.of(fragment, factory).get(UsersViewModel::class.java)
    }

    @Provides
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    fun provideSignInViewModel(interactor: UserInteractor, router: UsersRouter): ViewModel {
        return UsersViewModel(interactor, router)
    }
}