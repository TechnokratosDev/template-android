package com.technokratos.users.di

import com.technokratos.common.data.network.NetworkApiCreator
import com.technokratos.core_db.AppDatabase

interface UserFeatureDependencies {

    fun networkApiCreator(): NetworkApiCreator

    fun db(): AppDatabase
}