package com.technokratos.app.di.app

import com.technokratos.app.navigation.Navigator
import com.technokratos.common.di.scope.ApplicationScope
import com.technokratos.splash.SplashRouter
import com.technokratos.users.UsersRouter
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideMainRouter(navigator: Navigator): UsersRouter = navigator

    @ApplicationScope
    @Provides
    fun provideSplashRouter(navigator: Navigator): SplashRouter = navigator
}