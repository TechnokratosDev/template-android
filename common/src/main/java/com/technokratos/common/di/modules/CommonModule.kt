package com.technokratos.common.di.modules

import android.content.Context
import com.technokratos.common.di.scope.ApplicationScope
import com.technokratos.common.resources.ResourceManager
import com.technokratos.common.resources.ResourceManagerImpl
import dagger.Module
import dagger.Provides

@Module
class CommonModule {

    @Provides
    @ApplicationScope
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManagerImpl(context)
    }
}