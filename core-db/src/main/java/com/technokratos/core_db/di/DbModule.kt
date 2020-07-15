package com.technokratos.core_db.di

import android.content.Context
import com.technokratos.common.di.scope.ApplicationScope
import com.technokratos.core_db.AppDatabase
import com.technokratos.core_db.dao.UserDao
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    @ApplicationScope
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.get(context)
    }

    @Provides
    @ApplicationScope
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}