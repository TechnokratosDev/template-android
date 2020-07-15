package com.technokratos.app.di.app

import com.technokratos.app.App
import com.technokratos.app.di.deps.ComponentDependenciesModule
import com.technokratos.app.di.deps.ComponentHolderModule
import com.technokratos.app.di.main.MainDependencies
import com.technokratos.common.di.CommonApi
import com.technokratos.common.di.modules.CommonModule
import com.technokratos.common.di.modules.NetworkModule
import com.technokratos.common.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class,
        NavigationModule::class,
        ComponentHolderModule::class,
        ComponentDependenciesModule::class,
        FeatureManagerModule::class
    ]
)
interface AppComponent : MainDependencies, CommonApi {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}