package com.technokratos.splash.di

import com.technokratos.common.di.CommonApi
import com.technokratos.common.di.scope.FeatureScope
import com.technokratos.splash.SplashRouter
import com.technokratos.splash.presentation.di.SplashComponent
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        SplashFeatureDependencies::class
    ],
    modules = [
        SplashFeatureModule::class
    ]
)
@FeatureScope
interface SplashFeatureComponent : SplashFeatureApi {

    fun splashComponentFactory(): SplashComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun router(splashRouter: SplashRouter): Builder

        fun withDependencies(deps: SplashFeatureDependencies): Builder

        fun build(): SplashFeatureComponent
    }

    @Component(
        dependencies = [
            CommonApi::class
        ]
    )
    interface SplashFeatureDependenciesComponent : SplashFeatureDependencies
}