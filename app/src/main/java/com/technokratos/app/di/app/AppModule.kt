package com.technokratos.app.di.app

import android.content.Context
import com.technokratos.app.App
import com.technokratos.common.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @ApplicationScope
    @Provides
    fun provideContext(application: App): Context {
        return application
    }
}