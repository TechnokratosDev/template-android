package com.technokratos.app

import android.app.Application
import com.technokratos.app.di.app.AppComponent
import com.technokratos.app.di.app.DaggerAppComponent
import com.technokratos.app.di.deps.ComponentDependenciesProvider
import com.technokratos.app.di.deps.FeatureHolderManager
import com.technokratos.app.di.deps.HasComponentDependencies
import com.technokratos.common.di.CommonApi
import com.technokratos.common.di.FeatureContainer
import javax.inject.Inject

open class App : Application(), FeatureContainer, HasComponentDependencies {

    @Inject lateinit var featureHolderManager: FeatureHolderManager

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider
        protected set

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }

    override fun <T> getFeature(key: Class<*>): T {
        return featureHolderManager.getFeature<T>(key)!!
    }

    override fun releaseFeature(key: Class<*>) {
        featureHolderManager.releaseFeature(key)
    }

    override fun commonApi(): CommonApi {
        return appComponent
    }
}