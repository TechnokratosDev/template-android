package com.technokratos.app.di.app

import com.technokratos.app.di.deps.FeatureHolderManager
import com.technokratos.common.di.FeatureApiHolder
import com.technokratos.common.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class FeatureManagerModule {

    @ApplicationScope
    @Provides
    fun provideFeatureHolderManager(featureApiHolderMap: @JvmSuppressWildcards Map<Class<*>, FeatureApiHolder>): FeatureHolderManager {
        return FeatureHolderManager(featureApiHolderMap)
    }
}