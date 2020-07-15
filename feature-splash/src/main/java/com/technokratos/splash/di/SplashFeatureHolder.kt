package com.technokratos.splash.di

import com.technokratos.common.di.FeatureApiHolder
import com.technokratos.common.di.FeatureContainer
import com.technokratos.common.di.scope.ApplicationScope
import com.technokratos.splash.SplashRouter
import javax.inject.Inject

@ApplicationScope
class SplashFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val splashRouter: SplashRouter
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        val splashFeatureDependencies = DaggerSplashFeatureComponent_SplashFeatureDependenciesComponent.builder()
            .commonApi(commonApi())
            .build()
        return DaggerSplashFeatureComponent.builder()
            .withDependencies(splashFeatureDependencies)
            .router(splashRouter)
            .build()
    }
}