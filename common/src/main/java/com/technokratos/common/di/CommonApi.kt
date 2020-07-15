package com.technokratos.common.di

import android.content.Context
import com.technokratos.common.data.network.NetworkApiCreator
import com.technokratos.common.resources.ResourceManager

interface CommonApi {

    fun context(): Context

    fun provideResourceManager(): ResourceManager

    fun provideNetworkApiCreator(): NetworkApiCreator
}